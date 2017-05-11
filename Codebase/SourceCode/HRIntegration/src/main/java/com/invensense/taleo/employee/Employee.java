
package com.invensense.taleo.employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
    "Fusion_Person_ID",
    "fusionIntegrationStatus",
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
    private String businessUnit;
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
    @JsonProperty("division")
    private List<Object> division = null;
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
    @JsonProperty("Fusion_Person_ID")
    private String fusionPersonID;
    @JsonProperty("fusionIntegrationStatus")
    private String fusionIntegrationStatus;
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
    @JsonProperty("reportsIndirectly")
    private List<Object> reportsIndirectly = null;
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
    @JsonProperty("region")
    private List<Object> region = null;
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
    private Object state;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("stockOptions")
    private String stockOptions;
    @JsonProperty("address2")
    private String address2;
    @JsonProperty("nameSuffix")
    private String nameSuffix;
    @JsonProperty("veteran")
    private List<Object> veteran = null;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("relationshipUrls")
    private RelationshipUrls relationshipUrls;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("emplAcceptedOfferId")
    public Object getEmplAcceptedOfferId() {
        return emplAcceptedOfferId;
    }

    @JsonProperty("emplAcceptedOfferId")
    public void setEmplAcceptedOfferId(Object emplAcceptedOfferId) {
        this.emplAcceptedOfferId = emplAcceptedOfferId;
    }

    @JsonProperty("ssoLoginOnly")
    public Boolean getSsoLoginOnly() {
        return ssoLoginOnly;
    }

    @JsonProperty("ssoLoginOnly")
    public void setSsoLoginOnly(Boolean ssoLoginOnly) {
        this.ssoLoginOnly = ssoLoginOnly;
    }

    @JsonProperty("creationDate")
    public String getCreationDate() {
        return creationDate;
    }

    @JsonProperty("creationDate")
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("Business_Unit")
    public String getBusinessUnit() {
        return businessUnit;
    }

    @JsonProperty("Business_Unit")
    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    @JsonProperty("candidate")
    public Object getCandidate() {
        return candidate;
    }

    @JsonProperty("candidate")
    public void setCandidate(Object candidate) {
        this.candidate = candidate;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("county")
    public String getCounty() {
        return county;
    }

    @JsonProperty("county")
    public void setCounty(String county) {
        this.county = county;
    }

    @JsonProperty("birthdate")
    public String getBirthdate() {
        return birthdate;
    }

    @JsonProperty("birthdate")
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @JsonProperty("department")
    public Integer getDepartment() {
        return department;
    }

    @JsonProperty("department")
    public void setDepartment(Integer department) {
        this.department = department;
    }

    @JsonProperty("division")
    public List<Object> getDivision() {
        return division;
    }

    @JsonProperty("division")
    public void setDivision(List<Object> division) {
        this.division = division;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("numberOfReports")
    public Integer getNumberOfReports() {
        return numberOfReports;
    }

    @JsonProperty("numberOfReports")
    public void setNumberOfReports(Integer numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    @JsonProperty("numberOfSubordinates")
    public Integer getNumberOfSubordinates() {
        return numberOfSubordinates;
    }

    @JsonProperty("numberOfSubordinates")
    public void setNumberOfSubordinates(Integer numberOfSubordinates) {
        this.numberOfSubordinates = numberOfSubordinates;
    }

    @JsonProperty("employeeNumber")
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    @JsonProperty("employeeNumber")
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @JsonProperty("emplIsActiveStatus")
    public Boolean getEmplIsActiveStatus() {
        return emplIsActiveStatus;
    }

    @JsonProperty("emplIsActiveStatus")
    public void setEmplIsActiveStatus(Boolean emplIsActiveStatus) {
        this.emplIsActiveStatus = emplIsActiveStatus;
    }

    @JsonProperty("lockedFromEws")
    public Boolean getLockedFromEws() {
        return lockedFromEws;
    }

    @JsonProperty("lockedFromEws")
    public void setLockedFromEws(Boolean lockedFromEws) {
        this.lockedFromEws = lockedFromEws;
    }

    @JsonProperty("Employee_Role")
    public String getEmployeeRole() {
        return employeeRole;
    }

    @JsonProperty("Employee_Role")
    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    @JsonProperty("ewsLogin")
    public String getEwsLogin() {
        return ewsLogin;
    }

    @JsonProperty("ewsLogin")
    public void setEwsLogin(String ewsLogin) {
        this.ewsLogin = ewsLogin;
    }

    @JsonProperty("ewsPassword")
    public String getEwsPassword() {
        return ewsPassword;
    }

    @JsonProperty("ewsPassword")
    public void setEwsPassword(String ewsPassword) {
        this.ewsPassword = ewsPassword;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("emplPosEndDate")
    public Object getEmplPosEndDate() {
        return emplPosEndDate;
    }

    @JsonProperty("emplPosEndDate")
    public void setEmplPosEndDate(Object emplPosEndDate) {
        this.emplPosEndDate = emplPosEndDate;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("Fusion_Assignment_ID")
    public String getFusionAssignmentID() {
        return fusionAssignmentID;
    }

    @JsonProperty("Fusion_Assignment_ID")
    public void setFusionAssignmentID(String fusionAssignmentID) {
        this.fusionAssignmentID = fusionAssignmentID;
    }

    @JsonProperty("Fusion_Person_ID")
    public String getFusionPersonID() {
        return fusionPersonID;
    }

    @JsonProperty("Fusion_Person_ID")
    public void setFusionPersonID(String fusionPersonID) {
        this.fusionPersonID = fusionPersonID;
    }

    @JsonProperty("fusionIntegrationStatus")
    public String getFusionIntegrationStatus() {
        return fusionIntegrationStatus;
    }

    @JsonProperty("fusionIntegrationStatus")
    public void setFusionIntegrationStatus(String fusionIntegrationStatus) {
        this.fusionIntegrationStatus = fusionIntegrationStatus;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("Grade")
    public String getGrade() {
        return grade;
    }

    @JsonProperty("Grade")
    public void setGrade(String grade) {
        this.grade = grade;
    }

    @JsonProperty("fusionEmployeeNumber")
    public String getFusionEmployeeNumber() {
        return fusionEmployeeNumber;
    }

    @JsonProperty("fusionEmployeeNumber")
    public void setFusionEmployeeNumber(String fusionEmployeeNumber) {
        this.fusionEmployeeNumber = fusionEmployeeNumber;
    }

    @JsonProperty("hiredForReqId")
    public Object getHiredForReqId() {
        return hiredForReqId;
    }

    @JsonProperty("hiredForReqId")
    public void setHiredForReqId(Object hiredForReqId) {
        this.hiredForReqId = hiredForReqId;
    }

    @JsonProperty("hiredForReqJobCode")
    public String getHiredForReqJobCode() {
        return hiredForReqJobCode;
    }

    @JsonProperty("hiredForReqJobCode")
    public void setHiredForReqJobCode(String hiredForReqJobCode) {
        this.hiredForReqJobCode = hiredForReqJobCode;
    }

    @JsonProperty("hiredForReqTitle")
    public String getHiredForReqTitle() {
        return hiredForReqTitle;
    }

    @JsonProperty("hiredForReqTitle")
    public void setHiredForReqTitle(String hiredForReqTitle) {
        this.hiredForReqTitle = hiredForReqTitle;
    }

    @JsonProperty("hourlyWage")
    public String getHourlyWage() {
        return hourlyWage;
    }

    @JsonProperty("hourlyWage")
    public void setHourlyWage(String hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @JsonProperty("employeeId")
    public Integer getEmployeeId() {
        return employeeId;
    }

    @JsonProperty("employeeId")
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @JsonProperty("reportsIndirectly")
    public List<Object> getReportsIndirectly() {
        return reportsIndirectly;
    }

    @JsonProperty("reportsIndirectly")
    public void setReportsIndirectly(List<Object> reportsIndirectly) {
        this.reportsIndirectly = reportsIndirectly;
    }

    @JsonProperty("IndividualWithDisability")
    public String getIndividualWithDisability() {
        return individualWithDisability;
    }

    @JsonProperty("IndividualWithDisability")
    public void setIndividualWithDisability(String individualWithDisability) {
        this.individualWithDisability = individualWithDisability;
    }

    @JsonProperty("activeEmplPosition")
    public Boolean getActiveEmplPosition() {
        return activeEmplPosition;
    }

    @JsonProperty("activeEmplPosition")
    public void setActiveEmplPosition(Boolean activeEmplPosition) {
        this.activeEmplPosition = activeEmplPosition;
    }

    @JsonProperty("jobCode")
    public String getJobCode() {
        return jobCode;
    }

    @JsonProperty("jobCode")
    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    @JsonProperty("jobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    @JsonProperty("jobTitle")
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @JsonProperty("lastDayDate")
    public Object getLastDayDate() {
        return lastDayDate;
    }

    @JsonProperty("lastDayDate")
    public void setLastDayDate(Object lastDayDate) {
        this.lastDayDate = lastDayDate;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonProperty("Legal_entity")
    public String getLegalEntity() {
        return legalEntity;
    }

    @JsonProperty("Legal_entity")
    public void setLegalEntity(String legalEntity) {
        this.legalEntity = legalEntity;
    }

    @JsonProperty("Legislation_Code")
    public String getLegislationCode() {
        return legislationCode;
    }

    @JsonProperty("Legislation_Code")
    public void setLegislationCode(String legislationCode) {
        this.legislationCode = legislationCode;
    }

    @JsonProperty("licenseNumber")
    public String getLicenseNumber() {
        return licenseNumber;
    }

    @JsonProperty("licenseNumber")
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @JsonProperty("location")
    public Integer getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Integer location) {
        this.location = location;
    }

    @JsonProperty("manager")
    public Object getManager() {
        return manager;
    }

    @JsonProperty("manager")
    public void setManager(Object manager) {
        this.manager = manager;
    }

    @JsonProperty("maritalStatus")
    public String getMaritalStatus() {
        return maritalStatus;
    }

    @JsonProperty("maritalStatus")
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @JsonProperty("middleInitial")
    public String getMiddleInitial() {
        return middleInitial;
    }

    @JsonProperty("middleInitial")
    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    @JsonProperty("cellPhone")
    public String getCellPhone() {
        return cellPhone;
    }

    @JsonProperty("cellPhone")
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @JsonProperty("nsuiteEmployeeNumber")
    public String getNsuiteEmployeeNumber() {
        return nsuiteEmployeeNumber;
    }

    @JsonProperty("nsuiteEmployeeNumber")
    public void setNsuiteEmployeeNumber(String nsuiteEmployeeNumber) {
        this.nsuiteEmployeeNumber = nsuiteEmployeeNumber;
    }

    @JsonProperty("nsuiteIntegrationStatus")
    public String getNsuiteIntegrationStatus() {
        return nsuiteIntegrationStatus;
    }

    @JsonProperty("nsuiteIntegrationStatus")
    public void setNsuiteIntegrationStatus(String nsuiteIntegrationStatus) {
        this.nsuiteIntegrationStatus = nsuiteIntegrationStatus;
    }

    @JsonProperty("offBoardStatus")
    public Integer getOffBoardStatus() {
        return offBoardStatus;
    }

    @JsonProperty("offBoardStatus")
    public void setOffBoardStatus(Integer offBoardStatus) {
        this.offBoardStatus = offBoardStatus;
    }

    @JsonProperty("hiredDate")
    public String getHiredDate() {
        return hiredDate;
    }

    @JsonProperty("hiredDate")
    public void setHiredDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }

    @JsonProperty("onBoardStatus")
    public Integer getOnBoardStatus() {
        return onBoardStatus;
    }

    @JsonProperty("onBoardStatus")
    public void setOnBoardStatus(Integer onBoardStatus) {
        this.onBoardStatus = onBoardStatus;
    }

    @JsonProperty("emplEmailRequired")
    public Boolean getEmplEmailRequired() {
        return emplEmailRequired;
    }

    @JsonProperty("emplEmailRequired")
    public void setEmplEmailRequired(Boolean emplEmailRequired) {
        this.emplEmailRequired = emplEmailRequired;
    }

    @JsonProperty("passportNumber")
    public String getPassportNumber() {
        return passportNumber;
    }

    @JsonProperty("passportNumber")
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @JsonProperty("payFrequency")
    public String getPayFrequency() {
        return payFrequency;
    }

    @JsonProperty("payFrequency")
    public void setPayFrequency(String payFrequency) {
        this.payFrequency = payFrequency;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("position")
    public String getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(String position) {
        this.position = position;
    }

    @JsonProperty("preferredLocale")
    public String getPreferredLocale() {
        return preferredLocale;
    }

    @JsonProperty("preferredLocale")
    public void setPreferredLocale(String preferredLocale) {
        this.preferredLocale = preferredLocale;
    }

    @JsonProperty("preferredTalentCenter")
    public String getPreferredTalentCenter() {
        return preferredTalentCenter;
    }

    @JsonProperty("preferredTalentCenter")
    public void setPreferredTalentCenter(String preferredTalentCenter) {
        this.preferredTalentCenter = preferredTalentCenter;
    }

    @JsonProperty("employeePicture")
    public Object getEmployeePicture() {
        return employeePicture;
    }

    @JsonProperty("employeePicture")
    public void setEmployeePicture(Object employeePicture) {
        this.employeePicture = employeePicture;
    }

    @JsonProperty("race")
    public String getRace() {
        return race;
    }

    @JsonProperty("race")
    public void setRace(String race) {
        this.race = race;
    }

    @JsonProperty("region")
    public List<Object> getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(List<Object> region) {
        this.region = region;
    }

    @JsonProperty("religion")
    public String getReligion() {
        return religion;
    }

    @JsonProperty("religion")
    public void setReligion(String religion) {
        this.religion = religion;
    }

    @JsonProperty("resignedDate")
    public Object getResignedDate() {
        return resignedDate;
    }

    @JsonProperty("resignedDate")
    public void setResignedDate(Object resignedDate) {
        this.resignedDate = resignedDate;
    }

    @JsonProperty("reviewApprover")
    public Object getReviewApprover() {
        return reviewApprover;
    }

    @JsonProperty("reviewApprover")
    public void setReviewApprover(Object reviewApprover) {
        this.reviewApprover = reviewApprover;
    }

    @JsonProperty("salary")
    public String getSalary() {
        return salary;
    }

    @JsonProperty("salary")
    public void setSalary(String salary) {
        this.salary = salary;
    }

    @JsonProperty("salaryGrade")
    public String getSalaryGrade() {
        return salaryGrade;
    }

    @JsonProperty("salaryGrade")
    public void setSalaryGrade(String salaryGrade) {
        this.salaryGrade = salaryGrade;
    }

    @JsonProperty("salutation")
    public String getSalutation() {
        return salutation;
    }

    @JsonProperty("salutation")
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    @JsonProperty("ssn")
    public String getSsn() {
        return ssn;
    }

    @JsonProperty("ssn")
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("emplPosStartDate")
    public Object getEmplPosStartDate() {
        return emplPosStartDate;
    }

    @JsonProperty("emplPosStartDate")
    public void setEmplPosStartDate(Object emplPosStartDate) {
        this.emplPosStartDate = emplPosStartDate;
    }

    @JsonProperty("state")
    public Object getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(Object state) {
        this.state = state;
    }

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("stockOptions")
    public String getStockOptions() {
        return stockOptions;
    }

    @JsonProperty("stockOptions")
    public void setStockOptions(String stockOptions) {
        this.stockOptions = stockOptions;
    }

    @JsonProperty("address2")
    public String getAddress2() {
        return address2;
    }

    @JsonProperty("address2")
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @JsonProperty("nameSuffix")
    public String getNameSuffix() {
        return nameSuffix;
    }

    @JsonProperty("nameSuffix")
    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    @JsonProperty("veteran")
    public List<Object> getVeteran() {
        return veteran;
    }

    @JsonProperty("veteran")
    public void setVeteran(List<Object> veteran) {
        this.veteran = veteran;
    }

    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

    @JsonProperty("zipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @JsonProperty("relationshipUrls")
    public RelationshipUrls getRelationshipUrls() {
        return relationshipUrls;
    }

    @JsonProperty("relationshipUrls")
    public void setRelationshipUrls(RelationshipUrls relationshipUrls) {
        this.relationshipUrls = relationshipUrls;
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
