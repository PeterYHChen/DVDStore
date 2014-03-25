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
   private String name;
   private int quantity;
   private int type;

   public SaleItem() {
      id = 0;
      name = "";
      quantity = 0;
      type = 0;
   }

public SaleItem(SaleItem item) {
      id = item.getId();
      name = item.getName();
      quantity = item.getQuantity();
      type = item.getType();

   }

/**
    * Constructor
    * @param dvdId is the unique id assigned to the DVD
    * @param desiredQuantity is the quantity requested by the customer
    * @param saleType indicates whether a sale or rent is occuring
    * @return reference to SaleItem instance
    */
   public SaleItem(int dvdId, String dvdName, int desiredQuantity, int saleType) {
      id = dvdId;
      name = dvdName;
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

   public String toString() {
      if (type == Sale.BUY)
         return "Item name: " + name + "\nQuantity : " + quantity
               + "\n  Type   : Buy\n";
      else
         return "Item name: " + name + "\nQuantity : " + quantity
               + "\n  Type   : Rent\n";
   }

}