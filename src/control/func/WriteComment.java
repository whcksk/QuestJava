package control.func;

import java.util.ArrayList;

import control.Controller;
import model.Comment;
import model.Model;
import model.Post;

public class WriteComment {

	public void exec(Model model, String uid, String content, Post post) {
		Comment com = new Comment(uid, content);
		
		// 로그인 시에만 유저 정보와 연결
		if (Controller.IsAuth()) {
			// 1. 유저와 연결 생성
			if (!model.user_comment.containsKey(uid)) {
				System.out.println("Non");
				model.user_comment.computeIfAbsent(uid, k -> new ArrayList<Integer>());
				model.user_comment.get(uid).add(com.getId());
			} else {
				System.out.println("add");
				ArrayList<Integer> tmp = model.user_comment.get(uid);
				tmp.add(com.getId());
			}
		}
		// 2. 포스트와 연결 생성
		if (!model.post_comment.containsKey(post.getId())) {
			model.post_comment.computeIfAbsent(post.getId(), k -> new ArrayList<Integer>());
			model.post_comment.get(post.getId()).add(com.getId());
		} else {
			ArrayList<Integer> tmp = model.post_comment.get(post.getId());
			tmp.add(com.getId());
		}

		// 코멘트 생성
		model.comments.add(com);
	}
}
