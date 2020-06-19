package control.chatClient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import view.ChatFrame;

class ClientSender extends Thread {
	ChatFrame view;
	Socket socket;
	String me;
	String oppenent;
	DataOutputStream out;

	public ClientSender(ChatFrame view, Socket socket, String me, String opponent) {
		super();
		this.view = view;
		this.socket = socket;
		this.me = me;
		this.oppenent = opponent;
		try {
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			out.writeUTF(me);
			out.writeUTF(oppenent);
			while (true) {
				String msg = view.msg.getText();
				view.msg.setText("");
				out.writeUTF(msg);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
