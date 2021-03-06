/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.informationview.lookup;


import org.odpi.openmetadata.accessservices.informationview.contentmanager.OMEntityDao;
import org.odpi.openmetadata.accessservices.informationview.events.Source;
import org.odpi.openmetadata.accessservices.informationview.ffdc.InformationViewErrorCode;
import org.odpi.openmetadata.accessservices.informationview.utils.Constants;
import org.odpi.openmetadata.repositoryservices.auditlog.OMRSAuditLog;
import org.odpi.openmetadata.repositoryservices.auditlog.OMRSAuditLogRecordSeverity;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.MatchCriteria;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.SequencingOrder;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.*;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDef;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryConnector;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.EntityNotKnownException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.FunctionNotSupportedException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.InvalidParameterException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.PagingErrorException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.PropertyErrorException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.RepositoryErrorException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.TypeErrorException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.UserNotAuthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class EntityLookup<T extends Source> {

    private static final Integer PAGE_SIZE = 0;
    private static final Logger log = LoggerFactory.getLogger(EntityLookup.class);
    protected OMRSRepositoryConnector enterpriseConnector;
    protected OMEntityDao omEntityDao;
    protected OMRSAuditLog auditLog;
    protected EntityLookup parentChain;

    public EntityLookup(OMRSRepositoryConnector enterpriseConnector, OMEntityDao omEntityDao, EntityLookup parentChain, OMRSAuditLog auditLog) {
        this.enterpriseConnector = enterpriseConnector;
        this.omEntityDao = omEntityDao;
        this.auditLog = auditLog;
        this.parentChain = parentChain;
    }

    public abstract EntityDetail lookupEntity(T source) throws UserNotAuthorizedException, FunctionNotSupportedException, InvalidParameterException, RepositoryErrorException, PropertyErrorException, TypeErrorException, PagingErrorException, EntityNotKnownException;

    public void setParentChain(EntityLookup parentChain) {
        this.parentChain = parentChain;
    }

    public EntityDetail lookupEntity(T source, List<EntityDetail> list)  {
        InstanceProperties matchProperties = getMatchingProperties(source);
        return matchExactlyToUniqueEntity(list, matchProperties);
    }

    protected abstract InstanceProperties getMatchingProperties(T source);


    public EntityDetail findEntity(InstanceProperties matchProperties, String typeDefName) throws UserNotAuthorizedException, FunctionNotSupportedException, InvalidParameterException, RepositoryErrorException, PropertyErrorException, TypeErrorException, PagingErrorException {
        List<EntityDetail> existingEntities =  omEntityDao.findEntities(matchProperties, typeDefName);
        return matchExactlyToUniqueEntity(existingEntities, matchProperties);
    }


    public EntityDetail matchExactlyToUniqueEntity(List<EntityDetail> entities, final InstanceProperties matchingProperties) throws RuntimeException {
        if (entities != null && !entities.isEmpty()) {
            List<EntityDetail> filteredEntities = entities.stream().filter(e -> matchProperties(e, matchingProperties)).collect(Collectors.toList());
            if (filteredEntities == null || filteredEntities.isEmpty()) {
                throw new RuntimeException("No entity matches the criteria.");
            }
            if (filteredEntities.size() > 1) {
                throw new RuntimeException("Too many entities are matching the criteria.");//TODO exception
            }
            return filteredEntities.get(0);
        }
        return null;
    }

    public boolean matchProperties(EntityDetail entityDetail, InstanceProperties matchingProperties) {
        InstanceProperties entityProperties = entityDetail.getProperties();
        for (Map.Entry<String, InstancePropertyValue> property : matchingProperties.getInstanceProperties().entrySet()) {

            String actualValue = enterpriseConnector.getRepositoryHelper().getStringProperty("", property.getKey(), entityProperties, "matchProperties");//TODO only string supported for now
            if (!((PrimitivePropertyValue)property.getValue()).getPrimitiveValue().equals(actualValue)) {
                return false;
            }
        }
        return true;
    }


    protected List<String> getRelatedEntities(String parentEntityGuid, String relationshipTypeName) {
        List<Relationship> relationships = omEntityDao.getRelationships(relationshipTypeName, parentEntityGuid);
        return relationships.stream().map(e -> e.getEntityTwoProxy().getGUID()).collect(Collectors.toList());
    }


    protected List<EntityDetail> getRelatedEntities(List<String> allEntitiesGuids, String relationshipType) {
        List<Relationship> allSchemaTypeToTableRelationships = allEntitiesGuids.stream().flatMap(e ->  getRelationships(e, relationshipType).stream()).collect(Collectors.toList());
        return getEntityDetails(allSchemaTypeToTableRelationships);
    }

    private List<Relationship> getRelationships(String guid, String relationshipType) {
        List<Relationship> relationships = omEntityDao.getRelationships(relationshipType, guid);
        if(relationships != null && !relationships.isEmpty()){
            return relationships;
        }
        return Collections.emptyList();
    }

    protected List<EntityDetail> getEntityDetails(List<Relationship> relationships) {
        Set<String> allLinkedTablesGuids = relationships.stream().map(e -> e.getEntityTwoProxy().getGUID()).collect(Collectors.toSet());
        return allLinkedTablesGuids.stream().map(guid -> getEntity(guid)).collect(Collectors.toList());
    }


    protected EntityDetail getEntity(String guid) {
        try {
            return enterpriseConnector.getMetadataCollection().getEntityDetail(Constants.USER_ID, guid);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
