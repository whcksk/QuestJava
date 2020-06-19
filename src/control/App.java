package control;

import chatServer.Server;
import control.makePage.C_Board;
import control.makePage.C_Header;
import model.Model;
import view.BoardPanel;
import view.MainFrame;

public class App {
	Model model = new Model();
	MainFrame view = new MainFrame();
	Controller control = new Controller(model);
	Server chatServer = new Server();
	
	App() {
		control.createUser("1", "1", "1");
		control.createUser("2", "1", "1");
		control.createUser("3", "1", "1");
		control.createUser("4", "1", "1");
		control.createUser("5", "1", "1");
		
		control.writePost("1", false, "title1", "no content");
		control.writePost("2", false, "title2", "2");
		control.writePost("3", true, "title3", "ADS");
		control.writePost("4", true, "title4", "GAZUA");
		control.writePost("1", false, "title11", "HAHA");
		control.writePost("1", false, "title12", "HELO!");
		control.writePost("5", true, "title1", "SKYRIM");
		control.writePost("3", true, "title31", "ELDERSCROLL");
		
		new C_Header().set(view, control);
		new C_Board(view, control).set((BoardPanel) view.current);
	}

	public void run() {
		view.createGui();
	}

	public static void main(String[] args) {
		new App().run();
	}
}
