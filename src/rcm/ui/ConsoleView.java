package rcm.ui;

import javax.swing.*;
import java.awt.ScrollPane;
import java.awt.Font;


public class ConsoleView extends JPanel  {

	private static final long serialVersionUID = 1L;
	
	private ScrollPane scroll;
	private JTextArea txtrConsole;
	
	
	public ConsoleView(){
		
		setLayout(null);
		
		scroll = new ScrollPane();
		scroll.setBounds(10, 10, 498, 233);
		
		
		this.add(scroll);
		
		txtrConsole = new JTextArea();
		txtrConsole.setTabSize(4);
		txtrConsole.setFont(new Font("Monospaced", Font.BOLD, 12));
		scroll.add(txtrConsole);
		txtrConsole.setBounds(20, 25, 554, 217);
		//add(textArea);
		//consoleScrollBar.
					
	}
	
	public void displayTextInConsole(String str ){
		
		
		txtrConsole.append(str);
		
	}
	
	public void clearTextConsole(){
		
		txtrConsole.setText("");
		
	}
}