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
     
       
     
            try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
            }
      
            
      Connection  conn = DriverManager.getConnection("jdbc:oracle:thin:@10.176.1.94:1521:Doable","sys as sysdba","Oracle_1");
            

            
          /* try {
               conn= DriverManager.getConnection(URL,userName,password);
           } catch (SQLException ex) {
               Logger.getLogger(MyDb.class.getName()).log(Level.SEVERE, null, ex);
           }*/
        
        
        
       
            
    return conn;      
   }
}
 