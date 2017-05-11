
package com.invensense.model.hcm.empupdate;

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
    "Context",
    "Changed Attributes"
})
public class ContextRoot {

    @JsonProperty("Context")
    private List<Context_> context = new ArrayList<Context_>();
    @JsonProperty("Changed Attributes")
    private List<ChangedAttribute> changedAttributes = new ArrayList<ChangedAttribute>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The context
     */
    @JsonProperty("Context")
    public List<Context_> getContext() {
        return context;
    }

    /**
     * 
     * @param context
     *     The Context
     */
    @JsonProperty("Context")
    public void setContext(List<Context_> context) {
        this.context = context;
    }

    /**
     * 
     * @return
     *     The changedAttributes
     */
    @JsonProperty("Changed Attributes")
    public List<ChangedAttribute> getChangedAttributes() {
        return changedAttributes;
    }

    /**
     * 
     * @param changedAttributes
     *     The Changed Attributes
     */
    @JsonProperty("Changed Attributes")
    public void setChangedAttributes(List<ChangedAttribute> changedAttributes) {
        this.changedAttributes = changedAttributes;
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
