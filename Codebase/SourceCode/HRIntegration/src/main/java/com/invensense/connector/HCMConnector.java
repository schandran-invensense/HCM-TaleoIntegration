package com.invensense.connector;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.xml.sax.InputSource;

import com.invensense.dao.UtilitiesDao;
import com.invensense.model.hcm.hcmlocation.HCMLocations;
import com.invensense.model.hcmtaleo.HCMTaleoEmployee;
import com.invensense.model.hcmtaleo.HCMTaleoLocations;
import com.invensense.utils.HCMConstants;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;


public class HCMConnector {

	@Autowired
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	@Qualifier("utilitiesDao")
	private UtilitiesDao uDao;


	public List<HCMTaleoEmployee> employeeUpdate(String employeeUpdateIn) throws Exception {

		String employeeUpdateUrl = HCMConstants.getHcmUrl() + "hcmCoreApi/atomservlet/employee/empupdate?updated-min="
				+ employeeUpdateIn;

		List<HCMTaleoEmployee> hcmTaleoEmployees = callGetMethod(employeeUpdateIn, employeeUpdateUrl);
		logger.info("In empUpdate :: HCM Result size ::" + hcmTaleoEmployees.size());
		return hcmTaleoEmployees;
	}

	public List<HCMTaleoEmployee> employeeTerminate(String employeeTerminateIn) throws Exception {

		logger.debug("Time to pass in URL : " + employeeTerminateIn);

		String employeeTerminateUrl = HCMConstants.getHcmUrl()
				+ "hcmCoreApi/atomservlet/employee/termination?updated-min=" + employeeTerminateIn;
		logger.debug("In empTerminate ::  URL : " + employeeTerminateUrl);
		List<HCMTaleoEmployee> hcmTaleoEmployees = callGetMethod(employeeTerminateIn, employeeTerminateUrl);
		logger.debug("In empTerminate no of employees:: " + hcmTaleoEmployees.size());
		return hcmTaleoEmployees;
	}

	public List<HCMTaleoEmployee> empAssignmentUpdate(String empAssignmentUpdateIn) throws Exception {

		logger.debug("Time to pass in URL : " + empAssignmentUpdateIn);

		String empAssignmentUpdateUrl = HCMConstants.getHcmUrl()
				+ "hcmCoreApi/atomservlet/employee/empassignment?updated-min=" + empAssignmentUpdateIn;
		logger.debug("In empAssignmentUpdate URL : " + empAssignmentUpdateUrl);
		List<HCMTaleoEmployee> hcmTaleoEmployees = callGetMethod(empAssignmentUpdateIn, empAssignmentUpdateUrl);
		logger.debug("In empAssignmentUpdate no of employees:: " + hcmTaleoEmployees.size());
		return hcmTaleoEmployees;
	}
	

	public List<HCMTaleoEmployee> newhireUpdate(String newhireUpdateIn) throws Exception {

		logger.debug("Time to pass in URL : " + newhireUpdateIn);

		String newhireUpdateUrl = HCMConstants.getHcmUrl()
				+ "hcmCoreApi/atomservlet/employee/newhire?updated-min=" + newhireUpdateIn;
		logger.debug("In new hire update URL : " + newhireUpdateUrl);
		List<HCMTaleoEmployee> hcmTaleoEmployees = callGetNewHireMethod(newhireUpdateIn, newhireUpdateUrl);
		logger.debug("In  new hire update no of employees:: " + hcmTaleoEmployees.size());
		return hcmTaleoEmployees;
	}
	
	/*public List<HCMTaleoLocations> getLocation(String createLocationIn) throws Exception {

		logger.debug("Time to pass in URL : " + createLocationIn);

		String getLocationUrl = HCMConstants.getHcmUrl()
				+ "/hcmCoreApi/atomservlet/workstructures/locations?updated-min=" + createLocationIn;
		logger.debug("In getLocation URL : " + getLocationUrl);
		List<HCMTaleoLocations> hcmTaleoLocations = callGetLocationMethod(createLocationIn, getLocationUrl);
		logger.debug("In getLocation no of Locations:: " + hcmTaleoLocations.size());
		return hcmTaleoLocations;
	}*/

