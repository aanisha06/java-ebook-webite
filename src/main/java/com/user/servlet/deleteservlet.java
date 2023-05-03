package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.WriteAndReadImp;
import com.DB.dbconnect;

@WebServlet("/delete")
public class deleteservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int titleid= Integer.parseInt(req.getParameter("titleid"));
			
			WriteAndReadImp writeO= new WriteAndReadImp(dbconnect.getConn());
			boolean done4= writeO.delete(titleid);
			
			HttpSession session = req.getSession();
			
			if(done4) {
				session.setAttribute("successmsg", "deleted successfully...");
				resp.sendRedirect("mystory.jsp");
			}
			else {
				session.setAttribute("failedsmsg", "error occured while deleting .........try again later");
				resp.sendRedirect("mystory.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
