<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="error" value="${error}" scope="request" />


<!DOCTYPE>
<html>
    <head>
        <title>Vacation Form</title>
         <%@include file="/Design/BootstrapLinks.jsp"  %>
        
    </head>
    <body>
        <%@include file="/Design/navigation.jsp"  %>
        <jsp:include page="FetchData" flush="true" />
        
        <c:set var="emps" value="${Information}"/>
        
        <div class="container">
            <h2>Vacation Form</h2>
            
            <c:if test="${not empty error}">
                <span id="form-error" style="display: none;">
                    <c:out value="${error}"/>
                </span>
                
               <c:set var="error" value="" />
            </c:if>
            
            
            <form id="VacEmpForm" action="VacEmp" method="post" class="form-horizontal">
               <div class="form-group">
                    <label for="empid" class="col-xs-3 control-label">Employee Id</label>
                    <div class="col-xs-5">
                        <input type="text" name="empid" placeholder="Enter id" class="form-control" required >
                    </div>
                </div>
                <div class="form-group">
                    <label for="empname" class="col-xs-3 control-label">Employee Name</label>
                    <div class="col-xs-5">
                       <select class="form-control" name="empname" autofocus="true" placeholder="Enter name" onchange="setEmpId(this)" required>
                            <option value="">Select Employee Name</option>
                            
                            <c:forEach items="${emps}" var="emp">
                                <option data-id="${emp.empid}" value="${emp.empname}">${emp.empname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="lblFromDate" class="col-xs-3 control-label">Holiday From</label>
                    <div class="col-xs-5">
                        <div class="input-group input-append date datepicker" id="toDatePicker">
                            <input type="text" class="form-control" id="dtTo" name="hf" required>
                            <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="lblToDate" class="col-xs-3 control-label">Resume On</label>
                    <div class="col-xs-5">
                        <div class="input-group input-append date datepicker" id="fromDatePicker">
                            <input type="text" class="form-control" id="dtFrom" name="ht" required>
                            <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                    </div>
                </div>
                   <div class="form-group">
                    <div class="col-xs-5 control-label">
                        <input type=submit class="btn btn-lg  btn-default " name="Enter" value="Enter" >
                    </div>
                </div>
            </form>
            <%@include file="/Design/dispmodal.jsp"  %> 
        </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/bootstrap-datepicker.min.js"></script>
        <!--<script src="js/bootstrap-datepicker.min.js"></script>-->
        <script src="js/main.js"></script>
        
        <script type="text/javascript">
            $(document).ready(function() {
               /*var formResult = $('#form-result');
               formResult.hide();
               
               
               $('#VacEmpForm').submit(function(ev) {
                  ev.preventDefault();
                  var $form = $( this );
                  var data = {};
                  
                  data.empid = $form.find("input[name='empid']").val();
                  data.empname = $form.find("input[name='empname']").val();
                  data.hf = $form.find("input[name='hf']").val();
                  data.ht = $form.find("input[name='ht']").val();
                  
                  
                  $.post('/AttUI/VacEmp', data, function(response) {
                    console.log('Form submiited..' + response.message);
                    if(response === null || response.message === null) {
                        $form[0].submit();
                    } else {
                        formResult.text(response.message);
                        formResult.show();
                        $form[0].reset();
                        $('#myModal').modal('show');
                    }
                    }, 'json');
                });*/
        
                    
                var formResult = $('#form-result');
                formResult.text($('#form-error').text());
                if(formResult.text().length > 1) {
                    $('#myModal').modal('show');
                }
                
                $('#myModal').on('hidden.bs.modal', function() {
                   $('#form-error').text(''); 
                });
                        
            });
            var setEmpId = function (elm){
                //console.log("Hello" + elm.value);
                var optVal = $(elm).find(':selected').attr('data-id')
                if(elm.value !== null) {
                    $("input[name='empid']").val(optVal);
                } else {
                    $("input[name='empid']").val();
                }
           }; 
        </script>
        
       
    </body>
</html>