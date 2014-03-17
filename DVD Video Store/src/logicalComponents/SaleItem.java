/** Description of Program 
 * @file: SaleItem.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * The SaleItem describes a dvd in a sale by its id value.
 */

package logicalComponents;

public class SaleItem {
   private int id;
   private int quantity;
   private int type;

   /**
    * Constructor
    * @param dvdId is the unique id assigned to the DVD
    * @param desiredQuantity is the quantity requested by the customer
    * @param saleType indicates whether a sale or rent is occuring
    * @return reference to SaleItem instance
    */
   public SaleItem(int dvdId, int desiredQuantity, int saleType) {
      id = dvdId;
      quantity = desiredQuantity;
      type = saleType;
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
    * @return the quantity
    */
   public int getQuantity() {
      return quantity;
   }

   /**
    * @param quantity the quantity to set
    */
   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   /**
    * @return the type
    */
   public int getType() {
      return type;
   }

   /**
    * @param type the type to set
    */
   public void setType(int type) {
      this.type = type;
   }

}