package com.oe.AttUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oe.connection.DatabaseConnection;
import com.oe.models.VacationEmp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonObject;


public class VacEmp extends HttpServlet {

    
    Connection con = null;

    Statement st = null;
    int result;
    String id, Name, email, des, vt, vf;
    float pl, balance;
    ResultSet rs;
    //Object Result=new Object();

    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            con = DatabaseConnection.getConnection();
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(AddEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectMapper mapper = new ObjectMapper();
        //JsonObject json = null;
        List<VacationEmp> empVacList = new ArrayList<>();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String empid, empname, ht, hf;
            empid = request.getParameter("empid");
            empname = request.getParameter("empname");
            String replace = request.getParameter("hf");
            String replace1 = request.getParameter("ht");
            //  out.println(replace+","+replace1);
            hf = replace.replace('/', '-');
            ht = replace1.replace('/', '-');
            //out.println(hf+","+ht);

            //calculate no of days
            final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            final LocalDate firstDate = LocalDate.parse(hf, formatter);
            final LocalDate secondDate = LocalDate.parse(ht, formatter);
            final long days = ChronoUnit.DAYS.between(firstDate, secondDate);

            try {
                String validation = "select count(empid) from empdetails where empid='" + empid + "' and empname='" + empname + "';";
                // out.println(validation);

                rs = st.executeQuery(validation);
                while (rs.next()) {
                    result = rs.getInt(1);
                    //out.println(a);
                }

                if (result == 0) {
                    //   out.println("<h3>Id or name not found<h3>");

                    
                    
                    request.setAttribute("error", "Id or name not found");
                    request.getRequestDispatcher("/FormVacation.jsp").forward(request, response);
                    // st.close();

                } else {
                    String availvacation = "select emppl from empdetails where empid='" + empid + "';";
                    rs = st.executeQuery(availvacation);
                    while (rs.next()) {
                        Float paidleaves = rs.getFloat(1);
                        balance = paidleaves - days;
                        // rs.close();
                        //out.println(a);
                    }

                    //rs.close();
                    String insert = "insert into empvacation values('" + empid + "','" + hf + "','" + ht + "','" + days + "','" + balance + "');";
                    //System.out.println(q);

                    st.executeUpdate(insert);

                    //out.println("Records inserted sucessfully");
                    //display table
                    String query = "SELECT a.empid, a.empname,a.empemail,a.empdes,a.emppl, b.vfrom, b.vto ,b.totaldays,b.balance FROM empdetails a, empvacation b WHERE a.empid = b.empid=" + empid + ";";

                    rs = st.executeQuery(query);
//               

                    while (rs.next()) {
                        VacationEmp empVac = new VacationEmp();
                        empVac.setId(rs.getString(1));
                        empVac.setName(rs.getString(2));
                        empVac.setEmail(rs.getString(3));
                        empVac.setDes(rs.getString(4));
                        empVac.setPl(Float.parseFloat(rs.getString(5)));
                        empVac.setVf(rs.getString(6));
                        empVac.setVt(rs.getString(7));
                        empVac.setTotaldays(rs.getString(8));
                        empVac.setBalance(rs.getFloat(9));

                        empVacList.add(empVac);
                    }
                    // out.println("</table>");
                }

                String update = "update empdetails set emppl='" + balance + "' where empid='" + empid + "';";
                st.executeUpdate(update);
            } catch (SQLException ex) {
                Logger.getLogger(AddEmp.class.getName()).log(Level.SEVERE, null, ex);
            }

            //out.print(1);
            if (!empVacList.isEmpty()) {
                //response.getWriter().write(mapper.writeValueAsString(empVacList));
               // out.print(2);
                out.println(mapper.writeValueAsString(empVacList));
                
                
              //Result=mapper.writeValueAsString(empVacList);
//                System.out.println(Result);
                request.setAttribute("Result",empVacList );
                request.getRequestDispatcher("/VacationDetails.jsp").forward(request, response);
            }

            //out.print(3);
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
