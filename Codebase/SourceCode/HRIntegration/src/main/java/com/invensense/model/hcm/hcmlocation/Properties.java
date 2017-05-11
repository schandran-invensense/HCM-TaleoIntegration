
package com.invensense.model.hcm.hcmlocation;

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
    "changeIndicator"
})
public class Properties {

    @JsonProperty("changeIndicator")
    private String changeIndicator;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The changeIndicator
     */
    @JsonProperty("changeIndicator")
    public String getChangeIndicator() {
        return changeIndicator;
    }

    /**
     * 
     * @param changeIndicator
     *     The changeIndicator
     */
    @JsonProperty("changeIndicator")
    public void setChangeIndicator(String changeIndicator) {
        this.changeIndicator = changeIndicator;
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
