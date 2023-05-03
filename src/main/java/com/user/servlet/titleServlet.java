package com.user.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;

import com.DAO.WriteAndRead;
import com.DAO.WriteAndReadImp;
import com.DAO.userDAOimp;
import com.DB.dbconnect;
import com.entity.story_title;
import com.entity.user;
import com.mysql.cj.jdbc.Blob;

@WebServlet("/writing_saved")
@MultipartConfig
public class titleServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String cookiename=null;
		try {
		Cookie[] cookies= req.getCookies();
		if(cookies != null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("Ucookie")) cookiename = cookie.getValue();
		}
		System.out.println("write3 "+cookiename);
		}
		
		String title= req.getParameter("title");
		String chapter= req.getParameter("chapter");
		String content =req.getParameter("content");
		String tagone =req.getParameter("genre");
		Part part = req.getPart("coverphoto");
		String filename= part.getSubmittedFileName();
		String description= req.getParameter("description");
		
		System.out.println(title+" "+chapter);
		
		story_title titleO =new story_title();
		
		titleO.setTitle(title);
		titleO.setChapter(chapter);
		titleO.setContent(content);
		titleO.setTagOne(tagone);
		titleO.setPhotoname(filename);
		titleO.setDescription(description);
		titleO.setStatus("save");
		
		HttpSession session =req.getSession();
		user userO=new user();
    	session.setAttribute("userobj", userO);
    	session.setAttribute("titleobj", titleO);
//    	story_title titleO= new story_title();    	 
		   WriteAndReadImp writeO=new WriteAndReadImp(dbconnect.getConn());
//		   writeO.editstory(titleid);
		   String userid= cookiename;
		   
		   
		   if(!title .equals("")) {
			   boolean done= writeO.save_content(userid, titleO);
					   
			   if(done) {
				   session.setAttribute("successmsg", "Saved Successful");
				   resp.sendRedirect("write.jsp");
		        System.out.println("finally title saved");
		        }
		 }
		   else {
			   session.setAttribute("failedmsg", "error occured while saving ..........try again later");
			   resp.sendRedirect("write.jsp");
			   System.out.println("error occured while saving ..........try again later");
		}
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
