package rcm.ui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;



public class AddItemPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton startButton, addItemButton;
	private JTextField textFieldItemName, textFieldItemWeight;
	private JTextField textFieldItemCnt, textFieldUsedTime;
	private JComboBox<ItemType> comboBoxItemType;
	private JLabel lblItemName, lblItemType, lblItemWeight, lblItemCnt,
			lblUsedTime, lblTotalPrice, lblMetrics;

	private int itemInputTypeIndex;
	private double itemInputWeight;
	String textInWeightItem;
	String itemInputName;
	ItemType itemInputType;

	private Machine localRCM;
	private ConsoleView textConsole;
	private PayView payPanel;

	private JTextField textPriceofItems;
	private JButton btnItemsView;
	private JComboBox<String> comboBoxWeightUnit;

	boolean mutual_flag = false;

	public AddItemPanel(Machine rcm, ConsoleView display, PayView pay) {

		this.setBackground(Color.YELLOW);
		this.setBounds(10, 87, 507, 208);
		this.setLayout(null);

		localRCM = rcm;
		textConsole = display;
		payPanel = pay;

		// payPanel.setEnabled(false);

		// start button
		startButton = new JButton("START");
		startButton.setFont(new Font("Arial Black", Font.BOLD, 11));
		startButton.setBounds(2, 11, 89, 38);
		startButton.addActionListener(this);
		// startButton.setActionCommand("START");
		this.add(startButton);

		// addItem button
		addItemButton = new JButton("ADD");
		addItemButton.setToolTipText("add a new item.");
		addItemButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		addItemButton.setBounds(402, 83, 95, 23);
		addItemButton.addActionListener(this);
		addItemButton.setActionCommand("ADD");
		this.add(addItemButton);
		addItemButton.setEnabled(false);

		// item name
		textFieldItemName = new JTextField();
		textFieldItemName.setBounds(2, 84, 100, 20);
		this.add(textFieldItemName);
		textFieldItemName.setEditable(false);
		textFieldItemName.setColumns(10);
		textFieldItemName.setText("");

		lblItemName = new JLabel("Name");
		lblItemName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblItemName.setBounds(2, 60, 89, 23);
		this.add(lblItemName);
		lblItemName.setHorizontalAlignment(SwingConstants.CENTER);

		// item type
		comboBoxItemType = new JComboBox<ItemType>();
		comboBoxItemType.addItem(null);
		comboBoxItemType.addItem(ItemType.glass);
		comboBoxItemType.addItem(ItemType.aluminum);
		comboBoxItemType.addItem(ItemType.paper);
		comboBoxItemType.addItem(ItemType.elctronics);
		comboBoxItemType.addItem(ItemType.plastic);

		comboBoxItemType.setSelectedIndex(0);
		comboBoxItemType.setBounds(292, 84, 100, 20);
		comboBoxItemType.setEnabled(false);
		this.add(comboBoxItemType);

		lblItemType = new JLabel("Type");
		lblItemType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblItemType.setBounds(292, 60, 100, 23);
		this.add(lblItemType);
		lblItemType.setHorizontalAlignment(SwingConstants.CENTER);

		// item weight
		lblItemWeight = new JLabel("Weight");
		lblItemWeight.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblItemWeight.setBounds(126, 60, 100, 23);
		this.add(lblItemWeight);
		lblItemWeight.setHorizontalAlignment(SwingConstants.CENTER);

		textFieldItemWeight = new JTextField();
		textFieldItemWeight.setBounds(126, 84, 100, 20);
		textFieldItemWeight.setText("0.0");
		this.add(textFieldItemWeight);
		textFieldItemWeight.setColumns(10);
		textFieldItemWeight.setEditable(false);

		// Item cnt
		textFieldItemCnt = new JTextField();
		textFieldItemCnt.setBounds(5, 177, 97, 20);
		textFieldItemCnt.setEditable(false);
		this.add(textFieldItemCnt);
		textFieldItemCnt.setColumns(10);
		textFieldItemCnt.setText("0");

		lblItemCnt = new JLabel(" Item Count");
		lblItemCnt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblItemCnt.setBounds(2, 149, 99, 23);
		this.add(lblItemCnt);

		// the amount that rcm is used.
		textFieldUsedTime = new JTextField();
		textFieldUsedTime.setBounds(292, 177, 100, 20);
		textFieldUsedTime.setEditable(false);
		this.add(textFieldUsedTime);
		textFieldUsedTime.setColumns(10);
		textFieldUsedTime.setText("0");

		lblUsedTime = new JLabel("RCM Used Times");
		lblUsedTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsedTime.setBounds(292, 153, 100, 14);
		this.add(lblUsedTime);

		// Total Price of Accepted Items

		textPriceofItems = new JTextField();
		textPriceofItems.setEditable(false);
		textPriceofItems.setColumns(10);
		textPriceofItems.setBounds(126, 177, 100, 20);
		textPriceofItems.setText("");
		this.add(textPriceofItems);

		lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalPrice.setBounds(125, 153, 86, 14);
		this.add(lblTotalPrice);

		comboBoxWeightUnit = new JComboBox<String>();
		comboBoxWeightUnit.addItem("lbs");
		comboBoxWeightUnit.addItem("kg");
		comboBoxWeightUnit.setBounds(236, 84, 46, 20);
		comboBoxWeightUnit.setActionCommand("METRICS");
		comboBoxWeightUnit.addActionListener(this);
		this.add(comboBoxWeightUnit);

		lblMetrics = new JLabel("Metrics");
		lblMetrics.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMetrics.setBounds(236, 64, 46, 14);
		this.add(lblMetrics);

		btnItemsView = new JButton("ITEMLIST");
		btnItemsView.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnItemsView.setBounds(402, 176, 95, 23);
		btnItemsView.addActionListener(this);
		this.add(btnItemsView);

		if (localRCM.getMachineStatus() == 0) {

			startButton.setEnabled(false);
			btnItemsView.setEnabled(false);
			comboBoxWeightUnit.setEnabled(false);

		} else {

			startButton.setEnabled(true);
			btnItemsView.setEnabled(true);
			comboBoxWeightUnit.setEnabled(true);
		}

	}

	// New Accepted Item
	// public UserItem NewAcceptedItem(String itemName, double itemWeight, int
	// inputTypeindex ){
	public RCMItem NewRCMItem(String itemName, double itemWeight,
			ItemType inputType) {

		System.out.println("hello world in NewRCMItem");

		double priceByType = Double.parseDouble(localRCM.getItemMap()
				.getMapEntryValue(inputType));
		double newRCMItemPrice = itemWeight * priceByType;

		RCMItem newRCMItem = new RCMItem(itemName, inputType, itemWeight,
				newRCMItemPrice);

		System.out.println("itemName:" + itemName + "\ninputType: " + inputType
				+ "\nitemWeight:" + itemWeight + "\nnewRCMItemPrice"
				+ newRCMItemPrice + "in NewRCMItem block");

		return newRCMItem;

	}

	// RCM ItemList
	public void addRCMItemList(Machine rcm, RCMItem item) {

		rcm.addRCMItem(item);

	}

	// Perform Action
	public void actionPerformed(ActionEvent event) {

		String cmd = event.getActionCommand();

		if (cmd.equals("START")) {

			textConsole.clearTextConsole();
			textFieldItemName.setText("");
			comboBoxItemType.setSelectedIndex(0);
			textFieldItemWeight.setText("0.0");
			textPriceofItems.setText("0.0");
			localRCM.resetSessionItemCnt();
			textFieldItemCnt.setText("" + localRCM.getSessionItemCnt());

			startButton.setText("STOP");

			localRCM.updateAmountofUsedTime();
			textFieldUsedTime.setText("" + localRCM.getAmountofUsedTime());

			lblItemName.setEnabled(true);
			lblItemType.setEnabled(true);
			lblItemWeight.setEnabled(true);

			textFieldItemName.setEditable(true);
			comboBoxItemType.setEnabled(true);
			textFieldItemWeight.setEditable(true);
			addItemButton.setEnabled(true);

			payPanel.setbtnPay(false);
			payPanel.setcomboBoxPayment(false);
			payPanel.settextPriceForCoupon(false);

		} else if (cmd.equals("STOP")) {

			double itemCnt = Double.parseDouble(textFieldItemCnt.getText());

			if (itemCnt != 0.0) {

				// payPanel
				payPanel.setbtnPay(true);
				payPanel.setcomboBoxPayment(true);
				// payPanel.settextPriceForCoupon(true);

			}

			startButton.setText("START");

			// localRCM.resetSessionItemCnt();
			// textFieldItemCnt.setText(""+localRCM.getSessionItemCnt());
			// textFieldItemCnt.getText();

			lblItemName.setEnabled(false);
			lblItemType.setEnabled(false);
			lblItemWeight.setEnabled(false);

			textFieldItemName.setEditable(false);
			comboBoxItemType.setEnabled(false);
			textFieldItemWeight.setEditable(false);
			addItemButton.setEnabled(false);

			// textFieldItemCnt.setText("0");

		} else if (cmd.equals("ADD")) {

			// be careful about the difference btw getText() and
			// getSelectedText()

			itemInputName = textFieldItemName.getText();
			// itemInputName=textFieldItemName.getSelectedText();

			System.out.println(itemInputName + "hello world in name");

			itemInputTypeIndex = comboBoxItemType.getSelectedIndex();
			itemInputType = (ItemType) comboBoxItemType.getSelectedItem();
			// comboBoxItemType.getSelectedItem().toString();

			boolean isRCMItemType = localRCM.getItemMap().rcmAcceptedItemType(
					itemInputType);
			System.out.println("isRCMItemType is:" + isRCMItemType);

			// System.out.println(itemInputTypeIndex+"hello world in type  "+comboBoxItemType.getSelectedItem().toString());

			textInWeightItem = textFieldItemWeight.getText();
			// textInWeightItem = textFieldItemWeight.getSelectedText();
			itemInputWeight = Double.parseDouble(textInWeightItem);

			System.out.println(itemInputWeight + "hello world in weight");

			if (itemInputName.equals("")) {

				JOptionPane.showMessageDialog(null,
						"Please enter the item name.");

			} else if (itemInputWeight == 0.0) {

				JOptionPane.showMessageDialog(null,
						"Please enter the item weight.");

			} else if (!isRCMItemType) {

				JOptionPane.showMessageDialog(null,
						"Please choose a legal item type.");

			} else if ((localRCM.getCurrentWeight() + itemInputWeight) > localRCM
					.getCapacityAmount()) {

				System.out.println("cur weight:" + localRCM.getCurrentWeight()
						+ "\ncap: " + localRCM.getCapacityAmount()
						+ "\nitem weight:" + itemInputWeight);

				JOptionPane
						.showMessageDialog(null,
								" The weight of item exceed than the current capacity of RCM.");

			} else {

				// boolean typeMatch =
				// localRCM.getItemMap().rcmAcceptedItemType(itemInputType);

				// if( typeMatch ) {

				RCMItem curItem = this.NewRCMItem(itemInputName,
						itemInputWeight, itemInputType);

				System.out.println("itemInputName:" + itemInputName
						+ "\nitemInputWeight: " + itemInputWeight
						+ "\nitemInputType:" + itemInputType);

				String tmpStr = "ItemName: " + itemInputName + "; ItemWeight: "
						+ itemInputWeight + "; ItemType: "
						+ comboBoxItemType.getSelectedItem().toString()
						+ "; ItemPrice:" + curItem.getRCMItemPrice() + "\n";

				// textConsole = new ConsoleView();

				textConsole.displayTextInConsole(tmpStr);

				// JOptionPane.showMessageDialog( null,"ADD ONE GLASS ITEM." );

				// addRCMItemList( rcm_1, curItem);
				localRCM.addRCMItem(curItem);

				localRCM.updateSessionItemCnt();
				textFieldItemCnt.setText("" + localRCM.getSessionItemCnt());
				// textFieldItemCnt.getText();

				// add price... to be continued
				textPriceofItems.setText(""
						+ localRCM.priceofArrayRCMItems(localRCM
								.getSessionItemCnt()));

				// insert data to deal table
				// DealTable insertData = new DealTable();
				try {
					//double itemPrice = curItem.getRCMItemPrice();
					double totalPrice = Machine.getTotalCash();
					int memberID = AddMachine.getOpenMachineID();
					DealTable.updateTableData(itemInputType, itemInputWeight,
							 memberID);
					// DealTable.testData(ItemType.glass, 10.2, 1.3);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// }

			}

		}// cmd.equals("ADD")
		else if (cmd.equals("ITEMLIST")) {

			System.out.println("hello world in items");
			ItemsView view_1 = new ItemsView(localRCM);
			view_1.setVisible(true);
			System.out.println("hello world in items2");
		} else if (cmd.equals("METRICS")) {

			int weightUnitIndex;
			double amountInKilo, amountInlbs;
			String curItemWeightInlbs, curItemWeightInKilo;

			weightUnitIndex = comboBoxWeightUnit.getSelectedIndex();

			System.out.println("weightUnitIndex is: " + weightUnitIndex
					+ "\n mutual_flag is: " + mutual_flag);

			if (weightUnitIndex == 0) {

				if (mutual_flag) {

					mutual_flag = false;
					curItemWeightInKilo = textFieldItemWeight.getText();
					amountInlbs = Double.parseDouble(curItemWeightInKilo) / 0.45;
					textFieldItemWeight.setText("" + amountInlbs);

				}

			}

			if (weightUnitIndex == 1) {

				if (!mutual_flag) {

					mutual_flag = true;
					curItemWeightInlbs = textFieldItemWeight.getText();
					amountInKilo = Double.parseDouble(curItemWeightInlbs) * 0.45;
					textFieldItemWeight.setText("" + amountInKilo);

				}

			}
		}

	}
}