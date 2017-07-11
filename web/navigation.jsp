<%-- 
    Document   : navigation
    Created on : Jul 11, 2017, 1:57:19 PM
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.min.css" rel="stylesheet" />
         <link href="css\bootstrap.min.css" rel="stylesheet">
        <link href="./css/bootstrap-datepicker.min.css" rel="stylesheet" />
        <link href="./css/bootstrap-datepicker3.min.css" rel="stylesheet" />
       
        <!--<title>JSP Page</title>-->
    </head>
    <body>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/bootstrap-datepicker.min.js"></script>
        <script src="./js/main.js"></script>
       
        <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="MainMenu.html">ObjectEdge Attendance</a>
    </div >
    <ul class="nav navbar-nav">
      <li ><a href="MainMenu.html" class="active">Home</a></li>
      <li class="active"><a href="EmpAdd.html">Add Employees</a></li>
      <li ><a href="EmpUpdate.html">Update Employee</a></li>
      <li ><a href="FormVacation.html">Going on Vacation</a></li>
      <li><a href="wfh.html">Working From Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Know Your Details
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="EmpDet.jsp">Employee Details</a></li>
          <li><a href="EmpVac.jsp">Employee Vacations</a></li>
          <li><a href="EmpWfh.jsp">Work From Home</a></li>
        </ul>

    </ul>
  </div>
        </nav> 
    </body>
</html>
