package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class CalendarPanel extends CenterPanel{
	private static final long serialVersionUID = 1L;
	public JTable[] table;
	public DefaultTableModel[] model;
	public JPanel grid;
	public JLabel targetDate;
	public JButton btn_prev, btn_next;
	JButton[] button = new JButton[42];
	
	public CalendarPanel(){
		JScrollPane[] scrollPane = new JScrollPane[42];
		table = new JTable[42];
		
		setSize(MainFrame.CENTEREWidth, MainFrame.CENTERHeight);
		setLayout(null);
		
		JPanel divide = new JPanel();
		divide.setBackground(new Color(100, 149, 237));
		divide.setBounds(12, 45, 970, 4);
		add(divide);
		
		grid = new JPanel(new GridBagLayout());
		grid.setBounds(12, 57, 970, 624);
		grid.setBackground(Color.WHITE);
		
		String[] cols = new String[] {""};
		Object[][] data = new Object[0][];
		model = new DefaultTableModel[42];
		for (int i = 0; i < model.length; i++) {
			model[i] = new DefaultTableModel(data, cols);
		}
		
		for (int i = 0; i < table.length; i++) {
			table[i] = new JTable();
			table[i].setRowSelectionAllowed(false);
			table[i].setShowHorizontalLines(false);
			table[i].setShowVerticalLines(false);
			table[i].setShowGrid(false);
			table[i].setEnabled(false);
			table[i].setModel(model[i]);
			scrollPane[i] = new JScrollPane(table[i]);
			grid.add(scrollPane[i]);
		}
		
		for (int i = 0; i < model.length;) {
			for (int j = 0; j < 7; j++) {
				scrollPane[i].setBounds(138 * j, 104 * (i / 7), 138, 104);
				i++;
			}
		}
	
		add(grid);
		
		targetDate = new JLabel("이번 달");
		targetDate.setFont(new Font("D2", Font.BOLD, 15));
		targetDate.setHorizontalAlignment(SwingConstants.CENTER);
		targetDate.setBounds(399, 12, 179, 29);
		add(targetDate);
		
		btn_prev = new JButton("");
		btn_prev.setIcon(new ImageIcon("C:\\Users\\whcks\\Desktop\\eclipse\\workspace\\Qqqq\\src\\images\\leftArrow.png"));
		btn_prev.setBounds(305, 12, 80, 27);
		add(btn_prev);
		
		btn_next = new JButton("");
		btn_next.setIcon(new ImageIcon("C:\\Users\\whcks\\Desktop\\eclipse\\workspace\\Qqqq\\src\\images\\rightArrow.png"));
		btn_next.setBounds(601, 12, 80, 27);
		add(btn_next);
	}

	@Override
	public void turnAuthView(String id) {
		repaint();
	}
}
