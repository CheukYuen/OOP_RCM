package rmos.ui;

import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;



public class PieChartView2 extends JPanel implements Observer {

	private List test_num = new ArrayList();
	
	
	

	// Map of Colors for drawing pie chart wedges
	private Map colors = new HashMap();

	// Set of observed Accounts


	private ItemForPie test_num_1;
	private ItemForPie test_num_2;
	private ItemForPie test_num_3;
	private ItemForPie test_num_4;
	private ItemForPie test_num_5;
	
	private int total_num;
	double glassSum ;
	double paperSum;
	double eleSum ;
	double aluSum;
	double plaSum ;
	
	public PieChartView2() {

		super.setSize(700, 550);
		
		int infoMachineID = MachineInfo.getInfoMachineID();
		try {
			double glassSum = MachineTable.getGlass(infoMachineID);
			test_num_1 = new ItemForPie("Glass", glassSum );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			double paperSum = MachineTable.getPaper(infoMachineID);
			test_num_3 = new ItemForPie("Paper", paperSum);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			double eleSum = MachineTable.getEle(infoMachineID);
			
			test_num_4 = new ItemForPie("Electro", eleSum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			double aluSum = MachineTable.getAluminum(infoMachineID);
			
			test_num_2 = new ItemForPie("Alu", aluSum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			double plaSum = MachineTable.getPlastic(infoMachineID);
			test_num_5 = new ItemForPie("Plastic", plaSum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//double glassSum = plaSum;

		
		
		
		

//		test_num_1 = new Account("Glass", 10.0);
//		test_num_2 = new Account("Alu", 10.0);
//		test_num_3 = new Account("Paper", 20.0);
//		test_num_4 = new Account("Electro", 30.0);
//		test_num_4 = new Account("Plastic", 30.0);

		// this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.addItem(test_num_1);
		this.addItem(test_num_2);
		this.addItem(test_num_3);
		this.addItem(test_num_4);
		this.addItem(test_num_5);

		// this.setLayout(new FlowLayout());
		// this.setLayout(new AbsoluteLayout());
		System.out.println(" hello world 5 ");
	}

	/*
	 * public int getTotal_num(){
	 * 
	 * total_num=test_num_1.getItemNum()+test_num_2.getItemNum()+test_num_3.
	 * getItemNum()+test_num_4.getItemNum(); return total_num;
	 * 
	 * }
	 */

	// add Account to pie chart view
	public void addItem(ItemForPie test_num_12) {

		// add ItemForPie to accounts Vector
		test_num.add(test_num_12);

		// add Color to Hashtable for drawing ItemForPie's wedge
		colors.put(test_num_12, getRandomColor());

		// register as Observer to receive ItemForPie updates
		test_num_12.addObserver(this);

		// update display with new ItemForPie information
		repaint();
	}

	// remove ItemForPie from pie chart view
	public void removeItem(ItemForPie test_num_i) {
		// stop receiving updates from given ItemForPie
		test_num_i.deleteObserver(this);

		// remove ItemForPie from accounts Vector
		test_num.remove(test_num_i);

		// remove ItemForPie's Color from Hashtable
		colors.remove(test_num_i);

		// update display to remove ItemForPie information
		repaint();
	}

	// draw ItemForPie balances in a pie chart
	public void paintComponent(Graphics g) {
		// ensure proper painting sequence
		super.paintComponent(g);

		// draw pie chart
		drawPieChart(g);

		// draw legend to describe pie chart wedges
		drawLegend(g);
	}

	// draw pie chart on given Graphics context
	private void drawPieChart(Graphics g) {
		// get combined ItemForPie balance

		double totalBalance = 70.0;
		// create temporary variables for pie chart calculations
		double percentage = 0.0;
		int startAngle = 0;
		int arcAngle = 0;

		Iterator itemIterator = test_num.iterator();
		ItemForPie curItem = null;

		// draw pie wedge for each ItemForPie
		while (itemIterator.hasNext()) {

			// get next ItemForPie from Iterator
			curItem = (ItemForPie) itemIterator.next();

			// draw wedges only for included ItemForPies
			if (!includeItemForPieInChart(curItem))
				continue;

			// get percentage of total balance held in ItemForPie
			percentage = curItem.getBalance() / totalBalance;

			// calculate arc angle for percentage
			arcAngle = (int) Math.round(percentage * 360);

			// set drawing Color for ItemForPie pie wedge
			g.setColor((Color) colors.get(curItem));

			// draw ItemForPie pie wedge
			g.fillArc(5, 5, 100, 100, startAngle, arcAngle);

			// calculate startAngle for next pie wedge
			startAngle += arcAngle;
		}
	} // end method drawPieChart

	// draw pie chart legend on given Graphics context
	private void drawLegend(Graphics g) {
		Iterator itemIterator = test_num.iterator();
		ItemForPie curItem = null;

		// create Font for ItemForPie name
		Font font = new Font("SansSerif", Font.BOLD, 12);
		g.setFont(font);

		// get FontMetrics for calculating offsets and
		// positioning descriptions
		FontMetrics metrics = getFontMetrics(font);
		int ascent = metrics.getMaxAscent();
		int offsetY = ascent + 2;

		// draw description for each ItemForPie
		for (int i = 1; itemIterator.hasNext(); i++) {

			// get next ItemForPie from Iterator
			curItem = (ItemForPie) itemIterator.next();

			// draw ItemForPie color swatch at next offset
			g.setColor((Color) colors.get(curItem));
			g.fillRect(125, offsetY * i, ascent, ascent);

			// draw ItemForPie name next to color swatch
			g.setColor(Color.black);
			g.drawString(curItem.getName(), 140, offsetY * i + ascent);
		}
	} // end method drawLegend

	// return true if given ItemForPie should be included in
	// pie chart
	protected boolean includeItemForPieInChart(ItemForPie curItem) {
		// include only Asset accounts (ItemForPies with positive
		// balances)
		return curItem.getBalance() > 0.0;
	}

	// get a random Color for drawing pie wedges
	private Color getRandomColor() {
		// calculate random red, green and blue values
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);

		// return newly created Color
		return new Color(red, green, blue);
	}

	// receive updates from Observable ItemForPie
	public void update(Observable observable, Object object) {
		repaint();
	}

	// get ItemForPieBarGraphView's preferred size

	public Dimension getPreferredSize() {
		return new Dimension(210, 110);
	}

	// get ItemForPieBarGraphView's preferred size
	/*
	 * public Dimension getMinimumSize() { return getPreferredSize(); }
	 * 
	 * // get ItemForPieBarGraphView's preferred size public Dimension
	 * getMaximumSize() { return getPreferredSize(); }
	 */

}
