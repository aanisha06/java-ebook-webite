package com.entity;

public class addchapter {
	
	private int chapter_id;
	private int FK_titleId;
	private String chapter_name;
	private String story_content;
	public int getChapter_id() {
		return chapter_id;
	}
	public void setChapter_id(int chapter_id) {
		this.chapter_id = chapter_id;
	}
	public int getFK_titleId() {
		return FK_titleId;
	}
	public void setFK_titleId(int fK_titleId) {
		FK_titleId = fK_titleId;
	}
	public String getChapter_name() {
		return chapter_name;
	}
	public void setChapter_name(String chapter_name) {
		this.chapter_name = chapter_name;
	}
	public String getStory_content() {
		return story_content;
	}
	public void setStory_content(String story_content) {
		this.story_content = story_content;
	}
	@Override
	public String toString() {
		return "addchapter [chapter_id=" + chapter_id + ", FK_titleId=" + FK_titleId + ", chapter_name=" + chapter_name
				+ ", story_content=" + story_content + "]";
	}
	public addchapter(int chapter_id, int fK_titleId, String chapter_name, String story_content) {
		super();
		this.chapter_id = chapter_id;
		FK_titleId = fK_titleId;
		this.chapter_name = chapter_name;
		this.story_content = story_content;
	}

	
}
