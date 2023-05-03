package com.entity;

public class user {
	private int id;
	private String userid;
	private String password;
	private String fname;
	private String lname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	@Override
	public String toString() {
		return "user [id=" + id + ", userid=" + userid + ", password=" + password + ", fname=" + fname + ", lname="
				+ lname + "]";
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}

}
