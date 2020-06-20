package chatServer.control;

import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import chatServer.model.ChatModel;

public class ChatController {
	ChatModel model;

	public ChatController(ChatModel model) {
		this.model = model;
	}
	
	public void addSocket(int id, Socket socket) {
		model.socket.put(id, socket);
	}
	
	//getSocket으로 null이면 현재 접속해 있지 않다는 얘기
	//메시지 쌓아줘야한다. (saveMsg)
	public Socket getSocket(int id) {
		if(!model.socket.containsKey(id)) {
			return null;
		}
		return model.socket.get(id);
	}
	
	
	public int[] recvId(int receiver) {
		int[] senders;
		if (model.recv_send.containsKey(receiver)) {
			senders = new int[model.recv_send.size()];
			Iterator<Integer> iter = model.recv_send.get(receiver).keySet().iterator();
			for (int i = 0; iter.hasNext(); i++) {
				senders[i] = iter.next();
			}
			return senders;
		}
		return null;
	}

	// 접속 후 보낸이에게 쌓인 메시지 받기
	public String[] recvMsg(int receiver, int sender) {
		Queue<String> queue = model.recv_send.get(receiver).get(sender);
		String[] msg = new String[queue.size()];
		for (int i = 0; !queue.isEmpty(); i++) {
			msg[i] = queue.remove();
		}
		return msg;
	}

	// 서버가 리시버id에 샌더 id와 함께 메시지 저장
	public void saveMsg(int receiver, int sender, String message) {
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
