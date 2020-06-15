package control.makePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import control.Controller;
import model.Comment;
import model.Post;
import model.User;
import view.MainFrame;
import view.PostPanel;
import view.UserpagePanel;

public class C_Userpage extends C_Panel{
	C_Userpage(MainFrame view, Controller control){
		super(view, control);
	}
	public void set(UserpagePanel panel, User user) {
		// 유저정보 세팅
		// 유저 아이디
		panel.userId.setText(user.getId());
		// 유저 전체 게시글
		Post[] posts = control.getPosts(user);
		if(posts != null)
			for (int i = posts.length - 1; i >= 0; i--) {
				Object[] post = { posts[i].getId() + 1, posts[i].getTitle(), posts[i].getUserid(), posts[i].getTime() };
				panel.model_post.addRow(post);
			}
		// 유저 전체 댓글
		Comment[] comments = control.getComments(user);
		if(comments != null)
			for (int i = comments.length - 1; i >= 0; i--) {
				Object[] comment = { comments[i].getContent(), comments[i].getTime() };
				panel.model_comment.addRow(comment);
			}
		panel.posts.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = panel.posts.rowAtPoint(e.getPoint());
				int col = panel.posts.columnAtPoint(e.getPoint());
				//게시글 클릭
				if(col == 1) {
					int postId = (Integer)panel.model_post.getValueAt(row, 0) - 1;
					PostPanel newpanel = (PostPanel) view.change("post");
					new C_Post(view, control).set(newpanel, control.getPost(postId));
				}
			}
		});
		
		panel.back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goback();
			}
		});
	}
}
