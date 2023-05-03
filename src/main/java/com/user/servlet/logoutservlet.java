package com.user.servlet;

import java.io.IOException;

import com.entity.user;
import com.DAO.userDAOimp;
import com.DB.dbconnect;
//import com.user.servlet.*;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logoutservlet extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
Cookie userCookie= null;
		
		Cookie[] cookies=req.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("Ucookie")){
					userCookie = cookie;
					break;
				}
			}
		}
		if(userCookie != null) {
			userCookie.setMaxAge(0);
			resp.addCookie(userCookie);
			System.out.println("logoutserv just");
		}
	
		try {
			HttpSession session= req.getSession();
			session.removeAttribute("userobj");
			

//			 if (session == null) {
//				 System.out.println("This will never happen!");
//				 }
			 System.out.println("logout sess inval  "+session.getId());
//			 System.out.println(req.getSession(false));
			   
//			HttpSession session2= req.getSession();
			resp.sendRedirect("index.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		https://stackoverflow.com/questions/4194207/prevent-user-from-seeing-previously-visited-secured-page-after-logout
	}

	
}
