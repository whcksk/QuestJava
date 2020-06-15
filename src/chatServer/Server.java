package chatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static void main(String[] args) {
		System.out.println("server start");
		new Server().run();
	}

	public void run() {
		while (true) {
			ServerSocket serverSocket = null;
			try {
				serverSocket = new ServerSocket(port++);
				serverSockets.add(serverSocket);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				Socket socket = serverSocket.accept();
				sockets.add(socket);
				new ChattingServer(socket).start();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Server end");
				break;
			}
		}
	}
}

class ChattingServer extends Thread {
	Socket socket;

	ChattingServer(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		DataInputStream inputdata;
		DataOutputStream outputdata;
		try {
			inputdata = new DataInputStream(socket.getInputStream());
			String id = inputdata.readUTF();
			Socket receiver = null;
			try {
				receiver = Server.sockets.get(Integer.parseInt(id));
			} catch (Exception e) {
				System.out.println("해당 아이디없");
			}
			
			if (receiver != null) {
				outputdata = new DataOutputStream(receiver.getOutputStream());

				for (int i = 0; i < Server.oldMsg.size(); i++) {
					outputdata.writeUTF(Server.oldMsg.remove(i));
				}
			}

			while (true) {
				try {
					receiver = Server.sockets.get(Integer.parseInt(id));
					String message = inputdata.readUTF();
					System.out.println(message);

					if (receiver == null) {
						Server.oldMsg.add(message);
					} else {
						outputdata = new DataOutputStream(receiver.getOutputStream());
						outputdata.writeUTF(message);
					}

				} catch (IOException e) {
					e.printStackTrace();
					break;
				} catch (Exception e) {
					break;
				}
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
