/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oe.AttUI;

import com.oe.connection.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user1
 */
public class UpdatePL extends HttpServlet {

    Connection con = null;
    String lstupdate;
    float add = (float) 1.5;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
       Date date=new Date();
       String currDate=dateFormat.format(date);
       
       
        //get the last update date
       
        try {
            con = DatabaseConnection.getConnection();
            Statement dateSt=con.createStatement();
            String getdate="select * from updatedate;";
            ResultSet dateRs=dateSt.executeQuery(getdate);
            while(dateRs.next())
            {
            lstupdate=dateRs.getString(1);
            }
            } 
        catch (SQLException ex) 
        {
            Logger.getLogger(UpdatePL.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       //calculate no of days
       final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
       final LocalDate firstDate = LocalDate.parse(lstupdate , formatter);
       final LocalDate secondDate = LocalDate.parse(currDate, formatter);
       final long days = ChronoUnit.DAYS.between(firstDate, secondDate);
       
        //calcualte how many days left for next update
        int daysRemained=(int) (30-days);
        
            if(days>30)
            {
        try {

            con = DatabaseConnection.getConnection();
           Statement st = con.createStatement(); 
            String update="update updatedate set lst_update='"+currDate+"';";
             Statement upst = con.createStatement();
             upst.execute(update);
            
            
            
            
            String timequery = "select emppl,empid from empdetails where timestampdiff(day,empdoj,current_date)>180;";

            ResultSet rs = st.executeQuery(timequery);
            while (rs.next()) {
                Float paidleaves = rs.getFloat(1);
                String empid = rs.getString(2);
                Float updatePL = paidleaves + add;
                String Update = "update empdetails set emppl=" + updatePL + " where empid='" + empid + "';";
                Statement st1 = con.createStatement();
                st1.execute(Update);
                updatePL = (float) 0.0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        request.setAttribute("error", "Update Successfull");
         request.getRequestDispatcher("/MainMenu.jsp").forward(request, response);
        //response.sendRedirect("MainMenu.jsp");
        
            }
            else
            {
             request.setAttribute("error", "Please wait for next "+daysRemained+" days for updation");
         request.getRequestDispatcher("/MainMenu.jsp").forward(request, response);
      //  response.sendRedirect("MainMenu.jsp");
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
