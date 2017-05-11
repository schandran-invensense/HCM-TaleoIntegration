
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
    "department",
    "division",
    "reportsIndirectly",
    "location",
    "offBoardStatus",
    "onBoardStatus",
    "region",
    "status",
    "workhistory",
    "reference",
    "education",
    "residence",
    "certificate",
    "packets",
    "comment",
    "historylog",
    "contactlog"
})
public class RelationshipUrls {

    @JsonProperty("department")
    private String department;
    @JsonProperty("division")
    private String division;
    @JsonProperty("reportsIndirectly")
    private String reportsIndirectly;
    @JsonProperty("location")
    private String location;
    @JsonProperty("offBoardStatus")
    private String offBoardStatus;
    @JsonProperty("onBoardStatus")
    private String onBoardStatus;
    @JsonProperty("region")
    private String region;
    @JsonProperty("status")
    private String status;
    @JsonProperty("workhistory")
    private String workhistory;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("education")
    private String education;
    @JsonProperty("residence")
    private String residence;
    @JsonProperty("certificate")
    private String certificate;
    @JsonProperty("packets")
    private String packets;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("historylog")
    private String historylog;
    @JsonProperty("contactlog")
    private String contactlog;
    
    /**
     * 
     * @return
     *     The department
     */
    @JsonProperty("department")
    public String getDepartment() {
        return department;
    }

    /**
     * 
     * @param department
     *     The department
     */
    @JsonProperty("department")
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 
     * @return
     *     The division
     */
    @JsonProperty("division")
    public String getDivision() {
        return division;
    }

    /**
     * 
     * @param division
     *     The division
     */
    @JsonProperty("division")
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * 
     * @return
     *     The reportsIndirectly
     */
    @JsonProperty("reportsIndirectly")
    public String getReportsIndirectly() {
        return reportsIndirectly;
    }

    /**
     * 
     * @param reportsIndirectly
     *     The reportsIndirectly
     */
    @JsonProperty("reportsIndirectly")
    public void setReportsIndirectly(String reportsIndirectly) {
        this.reportsIndirectly = reportsIndirectly;
    }

    /**
     * 
     * @return
     *     The location
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The offBoardStatus
     */
    @JsonProperty("offBoardStatus")
    public String getOffBoardStatus() {
        return offBoardStatus;
    }

    /**
     * 
     * @param offBoardStatus
     *     The offBoardStatus
     */
    @JsonProperty("offBoardStatus")
    public void setOffBoardStatus(String offBoardStatus) {
        this.offBoardStatus = offBoardStatus;
    }

    /**
     * 
     * @return
     *     The onBoardStatus
     */
    @JsonProperty("onBoardStatus")
    public String getOnBoardStatus() {
        return onBoardStatus;
    }

    /**
     * 
     * @param onBoardStatus
     *     The onBoardStatus
     */
    @JsonProperty("onBoardStatus")
    public void setOnBoardStatus(String onBoardStatus) {
        this.onBoardStatus = onBoardStatus;
    }

    /**
     * 
     * @return
     *     The region
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * 
     * @param region
     *     The region
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The workhistory
     */
    @JsonProperty("workhistory")
    public String getWorkhistory() {
        return workhistory;
    }

    /**
     * 
     * @param workhistory
     *     The workhistory
     */
    @JsonProperty("workhistory")
    public void setWorkhistory(String workhistory) {
        this.workhistory = workhistory;
    }

    /**
     * 
     * @return
     *     The reference
     */
    @JsonProperty("reference")
    public String getReference() {
        return reference;
    }

    /**
     * 
     * @param reference
     *     The reference
     */
    @JsonProperty("reference")
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * 
     * @return
     *     The education
     */
    @JsonProperty("education")
    public String getEducation() {
        return education;
    }

    /**
     * 
     * @param education
     *     The education
     */
    @JsonProperty("education")
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 
     * @return
     *     The residence
     */
    @JsonProperty("residence")
    public String getResidence() {
        return residence;
    }

    /**
     * 
     * @param residence
     *     The residence
     */
    @JsonProperty("residence")
    public void setResidence(String residence) {
        this.residence = residence;
    }

    /**
     * 
     * @return
     *     The certificate
     */
    @JsonProperty("certificate")
    public String getCertificate() {
        return certificate;
    }

    /**
     * 
     * @param certificate
     *     The certificate
     */
    @JsonProperty("certificate")
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    /**
     * 
     * @return
     *     The packets
     */
    @JsonProperty("packets")
    public String getPackets() {
        return packets;
    }

    /**
     * 
     * @param packets
     *     The packets
     */
    @JsonProperty("packets")
    public void setPackets(String packets) {
        this.packets = packets;
    }

    /**
     * 
     * @return
     *     The comment
     */
    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    /**
     * 
     * @param comment
     *     The comment
     */
    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 
     * @return
     *     The historylog
     */
    @JsonProperty("historylog")
    public String getHistorylog() {
        return historylog;
    }

    /**
     * 
     * @param historylog
     *     The historylog
     */
    @JsonProperty("historylog")
    public void setHistorylog(String historylog) {
        this.historylog = historylog;
    }

    /**
     * 
     * @return
     *     The contactlog
     */
    @JsonProperty("contactlog")
    public String getContactlog() {
        return contactlog;
    }

    /**
     * 
     * @param contactlog
     *     The contactlog
     */
    @JsonProperty("contactlog")
    public void setContactlog(String contactlog) {
        this.contactlog = contactlog;
    }

   
}
