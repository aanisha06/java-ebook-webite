<%@page import="java.util.List"%>
<%@page import="com.DB.dbconnect"%>
<%@page import="com.DAO.WriteAndReadImp"%>
<%@page import="com.entity.story_title"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<style>
<%@include file="allComp/style.css"%>
</style>
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
		
		<c:if test="${empty userobj }">
		<div class="dropdown">
			<button id="profile-dropbtn" class="dropbtn"><i class="fas fa-user-circle fa-lg"></i></button>
			<div id="dropdown-content" class="dropdown-content">
				<a href="signin.jsp"><i class="fas fa-sign-in-alt"></i> Sign-In</a><a href="signup.jsp">Sign-Up</a> <a href="#">add description</a>
			</div>
		</div>
		</c:if>
	</div>
	<!-- login/sign up/info -->
</div>
<script>
document.getElementById("profile-dropbtn").onclick=function(){
	dropdown();
}
function dropdown(){
	document.getElementById("dropdown-content").classList.toggle("show");
}
</script>

<nav class="navbar navbar-2">

<div class="navbar navbar-list">

		<a class="nav-link" href="index.jsp">HOME</a>
			 <select onchange="location=this.value" name="GENRE">
            <option  value="" disabled selected hidden>GENRE</option>
			<option  value="G_scifi.jsp">science fiction</option>
			<option value="G_poetry.jsp">poetry</option>
			<option value="G_tcrimes.jsp">true crimes</option>
			<option value="G_Folklore.jsp">folklore</option>
		</select> 
		<a class="nav-link" href="write.jsp">WRITE</a>
		<c:if test="${not empty userobj }">
		 <a class="nav-link" href="mystory.jsp">MY STORY</a> 
		</c:if>
		<a class="nav-link" href="addtolib.jsp">LIBRARY</a>
<div style="left:520px;" class="form-search">
		<form style="left:520px;"class="form-serach">
      <input  class="form-search " type="search" placeholder="Search" >
      <button class="btn btn-submit" type="submit">Search</button>
    </form></div>
  </div>
</nav>


    <h2 class="story story-row-1">Enjoy True Crimes!!</h2>
<!--     <button class="pre-btn"><img src="img/arrow.png" alt=""></button> -->
<!-- <button class="nxt-btn"><img src="img/arrow.png" alt=""></button> -->
    <div class="story-container">
    <%
    WriteAndReadImp writeO= new WriteAndReadImp(dbconnect.getConn());
    List<story_title> list= writeO.displayFolklore();
    
    for (story_title titleO : list){
    %>
     <div style="justify-content: center;" class="story-ebook">
        <div class="story-image">
            <a href="desc.jsp?titleid=<%=titleO.getTitleId()%>"><img src="pictures/<%=titleO.getPhotoname() %>" class="coverpage" alt=""></a>
            <button type="submit" class="card-btn">add to library</button>
        </div>
        <div   class="story-info">
            <p style="font-size:12px;margin-left:40px" class="story-title"><%=titleO.getTitle() %></p>
        </div>
    </div>
    <%
    }
    %>
           
</div>