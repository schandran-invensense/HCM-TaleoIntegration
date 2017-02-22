
package com.invensense.model.taleo;

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
    "emplAcceptedOfferId",
    "ssoLoginOnly",
    "creationDate",
    "address",
    "Business_Unit",
    "candidate",
    "city",
    "country",
    "county",
    "birthdate",
    "department",
    "division",
    "email",
    "numberOfReports",
    "numberOfSubordinates",
    "employeeNumber",
    "emplIsActiveStatus",
    "lockedFromEws",
    "Employee_Role",
    "ewsLogin",
    "ewsPassword",
    "duration",
    "emplPosEndDate",
    "firstName",
    "Fusion_Assignment_ID",
    "fusionIntegrationStatus",
    "Fusion_Person_ID",
    "gender",
    "Grade",
    "fusionEmployeeNumber",
    "hiredForReqId",
    "hiredForReqJobCode",
    "hiredForReqTitle",
    "hourlyWage",
    "employeeId",
    "reportsIndirectly",
    "IndividualWithDisability",
    "activeEmplPosition",
    "jobCode",
    "jobTitle",
    "lastDayDate",
    "lastName",
    "lastUpdated",
    "Legal_entity",
    "Legislation_Code",
    "licenseNumber",
    "location",
    "manager",
    "maritalStatus",
    "middleInitial",
    "cellPhone",
    "nsuiteEmployeeNumber",
    "nsuiteIntegrationStatus",
    "offBoardStatus",
    "hiredDate",
    "onBoardStatus",
    "emplEmailRequired",
    "passportNumber",
    "payFrequency",
    "phone",
    "position",
    "preferredLocale",
    "preferredTalentCenter",
    "employeePicture",
    "race",
    "region",
    "religion",
    "resignedDate",
    "reviewApprover",
    "salary",
    "salaryGrade",
    "salutation",
    "ssn",
    "startDate",
    "emplPosStartDate",
    "state",
    "status",
    "stockOptions",
    "address2",
    "nameSuffix",
    "veteran",
    "zipCode",
    "relationshipUrls"
})
public class Employee {

    @JsonProperty("emplAcceptedOfferId")
    private Object emplAcceptedOfferId;
    @JsonProperty("ssoLoginOnly")
    private Boolean ssoLoginOnly;
    @JsonProperty("creationDate")
    private String creationDate;
    @JsonProperty("address")
    private String address;
    @JsonProperty("Business_Unit")
    private String Business_Unit;
    @JsonProperty("candidate")
    private Object candidate;
    @JsonProperty("city")
    private String city;
    @JsonProperty("country")
    private String country;
    @JsonProperty("county")
    private String county;
    @JsonProperty("birthdate")
    private String birthdate;
    @JsonProperty("department")
    private Integer department;
    @JsonProperty("email")
    private String email;
    @JsonProperty("numberOfReports")
    private Integer numberOfReports;
    @JsonProperty("numberOfSubordinates")
    private Integer numberOfSubordinates;
    @JsonProperty("employeeNumber")
    private String employeeNumber;
    @JsonProperty("emplIsActiveStatus")
    private Boolean emplIsActiveStatus;
    @JsonProperty("lockedFromEws")
    private Boolean lockedFromEws;
    @JsonProperty("Employee_Role")
    private String employeeRole;
    @JsonProperty("ewsLogin")
    private String ewsLogin;
    @JsonProperty("ewsPassword")
    private String ewsPassword;
    @JsonProperty("duration")
    private String duration; 

