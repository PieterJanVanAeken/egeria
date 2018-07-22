/* SPDX-License-Identifier: Apache-2.0 */

// This is a generated file - do not edit - changes should be made to the templates amd/or generator to generate this file with changes.

package org.odpi.openmetadata.accessservices.subjectarea.generated.relationships.ContactThrough;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.*;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.*;

import org.odpi.openmetadata.accessservices.subjectarea.generated.relationships.ContactThrough.ContactThrough;
import org.odpi.openmetadata.accessservices.subjectarea.properties.enums.*;
import org.odpi.openmetadata.accessservices.subjectarea.ffdc.exceptions.InvalidParameterException;
import org.odpi.openmetadata.accessservices.subjectarea.properties.enums.Status;
import org.odpi.openmetadata.accessservices.subjectarea.properties.objects.common.SystemAttributes;
import org.odpi.openmetadata.accessservices.subjectarea.properties.objects.line.Line;
import org.odpi.openmetadata.accessservices.subjectarea.utilities.SubjectAreaUtils;

import java.util.*;

/**
 * Static mapping methods to map between ContactThrough and the omrs Relationship.
 */
public class ContactThroughMapper {
       private static final Logger log = LoggerFactory.getLogger(ContactThroughMapper.class);
       private static final String className = ContactThroughMapper.class.getName();

