package control.func;

import java.util.ArrayList;

import model.Model;
import model.Post;

public class WritePost {
	public void exec(Model model, String uid, boolean quest, String title, String content) {
		Post post = new Post(uid, quest, title, content);

		// user_post 연결 생성
		if (!model.user_post.containsKey(uid)) {
			model.user_post.computeIfAbsent(uid, k -> new ArrayList<Integer>());
			model.user_post.get(uid).add(post.getId());
		} else {
			ArrayList<Integer> tmp = model.user_post.get(uid);
			tmp.add(post.getId());
		}

		if (post.isQuest()) {
			// date_post연결 생성
			if (!model.date_quest.containsKey(post.getTime())) {
				model.date_quest.computeIfAbsent(post.getTime(), k -> new ArrayList<Integer>());
				model.date_quest.get(post.getTime()).add(post.getId());
			} else {
				ArrayList<Integer> tmp = model.date_quest.get(post.getTime());
				tmp.add(post.getId());
			}
		}

		// 포스트 생성
		model.posts.add(post);
//		model.user_post.computeIfPresent(uid, (k, v) -> v.add(post.getId()));
	}
}
