package com.DAO;

import java.io.InputStream;
import java.util.List;

import com.entity.story_title;

public interface WriteAndRead {
 
	public boolean save_content(String userid,story_title titleO);
	public boolean update_content(story_title titleO);
	public boolean update_status(story_title titleO);
	public boolean delete(int titleid);
	public List<story_title> getstory(String userid);
	public story_title editstory(int titleid);
	public List<story_title> displayTP();
	public List<story_title> displayPoetry();
	public List<story_title> displayScifi();
	public List<story_title> displayFolklore();
	public List<story_title> displayTcrimes();

    public List<story_title> searchstory(String ch);
}
