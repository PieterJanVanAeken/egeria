/* SPDX-License-Identifier: Apache-2.0 */
package org.odpi.openmetadata.accessservices.digitalarchitecture.properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Validate that the Asset bean can be cloned, compared, serialized, deserialized and printed as a String.
 */
public class DigitalServiceTest
{
    private String                            url                      = "TestURL";
    private String                            guid                     = "TestGUID";
    private String                            typeId                   = "TestTypeId";
    private String                            typeName                 = "TestTypeName";
    private long                              typeVersion              = 7;
    private String                            typeDescription          = "TestTypeDescription";
    private String                            qualifiedName            = "TestQualifiedName";
    private String                            displayName              = "TestDisplayName";
    private String                            description              = "TestDescription";
    private DigitalServiceImplementationStyle implementationStyle      = DigitalServiceImplementationStyle.API;
    private DigitalServiceStatus              status                   = DigitalServiceStatus.APPROVED_CONCEPT;
    private DigitalServiceVisibility          visibility               = DigitalServiceVisibility.EXTERNAL_SERVICE;
    private DigitalServiceResponsibility      responsibility           = DigitalServiceResponsibility.DATA_CONTROLLER;
    private Map<String, Object>               additionalProperties     = new HashMap<>();
    private List<Classification>              classifications          = new ArrayList<>();
    private Classification                    classification           = new Classification();
    private Map<String, Object>               classificationProperties = new HashMap<>();



    /**
     * Default constructor
     */
    public DigitalServiceTest()
    {
        additionalProperties.put("TestAdditionalPropertyName", "TestAdditionalPropertyValue");

        classification.setClassificationName("TestClassificationName");
        classificationProperties.put("TestClassificationPropertyName", "TestClassificationPropertyValue");
        classification.setClassificationProperties(classificationProperties);
        classifications.add(classification);
    }


    /**
     * Set up an example object to test.
     *
     * @return filled in object
     */
    private DigitalService getTestObject()
    {
        DigitalService testObject = new DigitalService();

        testObject.setURL(url);
        testObject.setGUID(guid);
        testObject.setTypeId(typeId);
        testObject.setTypeName(typeName);
        testObject.setTypeVersion(typeVersion);
        testObject.setTypeDescription(typeDescription);
        testObject.setQualifiedName(qualifiedName);
        testObject.setDisplayName(displayName);
        testObject.setDescription(description);
        testObject.setImplementationStyle(implementationStyle);
        testObject.setVisibility(visibility);
        testObject.setStatus(status);
        testObject.setResponsibility(responsibility);
        testObject.setAdditionalProperties(additionalProperties);
        testObject.setClassifications(classifications);

        return testObject;
    }


    /**
     * Validate that the object that comes out of the test has the same content as the original test object.
     *
     * @param resultObject object returned by the test
     */
    private void validateResultObject(DigitalService  resultObject)
    {
        assertTrue(resultObject.getURL().equals(url));
        assertTrue(resultObject.getGUID().equals(guid));
        assertTrue(resultObject.getTypeId().equals(typeId));
        assertTrue(resultObject.getTypeName().equals(typeName));

        assertTrue(resultObject.getTypeVersion() == typeVersion);

        assertTrue(resultObject.getTypeDescription().equals(typeDescription));
        assertTrue(resultObject.getQualifiedName().equals(qualifiedName));
        assertTrue(resultObject.getDisplayName().equals(displayName));
        assertTrue(resultObject.getDescription().equals(description));
        assertTrue(resultObject.getImplementationStyle().equals(implementationStyle));
        assertTrue(resultObject.getVisibility().equals(visibility));
        assertTrue(resultObject.getStatus().equals(status));
        assertTrue(resultObject.getResponsibility().equals(responsibility));
        assertTrue(resultObject.getAdditionalProperties().equals(additionalProperties));
        assertTrue(resultObject.getClassifications().equals(classifications));
    }


    /**
     * Validate that the object is initialized properly
     */
    @Test public void testNullObject()
    {
        DigitalService    nullObject = new DigitalService();

        assertTrue(nullObject.getURL() == null);
        assertTrue(nullObject.getGUID() == null);
        assertTrue(nullObject.getTypeId() == null);
        assertTrue(nullObject.getTypeName() == null);
        assertTrue(nullObject.getTypeVersion() == 0);
        assertTrue(nullObject.getTypeDescription() == null);
        assertTrue(nullObject.getQualifiedName() == null);
        assertTrue(nullObject.getDisplayName() == null);
        assertTrue(nullObject.getDescription() == null);
        assertTrue(nullObject.getImplementationStyle() == null);
        assertTrue(nullObject.getVisibility() == null);
        assertTrue(nullObject.getStatus() == null);
        assertTrue(nullObject.getResponsibility() == null);
        assertTrue(nullObject.getAdditionalProperties() == null);
        assertTrue(nullObject.getClassifications() == null);

        nullObject = new DigitalService(null);

        assertTrue(nullObject.getURL() == null);
        assertTrue(nullObject.getGUID() == null);
        assertTrue(nullObject.getTypeId() == null);
        assertTrue(nullObject.getTypeName() == null);
        assertTrue(nullObject.getTypeVersion() == 0);
        assertTrue(nullObject.getTypeDescription() == null);
        assertTrue(nullObject.getQualifiedName() == null);
        assertTrue(nullObject.getDisplayName() == null);
        assertTrue(nullObject.getDescription() == null);
        assertTrue(nullObject.getImplementationStyle() == null);
        assertTrue(nullObject.getVisibility() == null);
        assertTrue(nullObject.getStatus() == null);
        assertTrue(nullObject.getResponsibility() == null);
        assertTrue(nullObject.getAdditionalProperties() == null);
        assertTrue(nullObject.getClassifications() == null);

    }


