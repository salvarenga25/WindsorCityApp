/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
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
public class search extends HttpServlet {

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
        //esponse.setContentType("text/html;charset=UTF-8");
       
       
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws java.sql.SQLException
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\n" +
                                "<html lang=\"en\">\n" +
                                "<head>\n" +
                                "    <meta charset=\"UTF-8\">\n" +
                                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                                "    <link rel=\"stylesheet\" href=\"./public/main.css\" type =\"text/css\"/>\n" +
                                "    <script src=\"https://maps.googleapis.com/maps/api/js?AIzaSyCCqD1RqN6Egitjz8XVRZW021qX_VbkiSI&callback=myMap\"></script>\n" +
                                "    <title>CoW Web-Based App</title>\n" +
                                "</head>");
        writer.append("<body>\n" +
"                      <div id=\"wrapper\"> \n" +
                    "    <header>\n" +
                    "        <div class=\"container\"> \n" +
                    "        \n" +
                    "            <img src=\"https://www.citywindsor.ca/residents/Culture/PublishingImages/City%20Logo%20-%201%20Colour%20-%20White%20-%20JPEG.jpg\" alt=\"logo\" class=\"logo\">\n" +
                    "            \n" +
                    "            <nav>\n" +
                    "             <ul>\n" +
                    "                <li><a href= \"http://10.176.1.149:58394/CityofWindsorFinal2/Main.html\"> Main</a></li>\n" +
                    "                <li class=\"current\"><a href= \"http://10.176.1.149:58394/CityofWindsorFinal2/CommunityCentre.html\"> Community Centres</a></li>\n" +
                    "                <li><a href= \"http://10.176.1.149:58394/CityofWindsorFinal2/ParkingLots.html\"> Parking Lots</a></li>\n" +
                    "                <li><a href= \"http://10.176.1.149:58394/CityofWindsorFinal2/GarbageCollectio.html\"> Garbage Collection</a></li>\n" +
                    "                <li><a href= \"http://10.176.1.149:58394/CityofWindsorFinal2/BusRoutes.html\"> Bus Routes</a></li>\n" +
                    "                <li><a href= \"http://10.176.1.149:58394/CityofWindsorFinal2/SpecialEvents.html\"> Special Events</a></li>\n" +
                    "                <li><a href= \"http://10.176.1.149:58394/CityofWindsorFinal2/Other.html\"> Other</a></li>\n" +               
                    "            </ul>\n" +
                    "            </nav>\n" +
                    "            \n" +
                    "            \n" +
                    "        </div>\n" +
                    "        </header>\n" +
                    "    \n" +
                    "<section id = \"map-showcase\">\n" +
                    "    <div class = \"container\">\n" +
                    "        <h1>Community Centre</h1>\n" +
                    "            <h2>Locate our Community Centres!</h2>\n" +     
                    "        <h2> Community Centre:</h2>\n" +
                    "        <div id=\"details\">" +
                    "    <div class=\"container1\">\n" +
                    "<table>\n" +
                    "  <tr>\n" +
                    "    <th>Location Name</th>\n" +
                    "    <th>Phone Number</th>\n" +
                    "    <th>Address</th>" +
                    "    <th>Zip Code</th>" +
                    "  </tr>\n" );
                    
        MyDb db = new MyDb();//Creates a db connection with Oracle 
        try{
        Connection conn = db.getCon(); //tests if the connection is null or not
        if(conn == null){
            writer.println("No Connection");
        }
        Statement stmt = conn.createStatement();//Starts an SQL Statement
        ResultSet rs = stmt.executeQuery("Select * from T_CITY_CENTRE");//Executes the Select query
        
        while(rs.next()){//Brings all the results from the database 
                 writer.append("  <tr>\n");
                writer.append("<td>"+rs.getString(1)+"</td>"+
                              "<td>"+rs.getString(2)+"</td>"+
                              "<td>"+rs.getString(3)+"</td>"+
                              "<td>"+rs.getString(4) +"</td>");
                writer.append("  </tr>\n");
        }
       rs.close();
      } catch(SQLException ex){
         Logger.getLogger(search.class.getName()).log(Level.SEVERE,null,ex);
      }
       
        
        writer.append(" \"</table>\\n\" +\n" +                    
"                    \"    </div> \\n\" +\n" +
"                    \"         \\n\" +\n" +
"                    \"    </div>\\n\" +\n" +
"                    \"</section>\\n\" +\n" +
"                    \"</div>\\n\" +\n" +
"                    \"\\n\" +\n" +
"                    \"\\n\" +\n" +
"                    \"</body>\\n\" +\n" +
"                    \"\\n\" +\n" +
"                    \"    \\n\" +\n" +
"                    \"    \\n\" +\n" +
"                    \"</html>\"");
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
       
            processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

