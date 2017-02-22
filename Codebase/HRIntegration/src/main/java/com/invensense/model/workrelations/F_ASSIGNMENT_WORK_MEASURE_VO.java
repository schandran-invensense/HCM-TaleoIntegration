package com.invensense.model.workrelations;

public class F_ASSIGNMENT_WORK_MEASURE_VO {

	private String ACTION_OCCURRENCE_ID;
	private String ADDS_TO_BUDGET;
	private String ASSIGN_WORK_MEASURE_ID;
	private String ASSIGNMENT_ID;
	private String BUSINESS_GROUP_ID;
	private String EFFECTIVE_START_DATE;
	private String EFFECTIVE_END_DATE;
	private String UNIT;
	private String VALUE;
	private String FT_ALTERNATE_REC;
	private String FT_ALTERNATE_KEY;
	
	public String toDelimitedString() {
		return ACTION_OCCURRENCE_ID + "|" + ADDS_TO_BUDGET + "|" + ASSIGN_WORK_MEASURE_ID + "|" + ASSIGNMENT_ID
				+ "|" + BUSINESS_GROUP_ID + "|" + EFFECTIVE_START_DATE + "|" + EFFECTIVE_END_DATE + "|" + UNIT + "|"
				+ VALUE + "|" + FT_ALTERNATE_REC + "|" + FT_ALTERNATE_KEY;
	}

	public String getACTION_OCCURRENCE_ID() {
		return ACTION_OCCURRENCE_ID;
	}

	public void setACTION_OCCURRENCE_ID(String aCTION_OCCURRENCE_ID) {
		ACTION_OCCURRENCE_ID = aCTION_OCCURRENCE_ID;
	}

	public String getADDS_TO_BUDGET() {
		return ADDS_TO_BUDGET;
	}

	public void setADDS_TO_BUDGET(String aDDS_TO_BUDGET) {
		ADDS_TO_BUDGET = aDDS_TO_BUDGET;
	}

	public String getASSIGN_WORK_MEASURE_ID() {
		return ASSIGN_WORK_MEASURE_ID;
	}

	public void setASSIGN_WORK_MEASURE_ID(String aSSIGN_WORK_MEASURE_ID) {
		ASSIGN_WORK_MEASURE_ID = aSSIGN_WORK_MEASURE_ID;
	}

	public String getASSIGNMENT_ID() {
		return ASSIGNMENT_ID;
	}

	public void setASSIGNMENT_ID(String aSSIGNMENT_ID) {
		ASSIGNMENT_ID = aSSIGNMENT_ID;
	}

	public String getBUSINESS_GROUP_ID() {
		return BUSINESS_GROUP_ID;
	}

	public void setBUSINESS_GROUP_ID(String bUSINESS_GROUP_ID) {
		BUSINESS_GROUP_ID = bUSINESS_GROUP_ID;
	}

	public String getEFFECTIVE_START_DATE() {
		return EFFECTIVE_START_DATE;
	}

	public void setEFFECTIVE_START_DATE(String eFFECTIVE_START_DATE) {
		EFFECTIVE_START_DATE = eFFECTIVE_START_DATE;
	}

	public String getEFFECTIVE_END_DATE() {
		return EFFECTIVE_END_DATE;
	}

	public void setEFFECTIVE_END_DATE(String eFFECTIVE_END_DATE) {
		EFFECTIVE_END_DATE = eFFECTIVE_END_DATE;
	}

	public String getUNIT() {
		return UNIT;
	}

	public void setUNIT(String uNIT) {
		UNIT = uNIT;
	}

	public String getVALUE() {
		return VALUE;
	}

	public void setVALUE(String vALUE) {
		VALUE = vALUE;
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
