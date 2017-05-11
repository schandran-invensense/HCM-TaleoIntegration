
package com.invensense.model.taleolocations;

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
    "requisitionApprovers"
})
public class RelationshipUrls {

    @JsonProperty("requisitionApprovers")
    private String requisitionApprovers;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
