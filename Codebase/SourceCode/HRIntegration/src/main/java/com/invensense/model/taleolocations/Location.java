
package com.invensense.model.taleolocations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "locationName",
    "locationCode",
    "timeZone",
    "directions",
    "regionId",
    "description",
    "requisitionApprovers",
    "address",
    "phone",
    "city",
    "zipCode",
    "state",
    "countryCode",
    "interviewRooms",
    "entityType",
    "relationshipUrls"
})
public class Location {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("locationName")
    private String locationName;
    @JsonProperty("locationCode")
    private String locationCode;
    @JsonProperty("timeZone")
    private String timeZone;
    @JsonProperty("directions")
    private Object directions;
    @JsonProperty("regionId")
    private Integer regionId;
    @JsonProperty("description")
    private String description;
    @JsonProperty("requisitionApprovers")
    private List<Integer> requisitionApprovers = new ArrayList<Integer>();
    @JsonProperty("address")
    private String address;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("state")
    private String state;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("interviewRooms")
    private List<Object> interviewRooms = new ArrayList<Object>();
    @JsonProperty("entityType")
    private String entityType;
    @JsonProperty("relationshipUrls")
    private RelationshipUrls relationshipUrls;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The locationName
     */
    @JsonProperty("locationName")
    public String getLocationName() {
        return locationName;
    }

    /**
     * 
     * @param locationName
     *     The locationName
     */
    @JsonProperty("locationName")
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * 
     * @return
     *     The locationCode
     */
    @JsonProperty("locationCode")
    public String getLocationCode() {
        return locationCode;
    }

    /**
     * 
     * @param locationCode
     *     The locationCode
     */
    @JsonProperty("locationCode")
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    /**
     * 
     * @return
     *     The timeZone
     */
    @JsonProperty("timeZone")
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * 
     * @param timeZone
     *     The timeZone
     */
    @JsonProperty("timeZone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * 
     * @return
     *     The directions
     */
    @JsonProperty("directions")
    public Object getDirections() {
        return directions;
    }

    /**
     * 
     * @param directions
     *     The directions
     */
    @JsonProperty("directions")
    public void setDirections(Object directions) {
        this.directions = directions;
    }

    /**
     * 
     * @return
     *     The regionId
     */
    @JsonProperty("regionId")
    public Integer getRegionId() {
        return regionId;
    }

    /**
     * 
     * @param regionId
     *     The regionId
     */
    @JsonProperty("regionId")
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The requisitionApprovers
     */
    @JsonProperty("requisitionApprovers")
    public List<Integer> getRequisitionApprovers() {
        return requisitionApprovers;
    }

    /**
     * 
     * @param requisitionApprovers
     *     The requisitionApprovers
     */
    @JsonProperty("requisitionApprovers")
    public void setRequisitionApprovers(List<Integer> requisitionApprovers) {
        this.requisitionApprovers = requisitionApprovers;
    }

    /**
     * 
     * @return
     *     The address
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The phone
     */
    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return
     *     The city
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The zipCode
     */
    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 
     * @param zipCode
     *     The zipCode
     */
    @JsonProperty("zipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 
     * @return
     *     The state
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The countryCode
     */
    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 
     * @param countryCode
     *     The countryCode
     */
    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * 
     * @return
     *     The interviewRooms
     */
    @JsonProperty("interviewRooms")
    public List<Object> getInterviewRooms() {
        return interviewRooms;
    }

    /**
     * 
     * @param interviewRooms
     *     The interviewRooms
     */
    @JsonProperty("interviewRooms")
    public void setInterviewRooms(List<Object> interviewRooms) {
        this.interviewRooms = interviewRooms;
    }

    /**
     * 
     * @return
     *     The entityType
     */
    @JsonProperty("entityType")
    public String getEntityType() {
        return entityType;
    }

    /**
     * 
     * @param entityType
     *     The entityType
     */
    @JsonProperty("entityType")
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    /**
     * 
     * @return
     *     The relationshipUrls
     */
    @JsonProperty("relationshipUrls")
    public RelationshipUrls getRelationshipUrls() {
        return relationshipUrls;
    }

    /**
     * 
     * @param relationshipUrls
     *     The relationshipUrls
     */
    @JsonProperty("relationshipUrls")
    public void setRelationshipUrls(RelationshipUrls relationshipUrls) {
        this.relationshipUrls = relationshipUrls;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
