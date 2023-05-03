package com.DAO;

import com.user.servlet.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.WriteAndRead;
import com.entity.story_title;
import com.entity.user;

public class WriteAndReadImp implements WriteAndRead {
	
	private Connection conn;

	public WriteAndReadImp(Connection conn) {
		super();
		this.conn = conn;
	}
//	int idd=0;
	@Override
	public boolean save_content(String userid,story_title titleO) {
         boolean done=false;
         user userO=null;
		int idd=0;
		try {	
         String sql="select id from user where userid=?";
			PreparedStatement pStatement= conn.prepareStatement(sql);
			
			pStatement.setString(1, userid);
			
			ResultSet rSet= pStatement.executeQuery();
			
			while(rSet.next()) {
			userO= new user();
			userO.setId(rSet.getInt(1));
			idd=rSet.getInt(1);
			}
			System.out.println("outside  "+idd);
			titleO.setFK_id(idd);
			
			PreparedStatement pStatement2= conn.prepareStatement("insert into story_title(FK_id,title,chapter,content,tagOne,coverphoto,description,status) values(?,?,?,?,?,?,?,?)");
			pStatement2.setInt(1,titleO.getFK_id());
			pStatement2.setString(2,titleO.getTitle());
			pStatement2.setString(3,titleO.getChapter());
			pStatement2.setString(4,titleO.getContent());
			pStatement2.setString(5,titleO.getTagOne());
			pStatement2.setString(6,titleO.getPhotoname());
			pStatement2.setString(7, titleO.getDescription());
			pStatement2.setString(8, titleO.getStatus());
			
			
			int i=pStatement2.executeUpdate();
			if(i==1) {
				done=true;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return done;
	}


	public boolean update_content(story_title titleO) {
		boolean done3= false;
		
		try {
		String sql2="update story_title  set title=?, chapter=?, content=?, tagOne=?, description=?  where titleId=?";
		PreparedStatement pStatement3= conn.prepareStatement(sql2);
		
		
		pStatement3.setString(1, titleO.getTitle());
		pStatement3.setString(2, titleO.getChapter());
		pStatement3.setString(3 , titleO.getContent());
		pStatement3.setString(4, titleO.getTagOne());
		pStatement3.setString(5, titleO.getDescription());
		pStatement3.setInt(6, titleO.getTitleId());
		
		int i= pStatement3.executeUpdate();
		
		if(i==1) {
			done3=true;
		}
		
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return done3;
	}

	

	@Override
	public boolean update_status(story_title titleO) {
boolean done4= false;
		
		try {
		String sql2="update story_title set status='upload' where titleId=?";
		PreparedStatement pStatement3= conn.prepareStatement(sql2);
		
	System.out.println("+++" +titleO.getStatus());
	System.out.println("++++++" +titleO.getTitleId());
		pStatement3.setInt(1, titleO.getTitleId());
		
		int i= pStatement3.executeUpdate();
		
		if(i==1) {
			done4=true;
		}
		
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return done4;
	}
	public List<story_title> getstory(String userid) {
		
		List<story_title> list= new ArrayList<story_title>();
		story_title titleO=null;
		
		try {
			user userO=null;
			int idd=0;	
	         String sql="select id from user where userid=?";
				PreparedStatement pStatement= conn.prepareStatement(sql);
				
				pStatement.setString(1, userid);
				
				ResultSet rSet= pStatement.executeQuery();
				
				while(rSet.next()) {
				userO= new user();
				userO.setId(rSet.getInt(1));
				idd=rSet.getInt(1);
				}
				System.out.println("outside99  "+idd);
				
			
			String sql2="select *from story_title where FK_id="+idd;
			PreparedStatement pStatement2=conn.prepareStatement(sql2);
			
			ResultSet rSet2=pStatement2.executeQuery();
			
			while(rSet2.next()) {
				titleO=new story_title();
				titleO.setTitleId(rSet2.getInt(1));
				titleO.setTitle(rSet2.getString(3));
				titleO.setChapter(rSet2.getString(4));
				titleO.setTagOne(rSet2.getString(6));
				titleO.setPhotoname(rSet2.getString(7));
				list.add(titleO);
			}
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
}
	
	@Override
	public List<story_title> displayTP() {
		
		List<story_title> list= new ArrayList<story_title>();
		story_title titleO =null;
		
		try {
			
			String sql= "select *from story_title where status='upload'";
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ResultSet rSet= ps.executeQuery();
			int i=1;
			while(rSet.next() && i<=7) {
				
				titleO=new story_title();
				titleO.setTitleId(rSet.getInt(1));
				titleO.setTitle(rSet.getString(3));
				titleO.setChapter(rSet.getString(4));
				titleO.setContent(rSet.getString(5));
				titleO.setTagOne(rSet.getString(6));
				titleO.setPhotoname(rSet.getString(7));
				list.add(titleO);
				i++;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public List<story_title> displayPoetry() {
		
		List<story_title> list= new ArrayList<story_title>();
		story_title titleO =null;
		
		try {
			
			String sql= "select *from story_title where tagOne=? and status='upload'";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, "Poetry");
			
			ResultSet rSet= ps.executeQuery();
			int i=1;
			while(rSet.next() && i<=8) {
				
				titleO=new story_title();
				titleO.setTitleId(rSet.getInt(1));
				titleO.setTitle(rSet.getString(3));
				titleO.setChapter(rSet.getString(4));
				titleO.setContent(rSet.getString(5));
				titleO.setTagOne(rSet.getString(6));
				titleO.setPhotoname(rSet.getString(7));
				list.add(titleO);
				i++;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return list;
	}
	
	
	@Override
	public List<story_title> displayScifi() {
		
		List<story_title> list= new ArrayList<story_title>();
		story_title titleO =null;
		
		try {
			
			String sql= "select *from story_title where tagOne=? and status='upload'";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, "Sci-fi");
			
			ResultSet rSet= ps.executeQuery();
			int i=1;
			while(rSet.next() && i<=8) {
				
				titleO=new story_title();
				titleO.setTitleId(rSet.getInt(1));
				titleO.setTitle(rSet.getString(3));
				titleO.setChapter(rSet.getString(4));
				titleO.setContent(rSet.getString(5));
				titleO.setTagOne(rSet.getString(6));
				titleO.setPhotoname(rSet.getString(7));
				list.add(titleO);
				i++;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return list;
	}
	
	
	@Override
	public List<story_title> displayFolklore() {
		
		List<story_title> list= new ArrayList<story_title>();
		story_title titleO =null;
		
		try {
			
			String sql= "select *from story_title where tagOne=? and status='upload'";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, "Folklore");
			
			ResultSet rSet= ps.executeQuery();
			int i=1;
			while(rSet.next() && i<=8) {
				
				titleO=new story_title();
				titleO.setTitleId(rSet.getInt(1));
				titleO.setTitle(rSet.getString(3));
				titleO.setChapter(rSet.getString(4));
				titleO.setContent(rSet.getString(5));
				titleO.setTagOne(rSet.getString(6));
				titleO.setPhotoname(rSet.getString(7));
				list.add(titleO);
				i++;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return list;
	
	}
	
	
	@Override
	public List<story_title> displayTcrimes() {
		List<story_title> list= new ArrayList<story_title>();
		story_title titleO =null;
		
		try {
			
			String sql= "select *from story_title where tagOne=? and status='upload'";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, "True Crimes");
			
			ResultSet rSet= ps.executeQuery();
			int i=1;
			while(rSet.next() && i<=8) {
				
				titleO=new story_title();
				titleO.setTitleId(rSet.getInt(1));
				titleO.setTitle(rSet.getString(3));
				titleO.setChapter(rSet.getString(4));
				titleO.setContent(rSet.getString(5));
				titleO.setTagOne(rSet.getString(6));
				titleO.setPhotoname(rSet.getString(7));
				list.add(titleO);
				i++;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return list;
	}
	@Override
	public story_title editstory(int titleid) {
		story_title titleO=null;
		
		try {
			String sql2="select *from story_title where titleId=?";
			PreparedStatement pStatement2=conn.prepareStatement(sql2);
			
			pStatement2.setInt(1, titleid);
			
			ResultSet rSet2=pStatement2.executeQuery();
			
			while(rSet2.next()) {
				titleO=new story_title();
				titleO.setTitleId(rSet2.getInt(1));
				titleO.setTitle(rSet2.getString(3));
				titleO.setChapter(rSet2.getString(4));
				titleO.setContent(rSet2.getString(5));
				titleO.setTagOne(rSet2.getString(6));
				titleO.setPhotoname(rSet2.getString(7));
				titleO.setDescription(rSet2.getString(8));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return titleO;
	}
	@Override
	public boolean delete(int titleid) {
		boolean done4=false;
		
		try {
			String sql="delete from story_title where titleId=?";
			PreparedStatement pStatement=conn.prepareStatement(sql);
			
			pStatement.setInt(1, titleid);
			
			int i=pStatement.executeUpdate();
			if(i==1) {
				done4=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return done4;
	}
	@Override
	public List<story_title> searchstory(String ch) {
		List<story_title> list= new ArrayList<story_title>();
		story_title titleO =null;
		
		try {
			
			String sql= "select *from story_title where title=?, tagOne=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, "True Crimes");
			
			ResultSet rSet= ps.executeQuery();
			int i=1;
			while(rSet.next() && i<=8) {
				
				titleO=new story_title();
				titleO.setTitleId(rSet.getInt(1));
				titleO.setTitle(rSet.getString(3));
				titleO.setChapter(rSet.getString(4));
				titleO.setContent(rSet.getString(5));
				titleO.setTagOne(rSet.getString(6));
				titleO.setPhotoname(rSet.getString(7));
				list.add(titleO);
				i++;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return list;
	}

	
	
	
	
}
