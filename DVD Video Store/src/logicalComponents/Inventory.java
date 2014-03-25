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

import java.util.ArrayList;

public class Inventory {
   private ArrayList<DVD> dvdInventory;
   int numOfDVD;

   /**
    * Constructor
    * @return reference to a Inventory object
    */
   public Inventory() {
      dvdInventory = new ArrayList<DVD>();
      numOfDVD = 0;
   }

   public int size() {
      return dvdInventory.size();
   }

   public int getId(int index) {
      return dvdInventory.get(index).getId();
   }

public String getName(int index) {
      return dvdInventory.get(index).getName();
   }

public int getQuantity(int index) {
      return dvdInventory.get(index).getQuantity();
   }

/**
    * @param dvdId is the unique id of the DVD
    */
   public double getCost(int index) {
      return dvdInventory.get(index).getCost();
   }

/**
    * Adds a DVD to the inventory. Note that this is private, as DVDs
    * are only added from the corresponding lists.
    * 
    * @param newDVD is the DVD to be added to the inventory
    */
   public void addDVD(DVD newDVD) {
      dvdInventory.add(newDVD);
   }

   public boolean matchIdToName(DVD dvd) {
      for (DVD listDVD : dvdInventory)
         if (listDVD.getId() == dvd.getId())
            if (listDVD.getName().equalsIgnoreCase(dvd.getName()))
               return true;

      return false;   
   }

   public boolean containsName(String dvdName) {
      for (DVD dvd : dvdInventory)
         if (dvd.getName().equalsIgnoreCase(dvdName))
            return true;
      return false;
   }

/**
    * This method checks the quantity of the DVD. This is only performed
    * when a customer is buying a DVD, as only one can be rented at a time.
    * 
    * @param index is the location of the DVD item
    * @return reference to the DVD instance
    */
   public boolean checkQuantity(int dvdId, int desiredQuantity) {

      if ((dvdInventory.get(dvdId - 1).getQuantity() - desiredQuantity) >= 0)
         return true;

      return false;
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
         if (currentDVD.getId() == 0) {
            currentDVD.setId(++numOfDVD);
            addDVD(currentDVD);
            continue;
         }

         newQuantity = dvdInventory.get(currentDVD.getId() - 1).getQuantity()
               + currentDVD.getQuantity();

         dvdInventory.get(currentDVD.getId() - 1).setQuantity(newQuantity);

      }// end for-loop
      System.out.println("update inventory with stock list : ");
      printInventory();
      System.out.println("");
   }

   /**
    * This method updates the inventory of DVDs once the sale
    * procedure is finished.
    * 
    * @param dvdSaleList is the list of DVDs which are to be added to the
    *        inventory
    */
   public void update(SaleList dvdSaleList) {
      int newQuantity;
      SaleItem currentItem;

      // Idea is to iterate through the dvdSaleList
      for (int i = 0; i < dvdSaleList.size(); i++) {
         currentItem = dvdSaleList.getSaleItem(i);

         newQuantity = dvdInventory.get(currentItem.getId() - 1).getQuantity()
               - currentItem.getQuantity();

         // Update quantity of item
         dvdInventory.get(currentItem.getId() - 1).setQuantity(newQuantity);

      }//end for-loop
      System.out.println("update inventory with dvd sale list : ");
      printInventory();
      System.out.println("");
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
         newQuantity = dvdInventory.get(returnID - 1).getQuantity() + 1;
         dvdInventory.get(returnID - 1).setQuantity(newQuantity);
      }//end for-loop
      System.out.println("update inventory with return list : ");
      printInventory();
      System.out.println("");
   }

   public void printInventory() {
      for (int i = 0; i < dvdInventory.size(); i++)
         System.out.println("id: " + dvdInventory.get(i).getId() + dvdInventory.get(i));
   }

}
