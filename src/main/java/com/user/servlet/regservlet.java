package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;

import com.DAO.userDAOimp;
import com.DB.dbconnect;
import com.entity.user;

//why import this package?
@WebServlet("/signup") //why?

public class regservlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String userid=req.getParameter("userid");
			String password=req.getParameter("password");
			String fname=req.getParameter("fname");
			String lname=req.getParameter("lname");
			
			System.out.println(userid+" "+password+" "+fname+" "+lname);
			//left
		    user userO=new user();
		    userO.setUserid(userid);
		    userO.setPassword(password);
		    userO.setFname(fname);
		    userO.setLname(lname);
		   
		  
		   HttpSession session =req.getSession();
		   
		   System.out.println("regserv"+session.getId());
		   if (password.length()>=8) {
			   
			   userDAOimp udaO=new userDAOimp(dbconnect.getConn());
			   boolean done=udaO.userRegistration(userO);//right
		   
			   
		   if(done) {
	           
			   System.out.println("finally");
			   session.setAttribute("successmsg", "Registration Successful");
			   resp.sendRedirect("signup.jsp");
		   }
		   else {
			   System.out.println("server problem");
			   session.setAttribute("failedmsg", "username already taken");
			   resp.sendRedirect("signup.jsp");
		   }
//		   https://copyprogramming.com/howto/sign-up-a-new-user-but-return-http-error-if-username-or-email-already-exists
		   }
		   else {
			   session.setAttribute("pwdmsg", "password length should be greater than 8");
			   resp.sendRedirect("signup.jsp");
		   }
		}
		   catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
//	
//	public void FindByUsername(){
//		
//		userRepository.save(userO);
//		 UserO dbUser = userRepository.findByUserid(userO.getUserid());
//	}

}
