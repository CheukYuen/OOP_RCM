package rcm.ui;

import javax.swing.*;

import rcm3.model.*;

import java.awt.Color;


public class MainView extends JFrame  {
	
	//private String viewName;
	private AddItemPanel addItem;
	private PayView pay;
	private ConsoleView display;
	private SelfView showSelf;
	private ClockView clock;
	private TypeMapView rcmMapView;

	private Machine rcm;
	private static final long serialVersionUID = 1L;
	

	public MainView( String viewName ) throws Throwable{
		
		super(viewName);
		super.setSize(700,550);
		
		
		rcm = new Machine();
		
		//consoleView
		display = new ConsoleView();
		display.setSize(517, 254);
		display.setLocation(2,262);
		getContentPane().add(display);
		
		//payView
		pay = new PayView( rcm,display );
		pay.setBounds(529, 43, 151, 208);
		getContentPane().add(pay);
		
		
		
		//clockView 
		
		clock= new ClockView();
		clock.setBackground(Color.WHITE);
		//clock.setSize(507, 196);
		clock.setBounds(530, 10, 150, 32);
		//clock.setTextClock("hello world");
		getContentPane().add(clock);
		
		// addItemView
		addItem = new AddItemPanel( rcm, display, pay );
		addItem.setBounds(12, 43, 507, 208);
		getContentPane().add(addItem);
		
		//selfView
		showSelf = new SelfView( rcm );
		showSelf.setBounds(12, 10, 507, 32);
		getContentPane().add(showSelf);
		
		//TypeMapView
		rcmMapView = new TypeMapView(rcm );
		rcmMapView.setBackground(Color.PINK);
		rcmMapView.setBounds(529, 262, 151, 254);
		//rcmMapView.setEnabled(false);
		getContentPane().add(rcmMapView);
		
		
		getContentPane().setLayout(null);
		
		if (rcm.getMachineID()=="0.0"){
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public ClockView getClockView(){
		
		return this.clock;
	}
	
	public Machine getCurRCM(){
		
		return this.rcm;
	}

}