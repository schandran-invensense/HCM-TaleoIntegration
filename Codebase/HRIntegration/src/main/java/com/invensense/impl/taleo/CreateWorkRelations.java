package com.invensense.impl.taleo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.invensense.model.hcmtaleo.HCMTaleoEmployee;
import com.invensense.model.workrelations.F_ASSIGNMENT_VO;
import com.invensense.model.workrelations.F_ASSIGNMENT_WORK_MEASURE_VO;
import com.invensense.model.workrelations.F_CONTRACT_VO;
import com.invensense.model.workrelations.F_WORK_RELATIONSHIP_VO;
import com.invensense.model.workrelations.F_WORK_TERMS_VO;
import com.invensense.utils.CreateEmployeeConstants;

public class CreateWorkRelations {

	private static Logger logger = Logger.getLogger(CreateWorkRelations.class);

	public static void createAllWorkRelations(File wFolder,HCMTaleoEmployee hcmTaleoEmployee) {
		logger.debug("WorkRelations file in ::" + wFolder.getPath());
		createAssignmentSupervisorFile(wFolder, hcmTaleoEmployee);
		createAssignmentFile(wFolder, hcmTaleoEmployee);
		createAssignWorkMeasureFile(wFolder, hcmTaleoEmployee);
		createWorkRelationshipFile(wFolder, hcmTaleoEmployee);
		createWorkTermsFile(wFolder, hcmTaleoEmployee);

	}

