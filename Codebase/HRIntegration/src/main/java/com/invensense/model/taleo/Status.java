
package com.invensense.model.taleo;

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
    "success",
    "detail"
})
public class Status {

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("detail")
    private Detail detail;
   
    /**
     * 
     * @return
     *     The success
     */
    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    /**
     * 
     * @param success
     *     The success
     */
    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * 
     * @return
     *     The detail
     */
    @JsonProperty("detail")
    public Detail getDetail() {
        return detail;
    }

    /**
     * 
     * @param detail
     *     The detail
     */
    @JsonProperty("detail")
    public void setDetail(Detail detail) {
        this.detail = detail;
    }

  

}
