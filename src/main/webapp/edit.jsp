<%@page import="com.entity.user"%>
<%@page import="com.DAO.WriteAndReadImp"%>
<%@page import="com.entity.story_title"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.WriteAndReadImp"%>
<%@page import="com.DB.dbconnect"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<%--  <%@ include file="allComp/signup_in.css" %> --%>
</style>
</head>
<body>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/bbbootstrap/libraries@main/choices.min.css">

<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
		integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />

<script src="tags.js"></script>

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
			String userid= cookiename;
			
			%>
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
</div>



<div class="navbar navbar-list">

		<a class="nav-link" href="home.jsp">HOME</a>
		<a class="nav-link" href="mystory.jsp">MY STORY</a>
			 
  </div>

<div class="write container" >
        
<%
int titleid=Integer.parseInt(request.getParameter("titleid"));
WriteAndReadImp writeO= new WriteAndReadImp(dbconnect.getConn());
story_title titleO= writeO.editstory(titleid);

%>		

<form  method="post">
<input class="titleid" type="hidden" style="height:20px;width:20px;margin-right:320px;" name="titleId" value="<%=titleO.getTitleId()%>" >
      
      <div class="write title-name" >
      
         <input class="title" type="text" name="title" value="<%=titleO.getTitle()%>" >
      </div><br> <br>
       <div class="photo-1">
<!--          <label class="upload-photo" style="color:#faca38">upload coverphoto</label> -->
<!--          <input class="photo" type="file" name="coverphoto" placeholder="select coverphoto" required> -->
          
		
<!-- 								<label for="inputState">Genre</label>  -->
								<select
									id="inputState" name="genre" class="form-control">
									<%
									if ("Sci-fi".equals(titleO.getTagOne())) {
									%>
									<option value="Sci-fi">Sci-fi</option>
									<option value="Poetry">Poetry</option>
									<option value="True Crimes">True Crimes</option>
									<option value="Folklore">Folklore</option>
									<%}
									if ("Poetry".equals(titleO.getTagOne())) {
									%>
									<option value="Poetry">Poetry</option>
									<option value="Sci-fi">Sci-fi</option>
									<option value="True Crimes">True Crimes</option>
									<option value="Folklore">Folklore</option>
									<%}
									if ("True Crimes".equals(titleO.getTagOne())) {
									%>
									<option value="True Crimes">True Crimes</option>
									<option value="Sci-fi">Sci-fi</option>
									<option value="Poetry">Poetry</option>
									<option value="Folklore">Folklore</option>
									<%
									} else {
									%>
									<option value="Folklore">Folklore</option>
								    <option value="Sci-fi">Sci-fi</option>
									<option value="Poetry">Poetry</option>
									<option value="True Crimes">True Crimes</option>
									<%
									}
									%>
								</select>
							
         </div>
      <div class="write chapter-name" >
         <input class="chapter" type="text" name="chapter" value="<%=titleO.getChapter()%>">
      </div><br> <br>
      
      <div class="write content-area" >
      <% 
	String cont=titleO.getContent(); 
%> 
<%--      <input class="content-class" type="text" name="content" value="<%=titleO.getContent()%>"> --%>
         <textarea class="content" name="content" id="story-content"><%=cont %></textarea>
      </div>
      <label style="position:absolute;margin-top:100px;margin-left:-120px;">Description</label>
       <div class="write description-area" >

         <textarea class="description" name="description" placeholder="write description.." ><%=titleO.getDescription() %></textarea>
      </div>
      <div class="butt-ons">
      <button class="btn-save" type="submit"  formaction="writing_edited" value="writing_save">save</button>
      <button class="btn-upload"  formaction="uploaded" value="">upload</button>
      </div>
      
      
 </form>    
</div>

</div>
</body>
</html>
