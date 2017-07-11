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
public class AddEmp extends HttpServlet {

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
ResultSet rs;
int result;
String empid,empname,empemail,empdes;
float emppl;

@Override
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
        PrintWriter out = response.getWriter();
          empid=request.getParameter("empid");
            empname=request.getParameter("empname");
            empemail=request.getParameter("empemail");
            empdes=request.getParameter("empdes");
            emppl=Float.parseFloat(request.getParameter("emppl"));
            out.println(empdes + empemail + empname + empid );
            
out.println("<html>\n" +
"    <head>\n" +
"        <title>Add Employee</title>\n" +
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
"      <li class=\"active\"><a href=\"EmpAdd.html\">Add Employees</a></li>\n" +
"      <li ><a href=\"EmpUpdate.html\">Update Employee</a></li>\n" +
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
"        </nav></body></html>");
        try
        {
           
          
            String validation="select count(empid) from empdetails where empid='"+empid+"' and empname='"+empname+"';";
           // out.println(validation);
             
            rs = st.executeQuery(validation);
             while (rs.next()) 
                {
                 result=rs.getInt(1);
                //out.println(a);
                }
            
               
                if(empid=="" && empname==null)
                {
                response.sendError(result, empid);
                }
                  else if(result!=0)
                    
                {
               // out.println("<>");
                out.println("<h3>Duplicate entry for same id and name,Please try with different id or name  <h3>");
                rs.close();
              // st.close();
               // con.close();
                }
                else
                {
// out.println(empid+","+emppl);
            String q="insert into empdetails values('"+empid+"','"+empname+"','"+empemail+"','"+empdes+"',"+emppl+");";
           // System.out.println(q);
            
                st.executeUpdate(q);
                out.println("Records inserted sucessfully");
                st.close();
                con.close();
                }
        } 
        catch (SQLException ex) 
            {
                Logger.getLogger(AddEmp.class.getName()).log(Level.SEVERE, null, ex);
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
