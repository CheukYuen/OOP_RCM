package rcm.model;

public class Cash {
	
	String currencyUnit="dollars";
	private double amount;
	
	/**
	 * Class Constructor 
	 * @param amount
	 */
	public Cash() {
		// TODO Auto-generated constructor stub
		this.amount =0.0;
	}
	
	public Cash( double amountofCash ){
		
		this.amount=amountofCash;
	}
	
	/**
	 * Method: setAmount 
	 */
	public void setCashAmount ( double amountofCash) { this.amount=amountofCash;}
	
    /**
     * Method: getAmount
     * @return amount
     */
	public double getCashAmount() { return amount;}
	

   // face value of paper money should be considered in the future

}
