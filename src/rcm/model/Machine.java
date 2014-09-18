package rcm.model;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Machine extends Observable implements UpdateRCM {

	// private variables
	private int id;
	private String location;
	private Weight capacity;
	private static Cash totalCash;
	public static double priceofRCMItem;

	private int rcmStatus;
	private Weight curWeightInRCM;
	private Cash currCashInRCM;

	private Date curDate;
	private java.sql.Date lastEmptiedDate;

	private int amountofUsedTime;
	private int amountofEmptiedTime;

	private ItemMap map;
	private List<RCMItem> ItemListInRCM;

	private int sessionItemCnt;

	// constructor
	public Machine() throws Throwable {

		id = AddMachine.getOpenMachineID();
		// location="Enigneering Building";
		location = MachineTable.getLocation(AddMachine.getOpenMachineID());

		capacity = new Weight(1000.0);
		totalCash = new Cash(500.0);

		rcmStatus = MachineTable.getStatus(AddMachine.getOpenMachineID());

		curWeightInRCM = new Weight();
		currCashInRCM = new Cash(50.0);

		curDate = new Date();
		lastEmptiedDate = null;

		amountofUsedTime = 0;
		amountofEmptiedTime = -1; // special point

		map = new ItemMap();

		// map.addMapEntry(ItemType.paper, "7.0");

		ItemListInRCM = new ArrayList<RCMItem>();
		if (MachineTable.getEleStatus(AddMachine.getOpenMachineID()) == 1) {
			map.addMapEntry(ItemType.elctronics, "8.0");
		}
		if (MachineTable.getAluStatus(AddMachine.getOpenMachineID()) == 1) {
			map.addMapEntry(ItemType.aluminum, "5.0");
		}
		
		

		String glassPrice = String.valueOf(MachineTable
				.getGlassPrice(AddMachine.getOpenMachineID()));
		if (MachineTable.getGlassPrice(AddMachine.getOpenMachineID()) != 0.0) {
			map.addMapEntry(ItemType.glass, glassPrice);

		}


		String paperPrice = String.valueOf(MachineTable
				.getPaperPrice(AddMachine.getOpenMachineID()));
		if (MachineTable.getPaperPrice(AddMachine.getOpenMachineID()) != 0.0) {
			map.addMapEntry(ItemType.paper, paperPrice);

		}

		String plasticPrice = String.valueOf(MachineTable
				.getPlasticPrice(AddMachine.getOpenMachineID()));
		if (MachineTable.getPlasticPrice(AddMachine.getOpenMachineID()) != 0.0) {
			map.addMapEntry(ItemType.plastic, plasticPrice);

		}

		sessionItemCnt = 0;

	}

	/******************* getter()s and setter()s ********************/

	// 1.RCM ID

	public void setMachineID(int id) {
		this.id = id;
	}

	public String getMachineID() {

		String stringId = String.valueOf(id);

		return stringId;
	}

	// 2.RCM Location

	public void setMachineLocation(String location) {
		this.location = location;
	}

	public String getMachineLocation() {
		return this.location;
	}

	// 3.RCM Capacity

	public void setCapacity(double cap) {
		this.capacity.setAmount(cap);
	}

	public double getCapacityAmount() {

		// System.out.println("\ncap:"+capacity.getAmount());

		return this.capacity.getAmount();

	}

	public double getCapacityAmountInKilo() {
		return this.capacity.getAmountInKilo();
	}

	// 4.RCM Total Cash
	public void setTotalCash(double cash) {
		this.totalCash.setCashAmount(cash);
	}

	public static double getTotalCash() {
		return totalCash.getCashAmount();
	}

	// 5.Machine Status

	public void setMachineStatus(int mStatus) {
		this.rcmStatus = mStatus;
	}

	public int getMachineStatus() {
		return this.rcmStatus;
	}

	// 6.Machine Current Weight
	public void setCurrentWeight(double amountofWeight) {
		this.curWeightInRCM.setAmount(amountofWeight);

		// for test purpose
		setChanged();
		notifyObservers(new Double(amountofWeight));
	}

	public double getCurrentWeight() {
		return this.curWeightInRCM.getAmount();
	}

	public double getCurrentWeightInKilo() {
		return this.curWeightInRCM.getAmountInKilo();
	}

	// 7.Machine Current Cash

	public void setCurrentCash(double curCash) {
		this.currCashInRCM.setCashAmount(curCash);
	}

	public double getCurrentCash() {
		return this.currCashInRCM.getCashAmount();
	}

	// 8.Current Date

	public String showCurrentDate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String currentDate = dateFormat.format(curDate);
		System.out.println(" Item Date is: " + currentDate);

		return currentDate;
	}

	// 9.Last Emptied Date--need improved
	// 10.The amount the machine is emptied

	public void setLastEmptiedTime() throws Exception {

		if (this.getCurrentWeight() == 0) {

			this.lastEmptiedDate = (java.sql.Date) new Date();
			int memberID = AddMachine.getOpenMachineID();
			SetTable.updateTime(lastEmptiedDate , memberID);
			amountofEmptiedTime++;
		}

	}

	public Date getLastEmptiedDate() {
		return this.lastEmptiedDate;
	}

	public int getAmountofemptiedTime() {
		return this.amountofEmptiedTime;
	}

	// 11.The amount the machine is used

	public void updateAmountofUsedTime() {

		amountofUsedTime++;
		setChanged();
		notifyObservers(amountofUsedTime);

	}

	public int getAmountofUsedTime() {
		return this.amountofUsedTime;
	}

	// 13.ItemMap getter()
	public ItemMap getItemMap() {
		return this.map;
	}

	@SuppressWarnings("null")
	public String showMapInfo() {

		String mapString = null;

		for (Map.Entry<ItemType, String> entry : map.getItemMapEntrySet()) {
			ItemType ItemTypeInRCM = entry.getKey();
			String typeName = ItemTypeInRCM.toString();

			String itemPriceInRCM = entry.getValue();

			String itemMapEntry = "\n" + typeName + ":" + " " + itemPriceInRCM
					+ " USD.";

			// need to be verified!!
			mapString.concat(itemMapEntry);

		}

		return mapString;

	}

	// 14.RCMItemList
	public List<RCMItem> getRCMItemList() {
		return ItemListInRCM;
	}

	public void addRCMItem(RCMItem item) {
		ItemListInRCM.add(item);
	}

	public int SizeofRCMItemList() {
		return ItemListInRCM.size();
	}

	// 15 Session Item Cnt

	public void resetSessionItemCnt() {

		sessionItemCnt = 0;
	}

	public void updateSessionItemCnt() {

		sessionItemCnt++;
	}

	public int getSessionItemCnt() {

		return sessionItemCnt;
	}

	/****************** Update RCM **************************/

	// 1.priceofRCMItem
	public double priceofRCMItem(ItemMap map, UserItem item) {

		double RCMItemPrice = 0.0;
		double itemPricebyWeight = Double.parseDouble(map.getMapEntryValue(item
				.getUserItemType()));

		RCMItemPrice = item.getUserItemWeight() * itemPricebyWeight;

		return RCMItemPrice;

	}

	// 2.priceofArrayRCMItems
	public double priceofArrayRCMItems(int numofNewItems) {

		double totalPriceofNewItems = 0.0;

		for (int i = (ItemListInRCM.size() - numofNewItems); i < ItemListInRCM
				.size(); i++) {

			RCMItem newItem = ItemListInRCM.get(i);

			totalPriceofNewItems += newItem.getRCMItemPrice();
		}

		return totalPriceofNewItems;

	}

	// 3.updateRCMWeight
	public void updateRCMWeight(RCMItem item, Weight curWeightInRCM) {

		double newItemWeight = item.getRCMItemWeight();

		double newAmountofCurWeight = curWeightInRCM.getAmount()
				+ newItemWeight;

		this.setCurrentWeight(newAmountofCurWeight);

	}

	// 4.updateRCMCash
	public String updateRCMCash(double totalItemPrice,
			double itemPriceforCoupon, int userOption) {

		double newCurrentCash = 0.0;
		double redeemedPrice = 0.0;

		String printPay = null;

		// cash is enough
		if (totalItemPrice <= this.getCurrentCash()) {

			// pay cash totally
			if (userOption == 1) {

				newCurrentCash = this.getCurrentCash() - totalItemPrice;
				printPay = payCash(totalItemPrice);
				this.setCurrentCash(newCurrentCash);

			}

			if (userOption == 2) { // pay coupon based on the partial price

				newCurrentCash = this.getCurrentCash() - totalItemPrice
						+ itemPriceforCoupon;

				// if((totalItemPrice-itemPriceforCoupon)<0){}

				printPay = payCash(totalItemPrice - itemPriceforCoupon) + "\n"
						+ payCoupon(itemPriceforCoupon);
				this.setCurrentCash(newCurrentCash);
			}

			if (userOption == 3) {

				printPay = payCoupon(totalItemPrice);
			}

		} else { // cash is not enough

			if (userOption == 1) {

				newCurrentCash = totalItemPrice - this.getCurrentCash();
				printPay = "The Cash in RCM is not enough."
						+ payCash(this.getCurrentCash()) + "\n"
						+ payCoupon(newCurrentCash);
				this.setCurrentCash(0.0);

			}

			if (userOption == 2) {

				if ((totalItemPrice - itemPriceforCoupon) > this
						.getCurrentCash()) {

					redeemedPrice = totalItemPrice - this.getCurrentCash();
					printPay = "The Cash in RCM is not enough."
							+ payCash(this.getCurrentCash()) + "\n"
							+ payCoupon(redeemedPrice);
					this.setCurrentCash(0.0);

				} else {

					newCurrentCash = this.getCurrentCash() - totalItemPrice
							+ itemPriceforCoupon;
					printPay = payCash(totalItemPrice - itemPriceforCoupon)
							+ "\n" + payCoupon(itemPriceforCoupon);
					this.setCurrentCash(newCurrentCash);
				}
			}

			if (userOption == 3) {

				printPay = payCoupon(totalItemPrice);
			}

		}

		return printPay;

	}

	// 5.payCash
	public String payCash(double price) {

		String cashPaper = new String(
				"$"
						+ price
						+ "cash are paid, we appreciate your contribution for our earth .");

		return cashPaper;
	}

	// 6.payCoupon
	public String payCoupon(double price) {

		String printCoupon = new String("A coupon is generate as a vouch of $"
				+ price + " in Safeway, Target and SCU cafeteria. ");

		return printCoupon;

	}

}