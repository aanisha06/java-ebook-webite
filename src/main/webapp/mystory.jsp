<%@page import="com.entity.user"%>
<%@page import="com.DAO.WriteAndReadImp"%>
<%@page import="com.entity.story_title"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.WriteAndReadImp"%>
<%@page import="com.DB.dbconnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Story</title>
<style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/bbbootstrap/libraries@main/choices.min.css">
 <%@include file="allComp/style.css" %>
 <%@ include file="allComp/write.css" %>
 <%@include file="allComp/mystory.css" %>
</style>
</head>
<body>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/bbbootstrap/libraries@main/choices.min.css">

<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
		integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />


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
<!-- 		<a class="nav-link" href="mystory.jsp">MY STORY</a> -->
			 
  </div>

<c:if test="${not empty successmsg}">
        <p class="text-success">${successmsg}</p>
        <c:remove var="successmsg" scope="session"/>
        </c:if>
        
        <c:if test="${not empty failedmsg}">
        <p class="text-failed">${failedmsg}</p>
        <c:remove var="failedmsg" scope="session"/>
        </c:if>
<table class="table-col">
		<thead class="table-col2">
			<tr class="table-row">
				<th scope="col">Story Id</th>
				<th scope="col">cover photo</th>
				<th scope="col">Title</th>
				<th scope="col">Genre</th>
				<th scope="col">chapter</th>
			</tr>
		</thead>
		<tbody>
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
			WriteAndReadImp writeO= new WriteAndReadImp(dbconnect.getConn());
			
			List<story_title> list = writeO.getstory(userid);
			for (story_title titleO: list) {
			%>
			<tr>
			    <td><%=titleO.getTitleId()%></td>
				<td><img src="pictures/<%=titleO.getPhotoname()%>"
					style="width: 50px; height: 50px;"></td>
					<td><%=titleO.getTitle()%></td>
					<td><%=titleO.getTagOne()%></td>
				<td><%=titleO.getChapter()%></td>
				<td><a href="upload?titleid=<%=titleO.getTitleId()%>"
					class="btn btn-sm btn-primary"><i
						class="fa-solid fa-pen-to-square"></i>Upload</a></td>
				<td><a href="edit.jsp?titleid=<%=titleO.getTitleId()%>"
					class="btn btn-sm btn-primary"><i
						class="fa-solid fa-pen-to-square"></i> Edit</a> <a
					href="delete?titleid=<%=titleO.getTitleId()%>"
					class="btn btn-sm btn-danger"><i class="fa-solid fa-trash-can"></i>
						Delete</a></td>

			</tr>
			<%
			} 
			%>

		</tbody>
	</table>
</body>

</body>
</html>
