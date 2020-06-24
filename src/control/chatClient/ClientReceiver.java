package control.chatClient;

import java.io.DataInputStream;
import java.net.Socket;
import view.ChatFrame;

class ClientReceiver extends Thread {
	Socket socket;
	ChatFrame view;
	DataInputStream in;

	public ClientReceiver(ChatFrame view, Socket socket) {
		this.view = view;

		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (in != null) {
			try {
				String message = in.readUTF();
				Object[] data = { message, "" };
				view.model.addRow(data);

			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
