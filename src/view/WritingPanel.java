package view;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WritingPanel extends CenterPanel {
	private static final long serialVersionUID = 1L;
	public JTextField title;
	public JTextArea content;
	public JCheckBox quest;
	public JButton back, send;
	
	public WritingPanel() {
		setSize(MainFrame.CENTEREWidth, MainFrame.CENTERHeight);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(14, 45, 966, 5);
		add(panel);
		
		title = new JTextField();
		title.setText("제목");
		title.setBounds(14, 12, 966, 24);
		add(title);
		title.setColumns(10);
		
		content = new JTextArea();
		content.setToolTipText("내용");
		content.setBounds(14, 97, 966, 508);
		add(content);
		
		quest = new JCheckBox("! 퀘스트");
		quest.setBounds(10, 58, 131, 27);
		add(quest);
		
		back = new JButton("뒤로가기");
		back.setBackground(new Color(100, 149, 237));
		back.setBounds(742, 636, 105, 27);
		add(back);
		
		send = new JButton("등록");
		send.setBackground(new Color(100, 149, 237));
		send.setBounds(875, 636, 105, 27);
		add(send);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(14, 619, 966, 5);
		add(panel_1);
	}

	@Override
	public void turnAuthView(String id) {
		
	}
}
