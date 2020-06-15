package control;

import java.util.ArrayList;
import java.util.Iterator;

import control.func.AuthUser;
import control.func.CreateUser;
import control.func.ReadUser;
import control.func.WriteComment;
import control.func.WritePost;
import model.Comment;
import model.Model;
import model.Post;
import model.User;

public class Controller {
	Model model;
	public User me;
	private static boolean auth = false;

	public Controller(Model model) {
		this.model = model;

		createUser("1", "1", "SKYRIM");
	}

	public boolean createUser(String id, String pw, String email) {
		System.out.println("Control: createUser");
		return new CreateUser().exec(model, id, pw, email);
	}

	public User readUser(String id) {
		System.out.println("Control: readUser");
		return new ReadUser().exec(model, id);
	}

	public void updateUser(String id, String pw, String email) {
		System.out.println("Control: updateUser");
	}

	public void deleteUser(String id) {
		System.out.println("Control: deleteUser");
	}

	public boolean isDuple(String id) {
		System.out.println("Control: isDuple");
		if (model.users_info.containsKey(id)) {
			return true;
		} else {
			return false;
		}
	}

	public int authUser(String id, String pw) {
		System.out.println("Control: authUser");
		int result = new AuthUser().exec(model, id, pw);
		me = readUser(id);
		return result;
	}

	public void logout() {
		System.out.println("Control: logout");
		me = null;
		chageAuth();
	}

	public void writePost(String uid, boolean quest, String title, String content) {
		System.out.println("Control: wirtePost");
		new WritePost().exec(model, uid, quest, title, content);
	}

	public void writeComment(String uid, String content, Post post) {
		System.out.println("Control: writeComment");
		new WriteComment().exec(model, uid, content, post);
	}

	public User[] getUsers() {
		Iterator<User> iter = model.users.values().iterator();
		User[] users = new User[model.users.size()];
		for (int i = 0; i < users.length; i++) {
			users[i] = iter.next();
		}
		return users;
	}
	
	public User getUser(String id) {
		return model.users.get(id);
	}
	
	public Comment[] getComments(Post post) {
		ArrayList<Integer> id = model.post_comment.get(post.getId());
		if(id == null) {
			return null;
		}
		Comment[] coms = new Comment[id.size()];
		for (int i = 0; i < coms.length; i++) {
			coms[i] = model.comments.get(id.get(i));
		}
		return coms;
	}
	
	public Comment[] getComments(User user) {
		ArrayList<Integer> id = model.user_comment.get(user.getId());
		if(id == null)
			return null;
		Comment[] coms = new Comment[id.size()];
		for (int i = 0; i < coms.length; i++) {
			coms[i] = model.comments.get(id.get(i));
		}
		return coms;
	}
	
	public Post[] getPosts(User user) {
		//getPostID
		ArrayList<Integer> id = model.user_post.get(user.getId());
		if(id == null) {
			return null;
		}
		Post[] posts = new Post[id.size()];
		for (int i = 0; i < posts.length; i++) {
			posts[i] = model.posts.get(id.get(i));
		}
		return posts;
	}
	
	public Post[] getPosts(String date) {
		ArrayList<Integer> id = model.date_quest.get(date);
		if(id == null) {
			return null;
		}
		
		Post[] posts = new Post[id.size()];
		for (int i = 0; i < posts.length; i++) {
			posts[i] = model.posts.get(id.get(i));
		}
		return posts;
	}
	
	public Post getPost(int index) {
		return model.posts.get(index);
	}
	
	public Post[] getTotalPosts() {
		Post[] posts = new Post[model.posts.size()];
		for (int i = 0; i < posts.length; i++) {
			posts[i] = model.posts.get(i);
		}
	
		return posts;
	}
	public static boolean IsAuth() {
		return auth;
	}

	public void chageAuth() {
		auth = !auth;
	}

}
