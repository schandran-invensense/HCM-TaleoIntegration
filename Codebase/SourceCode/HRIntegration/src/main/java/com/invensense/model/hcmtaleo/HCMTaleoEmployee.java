package com.invensense.model.hcmtaleo;

public class HCMTaleoEmployee {
	
	private String hcmPersonId;
	private String hcmPersonNumber;
	private String hcmPersonName;
	private String employeeId;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;

	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String ssn;
	private String dateOfBirth;
	private String maritalStatus;

	
	private String nameInformation;
	private String emailAddress;
	private String workEmail;
	private String startDate;
	private String managerId;
	private String managerPersonNo;
	
	private String region;
	private String city;
	private String postalCode;
	private String country;
	private String county;
	private String state;
	private String hcmState;
	private String address2;
	private String actualTerminationDate;
	private String businessUnit;
	private String hcmBusinessUnit;
	private int department;
	private String legalEntity;
	private String hcmLegalEntity;
	private String grade;
		
	private String roleName;
	private String assignmentName;
	private String phoneNo;
	private int locationID;
	private String jobId;
	private String language;
	private String legislationCode;
	private String hcmLegislationCode;
	private String salutation;
	private String hireDate;
	 private String jobCode;
	 private String jobTitle;
	 private String position;
	private String projStartDate;
	
	private String fblPersonId;
	
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLegislationCode() {
		return legislationCode;
	}
	public void setLegislationCode(String legislationCode) {
		this.legislationCode = legislationCode;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public HCMTaleoEmployee(String firstName, String lastName, String emailAddress, String city, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.city = city;
		this.country = country;
	}
	public HCMTaleoEmployee() {
		// TODO Auto-generated constructor stub
	}
	public String getHcmPersonId() {
		return hcmPersonId;
	}
	public void setHcmPersonId(String hcmPersonId) {
		this.hcmPersonId = hcmPersonId;
	}
	public String getHcmPersonNumber() {
		return hcmPersonNumber;
	}
	public void setHcmPersonNumber(String hcmPersonNumber) {
		this.hcmPersonNumber = hcmPersonNumber;
	}
	public String getHcmPersonName() {
		return hcmPersonName;
	}
	public void setHcmPersonName(String hcmPersonName) {
		this.hcmPersonName = hcmPersonName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNameInformation() {
		return nameInformation;
	}
	public void setNameInformation(String nameInformation) {
		this.nameInformation = nameInformation;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getWorkEmail() {
		return workEmail;
	}
	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getActualTerminationDate() {
		return actualTerminationDate;
	}
	public void setActualTerminationDate(String actualTerminationDate) {
		this.actualTerminationDate = actualTerminationDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerPersonNo() {
		return managerPersonNo;
	}
	public void setManagerPersonNo(String managerPersonNo) {
		this.managerPersonNo = managerPersonNo;
	}	
	public String getLegalEntity() {
		return legalEntity;
	}
	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}	
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getAssignmentName() {
		return assignmentName;
	}
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getHcmLegalEntity() {
		return hcmLegalEntity;
	}
	public void setHcmLegalEntity(String hcmLegalEntity) {
		this.hcmLegalEntity = hcmLegalEntity;
	}
	public String getHcmLegislationCode() {
		return hcmLegislationCode;
	}
	public void setHcmLegislationCode(String hcmLegislationCode) {
		this.hcmLegislationCode = hcmLegislationCode;
	}
	public String getHcmBusinessUnit() {
		return hcmBusinessUnit;
	}
	public void setHcmBusinessUnit(String hcmBusinessUnit) {
		this.hcmBusinessUnit = hcmBusinessUnit;
	}
	public String getHcmState() {
		return hcmState;
	}
	public void setHcmState(String hcmState) {
		this.hcmState = hcmState;
	}
	public String getProjStartDate() {
		return projStartDate;
	}
	public void setProjStartDate(String projStartDate) {
		this.projStartDate = projStartDate;
	}
	public String getFblPersonId() {
		return fblPersonId;
	}
	public void setFblPersonId(String fblPersonId) {
		this.fblPersonId = fblPersonId;
	}
	
	

}
