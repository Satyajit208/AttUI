/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oe.getinfo;

import com.oe.AttUI.AddEmp;
import com.oe.connection.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user1
 */
public class FetchData extends HttpServlet {
    Connection con=null;
    Statement st=null;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
                con = DatabaseConnection.getConnection();
                st = con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(AddEmp.class.getName()).log(Level.SEVERE, null, ex);
            }
        response.setContentType("text/html;charset=UTF-8");
        
           ArrayList<EmpInfo> infolist = new ArrayList<EmpInfo>();
    try {
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from empdetails");

        while(rs.next()) {  
            EmpInfo in=new EmpInfo();
            in.setEmpid(rs.getString(1));
            in.setEmpname(rs.getString(2));
            in.setEmpemail(rs.getString(3));
            in.setEmpdes(rs.getString(4));
            in.setEmppl(Float.parseFloat(rs.getString(5)));
            infolist.add(in);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
         if (!infolist.isEmpty()) {
               
                request.setAttribute("Information",infolist );
               // request.getRequestDispatcher("/EmpUpdate.jsp").forward(request, response);
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
            throws ServletException, IOException {
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