       public static ContactThrough mapOmrsRelationshipToContactThrough(Relationship omrsRelationship)  throws InvalidParameterException {
     
               if ("ContactThrough".equals(omrsRelationship.getType().getTypeDefName())) {
                   ContactThrough contactThrough = new ContactThrough(omrsRelationship);

                   SystemAttributes systemAttributes = new SystemAttributes();
                   InstanceStatus instanceStatus =  omrsRelationship.getStatus();
                   Status omrsBeanStatus = SubjectAreaUtils.convertInstanceStatusToStatus(instanceStatus);
                   systemAttributes.setStatus(omrsBeanStatus);
                   systemAttributes.setCreatedBy(omrsRelationship.getCreatedBy());
                   systemAttributes.setUpdatedBy(omrsRelationship.getUpdatedBy());
                   systemAttributes.setCreateTime(omrsRelationship.getCreateTime());
                   systemAttributes.setUpdateTime(omrsRelationship.getUpdateTime());
                   systemAttributes.setVersion(omrsRelationship.getVersion());
                   systemAttributes.setGUID(omrsRelationship.getGUID());
                   contactThrough.setSystemAttributes(systemAttributes);

                   InstanceProperties omrsRelationshipProperties = omrsRelationship.getProperties();
                   Iterator omrsPropertyIterator = omrsRelationshipProperties.getPropertyNames();
                   while (omrsPropertyIterator.hasNext()) {
                       String name = (String) omrsPropertyIterator.next();
                       //TODO check if this is a property we expect or whether the type has been added to.
                       // this is a property we expect
                       InstancePropertyValue value = omrsRelationshipProperties.getPropertyValue(name);
                       // supplied guid matches the expected type
                       Object actualValue;
                       switch (value.getInstancePropertyCategory()) {
                                               case PRIMITIVE:
                                                   PrimitivePropertyValue primitivePropertyValue = (PrimitivePropertyValue) value;
                                                   actualValue = primitivePropertyValue.getPrimitiveValue();
                                                   if (ContactThrough.ATTRIBUTE_NAMES_SET.contains(name)) {
                                                      if (name.equals("contactMethodValue")) {
                                                           contactThrough.setContactMethodValue((String)actualValue);
                                                      }
                                                   } else {
                                                       // put out the omrs value object
                                                       if (contactThrough.getExtraAttributes() ==null) {
                                                            Map<String, Object> extraAttributes = new HashMap();
                                                            contactThrough.setExtraAttributes(extraAttributes);
                                                        }
                                                      contactThrough.getExtraAttributes().put(name, primitivePropertyValue);
                                                   }
                                                   break;
                                               case ENUM:
                                                   EnumPropertyValue enumPropertyValue = (EnumPropertyValue) value;
                                                   String symbolicName = enumPropertyValue.getSymbolicName();
                                                   if (ContactThrough.ENUM_NAMES_SET.contains(name)) {
                                                        if (name.equals("contactMethodType")) {
                                                              org.odpi.openmetadata.accessservices.subjectarea.properties.enums.ContactMethodType contactMethodType = org.odpi.openmetadata.accessservices.subjectarea.properties.enums.ContactMethodType.valueOf(symbolicName);
                                                             contactThrough.setContactMethodType(contactMethodType);
                                                        }
                                                   } else {
                                                       // put out the omrs value object
                                                        if (contactThrough.getExtraAttributes() ==null) {
                                                            Map<String, Object> extraAttributes = new HashMap();
                                                            contactThrough.setExtraAttributes(extraAttributes);
                                                        }

                                                        contactThrough.getExtraAttributes().put(name, enumPropertyValue);
                                                    }
                       
                                                   break;
                                               case MAP:
                                                    if (contactThrough.MAP_NAMES_SET.contains(name)) {
                                                        MapPropertyValue mapPropertyValue = (MapPropertyValue) value;
                                                        InstanceProperties instancePropertyForMap = (InstanceProperties) mapPropertyValue.getMapValues();

                                                    }
                                                    break;
                                               case ARRAY:
                                               case STRUCT:
                                               case UNKNOWN:
                                                   // error
                                                   break;
                                           }
                       
                                       }   // end while
                                       return contactThrough;

                   } else {
                       // TODO wrong type for this guid
                   }
                   return null;
       }
       public static Relationship mapContactThroughToOmrsRelationship(ContactThrough contactThrough) {
           Relationship omrsRelationship = Line.createOmrsRelationship(contactThrough);

           SystemAttributes systemAttributes = contactThrough.getSystemAttributes();
           if (systemAttributes!=null) {
               if (systemAttributes.getCreatedBy()!=null)
                   omrsRelationship.setCreatedBy(systemAttributes.getCreatedBy());
               if (systemAttributes.getUpdatedBy()!=null)
                   omrsRelationship.setUpdatedBy(systemAttributes.getUpdatedBy());
               if (systemAttributes.getCreateTime()!=null)
                   omrsRelationship.setCreateTime(systemAttributes.getCreateTime());
               if (systemAttributes.getUpdateTime()!=null)
                   omrsRelationship.setUpdateTime(systemAttributes.getUpdateTime());
               if (systemAttributes.getVersion()!=null)
                   omrsRelationship.setVersion(systemAttributes.getVersion());
               if (systemAttributes.getStatus()!=null) {
                   InstanceStatus instanceStatus = SubjectAreaUtils.convertStatusToStatusInstance(systemAttributes.getStatus());
                   omrsRelationship.setStatus(instanceStatus);
               }
           }

           InstanceProperties instanceProperties = new InstanceProperties();
           // primitives

            if (contactThrough.getContactMethodValue()!=null) {
                PrimitivePropertyValue primitivePropertyValue = new PrimitivePropertyValue();
                primitivePropertyValue.setPrimitiveDefCategory(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_STRING);
                primitivePropertyValue.setPrimitiveValue(contactThrough.getContactMethodValue());
                instanceProperties.setProperty("contactMethodValue", primitivePropertyValue);
            }
            if (contactThrough.getContactMethodType()!=null) {
                ContactMethodType enumType = contactThrough.getContactMethodType();
                EnumPropertyValue enumPropertyValue = new EnumPropertyValue();
                enumPropertyValue.setOrdinal(enumType.ordinal());
                enumPropertyValue.setSymbolicName(enumType.name());
                instanceProperties.setProperty("contactMethodType", enumPropertyValue);
            }
            omrsRelationship.setProperties(instanceProperties);

           return omrsRelationship;
       }
}