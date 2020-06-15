package control.func;

import model.Model;

public class AuthUser {
	// -1 : ID 없음  0: 비밀번호 틀림   1: 인증완료
	public int exec(Model model, String id, String pw) {
		if(model.users.containsKey(id)) {
			if(model.users.get(id).getPw().equals(pw)) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return -1;
		}
	}
}
