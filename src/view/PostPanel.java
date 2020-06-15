package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import control.Controller;

public class PostPanel extends CenterPanel{
	private static final long serialVersionUID = 1L;
	static int MAXCOMMENTCNT = 10;
	public JTextField output_title, input_tmpID, input_comment;
	public JTextArea output_content;
	public JLabel output_id, output_time, myID, output_no;
	public JScrollPane scroll_post, scroll_comment;
	public JButton send, back;
	public JTable comments;
	public DefaultTableModel model;
	public String[] cols;
	public Object[][] data;
	private String id = "";
	
	public PostPanel() {
		setSize(MainFrame.CENTEREWidth, MainFrame.CENTERHeight);
		setLayout(null);
		
		output_title = new JTextField();
		output_title.setEditable(false);
		output_title.setBounds(103, 10, 812, 21);
		add(output_title);
		output_title.setColumns(10);

		output_id = new JLabel();
		output_id.setBounds(50, 41, 118, 15);
		add(output_id);

		output_time = new JLabel();
		output_time.setBounds(180, 41, 141, 15);
		add(output_time);

		scroll_post = new JScrollPane();
		scroll_post.setBounds(50, 66, 865, 339);
		add(scroll_post);

		output_content = new JTextArea();
		scroll_post.setViewportView(output_content);
		output_content.setEditable(false);

		JLabel commentLabel = new JLabel("댓글");
		commentLabel.setBounds(50, 408, 71, 15);
		add(commentLabel);

		JPanel divide = new JPanel();
		divide.setBackground(new Color(100, 149, 237));
		divide.setBounds(12, 433, 970, 4);
		add(divide);

		input_comment = new JTextField();
		input_comment.setBounds(145, 597, 770, 21);
		add(input_comment);
		input_comment.setColumns(10);

		send = new JButton("등록");
		send.setBackground(new Color(100, 149, 237));
		send.setBounds(819, 628, 97, 23);
		add(send);

		back = new JButton("뒤로가기");
		back.setBackground(new Color(100, 149, 237));
		back.setBounds(699, 628, 97, 23);
		add(back);

		scroll_comment = new JScrollPane();
		scroll_comment.setBounds(50, 447, 865, 140);
		add(scroll_comment);

		//Table setting
		cols = new String[] {"id", "content", "time"};
		data = new Object[0][];
		model = new DefaultTableModel(data, cols);
		
		comments = new JTable(model);
		comments.setRowSelectionAllowed(false);
		comments.setShowHorizontalLines(false);
		comments.setShowVerticalLines(false);
		comments.setShowGrid(false);
		comments.setEnabled(false);
		comments.getColumn("content").setPreferredWidth(500);
		comments.getTableHeader().setUI(null);
		
		scroll_comment.setViewportView(comments);

		myID = new JLabel();
		myID.setBounds(50, 600, 89, 15);
		myID.setHorizontalAlignment(SwingConstants.CENTER);
		add(myID);
		
		input_tmpID = new JTextField();
		input_tmpID.setBounds(50, 597, 89, 21);
		input_tmpID.setColumns(10);
		add(input_tmpID);
		
		output_no = new JLabel("");
		output_no.setBounds(50, 13, 41, 18);
		add(output_no);
		
	}

	@Override
	public void turnAuthView(String id) {
		if(this.id.equals(""))
			this.id = id;
		if(Controller.IsAuth()) {
			myID.setText(id);
			myID.setVisible(true);
			input_tmpID.setVisible(false);
		} else {
			myID.setText("");
			myID.setVisible(false);
			input_tmpID.setVisible(true);
		}
	}
}
