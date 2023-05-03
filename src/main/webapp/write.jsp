<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WRITE PAGE</title>
<style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/bbbootstrap/libraries@main/choices.min.css">
 <%@include file="allComp/style.css" %>
 <%@ include file="allComp/write.css" %>
</style>
</head>
<body>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/bbbootstrap/libraries@main/choices.min.css">

<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
		integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />
<%
String cookiename=null;
Cookie[] cookies= request.getCookies();
if(cookies != null){
	System.out.println("write  "+session.getId());
for(Cookie cookie : cookies){
	if(cookie.getName().equals("Ucookie")) cookiename = cookie.getValue();
}
System.out.println("write1"+cookiename);
}
if(cookiename == null){
	response.sendRedirect("signin.jsp");
}
%>
<script src="tags.js"></script>

<div class="container-fluid">
	<div class="col-3">
		<a href="#" class="ebook">ONCE UPON A TIME... </a>
		<c:if test="${not empty userobj }">
		   <div class="dropdown">
			<button id="profile-dropbtn" class="dropbtn" style="right:100px;"><i class="fas fa-user-circle fa-lg"></i> ${userobj.fname }</button>
			<div id="dropdown-content" class="dropdown-content">
				<a href="logout"><i class="fas fa-sign-in-alt"></i> Logout</a><a href="#">profile</a>
			</div>
		   
		</c:if>
<!-- 		<div class="dropdown"> -->
<!-- 			<button id="profile-dropbtn" class="dropbtn"><i class="fas fa-user-circle fa-lg"></i> LOGOUT</button> -->
<!-- 		</div> -->
	</div>
	<!-- login/sign up/info -->
</div>



<div class="navbar navbar-list">

		<a class="nav-link" href="home.jsp">HOME</a>
		<a class="nav-link" href="mystory.jsp">MY STORY</a>
			 
  </div>

<!-- <div class="please"> -->
<div class="biggy">

<!-- <div class="add-tags"> -->
<!-- </div> -->
<!-- </div> -->
<!-- <div class="righty"> -->
<!-- <div class="uploaded-chapter"> -->

<!-- <div class="containerr"> -->
<!--  <div class="tag-container"> -->
<!--  <input /> -->
<!--  </div> -->
<!--  </div> -->
<!-- </div> -->
<!-- </div><div class="lefty"> -->

<div class="write container" >
<c:if test="${not empty successmsg}">
        <p class="text-success">${successmsg}</p>
        <c:remove var="successmsg" scope="session"/>
        </c:if>
        
        <c:if test="${not empty failedmsg}">
        <p class="text-failed">${failedmsg}</p>
        <c:remove var="failedmsg" scope="session"/>
        </c:if>
<form  method="post" enctype="multipart/form-data">

      <div class="write title-name" >
         <input class="title" type="text" name="title" placeholder="enter title" required> <br>
      </div><br> <br>
      <div class="photo-1">
         <label class="upload-photo" style="color:#faca38">upload coverphoto</label>
         <input class="photo" type="file" name="coverphoto" placeholder="select coverphoto" required>
          
		<select id="inputState" name="genre" class="form-control">
		  <option selected>--select--</option>
		  <option value="Sci-fi">Sci-fi</option>
		  <option value="Poetry">Poetry</option>
		  <option value="True Crimes">True Crimes</option>
		  <option value="Folklore">Folklore</option>
	      </select>
	      <label class="genre-lab" for="inputState">Genre</label>
         </div>
      <div class="write chapter-name" >
         <input class="chapter" type="text" name="chapter" placeholder="enter chapter name or number">
      </div><br> <br>

      <div class="write content-area" >
         <textarea class="content" name="content" placeholder="start your story here...."></textarea>
      </div>
      
     <div class="write description-area" >
         <textarea class="description" name="description" placeholder="write description.." required></textarea>
      </div>
      <div class="butt-ons">
      <button class="btn-save" type="submit" formaction="writing_saved" value="writing_save">save</button>
      <button class="btn-upload" formaction="uploaded" value="uploaded">upload</button>
      </div>
 </form>    
</div>

</div>
<!-- </div> -->
</body>
</html>
<!-- DC66C262999590095A862C6F4DDEEF59 -->