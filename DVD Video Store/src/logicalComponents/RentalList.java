/** Description of Program 
 * @file: RentalList.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * This class contains the rental list which distinguishes between entries
 * by mapping values both by the customer id, and by the dvd which they
 * rented.
 */

package logicalComponents;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Set;

public class RentalList {
   private HashMap<SimpleEntry<Integer, Integer>, RentalItem> rentalItemList;

   /**
    * Constructor
    * @return reference to RentalList instance
    */
   public RentalList() {
      rentalItemList = new HashMap<SimpleEntry<Integer, Integer>, RentalItem>();
   }

   public int size() {
      return rentalItemList.size();
   }

   public Set<SimpleEntry<Integer, Integer>> getKeySet() {
      return rentalItemList.keySet();
   }

   /**
    * This method the rental item corresponding to the customer id and
    * unique dvd id.
    * 
    * @param custId is the unique id assigned to the customer
    * @param dvdId is the list pertaining to a particular return
    * @return the rental item corresponding to the customer id and dvd id
    */
   public RentalItem getRentalItem(int custId, int dvdId) {

      SimpleEntry<Integer, Integer> rentalItemTag =
            new SimpleEntry<Integer, Integer>(custId, dvdId);

      return rentalItemList.get(rentalItemTag);
   }

/**
    * This method updates the rental list once a purchase has been made.
    * Also note that this is an overloaded method, and also removes rental
    * items when the return sale occurs.
    * 
    * @param custId is the unique id assigned to the customer
    * @param dvdSaleList is the list pertaining to a particular sale
    */
   public void update(int custId, SaleList dvdSaleList) {
      int dvdId;
      String dvdName;

      for (int i = 0; i < dvdSaleList.size(); i++) {
         if (dvdSaleList.getSaleItem(i).getType() == Sale.BUY)
            continue;
         dvdId = dvdSaleList.getSaleItem(i).getId();
         dvdName = dvdSaleList.getSaleItem(i).getName();

         RentalItem rentalItem = new RentalItem(custId, dvdId, dvdName);

         SimpleEntry<Integer, Integer> rentalItemTag =
               new SimpleEntry<Integer, Integer>(custId, dvdId);
         rentalItemList.put(rentalItemTag, rentalItem);
         System.out.println("add to rental list : "
               + rentalItemList.get(rentalItemTag) + "\n");
      }
   }

/**
    * This method updates the rental list once a purchase has been made.
    * Also note that this is an overloaded method, and also removes rental
    * items when the return sale occurs.
    * 
    * @param custId is the unique id assigned to the customer
    * @param returnList is the list pertaining to a particular return
    */
   public void update(int custId, ReturnList returnList) {
      int returnId;

      for (int i = 0; i < returnList.size(); i++) {
         returnId = returnList.getReturnDVDId(i);

         SimpleEntry<Integer, Integer> rentalItemTag =
               new SimpleEntry<Integer, Integer>(custId, returnId);

         rentalItemList.remove(rentalItemTag);
         System.out.println("update rental list with returnlist: "
               + rentalItemList.get(rentalItemTag) + "\n");
      }

   }

}
