<HTML>
    <%@include file="../Design/FileUpload.jsp" %>
    <%@include file="BootstrapLinks.jsp" %>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/bootstrap-datepicker.min.js"></script>
        <!--<script src="./js/main.js"></script>-->
        <!--<script src="./js/r.js"></script>-->
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <!--<script src="./js/main1.js"></script>-->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="MainMenu.jsp">ObjectEdge Attendance</a>
    </div >
    <ul class="nav navbar-nav">
      <li ><a href="MainMenu.jsp" >Home</a></li>
      <li ><a href="EmpAdd.jsp">Add Employees</a></li>
      <li ><a href="EmpUpdate.jsp">Update Employee</a></li>
      <li ><a href="FormVacation.jsp">Going on Vacation</a></li>
      <li><a href="wfh.jsp">Working From Home</a></li>
      <!--<li><a href="fileupload.jsp">Upload Attendance</a></li>-->
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Know Your Details
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="EmpDet.jsp">Employee Details</a></li>
          <li><a href="EmpVac.jsp">Employee Vacations</a></li>
          <li><a href="EmpWfh.jsp">Work From Home</a></li>
        </ul></ul>
          <ul class="nav navbar-nav navbar-right">
      <li><button   id="myBtn" style="background-color:transparent; 
                   color: white; padding: 12px 28px;text-align: 
                   center;"><span class="glyphicon glyphicon-file"></span>Upload Attendance</button></li>
          
    </ul>
  </div>
        </nav>
        <script type="text/javascript">
$(document).ready(function() {
    $("#myBtn").click(function(){
        $("#fileModal").modal();
    });
});
</script>
        
</HTML>