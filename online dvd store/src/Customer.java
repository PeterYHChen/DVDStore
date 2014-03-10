
public class Customer {
	
	private int id;
	private String name;
	
	public Customer(String custName, int custId) {
		id = custId;
		name = custName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int custId) {
		id = custId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String custName) {
		name = custName;
	}
	
}
