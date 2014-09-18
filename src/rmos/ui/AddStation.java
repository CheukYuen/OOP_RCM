package rmos.ui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class AddStation extends JPanel implements ActionListener{
	
	private JButton addButton;
	private JRadioButton active, inActive;
	private JTextField addStation, showActive;
	private JLabel labelAddStation;
	
	
	public AddStation(){
		super();
		super.setSize(100, 1000);
		setBackground(Color.orange);
		
		
		addButton = new JButton("confirm");
		addButton.setActionCommand("welcome");
		addButton.addActionListener(this);
		
		
		active = new JRadioButton("Active");
		inActive = new JRadioButton("Inactive");
		addStation = new JTextField();
		showActive = new JTextField();
		
		
		labelAddStation = new JLabel("Add station: ");
		labelAddStation.setLabelFor(addStation);
		
		setGridLayout();						
	}
	
	private void setGridLayout()
	{
		this.setLayout(new GridLayout(2,3));
		add(addStation);
		//add();
		add(labelAddStation);
		add(addButton);
		add(addStation);
		
		
		//active.setEnabled(false);
		
//		add(active);
//		add(inActive);
//		add(showActive);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand();
		if(cmd.equals("welcome")){
			addStation.setText("Welcome to RMOS!!  =)");
			
			
			
			
		}
		// TODO Auto-generated method stub
		
	}
	
	

}
