package com.invensense.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.invensense.dao.EmployeeOperationsDao;
import com.invensense.dao.UtilitiesDao;

//@Api(name = "RestController", description = "HR Integration rest controller")

@org.springframework.web.bind.annotation.RestController
public class RestController {
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	@Qualifier("employeeOperationsDao")
	private EmployeeOperationsDao eDao;
	@Autowired
	@Qualifier("utilitiesDao")
	private UtilitiesDao uDao;

	@RequestMapping(value = "/empUpdate", method = { RequestMethod.GET })
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody String empUpdate(@RequestBody String empUpdateIn) throws Exception {

		logger.info("In empUpdate1 :: Employee update started");
		String response = null;
		//logger.info("Gettingupdated date from table in empUpdate :" + uDao.getInterfaceDate("empUpdate"));

		response = eDao.employeeUpdate(uDao.getInterfaceDate("empUpdate"));

		logger.info("After employeeUpdate ");
		uDao.updateInterfaceDate("empUpdate");
		logger.info("In empUpdate :: Employee update completed");
		return response;
	}

	@RequestMapping(value = "/empTerminate", method = { RequestMethod.GET })
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody String empTerminate(@RequestBody String employeeTerminateIn) throws Exception {

		logger.info("In empTerminate :: Employee termination started");
		String response = null;
		// response = eDao.employeeTerminate(employeeTerminateIn);
		logger.info("Gettingupdated date from table in empTerminate :" + uDao.getInterfaceDate("empTerminate"));
		response = eDao.employeeTerminate(uDao.getInterfaceDate("empTerminate"));
		// update table to update the interface table
		uDao.updateInterfaceDate("empTerminate");
		logger.info("In empTerminate :: Employee termination completed");
		return response;
	}

	/*@RequestMapping(value = "/createEmployee", method = { RequestMethod.GET })
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody String createEmployee(@RequestBody String createEmployeeIn) throws Exception {

		logger.info("In createEmployee :: Employee creation started");
		String response = null;
		// EmployeeUpdateImpl employeeUpdateImpl = new EmployeeUpdateImpl();
		// response = eDao.createEmployee(createEmployeeIn);
		logger.info("Gettingupdated date from table in createEmployee :" + uDao.getInterfaceDate("createEmployee"));
		List<HCMTaleoEmployee> hcmTaleoEmployees= eDao.createEmployee(uDao.getInterfaceDate("createEmployee"));
		// update table to update the interface table
		uDao.updateInterfaceDate("createEmployee");
		logger.info("In createEmployee :: Employee creation completed");

		return response;
	}
*/
	@RequestMapping(value = "/empAssignmentUpdate", method = { RequestMethod.GET })
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody String empAssignmentUpdate(@RequestBody String createEmployeeIn) throws Exception {

		logger.info("In empAssignmentUpdate :: Employee update started");
		String response = null;
		// EmployeeUpdateImpl employeeUpdateImpl = new EmployeeUpdateImpl();
		// response = eDao.empAssignmentUpdate(createEmployeeIn);
		logger.info("Gettingupdated date from table in empAssignmentUpdate :"
				+ uDao.getInterfaceDate("empAssignmentUpdate"));
		response = eDao.empAssignmentUpdate(uDao.getInterfaceDate("empAssignmentUpdate"));
		// update table to update the interface table
		uDao.updateInterfaceDate("empAssignmentUpdate");
		logger.info("In empAssignmentUpdate :: Employee udate completed");

		return response;
	}

	/*
	 * public void run() { System.out.println(
	 * "In run method******************************"); try { // RestController
	 * restC= new RestController(); this.empUpdate(""); } catch (Exception e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } }
	 */
}
