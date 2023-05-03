package com.user.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.WriteAndReadImp;
import com.DB.dbconnect;
import com.entity.story_title;

@WebServlet("/uploaded")
public class uploadservlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			int titleid=Integer.parseInt(req.getParameter("titleId")); 
			
			story_title titleO= new story_title();

			titleO.setTitleId(titleid);
			titleO.setStatus("upload");
			System.out.println("heloooooooooooooooooooooooooooooooooooooooooooo");
			WriteAndReadImp writeO= new WriteAndReadImp(dbconnect.getConn());
			boolean done4= writeO.update_status(titleO);
			
			HttpSession session= req.getSession();
			
			
			if(done4) {
				session.setAttribute("successmsg", "Uploaded successfully...");
				resp.sendRedirect("mystory.jsp");
			}
			else {
				session.setAttribute("failedmsg", "error occured while uploading.......try again later");
				resp.sendRedirect("mystory.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
