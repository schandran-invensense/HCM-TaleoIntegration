package com.invensense.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
//import org.codehaus.jackson.map.DeserializationConfig;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.invensense.model.hcm.hcmlocation.HCMLocations;
import com.invensense.model.hcmtaleo.HCMTaleoEmployee;
import com.invensense.model.hcmtaleo.HCMTaleoLocations;
import com.invensense.model.taleo.Employee;
import com.invensense.model.taleo.Response;
import com.invensense.model.taleo.TaleoEmployee;
import com.invensense.model.taleo.department.Department;
import com.invensense.model.taleo.department.TaleoDepartment;
import com.invensense.model.taleolocations.Location;
import com.invensense.model.taleolocations.TaleoLocations;
//import com.invensense.model.taleolocations.Response;
import com.invensense.utils.TaleoConstants;

public class TaleoConnector {

	private Logger logger = Logger.getLogger(this.getClass());

	public String employeeUpdate(List<HCMTaleoEmployee> hcmTaleoEmployeeList) throws Exception {
		String auth = "";
		String urlStr = "";
		try {
			logger.info("In empUpdate ::Getting Taleo URL and auth token");
			urlStr = getTaleoAPIDetails();

			auth = authoriseTaleo(urlStr);

			for (int i = 0; i < hcmTaleoEmployeeList.size(); i++) {
				String employeeId = hcmTaleoEmployeeList.get(i).getEmployeeId();
				logger.debug("In empUpdate :: employee id :" + employeeId);
				if ((employeeId != null) && (employeeId != "")) {
					callPutMethod(auth, urlStr + "/object/employee/" + employeeId, hcmTaleoEmployeeList.get(i));
					logger.debug("In empUpdate :: Update done for Employee :::" + employeeId);
				}
			}
		} catch (Exception e) {
			logger.debug("Exception occurred in employeeUpdate ::" + e.getMessage());
			logger.log(Level.FATAL, e.getMessage(), e);

			e.printStackTrace();
		} finally {
			callLogoutService(auth, urlStr);
		}
		return "Success";
	}

	public String employeeTerminate(List<HCMTaleoEmployee> hcmTaleoEmployeeList) throws Exception {
		String auth = "";
		String urlStr = "";
		try {
			urlStr = getTaleoAPIDetails();
			logger.debug("In employeeTerminate:: authorise Taleo");
			auth = authoriseTaleo(urlStr);

			for (int i = 0; i < hcmTaleoEmployeeList.size(); i++) {
				logger.debug("In employeeTerminate:: Taleo GET API call************************************");

				String employeeId = hcmTaleoEmployeeList.get(i).getEmployeeId();
				logger.debug("In employeeterminate :: Employee id : " + employeeId);
				if ((employeeId != null) && (employeeId != "")) {
					callPutMethod(auth, urlStr + "/object/employee/" + employeeId, hcmTaleoEmployeeList.get(i));
					logger.debug("Update done for Employee :::" + employeeId);
				}
			}
		} catch (Exception e) {
			logger.debug("Exception occurred in employeeTerminate ::" + e.getMessage());
			logger.log(Level.FATAL, e.getMessage(), e);

			e.printStackTrace();
		} finally {
			callLogoutService(auth, urlStr);
		}

		return "Success";
	}

