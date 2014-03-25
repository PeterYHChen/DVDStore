/** Description of Program 
 * @file: DVD.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * The DVD ADT which is the main feature of the DVD store. Stores
 * information about the name, quantity, cost, and id of the DVD.
 */

package logicalComponents;

import java.text.NumberFormat;

public class DVD {
   private int id;
   private String name;
   private int quantity;
   private double cost;
   private NumberFormat dollarFormatter;

   // Java will automatically initialize all variables to zero or empty string
   public DVD() {
      dollarFormatter = NumberFormat.getCurrencyInstance();
      id = 0;
      name = "";
      quantity = 0;
      cost = 0.0;
   }

/**
    * Constructor
    * @param dvdId is the unique id of the DVD
    * @param dvdName is the name of the DVD
    * @param dvdQuantity is the number of the DVD in stock
    * @param dvdCost is the cost of the DVD
    * @return reference to a DVD object
    */
   public DVD(DVD dvd) {
      dollarFormatter = NumberFormat.getCurrencyInstance();
      id = dvd.getId();
      name = dvd.getName();
      quantity = dvd.getQuantity();
      cost = dvd.getCost();
   }

   public DVD(int DVDId, String DVDName, int DVDQuantity, double DVDCost) {
      dollarFormatter = NumberFormat.getCurrencyInstance();
      id = DVDId;
      name = DVDName;
      quantity = DVDQuantity;
      cost = DVDCost;
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
   public void setQuantity(int newQuantity) {
      quantity = newQuantity;
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

   public String toString() {
      return "Name: \t" + name + "\n# of: \t" + quantity + "\nCost: \t"
            + dollarFormatter.format(cost) + "\n\n";
   }
}
