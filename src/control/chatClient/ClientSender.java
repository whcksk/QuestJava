package control.chatClient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import view.ChatFrame;

public class ClientSender {

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

	public void start() {
		try {
			out.writeUTF(me);
			out.writeUTF(oppenent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			String message = view.msg.getText();
			view.msg.setText("");
			Object[] data = { "", message };
			view.model.addRow(data);
			message = me + ": " + message;
			String msgtoSever = message;
			out.writeUTF(msgtoSever);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
