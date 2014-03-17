/** Description of Program 
 * @file: DVDSaleList.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * The DVDSaleItem describes a dvd in a sale by its id value.
 */

package logicalComponents;

import java.util.ArrayList;

public class DVDSaleList {
   private ArrayList<SaleItem> saleItemList;

   /**
    * Constructor
    * @return reference to DVDSaleList item
    */
   public DVDSaleList() {
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
   public void addSaleItem(int dvdId, int desiredQuantity, int saleType) {
      SaleItem saleItem = new SaleItem(dvdId, desiredQuantity, saleType);
      saleItemList.add(saleItem);
   }
}