	@JsonProperty("emplPosEndDate")
    private Object emplPosEndDate;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("Fusion_Assignment_ID")
    private String fusionAssignmentID;
    @JsonProperty("fusionIntegrationStatus")
    private String fusionIntegrationStatus;
    @JsonProperty("Fusion_Person_ID")
    private String fusionPersonID;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("Grade")
    private String grade;
    @JsonProperty("fusionEmployeeNumber")
    private String fusionEmployeeNumber;
    @JsonProperty("hiredForReqId")
    private Object hiredForReqId;
    @JsonProperty("hiredForReqJobCode")
    private String hiredForReqJobCode;
    @JsonProperty("hiredForReqTitle")
    private String hiredForReqTitle;
    @JsonProperty("hourlyWage")
    private String hourlyWage;
    @JsonProperty("employeeId")
    private Integer employeeId;
    @JsonProperty("IndividualWithDisability")
    private String individualWithDisability;
    @JsonProperty("activeEmplPosition")
    private Boolean activeEmplPosition;
    @JsonProperty("jobCode")
    private String jobCode;
    @JsonProperty("jobTitle")
    private String jobTitle;
    @JsonProperty("lastDayDate")
    private Object lastDayDate;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("Legal_entity")
    private String legalEntity;
    @JsonProperty("Legislation_Code")
    private String legislationCode;
    @JsonProperty("licenseNumber")
    private String licenseNumber;
    @JsonProperty("location")
    private Integer location;
    @JsonProperty("manager")
    private Object manager;
    @JsonProperty("maritalStatus")
    private String maritalStatus;
    @JsonProperty("middleInitial")
    private String middleInitial;
    @JsonProperty("cellPhone")
    private String cellPhone;
    @JsonProperty("nsuiteEmployeeNumber")
    private String nsuiteEmployeeNumber;
    @JsonProperty("nsuiteIntegrationStatus")
    private String nsuiteIntegrationStatus;
    @JsonProperty("offBoardStatus")
    private Integer offBoardStatus;
    @JsonProperty("hiredDate")
    private String hiredDate;
    @JsonProperty("onBoardStatus")
    private Integer onBoardStatus;
    @JsonProperty("emplEmailRequired")
    private Boolean emplEmailRequired;
    @JsonProperty("passportNumber")
    private String passportNumber;
    @JsonProperty("payFrequency")
    private String payFrequency;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("position")
    private String position;
    @JsonProperty("preferredLocale")
    private String preferredLocale;
    @JsonProperty("preferredTalentCenter")
    private String preferredTalentCenter;
    @JsonProperty("employeePicture")
    private Object employeePicture;
    @JsonProperty("race")
    private String race;
    @JsonProperty("religion")
    private String religion;
    @JsonProperty("resignedDate")
    private Object resignedDate;
    @JsonProperty("reviewApprover")
    private Object reviewApprover;
    @JsonProperty("salary")
    private String salary;
    @JsonProperty("salaryGrade")
    private String salaryGrade;
    @JsonProperty("salutation")
    private String salutation;
    @JsonProperty("ssn")
    private String ssn;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("emplPosStartDate")
    private Object emplPosStartDate;
    @JsonProperty("state")
    private String state;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("stockOptions")
    private String stockOptions;
    @JsonProperty("address2")
    private String address2;
    @JsonProperty("nameSuffix")
    private String nameSuffix;
    @JsonProperty("zipCode")
    private String zipCode;
   
    /**
     * 
     * @return
     *     The emplAcceptedOfferId
     */
    @JsonProperty("emplAcceptedOfferId")
    public Object getEmplAcceptedOfferId() {
        return emplAcceptedOfferId;
    }
	/**
     * 
     * @param emplAcceptedOfferId
     *     The emplAcceptedOfferId
     */
    @JsonProperty("emplAcceptedOfferId")
    public void setEmplAcceptedOfferId(Object emplAcceptedOfferId) {
        this.emplAcceptedOfferId = emplAcceptedOfferId;
    }

    /**
     * 
     * @return
     *     The ssoLoginOnly
     */
    @JsonProperty("ssoLoginOnly")
    public Boolean getSsoLoginOnly() {
        return ssoLoginOnly;
    }

