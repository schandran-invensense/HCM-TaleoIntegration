package com.invensense.dao;

import java.util.List;

import com.invensense.model.hcmtaleo.Employee;
import com.invensense.model.hcmtaleo.HCMMap;
import com.invensense.model.hcmtaleo.HCMTaleoEmployee;

public interface UtilitiesDao {

	public String getInterfaceDate(String interfaceId) throws Exception;
	public String getPersonIdSequence() throws Exception;
	public String updateInterfaceDate(String interfaceId) throws Exception;
	public Employee getPerson(String personId,String personNumber) throws Exception;
	public HCMMap getHCMId(String srcId) throws Exception;
	public String createPerson(List<HCMTaleoEmployee> hcmTaleoEmployees) throws Exception;
	public String updateNewHirePerson(String hcmPersonNum,String hcmPersonId) throws Exception;
	public Employee checkExistingEmployee(String workEmail) throws Exception;
}
