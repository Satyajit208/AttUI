<%@page import="java.sql.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%@include file="Design/BootstrapLinks.jsp"  %>

<title>Records</title>

</head>

<body>
    <%@include file="Design/navigation.jsp"  %>

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



rs=st.executeQuery("select * from empwfh"); 
rmd=rs.getMetaData();

%>
<table class="table  table-bordered">
    <thead class="thead-inverse">
    <tr>
      <th>Employee ID</th>
      <th>Work From Home Date</th>
      <th>Hours</th>
      <th>Total Hours</th>
      
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/bootstrap-datepicker.min.js"></script>
        <script src="./js/main.js"></script>
</body>

</html>
