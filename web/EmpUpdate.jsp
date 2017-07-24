

<html>
    <head>
        <title>Update Employee</title>
        <%@include file="/Design/BootstrapLinks.jsp"  %>
        
    </head>
    <body>
        <%@include file="/Design/navigation.jsp"  %>
        <%@include file="/Design/dispmodal.jsp"  %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:set var="error" value="${error}" scope="request" />

        <div class="container">
            <h2>Update Form</h2>
             <c:if test="${not empty error}">
                <span id="form-error" style="display:none;">
                    <c:out value="${error}"/>
                </span>
                
               <c:set var="error" value="" />
            </c:if>
            
            <form action="UpdateEmp" method="post" class="form-horizontal"  data-toggle="validator" role="form">
                <div class="form-group">
                    <label for="empid" class="col-xs-3 control-label">Employee Id</label>
                    <div class="col-xs-5">
                        <input type="text" name="empid" placeholder="Enter id" class="form-control" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="empname" class="col-xs-3 control-label">Employee Name</label>
                    <div class="col-xs-5">
                        <input type="text" name="empname" placeholder="Enter name" class="form-control" required>
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-xs-5 control-label">
                        <input type=submit class="btn btn-lg  btn-default" name="Enter" value="Enter"   >
                    </div>
                </div>
                

            </form>
        </div>
        
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/bootstrap-datepicker.min.js"></script>
        <script src="./js/main.js"></script>
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