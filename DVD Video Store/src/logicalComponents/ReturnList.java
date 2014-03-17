/** Description of Program 
 * @file: ReturnList.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * The contains a list of DVD ids which indicated they are rented. Note
 * that the array only needs to be integers because we're only renting one
 * DVD at a time.
 */

package logicalComponents;

import java.util.ArrayList;

public class ReturnList {
   private ArrayList<Integer> idList;

   /**
    * Constructor
    * @return reference to DVDSaleList item
    */
   public ReturnList() {
      idList = new ArrayList<Integer>();
   }

   /**
    * @return size of RentalList
    */
   public int size() {
      return idList.size();
   }

   /**
    * @return DVD indicated by its id
    */
   public int getReturnDVDId(int index) {
      return idList.get(index);
   }

   /**
    * @param dvdId is the unique id assigned to the DVD
    */
   public void addReturnDVD(int dvdId) {
      idList.add(dvdId);
   }
}
