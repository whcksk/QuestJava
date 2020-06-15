package control.makePage;

import control.Controller;
import model.Post;
import model.User;
import view.BoardPanel;
import view.CalendarPanel;
import view.CenterPanel;
import view.MainFrame;
import view.PostPanel;
import view.UserpagePanel;
import view.WritingPanel;

public class C_Panel {
	MainFrame view;
	Controller control;

	C_Panel(MainFrame view, Controller control) {
		this.view = view;
		this.control = control;
	}

	public void goback() {
		CenterPanel curPane = (CenterPanel) view.center.getComponent(0);
		view.center.remove(curPane);
		CenterPanel oldPane = view.getPrev();

		if (oldPane == null) {
			return;
		}
		if (oldPane instanceof BoardPanel) {
			view.current = new BoardPanel();
			view.center.add(view.current);
			new C_Board(view, control).set((BoardPanel) view.current);

		} else if (oldPane instanceof CalendarPanel) {
			view.current = new CalendarPanel();
			view.center.add(view.current);
			new C_Calendar(view, control).set((CalendarPanel) view.current);

		} else if (oldPane instanceof PostPanel) {
			view.current = new PostPanel();
			view.center.add(view.current);
			String id = ((PostPanel) view.current).output_no.getText();
			Post post = control.getPost(Integer.parseInt(id));
			new C_Post(view, control).set((PostPanel) view.current, post);

		} else if (oldPane instanceof UserpagePanel) {
			view.current = new UserpagePanel();
			view.center.add(view.current);
			String id = ((UserpagePanel) oldPane).userId.getText();
			User user = control.getUser(id);
			new C_Userpage(view, control).set((UserpagePanel) view.current, user);
			
		} else if (oldPane instanceof WritingPanel) {
			if (Controller.IsAuth()) {
				view.current = new WritingPanel();
				view.center.add(view.current);
				new C_Writing(view, control).set((WritingPanel) view.current);
			} else {
				goback();
			}
		} else {
		}
		view.repaint();
	}
}
