package control.chatClient;

import java.io.IOException;
import java.net.Socket;

import view.ChatFrame;

public class Client {
	public ClientSender sender;
	public ClientReceiver receiver;

	public void run(ChatFrame view, String me, String opponent) {
		Socket socket;
		try {
			socket = new Socket("192.168.0.175", 8080);
			System.out.println("클라이언트 시작");
			sender = new ClientSender(view, socket, me, opponent);
			receiver = new ClientReceiver(view, socket);
			receiver.start();
			sender.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}