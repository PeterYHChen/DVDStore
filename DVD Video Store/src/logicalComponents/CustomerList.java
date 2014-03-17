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

   ArrayList<Customer> customerList;
   int numOfCustomer;

   /**
    * Constructor
    * @return reference to a customer list object
    */
   public CustomerList() {
      customerList = new ArrayList<Customer>();
      numOfCustomer = 0;
   }

   /**
    * Adds a customer to the list. Once they are registered, they are
    * never removed from the system.
    * 
    * @param customer is the customer to be inserted
    * @return the id of the customer
    */
   public int add(Customer customer) {

      // Customers are initialized with default id of 0
      // if not found then set id to their index in the list
      if (customer.getId() == 0) {
         customer.setId(++numOfCustomer);
         customerList.add(customer);
      }
      return customer.getId();
   }

}
