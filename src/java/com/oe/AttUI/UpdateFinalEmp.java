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
public class UpdateFinalEmp extends HttpServlet {

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
            String empid,empname,empemail,empdes;
            float emppl;
            empid=request.getParameter("empid");
            empname=request.getParameter("empname");
            empemail=request.getParameter("empemail");
            empdes=request.getParameter("empdes");
            emppl=Float.parseFloat(request.getParameter("emppl"));
            //out.println(empid+","+emppl);
           String q="update empdetails set empname='"+empname+"' , empemail='"+empemail+"' , empdes='"+empdes+"' , emppl="+emppl+" where empid='"+empid+"';";
            System.out.println(q);
            try {
                st.executeUpdate(q);
            } catch (SQLException ex) {
                Logger.getLogger(AddEmp.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("Records Updated Sucessfully ");
            response.sendRedirect("EmpUpdate.html");
           
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