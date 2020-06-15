package view;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// 로그인 화면
public class SignInPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel title;
	public JButton upBtn, inBtn;
	public JTextField input_id, input_pw;
	SignInPanel(){
		setLayout(null);
		setSize(355, 329);
		
		title = new JLabel("SQUEST");
		title.setFont(new Font("Verdana", Font.PLAIN, 35));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(52, 45, 247, 51);
		add(title);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 102, 204));
		panel_1.setBounds(0, 0, 355, 28);
		add(panel_1);
		
		JLabel labelID = new JLabel("ID");
		labelID.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelID.setHorizontalAlignment(SwingConstants.CENTER);
		labelID.setBounds(30, 116, 88, 28);
		add(labelID);
		
		JLabel labelPW = new JLabel("PW");
		labelPW.setHorizontalAlignment(SwingConstants.CENTER);
		labelPW.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelPW.setBounds(30, 154, 88, 28);
		add(labelPW);
		
		input_id = new JTextField();
		input_id.setBounds(143, 118, 149, 21);
		add(input_id);
		input_id.setColumns(10);
		
		input_pw = new JTextField();
		input_pw.setColumns(10);
		input_pw.setBounds(143, 161, 149, 21);
		add(input_pw);
		
		upBtn = new JButton("회원가입");
		upBtn.setBackground(new Color(102, 153, 204));
		upBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		upBtn.setBounds(52, 250, 108, 28);
		add(upBtn);
		
		inBtn = new JButton("로그인");
		inBtn.setBackground(new Color(102, 153, 204));
		inBtn.setBounds(191, 250, 108, 28);
		add(inBtn);
	}
}
