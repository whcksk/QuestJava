package view;

import javax.swing.JFrame;

public class SignFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	public SignInPanel inPanel;
	public SignUpPanel upPanel;
	public SignFrame(String log){
		inPanel = new SignInPanel();
		upPanel = new SignUpPanel();
		
		setSize(355, 329);
		change(log);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void change(String log) {
		if(log == "signin") {
			
			try {
				remove(upPanel);
			} catch (Exception e) {	}
			
			add(inPanel);
		} else if(log == "signup") {
			
			try {
				remove(inPanel);
			} catch (Exception e) {	}
			add(upPanel);
		} else {
			System.out.println("SignFrame: Wrong Param");
			return;
		}
		repaint();
	}
}
