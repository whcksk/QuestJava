package model;

import java.util.Calendar;

public class Comment {
	private static int num = 0;
	private int id;
	private String content;
	private String time;
	private String userid;
	
	public Comment(String userid, String content) {
		super();
		Calendar cal = Calendar.getInstance();
		id = num++;
		this.content = content;
		this.userid = userid;
		this.time = "" + cal.get(1) + "." + (cal.get(2) + 1) + "." + cal.get(5);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", time=" + time + ", userid=" + userid + "]";
	}
	
}
