package com.invensense.impl.taleo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.invensense.model.hcmtaleo.HCMTaleoEmployee;
import com.invensense.model.person.F_PERSON_ADDRESS_VO;
import com.invensense.model.person.F_PERSON_EMAIL_VO;
import com.invensense.model.person.F_PERSON_ETHNICITY_VO;
import com.invensense.model.person.F_PERSON_LEGISLATIVE_DATA_VO;
import com.invensense.model.person.F_PERSON_NAME_VO;
import com.invensense.model.person.F_PERSON_NATIONAL_IDENTIFIER_VO;
import com.invensense.model.person.F_PERSON_PHONE_VO;
import com.invensense.model.person.F_PERSON_RELIGION_VO;
import com.invensense.model.person.F_PERSON_VO;
import com.invensense.utils.CreateEmployeeConstants;

public class CreatePersonFiles {
	private static Logger logger = Logger.getLogger(CreatePersonFiles.class);

	public static HCMTaleoEmployee createAllPersonFiles(File pFolder, HCMTaleoEmployee hcmTaleoEmployee)
			throws Exception {
		logger.debug("Writing files for Person : "+hcmTaleoEmployee.getFirstName()+" "+hcmTaleoEmployee.getLastName());
		hcmTaleoEmployee = createPersonFile(pFolder, hcmTaleoEmployee);
		createPersonNameFile(pFolder, hcmTaleoEmployee);
		createPersonAddressFile(pFolder, hcmTaleoEmployee);
		createPersonEmailFile(pFolder, hcmTaleoEmployee);
		createPersonLegislativeFile(pFolder, hcmTaleoEmployee);
		createPersonNatIdFile(pFolder, hcmTaleoEmployee);
		createPersonPhoneFile(pFolder, hcmTaleoEmployee);
		createPersonTypeUsageFile(pFolder, hcmTaleoEmployee);
		return hcmTaleoEmployee;
	}

