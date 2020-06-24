package chatServer.model;

import java.net.Socket;
import java.util.HashMap;
import java.util.Queue;

public class ChatModel {
	public HashMap<String, Socket> socket = new HashMap<String, Socket>();
	public HashMap<String, HashMap<String, Queue<String>>> recv_send =  new HashMap<String, HashMap<String,Queue<String>>>();// receiverId : senderId : message
}

