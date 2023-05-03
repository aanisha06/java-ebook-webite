<%@page import="java.sql.Connection"%>
<%@page import="com.DB.dbconnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1.0">
<title>storytelling</title>
<style>
 <%@include file="allComp/style.css" %>
</style>
</head>
<body>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
		integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" href="/allComp/style.css" >
	<%@include file="allComp/navbar.jsp" %>
	<% Connection conn= dbconnect.getConn();
	out.println(conn);
	%>
<h1> justcoz</h1>
</body>
</html>