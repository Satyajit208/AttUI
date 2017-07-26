package com.oe.AttUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.oe.connection.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

public class Empwfh extends HttpServlet {

    Connection con = null;
    Statement st = null;
    int result, size;
//String id,Name,email,des,vt,vf;
    float tothours = 0, wfhh;
    ResultSet rs;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {//Get datebase connection
            con = DatabaseConnection.getConnection();
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(AddEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String empid, empname, wfhd;
            empid = request.getParameter("empid");
            empname = request.getParameter("empname");
            String replace = request.getParameter("wfhd");
            wfhh = Float.parseFloat(request.getParameter("wfhh"));
            wfhd = replace.replace('/', '-');

            try {//calculate total hours
                String totalhours = "select empwfhh from empwfh where empid='" + empid + "';";
                rs = st.executeQuery(totalhours);
                while (rs.next()) {
                    tothours = tothours + rs.getFloat(1);
                }
                float finaltotalhours = tothours + wfhh;
                //out.println(tothours);
                //tothours=0;
                String insert = "insert into empwfh values('" + empid + "','" + wfhd + "','" + wfhh + "','" + finaltotalhours + "');";
                //System.out.println(q);

                st.executeUpdate(insert);
                
                //showing message on modal 
                request.setAttribute("error", "Update Successfull");
                request.getRequestDispatcher("/wfh.jsp").forward(request, response);
                // out.println("Records inserted sucessfully");

            } catch (SQLException ex) {
                Logger.getLogger(AddEmp.class.getName()).log(Level.SEVERE, null, ex);
            }
            tothours = 0;
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
