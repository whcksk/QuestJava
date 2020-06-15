package control.func;

import model.Model;
import model.User;

public class ReadUser {
	public User exec(Model model, String id) {
		return model.users.get(id);
	}
}
