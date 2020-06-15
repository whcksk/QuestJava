package chatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		System.out.println("client");
		new Client().run();
	}

	public void run() {
		try {
			Socket client = new Socket("127.0.0.1", 524);
			new ChattingClient(client).run();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ChattingClient {
	Socket socket;

	ChattingClient(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		new ChattingClientSend(socket).start();
		new ChattingClientReiv(socket).start();
	}
}

class ChattingClientSend extends Thread {
	Socket socket;

	public ChattingClientSend(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		DataOutputStream outputdata;
		try {
			outputdata = new DataOutputStream(socket.getOutputStream());
			Scanner sc = new Scanner(System.in);
			outputdata.writeUTF("0");
			while(true) {
				String message = sc.nextLine();
				outputdata.writeUTF(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class ChattingClientReiv extends Thread {
	Socket socket;

	public ChattingClientReiv(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		DataInputStream inputdata;
		try {
			inputdata = new DataInputStream(socket.getInputStream());
			while (true) {
				try {
					String message = inputdata.readUTF();
					System.out.println(message);
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