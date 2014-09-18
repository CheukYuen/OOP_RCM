package rcm.model;


public interface UpdateRCM {
	
	//public RCMItem createRCMItem ( UserItem item );

	public double priceofRCMItem ( ItemMap map, UserItem item );
	
	public double priceofArrayRCMItems ( int numofNewItems );
	
	public void updateRCMWeight(RCMItem item, Weight curWeightInRCM);
	
	public String updateRCMCash( double totalItemPrice, double itemPriceforCoupon,int userOption );
	
	public String payCash( double price );
	
	public String payCoupon( double price );
	
}
