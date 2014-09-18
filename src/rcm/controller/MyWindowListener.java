package rcm.controller;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Window;  
import java.awt.event.WindowEvent;  
import java.awt.event.WindowListener;  
import javax.swing.*;


public class MyWindowListener implements WindowListener  
{  
	
	private int rcmID;
	private ImageIcon image;
	private Machine localRCM;
	private JFrame f2;
	
	public MyWindowListener( Machine rcm ){
		
		localRCM=rcm;
		
		System.out.println("hello world 9");
		
		/*
		if(rcm.getMachineID()=="1.0"){
			
			rcmID=1;
		}
		
		if(rcm.getMachineID()=="2.0"){
			
			rcmID=2;
		}
		*/
		
	}
    @Override  
    public void windowActivated(WindowEvent e) {  
        // TODO Auto-generated method stub  
          
    }  
  
    @Override  
    public void windowClosed(WindowEvent e) {  
        // TODO Auto-generated method stub  
    	//System.out.println("“—æ≠πÿ±’¥∞ø⁄ 2! "); 
    }  
  
    @Override  
    public void windowClosing(WindowEvent e) {  
        // TODO Auto-generated method stub  
         e.getWindow().setVisible(false); 
        ((Window)e.getComponent()).dispose(); 
 
        System.out.println("hello world 11");
        
        f2=new JFrame("HAHA!");
        
        System.out.println("hello world 10");
         
        //f2.setVisible(true);
        //image = new ImageIcon ("haha1.jpg");
        
        if(localRCM.getMachineID()=="1"){
        	
        	image = new ImageIcon ("haha1.jpg");
        }
        
        if(localRCM.getMachineID()=="2.0" ){
        	
        	image = new ImageIcon ("septa.jpg");
        }
        
        if(localRCM.getMachineID()=="3.0" ){
        	
        	image = new ImageIcon ("septa.jpg");
        }
        
        JLabel imageLabel = new JLabel (image);
        
        JScrollPane sp = new JScrollPane (imageLabel);
        sp.setPreferredSize (new Dimension (800, 600));
        
        f2.getContentPane().add (sp);
        f2.setSize(500,600);
        //f2.pack();
        f2.setVisible(true);
        System.out.println("hello world2 ! "); 
        
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //System.exit(0);
    }  
  
    @Override  
    public void windowDeactivated(WindowEvent e) {  
        // TODO Auto-generated method stub  
          
    }  
  
    @Override  
    public void windowDeiconified(WindowEvent e) {  
        // TODO Auto-generated method stub  
          
    }  
  
    @Override  
    public void windowIconified(WindowEvent e) {  
        // TODO Auto-generated method stub  
          
    }  
  
    @Override  
    public void windowOpened(WindowEvent e) {  
        // TODO Auto-generated method stub  
          
    }  
  
}
