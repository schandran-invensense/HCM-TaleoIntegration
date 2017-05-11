package com.invensense.connector;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class InvIntegrationUtil {
    private  Connection con = null;
	private  PreparedStatement stmt = null;
	private  ResultSet rs = null;
	private Logger logger = Logger.getLogger(this.getClass());
	
	/*@Autowired
	JdbcTemplate jdbct;
	
	public InvIntegrationUtil(DataSource dataSource) {
		jdbct = new JdbcTemplate(dataSource);
	}
	
	public String getExecutionDate(int interfaceId)
	{
		logger.debug("In get method");
		String iid = "0";
		 String sql="select UPDATE_DATE from xxinv_integration_interface where interface_id=?";
		 try{
			 
		logger.debug("Datasource :: "+jdbct.getDataSource());
	
		List<Map<String, Object>> rows =  jdbct.queryForList(sql,interfaceId);
			logger.debug("In get method");
			if (rows != null && rows.size() > 0) {
				Map<String, Object> item = rows.get(0);
				
				try {
					iid = (String) item.get("UPDATE_DATE");
					logger.debug("In get method");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		 }catch(Exception e)
		 {
			 logger.debug("In Exception: "+e.getMessage());
			 e.printStackTrace();
		 }
			return iid;
	}*/
	
    public  String getUpdateDate(String interfaceCode)
    {      
        String date=null;
        SimpleDateFormat ft =  new SimpleDateFormat ("yyyy-MM-dd'T'HH:mm:ss.sss");
        try{
        con = ConnectionManager.getConnection();        
        logger.debug("Connection is "+con);        
        
        String sql="select * from xxinv_integration_interface where interface_id=?";
      
        stmt = con.prepareStatement(sql);
        stmt.setString(1, interfaceCode);
        rs = stmt.executeQuery();
        while(rs.next())
        {
        	logger.debug("Instance Id is :"+rs.getString(1)); 
        	logger.debug("Updated Date is :"+rs.getString(2));            
            //date=ft.format(rs.getString(2));
            //Date parsedDate = (java.sql.Date)ft.parse(date);
            date =rs.getString(2);
            logger.debug("Returning Date is :"+date);
            if (date.equals(null))
            {
            	logger.debug("Inside Date Null :");
            	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
            	Date curdate = new Date();
            	logger.debug("Currenty Date is "+dateFormat.format(date)); 
            	 date=dateFormat.format(date).toString();
            }
            
        }
      
        con.close();  
        }catch(Exception ex)
        {
            logger.debug("Exception in Int class :"+ex.getMessage());
        }
        
        logger.debug("Returning Date is :"+date);
        return date;
    }
    
    public  int setInterfaceDtl(String interfaceCode)
    {
        int i=0;
      try{
        con = ConnectionManager.getConnection();
        
        logger.debug("Connection is "+con);        
        
        String sql="insert into xxinv_integration_interface values(?,SYSDATE)";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, interfaceCode);
         i=stmt.executeUpdate();         
         logger.debug(i+" records inserted");  
        
      }catch(Exception ex)
      {
    	  logger.debug("Exception in set methos is :"+ex.getMessage());
      }
      return i;
    }
    public  String getPersonNumber(int personId)
    {
        String personNum=null;
         try{
        con = ConnectionManager.getConnection();        
        logger.debug("Connection is "+con);        
        
        String sql="select * from xxinv_integration_person where person_id=?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1,personId);
        rs = stmt.executeQuery();
        while(rs.next())
        {
        	logger.debug("Person Id is :"+personId); 
        	logger.debug("Person Num is :"+rs.getString(2));            
            personNum=rs.getString(2);
            
        }
        con.close();  
        }catch(Exception ex)
        {
        	logger.debug("Exception in Int class :"+ex.getMessage());
        }
         return personNum;
    }
    
    public  void main(String[] args) {
        
    	logger.debug("Inside main class");
        int i=setInterfaceDtl("333");
        logger.debug("Insert completed :"+i);
        String UpdatedDate=getUpdateDate("111");
        logger.debug("Date received is :"+UpdatedDate);
        String empNum=getPersonNumber(101);
        logger.debug("Person number:"+empNum);
        
    }
    
}
