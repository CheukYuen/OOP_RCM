package rcm.ui;

import javax.swing.*;
import java.awt.Font;
import java.util.Calendar;
//import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Color;


public class ClockView extends JPanel implements Runnable {
//public class ClockView extends JPanel  {	
	
	private static final long serialVersionUID = 1L;
	private JTextField textClock;
	//private Calendar curCalendar;
	private int ONE_SECOND = 1000;
	
	public ClockView() {
		
		setLayout(null);
		
		textClock = new JTextField();
		textClock.setBackground(Color.WHITE);
		textClock.setFont(new Font("Tahoma", Font.BOLD, 11));
		textClock.setBounds(0, 0, 206, 30);
		textClock.setColumns(10);
		textClock.setEditable(false);
		this.add(textClock);
		//textClock.setText("hello");
		//textClock.setVisible(true);
	}
	
	public void setTextClock(String str ){
		
		textClock.setText(str);
	}

	
	public void run()
	{
		while(true)
		{
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			
			this.setTextClock(dateFormatter.format(Calendar.getInstance().getTime()));
			//textClock.setText(dateFormatter.format(Calendar.getInstance().getTime()));
			
			try
			{
				Thread.sleep(ONE_SECOND); 
			}
			catch(Exception e)
			{
				this.setTextClock("ERROR!!");
			}
		}	  
	 }
	 

}