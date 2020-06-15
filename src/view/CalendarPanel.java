package view;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CalendarPanel extends CenterPanel{
	private static final long serialVersionUID = 1L;
	public JTable[] table;
	public DefaultTableModel[] model;
	public JPanel grid;
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
	}

	@Override
	public void turnAuthView(String id) {
		
	}
}
