import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class RentalList {
	Map<SimpleEntry<Integer, Integer>, RentalItem> rentalItemList;
	
	public RentalList() {
		rentalItemList = new HashMap<SimpleEntry<Integer, Integer>, RentalItem>();
	}
	
	public void update(int custId, DVDSaleList dvdSaleList){
		for (int i = 0; i < dvdSaleList.size(); i++) {
			int DVDId = dvdSaleList.getSaleItem(i).getId();
			RentalItem rentalItem = new RentalItem(custId, DVDId);
			SimpleEntry<Integer, Integer> rentalItemTag = 
					new SimpleEntry<Integer, Integer>(custId, DVDId);
			rentalItemList.put(rentalItemTag, rentalItem);
		}
		
	}
	
	public void update(int custId, ReturnList returnList){
		for (int i = 0; i < returnList.size(); i++) {
			SimpleEntry<Integer, Integer> rentalItemTag = 
					new SimpleEntry<Integer, Integer>(custId, returnList.getReturnDVDId(i));
			rentalItemList.remove(rentalItemTag);
		}
		
	}
	
	public void addRentalItem(RentalItem item){
		
	}
	
	public RentalItem getRentalItem(int custId, int DVDId) {
		SimpleEntry<Integer, Integer> rentalItemTag = 
				new SimpleEntry<Integer, Integer>(custId, DVDId);
		return rentalItemList.get(rentalItemTag);
	}
	
}