    /**
     * 
     * @param ssoLoginOnly
     *     The ssoLoginOnly
     */
    @JsonProperty("ssoLoginOnly")
    public void setSsoLoginOnly(Boolean ssoLoginOnly) {
        this.ssoLoginOnly = ssoLoginOnly;
    }

    /**
     * 
     * @return
     *     The creationDate
     */
    @JsonProperty("creationDate")
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * 
     * @param creationDate
     *     The creationDate
     */
    @JsonProperty("creationDate")
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * 
     * @return
     *     The address
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The businessUnit
     */
    @JsonProperty("Business_Unit")
    public String getBusiness_Unit() {
        return Business_Unit;
    }

    /**
     * 
     * @param businessUnit
     *     The Business_Unit
     */
    @JsonProperty("Business_Unit")
    public void setBusiness_Unit(String Business_Unit) {
        this.Business_Unit = Business_Unit;
    }

    /**
     * 
     * @return
     *     The candidate
     */
    @JsonProperty("candidate")
    public Object getCandidate() {
        return candidate;
    }

    /**
     * 
     * @param candidate
     *     The candidate
     */
    @JsonProperty("candidate")
    public void setCandidate(Object candidate) {
        this.candidate = candidate;
    }

    /**
     * 
     * @return
     *     The city
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The country
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The county
     */
    @JsonProperty("county")
    public String getCounty() {
        return county;
    }

    /**
     * 
     * @param county
     *     The county
     */
    @JsonProperty("county")
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * 
     * @return
     *     The birthdate
     */
    @JsonProperty("birthdate")
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * 
     * @param birthdate
     *     The birthdate
     */
    @JsonProperty("birthdate")
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * 
     * @return
     *     The department
     */
    @JsonProperty("department")
    public Integer getDepartment() {
        return department;
    }

    /**
     * 
     * @param department
     *     The department
     */
    @JsonProperty("department")
    public void setDepartment(Integer department) {
        this.department = department;
    }

    

    /**
     * 
     * @return
     *     The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The numberOfReports
     */
    @JsonProperty("numberOfReports")
    public Integer getNumberOfReports() {
        return numberOfReports;
    }

