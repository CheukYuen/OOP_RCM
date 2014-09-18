package rmos.ui;

import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class AddMachine extends JPanel implements ActionListener {

	private JButton confirmAdd, confirmRemove, confirmOpen;
	private JTextField machineLocation, machineId;
	private JTextField addLocation, addID, textFieldremoveID, textFieldOpenID;
	private JLabel labelAddID, labelAddLocation, labelRemoveID,
			labelRemoveLocation;
	private static int openMachineID;
	private static int addMachineID, removeMachineID;
	private static String addMachineLoc;

	// protected static final String textFieldA

	public AddMachine() {
		super();
		super.setSize(200, 1000);
		setBackground(Color.cyan);

		confirmOpen = new JButton("Open Machine by ID");
		confirmOpen.setActionCommand("open");
		confirmOpen.addActionListener(this);

		addID = new JTextField();
		addLocation = new JTextField();
		textFieldOpenID = new JTextField();
		textFieldremoveID = new JTextField();

		labelAddID = new JLabel("Add Machine Input ID: ");
		labelAddID.setLabelFor(addID);

		labelAddLocation = new JLabel("Input location : ");
		labelAddID.setLabelFor(addLocation);

		// labelRemoveID = new JLabel("Open Machine by ID: ");
		// labelAddID.setLabelFor(removeID);

		labelRemoveLocation = new JLabel("");
		labelAddID.setLabelFor(textFieldremoveID);
		
		confirmAdd = new JButton("Add Machine");
		confirmAdd.setActionCommand("addMachine");
		confirmAdd.setToolTipText("Add a new machine");
		confirmAdd.addActionListener(this);
		
		
		confirmRemove = new JButton("Remove Machine by ID");
		confirmRemove.setActionCommand("removeMachine");
		confirmRemove.setToolTipText("Remove a machine");
		confirmRemove.addActionListener(this);
		
		
		setGridLayout();
	}

	private void setGridLayout() {
		this.setLayout(new GridLayout(2, 5));
		add(labelAddID);
		add(addID);

		add(labelAddLocation);
		add(addLocation);
		add(confirmAdd);

		add(textFieldOpenID);// text field
		add(confirmOpen);

		add(labelRemoveLocation);
		add(textFieldremoveID);
		add(confirmRemove);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if (cmd.equals("open")) {

			String stringID = textFieldOpenID.getText();
			setOpenMachineID(Integer.parseInt(stringID));

			MainView main_panel = null;
			try {
				main_panel = new MainView(" Recycling Machine ");
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			main_panel.setVisible(true);

			ClockView clock_1 = main_panel.getClockView();
			clock_1.setVisible(true);

			Thread thread1 = new Thread(clock_1);
			thread1.start();

		} else if (cmd.equals("addMachine")) {
			
			String stringAddID = addID.getText();
			//setAddMachineID(Integer.parseInt(stringAddID));
			addMachineID = Integer.parseInt(stringAddID);
			setAddMachineLoc(addLocation.getText());
//			String addMachineLocation = addLocation.getText();
//			System.out.print(addMachineLoc);
//			System.out.print(addMachineLoc);
			try {
				InsertMachine.insertMachine(addMachineID, addMachineLoc);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}else if(cmd.equals("removeMachine")){
			String stringRemoveID = textFieldremoveID.getText();
			removeMachineID = Integer.parseInt(stringRemoveID);
			try {
				InsertMachine.deleteMachine(removeMachineID);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

	public static int getOpenMachineID() {
		return openMachineID;
	}

	public static void setOpenMachineID(int openMachineID) {
		AddMachine.openMachineID = openMachineID;
	}

	public static int getAddMachineID() {
		return addMachineID;
	}

	public static void setAddMachineID(int addMachineID) {
		AddMachine.addMachineID = addMachineID;
	}

	public static String getAddMachineLoc() {
		return addMachineLoc;
	}

	public static void setAddMachineLoc(String addMachineLoc) {
		AddMachine.addMachineLoc = addMachineLoc;
	}

}
