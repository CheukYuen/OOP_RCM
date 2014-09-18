package rmos.ui;

import javax.swing.*;

import rmos.database.MachineTable;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MachineInfo extends JPanel implements ActionListener {
	
	
	final static double MAX_WEIGHT = 1000;

	private JTextField textAMachineID, textAStatus, textAAmount,
			textACurrentCapacity, textAAvailableCapacity, textAPaper,
			textAPlastic, textABattery, textAMetal, textAGlass, textATimeEmpty;

	private JLabel labelAmount, labelCCapacity, labelACapacity, labelPaper,
			labelPlastic, labelBattery, labelMetal, labelGlass, labelTimeEmpty,
			labelStatus;

	private JButton buttonConfirm;

	private static int infoMachineID;
	MainPanel mainPanel ;
	
	public static void main(String[] args) {
		MachineInfo main = new MachineInfo();
		System.out.println(infoMachineID);
		// SetMachine.addGridBagPanes();
		main.setVisible(true);
		// main.pack();
	}
	public static int getInfoMachineID() {
		return infoMachineID;
	}
	public MachineInfo() {
		super();
		super.setSize(500, 500);
		setBackground(Color.pink);
		textAMachineID = new JTextField("");
		buttonConfirm = new JButton("Input Machine ID");
		buttonConfirm.setActionCommand("showInfo");
		buttonConfirm.setToolTipText("Show machine information");
		buttonConfirm.addActionListener(this);
		textAStatus = new JTextField();
		labelStatus = new JLabel("Machine Status:");
		textAAmount = new JTextField();
		textACurrentCapacity = new JTextField();
		textAAvailableCapacity = new JTextField();
		textAGlass = new JTextField();
		textAPaper = new JTextField();
		textAPlastic = new JTextField();
		textABattery = new JTextField();
		textAMetal = new JTextField();

		textATimeEmpty = new JTextField();

		labelAmount = new JLabel("Amount of money in Machine:");
		labelAmount.setLabelFor(labelAmount);
		labelCCapacity = new JLabel("Current capacity:");

		labelACapacity = new JLabel("Availabel capacity:");
		labelGlass = new JLabel("Number of glass:");
		labelPaper = new JLabel("Number of paper:");
		labelPlastic = new JLabel("Number of plastic:");
		labelBattery = new JLabel("Number of electronics:");
		labelMetal = new JLabel("Number of aluminum:");

		labelTimeEmpty = new JLabel("Last time operated:");
		setGradLayout();
	}

	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();

		if (cmd.equals("showInfo")) {

			try {
				
	
				double cash = MachineTable.getCashSum(infoMachineID);
				String money = String.valueOf(cash);
				textAAmount.setText(money);
				
				double weight = MachineTable.getWeight(infoMachineID);
				String weightSum = String.valueOf(weight);
				textACurrentCapacity.setText(weightSum);
				
				double avaWeight = MAX_WEIGHT -  MachineTable.getWeight(infoMachineID);
				String avaWeightSum = String.valueOf(avaWeight);
				textAAvailableCapacity.setText(avaWeightSum);
				
				double glassSum = MachineTable.getGlass(infoMachineID);
				String glass = String.valueOf(glassSum);
				textAGlass.setText(glass);
				
				double paperSum = MachineTable.getPaper(infoMachineID);
				String paper = String.valueOf(paperSum);
				textAPaper.setText(paper);
				
				double eleSum = MachineTable.getEle(infoMachineID);
				String ele = String.valueOf(eleSum);
				textABattery.setText(ele);
				
				double aluSum = MachineTable.getAluminum(infoMachineID);
				String alu = String.valueOf(aluSum);
				textAMetal.setText(alu);
				
				double plaSum = MachineTable.getPlastic(infoMachineID);
				String pla = String.valueOf(plaSum);
				textAPlastic.setText(pla);
				
				String emptyTime = MachineTable.getTime(infoMachineID);
				textATimeEmpty.setText(emptyTime);
				
				
				int status = MachineTable.getStatus(infoMachineID);
								
				if (status ==0){
					textAStatus.setText("Inactive");
				}else{
					textAStatus.setText("Active");
				}
				
				
//				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//				java.util.Date emptyDate = MachineTable.getTime(infoMachineID);
//				String date = df.format(emptyDate);
//				textATimeEmpty.setText(date);
//				
				
				
				// double weight = MachineTable.getCashSum();
				// String money = String.valueOf(cash);
				// textAAmount.setText(money);

				String stringID = textAMachineID.getText();
				infoMachineID = Integer.parseInt(stringID);
				
				mainPanel = new MainPanel();
				mainPanel.setVisible(true);
			
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void setGradLayout() {
		this.setLayout(new GridLayout(11, 2));
		add(textAMachineID);
		add(buttonConfirm);
		add(labelStatus);
		add(textAStatus);
//		add(labelAmount);
//		add(textAAmount);
		add(labelCCapacity);
		add(textACurrentCapacity);
		add(labelACapacity);
		add(textAAvailableCapacity);
		add(labelGlass);
		add(textAGlass);
		add(labelPaper);
		add(textAPaper);
		add(labelPlastic);
		add(textAPlastic);
		add(labelBattery);
		add(textABattery);
		add(labelMetal);
		add(textAMetal);
		add(labelTimeEmpty);
		add(textATimeEmpty);
	}

}