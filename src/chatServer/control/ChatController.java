package chatServer.control;

import java.util.ArrayList;

import chatServer.model.ChatModel;
import chatServer.model.Userkey;

public class ChatController {
	ChatModel model;
	public ChatController(ChatModel model) {
		this.model = model;
	}
	
	public void send(int receiver, int sender, String message) {
		if(!model.recv_send.containsKey(receiver)) {
			model.recv_send.computeIfAbsent(receiver, k -> new ArrayList<Integer>());
			model.recv_send.get(receiver).add(sender);
		}
		else {
			ArrayList<Integer> tmp = model.recv_send.get(receiver);
			tmp.add(sender);
		}
		
		Userkey key = new Userkey(receiver, sender);
		
		if(!model.recvMsg.containsKey(key))
		
	}
}

class create