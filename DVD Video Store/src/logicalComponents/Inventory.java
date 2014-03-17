/** Description of Program 
 * @file: Inventory.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * The Iventory is another key feature of the video store. This contains
 * permanent information about the store's stock. There is an overloaded
 * method for updating the inventory, in which we update it with the
 * sale list, rental list, and stock list
 */

package logicalComponents;

import java.util.HashMap;

public class Inventory {
   private HashMap<Integer, DVD> dvdInventory;
   int numOfDVD;

   /**
    * Constructor
    * @return reference to a Inventory object
    */
   public Inventory() {
      dvdInventory = new HashMap<Integer, DVD>();
      numOfDVD = 0;
   }

   /**
    * Adds a DVD to the inventory. Note that this is private, as DVDs
    * are only added from the corresponding lists.
    * 
    * @param newDVD is the DVD to be added to the inventory
    */
   private void addDVD(DVD newDVD) {
      dvdInventory.put(newDVD.getId(), newDVD);
   }

   /**
    * This method checks the quantity of the DVD. This is only performed
    * when a customer is buying a DVD, as only one can be rented at a time.
    * 
    * @param index is the location of the DVD item
    * @return reference to the DVD instance
    */
   public boolean checkQuantity(int dvdId, int desiredQuantity) {

      if ((dvdInventory.get(dvdId).getQuantity() - desiredQuantity) >= 0)
         return true;

      return false;
   }

   /**
    * @param dvdId is the unique id of the DVD
    */
   public double getCost(int dvdId) {
      return dvdInventory.get(dvdId).getCost();
   }

   /**
    * This method updates the inventory of DVDs once the stocking
    * procedure is finished.
    * 
    * @param stocklist is the list of DVDs which are to be added to the
    *        inventory
    */
   public void update(StockList stockList) {
      int newQuantity;
      DVD currentDVD;

      // Idea is to iterate through the stocklist
      for (int i = 0; i < stockList.size(); i++) {
         currentDVD = stockList.getStockItem(i);

         // If DVD does not exist in list assign id and add
         if (!dvdInventory.containsValue(currentDVD)) {
            currentDVD.setId(++numOfDVD);
            addDVD(currentDVD);
            continue;
         }

         newQuantity = dvdInventory.get(currentDVD.getId()).getQuantity()
               + currentDVD.getQuantity();

         dvdInventory.get(currentDVD.getId()).setQuantity(newQuantity);

      }// end for loop
   }

   /**
    * This method updates the inventory of DVDs once the sale
    * procedure is finished.
    * 
    * @param dvdSaleList is the list of DVDs which are to be added to the
    *        inventory
    */
   public void update(DVDSaleList dvdSaleList) {
      int newQuantity;
      SaleItem currentItem;

      // Idea is to iterate through the dvdSaleList
      for (int i = 0; i < dvdSaleList.size(); i++) {
         currentItem = dvdSaleList.getSaleItem(i);

         newQuantity = dvdInventory.get(currentItem.getId()).getQuantity()
               - currentItem.getQuantity();

         // Update quantity of item
         dvdInventory.get(currentItem.getId()).setQuantity(newQuantity);

      }
   }

   /**
    * This method updates the inventory of DVDs once the return
    * procedure is finished.
    * 
    * @param returnList is the list of DVDs which are to be added to the
    *        inventory
    */
   public void update(ReturnList returnList) {
      int returnID;
      int newQuantity;

      for (int i = 0; i < returnList.size(); i++) {
         returnID = returnList.getReturnDVDId(i);

         // We assume only one DVD can be rented at a time
         newQuantity = dvdInventory.get(returnID).getQuantity() - 1;
         dvdInventory.get(returnID).setQuantity(newQuantity);
      }
   }

}
