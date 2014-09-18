package rmos.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.border.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;



public class RmosFrame extends JFrame {

	Container contentPane = this.getContentPane();
	AddMachine addMachPanel = new AddMachine();
	AddStation addStation = new AddStation();
	SetMachine setMachine = new SetMachine();
	MachineInfo machineInfo = new MachineInfo();
	MachineStatic machineStatic = new MachineStatic();
	
	
	//PieChartView2 pieChart_2 = new PieChartView2();

	public RmosFrame() {
		super("RmosApp");
		super.setSize(1000, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		// System.out.println(width);
		this.setSize(width / 2, height / 2);
		// center the mainFrame on screen
		this.setLocationRelativeTo(null);
		// contentPane.add(tabbedPane);
		this.setLayout(new GridBagLayout());
		//  1???add station
		addStation.setBorder(new TitledBorder("Add Station"));
		this.add(addStation,
				new GBC(0, 0, 2, 1).setFill(GBC.BOTH).setIpad(200, 50)
						.setWeight(100, 0));
		// 2??????MachPanel
		addMachPanel.setBorder(new TitledBorder("Add Machine"));
		this.add(addMachPanel,
				new GBC(0, 1, 2, 1).setFill(GBC.BOTH).setIpad(200, 50)
						.setWeight(100, 0));


		// ???3??????set Machine
		setMachine.setBorder(new TitledBorder("Set Machine"));
		this.add(setMachine, new GBC(0, 2).setFill(GBC.BOTH).setIpad(200, 90)
				.setWeight(0, 100));
		// ???3??????machine info
		machineInfo.setBorder(new TitledBorder("Machine Info"));
		this.add(machineInfo, new GBC(1, 2).setFill(GBC.BOTH));
		
		
		// bottom??? static
//		machineStatic.setBorder(new TitledBorder("Machine Static"));
//		this.add(machineStatic,
//				new GBC(0, 3, 2, 1).setFill(GBC.BOTH).setIpad(200, 20)
//						.setWeight(100, 0));
//		
		
		
//		pieChart_2.setBorder(new TitledBorder("Machine Static"));
//		this.add(pieChart_2,
//				new GBC(0, 3, 2, 1).setFill(GBC.BOTH).setIpad(200, 20)
//						.setWeight(100, 0));

		// contentPane.add(addStation);
		// contentPane.add(addMachPanel);
		// contentPane.add(setMachine);
		// contentPane.add(machineInfo);
		// contentPane.add(machineStatic);
		// //setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		// contentPane.setLayout(new GridLayout(5,1));
		this.pack();
		this.setVisible(true);

	}

	public static void main(String args[]) {

		RmosFrame rmosFrame = new RmosFrame();
		rmosFrame.setVisible(true);

	}

}