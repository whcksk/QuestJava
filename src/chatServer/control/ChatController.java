package chatServer.control;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import chatServer.model.ChatModel;

public class ChatController {
	ChatModel model;

	public ChatController(ChatModel model) {
		this.model = model;
	}

	public ServerSocket makeServerSocket() throws IOException {
		ServerSocket serverSocket = new ServerSocket(ChatModel.port++);
		model.serverSockets.add(serverSocket);
		return serverSocket;
	}
	
	public void send(int receiver, int sender, String message) {

		// 처음
		if (!model.recv_send.containsKey(receiver)) {
			model.recv_send.computeIfAbsent(receiver, k -> new HashMap<Integer, Queue<String>>());
			model.recv_send.get(receiver).computeIfAbsent(sender, k -> new LinkedList<String>());
		} else {
			// 첫 상대
			model.recv_send.get(receiver).computeIfAbsent(sender, k -> new LinkedList<String>());
		}
		model.recv_send.get(receiver).get(sender).add(message);

	}
}
