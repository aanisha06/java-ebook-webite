package com.DAO;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.entity.lib;

public class libImpl implements libDAO {

	private Connection conn;
	private libImpl(Connection conn) {
		this.conn=conn;
	}
	@Override
	public boolean addtolib(lib l) {
		boolean add=false;
		
		try {
			
			String sql="insert into lib(id_FK,title_FK,writer,title) values(?,?,?,?)";
			PreparedStatement pStatement=conn.prepareStatement(sql);
			pStatement.setInt(1, l.getId_FK());
			pStatement.setInt(2, l.getTitleid_FK());
			pStatement.setString(3, l.getWriter());
			pStatement.setString(4, l.getTitle());
			
			int i=pStatement.executeUpdate();
			if(i==1) {
				add=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return add;
	}

}
