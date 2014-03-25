/** Description of Program 
 * @file: DVDSaleList.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * The DVDSaleItem describes a dvd in a sale by its id value.
 */

package logicalComponents;

import java.util.ArrayList;

public class SaleList {
   private ArrayList<SaleItem> saleItemList;

   /**
    * Constructor
    * @return reference to DVDSaleList item
    */
   public SaleList() {
      saleItemList = new ArrayList<SaleItem>();
   }

   /**
    * @return size of DVDSaleList
    */
   public int size() {
      return saleItemList.size();
   }

   /**
    * @return SaleItem in the position of given index
    */
   public SaleItem getSaleItem(int index) {
      return saleItemList.get(index);
   }

   /**
    * @param dvdId is the unique id assigned to the DVD
    * @param desiredQuantity is the quantity requested by the customer
    * @param saleType indicates whether a sale or rent is occuring
    */
   public void addSaleItem(SaleItem item) {
      saleItemList.add(new SaleItem(item));
   }

   public boolean checkSaleItemDuplicate(String saleItemName) {
      for (SaleItem item : saleItemList)
         if (item.getName().equalsIgnoreCase(saleItemName))
            return true;
      return false;
   }
}