	public List<HCMTaleoEmployee> getCreateEmployee(String createEmployeeIn) throws Exception {
		String auth = "";
		String urlStr = "";
		List<HCMTaleoEmployee> hcmTaleoEmployees = new ArrayList<>();
		try {
			urlStr = getTaleoAPIDetails();
			logger.debug("In employee Create:: authorise Taleo : " + createEmployeeIn);
			auth = authoriseTaleo(urlStr);

			/*
			 * SimpleDateFormat dateFormat = new
			 * SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
			 * dateFormat.setTimeZone(TimeZone.getTimeZone("PST")); Calendar cal
			 * = Calendar.getInstance(); cal.add(Calendar.DATE, -5);
			 * 
			 * //:2016-12-10T03:48PST String dateTime =
			 * dateFormat.format(cal.getTime()); logger.debug("Final date:::" +
			 * dateTime.replace("Z", "PST")); String queryTime =
			 * dateTime.replace("Z", "PST");
			 * createEmployeeIn=queryTime;//"2016-12-20T13:49PST";
			 * 
			 *
			 */ 
		// createEmployeeIn="2017-01-17T09:00PST";
			 logger.debug("Time to query : " + createEmployeeIn);
			String urlCreateEmp = urlStr
					+ "object/employee/search?fields=status|firstName|employeeId&creationDate_from=" + createEmployeeIn;
			String empListJson = callGetMethod(auth, urlCreateEmp);
			List<String> empIdList = new ArrayList<>();

			JSONObject obj;
			try {

				obj = new JSONObject(empListJson);

				final JSONObject response = obj.getJSONObject("response");
				final JSONArray searchResults = response.getJSONArray("searchResults");

				logger.debug("In createEmployee:: searchResults length :" + searchResults.length());
				if (searchResults.length() != 0) {
					for (int j = 0; j < searchResults.length(); j++) {
						JSONObject employee;
						employee = searchResults.getJSONObject(j).getJSONObject("employee");
						logger.debug("Employee returned::" + employee.getInt("employeeId"));

						empIdList.add(Integer.toString(employee.getInt("employeeId")));
					}
				}
			} catch (Exception e) {
				logger.debug("Exception occurred in createEmployee ::" + e.getMessage());
				logger.log(Level.FATAL, e.getMessage(), e);

				System.out.println("Exception occurred while reading Search results");
				e.printStackTrace();
			}

			if ((empIdList != null) && (empIdList.size() != 0)) {

				hcmTaleoEmployees = new ArrayList<HCMTaleoEmployee>();

				for (int i = 0; i < empIdList.size(); i++) {
					String urlGetEmp = urlStr + "/object/employee/" + empIdList.get(i);
					// Populate HCMTaleoEmployeeList to create CSV file
					HCMTaleoEmployee hcmTalEmp = getEmployeeDetails(auth, urlGetEmp);
					hcmTaleoEmployees.add(hcmTalEmp);
				}
			}
			// callLogoutService(auth, urlStr);
		} catch (Exception e) {
			logger.error("Exception occurred");
			throw new Exception();
		} finally {
			callLogoutService(auth, urlStr);
		}
		return hcmTaleoEmployees;
	}

	public String empAssignmentUpdate(List<HCMTaleoEmployee> hcmTaleoEmployeeList) throws Exception {
		String auth = "";
		String urlStr = "";
		try {
			urlStr = getTaleoAPIDetails();
			logger.debug("In empAssignmentUpdate:: authorise Taleo");
			auth = authoriseTaleo(urlStr);

			for (int i = 0; i < hcmTaleoEmployeeList.size(); i++) {
				logger.debug("In empAssignmentUpdate:: Taleo GET API call************************************");

				String employeeId = hcmTaleoEmployeeList.get(i).getEmployeeId();
				logger.debug("In empAssignmentUpdate :: Employee id : " + employeeId);

				if ((employeeId != null) && (employeeId != "")) {
					callPutMethod(auth, urlStr + "/object/employee/" + employeeId, hcmTaleoEmployeeList.get(i));
					logger.debug("In empUpdate :: Update done for Employee :::" + employeeId);
				}
			}
		} catch (Exception e) {
			logger.error("Exception occurred");
			throw new Exception();
		} finally {
			callLogoutService(auth, urlStr);
		}
		// callLogoutService(auth, urlStr);
		return "Success";
	}

	public String createTaleoLocation(List<HCMTaleoLocations> hcmTaleoLocationList) throws Exception {

		String urlStr = getTaleoAPIDetails();
		logger.debug("In createTaleoLocation:: authorise Taleo");
		String auth = authoriseTaleo(urlStr);

		for (int i = 0; i < hcmTaleoLocationList.size(); i++) {
			logger.debug("In createTaleoLocation:: Taleo GET API call************************************");
			// Check location exist method call
			HCMTaleoLocations hcmTaleoLocation = hcmTaleoLocationList.get(i);
			String locID = checkLocationTaleo(hcmTaleoLocation);
			if (locID != null) {
				callLocationUpsertMethod(auth, urlStr + "/object/location?upsert=true", hcmTaleoLocation, locID);
			} else {
				callLocationPostMethod(auth, urlStr + "/object/location", hcmTaleoLocation);
			}
			logger.debug("In createTaleoLocation after callPOST Method ::");

		}
		callLogoutService(auth, urlStr);
		return "Success";
	}

