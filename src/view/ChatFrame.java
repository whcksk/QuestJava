package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ChatFrame extends JFrame{
	public JTextField msg;
	public JLabel time;
	public JButton send, close;
	public JScrollPane scroll;
	public JTable chat;
	public DefaultTableModel model;
	public ChatFrame() {
		setSize(515, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(0, 0, 503, 25);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		time = new JLabel("");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setForeground(new Color(245, 245, 245));
		time.setBounds(352, 0, 151, 25);
		panel.add(time);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 314, 503, 44);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		send = new JButton("전송");
		send.setForeground(Color.WHITE);
		send.setBackground(Color.DARK_GRAY);
		send.setBounds(335, 10, 72, 23);
		panel_1.add(send);
		
		close = new JButton("닫기");
		close.setForeground(Color.WHITE);
		close.setBackground(Color.DARK_GRAY);
		close.setBounds(419, 10, 72, 23);
		panel_1.add(close);
		
		msg = new JTextField();
		msg.setBounds(12, 11, 311, 21);
		panel_1.add(msg);
		msg.setColumns(10);
		
		scroll = new JScrollPane();
		scroll.setBackground(Color.WHITE);
		scroll.setBounds(0, 24, 500, 290);
		getContentPane().add(scroll);
		
		chat = new JTable();
		chat.setRowSelectionAllowed(false);
		chat.setShowVerticalLines(false);
		chat.setShowHorizontalLines(false);
		chat.setShowGrid(false);
		chat.getTableHeader().setUI(null);
		chat.setEnabled(false);
		scroll.setViewportView(chat);
		
		String[] cols = new String[] {"u", "m"};
		Object[][] data = new Object[0][];
		model = new DefaultTableModel(data, cols);
		
		chat.setModel(model);
		
		DefaultTableCellRenderer renderer1 = new DefaultTableCellRenderer();
		renderer1.setHorizontalAlignment( JLabel.RIGHT );
		chat.getColumn("m").setCellRenderer( renderer1 );
		
		DefaultTableCellRenderer renderer2 = new DefaultTableCellRenderer();
		renderer2.setHorizontalAlignment( JLabel.LEFT );
		chat.getColumn("u").setCellRenderer( renderer2 );
		
	}
	public void createGui() {
		setVisible(true);
	}
	public static void main(String[] args) {
		new ChatFrame().createGui();
	}
}




