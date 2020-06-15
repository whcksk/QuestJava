package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import control.Controller;
import javax.swing.ImageIcon;

public class HeaderPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public JButton home, login, logout, mypage, calendar;
	
	public 	HeaderPanel() {
		setPreferredSize(new Dimension(1000, 200));
		setLayout(null);
		home = new JButton("Home");
		login = new JButton("login");
		logout = new JButton("logout");
		mypage = new JButton("mypage");
		
		home.setBounds(10, 10, 80, 50);
		login.setBounds(890, 10, 80, 50);
		logout.setBounds(890, 10, 80, 50);
		mypage.setBounds(800, 10, 80, 50);
		
		mypage.setVisible(false);
		logout.setVisible(false);
		
		home.setForeground(new Color(0, 0, 0));
		login.setForeground(new Color(0, 0, 0));
		setBackground(new Color(192, 192, 192));
		login.setBackground(new Color(220, 220, 220));
		home.setBackground(new Color(220, 220, 220));
		
		JLabel SQUEST = new JLabel("SQUEST");
		SQUEST.setFont(new Font("Verdana", Font.BOLD, 15));
		SQUEST.setHorizontalAlignment(SwingConstants.CENTER);
		SQUEST.setBounds(121, 10, 105, 50);
		
		add(SQUEST);
		add(home);
		add(login);
		add(logout);
		add(mypage);
		
		calendar = new JButton("");
		calendar.setIcon(new ImageIcon("C:/Users/whcks/Desktop/eclipse/workspace/Qqqq/src/calendar.jpg"));
		calendar.setBounds(725, 10, 50, 50);
		add(calendar);
		
	}
	public void turnAuthView(String id) {
		if(Controller.IsAuth()) {
			mypage.setVisible(true);
			logout.setVisible(true);
			login.setVisible(false);
		} else {
			mypage.setVisible(false);
			logout.setVisible(false);
			login.setVisible(true);
		}
	}
}
