/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.connectedasset.rest;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * ConnectedAssetOMASAPIResponse provides a common header for Connected Asset OMAS managed rest to its REST API.
 * It manages information about exceptions.  If no exception has been raised exceptionClassName is null.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "class")
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = AssetResponse.class, name = "AssetResponse"),
                @JsonSubTypes.Type(value = CertificationsResponse.class, name = "CertificationsResponse"),
                @JsonSubTypes.Type(value = CommentsResponse.class, name = "CommentsResponse"),
                @JsonSubTypes.Type(value = ConnectionsResponse.class, name = "ConnectionsResponse"),
                @JsonSubTypes.Type(value = ExternalIdentifiersResponse.class, name = "ExternalIdentifiersResponse"),
                @JsonSubTypes.Type(value = ExternalReferencesResponse.class, name = "ExternalReferencesResponse"),
                @JsonSubTypes.Type(value = GUIDResponse.class, name = "GUIDResponse"),
                @JsonSubTypes.Type(value = InformalTagsResponse.class, name = "InformalTagsResponse"),
                @JsonSubTypes.Type(value = LicensesResponse.class, name = "LicensesResponse"),
                @JsonSubTypes.Type(value = LikesResponse.class, name = "LikesResponse"),
                @JsonSubTypes.Type(value = LocationsResponse.class, name = "LocationsResponse"),
                @JsonSubTypes.Type(value = NoteLogsResponse.class, name = "NoteLogsResponse"),
                @JsonSubTypes.Type(value = NotesResponse.class, name = "NotesResponse"),
                @JsonSubTypes.Type(value = RatingsResponse.class, name = "RatingsResponse"),
                @JsonSubTypes.Type(value = RelatedAssetsResponse.class, name = "RelatedAssetsResponse"),
                @JsonSubTypes.Type(value = RelatedMediaReferencesResponse.class, name = "RelatedMediaReferencesResponse"),
                @JsonSubTypes.Type(value = SchemaTypeResponse.class, name = "SchemaTypeResponse"),
                @JsonSubTypes.Type(value = SchemaAttributesResponse.class, name = "SchemaAttributesResponse"),
                @JsonSubTypes.Type(value = VoidResponse.class, name = "VoidResponse"),
                @JsonSubTypes.Type(value = CountResponse.class, name = "CountResponse")
        })
public abstract class ConnectedAssetOMASAPIResponse implements java.io.Serializable
{
    private static final long    serialVersionUID = 1L;

    private int                  relatedHTTPCode = 200;
    private String               exceptionClassName = null;
    private String               exceptionErrorMessage = null;
    private String               exceptionSystemAction = null;
    private String               exceptionUserAction = null;
    private Map<String, Object>  exceptionProperties = null;


