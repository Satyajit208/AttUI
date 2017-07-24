package com.oe.AttUI;

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
import javax.json.JsonObject;

/**
 *
 * @author user1
 */
public class AddEmp extends HttpServlet {

    Connection con = null;
    Statement st = null;
    ResultSet rs;
    int result;
    String empid, empname, empemail, empdes;
    float emppl;

    @Override
    public void init() throws ServletException {

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            con = DatabaseConnection.getConnection();
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(AddEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        JsonObject json = null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        empid = request.getParameter("empid");
        empname = request.getParameter("empname");
        empemail = request.getParameter("empemail");
        empdes = request.getParameter("empdes");
        emppl = Float.parseFloat(request.getParameter("emppl"));
        //out.println(empdes + empemail + empname + empid );

        try {

            String validation = "select count(empid) from empdetails where empid='" + empid + "' and empname='" + empname + "';";
            // out.println(validation);

            rs = st.executeQuery(validation);
            while (rs.next()) {
                result = rs.getInt(1);
                //out.println(a);
            }

            if (result != 0) {
                request.setAttribute("error", "Duplicate Id and Name");
                request.getRequestDispatcher("/EmpUpdate.jsp").forward(request, response);
            } else {
                // out.println(empid+","+emppl);
                String q = "insert into empdetails values('" + empid + "','" + empname + "','" + empemail + "','" + empdes + "'," + emppl + ");";
                // System.out.println(q);

                st.executeUpdate(q);
//                json = Json.createObjectBuilder()
//                        .add("message", "Records inserted sucessfully")
//                        .build();
//                
//                //st.close();
//                DatabaseConnection.closeConnection(con);
                request.setAttribute("error", "Employee Registered");
                request.getRequestDispatcher("/EmpAdd.jsp").forward(request, response);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AddEmp.class.getName()).log(Level.SEVERE, null, ex);
        }

//        if(json == null) {
//            json = Json.createObjectBuilder().build();
//        }
//        
//        response.getWriter().write(json.toString());
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