    /**
     * Validate that additional properties are managed properly
     */
    @Test public void testAdditionalProperties()
    {
        Map<String, Object>   propertyMap;
        DigitalService                 testObject = new DigitalService();

        assertTrue(testObject.getAdditionalProperties() == null);

        propertyMap = null;
        testObject = new DigitalService();
        testObject.setAdditionalProperties(propertyMap);

        assertTrue(testObject.getAdditionalProperties() == null);

        propertyMap = new HashMap<>();
        testObject = new DigitalService();
        testObject.setAdditionalProperties(propertyMap);

        assertTrue(testObject.getAdditionalProperties() == null);

        propertyMap.put("propertyName", "propertyValue");
        testObject = new DigitalService();
        testObject.setAdditionalProperties(propertyMap);

        Map<String, Object>   retrievedPropertyMap = testObject.getAdditionalProperties();

        assertTrue(retrievedPropertyMap != null);
        assertFalse(retrievedPropertyMap.isEmpty());
        assertTrue("propertyValue".equals(retrievedPropertyMap.get("propertyName")));
    }


    /**
     * Validate that additional properties are managed properly
     */
    @Test public void testClassifications()
    {
        DigitalService                 testObject = new DigitalService();

        assertTrue(testObject.getClassifications() == null);

        testObject = new DigitalService();
        testObject.setClassifications(null);

        assertTrue(testObject.getClassifications() == null);

        List<Classification>  emptyClassifications = new ArrayList<>();
        testObject = new DigitalService();
        testObject.setClassifications(emptyClassifications);

        assertTrue(testObject.getClassifications() == null);

        testObject = new DigitalService();
        testObject.setClassifications(classifications);

        List<Classification>   retrievedClassifications = testObject.getClassifications();

        assertTrue(retrievedClassifications != null);
        assertFalse(retrievedClassifications.isEmpty());
        assertTrue(retrievedClassifications.equals(classifications));
    }


    /**
     * Validate that 2 different objects with the same content are evaluated as equal.
     * Also that different objects are considered not equal.
     */
    @Test public void testEquals()
    {
        assertFalse(getTestObject().equals(null));
        assertFalse(getTestObject().equals("DummyString"));
        assertTrue(getTestObject().equals(getTestObject()));

        DigitalService  sameObject = getTestObject();
        assertTrue(sameObject.equals(sameObject));

        DigitalService  differentObject = getTestObject();
        differentObject.setDescription("Different");
        assertFalse(getTestObject().equals(differentObject));
    }


    /**
     *  Validate that 2 different objects with the same content have the same hash code.
     */
    @Test public void testHashCode()
    {
        assertTrue(getTestObject().hashCode() == getTestObject().hashCode());

        DigitalService  testObject = getTestObject();

        assertTrue(testObject.hashCode() != 0);

        DigitalService  differentObject = getTestObject();

        differentObject.setClassifications(null);

        assertFalse(testObject.hashCode() == differentObject.hashCode());
    }


    /**
     *  Validate that an object cloned from another object has the same content as the original
     */
    @Test public void testClone()
    {
        validateResultObject(new DigitalService(getTestObject()));
    }


    /**
     * Validate that an object generated from a JSON String has the same content as the object used to
     * create the JSON String.
     */
    @Test public void testJSON()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String       jsonString   = null;

        /*
         * This class
         */
        try
        {
            jsonString = objectMapper.writeValueAsString(getTestObject());
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateResultObject(objectMapper.readValue(jsonString, DigitalService.class));
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        /*
         * Through superclass
         */
        DigitalArchitectureElementHeader superObject = getTestObject();

        try
        {
            jsonString = objectMapper.writeValueAsString(superObject);
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateResultObject((DigitalService) objectMapper.readValue(jsonString, DigitalArchitectureElementHeader.class));
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }
    }


    /**
     * Test that toString is overridden.
     */
    @Test public void testToString()
    {
        assertTrue(getTestObject().toString().contains("DigitalService"));
    }
}
