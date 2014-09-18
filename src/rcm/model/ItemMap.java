package rcm.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ItemMap {

	
	private Map<ItemType, String> itemMap;
	
	
	public ItemMap(){
		
		itemMap = new HashMap<ItemType,String>();
		
		itemMap.put(ItemType.glass,"2.0");
		itemMap.put(ItemType.plastic, "4.0");
		itemMap.put(ItemType.paper, "3.0");
		
		
		
	}
	
	public void addMapEntry( ItemType type, String stringofPrice ){
		
		itemMap.put(type, stringofPrice);
		
	}
	
	public Map<ItemType, String> getItemMap(){ return this.itemMap; }
	
	
	public Set<Map.Entry<ItemType, String>> getItemMapEntrySet() { return itemMap.entrySet(); }
	
	public String removeItemMapEntry(ItemType type ) { return itemMap.remove(type); }
	
	public String getMapEntryValue(ItemType UserItemType ){
		
	      for (Map.Entry<ItemType, String> entry : itemMap.entrySet())
	      {  
	         
	    	  
	    	  ItemType RCMItemType = entry.getKey();
	         
	         if (RCMItemType == UserItemType ){
	        	
	        	 String RCMItemPrice = entry.getValue();
	        	 System.out.println("RCMItemType=" + RCMItemType + ", RCMItemPricebyWeight=" + RCMItemPrice);
	        	 
	        	 return RCMItemPrice;
	         }
	         
	      }
	      
	      return null;
	}
	
	
	public boolean rcmAcceptedItemType( ItemType UserItemType ){
		
		 for (Map.Entry<ItemType, String> entry : itemMap.entrySet())
		 {
			 ItemType RCMItemType = entry.getKey();
			 if (RCMItemType == UserItemType ){
				 
				 System.out.println(" hello world 1 in rcmAcceptedItemType block");
				 
				 return true;
				 
			 }
		 }
		 
		 System.out.println(" hello world 2 in rcmAcceptedItemType block");
		 
		 return false;
		
	}
	
	public int getAmountofMapEntries(){
		
		return itemMap.size();
	}
	
	
	public Map.Entry<ItemType, String> getEntryofMap( int targetIndex ){
		
		int OrignalIndex=0;
		Map.Entry<ItemType,String> curEntry=null;
		//Map.Entry<ItemType,String> entry=null;
		//Iterator it=null;
		
		/*
		it = itemMap.entrySet().iterator();
		
	    while (it.hasNext()) {
	    	
	    	OrignalIndex++;
	    	
	    	if(OrignalIndex == targetIndex ) {
	    		
	    		entry = (Map.Entry)it.next();
	    		break;
	    		
	    	}
	           
	    }
	    
	    return entry;
	     */
	    
		
	    for (Map.Entry<ItemType, String> entry : itemMap.entrySet()){
	    	
	    	if( OrignalIndex == targetIndex ){
	    		
	    		curEntry = entry;
	    		return curEntry;
	    	}
	    	
	    	OrignalIndex++;
	    		
	    }
	    
	    
	    return null;
	    

		
	}
	
	
}
