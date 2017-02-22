
package com.invensense.model.hcm.empupdate;

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
    "old",
    "new"
})
public class EmailAddress {

    @JsonProperty("old")
    private String old;
    @JsonProperty("new")
    private String _new;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The old
     */
    @JsonProperty("old")
    public String getOld() {
        return old;
    }

    /**
     * 
     * @param old
     *     The old
     */
    @JsonProperty("old")
    public void setOld(String old) {
        this.old = old;
    }

    /**
     * 
     * @return
     *     The _new
     */
    @JsonProperty("new")
    public String getNew() {
        return _new;
    }

    /**
     * 
     * @param _new
     *     The new
     */
    @JsonProperty("new")
    public void setNew(String _new) {
        this._new = _new;
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
