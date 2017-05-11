
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
    "employee"
})
public class Response {

    @JsonProperty("employee")
    private Employee employee;
   
    /**
     * 
     * @return
     *     The employee
     */
    @JsonProperty("employee")
    public Employee getEmployee() {
        return employee;
    }

    /**
     * 
     * @param employee
     *     The employee
     */
    @JsonProperty("employee")
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

   
}
