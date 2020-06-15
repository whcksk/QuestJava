package control.func;

import model.Model;
import model.User;
import model.UserInfo;

public class CreateUser {
	public boolean exec(Model model, String id, String pw, String email) {
		User user = new User(id, pw);
		UserInfo info = new UserInfo(id, email);

		model.users.put(id, user);
		model.infos.add(info);
		model.users_info.put(id, id);

		return true;
	}
}
