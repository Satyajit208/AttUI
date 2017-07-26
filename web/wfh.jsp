<!DOCTYPE>


        <html>
    <head>
        <title>Update Employee</title>
         <%@include file="/Design/BootstrapLinks.jsp"  %>
       
    </head>
    <body>
        <%@include file="/Design/navigation.jsp"  %>
        <%@include file="/Design/dispmodal.jsp" %>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:set var="error" value="${error}" scope="request" />
        <jsp:include page="FetchData" flush="true" />
        <c:set var="emps" value="${Information}"/>
        
        <div class="container">
            <h2>Work From Home Form</h2>
            <c:if test="${not empty error}">
                <span id="form-error" style="display: none;">
                    <c:out value="${error}"/>
                </span>
                
               <c:set var="error" value="" />
            </c:if>
            <form action="Empwfh" method="post" class="form-horizontal">
               <div class="form-group">
                    <label for="empid" class="col-xs-3 control-label">Employee Id</label>
                    <div class="col-xs-5">
                        <input type="text" name="empid" placeholder="Enter id" class="form-control" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="empname" class="col-xs-3 control-label">Employee Name</label>
                    <div class="col-xs-5">
                         <select class="form-control" name="empname" placeholder="Enter name" onchange="setEmpId(this)" required>
                            <option value="">Select Employee Name</option>
                            
                            <c:forEach items="${emps}" var="emp">
                                <option value="${emp.empid}">${emp.empname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="lblFromDate" class="col-xs-3 control-label">Work From Home Date</label>
                    <div class="col-xs-5">
                        <div class="input-group input-append date datepicker" id="toDatePicker">
                            <input type="text" placeholder="Enter Date" class="form-control" id="dtTo" name="wfhd" required>
                            <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="empid" class="col-xs-3 control-label">Hours Worked</label>
                    <div class="col-xs-5">
                        <input type="number" name="wfhh" placeholder="Enter working hours" class="form-control" required>
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
        <script src="./js/main1.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                var formResult = $('#form-result');
                formResult.text($('#form-error').text());
                if(formResult.text().length > 1) {
                    $('#myModal').modal('show');
                }
                });
                var setEmpId = function (elm){
                //console.log("Hello" + elm.value);
                if(elm.value !== null) {
                    $("input[name='empid']").val(elm.value);
                } else {
                    $("input[name='empid']").val();
                }
           };
            
                
        </script>
    </body>
</html>