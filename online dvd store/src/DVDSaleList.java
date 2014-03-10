import java.util.*;

public class DVDSaleList {
	private Vector<SaleItem> saleItemList;
	
	public DVDSaleList() {
		saleItemList = new Vector<SaleItem>();
	}
	
	public int size() {
		return saleItemList.size();
	}
	public SaleItem getSaleItem(int index) {
		return saleItemList.get(index);
	}
	
	public void addSaleItem(int DVDId, int desireQuantity, int saleType) {
		SaleItem saleItem = new SaleItem(DVDId, desireQuantity, saleType);
		saleItemList.add(saleItem);
	}
}
