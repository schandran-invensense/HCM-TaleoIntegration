
package com.invensense.taleo.employee;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("department")
    public String getDepartment() {
        return department;
    }

    @JsonProperty("department")
    public void setDepartment(String department) {
        this.department = department;
    }

    @JsonProperty("division")
    public String getDivision() {
        return division;
    }

    @JsonProperty("division")
    public void setDivision(String division) {
        this.division = division;
    }

    @JsonProperty("reportsIndirectly")
    public String getReportsIndirectly() {
        return reportsIndirectly;
    }

    @JsonProperty("reportsIndirectly")
    public void setReportsIndirectly(String reportsIndirectly) {
        this.reportsIndirectly = reportsIndirectly;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("offBoardStatus")
    public String getOffBoardStatus() {
        return offBoardStatus;
    }

    @JsonProperty("offBoardStatus")
    public void setOffBoardStatus(String offBoardStatus) {
        this.offBoardStatus = offBoardStatus;
    }

    @JsonProperty("onBoardStatus")
    public String getOnBoardStatus() {
        return onBoardStatus;
    }

    @JsonProperty("onBoardStatus")
    public void setOnBoardStatus(String onBoardStatus) {
        this.onBoardStatus = onBoardStatus;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("workhistory")
    public String getWorkhistory() {
        return workhistory;
    }

    @JsonProperty("workhistory")
    public void setWorkhistory(String workhistory) {
        this.workhistory = workhistory;
    }

    @JsonProperty("reference")
    public String getReference() {
        return reference;
    }

    @JsonProperty("reference")
    public void setReference(String reference) {
        this.reference = reference;
    }

    @JsonProperty("education")
    public String getEducation() {
        return education;
    }

    @JsonProperty("education")
    public void setEducation(String education) {
        this.education = education;
    }

    @JsonProperty("residence")
    public String getResidence() {
        return residence;
    }

    @JsonProperty("residence")
    public void setResidence(String residence) {
        this.residence = residence;
    }

    @JsonProperty("certificate")
    public String getCertificate() {
        return certificate;
    }

    @JsonProperty("certificate")
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @JsonProperty("packets")
    public String getPackets() {
        return packets;
    }

    @JsonProperty("packets")
    public void setPackets(String packets) {
        this.packets = packets;
    }

    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    @JsonProperty("historylog")
    public String getHistorylog() {
        return historylog;
    }

    @JsonProperty("historylog")
    public void setHistorylog(String historylog) {
        this.historylog = historylog;
    }

    @JsonProperty("contactlog")
    public String getContactlog() {
        return contactlog;
    }

    @JsonProperty("contactlog")
    public void setContactlog(String contactlog) {
        this.contactlog = contactlog;
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
