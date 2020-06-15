package control.makePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import control.Controller;
import view.MainFrame;
import view.SignFrame;

public class C_Sign {
	public void set(MainFrame main, SignFrame view, Controller control) {
		// login in btn
		view.inPanel.inBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = view.inPanel.input_id.getText();
				String pw = view.inPanel.input_pw.getText();
				switch (control.authUser(id, pw)) {
				case -1:
					JOptionPane.showMessageDialog(null, "아이디가 없습니다.");
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.");
					break;
				case 1:
					JOptionPane.showMessageDialog(null, "로그인 성공");
					view.dispose();
					control.chageAuth();
					main.turnAuthView(control.me.getId());
					break;
				default:
					break;
				}
			}
		});
		view.inPanel.upBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.change("signup");
			}
		});

		view.upPanel.dupBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = view.upPanel.input_id.getText();
				if (id.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요");
					return;
				}
				if (control.isDuple(id)) {
					JOptionPane.showMessageDialog(null, "존재하는 ID입니다.");
					view.upPanel.isDup = false;
				} else {
					JOptionPane.showMessageDialog(null, "사용가능한 ID입니다.");
					view.upPanel.isDup = true;
				}
			}
		});
		view.upPanel.upBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = view.upPanel.input_id.getText();
				String pw = view.upPanel.input_pw.getText();
				String email = view.upPanel.input_email.getText();
				if (pw.equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요");
					return;
				}
				if (email.equals("")) {
					JOptionPane.showMessageDialog(null, "이메일을 입력해 주세요");
					return;
				} else if (!emailMatch(email)) {
					JOptionPane.showMessageDialog(null, "올바른 이메일주소가 아닙니다");
					return;
				}

				if (view.upPanel.isDup) {
					if (control.createUser(id, pw, email)) {
						JOptionPane.showMessageDialog(null, "회원가입 성공");
						view.change("signin");
					} else {
						JOptionPane.showMessageDialog(null, "예상치 못한 문제가 발생했습니다");
					}
				} else {
					JOptionPane.showMessageDialog(null, "ID 중복확인을 해주세요");
				}
			}
		});

		view.upPanel.backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.change("signin");
			}
		});
	}
	
	private boolean emailMatch(String email) {
		String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		if (m.matches()) {
			return true;
		}
		return false;
	}
}
