package com.DAO;


import com.entity.user;

public interface userDAO {

	public boolean userRegistration(user userO);
	public user UserAuth(String userid, String password);
}
