package com.oe.AttUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.oe.connection.DatabaseConnection;
import com.oe.models.UpdateModel;
import com.oe.models.VacationEmp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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



            protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                List<UpdateModel> empUpdateList = new ArrayList<>();
        try {//GET DB CONNECTION
            con = DatabaseConnection.getConnection();
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(AddEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            try {
            String empid,empname;
            empid=request.getParameter("empid");
            empname=request.getParameter("empname");
            
             String validation="select count(empid) from empdetails where empid='"+empid+"' and empname='"+empname+"';";
                System.out.println(validation);
                
           // out.println(validation);
             
            rs = st.executeQuery(validation);
             while (rs.next()) 
                {
                 result=rs.getInt(1);
                //out.println(a);
                }
            
                if(result==0)
                    
                {
                     request.setAttribute("error", "Id or name not found");
                    request.getRequestDispatcher("/EmpUpdate.jsp").forward(request, response);
                }
                else
                {
                
            String q="select * from empdetails where empid='"+empid+"' and empname='"+empname+"';";
          
            rs= st.executeQuery(q);
            while(rs.next())
                {
                UpdateModel update=new UpdateModel();
                update.setId(rs.getString(1));
                update.setName(rs.getString(2));
                update.setEmail(rs.getString(3));
                update.setDes(rs.getString(4));
                update.setPl(Float.parseFloat(rs.getString(5)));
                empUpdateList.add(update);
//               out.println("<table class=\"table\">");
//               out.println("<tr><th>Employee Id.</th><th>Employee Name</th><th>Employee Email</th><th>Employee Designation</th>"
//                       + "<th>Employee Paid-Leaves</th></tr>");
//                out.println("<tr><th>"+id+"</th><th>"+Name+"</th><th>"+email+"</th><th>"+des+"</th><th>"+pl+"</th></tr>");
               
                
                }
                if(!empUpdateList.isEmpty())
                {
                request.setAttribute("Result",empUpdateList );
                request.getRequestDispatcher("/updatedetails.jsp").forward(request, response);
                
                
                }
                
                    

                


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
