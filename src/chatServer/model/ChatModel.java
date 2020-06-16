package chatServer.model;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class ChatModel {
	public static int port = 8000;
	
	public ArrayList<ServerSocket> serverSockets = new ArrayList<ServerSocket>();
	public ArrayList<Socket> sockets = new ArrayList<Socket>();
	
	public HashMap<Integer, HashMap<Integer, Queue<String>>> recv_send =  new HashMap<Integer, HashMap<Integer,Queue<String>>>();// receiverId : senderId : message
}

