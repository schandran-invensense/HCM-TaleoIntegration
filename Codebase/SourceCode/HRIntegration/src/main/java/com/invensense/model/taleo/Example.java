
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
    "response",
    "status"
})
public class Example {

    @JsonProperty("response")
    private Response response;
    @JsonProperty("status")
    private Status status;
   
    /**
     * 
     * @return
     *     The response
     */
    @JsonProperty("response")
    public Response getResponse() {
        return response;
    }

    /**
     * 
     * @param response
     *     The response
     */
    @JsonProperty("response")
    public void setResponse(Response response) {
        this.response = response;
    }

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

   
}
