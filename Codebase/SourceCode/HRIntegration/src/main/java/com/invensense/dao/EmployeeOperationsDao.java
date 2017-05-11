package com.invensense.dao;

import java.util.List;

import com.invensense.model.hcmtaleo.HCMTaleoEmployee;

public interface EmployeeOperationsDao {
	public String employeeUpdate(String employeeUpdateIn) throws Exception;
	public String employeeTerminate(String employeeTerminateIn) throws Exception;
	
	public List<HCMTaleoEmployee> createEmployee(String createEmployeeIn) throws Exception;
	public String empAssignmentUpdate(String empAssignmentUpdateIn) throws Exception;
	public String createLocation(String createLocationIn) throws Exception;
	public String newhireUpdate(String newhireUpdateIn) throws Exception;
	
}
