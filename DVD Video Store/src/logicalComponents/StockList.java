/** Description of Program 
 * @file: StockList.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * The Stocklist maintains a list of all the DVDs in stock.
 * Note that DVDs are never removed from the list
 */

package logicalComponents;

import java.util.ArrayList;

public class StockList {
   private ArrayList<DVD> dvdStockList;

   /**
    * Constructor
    * @return reference to a Stocklist object
    */
   public StockList() {
      dvdStockList = new ArrayList<DVD>();
   }

   /**
    * @return the size of the DVD list
    */
   public int size() {
      return dvdStockList.size();
   }

   /**
    * @param index is the location of the DVD item
    * @return reference to the DVD instance
    */
   public DVD getStockItem(int index) {
      return dvdStockList.get(index);
   }

   /**
    * @param id is the unique id of the DVD
    * @param name is the name of the DVD
    * @param quantity is the number of the DVD in stock
    * @param cost is the cost of the DVD
    */
   public void stockDVD(int id, double cost, String name, int quantity) {
      DVD dvd = new DVD(id, name, quantity, cost);
      dvdStockList.add(dvd);
   }

}
