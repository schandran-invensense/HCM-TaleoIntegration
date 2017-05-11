package com.invensense.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.invensense.dao.EmployeeOperationsDao;
import com.invensense.dao.UtilitiesDao;
import com.invensense.model.hcmtaleo.HCMTaleoEmployee;

public class ScheduleController {
	@Autowired
	@Qualifier("employeeOperationsDao")
	private EmployeeOperationsDao eDao;
	@Autowired
	@Qualifier("utilitiesDao")
	private UtilitiesDao uDao;
	private Logger logger = Logger.getLogger(this.getClass());

	public void employeeUpdate() {
		try {
			logger.info("Schedule employeeUpdate*******************" + new Date());

			logger.debug("Empupdate :::In run method******************************");
			logger.info("In empUpdate :: Employee update started");
			eDao.employeeUpdate(uDao.getInterfaceDate("empUpdate"));
			logger.info("After employeeUpdate ");
			uDao.updateInterfaceDate("empUpdate");
			logger.info("In empUpdate :: Employee update completed");
		} catch (Exception e) {
			logger.error("In empUpdate:::exception");
			logger.log(Level.FATAL, e.getMessage(), e);
			e.printStackTrace();
		}
	}

	public void employeeTerminate() {
		try {
			logger.info("In empTerminate :: Employee termination started");
			logger.info("Gettingupdated date from table in empTerminate :" + uDao.getInterfaceDate("empTerminate"));
			eDao.employeeTerminate(uDao.getInterfaceDate("empTerminate"));
			uDao.updateInterfaceDate("empTerminate");
			logger.info("In empTerminate :: Employee termination completed");
		} catch (Exception e) {
			logger.error("In empTerminate:::exception");
			logger.log(Level.FATAL, e.getMessage(), e);

			e.printStackTrace();
		}

	}

	public void createEmployee() {
		try {
			logger.info("In createEmployee :: Employee creation started");

			List<HCMTaleoEmployee> hcmTaleoEmployees = eDao.createEmployee(uDao.getInterfaceDate("createEmployee"));

			uDao.updateInterfaceDate("createEmployee");
			logger.info("In createEmployee :: Employee creation completed");
			// update entry in our table
			uDao.createPerson(hcmTaleoEmployees);
		} catch (Exception e) {
			logger.error("In createEmployee:::exception");
			logger.log(Level.FATAL, e.getMessage(), e);

			e.printStackTrace();
		}
	}

	public void employeeAssignmentUpdate() {
		try {

			logger.info("Schedule employeeAssignmentUpdate*******************" + new Date());
			logger.info("In empAssignmentUpdate :: Employee update started");
			eDao.empAssignmentUpdate(uDao.getInterfaceDate("empAssignmentUpdate"));
			uDao.updateInterfaceDate("empAssignmentUpdate");
			logger.info("In empAssignmentUpdate :: Employee udate completed");
		} catch (Exception e) {
			logger.error("In empAssignmentUpdate:::exception");
			logger.log(Level.FATAL, e.getMessage(), e);

			e.printStackTrace();
		}
	}

	public void createTaleoLocation() {
		try {

			logger.info("Schedule createTaleoLocation*******************" + new Date());
			logger.info("In createTaleoLocation :: Employee update started");
			eDao.createLocation(uDao.getInterfaceDate("createTaleoLocation"));
			uDao.updateInterfaceDate("createTaleoLocation");
			logger.info("In createTaleoLocation :: Taleo Location Created");
		} catch (Exception e) {
			logger.error("In createTaleoLocation:::exception");
			logger.log(Level.FATAL, e.getMessage(), e);

			e.printStackTrace();
		}

	}

	public void newhireUpdate() {
		try {
			logger.info("In updateNewhire :: New Hire Update started");
			eDao.newhireUpdate(uDao.getInterfaceDate("newhireUpdate"));
			uDao.updateInterfaceDate("newhireUpdate");
			logger.info("In updateNewhire :: New Hire Update completed");
			// update entry in our table
			// uDao.createPerson(hcmTaleoEmployees);
		} catch (Exception e) {
			logger.error("In updateNewhire:::exception");
			logger.log(Level.FATAL, e.getMessage(), e);

			e.printStackTrace();
		}
	}

}