package com.invensense.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.invensense.connector.HCMConnector;
import com.invensense.connector.TaleoConnector;
import com.invensense.dao.EmployeeOperationsDao;
import com.invensense.dao.UtilitiesDao;
import com.invensense.impl.hcm.UploadFile;
import com.invensense.impl.taleo.CreateFBLWorkRelations;
import com.invensense.impl.taleo.CreatePersonFiles;
import com.invensense.impl.taleo.CreateWorkRelations;
import com.invensense.model.hcmtaleo.Employee;
import com.invensense.model.hcmtaleo.HCMTaleoEmployee;
import com.invensense.utils.CreateEmployeeConstants;

@Repository("employeeOperationsDao")
public class EmployeeOperationsDaoImpl implements EmployeeOperationsDao {
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	@Qualifier("utilitiesDao")
	private UtilitiesDao uDao;

	private static ArrayList<String> fileList = null;

	private static String sourceFolder = null;

	public String employeeUpdate(String employeeUpdateIn) throws Exception {
		// Call HCM
		logger.info("In empUpdate ::Calling HCMConnector:: " + employeeUpdateIn);
		HCMConnector hcmConnector = new HCMConnector();
		List<HCMTaleoEmployee> hcmTaleoEmployeeList = hcmConnector.employeeUpdate(employeeUpdateIn);

		logger.debug("In empUpdate :: Employee updates :" + hcmTaleoEmployeeList.size());

		System.out.println("HCM response : " + hcmTaleoEmployeeList.size());

		Collections.reverse(hcmTaleoEmployeeList);
		if (hcmTaleoEmployeeList.size() != 0) {

			for (int i = 0; i < hcmTaleoEmployeeList.size(); i++) {
				hcmTaleoEmployeeList.get(i).setEmployeeId(uDao.getPerson(hcmTaleoEmployeeList.get(i).getHcmPersonId(),
						hcmTaleoEmployeeList.get(i).getHcmPersonNumber()).getTBEempID());
			}
			// Call Taleo
			logger.info("In empUpdate ::Calling TaleoConnector");

			TaleoConnector taleoConnector = new TaleoConnector();
			taleoConnector.employeeUpdate(hcmTaleoEmployeeList);
		}

		return "Success";
	}

	public String employeeTerminate(String employeeTerminateIn) throws Exception {
		// Call HCM
		logger.info("In empTerminate ::Calling HCMConnector");

		HCMConnector hcmConnector = new HCMConnector();
		List<HCMTaleoEmployee> hcmTaleoEmployeeList = hcmConnector.employeeTerminate(employeeTerminateIn);

		logger.info("In empTerminate :: Employee terminates size::" + hcmTaleoEmployeeList.size());
		Collections.reverse(hcmTaleoEmployeeList);
		// Call Taleo
		if (hcmTaleoEmployeeList.size() != 0) {
			logger.info("In empTerminate :: calling TaleoConnector");

			for (int i = 0; i < hcmTaleoEmployeeList.size(); i++) {
				hcmTaleoEmployeeList.get(i).setEmployeeId(uDao.getPerson(hcmTaleoEmployeeList.get(i).getHcmPersonId(),
						hcmTaleoEmployeeList.get(i).getHcmPersonNumber()).getTBEempID());
			}
			TaleoConnector taleoConnector = new TaleoConnector();
			taleoConnector.employeeTerminate(hcmTaleoEmployeeList);
		}
		return "Success";
	}

