/** Description of Program 
 * @file: RentalSale.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * Handles when customers bring back DVDs. Also handles the charging process
 * if they bring back the DVD late.
 */

package logicalComponents;

public class ReturnSale {
   private int custId;
   private double total;
   private ReturnList returnList;

   /**
    * Constructor
    * @param dvdId is the unique id assigned to the DVD
    * @param customerId is the quantity requested by the customer
    * @return reference to RentalItem instance
    */
   public ReturnSale(int custId) {
      this.custId = custId;
      returnList = new ReturnList();
   }

   /**
    * @param dvdId is the unique id assigned to the DVD
    * @return reference to RentalItem instance
    */
   public int getCustId() {
      return custId;
   }

   /**
    * @param dvdId is the unique id assigned to the DVD
    * @return reference to RentalItem instance
    */
   public ReturnList getReturnList() {
      return returnList;
   }

   /**
    * @param dvdId is the unique id assigned to the DVD
    * @return reference to RentalItem instance
    */
   public double getTotal() {
      return total;
   }

   /**
    * @param dvdId is the unique id assigned to the DVD
    * @return reference to RentalItem instance
    */
   public void updateTotal(double fee) {
      total += fee;
   }

/**
    * @param dvdId is the unique id assigned to the DVD
    */
   public void addReturnDVD(int dvdId) {
      returnList.addReturnDVD(dvdId);
   }

/**
    * @param dvdId is the unique id assigned to the DVD
    * @return reference to RentalItem instance
    */
   public double completePayment(double amount) {
      return amount - total;
   }

   public boolean checkReturnSaleItemDuplicate(int dvdId) {
      if (dvdId == 0)
         return false;
      return returnList.checkSaleItemDuplicate(dvdId);
   }
}
