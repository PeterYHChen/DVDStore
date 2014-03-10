
public class DVDStore {
	final static int BUY = 1;
	final static int RENT = 2;
	
	Inventory inventory;
	RentalList rentalList;
	CustomerList customerList;
	
	public static void main(String args[]){
		DVDStore store = new DVDStore();
		store.run();
	}
	
	public DVDStore() {
		inventory = new Inventory();
		rentalList = new RentalList();
		customerList = new CustomerList();
	}
	
	void run(){
		//connect to the java GUI
	}
	
	void customerRegistrationScenario(){
		//input customer name and id
		String custName = "";
		int custId = 0;
		Customer customer = new Customer(custName, custId);
		customerList.add(customer);
	}
	
	void stockDVDScenario(){
		StockList stockList = new StockList();
		//for loop, stockList.stockDVD(id, cost, name, quantity);
		inventory.update(stockList);
	}
	
	void checkOutScenario(){
		int custId = 1;//temporary id for this scenario
		Sale sale = new Sale(custId);
//		while input DVD item {
//			if(inventory.checkQuantity(DVDId, desireQuantity)){
//				sale.addDVD(DVDId, desireQuantity, saleType);
//				sale.updateTotal(inventory.getCost(DVDId), saleType);
//				displayTotal(sale.getTotal());
//			}
//		}
//		displayChanges(sale.completePayment(amount));
		inventory.update(sale.getSaleList());
		rentalList.update(sale.getCustomerId(), sale.getSaleList());
	}
	
	void checkInScenario(){
		int custId = 1;//temporary id for this scenario
		ReturnSale returnSale = new ReturnSale(custId);
//		while input DVD item{
//			returnSale.returnDVD(DVDId);
//			returnSale.updateTotal(rentalList.getRentalItem(custId, DVDId).getFee());
//			displayTotal(returnSale.getTotal());
//		}
		inventory.update(returnSale.getReturnList());
		rentalList.update(returnSale.getCustomerId(), returnSale.getReturnList());
//		displayChanges(returnSale.completePayment(amount));	
		
	}
}
