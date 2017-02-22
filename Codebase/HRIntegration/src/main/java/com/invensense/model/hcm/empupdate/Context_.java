
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
    "PrimaryPhoneNumber",
    "PersonId",
    "PersonName",
    "EffectiveStartDate",
    "EffectiveDate",
    "WorkerType",
    "PeriodType",
    "PersonNumber",
    "WorkEmail"
})
public class Context_ {

    @JsonProperty("PrimaryPhoneNumber")
    private String primaryPhoneNumber;
    @JsonProperty("PersonId")
    private String personId;
    @JsonProperty("PersonName")
    private String personName;
    @JsonProperty("EffectiveStartDate")
    private String effectiveStartDate;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("WorkerType")
    private String workerType;
    @JsonProperty("PeriodType")
    private String periodType;
    @JsonProperty("PersonNumber")
    private String personNumber;
    @JsonProperty("WorkEmail")
    private String workEmail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The primaryPhoneNumber
     */
    @JsonProperty("PrimaryPhoneNumber")
    public String getPrimaryPhoneNumber() {
        return primaryPhoneNumber;
    }

    /**
     * 
     * @param primaryPhoneNumber
     *     The PrimaryPhoneNumber
     */
    @JsonProperty("PrimaryPhoneNumber")
    public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
        this.primaryPhoneNumber = primaryPhoneNumber;
    }

    /**
     * 
     * @return
     *     The personId
     */
    @JsonProperty("PersonId")
    public String getPersonId() {
        return personId;
    }

    /**
     * 
     * @param personId
     *     The PersonId
     */
    @JsonProperty("PersonId")
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * 
     * @return
     *     The personName
     */
    @JsonProperty("PersonName")
    public String getPersonName() {
        return personName;
    }

    /**
     * 
     * @param personName
     *     The PersonName
     */
    @JsonProperty("PersonName")
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    /**
     * 
     * @return
     *     The effectiveStartDate
     */
    @JsonProperty("EffectiveStartDate")
    public String getEffectiveStartDate() {
        return effectiveStartDate;
    }

    /**
     * 
     * @param effectiveStartDate
     *     The EffectiveStartDate
     */
    @JsonProperty("EffectiveStartDate")
    public void setEffectiveStartDate(String effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    /**
     * 
     * @return
     *     The effectiveDate
     */
    @JsonProperty("EffectiveDate")
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * 
     * @param effectiveDate
     *     The EffectiveDate
     */
    @JsonProperty("EffectiveDate")
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * 
     * @return
     *     The workerType
     */
    @JsonProperty("WorkerType")
    public String getWorkerType() {
        return workerType;
    }

    /**
     * 
     * @param workerType
     *     The WorkerType
     */
    @JsonProperty("WorkerType")
    public void setWorkerType(String workerType) {
        this.workerType = workerType;
    }

    /**
     * 
     * @return
     *     The periodType
     */
    @JsonProperty("PeriodType")
    public String getPeriodType() {
        return periodType;
    }

    /**
     * 
     * @param periodType
     *     The PeriodType
     */
    @JsonProperty("PeriodType")
    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    /**
     * 
     * @return
     *     The personNumber
     */
    @JsonProperty("PersonNumber")
    public String getPersonNumber() {
        return personNumber;
    }

    /**
     * 
     * @param personNumber
     *     The PersonNumber
     */
    @JsonProperty("PersonNumber")
    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    /**
     * 
     * @return
     *     The workEmail
     */
    @JsonProperty("WorkEmail")
    public String getWorkEmail() {
        return workEmail;
    }

    /**
     * 
     * @param workEmail
     *     The WorkEmail
     */
    @JsonProperty("WorkEmail")
    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
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
