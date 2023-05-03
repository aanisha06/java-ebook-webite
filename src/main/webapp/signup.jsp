<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGN-UP</title>
<style>
<%@include file="/allComp/signup_in.css" %>
<%@include file="/allComp/style.css" %>
</style>
</head>
<body style="background:black">
<nav class="navbar navbar-2">

<div class="navbar navbar-list">

		<a class="nav-link" href="index.jsp">HOME</a>
			 <select onchange="location=this.value" name="GENRE">
            <option  value="" disabled selected hidden>GENRE</option>
			<option  value="G_scifi.jsp">science fiction</option>
			<option value="G_poetry.jsp">poetry</option>
			<option value="G_tcrimes.jsp">true crimes</option>
		</select> 
		<a class="nav-link" href="G_scifi.jsp">WRITE</a>
		</div>
 <script> 
 document.getElementByValue("").onclick=function(){
	genre(); 
 } 
<</script> 
</nav>

<div class="form_wrapper">
  <div class="form_container">
    <div class="title_container">
      <h2> Registration Form</h2>
    </div>
    
    <c:if test="${not empty successmsg}">
        <p class="text-success">${successmsg}</p>
        <c:remove var="successmsg" scope="session"/>
        </c:if>
        
         <c:if test="${not empty failedmsg}">
        <p class="text-failed">${failedmsg}</p>
        <c:remove var="failedmsg" scope="session"/>
        </c:if>
        
        <c:if test="${not empty pwdmsg}">
        <p class="text-failed">${pwdmsg}</p>
        <c:remove var="pwdmsg" scope="session"/>
        </c:if>
        
      
        
    
    <div class="row clearfix">
      <div class="">
        <form action="signup" method="post">
          <div class="input_field">
            <input type="text" name="userid" placeholder="username" required />
          </div>
          <div class="input_field"> 
            <input type="password" name="password" placeholder="Password" required />
          </div>
<!--           <div class="input_field"> -->
<!--             <input type="password" name="password" placeholder="Re-type Password" required /> -->
<!--           </div> -->
          <div class="row clearfix">
            <div class="col_half">
              <div class="input_field"> 
                <input type="text" name="fname" placeholder="First Name" required/>
              </div>
            </div>
            <div class="col_half">
              <div class="input_field">
                <input type="text" name="lname" placeholder="Last Name" />
              </div>
            </div>
          </div>
            
<!--             <div class="input_field checkbox_option"> -->
<!--             	<input type="checkbox" id="cb2"> -->
<!--     			<label for="cb2">I want to receive the email</label> -->
<!--             </div> -->
          <input class="button" type="submit" value="Register" />
           <div class="reglink" style="position:absolute;bottom:35px;">
          <a class="reglink" href="signin.jsp" style="font-size:12px" >signin</a>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>

</body>
</html>