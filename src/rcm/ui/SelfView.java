package rcm.ui;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class SelfView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel lblRCMIdName,lblRCMLocationName,lblRCMId,lblRCMLocation;
	private Machine localRCM;
	
	public SelfView( Machine rcm ){
		setBackground(Color.MAGENTA);
		
		setLayout(null);
		
		localRCM = rcm;
		
		lblRCMId = new JLabel("RCM ID :");
		lblRCMId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRCMId.setBounds(10, 11, 61, 14);
		this.add(lblRCMId);
		
		lblRCMIdName = new JLabel();
		lblRCMIdName.setText(localRCM.getMachineID());
		lblRCMIdName.setBounds(72, 7, 85, 22);
		this.add(lblRCMIdName);
		
		lblRCMLocation = new JLabel("LOCATION :");
		lblRCMLocation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRCMLocation.setBounds(185, 11, 85, 14);
		add(lblRCMLocation);

		lblRCMLocationName = new JLabel();
		lblRCMLocationName.setText(localRCM.getMachineLocation());
		lblRCMLocationName.setBounds(266, 6, 144, 24);
		this.add(lblRCMLocationName);
			
	}

}
