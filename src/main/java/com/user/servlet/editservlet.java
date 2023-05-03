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

@WebServlet("/writing_edited")
public class editservlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
		
			int titleid=Integer.parseInt(req.getParameter("titleId")); 
			String title= req.getParameter("title");
			String chapter= req.getParameter("chapter");
			String content =req.getParameter("content");
			String tagone =req.getParameter("genre");
			String description=req.getParameter("description");
			
			
			story_title titleO= new story_title();
			titleO.setTitleId(titleid);
			titleO.setTitle(title);
			titleO.setChapter(chapter);
			titleO.setContent(content);
			titleO.setTagOne(tagone);
			titleO.setDescription(description);
			
			WriteAndReadImp writeO= new WriteAndReadImp(dbconnect.getConn());
			boolean done3= writeO.update_content(titleO);
			
			HttpSession session= req.getSession();
			
			
			if(done3) {
				session.setAttribute("successmsg", "saved successfully...");
				resp.sendRedirect("mystory.jsp");
			}
			else {
				session.setAttribute("failedmsg", "error occured while saving.......try again later");
				resp.sendRedirect("mystory.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
