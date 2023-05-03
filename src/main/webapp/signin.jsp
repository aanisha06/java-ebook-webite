<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head">
<meta charset="ISO-8859-1">
<title>SIGN-UP</title>
<style>
<%@include file="/allComp/signup_in.css" %>
<%@include file="/allComp/style.css" %>
</style>
</head>
<body style="background-color:black;">
<nav class="navbar navbar-2">

<div class="navbar navbar-list">

		<a class="nav-link" href="index.jsp">HOME</a>
			 
		</div>
 <script> 
 document.getElementByValue("").onclick=function(){
	genre(); 
 } 
</script> 
</nav>

<div class="form_wrapper">
  <div class="form_container">
    <div class="title_container">
      <h2> Login Form</h2>
    </div>
    
      <c:if test="${not empty loginfailedmsg}">
        <p class="text-failed">${loginfailedmsg}</p>
        <c:remove var="loginfailedmsg" scope="session"/>
        </c:if>

    <div class="row clearfix">
      <div class="">
        <form action="signin" method="post">
          <div class="input_field">
            <input type="text" name="userid" placeholder="username" required />
          </div>
          <div class="input_field"> 
            <input type="password" name="password" placeholder="Password" required />
          </div>
<!--           <div class="input_field"> -->
<!--             <input type="password" name="password" placeholder="Re-type Password" required /> -->
<!--           </div> -->
            
<!--             <div class="input_field checkbox_option"> -->
<!--             	<input type="checkbox" id="cb2"> -->
<!--     			<label for="cb2">I want to receive the email</label> -->
<!--             </div> -->
          <input class="button" type="submit" value="signin" />
          <div class="reglink" style="position:absolute;bottom:65px;">
          <a class="reglink" href="signup.jsp" style="font-size:12px;color:blue;text-decoration:underline;" >create an account?</a>
          </div>
          
        </form>
        
      </div>
    </div>
  </div>
</div>


</body>
</html>