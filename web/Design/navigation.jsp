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
                <a class="navbar-brand"  style="padding: 0;">
                    <img src="Design\Object Edge.jpg"  style="width:130px;height:50px;">
                </a>
                <!--<a class="navbar-brand" >ObjectEdge Attendance</a>-->
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
                    </ul>
            </ul>
            <li class="dropdown nav navbar-right ">
                <a class="dropdown-toggle navbar-brand" data-toggle="dropdown" href="#">UTILITIES
                    <span class="caret"></span></a>  
               
                    <ul class="dropdown-menu">
                        <li><a href="#" id="myBtn">Upload Attendance</a></li>
                        <li><a href="UpdatePL">Update Paid-Leaves</a></li>
                        
                    </ul>







<!--                    <li><button   id="myBtn" style="background-color:transparent; 
                                  color: white; padding: 12px 28px;text-align: 
                                  center;"><span class="glyphicon glyphicon-file"></span>Upload Attendance</button></li>-->

                
<!--                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <form id="updatePl" action="updatePl" method="post" role="form">
                            <button   id="uploadPL" style="background-color:transparent; 
                                      color: white; padding: 12px 28px;text-align: 
                                      center; white-space: normal; word-wrap: break-word ; "<span class="glyphicon glyphicon-edit"></span>Update Monthly Paid Leaves</button></li>
                    </form>

                </ul>-->
        </div>
    </nav>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#myBtn").click(function () {
                $("#fileModal").modal();
            });
        });
    </script>

</HTML>