    /**
     * 
     * @param numberOfReports
     *     The numberOfReports
     */
    @JsonProperty("numberOfReports")
    public void setNumberOfReports(Integer numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    /**
     * 
     * @return
     *     The numberOfSubordinates
     */
    @JsonProperty("numberOfSubordinates")
    public Integer getNumberOfSubordinates() {
        return numberOfSubordinates;
    }

    /**
     * 
     * @param numberOfSubordinates
     *     The numberOfSubordinates
     */
    @JsonProperty("numberOfSubordinates")
    public void setNumberOfSubordinates(Integer numberOfSubordinates) {
        this.numberOfSubordinates = numberOfSubordinates;
    }

    /**
     * 
     * @return
     *     The employeeNumber
     */
    @JsonProperty("employeeNumber")
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * 
     * @param employeeNumber
     *     The employeeNumber
     */
    @JsonProperty("employeeNumber")
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * 
     * @return
     *     The emplIsActiveStatus
     */
    @JsonProperty("emplIsActiveStatus")
    public Boolean getEmplIsActiveStatus() {
        return emplIsActiveStatus;
    }

    /**
     * 
     * @param emplIsActiveStatus
     *     The emplIsActiveStatus
     */
    @JsonProperty("emplIsActiveStatus")
    public void setEmplIsActiveStatus(Boolean emplIsActiveStatus) {
        this.emplIsActiveStatus = emplIsActiveStatus;
    }

    /**
     * 
     * @return
     *     The lockedFromEws
     */
    @JsonProperty("lockedFromEws")
    public Boolean getLockedFromEws() {
        return lockedFromEws;
    }

    /**
     * 
     * @param lockedFromEws
     *     The lockedFromEws
     */
    @JsonProperty("lockedFromEws")
    public void setLockedFromEws(Boolean lockedFromEws) {
        this.lockedFromEws = lockedFromEws;
    }

    /**
     * 
     * @return
     *     The employeeRole
     */
    @JsonProperty("Employee_Role")
    public String getEmployeeRole() {
        return employeeRole;
    }

    /**
     * 
     * @param employeeRole
     *     The Employee_Role
     */
    @JsonProperty("Employee_Role")
    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    /**
     * 
     * @return
     *     The ewsLogin
     */
    @JsonProperty("ewsLogin")
    public String getEwsLogin() {
        return ewsLogin;
    }

    /**
     * 
     * @param ewsLogin
     *     The ewsLogin
     */
    @JsonProperty("ewsLogin")
    public void setEwsLogin(String ewsLogin) {
        this.ewsLogin = ewsLogin;
    }

    /**
     * 
     * @return
     *     The ewsPassword
     */
    @JsonProperty("ewsPassword")
    public String getEwsPassword() {
        return ewsPassword;
    }

    /**
     * 
     * @param ewsPassword
     *     The ewsPassword
     */
    @JsonProperty("ewsPassword")
    public void setEwsPassword(String ewsPassword) {
        this.ewsPassword = ewsPassword;
    }

    /**
     * 
     * @return
     *     The duration
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     * 
     * @param duration
     *     The duration
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * 
     * @return
     *     The emplPosEndDate
     */
    @JsonProperty("emplPosEndDate")
    public Object getEmplPosEndDate() {
        return emplPosEndDate;
    }

    /**
     * 
     * @param emplPosEndDate
     *     The emplPosEndDate
     */
    @JsonProperty("emplPosEndDate")
    public void setEmplPosEndDate(Object emplPosEndDate) {
        this.emplPosEndDate = emplPosEndDate;
    }

    /**
     * 
     * @return
     *     The firstName
     */
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The firstName
     */
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *     The fusionAssignmentID
     */
    @JsonProperty("Fusion_Assignment_ID")
    public String getFusionAssignmentID() {
        return fusionAssignmentID;
    }

    /**
     * 
     * @param fusionAssignmentID
     *     The Fusion_Assignment_ID
     */
    @JsonProperty("Fusion_Assignment_ID")
    public void setFusionAssignmentID(String fusionAssignmentID) {
        this.fusionAssignmentID = fusionAssignmentID;
    }

    /**
     * 
     * @return
     *     The fusionIntegrationStatus
     */
    @JsonProperty("fusionIntegrationStatus")
    public String getFusionIntegrationStatus() {
        return fusionIntegrationStatus;
    }

    /**
     * 
     * @param fusionIntegrationStatus
     *     The fusionIntegrationStatus
     */
    @JsonProperty("fusionIntegrationStatus")
    public void setFusionIntegrationStatus(String fusionIntegrationStatus) {
        this.fusionIntegrationStatus = fusionIntegrationStatus;
    }

    /**
     * 
     * @return
     *     The fusionPersonID
     */
    @JsonProperty("Fusion_Person_ID")
    public String getFusionPersonID() {
        return fusionPersonID;
    }

    /**
     * 
     * @param fusionPersonID
     *     The Fusion_Person_ID
     */
    @JsonProperty("Fusion_Person_ID")
    public void setFusionPersonID(String fusionPersonID) {
        this.fusionPersonID = fusionPersonID;
    }

    /**
     * 
     * @return
     *     The gender
     */
    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The grade
     */
    @JsonProperty("Grade")
    public String getGrade() {
        return grade;
    }

    /**
     * 
     * @param grade
     *     The Grade
     */
    @JsonProperty("Grade")
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 
     * @return
     *     The fusionEmployeeNumber
     */
    @JsonProperty("fusionEmployeeNumber")
    public String getFusionEmployeeNumber() {
        return fusionEmployeeNumber;
    }

    /**
     * 
     * @param fusionEmployeeNumber
     *     The fusionEmployeeNumber
     */
    @JsonProperty("fusionEmployeeNumber")
    public void setFusionEmployeeNumber(String fusionEmployeeNumber) {
        this.fusionEmployeeNumber = fusionEmployeeNumber;
    }

    /**
     * 
     * @return
     *     The hiredForReqId
     */
    @JsonProperty("hiredForReqId")
    public Object getHiredForReqId() {
        return hiredForReqId;
    }

    /**
     * 
     * @param hiredForReqId
     *     The hiredForReqId
     */
    @JsonProperty("hiredForReqId")
    public void setHiredForReqId(Object hiredForReqId) {
        this.hiredForReqId = hiredForReqId;
    }

    /**
     * 
     * @return
     *     The hiredForReqJobCode
     */
    @JsonProperty("hiredForReqJobCode")
    public String getHiredForReqJobCode() {
        return hiredForReqJobCode;
    }

    /**
     * 
     * @param hiredForReqJobCode
     *     The hiredForReqJobCode
     */
    @JsonProperty("hiredForReqJobCode")
    public void setHiredForReqJobCode(String hiredForReqJobCode) {
        this.hiredForReqJobCode = hiredForReqJobCode;
    }

    /**
     * 
     * @return
     *     The hiredForReqTitle
     */
    @JsonProperty("hiredForReqTitle")
    public String getHiredForReqTitle() {
        return hiredForReqTitle;
    }

    /**
     * 
     * @param hiredForReqTitle
     *     The hiredForReqTitle
     */
    @JsonProperty("hiredForReqTitle")
    public void setHiredForReqTitle(String hiredForReqTitle) {
        this.hiredForReqTitle = hiredForReqTitle;
    }

    /**
     * 
     * @return
     *     The hourlyWage
     */
    @JsonProperty("hourlyWage")
    public String getHourlyWage() {
        return hourlyWage;
    }

    /**
     * 
     * @param hourlyWage
     *     The hourlyWage
     */
    @JsonProperty("hourlyWage")
    public void setHourlyWage(String hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    /**
     * 
     * @return
     *     The employeeId
     */
    @JsonProperty("employeeId")
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * 
     * @param employeeId
     *     The employeeId
     */
    @JsonProperty("employeeId")
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    

    /**
     * 
     * @return
     *     The individualWithDisability
     */
    @JsonProperty("IndividualWithDisability")
    public String getIndividualWithDisability() {
        return individualWithDisability;
    }

    /**
     * 
     * @param individualWithDisability
     *     The IndividualWithDisability
     */
    @JsonProperty("IndividualWithDisability")
    public void setIndividualWithDisability(String individualWithDisability) {
        this.individualWithDisability = individualWithDisability;
    }

    /**
     * 
     * @return
     *     The activeEmplPosition
     */
    @JsonProperty("activeEmplPosition")
    public Boolean getActiveEmplPosition() {
        return activeEmplPosition;
    }

    /**
     * 
     * @param activeEmplPosition
     *     The activeEmplPosition
     */
    @JsonProperty("activeEmplPosition")
    public void setActiveEmplPosition(Boolean activeEmplPosition) {
        this.activeEmplPosition = activeEmplPosition;
    }

    /**
     * 
     * @return
     *     The jobCode
     */
    @JsonProperty("jobCode")
    public String getJobCode() {
        return jobCode;
    }

    /**
     * 
     * @param jobCode
     *     The jobCode
     */
    @JsonProperty("jobCode")
    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    /**
     * 
     * @return
     *     The jobTitle
     */
    @JsonProperty("jobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * 
     * @param jobTitle
     *     The jobTitle
     */
    @JsonProperty("jobTitle")
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * 
     * @return
     *     The lastDayDate
     */
    @JsonProperty("lastDayDate")
    public Object getLastDayDate() {
        return lastDayDate;
    }

    /**
     * 
     * @param lastDayDate
     *     The lastDayDate
     */
    @JsonProperty("lastDayDate")
    public void setLastDayDate(Object lastDayDate) {
        this.lastDayDate = lastDayDate;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The lastName
     */
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return
     *     The lastUpdated
     */
    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * 
     * @param lastUpdated
     *     The lastUpdated
     */
    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * 
     * @return
     *     The legalEntity
     */
    @JsonProperty("Legal_entity")
    public String getLegalEntity() {
        return legalEntity;
    }

    /**
     * 
     * @param legalEntity
     *     The Legal_entity
     */
    @JsonProperty("Legal_entity")
    public void setLegalEntity(String legalEntity) {
        this.legalEntity = legalEntity;
    }

    /**
     * 
     * @return
     *     The legislationCode
     */
    @JsonProperty("Legislation_Code")
    public String getLegislationCode() {
        return legislationCode;
    }

    /**
     * 
     * @param legislationCode
     *     The Legislation_Code
     */
    @JsonProperty("Legislation_Code")
    public void setLegislationCode(String legislationCode) {
        this.legislationCode = legislationCode;
    }

    /**
     * 
     * @return
     *     The licenseNumber
     */
    @JsonProperty("licenseNumber")
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * 
     * @param licenseNumber
     *     The licenseNumber
     */
    @JsonProperty("licenseNumber")
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * 
     * @return
     *     The location
     */
    @JsonProperty("location")
    public Integer getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    @JsonProperty("location")
    public void setLocation(Integer location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The manager
     */
    @JsonProperty("manager")
    public Object getManager() {
        return manager;
    }

    /**
     * 
     * @param manager
     *     The manager
     */
    @JsonProperty("manager")
    public void setManager(Object manager) {
        this.manager = manager;
    }

    /**
     * 
     * @return
     *     The maritalStatus
     */
    @JsonProperty("maritalStatus")
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * 
     * @param maritalStatus
     *     The maritalStatus
     */
    @JsonProperty("maritalStatus")
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * 
     * @return
     *     The middleInitial
     */
    @JsonProperty("middleInitial")
    public String getMiddleInitial() {
        return middleInitial;
    }

    /**
     * 
     * @param middleInitial
     *     The middleInitial
     */
    @JsonProperty("middleInitial")
    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    /**
     * 
     * @return
     *     The cellPhone
     */
    @JsonProperty("cellPhone")
    public String getCellPhone() {
        return cellPhone;
    }

    /**
     * 
     * @param cellPhone
     *     The cellPhone
     */
    @JsonProperty("cellPhone")
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    /**
     * 
     * @return
     *     The nsuiteEmployeeNumber
     */
    @JsonProperty("nsuiteEmployeeNumber")
    public String getNsuiteEmployeeNumber() {
        return nsuiteEmployeeNumber;
    }

    /**
     * 
     * @param nsuiteEmployeeNumber
     *     The nsuiteEmployeeNumber
     */
    @JsonProperty("nsuiteEmployeeNumber")
    public void setNsuiteEmployeeNumber(String nsuiteEmployeeNumber) {
        this.nsuiteEmployeeNumber = nsuiteEmployeeNumber;
    }

    /**
     * 
     * @return
     *     The nsuiteIntegrationStatus
     */
    @JsonProperty("nsuiteIntegrationStatus")
    public String getNsuiteIntegrationStatus() {
        return nsuiteIntegrationStatus;
    }

    /**
     * 
     * @param nsuiteIntegrationStatus
     *     The nsuiteIntegrationStatus
     */
    @JsonProperty("nsuiteIntegrationStatus")
    public void setNsuiteIntegrationStatus(String nsuiteIntegrationStatus) {
        this.nsuiteIntegrationStatus = nsuiteIntegrationStatus;
    }

    /**
     * 
     * @return
     *     The offBoardStatus
     */
    @JsonProperty("offBoardStatus")
    public Integer getOffBoardStatus() {
        return offBoardStatus;
    }

    /**
     * 
     * @param offBoardStatus
     *     The offBoardStatus
     */
    @JsonProperty("offBoardStatus")
    public void setOffBoardStatus(Integer offBoardStatus) {
        this.offBoardStatus = offBoardStatus;
    }

    /**
     * 
     * @return
     *     The hiredDate
     */
    @JsonProperty("hiredDate")
    public String getHiredDate() {
        return hiredDate;
    }

    /**
     * 
     * @param hiredDate
     *     The hiredDate
     */
    @JsonProperty("hiredDate")
    public void setHiredDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }

    /**
     * 
     * @return
     *     The onBoardStatus
     */
    @JsonProperty("onBoardStatus")
    public Integer getOnBoardStatus() {
        return onBoardStatus;
    }

    /**
     * 
     * @param onBoardStatus
     *     The onBoardStatus
     */
    @JsonProperty("onBoardStatus")
    public void setOnBoardStatus(Integer onBoardStatus) {
        this.onBoardStatus = onBoardStatus;
    }

    /**
     * 
     * @return
     *     The emplEmailRequired
     */
    @JsonProperty("emplEmailRequired")
    public Boolean getEmplEmailRequired() {
        return emplEmailRequired;
    }

    /**
     * 
     * @param emplEmailRequired
     *     The emplEmailRequired
     */
    @JsonProperty("emplEmailRequired")
    public void setEmplEmailRequired(Boolean emplEmailRequired) {
        this.emplEmailRequired = emplEmailRequired;
    }

    /**
     * 
     * @return
     *     The passportNumber
     */
    @JsonProperty("passportNumber")
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * 
     * @param passportNumber
     *     The passportNumber
     */
    @JsonProperty("passportNumber")
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    /**
     * 
     * @return
     *     The payFrequency
     */
    @JsonProperty("payFrequency")
    public String getPayFrequency() {
        return payFrequency;
    }

    /**
     * 
     * @param payFrequency
     *     The payFrequency
     */
    @JsonProperty("payFrequency")
    public void setPayFrequency(String payFrequency) {
        this.payFrequency = payFrequency;
    }

    /**
     * 
     * @return
     *     The phone
     */
    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return
     *     The position
     */
    @JsonProperty("position")
    public String getPosition() {
        return position;
    }

    /**
     * 
     * @param position
     *     The position
     */
    @JsonProperty("position")
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 
     * @return
     *     The preferredLocale
     */
    @JsonProperty("preferredLocale")
    public String getPreferredLocale() {
        return preferredLocale;
    }

    /**
     * 
     * @param preferredLocale
     *     The preferredLocale
     */
    @JsonProperty("preferredLocale")
    public void setPreferredLocale(String preferredLocale) {
        this.preferredLocale = preferredLocale;
    }

    /**
     * 
     * @return
     *     The preferredTalentCenter
     */
    @JsonProperty("preferredTalentCenter")
    public String getPreferredTalentCenter() {
        return preferredTalentCenter;
    }

    /**
     * 
     * @param preferredTalentCenter
     *     The preferredTalentCenter
     */
    @JsonProperty("preferredTalentCenter")
    public void setPreferredTalentCenter(String preferredTalentCenter) {
        this.preferredTalentCenter = preferredTalentCenter;
    }

    /**
     * 
     * @return
     *     The employeePicture
     */
    @JsonProperty("employeePicture")
    public Object getEmployeePicture() {
        return employeePicture;
    }

    /**
     * 
     * @param employeePicture
     *     The employeePicture
     */
    @JsonProperty("employeePicture")
    public void setEmployeePicture(Object employeePicture) {
        this.employeePicture = employeePicture;
    }

    /**
     * 
     * @return
     *     The race
     */
    @JsonProperty("race")
    public String getRace() {
        return race;
    }

    /**
     * 
     * @param race
     *     The race
     */
    @JsonProperty("race")
    public void setRace(String race) {
        this.race = race;
    }

    

    /**
     * 
     * @return
     *     The religion
     */
    @JsonProperty("religion")
    public String getReligion() {
        return religion;
    }

    /**
     * 
     * @param religion
     *     The religion
     */
    @JsonProperty("religion")
    public void setReligion(String religion) {
        this.religion = religion;
    }

    /**
     * 
     * @return
     *     The resignedDate
     */
    @JsonProperty("resignedDate")
    public Object getResignedDate() {
        return resignedDate;
    }

    /**
     * 
     * @param resignedDate
     *     The resignedDate
     */
    @JsonProperty("resignedDate")
    public void setResignedDate(Object resignedDate) {
        this.resignedDate = resignedDate;
    }

    /**
     * 
     * @return
     *     The reviewApprover
     */
    @JsonProperty("reviewApprover")
    public Object getReviewApprover() {
        return reviewApprover;
    }

    /**
     * 
     * @param reviewApprover
     *     The reviewApprover
     */
    @JsonProperty("reviewApprover")
    public void setReviewApprover(Object reviewApprover) {
        this.reviewApprover = reviewApprover;
    }

    /**
     * 
     * @return
     *     The salary
     */
    @JsonProperty("salary")
    public String getSalary() {
        return salary;
    }

    /**
     * 
     * @param salary
     *     The salary
     */
    @JsonProperty("salary")
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * 
     * @return
     *     The salaryGrade
     */
    @JsonProperty("salaryGrade")
    public String getSalaryGrade() {
        return salaryGrade;
    }

    /**
     * 
     * @param salaryGrade
     *     The salaryGrade
     */
    @JsonProperty("salaryGrade")
    public void setSalaryGrade(String salaryGrade) {
        this.salaryGrade = salaryGrade;
    }

    /**
     * 
     * @return
     *     The salutation
     */
    @JsonProperty("salutation")
    public String getSalutation() {
        return salutation;
    }

    /**
     * 
     * @param salutation
     *     The salutation
     */
    @JsonProperty("salutation")
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    /**
     * 
     * @return
     *     The ssn
     */
    @JsonProperty("ssn")
    public String getSsn() {
        return ssn;
    }

    /**
     * 
     * @param ssn
     *     The ssn
     */
    @JsonProperty("ssn")
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * 
     * @return
     *     The startDate
     */
    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    /**
     * 
     * @param startDate
     *     The startDate
     */
    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * 
     * @return
     *     The emplPosStartDate
     */
    @JsonProperty("emplPosStartDate")
    public Object getEmplPosStartDate() {
        return emplPosStartDate;
    }

    /**
     * 
     * @param emplPosStartDate
     *     The emplPosStartDate
     */
    @JsonProperty("emplPosStartDate")
    public void setEmplPosStartDate(Object emplPosStartDate) {
        this.emplPosStartDate = emplPosStartDate;
    }

    /**
     * 
     * @return
     *     The state
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The stockOptions
     */
    @JsonProperty("stockOptions")
    public String getStockOptions() {
        return stockOptions;
    }

    /**
     * 
     * @param stockOptions
     *     The stockOptions
     */
    @JsonProperty("stockOptions")
    public void setStockOptions(String stockOptions) {
        this.stockOptions = stockOptions;
    }

    /**
     * 
     * @return
     *     The address2
     */
    @JsonProperty("address2")
    public String getAddress2() {
        return address2;
    }

    /**
     * 
     * @param address2
     *     The address2
     */
    @JsonProperty("address2")
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * 
     * @return
     *     The nameSuffix
     */
    @JsonProperty("nameSuffix")
    public String getNameSuffix() {
        return nameSuffix;
    }

    /**
     * 
     * @param nameSuffix
     *     The nameSuffix
     */
    @JsonProperty("nameSuffix")
    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }


    /**
     * 
     * @return
     *     The zipCode
     */
    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 
     * @param zipCode
     *     The zipCode
     */
    @JsonProperty("zipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

   

}
