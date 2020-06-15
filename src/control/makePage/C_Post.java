package control.makePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JOptionPane;

import control.Controller;
import model.Comment;
import model.Post;
import view.MainFrame;
import view.PostPanel;

public class C_Post extends C_Panel{
	C_Post(MainFrame view, Controller control){
		super(view, control);
	}
	public void set(PostPanel panel, Post post) {
		
		if(Controller.IsAuth()) {
			panel.myID.setText(control.me.getId());
			panel.myID.setVisible(true);
			panel.input_tmpID.setVisible(false);
		} else {
			panel.myID.setText("");
			panel.myID.setVisible(false);
			panel.input_tmpID.setVisible(true);
		}
		
		// 포스트 세팅
		panel.output_no.setText("No." + post.getId());
		// 제목
		panel.output_title.setText(post.getTitle());
		// id
		panel.output_id.setText(post.getUserid());
		// 날짜
		panel.output_time.setText(post.getTime());
		// 내용
		panel.output_content.setText(post.getContent());
		// 댓글 "id", "content", "time"
		Comment[] coms = control.getComments(post);
		if(coms != null)
			for (int i = 0; i < coms.length; i++) {
				Object[] com = { coms[i].getUserid(), coms[i].getContent(), coms[i].getTime() };
				panel.model.addRow(com);
			}
			
		// 버튼 세팅
		// 댓글 작성
		panel.send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Calendar cal = Calendar.getInstance();
				String time = "" + cal.get(1) + "." + (cal.get(2) + 1) + "." + cal.get(5);

				System.out.print("Comment: send > ");
				String content = panel.input_comment.getText();

				// 로긴 댓 작성
				if (Controller.IsAuth()) {
					if (content.equals("")) {
						JOptionPane.showMessageDialog(null, "댓글 내용을 입력하세요");
						return;
					}
					// 댓글 등록
					control.writeComment(control.me.getId(), content, post);
					panel.input_comment.setText("");

					// table update
					Object[] com = { control.me.getId(), content, time };
					panel.model.addRow(com);
				}

				// 익명 댓 작성
				else {
					System.out.println("NONAMED");
					String tmpID = "비회원: " + panel.input_tmpID.getText();
					if (tmpID.equals("")) {
						JOptionPane.showMessageDialog(null, "익명 아이디를 입력하세요");
						return;
					} else if (content.equals("")) {
						JOptionPane.showMessageDialog(null, "댓글 내용을 입력하세요");
						return;
					} else {
						// 댓글 등록
						control.writeComment(tmpID, content, post);

						// table update
						Object[] com = { tmpID, content, time };
						panel.model.addRow(com);
						
						panel.input_tmpID.setText("");
						panel.input_comment.setText("");
					}
				}
			}
		});

		// 뒤로가기
		panel.back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goback();
			}
		});
	}
}
