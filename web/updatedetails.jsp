<%-- 
    Document   : updatedetails
    Created on : Jul 17, 2017, 1:33:57 PM
    Author     : user1
--%>

<%@include file="Design/BootstrapLinks.jsp" %>
<%@include file="Design/navigation.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.oe.AttUI.UpdateFinalEmp"  %>
<!DOCTYPE html>
<html>

    <body>
        <h2>Update Table</h2>
        <c:forEach items="${Result}" var="Result">
            <div class="container" >
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Employee ID</th>
                            <th>Employee Name</th>
                            <th>Employee Email</th>
                            <th>Employee Designation</th>
                            <th>Employee Paid-Leaves</th>
                            <th>Employee Date Of Joining </th>
                            <th>Employee Address </th>
                            <th>Employee Contact no </th>

                        </tr>
                    </thead>

                    <tr>
                        <td>${Result.id}</td>
                        <td>${Result.name}</td>
                        <td>${Result.email}</td>
                        <td>${Result.des}</td>
                        <td>${Result.pl}</td>
                        <td>${Result.doj}</td>
                        <td>${Result.addr}</td>
                        <td>${Result.contact}</td>

                    </tr>
                </table>
            </div>

            <h2>Employee Update</h2>
            <div class="container">
                <form action="UpdateFinalEmp" method="post">
                    <div class="form-group">
                        <label for="Employee ID:">Employee ID:</label>
                        <input type="text" class="form-control" name="empid" value="${Result.id}" >
                    </div>
                    <div class="form-group">
                        <label for="empname">Employee Name:</label>
                        <input type="text" class="form-control" name="empname" value="${Result.name}">
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" name="empemail" value="${Result.email}">
                    </div>
                    <div class="form-group">
                        <label for="Des">Designation:</label>
                        <input type="text" class="form-control" name="empdes"  value="${Result.des}">
                    </div>
                    <div class="form-group">
                        <label for="pl">Paid-Leaves:</label>
                        <input type="number" class="form-control" name="emppl" value="${Result.pl}">
                    </div>
                    <div class="form-group">                
                        <label for="doj">Employee Date Of Joining</label>
                        <div class="input-group input-append date datepicker" id="toDatePicker">
                            <input type="text" class="form-control" id="dtTo" name="empdoj" value="${Result.doj}">
                            <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>

                    </div>





                    <div class="form-group">
                        <label for="addr">Employee Address:</label>
                        <input type="text" class="form-control" name="empaddr" value="${Result.addr}">
                    </div>

                    <div class="form-group">
                        <label for="contact">Employee Contact No:</label>
                        <input type="number" class="form-control" name="empcontact" value="${Result.contact}">
                    </div>

                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>

        </c:forEach>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/bootstrap-datepicker.min.js"></script>
    <script src="./js/main2.js"></script>

</html>
