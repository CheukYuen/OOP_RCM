package rcm.controller;


public class main {

	/**
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {

		MainView main_panel = new MainView(" Recycling Machine ");

		main_panel.setVisible(true);
		
		Machine curRCM = main_panel.getCurRCM();
		
		System.out.println("hello world 13");

		main_panel.addWindowListener(new MyWindowListener(curRCM));
		
		System.out.println("hello world 14");

		ClockView clock_1 = main_panel.getClockView();
		clock_1.setVisible(true);

		Thread thread1 = new Thread(clock_1);
		thread1.start();

	}

}
