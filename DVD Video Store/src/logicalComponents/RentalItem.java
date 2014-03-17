/** Description of Program 
 * @file: RentalItem.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * The contains a list of DVD ids which indicated they are rented. Note
 * that the array only needs to be integers because we're only renting one
 * DVD at a time.
 */

package logicalComponents;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RentalItem {
   private int custId;
   private int id;
   private java.util.Date rentDate;
   private double fee;

   /**
    * Constructor
    * @param dvdId is the unique id assigned to the DVD
    * @param customerId is the quantity requested by the customer
    * @return reference to RentalItem instance
    */
   public RentalItem(int customerId, int dvdId) {
      setCustId(customerId);
      setId(dvdId);
      setRentDate(getCurrentDate());
      fee = 0;
   }

   /**
    * @return the fee when the DVD is late
    */
   public double getFee() {
      // fee = getCurrentDate() - rentDate;
      return fee;
   }

   private Date getCurrentDate() {
      Calendar c = new GregorianCalendar();
      c.set(Calendar.HOUR_OF_DAY, 0); // anything 0 - 23
      c.set(Calendar.MINUTE, 0);
      c.set(Calendar.SECOND, 0);
      return c.getTime();
   }

   /**
    * @return the custId
    */
   public int getCustId() {
      return custId;
   }

   /**
    * @param custId the custId to set
    */
   public void setCustId(int custId) {
      this.custId = custId;
   }

   /**
    * @return the id
    */
   public int getId() {
      return id;
   }

   /**
    * @param id the id to set
    */
   public void setId(int id) {
      this.id = id;
   }

   /**
    * @return the rentDate
    */
   public java.util.Date getRentDate() {
      return rentDate;
   }

   /**
    * @param rentDate the rentDate to set
    */
   public void setRentDate(java.util.Date rentDate) {
      this.rentDate = rentDate;
   }
}
