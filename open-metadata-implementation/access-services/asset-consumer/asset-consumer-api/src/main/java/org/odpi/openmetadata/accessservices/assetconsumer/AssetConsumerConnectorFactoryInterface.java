/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.assetconsumer;

import org.odpi.openmetadata.accessservices.assetconsumer.ffdc.exceptions.*;
import org.odpi.openmetadata.accessservices.assetconsumer.properties.GlossaryTerm;
import org.odpi.openmetadata.frameworks.connectors.Connector;
import org.odpi.openmetadata.frameworks.connectors.ffdc.ConnectionCheckedException;
import org.odpi.openmetadata.frameworks.connectors.ffdc.ConnectorCheckedException;
import org.odpi.openmetadata.frameworks.connectors.properties.AssetUniverse;
import org.odpi.openmetadata.frameworks.connectors.properties.beans.CommentType;
import org.odpi.openmetadata.frameworks.connectors.properties.beans.Connection;
import org.odpi.openmetadata.frameworks.connectors.properties.beans.StarRating;

import java.util.List;

/**
 * AssetConsumerConnectorFactoryInterface is used by applications and tools as a factory for Open
 * Connector Framework (OCF) connectors.  The configuration for the connectors is managed as open metadata in
 * a Connection definition.  The caller to the Asset Consumer OMAS passes either the name, GUID or URL for the
 * connection to the appropriate method to retrieve a connector.  The Asset Consumer OMAS retrieves the connection
 * from the metadata repository and creates an appropriate connector as described the connection and
 * returns it to the caller.
 */
public interface AssetConsumerConnectorFactoryInterface
{
    /**
     * Returns the connector corresponding to the supplied connection name.
     *
     * @param userId           userId of user making request.
     * @param connectionName   this may be the qualifiedName or displayName of the connection.
     *
     * @return Connector   connector instance.
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws AmbiguousConnectionNameException there is more than one connection defined for this name.
     * @throws ConnectionCheckedException there are errors in the configuration of the connection which is preventing
     *                                      the creation of a connector.
     * @throws ConnectorCheckedException there are errors in the initialization of the connector.
     * @throws PropertyServerException there is a problem retrieving information from the property server(s).
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     */
    Connector getConnectorByName(String userId,
                                 String connectionName) throws InvalidParameterException,
                                                               AmbiguousConnectionNameException,
                                                               ConnectionCheckedException,
                                                               ConnectorCheckedException,
                                                               PropertyServerException,
                                                               UserNotAuthorizedException;


    /**
     * Returns the connector corresponding to the supplied connection GUID.
     *
     * @param userId           userId of user making request.
     * @param connectionGUID   the unique id for the connection within the metadata repository.
     *
     * @return Connector   connector instance.
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws ConnectionCheckedException there are errors in the configuration of the connection which is preventing
     *                                      the creation of a connector.
     * @throws ConnectorCheckedException there are errors in the initialization of the connector.
     * @throws PropertyServerException there is a problem retrieving information from the property server(s).
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     */
    Connector getConnectorByGUID(String userId,
                                 String connectionGUID) throws InvalidParameterException,
                                                               ConnectionCheckedException,
                                                               ConnectorCheckedException,
                                                               PropertyServerException,
                                                               UserNotAuthorizedException;


    /**
     * Returns the connector corresponding to the supplied connection.
     *
     * @param userId       userId of user making request.
     * @param connection   the connection object that contains the properties needed to create the connection.
     *
     * @return Connector   connector instance
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws ConnectionCheckedException there are errors in the configuration of the connection which is preventing
     *                                      the creation of a connector.
     * @throws ConnectorCheckedException there are errors in the initialization of the connector.
     * @throws PropertyServerException there is a problem retrieving information from the property server(s).
     */
    Connector  getConnectorByConnection(String userId,
                                        Connection connection) throws InvalidParameterException,
                                                                      ConnectionCheckedException,
                                                                      ConnectorCheckedException,
                                                                      PropertyServerException;
}
