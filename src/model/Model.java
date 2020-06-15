package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {
	public HashMap<String, String> users_info = new HashMap<String, String>();		//uid : userInfoid
	public HashMap<String, ArrayList<Integer>> user_post = new HashMap<String, ArrayList<Integer>>();		//uid : postid
	public HashMap<String, ArrayList<Integer>> user_comment = new HashMap<String,  ArrayList<Integer>>();	//uid : commentid
	public HashMap<Integer, ArrayList<Integer>> post_comment = new HashMap<Integer, ArrayList<Integer>>();	//postid : commnetid;
	public HashMap<String, ArrayList<Integer>> date_quest = new HashMap<String, ArrayList<Integer>>();		// date : postid
	
	public HashMap<String, User> users = new HashMap<String, User>();		//uid : User;
	public ArrayList<UserInfo> infos = new ArrayList<UserInfo>();
	public ArrayList<Post> posts = new ArrayList<Post>();
	public ArrayList<Comment> comments = new ArrayList<Comment>();
	
	public Model(){}
}
