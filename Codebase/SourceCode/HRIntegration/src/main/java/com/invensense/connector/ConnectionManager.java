/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invensense.connector;


import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class ConnectionManager {

    /**
     * @param args the command line arguments
     */
    
    private static final String driverName  = "oracle.jdbc.driver.OracleDriver";
    private static final String url  = "jdbc:oracle:thin:@devdb.invcorp.invensense.com:1528:INVNPRJ1";
    private static final String username  = "apps";
    private static final String password  = "prj1_apps";
    private static Connection con;
    private Logger logger = Logger.getLogger(this.getClass());
    
    public static Connection getConnection() {
      try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url,username, password);
            } catch (Exception ex) {
            }
        } catch (ClassNotFoundException ex) {
          
        }
        return con;
    }
    
}
