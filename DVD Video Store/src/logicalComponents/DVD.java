/** Description of Program 
 * @file: DVD.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * The DVD ADT which is the main feature of the DVD store. Stores
 * information about the name, quantity, cost, and id of the DVD.
 */

package logicalComponents;

public class DVD {
   private int id;
   private int quantity;
   private double cost;
   private String name;

   /**
    * Constructor
    * @param dvdId is the unique id of the DVD
    * @param dvdName is the name of the DVD
    * @param dvdQuantity is the number of the DVD in stock
    * @param dvdCost is the cost of the DVD
    * @return reference to a DVD object
    */
   public DVD(int dvdId, String dvdName, int dvdQuantity, double dvdCost) {
      id = dvdId;
      name = dvdName;
      quantity = dvdQuantity;
      cost = dvdCost;
   }

   /**
    * @return the unique id of the DVD
    */
   public int getId() {
      return id;
   }

   /**
    * @param dvdId is the unique id of the DVD
    */
   public void setId(int dvdId) {
      id = dvdId;
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
    * @return the cost
    */
   public double getCost() {
      return cost;
   }

   /**
    * @param cost the cost to set
    */
   public void setCost(double cost) {
      this.cost = cost;
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

}
