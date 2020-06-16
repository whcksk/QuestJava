package chatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import chatServer.control.ChatController;
import chatServer.model.ChatModel;

public class Server{
	ChatModel model;
	ChatController control;

	public static void main(String[] args) {
		System.out.println("server");
		new Server().run();
	}

	public Server() {
		model = new ChatModel();
		control = new ChatController(model);
	}

	public void run() {

		while (true) {
			ServerSocket serverSocket = null;
			try {
				serverSocket = control.makeServerSocket();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Socket socket = serverSocket.accept();
				model.sockets.add(socket);
				new ChattingServer(model, control, socket).start();
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
	ChatController control;
	ChatModel model;
	Socket socket;

	ChattingServer(ChatModel model, ChatController control, Socket socket) {
		this.model = model;
		this.control = control;
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
				receiver = model.sockets.get(Integer.parseInt(id));
			} catch (Exception e) {
				System.out.println("해당 아이디없");
			}

			if (receiver != null) {
				outputdata = new DataOutputStream(receiver.getOutputStream());

				for (int i = 0; i < Server.oldMsg.size(); i++) {
					outputdata.writeUTF(Server.oldMsg.remove(i));
				}z
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
