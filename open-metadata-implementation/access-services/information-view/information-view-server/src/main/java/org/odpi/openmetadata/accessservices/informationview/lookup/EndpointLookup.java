/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.informationview.lookup;

import org.odpi.openmetadata.accessservices.informationview.contentmanager.OMEntityDao;
import org.odpi.openmetadata.accessservices.informationview.events.Source;
import org.odpi.openmetadata.accessservices.informationview.utils.Constants;
import org.odpi.openmetadata.repositoryservices.auditlog.OMRSAuditLog;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.EntityDetail;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.InstanceProperties;
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
import org.springframework.util.StringUtils;

public class EndpointLookup extends EntityLookup<Source> {

    private static final Logger log = LoggerFactory.getLogger(EndpointLookup.class);

    public EndpointLookup(OMRSRepositoryConnector enterpriseConnector, OMEntityDao omEntityDao, EntityLookup chain, OMRSAuditLog auditLog) {
        super(enterpriseConnector, omEntityDao, chain, auditLog);

    }

    @Override
    public EntityDetail lookupEntity(Source source) throws UserNotAuthorizedException, FunctionNotSupportedException, InvalidParameterException, RepositoryErrorException, PropertyErrorException, TypeErrorException, PagingErrorException, EntityNotKnownException {
        return findEndpoint(source);

    }

    @Override
    protected InstanceProperties getMatchingProperties(Source source) {
        InstanceProperties matchProperties = new InstanceProperties();
        matchProperties = enterpriseConnector.getRepositoryHelper().addStringPropertyToInstance(Constants.INFORMATION_VIEW_OMAS_NAME, matchProperties, Constants.NETWORK_ADDRESS, source.getNetworkAddress(), "findEndpoint");
        if(!StringUtils.isEmpty(source.getProtocol())){
            matchProperties = enterpriseConnector.getRepositoryHelper().addStringPropertyToInstance(Constants.INFORMATION_VIEW_OMAS_NAME, matchProperties, Constants.PROTOCOL, source.getProtocol(), "findEndpoint");
        }
        return matchProperties;
    }


    public EntityDetail findEndpoint(Source source) throws UserNotAuthorizedException, FunctionNotSupportedException, InvalidParameterException, RepositoryErrorException, PropertyErrorException, TypeErrorException, PagingErrorException {
        EntityDetail entity = findEntity(getMatchingProperties(source), Constants.ENDPOINT);
        log.info("Endpoint found [{}]", entity);
        return entity;
    }


}
