package com.invensense.model.workrelations;

public class F_ASSIGNMENT_SUPERVISOR_VO {

	private String ACTION_OCCURRENCE_ID;
	private String ASSIGNMENT_ID;
	private String ASSIGNMENT_SUPERVISOR_ID;
	private String BUSINESS_GROUP_ID;
	private String EFFECTIVE_END_DATE;
	private String EFFECTIVE_START_DATE;
	private String MANAGER_ASSIGNMENT_ID;
	private String MANAGER_ID;
	private String MANAGER_TYPE;
	private String PERSON_ID;
	private String PRIMARY_FLAG;
	private String FT_ALTERNATE_REC;
	private String FT_ALTERNATE_KEY;
	
	
	
	public String toDelimitedString() {
		return ACTION_OCCURRENCE_ID + "|" + ASSIGNMENT_ID + "|" + ASSIGNMENT_SUPERVISOR_ID + "|"
				+ BUSINESS_GROUP_ID + "|" + EFFECTIVE_END_DATE + "|" + EFFECTIVE_START_DATE + "|"
				+ MANAGER_ASSIGNMENT_ID + "|" + MANAGER_ID + "|" + MANAGER_TYPE + "|" + PERSON_ID + "|" + PRIMARY_FLAG
				+ "|" + FT_ALTERNATE_REC + "|" + FT_ALTERNATE_KEY;
	}
	public String getACTION_OCCURRENCE_ID() {
		return ACTION_OCCURRENCE_ID;
	}
	public void setACTION_OCCURRENCE_ID(String aCTION_OCCURRENCE_ID) {
		ACTION_OCCURRENCE_ID = aCTION_OCCURRENCE_ID;
	}
	public String getASSIGNMENT_ID() {
		return ASSIGNMENT_ID;
	}
	public void setASSIGNMENT_ID(String aSSIGNMENT_ID) {
		ASSIGNMENT_ID = aSSIGNMENT_ID;
	}
	public String getASSIGNMENT_SUPERVISOR_ID() {
		return ASSIGNMENT_SUPERVISOR_ID;
	}
	public void setASSIGNMENT_SUPERVISOR_ID(String aSSIGNMENT_SUPERVISOR_ID) {
		ASSIGNMENT_SUPERVISOR_ID = aSSIGNMENT_SUPERVISOR_ID;
	}
	public String getBUSINESS_GROUP_ID() {
		return BUSINESS_GROUP_ID;
	}
	public void setBUSINESS_GROUP_ID(String bUSINESS_GROUP_ID) {
		BUSINESS_GROUP_ID = bUSINESS_GROUP_ID;
	}
	public String getEFFECTIVE_END_DATE() {
		return EFFECTIVE_END_DATE;
	}
	public void setEFFECTIVE_END_DATE(String eFFECTIVE_END_DATE) {
		EFFECTIVE_END_DATE = eFFECTIVE_END_DATE;
	}
	public String getEFFECTIVE_START_DATE() {
		return EFFECTIVE_START_DATE;
	}
	public void setEFFECTIVE_START_DATE(String eFFECTIVE_START_DATE) {
		EFFECTIVE_START_DATE = eFFECTIVE_START_DATE;
	}
	public String getMANAGER_ASSIGNMENT_ID() {
		return MANAGER_ASSIGNMENT_ID;
	}
	public void setMANAGER_ASSIGNMENT_ID(String mANAGER_ASSIGNMENT_ID) {
		MANAGER_ASSIGNMENT_ID = mANAGER_ASSIGNMENT_ID;
	}
	public String getMANAGER_ID() {
		return MANAGER_ID;
	}
	public void setMANAGER_ID(String mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}
	public String getMANAGER_TYPE() {
		return MANAGER_TYPE;
	}
	public void setMANAGER_TYPE(String mANAGER_TYPE) {
		MANAGER_TYPE = mANAGER_TYPE;
	}
	public String getPERSON_ID() {
		return PERSON_ID;
	}
	public void setPERSON_ID(String pERSON_ID) {
		PERSON_ID = pERSON_ID;
	}
	public String getPRIMARY_FLAG() {
		return PRIMARY_FLAG;
	}
	public void setPRIMARY_FLAG(String pRIMARY_FLAG) {
		PRIMARY_FLAG = pRIMARY_FLAG;
	}
	public String getFT_ALTERNATE_REC() {
		return FT_ALTERNATE_REC;
	}
	public void setFT_ALTERNATE_REC(String fT_ALTERNATE_REC) {
		FT_ALTERNATE_REC = fT_ALTERNATE_REC;
	}
	public String getFT_ALTERNATE_KEY() {
		return FT_ALTERNATE_KEY;
	}
	public void setFT_ALTERNATE_KEY(String fT_ALTERNATE_KEY) {
		FT_ALTERNATE_KEY = fT_ALTERNATE_KEY;
	}

	

	
}
