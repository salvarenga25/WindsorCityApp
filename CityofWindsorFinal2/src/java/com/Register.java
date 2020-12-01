/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author useruser
 */
public class Register extends HttpServlet {

      
        
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
       
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
       
    }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
             String usname = request.getParameter("username");
             String email = request.getParameter("inemail");
             PrintWriter writer = response.getWriter();
             MyDb db = new MyDb();
             response.setContentType("text/html");
             response.setCharacterEncoding("UTF-8");
             String insert = "insert into t_city_subscribers values(?,?)";
             Connection conn;
             
                 try {
                     conn = db.getCon();
                      if(conn == null) {
                       writer.println("No Connection");
                    }
                        PreparedStatement pstmt=conn.prepareStatement(insert);
                        pstmt = conn.prepareStatement(insert);
                        pstmt.setString(1,usname);
                        pstmt.setString(2,email);
                        pstmt.execute();
                        writer.println("Success! Welcome to the Community!");
                 } catch (SQLException ex) {
                     Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                     
       }
  }
                 
            
     
     

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    



