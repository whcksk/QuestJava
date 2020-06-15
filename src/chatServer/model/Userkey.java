package chatServer.model;

public class Userkey {
	private int receiver;
	private int sender;

	public Userkey(int receiver, int sender) {
		this.receiver = receiver;
		this.sender = sender;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	@Override
	public String toString() {
		return "chatRevSndKey [receiver=" + receiver + ", sender=" + sender + "]";
	}
}
