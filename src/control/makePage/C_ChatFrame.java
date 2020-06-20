package control.makePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import control.Controller;
import view.ChatFrame;

public class C_ChatFrame {
	public void set(ChatFrame view, Controller control) {
		view.send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = view.msg.getText();
				view.msg.setText("");
				
			}
		});
		
		view.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				
			}
		});
	}
}