	public List<HCMTaleoEmployee> createEmployee(String createEmployeeIn) throws Exception {

		TaleoConnector tConnector = new TaleoConnector();
		List<HCMTaleoEmployee> hcmTaleoEmployees = new ArrayList<HCMTaleoEmployee>();
		try {

			hcmTaleoEmployees = tConnector.getCreateEmployee(createEmployeeIn);
			for (int i = 0; i < hcmTaleoEmployees.size(); i++) {
				HCMTaleoEmployee hcmTaleoEmployee = hcmTaleoEmployees.get(i);

				logger.debug("Legislation code input : " + hcmTaleoEmployee.getLegislationCode());
				logger.debug("Legal entity input: " + hcmTaleoEmployee.getLegalEntity());
				logger.debug("Business Unit Id : " + hcmTaleoEmployee.getBusinessUnit());
				logger.debug("State Id : " + hcmTaleoEmployee.getState());
				
				hcmTaleoEmployee.setHcmLegalEntity(uDao.getHCMId(hcmTaleoEmployee.getLegalEntity()).getHcmGuid());
				hcmTaleoEmployee
						.setHcmLegislationCode(uDao.getHCMId(hcmTaleoEmployee.getLegislationCode()).getDescription());
				hcmTaleoEmployee.setHcmBusinessUnit(uDao.getHCMId(hcmTaleoEmployee.getBusinessUnit()).getSrcData());
				hcmTaleoEmployee.setHcmState(uDao.getHCMId(hcmTaleoEmployee.getState()).getSrcData());

				logger.debug("State Id : " + hcmTaleoEmployee.getHcmState());
				logger.debug("Legislation code : " + hcmTaleoEmployee.getHcmLegislationCode());
				logger.debug("Legal entity : " + hcmTaleoEmployee.getHcmLegalEntity());
				logger.debug("Business Unit : " + hcmTaleoEmployee.getHcmBusinessUnit());

				//check if the person exists in the database table
				Employee emp = new Employee();
				if(hcmTaleoEmployee.getEmailAddress()!=null)
			    {
				   logger.debug("Work EmailID : " + hcmTaleoEmployee.getEmailAddress());
				   emp=uDao.checkExistingEmployee(hcmTaleoEmployee.getEmailAddress());
			    }
				if ((emp.getFBLPersonId()!=null)&&(emp.getFBLPersonId()!=""))
				{
					logger.debug("Creating WR only Begin with PersonId: "+emp.getHCMPersonID());
					hcmTaleoEmployee.setFblPersonId(emp.getFBLPersonId());
					hcmTaleoEmployee.setHcmPersonNumber(emp.getPersonNumber());
					hcmTaleoEmployee.setHcmPersonId(emp.getHCMPersonID());
					logger.debug("HCMTALEOPERSON ID PersonId: "+hcmTaleoEmployee.getHcmPersonId());
					if (((hcmTaleoEmployee.getHcmLegislationCode() != null)
						&& (!hcmTaleoEmployee.getHcmLegislationCode().isEmpty()))
						|| ((hcmTaleoEmployee.getHcmLegalEntity() != null)
								&& (!hcmTaleoEmployee.getHcmLegalEntity().isEmpty()))) {
					Date d1 = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
					String fileName = "FBL_" + sdf.format(d1);
					String folder = CreateEmployeeConstants.getCreateFolder() + fileName;
					logger.debug("Creating WR Folder name ::" + folder+" created for Person "+hcmTaleoEmployee.getFirstName()+" "+hcmTaleoEmployee.getLastName());
					File dir = new File(folder);
					dir.mkdirs();
					dir.setExecutable(true);
					dir.setWritable(true);					
					String wFolderName = folder + File.separator + "WorkRelationship";					
					File wFolder = new File(folder + File.separator + "WorkRelationship");
					wFolder.mkdirs();
					wFolder.setWritable(true);
					wFolder.setExecutable(true);
					logger.debug("Creating WR only Before try : ");
					try {
						UploadFile uploadFile = new UploadFile();
						com.invensense.utils.ZipUsingJavaUtil zipUsingJavaUtil = new com.invensense.utils.ZipUsingJavaUtil();						
						logger.debug("Creating WR only inside try : ");
						CreateFBLWorkRelations.createAllWorkRelations(wFolder, hcmTaleoEmployee);
						//CreateFBLWorkRelations.createAllWorkRelations(wFolder, hcmTaleoEmployee);
						String wrZipName = folder + File.separator + fileName + "WR.zip";	
						zipUsingJavaUtil.zipFiles(wFolderName, wrZipName);
						uploadFile.uploadFileAndLoad(fileName + "WR", wrZipName, "WorkRelationship");
						hcmTaleoEmployees.set(0, hcmTaleoEmployee);
						uDao.createPerson(hcmTaleoEmployees);
					} catch (Exception e) {
						logger.error("In createEmployee employee operations:::exception");
						logger.log(Level.FATAL, e.getMessage(), e);
						throw new Exception(e);

					}
			    }
			    }
				else{
				 String personNumber = uDao.getPersonIdSequence();
				    logger.debug("Person number for the employee id :: "+hcmTaleoEmployee.getEmployeeId()+" is  "+personNumber);
				    
				    hcmTaleoEmployee.setHcmPersonNumber(personNumber);
				// Add the constants
				
				if (((hcmTaleoEmployee.getHcmLegislationCode() != null)
						&& (!hcmTaleoEmployee.getHcmLegislationCode().isEmpty()))
						|| ((hcmTaleoEmployee.getHcmLegalEntity() != null)
								&& (!hcmTaleoEmployee.getHcmLegalEntity().isEmpty()))) {
					HCMTaleoEmployee hcmTaleoEmployeeNew = null;
					Date d1 = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
					String fileName = "FBL_" + sdf.format(d1);
					String folder = CreateEmployeeConstants.getCreateFolder() + fileName;
					logger.debug("Folder name ::" + folder+" created for Person "+hcmTaleoEmployee.getFirstName()+" "+hcmTaleoEmployee.getLastName());
					File dir = new File(folder);
					dir.mkdirs();
					dir.setExecutable(true);
					dir.setWritable(true);
					String pFolderName = folder + File.separator + "Person";
					String wFolderName = folder + File.separator + "WorkRelationship";
					File pFolder = new File(folder + File.separator + "Person");
					pFolder.mkdirs();
					pFolder.setWritable(true);
					pFolder.setExecutable(true);
					File wFolder = new File(folder + File.separator + "WorkRelationship");
					wFolder.mkdirs();
					wFolder.setWritable(true);
					wFolder.setExecutable(true);
					try {
						UploadFile uploadFile = new UploadFile();
						com.invensense.utils.ZipUsingJavaUtil zipUsingJavaUtil = new com.invensense.utils.ZipUsingJavaUtil();
						hcmTaleoEmployeeNew = CreatePersonFiles.createAllPersonFiles(pFolder, hcmTaleoEmployee);						
						String pZipName = folder + File.separator + fileName + "P.zip";
						zipUsingJavaUtil.zipFiles(pFolderName, pZipName);

						uploadFile.uploadFileAndLoad(fileName + "P", pZipName, "Person");
						try {
					          Thread.sleep(30000);
					      } catch(InterruptedException ex) {
					          Thread.currentThread().interrupt();
					      }
						CreateWorkRelations.createAllWorkRelations(wFolder, hcmTaleoEmployee);
						//CreateFBLWorkRelations.createAllWorkRelations(wFolder, hcmTaleoEmployee);
						String wrZipName = folder + File.separator + fileName + "WR.zip";	
						zipUsingJavaUtil.zipFiles(wFolderName, wrZipName);
						uploadFile.uploadFileAndLoad(fileName + "WR", wrZipName, "WorkRelationship");
						hcmTaleoEmployees.set(0, hcmTaleoEmployeeNew);
						uDao.createPerson(hcmTaleoEmployees);
				
						logger.debug("Creation completed for  "+hcmTaleoEmployee.getFirstName()+" "+hcmTaleoEmployee.getLastName());
						
					} catch (Exception e) {
						logger.error("In createEmployee employee operations:::exception");
						logger.log(Level.FATAL, e.getMessage(), e);
						throw new Exception(e);

					}
				} else {
					logger.error("Legislation code or Legal entity not found for Person : "+hcmTaleoEmployee.getFirstName()+" "+hcmTaleoEmployee.getLastName());
					throw new Exception("Legal entity or Legislation code not found");
				}

			}
			}

		} catch (Exception e) {
			logger.error("In createEmployee employee operations:::exception");
			logger.log(Level.FATAL, e.getMessage(), e);
			throw new Exception(e);

		}
		return hcmTaleoEmployees;
	}

