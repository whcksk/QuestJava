package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import control.Controller;

public class UserpagePanel extends CenterPanel {
	private static final long serialVersionUID = 1L;
	public JTable posts, comments;
	public JLabel userId;
	public JButton back, chat;
	public DefaultTableModel model_post, model_comment;
	public String[] col_post, col_comment;
	public Object[][] data_post, data_comment;
	private ListSelectionModel selectionModel;
	
	public UserpagePanel() {

		setSize(MainFrame.CENTEREWidth, MainFrame.CENTERHeight);
		setLayout(null);

		JLabel label1 = new JLabel("전체 게시글");
		label1.setBounds(14, 84, 89, 28);
		add(label1);

		JPanel panel = new JPanel();
		panel.setBounds(14, 124, 956, 2);
		panel.setBackground(new Color(30, 144, 255));
		add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(14, 420, 956, 2);
		panel_1.setBackground(new Color(30, 144, 255));
		add(panel_1);

		JLabel label2 = new JLabel("전체 댓글");
		label2.setBounds(14, 388, 111, 28);
		add(label2);

		JScrollPane scroll_posts = new JScrollPane();
		scroll_posts.setBounds(24, 138, 956, 250);
		add(scroll_posts);

		//Post Table
		posts = new JTable();
		posts.setRowSelectionAllowed(false);
		posts.setShowVerticalLines(false);
		posts.setShowHorizontalLines(false);
		posts.setShowGrid(false);
		posts.setEnabled(false);
		col_post = new String[] { "번호", "제목", "글쓴이", "작성일" };
		data_post = new Object[0][];
		model_post = new DefaultTableModel(data_post, col_post);
		posts.setModel(model_post);
		// listener
		posts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectionModel = posts.getSelectionModel();

		scroll_posts.setViewportView(posts);

		JScrollPane scroll_comments = new JScrollPane();
		scroll_comments.setBounds(24, 429, 956, 192);
		add(scroll_comments);

		//Comment Table
		comments = new JTable();
		comments.setShowVerticalLines(false);
		comments.setShowHorizontalLines(false);
		comments.setRowSelectionAllowed(false);
		comments.setShowGrid(false);
		comments.setEnabled(false);
		col_comment = new String[] { "내용", "작성일" };
		data_comment = new Object[0][];
		model_comment = new DefaultTableModel(data_comment, col_comment);
		comments.setModel(model_comment);
		// listener
		comments.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectionModel = comments.getSelectionModel();
		scroll_comments.setViewportView(comments);
		
		back = new JButton("뒤로가기");
		back.setBackground(new Color(100, 149, 237));
		back.setBounds(883, 633, 97, 23);
		add(back);
		
		userId = new JLabel("ID");
		userId.setHorizontalAlignment(SwingConstants.CENTER);
		userId.setBounds(14, 12, 121, 49);
		add(userId);
		
		chat = new JButton("채팅하기");
		chat.setBackground(new Color(100, 149, 237));
		chat.setBounds(746, 633, 105, 27);
		add(chat);
		
		turnAuthView("");
	}

	@Override
	public void turnAuthView(String id) {
		if(Controller.IsAuth()) {
			chat.setVisible(true);
		} else {
			chat.setVisible(false);
		}
	}
}
