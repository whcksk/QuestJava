package chatServer.model;

import java.net.Socket;
import java.util.HashMap;
import java.util.Queue;

public class ChatModel {
	public HashMap<Integer, Socket> socket = new HashMap<Integer, Socket>();
	public HashMap<Integer, HashMap<Integer, Queue<String>>> recv_send =  new HashMap<Integer, HashMap<Integer,Queue<String>>>();// receiverId : senderId : message
}