	public List<HCMTaleoEmployee> callGetMethod(String input, String urlIn) throws Exception {
		URL url = new URL(urlIn);
		logger.debug("urlIn : " + urlIn);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setRequestProperty("Content-Type", "application/atom+xml");
		httpURLConnection = setAuthentication(httpURLConnection);

		if (httpURLConnection.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + httpURLConnection.getResponseCode());
		}

		InputSource source = new InputSource(new InputStreamReader(httpURLConnection.getInputStream()));
		SyndFeedInput input1 = new SyndFeedInput();
		SyndFeed feed = input1.build(source);
		logger.debug("Feed : " + feed.getTitle());
		int cnt = 0;
		List<HCMTaleoEmployee> hcmTaleoEmployeeList = new ArrayList<HCMTaleoEmployee>();
		for (Iterator i = feed.getEntries().iterator(); i.hasNext();) {

			SyndEntry entry = (SyndEntry) i.next();
			logger.debug("Title[" + cnt + "]:" + entry.getTitle());
			logger.debug("******************************************************");

			HCMTaleoEmployee hcmTaleoEmployee = new HCMTaleoEmployee();
			if (entry.getContents() != null) {
				for (Iterator<?> it = entry.getContents().iterator(); it.hasNext();) {
					SyndContent syndContent = (SyndContent) it.next();

					if (syndContent != null) {
						String value = syndContent.getValue();
						logger.debug("Value : " + value);
						JSONObject obj;
						obj = new JSONObject(value);

						final JSONArray resultRec = obj.getJSONArray("Context");
						boolean updateAvlbl = false;
						for (int iL = 0; iL < resultRec.length(); iL++) {

							JSONObject result = (JSONObject) resultRec.get(iL);
							logger.debug("Person number in the input: " + result.get("PersonId"));
							logger.debug("Person number in the input: " + result.get("PersonNumber"));
							hcmTaleoEmployee.setHcmPersonId(result.getString("PersonId"));
							hcmTaleoEmployee.setHcmPersonName(result.getString("PersonName"));
							hcmTaleoEmployee.setHcmPersonNumber(result.getString("PersonNumber"));
							try {
								hcmTaleoEmployee.setStartDate(result.getString("EffectiveStartDate"));
								logger.debug("hcmTaleoEmployee StartDate for : " + hcmTaleoEmployee.getHcmPersonName()
										+ "::" + hcmTaleoEmployee.getStartDate());
							} catch (Exception e) {
								logger.error("In getHCM::Effective start date not found");
							}
							// hcmTaleoEmployee.setWorkEmail(result.getString("WorkEmail"));

						}
						final JSONArray changedAttributes = obj.getJSONArray("Changed Attributes");
						for (int iL = 0; iL < changedAttributes.length(); iL++) {
							JSONObject changedAttributesObj = (JSONObject) changedAttributes.get(iL);

							try {
								if (changedAttributesObj.isNull("UserName")) {

								} else {
									JSONObject userName = changedAttributesObj.getJSONObject("Username");
									logger.debug("New User name :: " + userName.getString("old"));

								}
								if (changedAttributesObj.isNull("FirstName")) {

								} else {
									JSONObject userName = changedAttributesObj.getJSONObject("FirstName");
									logger.debug("New FirstName:: " + userName.getString("new"));
									hcmTaleoEmployee.setFirstName(userName.getString("new"));
									updateAvlbl = true;
								}
								if (changedAttributesObj.isNull("LastName")) {

								} else {
									JSONObject userName = changedAttributesObj.getJSONObject("LastName");
									logger.debug("New LastName:: " + userName.getString("new"));
									hcmTaleoEmployee.setLastName(userName.getString("new"));
									updateAvlbl = true;
								}
								if (changedAttributesObj.isNull("MiddleNames")) {

								} else {
									JSONObject MiddleName = changedAttributesObj.getJSONObject("MiddleNames");
									logger.debug("New MiddleNames:: " + MiddleName.getString("new"));
									hcmTaleoEmployee.setMiddleName(MiddleName.getString("new"));
									updateAvlbl = true;
								}
							
								if (changedAttributesObj.isNull("ActualTerminationDate")) {

								} else {
									JSONObject actualTerminationDate = changedAttributesObj
											.getJSONObject("ActualTerminationDate");
									logger.debug(
											"New ActualTerminationDate:: " + actualTerminationDate.getString("new"));
									hcmTaleoEmployee.setActualTerminationDate(actualTerminationDate.getString("new"));
									updateAvlbl = true;
								}
								
							} catch (Exception e) {
								logger.error("Parse errored for employee : " + hcmTaleoEmployee.getHcmPersonNumber()
										+ "::" + hcmTaleoEmployee.getHcmPersonName());
								logger.log(Level.ERROR, e.getMessage(), e);
								e.printStackTrace();
							}

						}
						if (updateAvlbl) {
							logger.debug("Mapping hcmTaleoEmployee");
							hcmTaleoEmployeeList.add(hcmTaleoEmployee);
						}
					}
				}
			}
			logger.debug("******************************************************");

			cnt++;
		}

