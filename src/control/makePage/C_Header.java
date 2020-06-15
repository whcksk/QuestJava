package control.makePage;
			
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.Controller;
import view.BoardPanel;
import view.CalendarPanel;
import view.CenterPanel;
import view.MainFrame;
import view.SignFrame;
import view.UserpagePanel;
			
public class C_Header {
	public void set(MainFrame view, Controller control) {
				
		view.header.home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CenterPanel board = view.change("board");
				new C_Board(view, control).set((BoardPanel)board);
			}		
		});	
			
		view.header.login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignFrame frame = new SignFrame("signin");
				new C_Sign().set(view, frame, control);
			}
		});			
					
		view.header.logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "정말 로그아웃 하시겠습니까?", null, 0) == 0) {
					control.logout();
					view.turnAuthView("");
				}
			}
		});	
		
		view.header.mypage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CenterPanel mypage = view.change("userpage");
				new C_Userpage(view, control).set((UserpagePanel)mypage, control.me);
			}
		});
		
		view.header.calendar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CenterPanel cal = view.change("calendar");
				new C_Calendar(view, control).set((CalendarPanel) cal);
			}
		});
	}
}
