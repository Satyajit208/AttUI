<%@page import="java.sql.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="./css/bootstrap.min.css" rel="stylesheet" />
         <link href="css\bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Records</title>

</head>

<body>
    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" >ObjectEdge Attendance</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="MainMenu.html">Home</a></li>
      <li><a href="EmpAdd.html">Add Employees</a></li>
      <li><a href="EmpUpdate.html">Update Employee</a></li>
      <li><a href="FormVacation.html">Going on Vacation</a></li>
      <li><a href="wfh.html">Working From Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Know Your Details
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="EmpDet.jsp">Employee Details</a></li>
          <li class="active"><a href="EmpVac.jsp">Employee Vacations</a></li>
          <li><a href="EmpWfh.jsp">Work From Home</a></li>
        </ul>
      
    </ul>
  </div>
</nav>

<%

Connection con;

Statement st;

ResultSet rs;

ResultSetMetaData rmd;

String id,Name,email,des;
float pl;




try{



Class.forName("com.mysql.jdbc.Driver");

con =DriverManager.getConnection("jdbc:mysql://LocalHost:3306/test","root","1234");

st=con.createStatement();



rs=st.executeQuery("select * from empvacation"); 
rmd=rs.getMetaData();

%>
<table class="table  table-bordered">
    <thead class="thead-inverse">
    <tr>
      <th>Employee ID</th>
      <th>Vacation From</th>
      <th>Resume On</th>
      <th>Total Days</th>
      <th>Balance</th>
    </tr>
    
  </thead>
   
<!--<tr>

<%

for(int i=1;i<=rmd.getColumnCount();i++)
{

%>

<td><b>
        <%= rmd.getColumnName(i)%>
    </b></td><%}%>

</tr>-->

<%
    while(rs.next()){
%>

<tr>
    <%
        for(int i=1;i<=rmd.getColumnCount();i++)
        {
        %> 
        <td>
        <%= rs.getString(i) %>
        </td>
        <%} 
        %>

        </tr>
        <%}
%>

</table>

<%}

catch(Exception e)

{out.println(e.getMessage());}

%>

</body>

</html>
