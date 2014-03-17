/** Description of Program 
 * @file: DVDStore.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * The main driver for the dvd store application. Contains the methods
 * which implement the four main processes. Later on these will be linked
 * to a GUI.
 */

package logicalComponents;

import java.util.Scanner;

public class DVDStore {
   final static int BUY = 1;
   final static int RENT = 2;

   private static Inventory inventory;
   private static RentalList rentalList;
   private static CustomerList customerList;
   private static Scanner in = new Scanner(System.in);

   public static void main(String[] args) {
      openStore();
      customerRegistrationScenario();
      stockDVDScenario();
      checkOutScenario();
      checkInScenario();
      // store.run();
   }

   public static void openStore() {
      inventory = new Inventory();
      rentalList = new RentalList();
      customerList = new CustomerList();
   }

   public void run() {
      // connect to the java GUI
   }

   public static void customerRegistrationScenario() {
      // input customer name and id
      System.out.println("Enter the customer name: ");
      String custName = in.nextLine();

      Customer customer = new Customer(custName);
      customerList.add(customer);
   }

   public static void stockDVDScenario() {
      StockList stockList = new StockList();

      System.out.println("The store is stocked with the following DVDs, ");
      System.out.println(" - Star Wars");
      System.out.println(" - The Notebook");
      System.out.println(" - Toy Story");
      stockList.stockDVD(1, 10, "Star Wars", 1);
      stockList.stockDVD(2, 10, "The Notebook", 1);
      stockList.stockDVD(3, 10, "Toy Story", 1);
      inventory.update(stockList);
   }

   public static void checkOutScenario() {
      int custId = 1; // temporary id for this scenario
      Sale sale = new Sale(custId);

      System.out.println("Check if Star Wars available : "
            + inventory.checkQuantity(1, 1));
      sale.addDVD(1, 1, Sale.BUY);
      sale.updateTotal(inventory.getCost(1), Sale.BUY);
      System.out.println("Total is : " + sale.getTotal());

      System.out.println("Customer pays with $20 bill.");
      System.out.println("Change is : " + sale.completePayment(20.0));
      inventory.update(sale.getSaleList());
      rentalList.update(sale.getCustomerId(), sale.getSaleList());
   }

   public static void checkInScenario() {
      int custId = 1; // temporary id for this scenario
      ReturnSale returnSale = new ReturnSale(custId);

      returnSale.returnDVD(1);
      returnSale.updateTotal(rentalList.getRentalItem(1, 1).getFee());

      System.out.println("The total cost of return is : "
            + returnSale.getTotal());

      inventory.update(returnSale.getReturnList());
      rentalList.update(returnSale.getCustomerId(), returnSale.getReturnList());

      System.out.println("No need for payment, so change is : "
            + returnSale.completePayment(0.0));

   }
}
