package chatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import chatServer.control.ChatController;
import chatServer.model.ChatModel;

public class Server {

	public static void main(String[] args) {
		ChatModel model = new ChatModel();
		ChatController control = new ChatController(model);
		ServerSocket serverSocket;
		
		try {
			serverSocket = new ServerSocket(8080);
			System.out.println("서버 시작");
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("■ [SERVER] " + socket.getInetAddress() + " : " + socket.getPort() + "클라 접속");
				new ChattingServer(socket, model, control).start();
			}
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
}

class ChattingServer extends Thread {
	ChatController control;
	ChatModel model;
	Socket socket;
	DataInputStream in;
	DataOutputStream out;

	ChattingServer(Socket socket, ChatModel model, ChatController control) {
		this.socket = socket;
		this.model = model;
		this.control = control;
		try {
			// 접속 유저의 in/out 스트림 생성
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
		} catch (Exception e) {}
	}

	@Override
	public void run() {
		try {
			// 일단 쌓인 메시지데이터들 다 보내주자.
			// 첫번째로 받는 것은 userid
			String id = in.readUTF();
			String opp = in.readUTF();
			
			// 서버에 접속신고 해줘야지
			model.socket.put(id, socket);
			
			System.out.println(id + "님이 접속했습니다.");
			// 여긴 서버인디. 이걸 클라에게 보내줘야 함
			String[] msg = control.recvMsg(id, opp);
			if(msg != null) {
				for (int i = 0; i < msg.length; i++) {
					out.writeUTF(opp + ":  " + msg[i]);
				}
			}
			
			// 채팅 시작.  중간자역할
			// 상대방에게 보내는 out 스트림 생성
			while (true) {
				Socket otherSocket = null;
				DataOutputStream otherOut = null;
				String message = in.readUTF();
				System.out.println("server check : " + message);
				// 접속중이 아니라면
				if(control.getSocket(opp) == null) {
					System.out.println("접속중 아니다");
					control.saveMsg(opp, id, message);
				} else {
					//접속중이면 스트림 생성
					System.out.println("접속중이다");
					otherSocket = control.getSocket(opp);
					otherOut = new DataOutputStream(otherSocket.getOutputStream());
					
					otherOut.writeUTF(message);
				}
			}
		} catch (SocketException e1) {
			System.out.println("접속 종료");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
