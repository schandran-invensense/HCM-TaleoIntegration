
package com.invensense.model.taleo.department;

import java.util.HashMap;
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
    "requisitionApprovers",
    "associatedUsers"
})
public class RelationshipUrls {

    @JsonProperty("requisitionApprovers")
    private String requisitionApprovers;
    @JsonProperty("associatedUsers")
    private String associatedUsers;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The requisitionApprovers
     */
    @JsonProperty("requisitionApprovers")
    public String getRequisitionApprovers() {
        return requisitionApprovers;
    }

    /**
     * 
     * @param requisitionApprovers
     *     The requisitionApprovers
     */
    @JsonProperty("requisitionApprovers")
    public void setRequisitionApprovers(String requisitionApprovers) {
        this.requisitionApprovers = requisitionApprovers;
    }

    /**
     * 
     * @return
     *     The associatedUsers
     */
    @JsonProperty("associatedUsers")
    public String getAssociatedUsers() {
        return associatedUsers;
    }

    /**
     * 
     * @param associatedUsers
     *     The associatedUsers
     */
    @JsonProperty("associatedUsers")
    public void setAssociatedUsers(String associatedUsers) {
        this.associatedUsers = associatedUsers;
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
