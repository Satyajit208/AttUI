package com.oe.AttUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author user1
 */
public class UpdateEmp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
Connection con= null;

Statement st=null;
String id,Name,email,des;
float pl;
ResultSet rs;
int result;
public void init()throws ServletException {

try

{

Class.forName("com.mysql.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://LocalHost:3306/test","root","1234");

st=con.createStatement();

}

catch(ClassNotFoundException | SQLException ce)

{}

}

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>\n" +
"    <head>\n" +
"        <title>Update Employee</title>\n" +
"        <link href=\"./css/bootstrap.min.css\" rel=\"stylesheet\" />\n" +
"         <link href=\"css\\bootstrap.min.css\" rel=\"stylesheet\">\n" +
"        <link href=\"./css/bootstrap-datepicker.min.css\" rel=\"stylesheet\" />\n" +
"        <link href=\"./css/bootstrap-datepicker3.min.css\" rel=\"stylesheet\" />\n" +
"       \n" +
"    </head>\n" +
"    <body>\n" +
"         <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n" +
"        <script src=\"./js/bootstrap.min.js\"></script>\n" +
"        <script src=\"./js/bootstrap-datepicker.min.js\"></script>\n" +
"        <script src=\"./js/main.js\"></script>\n" +
"       \n" +
"        <nav class=\"navbar navbar-inverse\">\n" +
"  <div class=\"container-fluid\">\n" +
"    <div class=\"navbar-header\">\n" +
"      <a class=\"navbar-brand\" href=\"MainMenu.html\">ObjectEdge Attendance</a>\n" +
"    </div >\n" +
"    <ul class=\"nav navbar-nav\">\n" +
"      <li ><a href=\"MainMenu.html\" class=\"active\">Home</a></li>\n" +
"      <li ><a href=\"EmpAdd.html\">Add Employees</a></li>\n" +
"      <li class=\"active\"><a href=\"EmpUpdate.html\">Update Employee</a></li>\n" +
"      <li ><a href=\"FormVacation.html\">Going on Vacation</a></li>\n" +
"      <li><a href=\"wfh.html\">Working From Home</a></li>\n" +
"      <li class=\"dropdown\">\n" +
"        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Know Your Details\n" +
"        <span class=\"caret\"></span></a>\n" +
"        <ul class=\"dropdown-menu\">\n" +
"          <li><a href=\"EmpDet.jsp\">Employee Details</a></li>\n" +
"          <li><a href=\"EmpVac.jsp\">Employee Vacations</a></li>\n" +
"          <li><a href=\"EmpWfh.jsp\">Work From Home</a></li>\n" +
"        </ul>\n" +
"\n" +
"    </ul>\n" +
"  </div>\n" +
"        </nav></body></html><h2>Department Details</h2>");
            try {
            String empid,empname;
            empid=request.getParameter("empid");
            empname=request.getParameter("empname");
            
             String validation="select count(empid) from empdetails where empid='"+empid+"' and empname='"+empname+"';";
           // out.println(validation);
             
            rs = st.executeQuery(validation);
             while (rs.next()) 
                {
                 result=rs.getInt(1);
                //out.println(a);
                }
            
                if(result==0)
                    
                {
               // out.println("<>");
                out.println("<h3>Cannot find Id and name,Please try with different id or name  <h3>");
                rs.close();
              // st.close();
               // con.close();
                }
                else
                {
                
                String q="select * from empdetails where empid='"+empid+"' and empname='"+empname+"';";
                System.out.println(q);
                 rs= st.executeQuery(q);
                while(rs.next())
                {

                 id=rs.getString(1);
                 Name=rs.getString(2);
                 email=rs.getString(3);
                 des=rs.getString(4);
                pl=Float.parseFloat(rs.getString(5));
                
               out.println("<table class=\"table\">");
               out.println("<tr><th>Employee Id.</th><th>Employee Name</th><th>Employee Email</th><th>Employee Designation</th>"
                       + "<th>Employee Paid-Leaves</th></tr>");
                out.println("<tr><th>"+id+"</th><th>"+Name+"</th><th>"+email+"</th><th>"+des+"</th><th>"+pl+"</th></tr>");

                }
                

                out.println("</table>");
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Update Employee</title>");
                out.println("</head>");
                out.println("<body><h1><center>Update Employee </center></h1><br><br>\n" +
"    <form action=UpdateFinalEmp method=\"post\">\n" +
"     <h3>Employee ID: <input type=text readonly name=\"empid\" value=\""+id+"\" id=\""+1+"\"></h3>\n" +
"    <h3>Employee Name:<input type=text name=\"empname\" value=\""+Name+"\" id=\""+2+"\"></h3>\n" +
"     <h3>Employee Email:<input type=text name=\"empemail\" value=\""+email+"\" id=\""+3+"\"></h3>\n" +
"      <h3>Employee Designation:<input type=text name=\"empdes\" value=\""+des+"\" id=\""+4+"\"></h3>\n" +
"      <h3>Employee Paid-Leaves:<input type=text name=\"emppl\"value=\""+pl+"\" id=\""+5+"\"></h3>\n" +
"      \n" +
"    <input type=submit class=\"btn\" name=\"Update\" value=\"Update\"> \n" +"</form>");
           
                out.println("</body>");

                out.println("</html>");


                }
               
            } catch (SQLException ex) {
                Logger.getLogger(AddEmp.class.getName()).log(Level.SEVERE, null, ex);
            }
            

           
            }
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
            throws ServletException, IOException 
{
        processRequest(request, response);
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
            throws ServletException, IOException {
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
