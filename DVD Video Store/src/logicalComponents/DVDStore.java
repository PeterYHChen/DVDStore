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

import graphicalComponent.MainInterface;

import java.awt.EventQueue;
import java.util.Locale;

import javax.swing.UIManager;

public class DVDStore {

   public static void main(String[] args) {
	  Locale.setDefault(Locale.US);
      try {
         UIManager
               .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      } catch (Throwable e) {
         e.printStackTrace();
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MainInterface frame = new MainInterface();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      }); // EventQueue
   }
}
