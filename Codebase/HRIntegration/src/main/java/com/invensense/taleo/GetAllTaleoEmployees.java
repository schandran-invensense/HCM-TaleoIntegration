package com.invensense.taleo;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Level;
import org.json.JSONArray;
import org.json.JSONObject;

//import com.invensense.connector.TaleoConnector;

public class GetAllTaleoEmployees {
	//Delimiter used in CSV file
			private static final String COMMA_DELIMITER = ",";
			private static final String NEW_LINE_SEPARATOR = "\n";
			private static final String fileName = System.getProperty("user.home")+"/Employee.csv";
			
			
	//CSV file header
			private static final String FILE_HEADER = "id,firstName,lastName";			    
	
	public static String callGetMethod(String input, String urlIn) throws Exception {
		
		URL url = new URL(urlIn);
		System.out.println("URL : " + urlIn);
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
		System.out.println("Output from Server in Get method.... \n");
		if (br != null) {
			json = br.readLine();
		}
		System.out.println("Response from Get" + json);

		String response = json;

		httpURLConnection.disconnect();
		return response;
	}

	public static void writeCsvFile(String empListJson)
	{
		
		    
		List<String> empIdList = new ArrayList<>();
		FileWriter fileWriter = null;
		
		JSONObject obj;
		try {

			obj = new JSONObject(empListJson);

			final JSONObject response = obj.getJSONObject("response");
			//final JSONObject pagination=response.getJSONObject("pagination");
			final JSONArray searchResults = response.getJSONArray("searchResults");

			System.out.println("In Main:: searchResults length :" + searchResults.length());
			if (searchResults.length() != 0) {
				fileWriter = new FileWriter(fileName);
				// Write the CSV file header
				fileWriter.append(FILE_HEADER.toString());
				// Add a new line separator after the header
				fileWriter.append(NEW_LINE_SEPARATOR);
				
				for (int j = 0; j < searchResults.length(); j++) {
					JSONObject employee;
					employee = searchResults.getJSONObject(j).getJSONObject("employee");
					System.out.println("Employee returned::" + employee.getInt("employeeId"));
					
					try {
						
						System.out.println("Employee2222 returned::" + employee.getInt("employeeId"));
						fileWriter.append(String.valueOf(employee.getInt("employeeId")));
						fileWriter.append(COMMA_DELIMITER);
						fileWriter.append(String.valueOf(employee.getString("firstName")));
						fileWriter.append(COMMA_DELIMITER);
						fileWriter.append(String.valueOf(employee.getString("lastName")));
						fileWriter.append(NEW_LINE_SEPARATOR);

					} catch (Exception e) {

						System.out.println("Error in CsvFileWriter !!!");

						e.printStackTrace();

					} 

					//empIdList.add(Integer.toString(employee.getInt("employeeId")));
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occurred in createEmployee ::" + e.getMessage());
		//	logger.log(Level.FATAL, e.getMessage(), e);

			System.out.println("Exception occurred while reading Search results");
			e.printStackTrace();
		}
		finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e)
			{
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}

	}
	public static void main(String args[])
	{
		String urlIn = "https://chp.tbe.taleo.net/chp04/ats/api/v1/object/employee/search";

		//String json = "{\"candidate\":		{	\"city\": \"Kyiv\",	\"country\": \"UA\",\"resumeText\": \"TBE Rest API Test\",\"email\": \"oskrypka@invalidemail.com\",\"firstName\": \"Oleg1\",	\"lastName\": \"Skrypka\",\"status\": \"2\"	}	}";
		String json = "webapi23717641390780625675";
		//TaleoConnector taleoConnector = new TaleoConnector();
		try {
			String empListJson=GetAllTaleoEmployees.callGetMethod(json, urlIn);
			System.out.println("File name is "+fileName);
			GetAllTaleoEmployees.writeCsvFile(empListJson);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
