package chatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class Client {
	public static void main(String[] args) {
		String user = "2";
		Socket socket;
		try {
			socket = new Socket("127.0.0.1", 8080);
			System.out.println("클라이언트 시작");
			new ClientSender(socket, user).start();
			new ClientReceiver(socket).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ClientSender extends Thread {
	Socket socket;
	String user;
	DataOutputStream out;

	public ClientSender(Socket socket, String user) {
		super();
		this.socket = socket;
		this.user = user;
		try {
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		try {
			out.writeUTF(user);
			while (true) {
				out.writeUTF(sc.next());
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}

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