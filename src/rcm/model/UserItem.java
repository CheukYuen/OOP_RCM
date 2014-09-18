package rcm.model;



public class UserItem {
	
	String name;
	private ItemType itemType;
	private Weight itemWeight;
	
	// default constructor
	public UserItem(){
		
		name=null;
		itemType=null;
		itemWeight=null;
		
	}
	
	
	public UserItem(String newItemName, ItemType newItemType, double newItemWeight ){
		
		this.name=newItemName;
		this.itemType=newItemType;
		this.itemWeight = new Weight(newItemWeight);
	}
	
	
	// for test purpose
	public UserItem(String newItemName, double newItemWeight ){
		
		this.name=newItemName;
		itemType=ItemType.glass;
		this.itemWeight= new Weight(newItemWeight);
		
	}
	
	// ItemName setter() and getter()--to observe the impact of protected type
	protected void setUserItemName ( String itemName) { this.name=itemName; }
	
	public String getUserItemName(){ return this.name; }
	
	// ItemType setter() and getter()--to observe the impact of protected type
	protected void setUserItemType( ItemType currentType ) { this.itemType=currentType;}
	
	
	public ItemType getUserItemType(){ return itemType; }
	
	// ItemWeight setter() and getter()
	public void setUserItemWeight( double currentWeight ){ itemWeight.setAmount(currentWeight);}
	
	public double getUserItemWeight(){ return itemWeight.getAmount(); }

}