	@Override
	public String empAssignmentUpdate(String empAssignmentUpdateIn) throws Exception {
		// Call HCM
		logger.info("In empAssignmentUpdate ::Calling HCMConnector");

		HCMConnector hcmConnector = new HCMConnector();
		List<HCMTaleoEmployee> hcmTaleoEmployeeList = hcmConnector.empAssignmentUpdate(empAssignmentUpdateIn);

		logger.info("In empAssignmentUpdate :: Employee assignment updates size::" + hcmTaleoEmployeeList.size());
		Collections.reverse(hcmTaleoEmployeeList);
		// Call Taleo
		if (hcmTaleoEmployeeList.size() != 0) {
			logger.info("In empAssignmentUpdate :: calling TaleoConnector");

			for (int i = 0; i < hcmTaleoEmployeeList.size(); i++) {
				hcmTaleoEmployeeList.get(i).setEmployeeId(uDao.getPerson(hcmTaleoEmployeeList.get(i).getHcmPersonId(),
						hcmTaleoEmployeeList.get(i).getHcmPersonNumber()).getTBEempID());
				if (hcmTaleoEmployeeList.get(i).getManagerId() != null)
					hcmTaleoEmployeeList.get(i)
							.setManagerPersonNo(uDao.getPerson(hcmTaleoEmployeeList.get(i).getManagerId(),
									hcmTaleoEmployeeList.get(i).getHcmPersonNumber()).getTBEempID());
			}
			TaleoConnector taleoConnector = new TaleoConnector();
			taleoConnector.empAssignmentUpdate(hcmTaleoEmployeeList);
		}
		return "Success";
	}

