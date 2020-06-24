package control.makePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import control.Controller;

import control.chatClient.Client;
import view.ChatFrame;

public class C_ChatFrame {
	Client client;
 	C_ChatFrame(ChatFrame view, String me, String opponent){
		client = new Client();
		client.run(view, me, opponent);
	}
	
	public void set(ChatFrame view, Controller control) {
		view.send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				client.sender.run();
			}
		});
		view.close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();

			}
		});
		
		view.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				
			}
		});
	}
}



