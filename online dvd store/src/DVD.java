
public class DVD {
	int id;
	String name;
	int quantity;
	double cost;
	
	public DVD(int DVDId, String DVDName, int DVDQuantity, double DVDCost) {
		id = DVDId;
		name = DVDName;
		quantity = DVDQuantity;
		cost = DVDCost;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int DVDId) {
		id = DVDId;
	}
	
}
