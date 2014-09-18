package rmos.ui;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.border.*;
import javax.swing.*;



public class MainPanel extends JFrame {
	
	
	
	public MainPanel(){
		
		super( "Item Statics" );
		
		super.setSize(700,550);
		
		JPanel pieChartPanel = new JPanel();
		
		//System.out.println(" hello world 1 ");
		
		pieChartPanel.setBorder( new TitledBorder( "Item" ) );
		
		PieChartView2 pieChart_2 = new PieChartView2();
		
		System.out.println(" hello world 2 ");
		
		pieChartPanel.add( pieChart_2 );
		
		System.out.println(" hello world 3 ");
		
		//item item_1 = new item ( 10, "jerry");
		
		//pieChart_2.addItem(item_1);
		
		//getContentPane().add(pieChart_2);
		
		
		
		//Account account1 = new Account( "Account 1", 1000.00 );
		//Account account2 = new Account( "Account 2", 3000.00 );
	
		//AssetPieChartView assetPieChart_2 = new AssetPieChartView();
		//AssetPieChartView pieChartView = new AssetPieChartView();
		 	
		//pieChartView.addAccount(account1);
		//pieChartView.addAccount(account2);
	
		//pieChartPanel.add( pieChartView );
		
		
		
		getContentPane().add(pieChartPanel);		
		getContentPane().setLayout(new GridLayout( 3, 1 ));// key statement
		
		
	    //Container contentPane = getContentPane();
	    //contentPane.setLayout( new GridLayout( 3, 1 ) );
	    //contentPane.add( pieChartPanel );
	    //setSize( 425, 450 );
	    
	}
	
	public static void main( String args[] )
	{
		   
		
		MainPanel main_panel = new MainPanel();
		
		main_panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		main_panel.setVisible(true);
		   
	}

}