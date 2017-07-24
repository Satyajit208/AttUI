<%-- 
    Document   : EmpAddOP
    Created on : Jul 11, 2017, 2:47:59 PM
    Author     : user1
--%>
<%@include file="Design/BootstrapLinks.jsp" %>
<%@include file="Design/navigation.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Vacation Table</h2>
        <table class="table table-bordered">
    <thead>
      <tr>
        <th>Employee ID</th>
        <th>Employee Name</th>
        <th>Employee Email</th>
        <th>Employee Designation</th>
        <th>Employee Paid-Leaves</th>
        <th>Employee Vacation From</th>
        <th>Employee Resume On</th>
        <th>Balance</th>
        
      </tr>
    </thead>
            
    <c:forEach items="${Result}" var="Result">
        
        <tr>
            <td>${Result.id}</td>
            <td>${Result.name}</td>
            <td>${Result.email}</td>
            <td>${Result.des}</td>
            <td>${Result.pl}</td>
            <td>${Result.vf}</td>
            <td>${Result.vt}</td>
            <td>${Result.balance}</td>
        </tr>
    </c:forEach>
</table>
    </body>
</html>
