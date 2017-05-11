package com.invensense.model.person;

public class F_PERSON_TYPE_USAGE_VO {

	private String PERSON_TYPE_USAGE_ID;
	private String EFFECTIVE_START_DATE;
	private String EFFECTIVE_END_DATE;
	private String EFFECTIVE_SEQUENCE;
	private String EFFECTIVE_LATEST_CHANGE;
	private String PERSON_ID;
	private String PERSON_TYPE_ID;
	private String SYSTEM_PERSON_TYPE;
	private String LEGAL_ENTITY_ID;
	private String ATTRIBUTE_CATEGORY;
	private String ATTRIBUTE1;
	private String ATTRIBUTE2;
	private String ATTRIBUTE3;
	private String ATTRIBUTE4;
	private String ATTRIBUTE5;
	private String ATTRIBUTE6;
	private String ATTRIBUTE7;
	private String ATTRIBUTE8;
	private String ATTRIBUTE9;
	private String ATTRIBUTE10;
	private String ATTRIBUTE11;
	private String ATTRIBUTE12;
	private String ATTRIBUTE13;
	private String ATTRIBUTE14;
	private String ATTRIBUTE15;
	private String ATTRIBUTE16;
	private String ATTRIBUTE17;
	private String ATTRIBUTE18;
	private String ATTRIBUTE19;
	private String ATTRIBUTE20;
	private String ATTRIBUTE21;
	private String ATTRIBUTE22;
	private String ATTRIBUTE23;
	private String ATTRIBUTE24;
	private String ATTRIBUTE25;
	private String ATTRIBUTE26;
	private String ATTRIBUTE27;
	private String ATTRIBUTE28;
	private String ATTRIBUTE29;
	private String ATTRIBUTE30;
	private String FT_ALTERNATE_REC;
	private String FT_ALTERNATE_KEY;

	public F_PERSON_TYPE_USAGE_VO() {

	}

	

	
	public String toDelimitedString() {
		return  PERSON_TYPE_USAGE_ID + "|" + EFFECTIVE_START_DATE + "|" + EFFECTIVE_END_DATE + "|"
				+ EFFECTIVE_SEQUENCE + "|" + EFFECTIVE_LATEST_CHANGE + "|" + PERSON_ID + "|" + PERSON_TYPE_ID + "|"
				+ SYSTEM_PERSON_TYPE + "|" + LEGAL_ENTITY_ID + "|" + ATTRIBUTE_CATEGORY + "|" + ATTRIBUTE1 + "|"
				+ ATTRIBUTE2 + "|" + ATTRIBUTE3 + "|" + ATTRIBUTE4 + "|" + ATTRIBUTE5 + "|" + ATTRIBUTE6 + "|"
				+ ATTRIBUTE7 + "|" + ATTRIBUTE8 + "|" + ATTRIBUTE9 + "|" + ATTRIBUTE10 + "|" + ATTRIBUTE11 + "|"
				+ ATTRIBUTE12 + "|" + ATTRIBUTE13 + "|" + ATTRIBUTE14 + "|" + ATTRIBUTE15 + "|" + ATTRIBUTE16 + "|"
				+ ATTRIBUTE17 + "|" + ATTRIBUTE18 + "|" + ATTRIBUTE19 + "|" + ATTRIBUTE20 + "|" + ATTRIBUTE21 + "|"
				+ ATTRIBUTE22 + "|" + ATTRIBUTE23 + "|" + ATTRIBUTE24 + "|" + ATTRIBUTE25 + "|" + ATTRIBUTE26 + "|"
				+ ATTRIBUTE27 + "|" + ATTRIBUTE28 + "|" + ATTRIBUTE29 + "|" + ATTRIBUTE30 + "|" + FT_ALTERNATE_REC + "|"
				+ FT_ALTERNATE_KEY;
	}



	public F_PERSON_TYPE_USAGE_VO(String pERSON_TYPE_USAGE_ID, String eFFECTIVE_START_DATE, String eFFECTIVE_END_DATE,
			String eFFECTIVE_SEQUENCE, String eFFECTIVE_LATEST_CHANGE, String pERSON_ID, String pERSON_TYPE_ID,
			String sYSTEM_PERSON_TYPE, String lEGAL_ENTITY_ID, String lSD, String lED) {
		super();
		PERSON_TYPE_USAGE_ID = pERSON_TYPE_USAGE_ID;
		EFFECTIVE_START_DATE = eFFECTIVE_START_DATE;
		EFFECTIVE_END_DATE = eFFECTIVE_END_DATE;
		EFFECTIVE_SEQUENCE = eFFECTIVE_SEQUENCE;
		EFFECTIVE_LATEST_CHANGE = eFFECTIVE_LATEST_CHANGE;
		PERSON_ID = pERSON_ID;
		PERSON_TYPE_ID = pERSON_TYPE_ID;
		SYSTEM_PERSON_TYPE = sYSTEM_PERSON_TYPE;
		LEGAL_ENTITY_ID = lEGAL_ENTITY_ID;
		
	}

