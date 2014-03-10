import java.util.*;

public class CustomerList {
	
	Vector<Customer> customerList;
	int numOfCustomer;
	
	public CustomerList() {
		customerList = new Vector<Customer>();
		numOfCustomer = 0;
	}
	
	public int add(Customer customer) {
		//if no such customer, assign new id and add to the list
		if(customer.getId() == 0) {
			customer.setId(++numOfCustomer);
			customerList.add(customer);
		}
		return customer.getId();
	}
	
	//can implement a method to deal with the empty slot after removing some customer from the list
}