    /**
     * Default constructor
     */
    public ConnectedAssetOMASAPIResponse()
    {
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public ConnectedAssetOMASAPIResponse(ConnectedAssetOMASAPIResponse template)
    {
        if (template !=null)
        {
            this.relatedHTTPCode = template.getRelatedHTTPCode();
            this.exceptionClassName = template.getExceptionClassName();
            this.exceptionErrorMessage = template.getExceptionErrorMessage();
            this.exceptionSystemAction = template.getExceptionSystemAction();
            this.exceptionUserAction = template.getExceptionUserAction();
            this.exceptionProperties = template.getExceptionProperties();
        }
    }


    /**
     * Return the HTTP Code to use if forwarding response to HTTP client.
     *
     * @return integer HTTP status code
     */
    public int getRelatedHTTPCode()
    {
        return relatedHTTPCode;
    }


    /**
     * Set up the HTTP Code to use if forwarding response to HTTP client.
     *
     * @param relatedHTTPCode - integer HTTP status code
     */
    public void setRelatedHTTPCode(int relatedHTTPCode)
    {
        this.relatedHTTPCode = relatedHTTPCode;
    }


    /**
     * Return the name of the Java class name to use to recreate the exception.
     *
     * @return String name of the fully-qualified java class name
     */
    public String getExceptionClassName()
    {
        return exceptionClassName;
    }


    /**
     * Set up the name of the Java class name to use to recreate the exception.
     *
     * @param exceptionClassName - String name of the fully-qualified java class name
     */
    public void setExceptionClassName(String exceptionClassName)
    {
        this.exceptionClassName = exceptionClassName;
    }


    /**
     * Return the error message associated with the exception.
     *
     * @return string error message
     */
    public String getExceptionErrorMessage()
    {
        return exceptionErrorMessage;
    }


    /**
     * Set up the error message associated with the exception.
     *
     * @param exceptionErrorMessage - string error message
     */
    public void setExceptionErrorMessage(String exceptionErrorMessage)
    {
        this.exceptionErrorMessage = exceptionErrorMessage;
    }


    /**
     * Return the description of the action taken by the system as a result of the exception.
     *
     * @return - string description of the action taken
     */
    public String getExceptionSystemAction()
    {
        return exceptionSystemAction;
    }


    /**
     * Set up the description of the action taken by the system as a result of the exception.
     *
     * @param exceptionSystemAction - string description of the action taken
     */
    public void setExceptionSystemAction(String exceptionSystemAction)
    {
        this.exceptionSystemAction = exceptionSystemAction;
    }


    /**
     * Return the action that a user should take to resolve the problem.
     *
     * @return string instructions
     */
    public String getExceptionUserAction()
    {
        return exceptionUserAction;
    }


    /**
     * Set up the action that a user should take to resolve the problem.
     *
     * @param exceptionUserAction - string instructions
     */
    public void setExceptionUserAction(String exceptionUserAction)
    {
        this.exceptionUserAction = exceptionUserAction;
    }


    /**
     * Return the additional properties stored by the exceptions.
     *
     * @return property map
     */
    public Map<String, Object> getExceptionProperties()
    {
        if (exceptionProperties == null)
        {
            return null;
        }
        else if (exceptionProperties.isEmpty())
        {
            return null;
        }
        else
        {
            return new HashMap<>(exceptionProperties);
        }
    }


    /**
     * Set up the additional properties stored by the exceptions.
     *
     * @param exceptionProperties property map
     */
    public void setExceptionProperties(Map<String, Object> exceptionProperties)
    {
        this.exceptionProperties = exceptionProperties;
    }


    /**
     * JSON-like toString
     *
     * @return string containing the property names and values
     */
    @Override
    public String toString()
    {
        return "ConnectedAssetOMASAPIResponse{" +
                "relatedHTTPCode=" + relatedHTTPCode +
                ", exceptionClassName='" + exceptionClassName + '\'' +
                ", exceptionErrorMessage='" + exceptionErrorMessage + '\'' +
                ", exceptionSystemAction='" + exceptionSystemAction + '\'' +
                ", exceptionUserAction='" + exceptionUserAction + '\'' +
                ", exceptionProperties=" + exceptionProperties +
                '}';
    }


    /**
     * Return comparison result based on the content of the properties.
     *
     * @param objectToCompare test object
     * @return result of comparison
     */
    @Override
    public boolean equals(Object objectToCompare)
    {
        if (this == objectToCompare)
        {
            return true;
        }
        if (!(objectToCompare instanceof ConnectedAssetOMASAPIResponse))
        {
            return false;
        }
        ConnectedAssetOMASAPIResponse that = (ConnectedAssetOMASAPIResponse) objectToCompare;
        return getRelatedHTTPCode() == that.getRelatedHTTPCode() &&
                Objects.equals(getExceptionClassName(), that.getExceptionClassName()) &&
                Objects.equals(getExceptionErrorMessage(), that.getExceptionErrorMessage()) &&
                Objects.equals(getExceptionSystemAction(), that.getExceptionSystemAction()) &&
                Objects.equals(getExceptionUserAction(), that.getExceptionUserAction()) &&
                Objects.equals(getExceptionProperties(), that.getExceptionProperties());
    }


    /**
     * Return hash code for this object
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {

        return Objects.hash(getRelatedHTTPCode(),
                            getExceptionClassName(),
                            getExceptionErrorMessage(),
                            getExceptionSystemAction(),
                            getExceptionUserAction(),
                            getExceptionProperties());
    }
}
