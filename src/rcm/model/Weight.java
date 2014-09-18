package rcm.model;

public class Weight {
	
	String weightUnit="lbs";
	private double amount;
	
	public Weight(){
		
		this.amount=0.0;
	}
	
	public Weight( double amountofWeight){
		
		this.amount=amountofWeight;
	}
	
	public void setAmount( double amountofWeight   ){ this.amount=amountofWeight;}
	
	public double getAmount( ){ return amount; }
	
	// 1lbs=0.45kg
	public double getAmountInKilo(){ return amount*0.45; }

}
