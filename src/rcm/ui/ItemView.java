package rcm.ui;

import javax.swing.*;
import java.awt.ScrollPane;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;



public class ItemsView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTable table=null;
	private TableModel_2 model = null;
	private JScrollPane scrollPane;
	private Machine localRCM;
	
	public ItemsView( Machine rcm ) {

		
		localRCM = rcm;
		
		super.setSize(500, 500);
		getContentPane().setLayout(null);
		
		
		model = new TableModel_2(20);
		table = new JTable(model);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFillsViewportHeight(true);
		table.setBounds(87, 241, 253, -186);
		
		this.addData(localRCM);
		System.out.println("hello world in items3");
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 448, 318);
		getContentPane().add(scrollPane);
		

		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void addData( Machine rcm ) {
		
		int sizeofItemList = rcm.getRCMItemList().size();
		
		System.out.println("hello world in items4 sizeofItemList �����"+sizeofItemList);
		
		for(int i=0;i<sizeofItemList;i++) {
			
			String curItemName=rcm.getRCMItemList().get(i).getUserItemName();
			System.out.println("hello world in items4 curItemName �����"+curItemName);
			
			String curItemType=rcm.getRCMItemList().get(i).getRCMItemTypeName();
			//String curItemType="glass";
			System.out.println("hello world in items4 curItemType �����"+curItemType);
			
			String curItemWeight=""+rcm.getRCMItemList().get(i).getRCMItemWeight();
			System.out.println("hello world in items4 curItemWeight �����"+curItemWeight);
			
			String curItemPrice=""+rcm.getRCMItemList().get(i).getRCMItemPrice();
			System.out.println("hello world in items4 curItemPrice �����"+curItemPrice);
			
			System.out.println("sizeofItemList is: "+sizeofItemList+" index is: "+i+" curItemName is:"+ curItemName + " curItemType is: "+curItemType
					+ "curItemWeight is:" + curItemWeight+"curItemPrice is:"+curItemPrice );
			
			model.addRow(curItemName, curItemType,curItemWeight,curItemPrice);
			
		}
		
	}
	
    public void removeData() {
        model.removeRows(0, model.getRowCount());
        //table.updateUI();
    }
	
	
}


class TableModel_2 extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
    private Vector content = null;

    private String[] title_name = { "Name","Type","Weight(lbs)","Price(USD)" };
    
    public TableModel_2() {
    	
        content = new Vector();
    }

    public TableModel_2(int count) {
    	
        content = new Vector(count);
    }
    
    public void addRow(String name, String type , String weight, String price) {
    	
        Vector v = new Vector(4);   
        v.add(0,name);
        v.add(1,type);
        v.add(2,weight);
        v.add(3,price);
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
        ((Vector) content.get(row)).add(col,value);
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