	public String getPERSON_TYPE_USAGE_ID() {
		return PERSON_TYPE_USAGE_ID;
	}

	public void setPERSON_TYPE_USAGE_ID(String pERSON_TYPE_USAGE_ID) {
		PERSON_TYPE_USAGE_ID = pERSON_TYPE_USAGE_ID;
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

	public String getEFFECTIVE_SEQUENCE() {
		return EFFECTIVE_SEQUENCE;
	}

	public void setEFFECTIVE_SEQUENCE(String eFFECTIVE_SEQUENCE) {
		EFFECTIVE_SEQUENCE = eFFECTIVE_SEQUENCE;
	}

	public String getEFFECTIVE_LATEST_CHANGE() {
		return EFFECTIVE_LATEST_CHANGE;
	}

	public void setEFFECTIVE_LATEST_CHANGE(String eFFECTIVE_LATEST_CHANGE) {
		EFFECTIVE_LATEST_CHANGE = eFFECTIVE_LATEST_CHANGE;
	}

	public String getPERSON_ID() {
		return PERSON_ID;
	}

	public void setPERSON_ID(String pERSON_ID) {
		PERSON_ID = pERSON_ID;
	}

	public String getPERSON_TYPE_ID() {
		return PERSON_TYPE_ID;
	}

	public void setPERSON_TYPE_ID(String pERSON_TYPE_ID) {
		PERSON_TYPE_ID = pERSON_TYPE_ID;
	}

	public String getSYSTEM_PERSON_TYPE() {
		return SYSTEM_PERSON_TYPE;
	}

	public void setSYSTEM_PERSON_TYPE(String sYSTEM_PERSON_TYPE) {
		SYSTEM_PERSON_TYPE = sYSTEM_PERSON_TYPE;
	}

	public String getLEGAL_ENTITY_ID() {
		return LEGAL_ENTITY_ID;
	}

	public void setLEGAL_ENTITY_ID(String lEGAL_ENTITY_ID) {
		LEGAL_ENTITY_ID = lEGAL_ENTITY_ID;
	}

	

	public String getATTRIBUTE_CATEGORY() {
		return ATTRIBUTE_CATEGORY;
	}

	public void setATTRIBUTE_CATEGORY(String aTTRIBUTE_CATEGORY) {
		ATTRIBUTE_CATEGORY = aTTRIBUTE_CATEGORY;
	}

	public String getATTRIBUTE1() {
		return ATTRIBUTE1;
	}

	public void setATTRIBUTE1(String aTTRIBUTE1) {
		ATTRIBUTE1 = aTTRIBUTE1;
	}

	public String getATTRIBUTE2() {
		return ATTRIBUTE2;
	}

	public void setATTRIBUTE2(String aTTRIBUTE2) {
		ATTRIBUTE2 = aTTRIBUTE2;
	}

	public String getATTRIBUTE3() {
		return ATTRIBUTE3;
	}

	public void setATTRIBUTE3(String aTTRIBUTE3) {
		ATTRIBUTE3 = aTTRIBUTE3;
	}

	public String getATTRIBUTE4() {
		return ATTRIBUTE4;
	}

	public void setATTRIBUTE4(String aTTRIBUTE4) {
		ATTRIBUTE4 = aTTRIBUTE4;
	}

	public String getATTRIBUTE5() {
		return ATTRIBUTE5;
	}

	public void setATTRIBUTE5(String aTTRIBUTE5) {
		ATTRIBUTE5 = aTTRIBUTE5;
	}

	public String getATTRIBUTE6() {
		return ATTRIBUTE6;
	}

	public void setATTRIBUTE6(String aTTRIBUTE6) {
		ATTRIBUTE6 = aTTRIBUTE6;
	}

	public String getATTRIBUTE7() {
		return ATTRIBUTE7;
	}

	public void setATTRIBUTE7(String aTTRIBUTE7) {
		ATTRIBUTE7 = aTTRIBUTE7;
	}

	public String getATTRIBUTE8() {
		return ATTRIBUTE8;
	}

	public void setATTRIBUTE8(String aTTRIBUTE8) {
		ATTRIBUTE8 = aTTRIBUTE8;
	}

	public String getATTRIBUTE9() {
		return ATTRIBUTE9;
	}

	public void setATTRIBUTE9(String aTTRIBUTE9) {
		ATTRIBUTE9 = aTTRIBUTE9;
	}

	public String getATTRIBUTE10() {
		return ATTRIBUTE10;
	}

	public void setATTRIBUTE10(String aTTRIBUTE10) {
		ATTRIBUTE10 = aTTRIBUTE10;
	}

	public String getATTRIBUTE11() {
		return ATTRIBUTE11;
	}

	public void setATTRIBUTE11(String aTTRIBUTE11) {
		ATTRIBUTE11 = aTTRIBUTE11;
	}

	public String getATTRIBUTE12() {
		return ATTRIBUTE12;
	}

	public void setATTRIBUTE12(String aTTRIBUTE12) {
		ATTRIBUTE12 = aTTRIBUTE12;
	}

	public String getATTRIBUTE13() {
		return ATTRIBUTE13;
	}

	public void setATTRIBUTE13(String aTTRIBUTE13) {
		ATTRIBUTE13 = aTTRIBUTE13;
	}

	public String getATTRIBUTE14() {
		return ATTRIBUTE14;
	}

	public void setATTRIBUTE14(String aTTRIBUTE14) {
		ATTRIBUTE14 = aTTRIBUTE14;
	}

	public String getATTRIBUTE15() {
		return ATTRIBUTE15;
	}

	public void setATTRIBUTE15(String aTTRIBUTE15) {
		ATTRIBUTE15 = aTTRIBUTE15;
	}

	public String getATTRIBUTE16() {
		return ATTRIBUTE16;
	}

	public void setATTRIBUTE16(String aTTRIBUTE16) {
		ATTRIBUTE16 = aTTRIBUTE16;
	}

	public String getATTRIBUTE17() {
		return ATTRIBUTE17;
	}

	public void setATTRIBUTE17(String aTTRIBUTE17) {
		ATTRIBUTE17 = aTTRIBUTE17;
	}

	public String getATTRIBUTE18() {
		return ATTRIBUTE18;
	}

	public void setATTRIBUTE18(String aTTRIBUTE18) {
		ATTRIBUTE18 = aTTRIBUTE18;
	}

	public String getATTRIBUTE19() {
		return ATTRIBUTE19;
	}

	public void setATTRIBUTE19(String aTTRIBUTE19) {
		ATTRIBUTE19 = aTTRIBUTE19;
	}

	public String getATTRIBUTE20() {
		return ATTRIBUTE20;
	}

	public void setATTRIBUTE20(String aTTRIBUTE20) {
		ATTRIBUTE20 = aTTRIBUTE20;
	}

	public String getATTRIBUTE21() {
		return ATTRIBUTE21;
	}

	public void setATTRIBUTE21(String aTTRIBUTE21) {
		ATTRIBUTE21 = aTTRIBUTE21;
	}

	public String getATTRIBUTE22() {
		return ATTRIBUTE22;
	}

	public void setATTRIBUTE22(String aTTRIBUTE22) {
		ATTRIBUTE22 = aTTRIBUTE22;
	}

	public String getATTRIBUTE23() {
		return ATTRIBUTE23;
	}

	public void setATTRIBUTE23(String aTTRIBUTE23) {
		ATTRIBUTE23 = aTTRIBUTE23;
	}

	public String getATTRIBUTE24() {
		return ATTRIBUTE24;
	}

	public void setATTRIBUTE24(String aTTRIBUTE24) {
		ATTRIBUTE24 = aTTRIBUTE24;
	}

	public String getATTRIBUTE25() {
		return ATTRIBUTE25;
	}

	public void setATTRIBUTE25(String aTTRIBUTE25) {
		ATTRIBUTE25 = aTTRIBUTE25;
	}

	public String getATTRIBUTE26() {
		return ATTRIBUTE26;
	}

	public void setATTRIBUTE26(String aTTRIBUTE26) {
		ATTRIBUTE26 = aTTRIBUTE26;
	}

	public String getATTRIBUTE27() {
		return ATTRIBUTE27;
	}

	public void setATTRIBUTE27(String aTTRIBUTE27) {
		ATTRIBUTE27 = aTTRIBUTE27;
	}

	public String getATTRIBUTE28() {
		return ATTRIBUTE28;
	}

	public void setATTRIBUTE28(String aTTRIBUTE28) {
		ATTRIBUTE28 = aTTRIBUTE28;
	}

	public String getATTRIBUTE29() {
		return ATTRIBUTE29;
	}

	public void setATTRIBUTE29(String aTTRIBUTE29) {
		ATTRIBUTE29 = aTTRIBUTE29;
	}

	public String getATTRIBUTE30() {
		return ATTRIBUTE30;
	}

	public void setATTRIBUTE30(String aTTRIBUTE30) {
		ATTRIBUTE30 = aTTRIBUTE30;
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
