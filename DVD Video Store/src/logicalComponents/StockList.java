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
	 * 
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
	 * @param index
	 *            is the location of the DVD item
	 * @return reference to the DVD instance
	 */
	public DVD getStockItem(int index) {
		return dvdStockList.get(index);
	}

	/**
	 * @param dvd
	 *            is the dvd being stored
	 * @return the dvd which was added
	 */
	public void add(DVD dvd) {
		dvdStockList.add(new DVD(dvd));
	}

	public void clear() {
		dvdStockList.clear();
	}

}