	public String newhireUpdate(String newhireUpdateIn) throws Exception {
		// Call HCM
		logger.info("In newhireUpdate ::Calling HCMConnector");
		String updatedRecs = "0";
		HCMConnector hcmConnector = new HCMConnector();
		List<HCMTaleoEmployee> hcmTaleoEmployeeList = hcmConnector.newhireUpdate(newhireUpdateIn);

		logger.info("In newhireUpdate :: Employee new hire updates size::" + hcmTaleoEmployeeList.size());
		if (hcmTaleoEmployeeList.size() != 0) {
			logger.info("In newhireUpdate :: calling database update");

			for (int i = 0; i < hcmTaleoEmployeeList.size(); i++) {
				hcmTaleoEmployeeList.get(i).setEmployeeId(uDao.getPerson(hcmTaleoEmployeeList.get(i).getHcmPersonId(),
						hcmTaleoEmployeeList.get(i).getHcmPersonNumber()).getTBEempID());
				if (hcmTaleoEmployeeList.get(i).getHcmPersonNumber() != null) {
					updatedRecs = uDao.updateNewHirePerson(hcmTaleoEmployeeList.get(i).getHcmPersonNumber(),
							hcmTaleoEmployeeList.get(i).getHcmPersonId());
					logger.info("In newhireUpdate :: Updated records is : " + updatedRecs);
				}
			}
	
		}
		return "Success";
	}

	public List<HCMTaleoEmployee> reverseList(List<HCMTaleoEmployee> hcmTaleoEmployees) {
		Collections.reverse(hcmTaleoEmployees);
		return hcmTaleoEmployees;
	}

	@Override
	public String createLocation(String createLocationIn) throws Exception {
		// TODO Auto-generated method stub
		logger.info("In createLocation ::Calling HCMConnector");

		// logger.info("testing database::
		// "+uDao.getInterfaceDate("createLocation"));
		// HCMConnector hcmConnector = new HCMConnector();
		/*
		 * List<HCMTaleoLocations> hcmTaleoLocationList =
		 * hcmConnector.getLocation(createLocationIn);
		 * 
		 * logger.info("In createLocationIn :: New Location list size::" +
		 * hcmTaleoLocationList.size());
		 * Collections.reverse(hcmTaleoLocationList); // Call Taleo if
		 * (hcmTaleoLocationList.size() != 0) { logger.info(
		 * "In createLocation :: calling TaleoConnector");
		 * 
		 * TaleoConnector taleoConnector = new TaleoConnector();
		 * taleoConnector.createTaleoLocation(hcmTaleoLocationList); }
		 */
		return "Success";
	}

}
