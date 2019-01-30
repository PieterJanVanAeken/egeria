/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.communityprofile.server;


import org.odpi.openmetadata.accessservices.communityprofile.admin.CommunityProfileAdmin;
import org.odpi.openmetadata.adminservices.OMAGAccessServiceRegistration;
import org.odpi.openmetadata.adminservices.configuration.registration.AccessServiceDescription;
import org.odpi.openmetadata.adminservices.configuration.registration.AccessServiceOperationalStatus;
import org.odpi.openmetadata.adminservices.configuration.registration.AccessServiceRegistration;

/**
 * CommunityProfileRegistration registers the access service with the OMAG Server administration services.
 * This registration must be driven once at server start up.  The OMAG Server administration services
 * then use this registration information as confirmation that there is an implementation of this
 * access service in the server and it can be configured and used.
 */
public class CommunityProfileRegistration
{
    /**
     * Pass information about this access service to the OMAG Server administration services.
     */
    public static void registerAccessService()
    {
        AccessServiceDescription myDescription = AccessServiceDescription.COMMUNITY_PROFILE_OMAS;

        AccessServiceRegistration myRegistration = new AccessServiceRegistration(myDescription.getAccessServiceCode(),
                                                                                 myDescription.getAccessServiceName(),
                                                                                 myDescription.getAccessServiceDescription(),
                                                                                 myDescription.getAccessServiceWiki(),
                                                                                 AccessServiceOperationalStatus.ENABLED,
                                                                                 CommunityProfileAdmin.class.getName());
        OMAGAccessServiceRegistration.registerAccessService(myRegistration);
    }
}