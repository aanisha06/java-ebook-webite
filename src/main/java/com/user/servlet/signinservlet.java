package com.user.servlet;

import java.io.IOException;
import com.entity.user;
import com.DAO.userDAOimp;
import com.DB.dbconnect;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signin")
public class signinservlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String userid =req.getParameter("userid");
			String password =req.getParameter("password");
			
//			user userO=new user();
//		    userO.setUserid(userid);
//		    userO.setPassword(password);
		    
		    userDAOimp udaO=new userDAOimp(dbconnect.getConn());
		    HttpSession session= req.getSession();
		    System.out.println("signinserv"+session.getId());
		    if("aani_sha".equals(userid) && "1234".equals(password)) {
		    	user userO=new user();
		    	session.setAttribute("userobj", userO);
		    	resp.sendRedirect("admin/home.jsp");
//		    	System.out.print(req.getRequestedSessionId());
		    }
		    else {
		    	user userO =udaO.UserAuth(userid, password);
		    	
		    	
		    	if (userO!=null) {
		    		userO.setFname(userO.getFname());
		    		Cookie userCookie= new Cookie("Ucookie",userid);
		    		System.out.println("signin  "+userCookie.getValue());
		    		userCookie.setMaxAge(20*60);
		    		resp.addCookie(userCookie); //session tracking right here!!
		    		session.setAttribute("userobj", userO);
					resp.sendRedirect("home.jsp");
					}
				else {
					session.setAttribute("loginfailedmsg", "username & password invalid");
					System.out.print("loginfailed");
					resp.sendRedirect("signin.jsp");
				     }
		    	
//		    	 resp.sendRedirect("home.jsp");
		    }
		    
		   
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