	public String checkLocationTaleo(HCMTaleoLocations hcmTaleoLocation) throws Exception {
		String urlStr = getTaleoAPIDetails();
		String auth = authoriseTaleo(urlStr);
		String locID = null;
		logger.debug("In checkLocationTaleo:: authorise Taleo");
		try {

			String urlGetEmp = urlStr + "/object/location?code=" + hcmTaleoLocation.getLocationCode();
			URL url = new URL(urlGetEmp);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("Content-Type", "application/json");
			httpURLConnection.setRequestProperty("Cookie", "authToken=" + auth);
			if (httpURLConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + httpURLConnection.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((httpURLConnection.getInputStream())));

			String json = "";
			logger.debug("In checkLocationTaleo");

			if (br != null) {
				json = br.readLine();
			}
			logger.debug("Creating java class" + json);

			try {
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
				TaleoLocations tbeLocations = objectMapper.readValue(json, TaleoLocations.class);
				Location loc = tbeLocations.getResponse().getLocation();
				if (loc != null && loc.getId() != null) {
					locID = loc.getId().toString();
					logger.debug("Taleo Location ID is :" + locID);
				}

			} catch (Exception e) {
				logger.debug("Exception occurred in checkLocationTaleo ::" + e.getMessage());
				logger.log(Level.FATAL, e.getMessage(), e);

				e.printStackTrace();
			}

			logger.debug("In checkLocationTaleo after call GET Method ::");
		} catch (Exception ex) {

			logger.debug("Exception occurred  in checkLocationTaleo ::" + ex.getMessage());
			logger.log(Level.FATAL, ex.getMessage(), ex);

		} finally {
			callLogoutService(auth, urlStr);
		}
		return locID;
	}

	// @SuppressWarnings("deprecation")
	public void callPutMethod(String auth, String urlIn, HCMTaleoEmployee hcmTaleoEmployee) throws Exception {

		logger.info("Update in Taleo for employee id :" + hcmTaleoEmployee.getEmployeeId());
		URL url = new URL(urlIn);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("Cookie", "authToken=" + auth);
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);
		connection.addRequestProperty("Accept", "application/json");
		ObjectMapper mapper = new ObjectMapper();
		Employee emp = new Employee();
		Response response = new Response();
		boolean updateAvlbl = false;
		if (hcmTaleoEmployee.getStartDate() != null) {
			emp.setStartDate(hcmTaleoEmployee.getStartDate());
			logger.debug("hcmTaleoEmployee Start date :" + emp.getStartDate());
			updateAvlbl = true;
		}
		/*
		 * if (hcmTaleoEmployee.getAddressLine1() != null) {
		 * emp.setAddress(hcmTaleoEmployee.getAddressLine1()); updateAvlbl=true;
		 * } if (hcmTaleoEmployee.getAddressLine2() != null) {
		 * emp.setAddress2(hcmTaleoEmployee.getAddressLine2());
		 * updateAvlbl=true; }
		 */
		if (hcmTaleoEmployee.getFirstName() != null) {
			emp.setFirstName(hcmTaleoEmployee.getFirstName());
		}
		if (hcmTaleoEmployee.getLastName() != null) {
			emp.setLastName(hcmTaleoEmployee.getLastName());
			updateAvlbl = true;
		}
		if (hcmTaleoEmployee.getMiddleName() != null) {
			emp.setMiddleInitial(hcmTaleoEmployee.getMiddleName());
			updateAvlbl = true;
		}

		if (hcmTaleoEmployee.getActualTerminationDate() != null) {
			emp.setStatus(3);
			updateAvlbl = true;
		}

