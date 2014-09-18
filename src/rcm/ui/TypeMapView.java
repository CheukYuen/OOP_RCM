package rcm.ui;

import javax.swing.*;

import java.awt.Font;
import java.awt.Color;
//import java.awt.ScrollPane;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
//import javax.swing.table.TableColumnModel;

import rcm3.model.*;

public class TypeMapView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable table = null;
	private TableModel model = null;
	private JButton btnTypeMap;
	private JScrollPane scrollInMapView;

	private Machine localRCM;

	public TypeMapView(Machine rcm) {

		localRCM = rcm;

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		btnTypeMap = new JButton("MapOpen");
		btnTypeMap
				.setToolTipText("Display in-built price table of acceptable itemtype in rcm .");
		btnTypeMap.setBackground(Color.WHITE);
		btnTypeMap.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTypeMap.setBounds(10, 11, 131, 23);
		btnTypeMap.addActionListener(this);
		this.add(btnTypeMap);

		// btnTypeMap.setEnabled(false);

		model = new TableModel(20);

		table = new JTable(model);
		table.setBackground(Color.WHITE);
		table.setBounds(-27, 182, 288, -317);
		table.setVisible(false);

		scrollInMapView = new JScrollPane(table);
		scrollInMapView.setBounds(10, 57, 131, 189);
		this.add(scrollInMapView);

		if (localRCM.getMachineStatus() == 0) {

			btnTypeMap.setEnabled(false);

		} else {

			btnTypeMap.setEnabled(true);
		}

	}

	public void addData(Machine rcm) {

		int sizeofMap = rcm.getItemMap().getAmountofMapEntries();
		// int sizeofMap=rcm.getItemMap().getItemMap().size();

		for (int i = 0; i < sizeofMap; i++) {

			Map.Entry<ItemType, String> curEntry = rcm.getItemMap()
					.getEntryofMap(i);

			String curEntryKey = curEntry.getKey().toString();
			String curEntryValue = curEntry.getValue();

			System.out.println("sizeofMap is: " + sizeofMap + " index is: " + i
					+ " curEntryKey is:" + curEntryKey + " curEntryValue is: "
					+ curEntryValue);

			model.addRow(curEntryKey, curEntryValue);
		}

	}

	public void removeData() {
		model.removeRows(0, model.getRowCount());
		table.updateUI();
	}

	// Perform Action
	public void actionPerformed(ActionEvent event) {

		String cmd = event.getActionCommand();

		if (cmd.equals("MapOpen")) {

			btnTypeMap.setText("MapClosed");

			this.addData(localRCM);
			table.setVisible(true);

		}

		if (cmd.equals("MapClosed")) {

			btnTypeMap.setText("MapOpen");
			// table.removeAll();
			this.removeData();
			table.setVisible(false);
		}

	}

}

class TableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private Vector content = null;

	private String[] title_name = { "Type", "Price(bylb)" };

	public TableModel() {

		content = new Vector();
	}

	public TableModel(int count) {

		content = new Vector(count);
	}

	public void addRow(String type, String price) {

		Vector v = new Vector(2);
		v.add(0, type);
		v.add(1, price);
		content.add(v);
	}

	public int getColumnCount() {
		return title_name.length;
	}

	public int getRowCount() {
		return content.size();
	}

	public Object getValueAt(int row, int col) {

		return ((Vector) content.get(row)).get(col);
	}

	public void setValueAt(Object value, int row, int col) {
		((Vector) content.get(row)).remove(col);
		((Vector) content.get(row)).add(col, value);
		this.fireTableCellUpdated(row, col);
	}

	public String getColumnName(int col) {
		return title_name[col];
	}

	public void removeRows(int row, int count) {
		for (int i = 0; i < count; i++) {
			if (content.size() > row) {
				content.remove(row);
			}
		}
	}

}