		httpURLConnection.disconnect();
		return hcmTaleoEmployeeList;
	}
	
	public List<HCMTaleoEmployee> callGetNewHireMethod(String input, String urlIn) throws Exception {
		URL url = new URL(urlIn);
		logger.debug("urlIn : " + urlIn);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setRequestProperty("Content-Type", "application/atom+xml");
		httpURLConnection = setAuthentication(httpURLConnection);

		if (httpURLConnection.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + httpURLConnection.getResponseCode());
		}

		InputSource source = new InputSource(new InputStreamReader(httpURLConnection.getInputStream()));
		SyndFeedInput input1 = new SyndFeedInput();
		SyndFeed feed = input1.build(source);
		logger.debug("Feed : " + feed.getTitle());
		int cnt = 0;
		List<HCMTaleoEmployee> hcmTaleoEmployeeList = new ArrayList<HCMTaleoEmployee>();
		for (Iterator i = feed.getEntries().iterator(); i.hasNext();) {

			SyndEntry entry = (SyndEntry) i.next();
			logger.debug("Title[" + cnt + "]:" + entry.getTitle());
			logger.debug("******************************************************");

			HCMTaleoEmployee hcmTaleoEmployee = new HCMTaleoEmployee();
			if (entry.getContents() != null) {
				for (Iterator<?> it = entry.getContents().iterator(); it.hasNext();) {
					SyndContent syndContent = (SyndContent) it.next();

					if (syndContent != null) {
						String value = syndContent.getValue();
						logger.debug("Value : " + value);
						JSONObject obj;
						obj = new JSONObject(value);

						final JSONArray resultRec = obj.getJSONArray("Context");
						boolean updateAvlbl = false;
						for (int iL = 0; iL < resultRec.length(); iL++) {

							JSONObject result = (JSONObject) resultRec.get(iL);
							logger.debug("Person number in the input: " + result.get("PersonId"));
							logger.debug("Person number in the input: " + result.get("PersonNumber"));
							hcmTaleoEmployee.setHcmPersonId(result.getString("PersonId"));
							hcmTaleoEmployee.setHcmPersonName(result.getString("PersonName"));
							hcmTaleoEmployee.setHcmPersonNumber(result.getString("PersonNumber"));
						

						}
					
					}
				}
			}
			logger.debug("******************************************************");
			hcmTaleoEmployeeList.add(hcmTaleoEmployee);
			cnt++;
		}

		httpURLConnection.disconnect();
		return hcmTaleoEmployeeList;
	}
	
	
	public HttpURLConnection setAuthentication(HttpURLConnection httpURLConnection) {
		String authString = HCMConstants.getHcmUser() + ":" + HCMConstants.getHcmPass();// SI:Mytest4";

		String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
		httpURLConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
		return httpURLConnection;
	}

}