		if (updateAvlbl) {
			emp.setFusionPersonID(hcmTaleoEmployee.getHcmPersonNumber());
			emp.setFusionEmployeeNumber(hcmTaleoEmployee.getHcmPersonNumber());
			response.setEmployee(emp);
			logger.debug("Update employee : employee data set");
			// mapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
			logger.debug("Employee update json::" + json);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(json);
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";

			logger.debug("Employee update PUT Method Invoked Successfully..");

			if (in != null) {
				line = in.readLine();
			}
			System.out.println(line);
		}

	}

	public void callLocationPostMethod(String auth, String urlIn, HCMTaleoLocations hcmTaleoLocations)
			throws Exception {

		logger.info("Begin callPostMethod ::");
		URL url = new URL(urlIn);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("Cookie", "authToken=" + auth);
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);
		connection.addRequestProperty("Accept", "application/json");
		ObjectMapper mapper = new ObjectMapper();
		Location loc = new Location();
		com.invensense.model.taleolocations.Response response = new com.invensense.model.taleolocations.Response();

		if (hcmTaleoLocations.getLocationCode() != null) {
			loc.setLocationCode(hcmTaleoLocations.getLocationCode());
			logger.debug("hcmTaleoLocations Location Code :" + loc.getLocationCode());
			// updateAvlbl=true;
		}
		if (hcmTaleoLocations.getLocationName() != null) {
			loc.setLocationName(hcmTaleoLocations.getLocationName());
			// updateAvlbl=true;
		}

		response.setLocation(loc);
		logger.debug("Create Locations : ");
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
		logger.debug("Location Create json::" + json);
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		out.write(json);
		out.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = "";

		logger.debug("Location create POST Method Invoked Successfully..");

		if (in != null) {
			line = in.readLine();
		}
		System.out.println(line);

	}

	public void callLocationUpsertMethod(String auth, String urlIn, HCMTaleoLocations hcmTaleoLocations,
			String locationId) throws Exception {

		logger.info("Begin callPostMethod ::");
		URL url = new URL(urlIn);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("Cookie", "authToken=" + auth);
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);
		connection.addRequestProperty("Accept", "application/json");
		ObjectMapper mapper = new ObjectMapper();
		Location loc = new Location();
		com.invensense.model.taleolocations.Response response = new com.invensense.model.taleolocations.Response();
		loc.setId(Integer.parseInt(locationId));
		if (hcmTaleoLocations.getLocationCode() != null) {
			loc.setLocationCode(hcmTaleoLocations.getLocationCode());
			logger.debug("hcmTaleoLocations Location Code :" + loc.getLocationCode());

		}
		if (hcmTaleoLocations.getLocationName() != null) {
			loc.setLocationName(hcmTaleoLocations.getLocationName());

		}
		response.setLocation(loc);
		logger.debug("Create Locations : ");
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
		logger.debug("Location update json::" + json);
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		out.write(json);
		out.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = "";

		logger.debug("Location create POST Method Invoked Successfully..");

		if (in != null) {
			line = in.readLine();
		}
		System.out.println(line);

	}

	public String searchEmployeeDetails(String input, String urlIn) throws Exception {
		URL url = new URL(urlIn);

		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");

		httpURLConnection.setRequestProperty("Content-Type", "application/json");
		httpURLConnection.setRequestProperty("Cookie", "authToken=" + input);
		if (httpURLConnection.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + httpURLConnection.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((httpURLConnection.getInputStream())));

		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		logger.debug("Search employee details:::" + json);

		JSONObject obj;
		String empId = "";
		try {
			obj = new JSONObject(json);

			final JSONObject response = obj.getJSONObject("response");
			final JSONArray searchResults = response.getJSONArray("searchResults");

			logger.debug("searchResults length :" + searchResults.length());
			if (searchResults.length() != 0) {
				JSONObject employee;
				employee = searchResults.getJSONObject(0).getJSONObject("employee");
				logger.debug("Employee Id :" + employee.getInt("employeeId"));

				empId = Integer.toString(employee.getInt("employeeId"));
			}
		} catch (Exception e) {
			logger.debug("Exception occurred while reading Search results");
			e.printStackTrace();
		}

		httpURLConnection.disconnect();
		return empId;
	}

	public HCMTaleoEmployee getEmployeeDetails(String input, String urlIn) throws Exception {
		URL url = new URL(urlIn);

		String empId = "";
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");

		httpURLConnection.setRequestProperty("Content-Type", "application/json");
		httpURLConnection.setRequestProperty("Cookie", "authToken=" + input);
		if (httpURLConnection.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + httpURLConnection.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((httpURLConnection.getInputStream())));

		String json = "";
		logger.debug("In getEmployeeDetails");
		HCMTaleoEmployee hcmTaleoEmployee = new HCMTaleoEmployee();
		if (br != null) {
			json = br.readLine();
		}
		System.out.println("Creating java class" + json);

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			TaleoEmployee response1 = objectMapper.readValue(json, TaleoEmployee.class);

			Employee emp = response1.getResponse().getEmployee();
			empId = Integer.toString(response1.getResponse().getEmployee().getEmployeeId());// Integer.toString(employee.getInt("employeeId"));
			hcmTaleoEmployee.setEmployeeId(Integer.toString(emp.getEmployeeId()));
			hcmTaleoEmployee.setFirstName(emp.getFirstName());
			hcmTaleoEmployee.setLastName(emp.getLastName());
			hcmTaleoEmployee.setMiddleName(emp.getMiddleInitial());
			if ((emp.getEmail() != null) && (!emp.getEmail().equalsIgnoreCase(""))) {
				logger.debug("Setting email :"+emp.getEmail());
				hcmTaleoEmployee.setEmailAddress(emp.getEmail());
			} else {
				hcmTaleoEmployee
						.setEmailAddress(hcmTaleoEmployee.getFirstName() + hcmTaleoEmployee.getLastName() + "@hcm.com");
			}

			SimpleDateFormat dateFormat = new
					  SimpleDateFormat("yyyy-MM-dd");
					  dateFormat.setTimeZone(TimeZone.getTimeZone("PST")); 
					  Calendar cal = Calendar.getInstance(); //cal.add(Calendar.DATE, -5);
					String startDate=  dateFormat.format(cal.getTime());
					Date date1 = dateFormat.parse(startDate);
		            Date date2 = dateFormat.parse(emp.getStartDate());
		           if(date2.after(date1))
		           {
		            logger.debug("Use start date");
		          hcmTaleoEmployee.setStartDate(startDate);
		          
		           }

		           else{
		            logger.debug("Use projected date");
		        hcmTaleoEmployee.setStartDate(emp.getStartDate());
		           }
			//hcmTaleoEmployee.setStartDate(startDate);//"2017-01-18");
			hcmTaleoEmployee.setCity(emp.getCity());
			hcmTaleoEmployee.setCounty(emp.getCounty());
			hcmTaleoEmployee.setCountry(emp.getCountry());
			hcmTaleoEmployee.setAddressLine1(emp.getAddress());
			hcmTaleoEmployee.setPostalCode(emp.getZipCode());
			hcmTaleoEmployee.setGender(emp.getGender());
			hcmTaleoEmployee.setState(emp.getState());
			hcmTaleoEmployee.setPhoneNo(emp.getPhone());
			hcmTaleoEmployee.setRoleName(emp.getPosition());
			hcmTaleoEmployee.setLegalEntity(emp.getLegalEntity());
			hcmTaleoEmployee.setLegislationCode(emp.getLegislationCode());
			hcmTaleoEmployee.setBusinessUnit(emp.getBusiness_Unit());
			hcmTaleoEmployee.setJobTitle(emp.getJobTitle());
			hcmTaleoEmployee.setProjStartDate(emp.getStartDate());

			// START_DATE|FIRST_NAME|MIDDLE_INITIAL|LAST_NAME|GENDER|TOWN_OR_CITY|STATE|COUNTRY|POSTAL_CODE|EMAIL_ADDRESS|EMP_ID|PHONE_NUMBER|PERSON_NUMBER|SSN|ADDRESS1|ADDRESS2|ADDRESS3|BIRTH_DATE|ROLE
			// NAME|PERSON_ID|ASSIGNMENT_ID
		} catch (Exception e) {
			logger.debug("Exception occurred while reading Search results");
			e.printStackTrace();
		}

		httpURLConnection.disconnect();
		return hcmTaleoEmployee;
	}

	public String callGetMethod(String input, String urlIn) throws Exception {
		URL url = new URL(urlIn);
		logger.debug("URL : " + urlIn);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setRequestProperty("Content-Type", "application/json");
		if (input != "") {
			httpURLConnection.setRequestProperty("Cookie", "authToken=" + input);
		}
		if (httpURLConnection.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + httpURLConnection.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((httpURLConnection.getInputStream())));

		String json = "";
		logger.debug("Output from Server in Get method.... \n");
		if (br != null) {
			json = br.readLine();
		}
		logger.debug("Response from Get" + json);

		String response = json;

		httpURLConnection.disconnect();
		return response;
	}

	public String callAuthPOSTMethod(String input, String urlIn) throws Exception {
		URL url = new URL(urlIn);
		logger.debug("Url Taleo::" + urlIn);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setRequestProperty("Content-Type", "application/json");
		if (input != "") {
			httpURLConnection.setRequestProperty("Cookie", "authToken=" + input);
		}
		if (httpURLConnection.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + httpURLConnection.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((httpURLConnection.getInputStream())));

		String json = "";
		if (br != null) {
			json = br.readLine();
		}

		String response = json;

		httpURLConnection.disconnect();
		return response;
	}

	public String getTaleoAPIDetails() throws Exception {
		String company = TaleoConstants.getTaleoCompany();
		String taleoUrl = TaleoConstants.getTaleoUrl();
		String urlStr = callDispatcherService(taleoUrl + company);

		return urlStr;
	}

	public String authoriseTaleo(String urlStr) throws Exception {
		String authToken = callLoginService(urlStr);
		logger.debug("Auth ::" + authToken);
		return authToken;
	}

	public String callLogoutService(String auth, String logoutUrl) throws Exception {
		logoutUrl = logoutUrl + "logout";

		logger.debug("Logout url " + logoutUrl);
		String logoutResponse = callAuthPOSTMethod(auth, logoutUrl);

		logger.debug("Response logout" + logoutResponse);
		return logoutResponse;

	}

	public String callDispatcherService(String dispatcherUrl) throws Exception {
		String apiUrlJson = callGetMethod("", dispatcherUrl);

		JSONObject obj;
		String urlStr = "";
		try {
			obj = new JSONObject(apiUrlJson);

			final JSONObject responseRec = obj.getJSONObject("response");
			urlStr = responseRec.optString("URL");
			logger.debug("Taleo URL from dispatcher :" + urlStr);
		} catch (Exception e) {
			System.out.println("Exception occurred while reading URL");
			logger.log(Level.FATAL, e.getMessage(), e);

			e.printStackTrace();
		}

		return urlStr;

	}

	public String callLoginService(String loginUrl) throws Exception {
		loginUrl = loginUrl + "login?orgCode=" + TaleoConstants.getTaleoCompany() + "&userName="
				+ TaleoConstants.getTaleoUser() + "&password=" + TaleoConstants.getTaleoPass();

		String authResponse = callAuthPOSTMethod("", loginUrl);
		logger.debug("loggin in Taleo");
		JSONObject obj;
		String authStr = "";
		try {
			obj = new JSONObject(authResponse);

			final JSONObject responseRec = obj.getJSONObject("response");

			authStr = responseRec.optString("authToken");
		} catch (Exception e) {
			logger.error("Exception occurred while reading authtoken");
			logger.log(Level.FATAL, e.getMessage(), e);

			e.printStackTrace();
		}
		return authStr;

	}

	public String createEmployeeSearchURL(String empName) {
		String url = "";

		int index = empName.lastIndexOf(",");
		String lname = empName.substring(0, index);
		String fname = empName.substring(index + 1, empName.length());
		url = "object/employee/search?firstName=" + fname.trim() + "&lastName=" + lname;

		return url;
	}

	public static void main(String[] args) {
		String urlIn = "https://chp.tbe.taleo.net/chp03/ats/api/v1/object/candidate/28";

		String json = "{\"candidate\":		{	\"city\": \"Kyiv\",	\"country\": \"UA\",\"resumeText\": \"TBE Rest API Test\",\"email\": \"oskrypka@invalidemail.com\",\"firstName\": \"Oleg1\",	\"lastName\": \"Skrypka\",\"status\": \"2\"	}	}";
		json = "webapi2483660174862833286";
		TaleoConnector taleoConnector = new TaleoConnector();
		try {
			taleoConnector.callGetMethod(json, urlIn);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static URLConnection setUsernamePassword(URL url) throws IOException {
		URLConnection urlConnection = url.openConnection();

		/*
		 * String authString = CustomerConstants.getCustomerUser() + ":" +
		 * CustomerConstants.getCustomerPass(); String authStringEnc = new
		 * String(Base64.encodeBase64(authString.getBytes()));
		 * 
		 * urlConnection.setRequestProperty("Authorization", "Basic " +
		 * authStringEnc);
		 */ return urlConnection;
	}

}