	public static HCMTaleoEmployee createPersonFile(File pFolder, HCMTaleoEmployee hcmTaleoEmployee) throws Exception {
		try {
			String pPersonFile = pFolder.getPath() + File.separator + "F_PERSON_VO.dat";
			logger.debug("Writing person file" + pPersonFile);

			FileWriter pPersonFileWriter = new FileWriter(pPersonFile);
			BufferedWriter out = new BufferedWriter(pPersonFileWriter);

			out.write(
					"PERSON_ID|EFFECTIVE_START_DATE|EFFECTIVE_END_DATE|BUSINESS_GROUP_ID|BUSINESS_GROUP_ID1|START_DATE|START_DATE1|CORRESPONDENCE_LANGUAGE|BLOOD_TYPE|DATE_OF_BIRTH|DATE_OF_DEATH|COUNTRY_OF_BIRTH|REGION_OF_BIRTH|TOWN_OF_BIRTH|USER_GUID|PERSON_NUMBER|PRIMARY_EMAIL_ID|PRIMARY_NID_ID|PRIMARY_NID_NUMBER|PRIMARY_PHONE_ID|MAILING_ADDRESS_ID|WAIVE_DATA_PROTECT|APPLICANT_NUMBER|ATTRIBUTE_CATEGORY|ATTRIBUTE1|ATTRIBUTE2|ATTRIBUTE3|ATTRIBUTE4|ATTRIBUTE5|ATTRIBUTE6|ATTRIBUTE7|ATTRIBUTE8|ATTRIBUTE9|ATTRIBUTE10|ATTRIBUTE11|ATTRIBUTE12|ATTRIBUTE13|ATTRIBUTE14|ATTRIBUTE15|ATTRIBUTE16|ATTRIBUTE17|ATTRIBUTE18|ATTRIBUTE19|ATTRIBUTE20|ATTRIBUTE21|ATTRIBUTE22|ATTRIBUTE23|ATTRIBUTE24|ATTRIBUTE25|ATTRIBUTE26|ATTRIBUTE27|ATTRIBUTE28|ATTRIBUTE29|ATTRIBUTE30|ATTRIBUTE_CATEGORY1|ATTRIBUTE110|ATTRIBUTE210|ATTRIBUTE31|ATTRIBUTE41|ATTRIBUTE51|ATTRIBUTE61|ATTRIBUTE71|ATTRIBUTE81|ATTRIBUTE91|ATTRIBUTE101|ATTRIBUTE111|ATTRIBUTE121|ATTRIBUTE131|ATTRIBUTE141|ATTRIBUTE151|ATTRIBUTE161|ATTRIBUTE171|ATTRIBUTE181|ATTRIBUTE191|ATTRIBUTE201|ATTRIBUTE211|ATTRIBUTE221|ATTRIBUTE231|ATTRIBUTE241|ATTRIBUTE251|ATTRIBUTE261|ATTRIBUTE271|ATTRIBUTE281|ATTRIBUTE291|ATTRIBUTE301|ATTRIBUTE311|ATTRIBUTE32|ATTRIBUTE33|ATTRIBUTE34|ATTRIBUTE35|ATTRIBUTE36|ATTRIBUTE37|ATTRIBUTE38|ATTRIBUTE39|ATTRIBUTE40|ATTRIBUTE411|ATTRIBUTE42|ATTRIBUTE43|ATTRIBUTE44|ATTRIBUTE45|ATTRIBUTE46|ATTRIBUTE47|ATTRIBUTE48|ATTRIBUTE49|ATTRIBUTE50|FT_ALTERNATE_REC|FT_ALTERNATE_KEY");
		
			F_PERSON_VO fPerson_VO = new F_PERSON_VO();
			fPerson_VO.setPERSON_ID(createPersonId(hcmTaleoEmployee.getEmployeeId()));
			hcmTaleoEmployee.setHcmPersonId(createPersonId(hcmTaleoEmployee.getEmployeeId()));

			fPerson_VO.setEFFECTIVE_START_DATE(hcmTaleoEmployee.getStartDate());
			fPerson_VO.setSTART_DATE(hcmTaleoEmployee.getStartDate());
			fPerson_VO.setSTART_DATE1(hcmTaleoEmployee.getStartDate());

			fPerson_VO.setCORRESPONDENCE_LANGUAGE(hcmTaleoEmployee.getLanguage());
			fPerson_VO.setDATE_OF_BIRTH(hcmTaleoEmployee.getDateOfBirth());
			fPerson_VO.setEFFECTIVE_END_DATE(CreateEmployeeConstants.getCreateEffectiveEndDate());
			fPerson_VO.setBUSINESS_GROUP_ID(CreateEmployeeConstants.getCreateBusinessGroupId());
			fPerson_VO.setBUSINESS_GROUP_ID1(CreateEmployeeConstants.getCreateBusinessGroupId1());
			fPerson_VO.setWAIVE_DATA_PROTECT("N");
			fPerson_VO.setPERSON_NUMBER(hcmTaleoEmployee.getHcmPersonNumber());
			//fPerson_VO.setPERSON_NUMBER(
				//	CreateEmployeeConstants.getCreatePersonNumber().replaceAll("#", hcmTaleoEmployee.getEmployeeId()));
			//hcmTaleoEmployee.setHcmPersonNumber(fPerson_VO.getPERSON_NUMBER());
			hcmTaleoEmployee.setHcmPersonName(hcmTaleoEmployee.getFirstName() + " " + hcmTaleoEmployee.getLastName());
			fPerson_VO.setPRIMARY_PHONE_ID(createPrimaryPhoneId(hcmTaleoEmployee.getEmployeeId()));
			fPerson_VO.setPRIMARY_NID_ID(createPrimaryNIDId(hcmTaleoEmployee.getEmployeeId()));
			fPerson_VO.setFT_ALTERNATE_REC("PERSON");
			fPerson_VO.setFT_ALTERNATE_KEY(createPersonId(hcmTaleoEmployee.getEmployeeId()));
			out.write("\r\n");
			//logger.debug("Data in person :: " + fPerson_VO.toDelimitedString().replaceAll("null", ""));
			out.write(fPerson_VO.toDelimitedString().replaceAll("null", ""));
	logger.debug("Write file person");

			pPersonFileWriter.flush();
			out.flush();
			pPersonFileWriter.close();
			out.close();
			File permFile = new File(pFolder.getPath() + File.separator + "F_PERSON_VO.dat");
			permFile.setWritable(true);
			permFile.setReadable(true);

			permFile.setExecutable(true);

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.FATAL, e.getMessage(), e);
			throw new Exception(e);
		}
		return hcmTaleoEmployee;

	}

	public static void createPersonAddressFile(File pFolder, HCMTaleoEmployee hcmTaleoEmployee) throws Exception {
		try {
			String pAddressFile = pFolder.getPath() + File.separator + "F_PERSON_ADDRESS_VO.dat";

			FileWriter pAddressFileWriter = new FileWriter(pAddressFile);
			BufferedWriter out = new BufferedWriter(pAddressFileWriter);
			out.write(
					"PERSON_ADDR_USAGE_ID|EFFECTIVE_START_DATE|EFFECTIVE_END_DATE|PERSON_ID|BUSINESS_GROUP_ID|BUSINESS_GROUP_ID1|ADDRESS_TYPE|ADDRESS_LINE_1|ADDRESS_LINE_2|ADDRESS_LINE_3|ADDRESS_LINE_4|BUILDING|FLOOR_NUMBER|TOWN_OR_CITY|REGION_1|REGION_2|REGION_3|COUNTRY|POSTAL_CODE|LONG_POSTAL_CODE|TIMEZONE_CODE|DERIVED_LOCALE|DQ_VALIDATION_LEVEL|FORMATTED_SINGLE_LINE_ADDRESS|FORMATTED_MULTI_LINE_ADDRESS|ATTRIBUTE_CATEGORY|ATTRIBUTE1|ATTRIBUTE2|ATTRIBUTE3|ATTRIBUTE4|ATTRIBUTE5|ATTRIBUTE6|ATTRIBUTE7|ATTRIBUTE8|ATTRIBUTE9|ATTRIBUTE10|ATTRIBUTE11|ATTRIBUTE12|ATTRIBUTE13|ATTRIBUTE14|ATTRIBUTE15|ATTRIBUTE16|ATTRIBUTE17|ATTRIBUTE18|ATTRIBUTE19|ATTRIBUTE20|ATTRIBUTE21|ATTRIBUTE22|ATTRIBUTE23|ATTRIBUTE24|ATTRIBUTE25|ATTRIBUTE26|ATTRIBUTE27|ATTRIBUTE28|ATTRIBUTE29|ATTRIBUTE30|ADDR_ATTRIBUTE_CATEGORY|ADDR_ATTRIBUTE1|ADDR_ATTRIBUTE2|ADDR_ATTRIBUTE3|ADDR_ATTRIBUTE4|ADDR_ATTRIBUTE5|ADDR_ATTRIBUTE6|ADDR_ATTRIBUTE7|ADDR_ATTRIBUTE8|ADDR_ATTRIBUTE9|ADDR_ATTRIBUTE10|ADDR_ATTRIBUTE11|ADDR_ATTRIBUTE12|ADDR_ATTRIBUTE13|ADDR_ATTRIBUTE14|ADDR_ATTRIBUTE15|ADDR_ATTRIBUTE16|ADDR_ATTRIBUTE17|ADDR_ATTRIBUTE18|ADDR_ATTRIBUTE19|ADDR_ATTRIBUTE20|ADDR_ATTRIBUTE21|ADDR_ATTRIBUTE22|ADDR_ATTRIBUTE23|ADDR_ATTRIBUTE24|ADDR_ATTRIBUTE25|ADDR_ATTRIBUTE26|ADDR_ATTRIBUTE27|ADDR_ATTRIBUTE28|ADDR_ATTRIBUTE29|ADDR_ATTRIBUTE30|ADDL_ADDRESS_ATTRIBUTE1|ADDL_ADDRESS_ATTRIBUTE2|ADDL_ADDRESS_ATTRIBUTE3|ADDL_ADDRESS_ATTRIBUTE4|ADDL_ADDRESS_ATTRIBUTE5|FT_ALTERNATE_REC|FT_ALTERNATE_KEY");

			F_PERSON_ADDRESS_VO fPerson_ADDRESS_VO = new F_PERSON_ADDRESS_VO();
			fPerson_ADDRESS_VO.setBUSINESS_GROUP_ID(CreateEmployeeConstants.getCreateBusinessGroupId());
			fPerson_ADDRESS_VO.setBUSINESS_GROUP_ID1(CreateEmployeeConstants.getCreateBusinessGroupId1());
			fPerson_ADDRESS_VO.setEFFECTIVE_END_DATE(CreateEmployeeConstants.getCreateEffectiveEndDate());
			fPerson_ADDRESS_VO.setADDRESS_LINE_1(hcmTaleoEmployee.getAddressLine1());
			fPerson_ADDRESS_VO.setADDRESS_TYPE(CreateEmployeeConstants.getCreateAddressType());
			fPerson_ADDRESS_VO.setPERSON_ADDR_USAGE_ID(createAddressUsageId(hcmTaleoEmployee.getEmployeeId()));
			fPerson_ADDRESS_VO.setEFFECTIVE_START_DATE(hcmTaleoEmployee.getStartDate());
			fPerson_ADDRESS_VO.setPERSON_ID(createPersonId(hcmTaleoEmployee.getEmployeeId()));

			fPerson_ADDRESS_VO.setTOWN_OR_CITY(hcmTaleoEmployee.getCity());
			fPerson_ADDRESS_VO.setPOSTAL_CODE(hcmTaleoEmployee.getPostalCode());
			// fPerson_ADDRESS_VO.setTOWN_OR_CITY("Pasadena");
			// fPerson_ADDRESS_VO.setPOSTAL_CODE("91101");

			fPerson_ADDRESS_VO.setREGION_1(hcmTaleoEmployee.getCounty());
			// fPerson_ADDRESS_VO.setREGION_1("Los Angeles");

			// fPerson_ADDRESS_VO.setTOWN_OR_CITY("Santa
			// Clara");
			fPerson_ADDRESS_VO.setCOUNTRY(hcmTaleoEmployee.getCountry());
			// fPerson_ADDRESS_VO.setPOSTAL_CODE(hcmTaleoEmployee.getPostalCode());
			fPerson_ADDRESS_VO.setFT_ALTERNATE_REC("ADDRESSES");
			fPerson_ADDRESS_VO.setFT_ALTERNATE_KEY(createAddressUsageId(hcmTaleoEmployee.getEmployeeId()));

			fPerson_ADDRESS_VO.setREGION_2(hcmTaleoEmployee.getHcmState());
	//	 fPerson_ADDRESS_VO.setREGION_2("CA");
			// hcmTaleoEmployee.getState()
			// =California

			// out.newLine();
			out.write("\r\n");
			out.write(fPerson_ADDRESS_VO.toDelimitedString().replaceAll("null", ""));

			pAddressFileWriter.flush();
			out.flush();
			pAddressFileWriter.close();
			out.close();

			File permFile = new File(pFolder.getPath() + File.separator + "F_PERSON_ADDRESS_VO.dat");
			permFile.setWritable(true);
			permFile.setReadable(true);

			permFile.setExecutable(true);

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.FATAL, e.getMessage(), e);
			throw new Exception(e);
		}
	}

	public static void createPersonNameFile(File pFolder, HCMTaleoEmployee hcmTaleoEmployee) throws Exception {
		try {
			String pNameFile = pFolder.getPath() + File.separator + "F_PERSON_NAME_VO.dat";

			FileWriter pNameFileWriter = new FileWriter(pNameFile);
			BufferedWriter out = new BufferedWriter(pNameFileWriter);

			out.write(
					"PERSON_NAME_ID|EFFECTIVE_START_DATE|EFFECTIVE_END_DATE|BUSINESS_GROUP_ID|LEGISLATION_CODE|PERSON_ID|NAME_TYPE|FIRST_NAME|MIDDLE_NAMES|LAST_NAME|DISPLAY_NAME|ORDER_NAME|LIST_NAME|FULL_NAME|HONORS|KNOWN_AS|PRE_NAME_ADJUNCT|PREVIOUS_LAST_NAME|SUFFIX|TITLE|MILITARY_RANK|ATTRIBUTE_CATEGORY|ATTRIBUTE1|ATTRIBUTE2|ATTRIBUTE3|ATTRIBUTE4|ATTRIBUTE5|ATTRIBUTE6|ATTRIBUTE7|ATTRIBUTE8|ATTRIBUTE9|ATTRIBUTE10|ATTRIBUTE11|ATTRIBUTE12|ATTRIBUTE13|ATTRIBUTE14|ATTRIBUTE15|ATTRIBUTE16|ATTRIBUTE17|ATTRIBUTE18|ATTRIBUTE19|ATTRIBUTE20|ATTRIBUTE21|ATTRIBUTE22|ATTRIBUTE23|ATTRIBUTE24|ATTRIBUTE25|ATTRIBUTE26|ATTRIBUTE27|ATTRIBUTE28|ATTRIBUTE29|ATTRIBUTE30|NAM_INFORMATION_CATEGORY|NAM_INFORMATION1|NAM_INFORMATION2|NAM_INFORMATION3|NAM_INFORMATION4|NAM_INFORMATION5|NAM_INFORMATION6|NAM_INFORMATION7|NAM_INFORMATION8|NAM_INFORMATION9|NAM_INFORMATION10|NAM_INFORMATION11|NAM_INFORMATION12|NAM_INFORMATION13|NAM_INFORMATION14|NAM_INFORMATION15|NAM_INFORMATION16|NAM_INFORMATION17|NAM_INFORMATION18|NAM_INFORMATION19|NAM_INFORMATION20|NAM_INFORMATION21|NAM_INFORMATION22|NAM_INFORMATION23|NAM_INFORMATION24|NAM_INFORMATION25|NAM_INFORMATION26|NAM_INFORMATION27|NAM_INFORMATION28|NAM_INFORMATION29|NAM_INFORMATION30|CHAR_SET_CONTEXT");

			F_PERSON_NAME_VO fPerson_NAME_VO = new F_PERSON_NAME_VO();
			fPerson_NAME_VO.setPERSON_ID(createPersonId(hcmTaleoEmployee.getEmployeeId()));
			fPerson_NAME_VO.setEFFECTIVE_START_DATE(hcmTaleoEmployee.getStartDate());
			fPerson_NAME_VO.setEFFECTIVE_END_DATE(CreateEmployeeConstants.getCreateEffectiveEndDate());
			fPerson_NAME_VO.setPERSON_NAME_ID(createPersonNameId(hcmTaleoEmployee.getEmployeeId()));
			fPerson_NAME_VO.setBUSINESS_GROUP_ID(CreateEmployeeConstants.getCreateBusinessGroupId());
			fPerson_NAME_VO.setFIRST_NAME(hcmTaleoEmployee.getFirstName());
			fPerson_NAME_VO.setLAST_NAME(hcmTaleoEmployee.getLastName());
			fPerson_NAME_VO.setTITLE(hcmTaleoEmployee.getSalutation());
			fPerson_NAME_VO.setDISPLAY_NAME(hcmTaleoEmployee.getFirstName() + " " + hcmTaleoEmployee.getLastName());
			fPerson_NAME_VO.setORDER_NAME(hcmTaleoEmployee.getFirstName() + " " + hcmTaleoEmployee.getLastName());
			fPerson_NAME_VO.setLIST_NAME(hcmTaleoEmployee.getFirstName() + " " + hcmTaleoEmployee.getLastName());
			fPerson_NAME_VO.setFULL_NAME(hcmTaleoEmployee.getFirstName() + " " + hcmTaleoEmployee.getLastName());
			fPerson_NAME_VO.setLEGISLATION_CODE(hcmTaleoEmployee.getHcmLegislationCode());
			fPerson_NAME_VO.setNAME_TYPE("GLOBAL");

			out.write("\r\n");
			out.write(fPerson_NAME_VO.toDelimitedString().replaceAll("null", ""));

			pNameFileWriter.flush();
			out.flush();
			pNameFileWriter.close();
			out.close();

			File permFile = new File(pFolder.getPath() + File.separator + "F_PERSON_NAME_VO.dat");
			permFile.setWritable(true);
			permFile.setReadable(true);

			permFile.setExecutable(true);

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.FATAL, e.getMessage(), e);
			throw new Exception(e);

		}

	}

	private static void createPersonEmailFile(File pFolder, HCMTaleoEmployee hcmTaleoEmployee) throws Exception {
		try {
			String pEmailFile = pFolder.getPath() + File.separator + "F_PERSON_EMAIL_VO.dat";

			FileWriter pEmailFileWriter = new FileWriter(pEmailFile);
			BufferedWriter out = new BufferedWriter(pEmailFileWriter);
			out.write(
					"EMAIL_ADDRESS_ID|BUSINESS_GROUP_ID|PERSON_ID|DATE_FROM|DATE_TO|EMAIL_TYPE|EMAIL_ADDRESS|PRIMARY_FLAG|MASTERED_IN_LDAP_FLAG|ATTRIBUTE_CATEGORY|ATTRIBUTE1|ATTRIBUTE2|ATTRIBUTE3|ATTRIBUTE4|ATTRIBUTE5|ATTRIBUTE6|ATTRIBUTE7|ATTRIBUTE8|ATTRIBUTE9|ATTRIBUTE10|ATTRIBUTE11|ATTRIBUTE12|ATTRIBUTE13|ATTRIBUTE14|ATTRIBUTE15|ATTRIBUTE16|ATTRIBUTE17|ATTRIBUTE18|ATTRIBUTE19|ATTRIBUTE20|ATTRIBUTE21|ATTRIBUTE22|ATTRIBUTE23|ATTRIBUTE24|ATTRIBUTE25|ATTRIBUTE26|ATTRIBUTE27|ATTRIBUTE28|ATTRIBUTE29|ATTRIBUTE30");
			F_PERSON_EMAIL_VO fPerson_EMAIL_VO = new F_PERSON_EMAIL_VO();

			fPerson_EMAIL_VO.setEMAIL_ADDRESS_ID(CreateEmployeeConstants.getCreateEmailAddressId().replaceAll("#",
					hcmTaleoEmployee.getEmployeeId()));
			fPerson_EMAIL_VO.setPERSON_ID(createPersonId(hcmTaleoEmployee.getEmployeeId()));
			fPerson_EMAIL_VO.setDATE_FROM(hcmTaleoEmployee.getStartDate());
			fPerson_EMAIL_VO.setDATE_TO(CreateEmployeeConstants.getCreateEffectiveEndDate());
			fPerson_EMAIL_VO.setBUSINESS_GROUP_ID(CreateEmployeeConstants.getCreateBusinessGroupId());
			fPerson_EMAIL_VO.setEMAIL_ADDRESS(hcmTaleoEmployee.getEmailAddress());
			fPerson_EMAIL_VO.setEMAIL_TYPE("W1");
			fPerson_EMAIL_VO.setPRIMARY_FLAG("Y");
			out.write("\r\n");
			out.write(fPerson_EMAIL_VO.toDelimitedString().replaceAll("null", ""));

			pEmailFileWriter.flush();
			out.flush();
			pEmailFileWriter.close();
			out.close();

		
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.FATAL, e.getMessage(), e);
			throw new Exception(e);

		}

	}

	private static void createPersonEthnicityFile(File pFolder, HCMTaleoEmployee hcmTaleoEmployee) throws Exception {
		try {
			String pEthnicityFile = pFolder.getPath() + File.separator + "F_PERSON_ETHNICITY_VO.dat";

			FileWriter pEthnicityFileWriter = new FileWriter(pEthnicityFile);
			BufferedWriter out = new BufferedWriter(pEthnicityFileWriter);

			out.write(
					"ETHNICITY_ID|BUSINESS_GROUP_ID|LEGISLATION_CODE|PERSON_ID|DECLARER_ID|ETHNICITY|PRIMARY_FLAG|ATTRIBUTE1|ATTRIBUTE2|ATTRIBUTE3|ATTRIBUTE4|ATTRIBUTE5|ATTRIBUTE6|ATTRIBUTE7|ATTRIBUTE8|ATTRIBUTE9|ATTRIBUTE10|ATTRIBUTE11|ATTRIBUTE12|ATTRIBUTE13|ATTRIBUTE14|ATTRIBUTE15|ATTRIBUTE16|ATTRIBUTE17|ATTRIBUTE18|ATTRIBUTE19|ATTRIBUTE20|ATTRIBUTE21|ATTRIBUTE22|ATTRIBUTE23|ATTRIBUTE24|ATTRIBUTE25|ATTRIBUTE26|ATTRIBUTE27|ATTRIBUTE28|ATTRIBUTE29|ATTRIBUTE30|ATTRIBUTE_NUMBER1|ATTRIBUTE_NUMBER2|ATTRIBUTE_NUMBER3|ATTRIBUTE_NUMBER4|ATTRIBUTE_NUMBER5|ATTRIBUTE_NUMBER6|ATTRIBUTE_NUMBER7|ATTRIBUTE_NUMBER8|ATTRIBUTE_NUMBER9|ATTRIBUTE_NUMBER10|ATTRIBUTE_NUMBER11|ATTRIBUTE_NUMBER12|ATTRIBUTE_NUMBER13|ATTRIBUTE_NUMBER14|ATTRIBUTE_NUMBER15|ATTRIBUTE_NUMBER16|ATTRIBUTE_NUMBER17|ATTRIBUTE_NUMBER18|ATTRIBUTE_NUMBER19|ATTRIBUTE_NUMBER20|ATTRIBUTE_DATE1|ATTRIBUTE_DATE2|ATTRIBUTE_DATE3|ATTRIBUTE_DATE4|ATTRIBUTE_DATE5|ATTRIBUTE_DATE6|ATTRIBUTE_DATE7|ATTRIBUTE_DATE8|ATTRIBUTE_DATE9|ATTRIBUTE_DATE10|ATTRIBUTE_DATE11|ATTRIBUTE_DATE12|ATTRIBUTE_DATE13|ATTRIBUTE_DATE14|ATTRIBUTE_DATE15|ATTRIBUTE_CATEGORY|USERKEY1|USERKEY2|USERKEY3|USERKEY4|USERKEY5|USERKEY6|USERKEY7|USERKEY8|USERKEY9|USERKEY10|USERKEYVALUE1|USERKEYVALUE2|USERKEYVALUE3|USERKEYVALUE4|USERKEYVALUE5|USERKEYVALUE6|USERKEYVALUE7|USERKEYVALUE8|USERKEYVALUE9|USERKEYVALUE10");

			F_PERSON_ETHNICITY_VO fPerson_ETHNICITY_VO = new F_PERSON_ETHNICITY_VO();
			fPerson_ETHNICITY_VO.setETHNICITY(hcmTaleoEmployee.getEmployeeId());
			fPerson_ETHNICITY_VO.setPERSON_ID(createPersonId(hcmTaleoEmployee.getEmployeeId()));
			fPerson_ETHNICITY_VO.setLEGISLATION_CODE(hcmTaleoEmployee.getHcmLegislationCode());
			fPerson_ETHNICITY_VO.setBUSINESS_GROUP_ID(CreateEmployeeConstants.getCreateBusinessGroupId());

			out.write(fPerson_ETHNICITY_VO.toString().replaceAll("null", ""));

			pEthnicityFileWriter.flush();
			out.flush();
			pEthnicityFileWriter.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.FATAL, e.getMessage(), e);
			throw new Exception(e);

		}

	}

	private static void createPersonLegislativeFile(File pFolder, HCMTaleoEmployee hcmTaleoEmployee) throws Exception

	{

		try {
			String pLegislativeFile = pFolder.getPath() + File.separator + "F_PERSON_LEGISLATIVE_DATA_VO.dat";

			FileWriter pLegislativeFileWriter = new FileWriter(pLegislativeFile);

			BufferedWriter out = new BufferedWriter(pLegislativeFileWriter);
			out.write(
					"PERSON_LEGISLATIVE_ID|EFFECTIVE_START_DATE|EFFECTIVE_END_DATE|BUSINESS_GROUP_ID|PERSON_ID|LEGISLATION_CODE|HIGHEST_EDUCATION_LEVEL|MARITAL_STATUS|MARITAL_STATUS_DATE|SEX|ATTRIBUTE_CATEGORY|ATTRIBUTE1|ATTRIBUTE2|ATTRIBUTE3|ATTRIBUTE4|ATTRIBUTE5|ATTRIBUTE6|ATTRIBUTE7|ATTRIBUTE8|ATTRIBUTE9|ATTRIBUTE10|ATTRIBUTE11|ATTRIBUTE12|ATTRIBUTE13|ATTRIBUTE14|ATTRIBUTE15|ATTRIBUTE16|ATTRIBUTE17|ATTRIBUTE18|ATTRIBUTE19|ATTRIBUTE20|ATTRIBUTE21|ATTRIBUTE22|ATTRIBUTE23|ATTRIBUTE24|ATTRIBUTE25|ATTRIBUTE26|ATTRIBUTE27|ATTRIBUTE28|ATTRIBUTE29|ATTRIBUTE30|PER_INFROMATION_CATEGORY|PER_INFORMATION1|PER_INFORMATION2|PER_INFORMATION3|PER_INFORMATION4|PER_INFORMATION5|PER_INFORMATION6|PER_INFORMATION7|PER_INFORMATION8|PER_INFORMATION9|PER_INFORMATION10|PER_INFORMATION11|PER_INFORMATION12|PER_INFORMATION13|PER_INFORMATION14|PER_INFORMATION15|PER_INFORMATION16|PER_INFORMATION17|PER_INFORMATION18|PER_INFORMATION19|PER_INFORMATION20|PER_INFORMATION21|PER_INFORMATION22|PER_INFORMATION23|PER_INFORMATION24|PER_INFORMATION25|PER_INFORMATION26|PER_INFORMATION27|PER_INFORMATION28|PER_INFORMATION29|PER_INFORMATION30|PER_INFORMATION_DATE1|PER_INFORMATION_DATE2|PER_INFORMATION_DATE3|PER_INFORMATION_DATE4|PER_INFORMATION_DATE5|PER_INFORMATION_DATE6|PER_INFORMATION_DATE7|PER_INFORMATION_DATE8|PER_INFORMATION_DATE9|PER_INFORMATION_DATE10|PER_INFORMATION_DATE11|PER_INFORMATION_DATE12|PER_INFORMATION_DATE13|PER_INFORMATION_DATE14|PER_INFORMATION_DATE15|PER_INFORMATION_NUMBER1|PER_INFORMATION_NUMBER2|PER_INFORMATION_NUMBER3|PER_INFORMATION_NUMBER4|PER_INFORMATION_NUMBER5|PER_INFORMATION_NUMBER6|PER_INFORMATION_NUMBER7|PER_INFORMATION_NUMBER8|PER_INFORMATION_NUMBER9|PER_INFORMATION_NUMBER10|PER_INFORMATION_NUMBER11|PER_INFORMATION_NUMBER12|PER_INFORMATION_NUMBER13|PER_INFORMATION_NUMBER14|PER_INFORMATION_NUMBER15|PER_INFORMATION_NUMBER16|PER_INFORMATION_NUMBER17|PER_INFORMATION_NUMBER18|PER_INFORMATION_NUMBER19|PER_INFORMATION_NUMBER20|FT_ALTERNATE_REC|FT_ALTERNATE_KEY");

			F_PERSON_LEGISLATIVE_DATA_VO fPerson_LEGISLATIVE_DATA_VO = new F_PERSON_LEGISLATIVE_DATA_VO();
			fPerson_LEGISLATIVE_DATA_VO.setPERSON_ID(createPersonId(hcmTaleoEmployee.getEmployeeId()));
			fPerson_LEGISLATIVE_DATA_VO.setEFFECTIVE_START_DATE(hcmTaleoEmployee.getStartDate());
			fPerson_LEGISLATIVE_DATA_VO.setPERSON_LEGISLATIVE_ID(CreateEmployeeConstants.getCreatePersonLegislativeId()
					.replace("#", hcmTaleoEmployee.getEmployeeId()));
			fPerson_LEGISLATIVE_DATA_VO.setEFFECTIVE_END_DATE(CreateEmployeeConstants.getCreateEffectiveEndDate());
			fPerson_LEGISLATIVE_DATA_VO.setBUSINESS_GROUP_ID(CreateEmployeeConstants.getCreateBusinessGroupId());

			fPerson_LEGISLATIVE_DATA_VO.setMARITAL_STATUS(hcmTaleoEmployee.getMaritalStatus());
			fPerson_LEGISLATIVE_DATA_VO.setBUSINESS_GROUP_ID(CreateEmployeeConstants.getCreateBusinessGroupId());
			fPerson_LEGISLATIVE_DATA_VO.setFT_ALTERNATE_REC("PERS_DATA_EFFDT");
			fPerson_LEGISLATIVE_DATA_VO.setFT_ALTERNATE_KEY(CreateEmployeeConstants.getCreatePersonLegislativeId()
					.replace("#", hcmTaleoEmployee.getEmployeeId()));
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER1("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER2("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER3("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER4("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER5("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER6("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER7("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER8("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER9("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER10("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER11("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER12("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER13("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER14("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER15("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER16("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER17("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER18("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER19("0");
			fPerson_LEGISLATIVE_DATA_VO.setPER_INFORMATION_NUMBER20("0");
			fPerson_LEGISLATIVE_DATA_VO.setLEGISLATION_CODE(hcmTaleoEmployee.getHcmLegislationCode());
			out.write("\r\n");
			out.write(fPerson_LEGISLATIVE_DATA_VO.toDelimitedString().replaceAll("null", ""));
			pLegislativeFileWriter.flush();
			out.flush();
			pLegislativeFileWriter.close();
			out.close();

		
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.FATAL, e.getMessage(), e);
			throw new Exception(e);
		}
	}

	private static void createPersonNatIdFile(File pFolder, HCMTaleoEmployee hcmTaleoEmployee) throws Exception

	{
		try {
			String pIdentifierFile = pFolder.getPath() + File.separator + "F_PERSON_NATIONAL_IDENTIFIER_VO.dat";

			FileWriter pIdentifierFileWriter = new FileWriter(pIdentifierFile);
			BufferedWriter out = new BufferedWriter(pIdentifierFileWriter);
			out.write(
					"NATIONAL_IDENTIFIER_ID|BUSINESS_GROUP_ID|PERSON_ID|LEGISLATION_CODE|ISSUE_DATE|EXPIRATION_DATE|NATIONAL_IDENTIFIER_TYPE|NATIONAL_IDENTIFIER_NUMBER|PRIMARY_FLAG|ATTRIBUTE_CATEGORY|ATTRIBUTE1|ATTRIBUTE2|ATTRIBUTE3|ATTRIBUTE4|ATTRIBUTE5|ATTRIBUTE6|ATTRIBUTE7|ATTRIBUTE8|ATTRIBUTE9|ATTRIBUTE10|ATTRIBUTE11|ATTRIBUTE12|ATTRIBUTE13|ATTRIBUTE14|ATTRIBUTE15|ATTRIBUTE16|ATTRIBUTE17|ATTRIBUTE18|ATTRIBUTE19|ATTRIBUTE20|ATTRIBUTE21|ATTRIBUTE22|ATTRIBUTE23|ATTRIBUTE24|ATTRIBUTE25|ATTRIBUTE26|ATTRIBUTE27|ATTRIBUTE28|ATTRIBUTE29|ATTRIBUTE30|FT_ALTERNATE_REC|FT_ALTERNATE_KEY");
			if ((hcmTaleoEmployee.getHcmLegislationCode() != null)
					&& (hcmTaleoEmployee.getHcmLegislationCode()).equalsIgnoreCase("US")) {
				
		//		if ((hcmTaleoEmployee.getCountry() != null)
		//				&& (hcmTaleoEmployee.getCountry()).equalsIgnoreCase("US")) {
				F_PERSON_NATIONAL_IDENTIFIER_VO fPERSON_NATIONAL_IDENTIFIER_VO = new F_PERSON_NATIONAL_IDENTIFIER_VO();
				fPERSON_NATIONAL_IDENTIFIER_VO
						.setNATIONAL_IDENTIFIER_ID(createPrimaryNIDId(hcmTaleoEmployee.getEmployeeId()));
				fPERSON_NATIONAL_IDENTIFIER_VO.setBUSINESS_GROUP_ID(CreateEmployeeConstants.getCreateBusinessGroupId());
				fPERSON_NATIONAL_IDENTIFIER_VO.setPERSON_ID(createPersonId(hcmTaleoEmployee.getEmployeeId()));
				fPERSON_NATIONAL_IDENTIFIER_VO.setNATIONAL_IDENTIFIER_NUMBER(hcmTaleoEmployee.getSsn());
				logger.debug("Legislation code : " + hcmTaleoEmployee.getHcmLegislationCode());

				fPERSON_NATIONAL_IDENTIFIER_VO.setNATIONAL_IDENTIFIER_TYPE("SSN");
				fPERSON_NATIONAL_IDENTIFIER_VO.setNATIONAL_IDENTIFIER_NUMBER("200-11-1212");

				fPERSON_NATIONAL_IDENTIFIER_VO.setPRIMARY_FLAG("Y");
				fPERSON_NATIONAL_IDENTIFIER_VO.setLEGISLATION_CODE(hcmTaleoEmployee.getHcmLegislationCode());
				fPERSON_NATIONAL_IDENTIFIER_VO.setFT_ALTERNATE_REC("NI_TBL");
				fPERSON_NATIONAL_IDENTIFIER_VO
						.setFT_ALTERNATE_KEY(createPrimaryNIDId(hcmTaleoEmployee.getEmployeeId()));

				out.write("\r\n");
				out.write(fPERSON_NATIONAL_IDENTIFIER_VO.toDelimitedString().replaceAll("null", ""));
			}
			pIdentifierFileWriter.flush();
			out.flush();
			pIdentifierFileWriter.close();
			out.close();

			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.FATAL, e.getMessage(), e);
			throw new Exception(e);

		}

	}

	private static void createPersonPhoneFile(File pFolder, HCMTaleoEmployee hcmTaleoEmployee) throws Exception {
		try {
			String pPhoneFile = pFolder.getPath() + File.separator + "F_PERSON_PHONE_VO.dat";

			FileWriter pPhoneFileWriter = new FileWriter(pPhoneFile);

			BufferedWriter out = new BufferedWriter(pPhoneFileWriter);
			out.write(
					"PHONE_ID|BUSINESS_GROUP_ID|PHONE_TYPE|DATE_FROM|DATE_TO|PERSON_ID|PHONE_NUMBER|COUNTRY_CODE_NUMBER|EXTENSION|SPEED_DIAL_NUMBER|VALIDITY|AREA_CODE|SEARCH_PHONE_NUMBER|PRIMARY_FLAG|ATTRIBUTE_CATEGORY|ATTRIBUTE1|ATTRIBUTE2|ATTRIBUTE3|ATTRIBUTE4|ATTRIBUTE5|ATTRIBUTE6|ATTRIBUTE7|ATTRIBUTE8|ATTRIBUTE9|ATTRIBUTE10|ATTRIBUTE11|ATTRIBUTE12|ATTRIBUTE13|ATTRIBUTE14|ATTRIBUTE15|ATTRIBUTE16|ATTRIBUTE17|ATTRIBUTE18|ATTRIBUTE19|ATTRIBUTE20|ATTRIBUTE21|ATTRIBUTE22|ATTRIBUTE23|ATTRIBUTE24|ATTRIBUTE25|ATTRIBUTE26|ATTRIBUTE27|ATTRIBUTE28|ATTRIBUTE29|ATTRIBUTE30|FT_ALTERNATE_REC|FT_ALTERNATE_KEY");

			F_PERSON_PHONE_VO fPERSON_PHONE_VO = new F_PERSON_PHONE_VO();
			fPERSON_PHONE_VO.setPHONE_ID(createPrimaryPhoneId(hcmTaleoEmployee.getEmployeeId()));
			fPERSON_PHONE_VO.setPHONE_TYPE("W1");
			fPERSON_PHONE_VO.setDATE_FROM(hcmTaleoEmployee.getStartDate());
			fPERSON_PHONE_VO.setDATE_TO(CreateEmployeeConstants.getCreateEffectiveEndDate());

			fPERSON_PHONE_VO.setPERSON_ID(createPersonId(hcmTaleoEmployee.getEmployeeId()));
			fPERSON_PHONE_VO.setBUSINESS_GROUP_ID(CreateEmployeeConstants.getCreateBusinessGroupId());
			fPERSON_PHONE_VO.setFT_ALTERNATE_REC("PERSONAL_PHONE");
			fPERSON_PHONE_VO.setFT_ALTERNATE_KEY(createPrimaryPhoneId(hcmTaleoEmployee.getEmployeeId()));
			fPERSON_PHONE_VO.setPHONE_NUMBER("111-111-1111");
			fPERSON_PHONE_VO.setPRIMARY_FLAG("Y");

			out.write("\r\n");
			out.write(fPERSON_PHONE_VO.toDelimitedString().replaceAll("null", ""));

			logger.debug("Write file phone");

			pPhoneFileWriter.flush();
			out.flush();
			pPhoneFileWriter.close();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.FATAL, e.getMessage(), e);
			throw new Exception(e);
		}
	}

	private static void createPersonReligionFile(File pFolder, HCMTaleoEmployee hcmTaleoEmployee) throws Exception {
		try {
			String pReligionFile = pFolder.getPath() + File.separator + "F_PERSON_RELIGION_VO.dat";
			FileWriter pReligionFileWriter = new FileWriter(pReligionFile);

			BufferedWriter out = new BufferedWriter(pReligionFileWriter);

			out.write(
					"RELIGION_ID|BUSINESS_GROUP_ID|PERSON_ID|LEGISLATION_CODE|PRIMARY_FLAG|RELIGION|ATTRIBUTE_CATEGORY|ATTRIBUTE1|ATTRIBUTE2|ATTRIBUTE3|ATTRIBUTE4|ATTRIBUTE5|ATTRIBUTE6|ATTRIBUTE7|ATTRIBUTE8|ATTRIBUTE9|ATTRIBUTE10|ATTRIBUTE11|ATTRIBUTE12|ATTRIBUTE13|ATTRIBUTE14|ATTRIBUTE15|ATTRIBUTE16|ATTRIBUTE17|ATTRIBUTE18|ATTRIBUTE19|ATTRIBUTE20|ATTRIBUTE21|ATTRIBUTE22|ATTRIBUTE23|ATTRIBUTE24|ATTRIBUTE25|ATTRIBUTE26|ATTRIBUTE27|ATTRIBUTE28|ATTRIBUTE29|ATTRIBUTE30|ATTRIBUTE_NUMBER1|ATTRIBUTE_NUMBER2|ATTRIBUTE_NUMBER3|ATTRIBUTE_NUMBER4|ATTRIBUTE_NUMBER5|ATTRIBUTE_NUMBER6|ATTRIBUTE_NUMBER7|ATTRIBUTE_NUMBER8|ATTRIBUTE_NUMBER9|ATTRIBUTE_NUMBER10|ATTRIBUTE_NUMBER11|ATTRIBUTE_NUMBER12|ATTRIBUTE_NUMBER13|ATTRIBUTE_NUMBER14|ATTRIBUTE_NUMBER15|ATTRIBUTE_NUMBER16|ATTRIBUTE_NUMBER17|ATTRIBUTE_NUMBER18|ATTRIBUTE_NUMBER19|ATTRIBUTE_NUMBER20|ATTRIBUTE_DATE1|ATTRIBUTE_DATE2|ATTRIBUTE_DATE3|ATTRIBUTE_DATE4|ATTRIBUTE_DATE5|ATTRIBUTE_DATE6|ATTRIBUTE_DATE7|ATTRIBUTE_DATE8|ATTRIBUTE_DATE9|ATTRIBUTE_DATE10|ATTRIBUTE_DATE11|ATTRIBUTE_DATE12|ATTRIBUTE_DATE13|ATTRIBUTE_DATE14|ATTRIBUTE_DATE15|USERKEY1|USERKEY2|USERKEY3|USERKEY4|USERKEY5|USERKEY6|USERKEY7|USERKEY8|USERKEY9|USERKEY10|USERKEYVALUE1|USERKEYVALUE2|USERKEYVALUE3|USERKEYVALUE4|USERKEYVALUE5|USERKEYVALUE6|USERKEYVALUE7|USERKEYVALUE8|USERKEYVALUE9|USERKEYVALUE10|");
			out.write("\r\n");
			F_PERSON_RELIGION_VO fPerson_RELIGION_VO = new F_PERSON_RELIGION_VO();
			fPerson_RELIGION_VO.setRELIGION_ID(hcmTaleoEmployee.getEmployeeId());
			fPerson_RELIGION_VO.setPERSON_ID(createPersonId(hcmTaleoEmployee.getEmployeeId()));
			fPerson_RELIGION_VO.setLEGISLATION_CODE(hcmTaleoEmployee.getHcmLegislationCode());
			out.write(fPerson_RELIGION_VO.toDelimitedString().replaceAll("null", ""));
			out.write("\r\n");

			pReligionFileWriter.flush();
			out.flush();
			pReligionFileWriter.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.FATAL, e.getMessage(), e);
			throw new Exception(e);
		}

	}

	private static void createPersonTypeUsageFile(File pFolder, HCMTaleoEmployee hcmTaleoEmployee) throws Exception {
		try {
			String pUsageFile = pFolder.getPath() + File.separator + "F_PERSON_TYPE_USAGE_VO.dat";

			FileWriter pUsageFileWriter = new FileWriter(pUsageFile);

			BufferedWriter out = new BufferedWriter(pUsageFileWriter);
			out.write(
					"PERSON_TYPE_USAGE_ID|EFFECTIVE_START_DATE|EFFECTIVE_END_DATE|EFFECTIVE_SEQUENCE|EFFECTIVE_LATEST_CHANGE|PERSON_ID|PERSON_TYPE_ID|SYSTEM_PERSON_TYPE|LEGAL_ENTITY_ID|ATTRIBUTE_CATEGORY|ATTRIBUTE1|ATTRIBUTE2|ATTRIBUTE3|ATTRIBUTE4|ATTRIBUTE5|ATTRIBUTE6|ATTRIBUTE7|ATTRIBUTE8|ATTRIBUTE9|ATTRIBUTE10|ATTRIBUTE11|ATTRIBUTE12|ATTRIBUTE13|ATTRIBUTE14|ATTRIBUTE15|ATTRIBUTE16|ATTRIBUTE17|ATTRIBUTE18|ATTRIBUTE19|ATTRIBUTE20|ATTRIBUTE21|ATTRIBUTE22|ATTRIBUTE23|ATTRIBUTE24|ATTRIBUTE25|ATTRIBUTE26|ATTRIBUTE27|ATTRIBUTE28|ATTRIBUTE29|ATTRIBUTE30|FT_ALTERNATE_REC|FT_ALTERNATE_KEY");
			out.write("\r\n");
			pUsageFileWriter.flush();
			out.flush();
			pUsageFileWriter.close();

			out.close();

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.FATAL, e.getMessage(), e);
			throw new Exception(e);
		}
	}

	public static String createPersonId(String employeeId) {
		employeeId = CreateEmployeeConstants.getCreatePersonId().replace("#", employeeId);
		return employeeId;
	}

	public static String createPrimaryPhoneId(String employeeId) {
		employeeId = CreateEmployeeConstants.getCreatePrimaryPhId().replace("#", employeeId);
		return employeeId;
	}

	public static String createPrimaryNIDId(String employeeId) {
		employeeId = CreateEmployeeConstants.getCreatePrimaryNIDId().replace("#", employeeId);
		return employeeId;
	}

	public static String createAddressUsageId(String employeeId) {
		employeeId = CreateEmployeeConstants.getCreateAddressUsageId().replace("#", employeeId);
		return employeeId;
	}

	public static String createPersonNameId(String employeeId) {
		employeeId = CreateEmployeeConstants.getCreatePersonNameId().replace("#", employeeId);
		return employeeId;
	}
}
