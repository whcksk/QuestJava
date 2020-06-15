package model;

public class UserInfo {
	private String uid;
	private String email;
	public UserInfo(String uid, String email){
		this.uid = uid;
		this.email = email;
	}
	
	
	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", email=" + email + "]";
	}
	
	
}
