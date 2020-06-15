package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.Controller;

public class BoardPanel extends CenterPanel{
	private static final long serialVersionUID = 2L;
	public JTable posts;
	public JButton writing, back;
	public DefaultTableModel model;
	public String[] cols;
	public Object[][] data;
	
	public BoardPanel() {
		setSize(MainFrame.CENTEREWidth, MainFrame.CENTERHeight);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 994, 604);
		add(scrollPane);
		
		//model setting
		cols = new String[] {"번호", "Q", "제목", "글쓴이", "작성일"};
		data = new Object[0][];
		model = new DefaultTableModel(data, cols);
		//테이블 세팅
		posts = new JTable(model);
		posts.setRowSelectionAllowed(false);
		posts.setShowHorizontalLines(false);
		posts.setShowVerticalLines(false);
		posts.setShowGrid(false);
		posts.setEnabled(false);
		//listener
		posts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel selectionModel = posts.getSelectionModel();
		scrollPane.setViewportView(posts);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(10, 608, 972, 5);
		add(panel);
		
		writing = new JButton("글쓰기");
		writing.setBackground(new Color(100, 149, 237));
		writing.setBounds(851, 628, 97, 23);
		add(writing);
		
		back = new JButton("뒤로가기");
		back.setBackground(new Color(100, 149, 237));
		back.setBounds(724, 628, 97, 23);
		add(back);
	}
	
	@Override
	public void turnAuthView(String id) {
		if(Controller.IsAuth()) {
			writing.setVisible(true);
		} else {
			writing.setVisible(false);
		}
	}
}
