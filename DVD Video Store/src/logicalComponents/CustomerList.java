/** Description of Program 
 * @file: CustomerList.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * The customer list contains a list of each registered customer.
 */

package logicalComponents;

import java.util.ArrayList;

public class CustomerList {

	private ArrayList<Customer> customerList;
	private int numOfCustomer;

	/**
	 * Constructor
	 * 
	 * @return reference to a customer list object
	 */
	public CustomerList() {
		customerList = new ArrayList<Customer>();
		numOfCustomer = 0;
	}

	/**
	 * Adds a customer to the list. Once they are registered, they are never
	 * removed from the system.
	 * 
	 * @param customer
	 *            is the customer to be inserted
	 * @return the id of the customer
	 */
	public int add(Customer customer) {
		customer.setId(++numOfCustomer);
		customerList.add(new Customer(customer));
		printCustList();
		return customer.getId();
	}

	/**
	 * Checks if a customer is in the list
	 * 
	 * @param custName
	 *            is item to be checked
	 * @return whether the customer is in the list or not
	 */
	public boolean customerIsThere(Customer customer) {
		if (customer.getId() == 0)
			return false;

		return true;
	}

	// check if the customer has a id and a right matched name in record
	public boolean validateCustomer(Customer customer) {
		if (customer.getId() > customerList.size())
			return false;

		if (customerList.get(customer.getId() - 1).getName()
				.equalsIgnoreCase(customer.getName()))
			return true;

		return false;
	}

	// test for print out the whole customer list
	public void printCustList() {
		for (int i = 0; i < customerList.size(); i++) {
			System.out.println("\nid: " + customerList.get(i).getId()
					+ "\nName: " + customerList.get(i).getName());
		}
	}
}
