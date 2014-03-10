import java.util.*;


public class Inventory {
	Map<Integer, DVD> DVDList;
	int numOfDVD;
	
	public Inventory() {
		DVDList = new HashMap<Integer, DVD>();
		numOfDVD = 0;
	}
	
	public boolean checkQuantity(int DVDId, int desireQuantity){
		if(DVDList.get(DVDId).quantity - desireQuantity >= 0)
			return true;
		return false;
	}
	
	public double getCost(int DVDId) {
		return DVDList.get(DVDId).cost;
	}
	
	public void addDVD(DVD dvd) {
		DVDList.put(dvd.id, dvd);
	}
	
	public void update(StockList stockList) {
		for (int i = 0; i < stockList.size(); i++) {
			//if no such DVD, assign new id and add to the DVDlist
			if(stockList.getStockItem(i).getId() == 0){
				stockList.getStockItem(i).setId(++numOfDVD);
				addDVD(stockList.getStockItem(i));
				return;
			}
			DVDList.get(stockList.getStockItem(i).getId()).quantity += stockList.getStockItem(i).quantity;
		}//end for loop
	}
	
	
	public void update(DVDSaleList dvdSaleList) {
		for (int i = 0; i < dvdSaleList.size(); i++) {
			DVDList.get(dvdSaleList.getSaleItem(i).getId()).quantity -= dvdSaleList.getSaleItem(i).quantity;
		}
		
	}
	
	public void update(ReturnList returnList) {
		for (int i = 0; i < returnList.size(); i++) {
			DVDList.get(returnList.getReturnDVDId(i)).quantity--;
		}
	}
	
}
