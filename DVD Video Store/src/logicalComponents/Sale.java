/** Description of Program 
 * @file: Sale.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * This is one of the key classes, as it is created everytime a sale
 * occurs. The main goal is to collect the dvds from the customer
 * calculate total sale, and recieve payment.
 */

package logicalComponents;

public class Sale {
   final static int BUY = 1;
   final static int RENT = 2;

   private int customerId;
   private double totalDeposit;
   private double totalCost;
   private double total;
   private DVDSaleList dvdSaleList;

   /**
    * Constructor
    * @param custId unique id associated with each customer purchase
    * @return reference to Sale instance
    */
   public Sale(int custId) {
      customerId = custId;
      dvdSaleList = new DVDSaleList();
   }

   /**
    * @param dvdId unique id associated with each dvd
    * @param desiredQuantity purchase quantity desired from customer
    * @param saleType is either buy or rent
    */
   public void addDVD(int dvdId, int desiredQuantity, int saleType) {
      dvdSaleList.addSaleItem(dvdId, desiredQuantity, saleType);
   }

   /**
    * @return the DVD Sale List associated with this sale
    */
   public DVDSaleList getSaleList() {
      return dvdSaleList;
   }

   /**
    * @return customer id associated with this sale
    */
   public int getCustomerId() {
      return customerId;
   }

   /**
    * @return the total of the purchase including rented/bought dvds
    */
   public double getTotal() {
      return total * 1.15;
   }

   /**
    * @param cost is how much the dvd costs in terms of dollars
    * @param saleType indicates whether the DVD is being rented or bought
    */
   public void updateTotal(double cost, int saleType) {
      if (saleType == RENT) {
         totalDeposit += cost;
         totalCost += cost * 0.10;
      } else {
         totalCost += cost;
      }
      total = totalCost + totalDeposit;
   }

   /**
    * @param amount is how much the customer pays for the purchase
    * @return amount of change which is due to the customer
    */
   public double completePayment(double amount) {
      return amount - total * 1.15;
   }
}
