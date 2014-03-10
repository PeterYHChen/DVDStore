
public class Sale {
	final static int BUY = 1;
	final static int RENT = 2;
	
	private int customerId;
	private double totalDeposit;
	private double totalCost;
	private double total;
	private DVDSaleList dvdSaleList;
	
	public Sale(int custId) {
		customerId = custId;
		dvdSaleList = new DVDSaleList();
	}
	
	public void addDVD(int DVDId, int desireQuantity, int saleType) {
		dvdSaleList.addSaleItem(DVDId, desireQuantity, saleType);
	}
	
	public DVDSaleList getSaleList() {
		return dvdSaleList;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	//with taxes
	public double getTotal() {
		return total*1.15;
	}
	
	public void updateTotal(double cost, int saleType) {
		if (saleType == RENT) {
			totalDeposit += cost;
			totalCost += cost * 0.1;
		} else {
			totalCost += cost;
		}
		total = totalCost + totalDeposit;
	}
	
	public double completePayment(double amount){
		return amount - total*1.15;
	}
}