	public static void createAssignmentSupervisorFile(File wFolder, HCMTaleoEmployee hcmTaleoEmployee) {
		try {
			String pAssignSupervisorFile = wFolder.getPath() + File.separator + "F_ASSIGNMENT_SUPERVISOR_VO.dat";

			FileWriter pAssignSupervisorFileWriter = new FileWriter(pAssignSupervisorFile);
			BufferedWriter out = new BufferedWriter(pAssignSupervisorFileWriter);
			out.write(
					"ACTION_OCCURRENCE_ID|ASSIGNMENT_ID|ASSIGNMENT_SUPERVISOR_ID|BUSINESS_GROUP_ID|EFFECTIVE_END_DATE|EFFECTIVE_START_DATE|MANAGER_ASSIGNMENT_ID|MANAGER_ID|MANAGER_TYPE|PERSON_ID|PRIMARY_FLAG|FT_ALTERNATE_REC|FT_ALTERNATE_KEY");
			out.newLine();

			logger.debug("Write file F_ASSIGNMENT_SUPERVISOR_VO");

			pAssignSupervisorFileWriter.flush();
			out.flush();
			pAssignSupervisorFileWriter.close();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static void createAssignmentFile(File pFolder, HCMTaleoEmployee hcmTaleoEmployee) {
		try {
			String wAssignFile = pFolder.getPath() + File.separator + "F_ASSIGNMENT_VO.dat";

			FileWriter wAssignFileWriter = new FileWriter(wAssignFile);
			BufferedWriter out = new BufferedWriter(wAssignFileWriter);
			out.write(
					"ACTION_CODE|ACTION_OCCURRENCE_ID|ASSIGNMENT_ID|ASSIGNMENT_NAME|ASSIGNMENT_NUMBER|ASSIGNMENT_SEQUENCE|ASSIGNMENT_STATUS_TYPE|ASSIGNMENT_STATUS_TYPE_ID|ASSIGNMENT_TYPE|AUTO_END_FLAG|BARGAINING_UNIT_CODE|BILLING_TITLE|BUSINESS_GROUP_ID|BUSINESS_UNIT_ID|CAGR_GRADE_DEF_ID|CAGR_ID_FLEX_NUM|COLLECTIVE_AGREEMENT_ID|CONTRACT_ID|DATE_PROBATION_END|DEFAULT_CODE_COMB_ID|DUTIES_TYPE|EFFECTIVE_END_DATE|EFFECTIVE_LATEST_CHANGE|EFFECTIVE_SEQUENCE|EFFECTIVE_START_DATE|EMPLOYEE_CATEGORY|EMPLOYMENT_CATEGORY|ESTABLISHMENT_ID|EXPENSE_CHECK_ADDRESS|FREQUENCY|GRADE_ID|GRADE_LADDER_PGM_ID|HOURLY_SALARIED_CODE|INTERNAL_BUILDING|INTERNAL_FLOOR|INTERNAL_LOCATION|INTERNAL_MAILSTOP|INTERNAL_OFFICE_NUMBER|JOB_ID|JOB_POST_SOURCE_NAME|LABOUR_UNION_MEMBER_FLAG|LEGAL_ENTITY_ID|LEGISLATION_CODE|LINKAGE_TYPE|LOCATION_ID|MANAGER_FLAG|NORMAL_HOURS|NOTICE_PERIOD|NOTICE_PERIOD_UOM|ORGANIZATION_ID|PARENT_ASSIGNMENT_ID|PEOPLE_GROUP_ID|PERIOD_OF_SERVICE_ID|PERSON_ID|PERSON_TYPE_ID|PO_HEADER_ID|PO_LINE_ID|POSITION_ID|POSITION_OVERRIDE_FLAG|POSTING_CONTENT_ID|PRIMARY_ASSIGNMENT_FLAG|PRIMARY_FLAG|PRIMARY_WORK_RELATION_FLAG|PRIMARY_WORK_TERMS_FLAG|PROBATION_PERIOD|PROBATION_UNIT|PROJECT_TITLE|PROJECTED_ASSIGNMENT_END|PROPOSED_WORKER_TYPE|REASON_CODE|RECORD_CREATOR|RETIREMENT_AGE|RETIREMENT_DATE|SAL_REVIEW_PERIOD|SAL_REVIEW_PERIOD_FREQUENCY|SET_OF_BOOKS_ID|SOURCE_TYPE|SPECIAL_CEILING_STEP_ID|STEP_ENTRY_DATE|SYSTEM_PERSON_TYPE|TAX_ADDRESS_ID|TIME_NORMAL_FINISH|TIME_NORMAL_START|VENDOR_ASSIGNMENT_NUMBER|VENDOR_EMPLOYEE_NUMBER|VENDOR_ID|VENDOR_SITE_ID|WORK_AT_HOME|WORK_TERMS_ASSIGNMENT_ID|FREEZE_START_DATE|FREEZE_UNTIL_DATE|FT_ALTERNATE_REC|FT_ALTERNATE_KEY|PROJECTED_START_DATE");
			logger.debug("Write file F_ASSIGNMENT_VO.dat");

			F_ASSIGNMENT_VO wAssign_VO = new F_ASSIGNMENT_VO();
			wAssign_VO.setACTION_CODE(CreateEmployeeConstants.getCreateActionCode());
			wAssign_VO.setASSIGNMENT_ID(createAssignmentId(hcmTaleoEmployee.getEmployeeId()));

			wAssign_VO.setASSIGNMENT_NAME("ASN" + hcmTaleoEmployee.getEmployeeId());
			wAssign_VO.setASSIGNMENT_NUMBER(createAssignmentNumber(hcmTaleoEmployee.getEmployeeId()));
			wAssign_VO.setASSIGNMENT_SEQUENCE("1");
			wAssign_VO.setASSIGNMENT_STATUS_TYPE("ACTIVE");
			wAssign_VO.setASSIGNMENT_STATUS_TYPE_ID(CreateEmployeeConstants.getCreateAssignStatusTypeId());
			wAssign_VO.setASSIGNMENT_TYPE("P");
			wAssign_VO.setAUTO_END_FLAG("Y");
			wAssign_VO.setBUSINESS_GROUP_ID(CreateEmployeeConstants.getCreateBusinessGroupId());
		//	wAssign_VO.setBUSINESS_UNIT_ID(CreateEmployeeConstants.getCreateBusinessUnitId());
wAssign_VO.setBUSINESS_UNIT_ID(hcmTaleoEmployee.getHcmBusinessUnit());
			wAssign_VO.setEFFECTIVE_END_DATE(CreateEmployeeConstants.getCreateEffectiveEndDate());
			wAssign_VO.setEFFECTIVE_LATEST_CHANGE("Y");
			wAssign_VO.setEFFECTIVE_SEQUENCE("1");
			wAssign_VO.setEFFECTIVE_START_DATE(hcmTaleoEmployee.getStartDate());
			wAssign_VO.setEMPLOYMENT_CATEGORY("FR");
			wAssign_VO.setFREQUENCY("W");
			wAssign_VO.setHOURLY_SALARIED_CODE("S");
			wAssign_VO.setLABOUR_UNION_MEMBER_FLAG("N");
			wAssign_VO.setLEGAL_ENTITY_ID(hcmTaleoEmployee.getHcmLegalEntity());
			wAssign_VO.setLEGISLATION_CODE(hcmTaleoEmployee.getHcmLegislationCode());
wAssign_VO.setPROJECTED_START_DATE(hcmTaleoEmployee.getProjStartDate());
			// wAssign_VO.setLEGAL_ENTITY_ID(CreateEmployeeConstants.getCreateLegalEntityId());
			// wAssign_VO.setLEGISLATION_CODE("US");

			wAssign_VO.setNOTICE_PERIOD("0");
			wAssign_VO.setMANAGER_FLAG("Y");
			wAssign_VO.setPERIOD_OF_SERVICE_ID(createPeriodOfServiceId(hcmTaleoEmployee.getEmployeeId()));
			wAssign_VO.setNORMAL_HOURS("40");
			wAssign_VO.setPERSON_ID(createPersonId(hcmTaleoEmployee.getEmployeeId()));
			wAssign_VO.setPERSON_TYPE_ID(CreateEmployeeConstants.getCreatePersonTypeId());
			wAssign_VO.setPOSITION_OVERRIDE_FLAG("Y");
			wAssign_VO.setPRIMARY_ASSIGNMENT_FLAG("Y");
			wAssign_VO.setPRIMARY_FLAG("Y");
			wAssign_VO.setPRIMARY_WORK_RELATION_FLAG("Y");
			wAssign_VO.setSYSTEM_PERSON_TYPE(CreateEmployeeConstants.getCreateSystemPersonType());
			wAssign_VO.setWORK_TERMS_ASSIGNMENT_ID(createWorkTermsAssignmentId(hcmTaleoEmployee.getEmployeeId()));
			wAssign_VO.setFREEZE_UNTIL_DATE(CreateEmployeeConstants.getCreateEffectiveEndDate());
			wAssign_VO.setPROPOSED_WORKER_TYPE(CreateEmployeeConstants.getCreateProposedWorkerType());
			wAssign_VO.setFREEZE_START_DATE(CreateEmployeeConstants.getCreateFreezeStartDate());
			wAssign_VO.setFT_ALTERNATE_REC("WT");
			wAssign_VO.setRETIREMENT_AGE("0");
			wAssign_VO.setFT_ALTERNATE_KEY("ASN" + hcmTaleoEmployee.getEmployeeId() + "::ASSIGNMENT");

			out.write("\r\n");
		//	logger.debug("Data in F_ASSIGNMENT_VO :: " + wAssign_VO.toDelimitedString().replaceAll("null", ""));

			out.write(wAssign_VO.toDelimitedString().replaceAll("null", ""));
			logger.debug("Write file person");

			wAssignFileWriter.flush();
			out.flush();
			wAssignFileWriter.close();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void createAssignWorkMeasureFile(File wFolder, HCMTaleoEmployee hcmTaleoEmployee) {
		try {
			String wAssignMeasureFile = wFolder.getPath() + File.separator + "F_ASSIGNMENT_WORK_MEASURE_VO.dat";

			FileWriter wAssignMeasureFileWriter = new FileWriter(wAssignMeasureFile);
			BufferedWriter out = new BufferedWriter(wAssignMeasureFileWriter);
			out.write(
					"ACTION_OCCURRENCE_ID|ADDS_TO_BUDGET|ASSIGN_WORK_MEASURE_ID|ASSIGNMENT_ID|BUSINESS_GROUP_ID|EFFECTIVE_START_DATE|EFFECTIVE_END_DATE|UNIT|VALUE|FT_ALTERNATE_REC|FT_ALTERNATE_KEY");

			logger.debug("Write file WorkAssignMeasureFile");
			F_ASSIGNMENT_WORK_MEASURE_VO fAssignment_WORK_MEASURE_VO = new F_ASSIGNMENT_WORK_MEASURE_VO();
			fAssignment_WORK_MEASURE_VO.setADDS_TO_BUDGET("Y");
			fAssignment_WORK_MEASURE_VO.setASSIGN_WORK_MEASURE_ID("ASG_FTE_ID" + hcmTaleoEmployee.getEmployeeId());
			fAssignment_WORK_MEASURE_VO.setASSIGNMENT_ID(createAssignmentId(hcmTaleoEmployee.getEmployeeId()));
			fAssignment_WORK_MEASURE_VO.setEFFECTIVE_START_DATE(hcmTaleoEmployee.getStartDate());
			fAssignment_WORK_MEASURE_VO.setEFFECTIVE_END_DATE(CreateEmployeeConstants.getCreateEffectiveEndDate());
			fAssignment_WORK_MEASURE_VO.setUNIT("FTE");
			fAssignment_WORK_MEASURE_VO.setVALUE("1");

			// out.newLine();
			out.write("\r\n");
			logger.debug("Data in F_ASSIGNMENT_WORK_MEASURE_VO :: "
					+ fAssignment_WORK_MEASURE_VO.toDelimitedString().replaceAll("null", ""));

			out.write(fAssignment_WORK_MEASURE_VO.toDelimitedString().replaceAll("null", ""));
			logger.debug("Write file F_ASSIGNMENT_WORK_MEASURE_VO");

			wAssignMeasureFileWriter.flush();
			out.flush();
			wAssignMeasureFileWriter.close();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private static void createContractFile(File wFolder, HCMTaleoEmployee hcmTaleoEmployee) {
		try {
			String wContractFile = wFolder.getPath() + File.separator + "F_CONTRACT_VO.dat";

			FileWriter wContractFileWriter = new FileWriter(wContractFile);
			BufferedWriter out = new BufferedWriter(wContractFileWriter);

			out.write(
					"ASSIGNMENT_ID|BUSINESS_GROUP_ID|CONTRACT_ID|EFFECTIVE_START_DATE|EFFECTIVE_END_DATE|CONTRACTUAL_JOB_TITLE|DESCRIPTION|DOC_STATUS|DOC_STATUS_CHANGE_DATE|DURATION|DURATION_UNITS|EXTENSION_PERIOD|EXTENSION_PERIOD_UNITS|NUMBER_OF_EXTENSIONS|PERSON_ID|CONTRACT_TYPE|WORK_TERMS_TYPE|END_REASON|EXTENSION_REASON|PARTIES|REFERENCE|START_REASON|STATUS|STATUS_REASON|");
			out.write("\r\n");
			logger.debug("Write file Work ContractFile");
			F_CONTRACT_VO fWork_Contract_VO = new F_CONTRACT_VO(hcmTaleoEmployee.getEmployeeId(), "", "", "", "", "",
					"", "", "", "", "", "", "", "", hcmTaleoEmployee.getEmployeeId(), "", "", "", "", "", "", "", "",
					"");
			out.write(fWork_Contract_VO.toDelimitedString().replaceAll("null", ""));

			wContractFileWriter.flush();
			out.flush();
			wContractFileWriter.close();
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private static void createWorkRelationshipFile(File wFolder, HCMTaleoEmployee hcmTaleoEmployee) {
		try {
			String wRelationFile = wFolder.getPath() + File.separator + "F_WORK_RELATIONSHIP_VO.dat";

			FileWriter wRelationFileWriter = new FileWriter(wRelationFile);
			BufferedWriter out = new BufferedWriter(wRelationFileWriter);
			out.write(
					"ACCEPTED_TERMINATION_DATE|ACTION_OCCURRENCE_ID|ACTUAL_TERMINATION_DATE|ADJUSTED_SVC_DATE|BUSINESS_GROUP_ID|DATE_EMPLOYEE_DATA_VERIFIED|DATE_START|FAST_PATH_EMPLOYEE|LAST_WORKING_DATE|LEGAL_ENTITY_ID|LEGISLATION_CODE|NOTIFIED_TERMINATION_DATE|ON_MILITARY_SERVICE|ORIGINAL_DATE_OF_HIRE|PERIOD_OF_SERVICE_ID|PERIOD_TYPE|PERSON_ID|PRIMARY_FLAG|PROJECTED_TERMINATION_DATE|REHIRE_AUTHORIZOR|REHIRE_REASON|REHIRE_RECOMMENDATION|TERMINATION_ACCEPTED_PERSON_ID|WORKER_NUMBER|COMMENTS|REHIRE_AUTHORIZER_PERSON_ID|FT_ALTERNATE_REC|FT_ALTERNATE_KEY");
			F_WORK_RELATIONSHIP_VO fWork_Relations_VO = new F_WORK_RELATIONSHIP_VO();
			fWork_Relations_VO.setACTION_OCCURRENCE_ID("0");
			fWork_Relations_VO.setADJUSTED_SVC_DATE(hcmTaleoEmployee.getStartDate());
			fWork_Relations_VO.setBUSINESS_GROUP_ID(CreateEmployeeConstants.getCreateBusinessGroupId());
			fWork_Relations_VO.setFAST_PATH_EMPLOYEE("Y");
			fWork_Relations_VO.setON_MILITARY_SERVICE("N");
		fWork_Relations_VO.setDATE_START(hcmTaleoEmployee.getStartDate());
		//	fWork_Relations_VO.setDATE_START("2017-01-20");
			
			// fWork_Relations_VO.setLEGAL_ENTITY_ID(CreateEmployeeConstants.getCreateLegalEntityId());
			// fWork_Relations_VO.setLEGISLATION_CODE("US");

			fWork_Relations_VO.setLEGAL_ENTITY_ID(hcmTaleoEmployee.getHcmLegalEntity());
			fWork_Relations_VO.setLEGISLATION_CODE(hcmTaleoEmployee.getHcmLegislationCode());

			fWork_Relations_VO.setORIGINAL_DATE_OF_HIRE(hcmTaleoEmployee.getStartDate());
			fWork_Relations_VO.setPERIOD_OF_SERVICE_ID(createPeriodOfServiceId(hcmTaleoEmployee.getEmployeeId()));
			fWork_Relations_VO.setPERSON_ID(createPersonId(hcmTaleoEmployee.getEmployeeId()));
			fWork_Relations_VO.setPRIMARY_FLAG("Y");
			fWork_Relations_VO.setREHIRE_RECOMMENDATION("Y");
			fWork_Relations_VO.setWORKER_NUMBER("PERSON_" + hcmTaleoEmployee.getEmployeeId());
			fWork_Relations_VO.setFT_ALTERNATE_REC("WR");
			fWork_Relations_VO.setFT_ALTERNATE_KEY("PER" + hcmTaleoEmployee.getEmployeeId() + "::WR");
			fWork_Relations_VO.setPERIOD_TYPE("P");
			out.write("\r\n");
			logger.debug("Data in F_WORK_RELATIONSHIP_VO :: "
					+ fWork_Relations_VO.toDelimitedString().replaceAll("null", ""));
			out.write(fWork_Relations_VO.toDelimitedString().replaceAll("null", ""));

			logger.debug("Write file F_WORK_RELATIONSHIP_VO");

			wRelationFileWriter.flush();
			out.flush();
			wRelationFileWriter.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private static void createWorkTermsFile(File wFolder, HCMTaleoEmployee hcmTaleoEmployee)

	{

		try {
			String wTermFile = wFolder.getPath() + File.separator + "F_WORK_TERMS_VO.dat";

			FileWriter wTermFileWriter = new FileWriter(wTermFile);
			BufferedWriter out = new BufferedWriter(wTermFileWriter);
			out.write(
					"ACTION_CODE|ACTION_OCCURRENCE_ID|ASSIGNMENT_ID|ASSIGNMENT_NAME|ASSIGNMENT_NUMBER|ASSIGNMENT_SEQUENCE|ASSIGNMENT_STATUS_TYPE|ASSIGNMENT_STATUS_TYPE_ID|ASSIGNMENT_TYPE|AUTO_END_FLAG|BARGAINING_UNIT_CODE|BILLING_TITLE|BUSINESS_GROUP_ID|BUSINESS_UNIT_ID|CAGR_GRADE_DEF_ID|CAGR_ID_FLEX_NUM|COLLECTIVE_AGREEMENT_ID|CONTRACT_ID|DATE_PROBATION_END|DEFAULT_CODE_COMB_ID|DUTIES_TYPE|EFFECTIVE_END_DATE|EFFECTIVE_LATEST_CHANGE|EFFECTIVE_SEQUENCE|EFFECTIVE_START_DATE|EMPLOYEE_CATEGORY|EMPLOYMENT_CATEGORY|ESTABLISHMENT_ID|EXPENSE_CHECK_ADDRESS|FREQUENCY|GRADE_ID|GRADE_LADDER_PGM_ID|HOURLY_SALARIED_CODE|INTERNAL_BUILDING|INTERNAL_FLOOR|INTERNAL_LOCATION|INTERNAL_MAILSTOP|INTERNAL_OFFICE_NUMBER|JOB_ID|JOB_POST_SOURCE_NAME|LABOUR_UNION_MEMBER_FLAG|LEGAL_ENTITY_ID|LEGISLATION_CODE|LINKAGE_TYPE|LOCATION_ID|MANAGER_FLAG|NORMAL_HOURS|NOTICE_PERIOD|NOTICE_PERIOD_UOM|ORGANIZATION_ID|PARENT_ASSIGNMENT_ID|PEOPLE_GROUP_ID|PERIOD_OF_SERVICE_ID|PERSON_ID|PERSON_TYPE_ID|PO_HEADER_ID|PO_LINE_ID|POSITION_ID|POSITION_OVERRIDE_FLAG|POSTING_CONTENT_ID|PRIMARY_ASSIGNMENT_FLAG|PRIMARY_FLAG|PRIMARY_WORK_RELATION_FLAG|PRIMARY_WORK_TERMS_FLAG|PROBATION_PERIOD|PROBATION_UNIT|PROJECT_TITLE|PROJECTED_ASSIGNMENT_END|PROPOSED_WORKER_TYPE|REASON_CODE|RECORD_CREATOR|RETIREMENT_AGE|RETIREMENT_DATE|SAL_REVIEW_PERIOD|SAL_REVIEW_PERIOD_FREQUENCY|SET_OF_BOOKS_ID|SOURCE_TYPE|SPECIAL_CEILING_STEP_ID|STEP_ENTRY_DATE|SYSTEM_PERSON_TYPE|TAX_ADDRESS_ID|TIME_NORMAL_FINISH|TIME_NORMAL_START|VENDOR_ASSIGNMENT_NUMBER|VENDOR_EMPLOYEE_NUMBER|VENDOR_ID|VENDOR_SITE_ID|WORK_AT_HOME|WORK_TERMS_ASSIGNMENT_ID|FREEZE_START_DATE|FREEZE_UNTIL_DATE|FT_ALTERNATE_REC|FT_ALTERNATE_KEY|PROJECTED_START_DATE");
			logger.debug("Write file F_WORK_TERMS_VO");

			F_WORK_TERMS_VO fWork_Terms_VO = new F_WORK_TERMS_VO();

			fWork_Terms_VO.setACTION_CODE(CreateEmployeeConstants.getCreateActionCode());
			fWork_Terms_VO.setASSIGNMENT_ID(createWorkTermsAssignmentId(hcmTaleoEmployee.getEmployeeId()));
		//Added new
			
			fWork_Terms_VO.setASSIGNMENT_NAME(hcmTaleoEmployee.getJobTitle());
			fWork_Terms_VO.setASSIGNMENT_NUMBER(createWorkTermsAssignmentId(hcmTaleoEmployee.getEmployeeId()));
			fWork_Terms_VO.setASSIGNMENT_SEQUENCE("1");
			fWork_Terms_VO.setASSIGNMENT_STATUS_TYPE_ID(CreateEmployeeConstants.getCreateAssignStatusTypeId());
			fWork_Terms_VO.setASSIGNMENT_STATUS_TYPE("ACTIVE");
			fWork_Terms_VO.setASSIGNMENT_TYPE("PT");
			fWork_Terms_VO.setAUTO_END_FLAG("Y");
			fWork_Terms_VO.setBUSINESS_GROUP_ID(CreateEmployeeConstants.getCreateBusinessGroupId());
	//		fWork_Terms_VO.setBUSINESS_UNIT_ID(CreateEmployeeConstants.getCreateBusinessUnitId());
		fWork_Terms_VO.setBUSINESS_UNIT_ID(hcmTaleoEmployee.getHcmBusinessUnit());
			fWork_Terms_VO.setEFFECTIVE_END_DATE(CreateEmployeeConstants.getCreateEffectiveEndDate());
			fWork_Terms_VO.setEFFECTIVE_LATEST_CHANGE("Y");
			fWork_Terms_VO.setEFFECTIVE_SEQUENCE("1");
			fWork_Terms_VO.setEFFECTIVE_START_DATE(hcmTaleoEmployee.getStartDate());

			fWork_Terms_VO.setLEGAL_ENTITY_ID(hcmTaleoEmployee.getHcmLegalEntity());
			fWork_Terms_VO.setLEGISLATION_CODE(hcmTaleoEmployee.getHcmLegislationCode());

			// fWork_Terms_VO.setLEGAL_ENTITY_ID(CreateEmployeeConstants.getCreateLegalEntityId());
			// fWork_Terms_VO.setLEGISLATION_CODE("US");

			fWork_Terms_VO.setPERIOD_OF_SERVICE_ID(createPeriodOfServiceId(hcmTaleoEmployee.getEmployeeId()));
			fWork_Terms_VO.setPERSON_ID(createPersonId(hcmTaleoEmployee.getEmployeeId()));
			fWork_Terms_VO.setPOSITION_OVERRIDE_FLAG("Y");
			fWork_Terms_VO.setPRIMARY_FLAG("N");
			fWork_Terms_VO.setPRIMARY_WORK_RELATION_FLAG("Y");
			fWork_Terms_VO.setPRIMARY_WORK_TERMS_FLAG("Y");
			fWork_Terms_VO.setPROPOSED_WORKER_TYPE(CreateEmployeeConstants.getCreateProposedWorkerType());
			fWork_Terms_VO.setREASON_CODE("PENDWKR");
			fWork_Terms_VO.setSYSTEM_PERSON_TYPE(CreateEmployeeConstants.getCreateSystemPersonType());
			fWork_Terms_VO.setFREEZE_START_DATE(CreateEmployeeConstants.getCreateFreezeStartDate());
			fWork_Terms_VO.setFREEZE_UNTIL_DATE(CreateEmployeeConstants.getCreateEffectiveEndDate());
			fWork_Terms_VO.setFT_ALTERNATE_REC("WT");
			fWork_Terms_VO.setFT_ALTERNATE_KEY("WT" + hcmTaleoEmployee.getEmployeeId() + "::WorkTerm");
			fWork_Terms_VO.setPROJECTED_START_DATE(hcmTaleoEmployee.getProjStartDate());
			// out.newLine();
			out.write("\r\n");
		//	logger.debug("Data in F_WORK_TERMS_VO :: " + fWork_Terms_VO.toDelimitedString().replaceAll("null", ""));

			out.write(fWork_Terms_VO.toDelimitedString().replaceAll("null", ""));
			logger.debug("Write file F_WORK_TERMS_VO");

			wTermFileWriter.flush();
			out.flush();
			wTermFileWriter.close();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static String createPersonId(String employeeId) {
		employeeId = CreateEmployeeConstants.getCreatePersonId().replace("#", employeeId);
		return employeeId;
	}

	public static String createAssignmentId(String employeeId) {
		employeeId = CreateEmployeeConstants.getCreateAssignmentId().replace("#", employeeId);
		return employeeId;
	}

	public static String createPeriodOfServiceId(String employeeId) {
		employeeId = CreateEmployeeConstants.getCreatePeriodOfServiceId().replace("#", employeeId);
		return employeeId;
	}

	public static String createAssignmentNumber(String employeeId) {
		employeeId = CreateEmployeeConstants.getCreateAssignmentNumber().replace("#", employeeId);
		return employeeId;
	}

	public static String createBusinessUnitId(String employeeId) {
		employeeId = CreateEmployeeConstants.getCreateBusinessUnitId().replace("#", employeeId);
		return employeeId;
	}

	public static String createWorkTermsAssignmentId(String employeeId) {
		employeeId = CreateEmployeeConstants.getCreateWorkTermsAssignId().replace("#", employeeId);
		return employeeId;
	}
}
