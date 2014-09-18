package rmos.ui;

import javax.swing.*;

import rmos.database.MachineTable;
import rmos.database.SetTable;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class SetMachine extends JPanel implements ActionListener {

	private JLabel labelMachineID, labelUpdate, labeMachineLocation,
			labelGlass, labelPaper, labelPlastic, labelEle, labelAlu;
	private JTextField textFieldMachineID;
	private JTextField textFieldLocation;
	private JButton buttonUpdate, buttonConfirm, buttonAddItem, buttonGlass,
			buttonPaper, buttonPlastic, buttonEle, buttonAlu;
	private JButton buttonActive, buttonInActive;
	private JTextField fieldPaper, fieldPlastic, fieldBattery, fieldMetal,
			fieldGlass;
	private JCheckBox checkGlass, checkPaper, checkPlastic, checkBattery,
			checkMetal;

	private static int infoMachineID, setGlassPrice, setPaperPrice,
			setPlasticPrice, setElePrice, setAluPrice;

	public static int getInfoMachineID() {
		return infoMachineID;
	}

	//
	// public static void main(String[] args) {
	// SetMachine main = new SetMachine();
	// // SetMachine.addGridBagPanes();
	// main.setVisible(true);
	// main.pack();
	//
	// }

	public SetMachine() {
		super();
		super.setSize(400, 500);
		setBackground(Color.green);

		
		labelEle = new JLabel("Item Electronics is inactive!");
	    labelAlu = new JLabel ("Item Aluminum is is inactive!");
	    
	    
	    buttonEle = new JButton("Add item Electronics($8.0)"); 
	    buttonEle.setActionCommand("addEle");
	    buttonEle.addActionListener(this);
		
		
	    buttonAlu = new JButton("Add item Aluminum($5.0)");
	    buttonAlu.setActionCommand("addAlu");
	    buttonAlu.addActionListener(this);
	    
		// labelMachineID = new JLabel("Machine ID:");
		// labelMachineID.setLabelFor(textFieldMachineID);
		buttonGlass = new JButton("Update glass price($)");
		buttonGlass.setActionCommand("updateGlass");
		buttonGlass.addActionListener(this);

		buttonPaper = new JButton("Update paper price($)");
		buttonPaper.setActionCommand("updatePaper");
		buttonPaper.addActionListener(this);

		buttonPlastic = new JButton("Update plastic price($)");
		buttonPlastic.setActionCommand("updatePlastic");
		buttonPlastic.addActionListener(this);

		textFieldMachineID = new JTextField("");
		buttonUpdate = new JButton("update");
		buttonUpdate.setActionCommand("update");
		buttonUpdate.addActionListener(this);

		buttonConfirm = new JButton("Input Machine ID");
		buttonConfirm.setActionCommand("confirmID");
		buttonConfirm.addActionListener(this);

		textFieldLocation = new JTextField("");
		labeMachineLocation = new JLabel("Machine Locaiton: ");

		buttonActive = new JButton("Active this machine");
		buttonActive.setActionCommand("active");
		buttonActive.addActionListener(this);

		buttonInActive = new JButton("Inactive thid machine");
		buttonInActive.setActionCommand("inactive");
		buttonInActive.addActionListener(this);
		// checkGlass = new JCheckBox("Set glass price:($)");
		// checkPaper = new JCheckBox("Set paper price:($)");
		// checkPlastic = new JCheckBox("Set plastic price:($)");
		labelGlass = new JLabel("Set glass price:($)");
		labelPaper = new JLabel("Set paper price:($)");
		labelPlastic = new JLabel("Set plastic price:($)");

		checkBattery = new JCheckBox("Add electronics price:($4.0)");
		checkMetal = new JCheckBox("Add aluminum price: ($5.0)");

		// checkGlass.setEnabled(false);
		// checkPaper.setEnabled(false);

		fieldGlass = new JTextField("");
		fieldPaper = new JTextField("");
		fieldPlastic = new JTextField("");
		fieldBattery = new JTextField("");
		fieldMetal = new JTextField("");

		buttonUpdate = new JButton("Update Price");
		// labelUpdate = new JLabel("click to update");
		buttonAddItem = new JButton("Add Item");

		setGradLayout();

	}

	private void setGradLayout() {
		this.setLayout(new GridLayout(10, 2));
		// add(labelMachineID);
		add(textFieldMachineID);
		add(buttonConfirm);
		add(labeMachineLocation);
		add(textFieldLocation);
		// add(buttonConfirm);
		// add(radioActive);
		// add(radioInActive);
		add(buttonActive);
		add(buttonInActive);
		// add(checkGlass);
		// add(labelGlass);
		add(fieldGlass);
		add(buttonGlass);
		// add(checkPaper);
		// add(labelPaper);
		add(fieldPaper);
		add(buttonPaper);
		// add(checkPlastic);
		// add(labelPlastic);
		add(fieldPlastic);
		add(buttonPlastic);

//		add(checkBattery);
//		add(fieldBattery);
		add(labelEle);
		add(buttonEle);
//		add(checkMetal);
//		add(fieldMetal);
		add(labelAlu);
		add(buttonAlu);
//		add(buttonAddItem);
//		add(buttonUpdate);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub

		String cmd = event.getActionCommand();
		if (cmd.equals("active")) {
			try {
				SetTable.setStatusToActive(infoMachineID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// fieldGlass.setEnabled(true);
			// fieldPaper.setText("asdasd");
			textFieldLocation.setEnabled(true);
			labeMachineLocation.setEnabled(true);

		} else if (cmd.equals("inactive")) {
			try {
				SetTable.setStatusToInactive(infoMachineID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			textFieldLocation.setEnabled(false);
			labeMachineLocation.setEnabled(false);
		} else if (cmd.equals("confirmID")) {
			labelEle.setText("Set Item Electronics");
			labelAlu.setText("Set Item Aluminum");
			
			try {
				String stringID = textFieldMachineID.getText();
				infoMachineID = Integer.parseInt(stringID);
				String location = MachineTable.getLocation(infoMachineID);
				textFieldLocation.setText(location);
				
//				buttonEle.setText("Add electronics price:($4.0)");
				
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (cmd.equals("updateGlass")) {
			String priceGlassString = fieldGlass.getText();
			 double glassPrice = Double.valueOf(priceGlassString);
			try {
				SetTable.setGlassPrice(infoMachineID, glassPrice);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("updatePaper")){
			String pricePaperString = fieldPaper.getText();
			double paperPrice = Double.valueOf(pricePaperString);
			try {
				SetTable.setPaperPrice(infoMachineID, paperPrice);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("updatePlastic")){
			String pricePlasticString = fieldPlastic.getText();
			double plasticPrice = Double.valueOf(pricePlasticString);
			try {
				SetTable.setPlasticPrice(infoMachineID, plasticPrice);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (cmd.equals("addEle")){
			labelEle.setText("active");
			try {
				SetTable.activeEle(infoMachineID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//SetTable
			
		}else if (cmd.equals("addAlu")){
			labelAlu.setText("active");
			try {
				SetTable.activeAlu(infoMachineID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//SetTable
			
		}

	}

}