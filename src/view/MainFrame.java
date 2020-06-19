package view;

import java.awt.Color;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.Controller;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	static final int FRAMEWidth = 1000;
	static final int FRAMEHeight = 800;
	static final int CENTEREWidth = 994;
	static final int CENTERHeight = 691;
	public JPanel center;
	public HeaderPanel header;
	public SignInPanel signin;
	public CenterPanel current;
	private Stack<CenterPanel> prevPanels;

	public MainFrame() {
		prevPanels = new Stack<CenterPanel>();

		center = new JPanel();

		setSize(FRAMEWidth, FRAMEHeight);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		center = new JPanel();
		center.setSize(CENTEREWidth, CENTERHeight);
		center.setLayout(null);
		center.setLocation(0, 80);
		getContentPane().add(center);

		JPanel divide = new JPanel();
		divide.setBackground(new Color(65, 105, 225));
		divide.setBounds(0, 70, 994, 10);
		getContentPane().add(divide);
		header = new HeaderPanel();

		header.setBounds(0, 0, 994, 71);
		getContentPane().add(header);

		current = new BoardPanel();
		center.add(current);
	}

	public CenterPanel change(String name) {
		CenterPanel oldPane = (CenterPanel) center.getComponent(0);
		prevPanels.add(oldPane);
		center.remove(oldPane);

		if (name.equals("post")) {
			current = new PostPanel();
			center.add(current);
		} else if (name.equals("board")) {
			current = new BoardPanel();
			center.add(current);
		} else if (name.equals("writing")) {
			current = new WritingPanel();
			center.add(current);
		} else if (name.equals("userpage")) {
			current = new UserpagePanel();
			center.add(current);
		} else if (name.equals("calendar")) {
			current = new CalendarPanel();
			center.add(current);
		} else {
			JOptionPane.showMessageDialog(null, "없는 페이지입니다!");
			return null;
		}
		repaint();
		return current;
	}

	public CenterPanel getPrev() {
		if(prevPanels.isEmpty()) {
			return null;
		}
		return prevPanels.pop();
	}

	public void createGui() {
		setVisible(true);
	}

	public void turnAuthView(String id) {
		header.turnAuthView(id);
		current.turnAuthView(id);
		repaint();
	}
}
