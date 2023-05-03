<!-- https://www.winterwind.com/tutorials/css/3 -->
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
 <%@ include file="allComp/flipS.css" %>
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
<input class="titleid" type="hidden" style="height:20px;width:20px;margin-right:320px;" name="titleId" value="<%=titleO.getTitleId()%>" >
 <div class="write title-name" >
         <label style="font-size:30px; class="title" ><%=titleO.getTitle()%></label>
      </div><br> <br>
 
<!--   <div class="write chapter-name" > -->
<%--          <label style="font-size:30px; class="chapter"><%=titleO.getChapter()%></label> --%>
<!--       </div><br> <br> -->
      
       <div class="write content-area" >
      <% 
	String cont=titleO.getContent(); 
%> 
<%--      <input class="content-class" type="text" name="content" value="<%=titleO.getContent()%>"> --%>
<%--          <textarea class="content" name="content" id="story-content"><%=cont %></textarea> --%>
<p class="content" id="story-content" style="font-size:24px;"><%=cont %></p>
      </div>
</div>


</body>
</html>
