package chatServer.model;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class ChatModel {
	public ArrayList<ServerSocket> serverSockets = new ArrayList<ServerSocket>();
	public ArrayList<Socket> sockets = new ArrayList<Socket>();
	
	public HashMap<Integer, ArrayList<Integer>> recv_send =  new HashMap<Integer, ArrayList<Integer>>();// receiverId : senderId
	public HashMap<Userkey, Queue<String>> recvMsg = new HashMap<Userkey, Queue<String>>();	//rcvsndKey : oldMsg
}

