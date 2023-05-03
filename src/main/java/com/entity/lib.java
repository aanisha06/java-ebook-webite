package com.entity;

public class lib {

	private int libId;
	private int id_FK ;
	private int titleid_FK;
	private String writer;
	private String title;
	public int getLibId() {
		return libId;
	}
	public void setLibId(int libId) {
		this.libId = libId;
	}
	public int getId_FK() {
		return id_FK;
	}
	public void setId_FK(int id_FK) {
		this.id_FK = id_FK;
	}
	public int getTitleid_FK() {
		return titleid_FK;
	}
	public void setTitleid_FK(int titleid_FK) {
		this.titleid_FK = titleid_FK;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "lib [libId=" + libId + ", id_FK=" + id_FK + ", titleid_FK=" + titleid_FK + ", writer=" + writer
				+ ", title=" + title + "]";
	}
	
	
}
