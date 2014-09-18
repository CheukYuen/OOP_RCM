package rcm.model;

import java.util.Date;


public class RCMItem extends UserItem {

	private double rcmItemPrice;
	//private double rcmItemWeight;
	//private ItemType rcmItemType;
	//private String rcmItemName;
	private Date rcmItemDate;
	
	public RCMItem(){
		
		super();
		rcmItemPrice=0.0;
		rcmItemDate= new Date();
	}
	
	
	public RCMItem( String newItemName,ItemType newItemType, double newItemWeight, double newItemPrice ){
		
		super(newItemName,newItemType,newItemWeight);
		
		rcmItemPrice=newItemPrice;
		
		rcmItemDate = new Date();
		
		System.out.println("newItemName:"+newItemName+"\nnewItemType: "+newItemType
				+"\nnewItemWeight:"+newItemWeight+"\nrcmItemPrice"+rcmItemPrice+"rcmItemDate is:"+rcmItemDate+"in RCMItem block");
				
	}
	
	// rcmItemName getter()
	public String getRCMItemName() { return this.getUserItemName(); }
	
	// rcmItemType setter() and getter()
	public void setRCMItemType( ItemType type ){ this.setUserItemType(type);}
	
	public ItemType getRCMItemType(){ return this.getUserItemType();}
	
	public String getRCMItemTypeName(){
		
		//return this.rcmItemType.toString();
		return this.getUserItemType().toString();
	}
	

	// rcmItemWeight setter() and getter()
	
	public void setRCMItemWeight( double amountofWeight ){ this.setUserItemWeight(amountofWeight);}
	
	public double getRCMItemWeight( ){ 
		
	
		System.out.println(" this.rcmItemWeightName:"+this.getUserItemWeight()+"in getItemWeight block");
		
		return this.getUserItemWeight(); 
		
	}

	// rcmItemPrice getter()
	
	public void setRCMItemPrice( double newPrice ) { this.rcmItemPrice=newPrice; }
	
	public double getRCMItemPrice(){ return this.rcmItemPrice; }
	
	// rcmItemDate getter()
	public Date getRCMItemDate(){ return this.rcmItemDate; }

}