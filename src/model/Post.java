package model;

import java.util.Calendar;

public class Post {
	static int num = 0;
	private int id;
	private String userid;
	private boolean quest;
	private String title; 
	private String content;
	private String time;
	
	public Post(String userid, boolean quest, String title, String content) {
		super();
		this.id = num++;
		this.quest = quest;
		this.title = title;
		this.content = content;
		Calendar cal = Calendar.getInstance();
		this.time = "" + cal.get(1) + "." + (cal.get(2) + 1) + "." + cal.get(5);
		this.userid = userid;
	}
	public static int getNum() {
		return num;
	}
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

	public boolean isQuest() {
		return quest;
	}
	public void setQuest(boolean quest) {
		this.quest = quest;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", userid=" + userid + ", quest=" + quest + ", title=" + title + ", content="
				+ content + ", time=" + time + "]";
	}
}
