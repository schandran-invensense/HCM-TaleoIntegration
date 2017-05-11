package com.oracle.xmlns.apps.hcm.common.batchloader.core.loaderintegrationservice;

import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.invensense.utils.HCMConstants;

import weblogic.wsee.jws.jaxws.owsm.SecurityPolicyFeature;

public class LoaderIntegrationServiceSoapHttpPortClient {
	@WebServiceRef
	private static LoaderIntegrationService_Service loaderIntegrationService_Service;
	private  Logger logger = Logger.getLogger(this.getClass());

	public  void loadService(	String fileName,String businessObject)
	{
		loaderIntegrationService_Service = new LoaderIntegrationService_Service();
		SecurityPolicyFeature[] securityFeatures = new SecurityPolicyFeature[] {
				new SecurityPolicyFeature("oracle/wss11_username_token_with_message_protection_client_policy") };
		LoaderIntegrationService loaderIntegrationService = loaderIntegrationService_Service
				.getLoaderIntegrationServiceSoapHttpPort(securityFeatures);
		BindingProvider wsbp = (BindingProvider) loaderIntegrationService;
		Map<String, Object> requestContext = wsbp.getRequestContext();
		requestContext.put(BindingProvider.USERNAME_PROPERTY, HCMConstants.getHcmUploadUser());
		requestContext.put(BindingProvider.PASSWORD_PROPERTY, HCMConstants.getHcmUploadPass());
		requestContext.put("oracle.webservices.security.keystore.type", "JKS");
		requestContext.put("oracle.webservices.security.keystore.location",
				"Provide the location of the default-keystore.jks (including the file name)");
		requestContext.put("oracle.webservices.security.keystore.password", "welcome");
		requestContext.put("oracle.webservices.security.encryption.key.alias", "orakey");
		requestContext.put("oracle.webservices.security.encryption.key.password", "welcome");
		requestContext.put("oracle.webservices.security.recipient.key.alias", "orakey");
		
		String batchName = "importAndLoadDataAsync";
		String autoLoad = "Y";
		String businessObj = businessObject;
		StringTokenizer strTok = new StringTokenizer(businessObj, ",");
		ArrayList businessObjList = new ArrayList();
		while (strTok.hasMoreTokens()) {
			businessObjList.add(strTok.nextToken());
		}
		String response;
		try {
			response = loaderIntegrationService.submitBatch(fileName, businessObjList, fileName, "FBL", autoLoad);
			logger.debug("The response received from the server is ..." +response);
	
		} catch (ServiceException e) {
			logger.error("Error occurred during the invocation of the service ...");
			   logger.log(Level.FATAL,e.getMessage(),e);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		loaderIntegrationService_Service = new LoaderIntegrationService_Service();
		SecurityPolicyFeature[] securityFeatures = new SecurityPolicyFeature[] {
				new SecurityPolicyFeature("oracle/wss11_username_token_with_message_protection_client_policy") };
		LoaderIntegrationService loaderIntegrationService = loaderIntegrationService_Service
				.getLoaderIntegrationServiceSoapHttpPort(securityFeatures);
		BindingProvider wsbp = (BindingProvider) loaderIntegrationService;
		Map<String, Object> requestContext = wsbp.getRequestContext();
		requestContext.put(BindingProvider.USERNAME_PROPERTY, "HCM.USER");
		requestContext.put(BindingProvider.PASSWORD_PROPERTY, "Welcome2");
		requestContext.put("oracle.webservices.security.keystore.type", "JKS");
		requestContext.put("oracle.webservices.security.keystore.location",
				"Provide the location of the default-keystore.jks (including the file name)");
		requestContext.put("oracle.webservices.security.keystore.password", "welcome");
		requestContext.put("oracle.webservices.security.encryption.key.alias", "orakey");
		requestContext.put("oracle.webservices.security.encryption.key.password", "welcome");
		requestContext.put("oracle.webservices.security.recipient.key.alias", "orakey");
		/*	String fileName = args[0];

		String batchName = args[1];
		String autoLoad = args[2];
		String businessObj = args[3];*/
		String fileName = "BU9";
		
		String batchName = "importAndLoadDataAsync";
		String autoLoad = "Y";
		String businessObj = "WorkRelationship";
		StringTokenizer strTok = new StringTokenizer(businessObj, ",");
		ArrayList businessObjList = new ArrayList();
		while (strTok.hasMoreTokens()) {
			businessObjList.add(strTok.nextToken());
		}
		String response;
		try {
			response = loaderIntegrationService.submitBatch(fileName, businessObjList, batchName, "FBL", autoLoad);
			System.out.println("The response received from the server is ...");
			System.out.println(response);
		} catch (ServiceException e) {
			System.out.println("Error occurred during the invocation of the service ...");
			e.printStackTrace();
		}
	}
}