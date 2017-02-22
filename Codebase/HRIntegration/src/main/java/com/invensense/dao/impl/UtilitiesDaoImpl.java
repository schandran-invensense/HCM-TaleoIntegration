package com.invensense.dao.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.invensense.dao.UtilitiesDao;
import com.invensense.model.hcmtaleo.Employee;
import com.invensense.model.hcmtaleo.HCMMap;
import com.invensense.model.hcmtaleo.HCMTaleoEmployee;

@Repository("utilitiesDao")
public class UtilitiesDaoImpl implements UtilitiesDao {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private DataSource dataSource;
	// private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}
	
	
	public String getPersonIdSequence() throws Exception {
		  logger.debug("In getPersonIdSequence ");
		  String sql = "SELECT XXINV_INTEGRATION_PERSONNOSEQ.nextval FROM dual";
		  String personIdSeq="";
		  List<String> res = this.jdbcTemplate.queryForList(sql,String.class);
		  
		   if (res.size() == 0) {
		          return null;
		      }
		   logger.debug("Creating person number");
		   personIdSeq=res.get(0);
		    logger.debug("Creating person number:: "+personIdSeq);
		 
		  return personIdSeq;
		 }

	public Employee getPerson(String personId, String personNumber) throws Exception {
		logger.debug("In getPerson for "+personId+" "+personNumber);
		String sql = "select * from XXINV_INTEGRATION_PERSON where person_id=?";

		Employee emp = new Employee();
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(sql, personId);
		if (rows != null && rows.size() > 0) {
			logger.debug("Inside getPerson :" + rows.size());
			Map<String, Object> item = rows.get(0);
			try {
				emp.setPersonNumber((String) item.get("PERSON_NUMBER"));
				logger.debug("Person number is :" + (String) item.get("PERSON_NUMBER"));
				emp.setTBEempID((String) item.get("TALEO_EMP_ID"));
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			sql = "select * from XXINV_INTEGRATION_PERSON where person_number=?";
			rows = this.jdbcTemplate.queryForList(sql, personNumber);
			if (rows != null && rows.size() > 0) {
				logger.debug("Inside getPerson :" + rows.size());
				Map<String, Object> item = rows.get(0);
				try {
					// emp.setPersonNumber((String) item.get("PERSON_NUMBER"));
					logger.debug("Employee id is :" + (String) item.get("TALEO_EMP_ID"));
					emp.setTBEempID((String) item.get("TALEO_EMP_ID"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return emp;
	}

	public HCMMap getHCMId(String srcId) throws Exception {
		logger.debug("In getHCMId "+srcId);
		String sql = "select * from XXINV_INTEGRATION_HCM_MAP where hcmkey=?";
		HCMMap hcmMap = new HCMMap();
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(sql, srcId);
		if (rows != null && rows.size() > 0) {
			logger.debug("Inside getPerson :" + rows.size());
			Map<String, Object> item = rows.get(0);
			try {
				hcmMap.setHcmGuid((String) item.get("HCMGUID"));
				hcmMap.setDescription((String) item.get("DESCRIPTION"));
				hcmMap.setSrcData((String) item.get("SRC_DATA"));
				hcmMap.setHcmKey(srcId);

				logger.debug("GUID is :" + (String) item.get("HCMGUID"));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return hcmMap;
	}

	public String getInterfaceDate(String interfaceId) throws Exception {
		logger.debug("In getupdateDate "+interfaceId);
		String sql = "select * from xxinv_integration_interface where interface_id=?";
		String result = "";
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(sql, interfaceId);
		if (rows != null && rows.size() > 0) {
			logger.debug("Inside Date not Null row size :" + rows.size());
			Map<String, Object> item = rows.get(0);
			try {
				result = (String) item.get("UPDATE_DATE");
				logger.debug("Date from getInterfaceDate is :" + result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			logger.debug("Inside Date Null :");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			result = dateFormat.format(cal.getTime());
	
		}
		return result;
	}

	public String updateNewHirePerson(String hcmPersonNum, String hcmPersonId) throws Exception {
		logger.debug("In updateNewHirePerson with :" + hcmPersonNum);
		String result = "";
		int no = 0;
		String sql = "update XXINV_INTEGRATION_PERSON set person_id=? where person_number=?";
		no = this.jdbcTemplate.update(sql, hcmPersonId, hcmPersonNum);
		logger.debug("No of records in the result::" + no);
		result = Integer.toString(no);
		return result;
	}

	public String updateInterfaceDate(String interfaceId) throws Exception {
		logger.debug("In updateInterfaceDate with :" + interfaceId);
		String result = "";
		int no = 0;
		String sql = "update xxinv_integration_interface set UPDATE_DATE=? where interface_id=?";

		if (interfaceId.equalsIgnoreCase("createEmployee")) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
			simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
			Calendar cal = Calendar.getInstance();
			String dateTime = simpleDateFormat.format(cal.getTime());
			System.out.println("Final date:::" + dateTime.replace("Z", "PST"));
			String queryTime = dateTime.replace("Z", "PST");

			logger.debug("Update date for createemployee :: " + queryTime);
			no = this.jdbcTemplate.update(sql, queryTime, interfaceId);
			logger.debug("No of records in the result::" + no);
			if (no == 0)

			{
				sql = "insert into xxinv_integration_interface values(?,?)";

				try {
					int resp = jdbcTemplate.update(sql, interfaceId, queryTime);
					logger.debug("No of records in the result::" + resp);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		} else {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
			String date = dateFormat.format(new Date());
			logger.debug("Date in updateInterfaceDate is " + date);
			no = this.jdbcTemplate.update(sql, date, interfaceId);
			logger.debug("No of records in the result::" + no);
			if (no == 0)

			{
				sql = "insert into xxinv_integration_interface values(?,?)";

				try {
					int resp = jdbcTemplate.update(sql, interfaceId, date);
					logger.debug("No of records in the result::" + resp);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		return result;
	}

	public String createPerson(List<HCMTaleoEmployee> hcmTaleoEmployees) throws Exception {
		logger.debug("In createPerson to update " + hcmTaleoEmployees.size() + " number of employees");
		String selectSql = "select * from XXINV_INTEGRATION_PERSON where person_id=?";
		String insertSql = "insert into XXINV_INTEGRATION_PERSON values(?,?,?,?)";
		for (int i = 0; i < hcmTaleoEmployees.size(); i++) {

			List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(selectSql,
					hcmTaleoEmployees.get(i).getHcmPersonId());
			if (rows != null && rows.size() > 0) {
				logger.debug("Inside getPerson person record already available");
				// update person number

			} else {
				// check if the taleo record is present
				jdbcTemplate.update(insertSql, hcmTaleoEmployees.get(i).getHcmPersonId(),
						hcmTaleoEmployees.get(i).getHcmPersonNumber(), hcmTaleoEmployees.get(i).getHcmPersonName(),
						hcmTaleoEmployees.get(i).getEmployeeId());

			}

		}
		return null;
	}

}
