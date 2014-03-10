
public class ReturnSale {
	int customerId;
	double total;
	ReturnList returnList;
	
	public ReturnSale(int custId) {
		customerId = custId;
		returnList = new ReturnList();
	}
	
	public void returnDVD(int DVDId){
		returnList.addReturnDVD(DVDId);
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public ReturnList getReturnList() {
		return returnList;
	}
	
	public void updateTotal(double fee) {
		total += fee;
	}
	public double getTotal() {
		return total;
	}
	
	public double completePayment(int amount) {
		return amount - total;
	}
}
