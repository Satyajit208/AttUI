<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
  <title>Main Menu</title>
   <%@include file="/Design/BootstrapLinks.jsp"  %>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%@include file="Design/navigation.jsp"  %>
  
</head>
<body>
<center>
        <h2>${message}</h2>
    </center>
        <%@include file="/Design/dispmodal.jsp"  %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:set var="error" value="${error}" scope="request" />
        <c:if test="${not empty error}">
                <span id="form-error" style="display:none;">
                    <c:out value="${error}"/>
                </span>
                
               <c:set var="error" value="" />
            </c:if>
<div class="container">
  <h3>Inverted Navbar</h3>
  <p>An inverted navbar is black instead of gray.</p>
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