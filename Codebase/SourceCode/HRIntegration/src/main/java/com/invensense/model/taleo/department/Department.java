
package com.invensense.model.taleo.department;

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
    "departmentName",
    "departmentCode",
    "creationDate",
    "lastUpdated",
    "requisitionApprovers",
    "description",
    "entityType",
    "associatedUsers",
    "relationshipUrls"
})
public class Department {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("departmentName")
    private String departmentName;
    @JsonProperty("departmentCode")
    private String departmentCode;
    @JsonProperty("creationDate")
    private String creationDate;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("requisitionApprovers")
    private List<Object> requisitionApprovers = new ArrayList<Object>();
    @JsonProperty("description")
    private String description;
    @JsonProperty("entityType")
    private String entityType;
    @JsonProperty("associatedUsers")
    private List<Integer> associatedUsers = new ArrayList<Integer>();
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
     *     The departmentName
     */
    @JsonProperty("departmentName")
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 
     * @param departmentName
     *     The departmentName
     */
    @JsonProperty("departmentName")
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * 
     * @return
     *     The departmentCode
     */
    @JsonProperty("departmentCode")
    public String getDepartmentCode() {
        return departmentCode;
    }

    /**
     * 
     * @param departmentCode
     *     The departmentCode
     */
    @JsonProperty("departmentCode")
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    /**
     * 
     * @return
     *     The creationDate
     */
    @JsonProperty("creationDate")
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * 
     * @param creationDate
     *     The creationDate
     */
    @JsonProperty("creationDate")
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * 
     * @return
     *     The lastUpdated
     */
    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * 
     * @param lastUpdated
     *     The lastUpdated
     */
    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * 
     * @return
     *     The requisitionApprovers
     */
    @JsonProperty("requisitionApprovers")
    public List<Object> getRequisitionApprovers() {
        return requisitionApprovers;
    }

    /**
     * 
     * @param requisitionApprovers
     *     The requisitionApprovers
     */
    @JsonProperty("requisitionApprovers")
    public void setRequisitionApprovers(List<Object> requisitionApprovers) {
        this.requisitionApprovers = requisitionApprovers;
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
     *     The associatedUsers
     */
    @JsonProperty("associatedUsers")
    public List<Integer> getAssociatedUsers() {
        return associatedUsers;
    }

    /**
     * 
     * @param associatedUsers
     *     The associatedUsers
     */
    @JsonProperty("associatedUsers")
    public void setAssociatedUsers(List<Integer> associatedUsers) {
        this.associatedUsers = associatedUsers;
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
