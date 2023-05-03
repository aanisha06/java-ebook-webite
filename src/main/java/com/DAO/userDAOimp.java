package com.DAO;

import java.sql.Connection;

//import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import java.sql.*;

import com.entity.user;

public class userDAOimp implements userDAO {
	private Connection conn;

	public userDAOimp(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean userRegistration(user userO) {

		boolean done=false;
	
		
		try {
			String sql="insert into user(userid,password,fname,lname) values(?,?,?,?)";
			PreparedStatement ps= conn.prepareStatement(sql);

			ps.setString(1, userO.getUserid());
			ps.setString(2, userO.getPassword());
			ps.setString(3, userO.getFname());
			ps.setString(4, userO.getLname());
			
			
			int i=ps.executeUpdate();
			if(i==1) {
				done=true;
				
			}
		}
	    catch(SQLException e){
	    	
	    	e.printStackTrace();
	    }
			

		return done;
	}

	@Override
	public user UserAuth(String userid, String password) {
		user userO =null; //why?
		
		try {
			
			String sql="select *from user where userid=? and password=? ";
			PreparedStatement pStatement= conn.prepareStatement(sql);
			
			pStatement.setString(1, userid);
			pStatement.setString(2, password);
			
			ResultSet rs= pStatement.executeQuery();
		
			while(rs.next()) {
				userO= new user();
				userO.setId(rs.getInt(1));
				userO.setUserid(rs.getString(2));
				userO.setPassword(rs.getString(3));
				userO.setFname(rs.getString(4));
				userO.setLname(rs.getString(5));
			}
			
			
		} catch( Exception e) {
			e.printStackTrace();
		}
		return userO;
	}

	
	
	}


