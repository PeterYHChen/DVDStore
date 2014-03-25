/** Description of Program 
 * @file: DVDStoreController.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * The controller which communicates with the GUI to perform the desired
 * tasks of the DVD store.
 */

package logicalComponents;

import java.io.InputStream;
import java.util.AbstractMap.SimpleEntry;
import java.util.Scanner;
import java.util.Set;

public class DVDStoreController {
	public final static int BUY = 1;
	public final static int RENT = 2;

	private Inventory inventory;
	private StockList stockList;
	private RentalList rentalList;
	private CustomerList customerList;
	private Sale sale;
	private ReturnSale returnSale;

	public DVDStoreController() {
		inventory = new Inventory();
		rentalList = new RentalList();
		customerList = new CustomerList();
		stockList = new StockList();
		preloadInventory();
	}

	private void preloadInventory() {
		InputStream inputStream = DVDStoreController.class
				.getResourceAsStream("/logicalComponents/inventoryList.txt");
		Scanner inFile = new Scanner(inputStream);

		DVD tempDVD;
		while (inFile.hasNext()) {
			int id = Integer.parseInt(inFile.nextLine());
			String name = inFile.nextLine();
			int quantity = Integer.parseInt(inFile.nextLine());
			double cost = Double.parseDouble((inFile.nextLine()));

			tempDVD = new DVD(id, name, quantity, cost);
			inventory.addDVD(tempDVD);
		}
		inFile.close();
	}

	public StockList getStockList() {
		return stockList;
	}

	public int getInvSize() {
		return inventory.size();
	}

	public String getInvItemName(int index) {
		return inventory.getName(index);
	}

	public int getInvItemIdByName(String dvdName) {
		for (int i = 0; i < inventory.size(); i++) {
			if (dvdName.equalsIgnoreCase(inventory.getName(i)))
				return inventory.getId(i);
		}
		return 0;
	}

	public int getInvQuantity(int index) {
		return inventory.getQuantity(index);
	}

	// -----------------------------------------------------------------------//
	// The following methods are used to register a customer
	// -----------------------------------------------------------------------//

	// Adds a customer to the customer list
	public int registerCustomer(Customer customer) {
		return customerList.add(customer);
	}

	// Checks if customer is in the customer list
	public boolean checkCustomer(Customer customer) {
		return customerList.customerIsThere(customer);
	}

	// Checks if customer is valid to be stored in the customer list
	public boolean validateCustomer(Customer customer) {
		return customerList.validateCustomer(customer);
	}

	// -----------------------------------------------------------------------//
	// The following methods are used to stock the DVDs
	// -----------------------------------------------------------------------//

	// Responsible for adding individual dvds to the stocklist
	public void stockDVD(DVD dvd) {
		stockList.add(dvd);
	}

	// return error type or true
	public int testValidation(DVD dvd) {
		int test = testValidationForInventory(dvd);
		if (combineDuplicateDVD(dvd)) {
			if (test == 1)
				return 4;
		}
		return test;
	}

	public boolean combineDuplicateDVD(DVD dvd) {
		int finalQuan = 0;
		if (dvd.getId() != 0)
			return false;

		for (int i = 0; i < stockList.size(); i++) {
			DVD currStockItem = stockList.getStockItem(i);
			if (dvd.getName().equalsIgnoreCase(currStockItem.getName())) {
				finalQuan = currStockItem.getQuantity() + dvd.getQuantity();
				currStockItem.setQuantity(finalQuan);
				return true;
			}
		}
		return false;
	}

	public int testValidationForInventory(DVD dvd) {
		if (dvd.getId() == 0) {
			if (inventory.containsName(dvd.getName()))
				return 2;
		} else if (!inventory.matchIdToName(dvd)) {
			return 3;
		}
		return 1;// no error
	}

	// Updates the inventory with the stocklist
	public void updateStockToInventory() {
		inventory.update(stockList);
	}

	public void clearStockList() {
		stockList.clear();
	}

	// -----------------------------------------------------------------------//
	// The following methods are used to check out DVDs
	// -----------------------------------------------------------------------//

	public void startSale(int custId) {
		sale = new Sale(custId);
	}

	public boolean checkSaleItemDuplicate(String name) {
		return sale.checkSaleItemDuplicate(name);
	}

	public double addToSaleAndUpdateTotal(SaleItem saleItem) {
		double subCost = inventory.getCost(saleItem.getId() - 1);
		sale.addDVD(saleItem);
		sale.updateTotal(subCost, saleItem);

		return subCost;
	}

	public void updateSalesToInventory() {
		inventory.update(sale.getSaleList());
	}

	public void updateSalesToRentalList() {
		rentalList.update(sale.getCustId(), sale.getSaleList());
	}

	public double getSaleTotal() {
		return sale.getTotal();
	}

	// -----------------------------------------------------------------------//
	// The following methods are used to check in DVDs
	// -----------------------------------------------------------------------//

	public void startReturnSale(int customerId) {
		returnSale = new ReturnSale(customerId);
	}

	public Set<SimpleEntry<Integer, Integer>> getRentalListKeySet() {
		return rentalList.getKeySet();
	}

	public int getRentalListSize() {
		return rentalList.size();
	}

	public boolean checkReturnSaleItemDuplicate(String saleItemName) {
		return returnSale
				.checkReturnSaleItemDuplicate(getInvItemIdByName(saleItemName));
	}

	public RentalItem getRentalItem(int custId, int dvdId) {
		return rentalList.getRentalItem(custId, dvdId);
	}

	public double getReturnSaleTotal() {
		return returnSale.getTotal();
	}

	public void addToReturnSaleAndUpdateTotal(RentalItem rentalItem) {
		returnSale.addReturnDVD(rentalItem.getId());
		returnSale.updateTotal(rentalItem.getFee());
	}

	public void updateReturnSalesToInventory() {
		inventory.update(returnSale.getReturnList());
	}

	public void updateReturnSalesToRentalList() {
		rentalList.update(returnSale.getCustId(), returnSale.getReturnList());
	}

}
