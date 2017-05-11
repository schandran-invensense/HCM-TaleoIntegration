package com.invensense.impl.hcm;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import org.apache.log4j.Logger;

import com.invensense.connector.HCMConnector;
import com.invensense.utils.HCMConstants;
import com.oracle.xmlns.apps.hcm.common.batchloader.core.loaderintegrationservice.LoaderIntegrationService;
import com.oracle.xmlns.apps.hcm.common.batchloader.core.loaderintegrationservice.LoaderIntegrationServiceSoapHttpPortClient;
import com.oracle.xmlns.apps.hcm.common.batchloader.core.loaderintegrationservice.LoaderIntegrationService_Service;
import com.oracle.xmlns.apps.hcm.common.batchloader.core.loaderintegrationservice.ServiceException;

import java.io.IOException;
import oracle.stellent.ridc.IdcClient;
import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.IdcClientManager;
import oracle.stellent.ridc.IdcContext;
import oracle.stellent.ridc.model.DataBinder;
import oracle.stellent.ridc.model.TransferFile;
import oracle.stellent.ridc.protocol.ServiceResponse;
import weblogic.wsee.jws.jaxws.owsm.SecurityPolicyFeature;

public class UploadFile {
	@WebServiceRef
	private static LoaderIntegrationService_Service loaderIntegrationService_Service;
	private  Logger logger = Logger.getLogger(this.getClass());

	public   String uploadFileAndLoad(String fileName,String folderPath,String businessObject)
	{
		try{
		 IdcClientManager m_clientManager = new IdcClientManager();
		
		 IdcClient idcClient =
		 m_clientManager.createClient( HCMConstants.getHcmUploadUrl());//"https://hbbc-test.hcm.us2.oraclecloud.com:443/cs/idcplg"); // replace with relevant URL
	//	 IdcContext userContext = new IdcContext("HCM_ADMIN", "Password");
		 IdcContext userContext = new IdcContext(HCMConstants.getHcmUploadUser(),HCMConstants.getHcmUploadPass());
		 logger.debug("Folder name :: "+folderPath+"::::filename:::"+fileName);
		 // replace with relevant username password
		 checkin(idcClient,userContext,folderPath,
				 // Replace with fully qualified path to source file
		 "Document", // content type
		 "BusinessUnit1", // doc title
		 userContext.getUser(), // author
		 "FAFusionImportExport", // security group
		 "hcm$/dataloader$/import$", // account
		 fileName); // dDocName - this is the ContentId
		 
		 logger.debug("After checkin :::");
		 
	 LoaderIntegrationServiceSoapHttpPortClient loadClient = new LoaderIntegrationServiceSoapHttpPortClient();
		 loadClient.loadService(fileName,businessObject);
		//}
		}
		catch(Exception e)
		{
			
		}
		return "Success";
	}
	
	/*public static void main(String[] args) {
		try {
			 IdcClientManager m_clientManager = new IdcClientManager();
			 IdcClient idcClient =
			 m_clientManager.createClient("https://hbbc-TEST.fs.us2.oraclecloud.com:443/cs/idcplg");//"https://hbbc-test.hcm.us2.oraclecloud.com:443/cs/idcplg"); // replace with relevant URL
		//	 IdcContext userContext = new IdcContext("HCM_ADMIN", "Password");
			 IdcContext userContext = new IdcContext("HCM.USER", "Welcome2");
				
			 // replace with relevant username password
			 String dDocName= checkin(idcClient,userContext,"D://INVENSENSE//Projects//HRIntegration//CreateEmployee//WorkRelationship29.zip",
					 // Replace with fully qualified path to source file
			 "Document", // content type
			 "BusinessUnit1", // doc title
			 userContext.getUser(), // author
			 "FAFusionImportExport", // security group
			 "hcm$/dataloader$/import$", // account
			 "BU10"); // dDocName - this is the ContentId
			 
			 System.out.println("After checkin :::");
			 callLoaderService(dDocName);
		}
		catch (IdcClientException e)
		{e.printStackTrace();}
		 }*/
		 /**
		 * Method description
		 * @param idcClient
		 * @param userContext
		 * @param sourceFileFQP fully qualified path to source content
		 * @param contentType content type
		 * @param dDocTitle doc title
		 * @param dDocAuthor author
		 * @param dSecurityGroup security group
		 * @param dDocAccount account
		 * @param dDocName dDocName
		 *
		 * @throws IdcClientException
		 */
		 public static String checkin(IdcClient idcClient, IdcContext userContext,
		 String sourceFileFQP, String contentType,
		String dDocTitle, String dDocAuthor,
		String dSecurityGroup, String dDocAccount,
		String dDocName) throws IdcClientException {
		 InputStream is = null;
		 try {
		 String fileName =
		 sourceFileFQP.substring(sourceFileFQP.lastIndexOf('/') + 1);
		 is = new FileInputStream(sourceFileFQP);
		 long fileLength = new File(sourceFileFQP).length();
		 TransferFile primaryFile = new TransferFile();
		 primaryFile.setInputStream(is);
		 primaryFile.setContentType(contentType);
		 primaryFile.setFileName(fileName);
		 primaryFile.setContentLength(fileLength);
		 // note!!! when using HTTP protocol (not intradoc/jaxws) - you must explicitly
		 // set the Content Length when supplying an InputStream to the transfer file
		 // e.g. primaryFile.setContentLength(xxx);
		 // otherwise, a 0-byte file results on the server
		 DataBinder request = idcClient.createBinder();
		 request.putLocal("IdcService", "CHECKIN_UNIVERSAL");
		 request.addFile("primaryFile", primaryFile);
		 request.putLocal("dDocTitle", dDocTitle);
		 request.putLocal("dDocAuthor", dDocAuthor);
		 request.putLocal("dDocType", contentType);
		 request.putLocal("dSecurityGroup", dSecurityGroup);
		 // if server is setup to use accounts - an account MUST be specified
		 // even if it is the empty string; supplying null results in Content server
		 // attempting to apply an account named "null" to the content!
		 request.putLocal("dDocAccount", dDocAccount == null ? "" : dDocAccount);
		 if (dDocName != null && dDocName.trim().length() > 0) {
			 request.putLocal("dDocName", dDocName);
			 System.out.println("Doc id ::"+dDocName);
			 }
			 // execute the request
			 ServiceResponse response =
			 idcClient.sendRequest(userContext, request); // throws IdcClientException
			 // get the binder - get a binder closes the response automatically
			 DataBinder responseBinder =
			 response.getResponseAsBinder(); // throws IdcClientException
			
			 } catch (IOException e) {
			 e.printStackTrace(System.out);
			 } finally {
			 if (is != null) {
			 try {
			 is.close();
			 } catch (IOException ignore) {
			 }
			 }
			 }
		 return dDocName;
			 }
	

		 public static void callLoaderService(String dDocName)
		 {
			
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
					String businessObj = "Person";
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


