/** Description of Program 
 * @file: Customer.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * The customer ADT which contains the name and unique id when the
 * customer is registered in the system.
 */

package logicalComponents;

public class Customer {

   private int id;
   private String name;

   /**
    * Constructor
    * @param custName is the name of the registered customer
    * @param custId is the unique id of the registered customer
    * @return reference to a customer object
    */
   public Customer(String custName) {
      id = 0;
      name = custName;
   }

   /**
    * @return the unique id of the customer
    */
   public int getId() {
      return id;
   }

   /**
    * @param custId is the unique id of the registered customer
    */
   public void setId(int custId) {
      id = custId;
   }

   /**
    * @return name of the customer
    */
   public String getName() {
      return name;
   }

   /**
    * @param custName is the name of the registered customer
    */
   public void setName(String custName) {
      name = custName;
   }

}
