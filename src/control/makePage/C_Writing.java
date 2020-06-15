package control.makePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Controller;
import view.MainFrame;
import view.WritingPanel;

public class C_Writing extends C_Panel{
	public C_Writing(MainFrame view, Controller control) {
		super(view, control);
	}
	public void set(WritingPanel panel) {
		
		panel.send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				control.writePost(control.me.getId(), panel.quest.isSelected(), panel.title.getText(), panel.content.getText());
				goback();
			}
		});
		
		panel.back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goback();
			}
		});
	}
}
