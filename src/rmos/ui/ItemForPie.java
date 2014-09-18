package rmos.ui;

import java.util.Observable;

public class ItemForPie extends Observable {
	private double balance;
	private String name;

	// Account constructor
	public ItemForPie(String accountName, double openingDeposit) {
		name = accountName;
		setBalance(openingDeposit);
	}

	// set Account balance and notify observers of change
	private void setBalance(double accountBalance) {
		balance = accountBalance;
		// must call setChanged before notifyObservers to
		// indicate model has changed

		setChanged();
		// notify Observers that model has changed
		notifyObservers();
	}

	// get Account balance
	public double getBalance() {
		return balance;
	}

	public String getName() {
		return name;
	}

	// withdraw funds from Account
	/*
	 * public void withdraw( double amount ) throws IllegalArgumentException {
	 * if ( amount < 0 ) throw new IllegalArgumentException(
	 * "Cannot withdraw negative amount" ); // update Account balance
	 * setBalance( getBalance() - amount ); }
	 */
	// deposit funds in account
	/*
	 * public void deposit( double amount ) throws IllegalArgumentException { if
	 * ( amount < 0 ) throw new IllegalArgumentException(
	 * "Cannot deposit negative amount" ); setBalance( getBalance() + amount );
	 * }
	 */

}
