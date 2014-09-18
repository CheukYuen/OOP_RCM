package rcm.ui;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rcm3.database.DealTable;
import rcm3.model.*;
import rmos.ui.AddMachine;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

public class PayView extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBoxPayment;
	private JLabel lblPayment;
	private JButton btnPay;
	private JTextField textPriceForCoupon;
	
	private Machine localRCM;
	private ConsoleView displayView;
	

	
	public PayView( Machine rcm, ConsoleView display ){
		
		setBackground(Color.GREEN);
		
		
		//this.setEnabled(false);
		
		localRCM = rcm;
		displayView = display;
		
		comboBoxPayment = new JComboBox<String>();
		comboBoxPayment.addItem("");
		comboBoxPayment.addItem("Cash");
		comboBoxPayment.addItem("Cash+Coupon");
		comboBoxPayment.addItem("Coupon");
		setLayout(null);
				
		comboBoxPayment.setBounds(20, 34, 122, 20);
		comboBoxPayment.setEnabled(false);
		comboBoxPayment.addActionListener(this);
		comboBoxPayment.setActionCommand("PAYMENT");
		this.add(comboBoxPayment);
		
		lblPayment = new JLabel("Paid");
		lblPayment.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPayment.setBounds(20, 11, 104, 14);
		this.add(lblPayment);
		
		btnPay = new JButton("PAY");
		btnPay.setEnabled(false);
		btnPay.setBounds(20, 154, 122, 23);
		btnPay.setActionCommand("PAY");
		btnPay.addActionListener(this);
		this.add(btnPay);
		
		textPriceForCoupon = new JTextField();
		textPriceForCoupon.setHorizontalAlignment(SwingConstants.LEFT);
		textPriceForCoupon.setBounds(20, 97, 122, 20);
		this.add(textPriceForCoupon);
		//textPriceForCoupon.setEnabled(false);
		textPriceForCoupon.setEditable(false);
		textPriceForCoupon.setText(""+0.0);	
		textPriceForCoupon.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(" Paid by Coupon");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(20, 72, 104, 14);
		add(lblNewLabel);
		
	}
	
	public void setcomboBoxPayment( boolean isEnable ){
		
		comboBoxPayment.setEnabled( isEnable );
	}
	
	public void settextPriceForCoupon( boolean isEditable ){
		
		textPriceForCoupon.setEditable(isEditable );
	}
	
	public void setbtnPay( boolean isEnable ){
		
		btnPay.setEnabled(isEnable);
	}
	
	//Perform Action
	public void actionPerformed( ActionEvent event ){
		
		String cmd = event.getActionCommand();
		
		if(cmd.equals("PAYMENT")){
			
			int paymentIndex = comboBoxPayment.getSelectedIndex();
			
			if(paymentIndex == 2){
				
				textPriceForCoupon.setEditable(true);	
				
			}else{
				
				textPriceForCoupon.setText("0.0");
				textPriceForCoupon.setEditable(false);
			}	
		}
		
		
		if(cmd.equals("PAY")){
			
			double totalPrice = Machine.priceofRCMItem;
			int memberID = AddMachine.getOpenMachineID();
			try {
				DealTable.updateTableCash(totalPrice, memberID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			int paymentIndex;
			double priceofNewItems;
			double itemPriceForCoupon;
			String payBack=null;
			boolean flagIndex=false;
			
			//comboBoxPayment.setEnabled(true);
			paymentIndex = comboBoxPayment.getSelectedIndex();
				
			priceofNewItems= localRCM.priceofArrayRCMItems(localRCM.getSessionItemCnt());
			System.out.println("\nitem_cnt: "+localRCM.getSessionItemCnt()+"\npriceofNewItems: "+priceofNewItems);
			

			if (paymentIndex ==2 ){
				
				//double itemPriceforCoupon=Double.parseDouble(textPriceForCoupon.getText());
				itemPriceForCoupon = Double.parseDouble(textPriceForCoupon.getText());	
				
				if(itemPriceForCoupon>priceofNewItems){
					
					JOptionPane.showMessageDialog( null," The price paid by coupon exceeds the total price of items, please enter an accepted value." );
					flagIndex=true;
					
				}else{
					
					payBack=localRCM.updateRCMCash(priceofNewItems,itemPriceForCoupon,paymentIndex);
					textPriceForCoupon.setText("0.0");
					
				}
				
			}else{
				
				payBack=localRCM.updateRCMCash(priceofNewItems,0.0,paymentIndex);
				textPriceForCoupon.setText("0.0");
				//textPriceForCoupon.setEnabled(false);
				//textPriceForCoupon.setText(""+0.0);		
			}
			
			displayView.displayTextInConsole(payBack);
			
			if(flagIndex){
				
				this.setbtnPay(true);
				this.setcomboBoxPayment(true);
				this.settextPriceForCoupon(true);
				
			}else{
			
				this.setbtnPay(false);
				this.setcomboBoxPayment(false);
				this.settextPriceForCoupon(false);
			
			}
			//System.out.println("\nitem_cnt: "+localRCM.getSessionItemCnt()+"\npriceofNewItems: "+priceofNewItems);
			//String payBack=localRCM.updateRCMCash(priceofNewItems, itemPriceForCoupon, paymentIndex);
			
			
		}//....
		
		
	}
}