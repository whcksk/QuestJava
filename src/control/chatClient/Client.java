package control.chatClient;

import java.io.IOException;
import java.net.Socket;

public class Client {
	public void run(String me, String opponent) {
		Socket socket;
//		try {
//			socket = new Socket("127.0.0.1", 8080);
//			System.out.println("클라이언트 시작");
//			new ClientSender(socket, me, opponent).start();
//			new ClientReceiver(socket).start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	public static void main(String[] args) {
		new Client().run("1", "2");
	}
}