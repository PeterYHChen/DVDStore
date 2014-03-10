
public class SaleItem {
	int id;
	int quantity;
	int type;
	
	public SaleItem(int DVDId, int desireQuantity, int saleType) {
		id = DVDId;
		quantity = desireQuantity;
		type = saleType;
	}
	
	public int getId() {
		return id;
	}
}