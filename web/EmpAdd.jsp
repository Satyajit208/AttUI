<!DOCTYPE>

<html>
    <head>
        <title>Add Employee</title>
        <%@include file="/Design/BootstrapLinks.jsp"  %>

    </head>
    <body>


        <%@include file="/Design/navigation.jsp" %>
         <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:set var="error" value="${error}" scope="request" />
        <div class="container">
             <c:if test="${not empty error}">
                <span id="form-error" style="display: none;">
                    <c:out value="${error}"/>
                </span>
                
               <c:set var="error" value="" />
            </c:if>
            <h2>Add Employee Form</h2>

            <form id="addEmpForm"  action="AddEmp" method="post" class="form-horizontal" data-toggle="validator" role="form">
                <div class="form-group">
                    
                    <label for="empid" class="col-xs-3 control-label">Employee Id</label>
                    <div class="col-xs-5">
                        <input type="text" autofocus="true" name="empid" placeholder="Enter id" class="form-control" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="empname" class="col-xs-3 control-label">Employee Name</label>
                    <div class="col-xs-5">
                        <input type="text" name="empname" placeholder="Enter name" class="form-control" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="empemail" class="col-xs-3 control-label">Employee Email</label>
                    <div class="col-xs-5">
                        <input type="email" name="empemail" placeholder="Enter Email" class="form-control" data-error="Bruh, that email address is invalid" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="empdes" class="col-xs-3 control-label">Employee Designation</label>
                    <div class="col-xs-5">
                        <input type="text" name="empdes" placeholder="Enter designation" class="form-control" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="emppl" class="col-xs-3 control-label">Employee PaidLeaves</label>
                    <div class="col-xs-5">
                        <input type="number" name="emppl" placeholder="Enter paid-leaves" class="form-control" value="0">
                    </div>
                </div>                                                       
                <div class="form-group">
                
                    <label for="empdoj" class="col-xs-3 control-label">Date Of Joining</label>
                    <div class="col-xs-5">
                        <div class="input-group input-append date datepicker" id="toDatePicker">
                            <input type="text" class="form-control" id="dtTo" name="empdoj" >
                            <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="empaddr" class="col-xs-3 control-label">Employee Address</label>
                    <div class="col-xs-5">
                        <input type="text" maxlength="78" name="empaddr" placeholder="Enter Address" class="form-control" >
                    </div>
                </div>
                <div class="form-group">
                    <!--<span class="form-group-addon"></span>-->

                    <label for="empcontact" class="col-xs-3 control-label">Employee Contact No</label>
                    <div class="col-xs-5">
<!--                        <input type="text" class="form-control bfh-phone"
                               data-format="+91 dddddddddd">-->


                        <input type="tel"  maxlength="10"  pattern="[0-9]{10}" name="empcontact" 
                               placeholder="Enter Contact number" class="form-control bfh-phone" 
                                data-format="+91 (ddd)ddd-dddd">
                    </div>
                </div>
                             
                <div class="form-group">
                    <div class="col-xs-6 control-label">
                        <input type="submit" class="btn btn-lg btn-info btn-default" name="Enter" value="Enter"
                               style="">
                    </div>
                    
                </div>
                
            </form>
            
            <%@include file="/Design/dispmodal.jsp" %>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/bootstrap-datepicker.min.js"></script>
        <script src="./js/main2.js"></script>
        <script src="js/countrySelect.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                var formResult = $('#form-result');
                formResult.text($('#form-error').text());
                if(formResult.text().length > 1) {
                    $('#myModal').modal('show');
                }
                });
              
        </script>
        
    </body>
</html>