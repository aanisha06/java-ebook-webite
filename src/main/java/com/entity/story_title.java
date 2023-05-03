package com.entity;

import javax.servlet.http.Part;

import com.mysql.cj.jdbc.Blob;

//https://github.com/PetePrattis/eclass-web-application/blob/master/eclass/src/eclass/Student.java

public class story_title {

	private int titleId;
	private int FK_id;
	private String title;
	private String chapter;
	private String content;
	private String tagOne;
    private String photoname;
    private String description;
	private String status;
    
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	public int getTitleId() {
		return titleId;
	}
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}
	public int getFK_id() {
		return FK_id;
	}
	public void setFK_id(int fK_id) {
		FK_id = fK_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTagOne() {
		return tagOne;
	}
	public void setTagOne(String tagOne) {
		this.tagOne = tagOne;
	}

	public story_title() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "story_title [titleId=" + titleId + ", FK_id=" + FK_id + ", title=" + title + ", chapter=" + chapter
				+ ", content=" + content + ", tagOne=" + tagOne + ", photoname=" + photoname + "]";
	}

	
	
	
}
