package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public JButton upBtn, backBtn, dupBtn;
	public JTextField input_id, input_pw, input_email;
	private JPanel panel;
	public boolean isDup = false;
	SignUpPanel() {
		setSize(355, 340);
		setLayout(null);
		
		JLabel title = new JLabel("SQUEST");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Verdana", Font.PLAIN, 35));
		title.setBounds(52, 45, 247, 51);
		add(title);
		
		JLabel labelID = new JLabel("ID");
		labelID.setHorizontalAlignment(SwingConstants.CENTER);
		labelID.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelID.setBounds(0, 116, 76, 28);
		add(labelID);
		
		input_id = new JTextField();
		input_id.setColumns(10);
		input_id.setBounds(88, 123, 149, 21);
		add(input_id);
		
		JLabel labelPW = new JLabel("PW");
		labelPW.setHorizontalAlignment(SwingConstants.CENTER);
		labelPW.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelPW.setBounds(0, 154, 76, 28);
		add(labelPW);
		
		input_pw = new JTextField();
		input_pw.setColumns(10);
		input_pw.setBounds(88, 161, 149, 21);
		add(input_pw);
		
		JLabel labelEmail = new JLabel("e-mail");
		labelEmail.setHorizontalAlignment(SwingConstants.CENTER);
		labelEmail.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelEmail.setBounds(0, 192, 76, 28);
		add(labelEmail);
		
		upBtn = new JButton("회원가입");
		upBtn.setBackground(new Color(102, 153, 204));
		upBtn.setBounds(191, 250, 108, 28);
		add(upBtn);
		
		backBtn = new JButton("뒤로가기");
		backBtn.setBackground(new Color(102, 153, 204));
		backBtn.setBounds(52, 250, 108, 28);
		add(backBtn);
		
		input_email = new JTextField();
		input_email.setColumns(10);
		input_email.setBounds(88, 199, 149, 21);
		add(input_email);
		
		panel = new JPanel();
		panel.setBackground(new Color(51, 102, 204));
		panel.setBounds(0, 0, 355, 28);
		add(panel);
		
		dupBtn = new JButton("중복확인");
		dupBtn.setBackground(Color.LIGHT_GRAY);
		dupBtn.setBounds(249, 124, 94, 19);
		add(dupBtn);
		
	}
}
