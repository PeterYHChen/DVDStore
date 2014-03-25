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
   private String name;
   private java.util.Date rentDate;
   private double fee;

   /**
    * Constructor
    * @param dvdId is the unique id assigned to the DVD
    * @param customerId is the quantity requested by the customer
    * @return reference to RentalItem instance
    */
   public RentalItem(int customerId, int dvdId, String dvdName) {
      custId = customerId;
      id = dvdId;
      rentDate = getCurrentDate();
      name = dvdName;
      fee = 0;
   }

   /**
    * @return the fee when the DVD is late
    */
   public double getFee() {
      int days = (int) (getCurrentDate().getTime() - rentDate.getTime()) / 1000
            / 60 / 60 / 24;
      fee = days * 0.1;
      return fee;
   }

   private Date getCurrentDate() {
      Calendar c = new GregorianCalendar();
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

   /**
    * @return the name
    */
   public String getName() {
      return name;
   }

   /**
    * @param name the name to set
    */
   public void setName(String name) {
      this.name = name;
   }

public String toString() {
      return "Customer id: " + custId + "\nDVD id: " + id + "\nDate : "
            + rentDate;
   }
}
