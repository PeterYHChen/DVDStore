import java.util.*;

public class StockList {
	private Vector<DVD> dvdStockList;
	
	public StockList() {
		dvdStockList = new Vector<DVD>();
	}
	
	public int size() {
		return dvdStockList.size();
	}
	
	public DVD getStockItem(int index) {
		return dvdStockList.get(index);
	}
	
	public void stockDVD(int id, double cost, String name, int quantity) {
		DVD dvd = new DVD(id, name, quantity, cost);
		dvdStockList.add(dvd);
	}
	//can implement the remove function
}
