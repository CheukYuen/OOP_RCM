package rmos.controller;

import javax.swing.*;

import rmos.ui.RmosFrame;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

/* PasswordDemo.java requires no other files. */

public class RmosManager extends JPanel implements ActionListener {
	private static String OK = "ok";
	private static String HELP = "help";

	private JFrame controllingFrame; // needed for dialogs
	private JPasswordField passwordField;
	private JPasswordField usernameField;
	
	//RmosFrame rmosFrame = new RmosFrame();

	public RmosManager(JFrame f) {
		// Use the default FlowLayout.
		controllingFrame = f;

		// Create everything.
		passwordField = new JPasswordField(10);
		passwordField.setActionCommand(OK);
		passwordField.addActionListener(this);

		usernameField = new JPasswordField(10);
		usernameField.setActionCommand(OK);
		usernameField.addActionListener(this);

		JLabel label = new JLabel("Enter the password: ");
		label.setLabelFor(passwordField);

		JLabel label2 = new JLabel("Enter the username: ");
		label2.setLabelFor(usernameField);

		JComponent buttonPane = createButtonPanel();

		// Lay out everything.
		JPanel textPane = new JPanel(new GridLayout(0, 1));

		textPane.add(label2);
		textPane.add(usernameField);

		textPane.add(label);
		textPane.add(passwordField);

		add(textPane);
		add(buttonPane);
	}

	protected JComponent createButtonPanel() {
		JPanel p = new JPanel(new GridLayout(0, 1));
		JButton okButton = new JButton("OK");
		JButton helpButton = new JButton("Help");

		okButton.setActionCommand(OK);
		helpButton.setActionCommand(HELP);
		okButton.addActionListener(this);
		helpButton.addActionListener(this);

		p.add(okButton);
		p.add(helpButton);

		return p;
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (OK.equals(cmd)) { // Process the password.
			char[] input = passwordField.getPassword();
			char[] input_user = usernameField.getPassword();
			if (isPasswordCorrect(input) && isUsernameCorrect(input_user)) {
				JOptionPane.showMessageDialog(controllingFrame,
						"Success! You typed the right password.");
				RmosFrame rmosFrame = new RmosFrame();
				rmosFrame.setVisible(true);
				
				
			} else {
				JOptionPane.showMessageDialog(controllingFrame,
						"Invalid password. Try again.", "Error Message",
						JOptionPane.ERROR_MESSAGE);
			}

			// Zero out the possible password, for security.
			Arrays.fill(input, '0');

			passwordField.selectAll();
			resetFocus();
		} else { // The user has asked for help.
			JOptionPane
					.showMessageDialog(
							controllingFrame,
							"You can get the password by searching this example's\n"
									+ "source code for the string \"correctPassword\".\n"
									+ "Or look at the section How to Use Password Fields in\n"
									+ "the components section of The Java Tutorial.");
		}
	}

	/**
	 * Checks the passed-in array against the correct password. After this
	 * method returns, you should invoke eraseArray on the passed-in array.
	 */
	private static boolean isPasswordCorrect(char[] input) {
		boolean isCorrect = true;
		char[] correctPassword = { '1', '9', '8', '9' };

		if (input.length != correctPassword.length) {
			isCorrect = false;
		} else {
			isCorrect = Arrays.equals(input, correctPassword);
		}

		// Zero out the password.
		Arrays.fill(correctPassword, '0');

		return isCorrect;
	}

	private static boolean isUsernameCorrect(char[] input) {
		boolean isCorrect = true;
		char[] correctUsername = { 'l', 'e', 'o', 'n' };

		if (input.length != correctUsername.length) {
			isCorrect = false;
		} else {
			isCorrect = Arrays.equals(input, correctUsername);
		}

		// Zero out the password.
		Arrays.fill(correctUsername, '0');

		return isCorrect;
	}

	// Must be called from the event dispatch thread.
	protected void resetFocus() {
		passwordField.requestFocusInWindow();
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("RMOS Admin");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		final RmosManager newContentPane = new RmosManager(frame);
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Make sure the focus goes to the right component
		// whenever the frame is initially given the focus.
		frame.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				newContentPane.resetFocus();
			}
		});

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}
}
