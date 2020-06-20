package control.chatClient;

import java.io.DataInputStream;
import java.net.Socket;

class ClientReceiver extends Thread {
	Socket socket;
	DataInputStream in;

	public ClientReceiver(Socket socket) {
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
				System.out.println(in.readUTF());
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
