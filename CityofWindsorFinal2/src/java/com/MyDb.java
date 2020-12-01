/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDb {
    Connection conn;
    
   public Connection getCon() throws SQLException {
     
       
     //attempting to add the driver to connect to the database (this one comes from the library ojdbc8.jar)
            try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
            }
      
            
      Connection  conn = DriverManager.getConnection("jdbc:oracle:thin:@HOST:orcl","username","password");//parameters have been deleted for security reasons
            

            
          /* try {
               conn= DriverManager.getConnection(URL,userName,password);
           } catch (SQLException ex) {
               Logger.getLogger(MyDb.class.getName()).log(Level.SEVERE, null, ex);
           }*/
        
        
        
       
            
    return conn;      
   }
}
 
