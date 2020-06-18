package control.makePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle.Control;

import control.Controller;
import model.Post;
import view.BoardPanel;
import view.CenterPanel;
import view.MainFrame;
import view.PostPanel;
import view.UserpagePanel;
import view.WritingPanel;

public class C_Board extends C_Panel{
	
	public C_Board(MainFrame view, Controller control){
		super(view, control);
	}

	public void set(BoardPanel panel) {
		if(Controller.IsAuth()) {
			panel.turnAuthView(control.me.getId());
		} else {
			panel.turnAuthView("");
		}
		
		// 기존 포스트 불러오기
		Post[] posts = control.getTotalPosts();
		for (int i = posts.length - 1; i >= 0; i--) {
			String quest = posts[i].isQuest() ? "!" : "";
			Object[] post = { posts[i].getId() + 1, quest, posts[i].getTitle(), posts[i].getUserid(), posts[i].getTime() };
			panel.model.addRow(post);
		}

		panel.writing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CenterPanel newpanel = view.change("writing");
				new C_Writing(view, control).set((WritingPanel) newpanel);
			}
		});
		
		panel.back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goback();
			}
		});

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
				if(col == 1 || col == 2) {
					PostPanel panel = (PostPanel) view.change("post");
					new C_Post(view, control).set(panel, control.getPost(Post.getNum() - row - 1));
				}
				//글쓴이 클릭
				else if(col == 3) {
					String id = (String) panel.model.getValueAt(row, col);
					UserpagePanel panel = (UserpagePanel) view.change("userpage");
					new C_Userpage(view, control).set(panel, control.getUser(id));
				}
				
			}
		});
	}
}
