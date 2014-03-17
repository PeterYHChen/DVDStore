package graphicalComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MainInterface extends JFrame {

   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private JTextField nameField;
   private JTextField idField;
   private String customerName;
   private int customerId;

   private JLabel registerLabel, statusLabel, signNameLabel;
   private JTextField textField;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
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
      });
   }

   /**
    * Create the frame.
    */
   public MainInterface() {

      // - Setup Content Pane - - - - - - - - - - - - - - - - - - - - - - - //
      setIconImage(Toolkit
            .getDefaultToolkit()
            .getImage(
                  MainInterface.class
                        .getResource("/com/sun/java/swing/plaf/motif/icons/ScrollDownArrowActive.gif")));
      setTitle("Video Store Application - AP Video");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 600, 400);
      contentPane = new JPanel();
      contentPane.setBackground(Color.LIGHT_GRAY);
      contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
      setContentPane(contentPane);

      // - Setup Content Pane - - - - - - - - - - - - - - - - - - - - - - - //

      contentPane.setLayout(new CardLayout(0, 0));

      JPanel mainWindow = new JPanel();
      contentPane.add(mainWindow, "name_14295185518890");
      mainWindow.setLayout(null);

      // - Setup Content Pane - - - - - - - - - - - - - - - - - - - - - - - //

      JPanel logIn = new JPanel();
      logIn.setBounds(403, 11, 171, 254);
      mainWindow.add(logIn);
      logIn.setBorder(new TitledBorder(UIManager
            .getBorder("TitledBorder.border"), "Sign in Here",
            TitledBorder.RIGHT, TitledBorder.TOP, null, null));
      logIn.setLayout(null);

      JLabel idLabel = new JLabel("Store ID:");
      idLabel.setBounds(10, 58, 46, 14);
      logIn.add(idLabel);

      registerLabel = new JLabel("Registration: ");
      registerLabel.setBounds(10, 142, 137, 14);
      logIn.add(registerLabel);

      statusLabel = new JLabel("Status: Offline");
      statusLabel.setBounds(10, 167, 137, 14);
      logIn.add(statusLabel);

      JLabel welcomeLabel = new JLabel("Welcome :");
      welcomeLabel.setBounds(10, 192, 137, 14);
      logIn.add(welcomeLabel);

      signNameLabel = new JLabel("- - - - - - -");
      signNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
      signNameLabel.setBounds(10, 217, 137, 14);
      logIn.add(signNameLabel);

      JButton signIn = new JButton("Sign In");
      signIn.setBounds(10, 105, 89, 23);
      logIn.add(signIn);

      nameField = new JTextField();
      nameField.setBounds(10, 32, 137, 20);
      logIn.add(nameField);
      nameField.setColumns(10);

      JLabel nameLabel = new JLabel("Name:");
      nameLabel.setBounds(10, 16, 46, 14);
      logIn.add(nameLabel);

      idField = new JTextField();
      idField.setColumns(10);
      idField.setBounds(10, 74, 137, 20);
      logIn.add(idField);

      // - Setup Content Pane - - - - - - - - - - - - - - - - - - - - - - - //

      JPanel logo = new JPanel();
      logo.setBounds(10, 11, 383, 254);
      mainWindow.add(logo);

      JLabel logoLabel = new JLabel();
      GridBagConstraints gbc_logoLabel = new GridBagConstraints();
      gbc_logoLabel.anchor = GridBagConstraints.NORTHWEST;
      gbc_logoLabel.gridx = 0;
      gbc_logoLabel.gridy = 0;
      logo.add(logoLabel, gbc_logoLabel);
      logoLabel
            .setIcon(new ImageIcon(
                  "C:\\Users\\Alex\\Desktop\\PRGM\\Data Structures\\Programs\\DVD Video Store\\src\\graphicalComponent\\logo.png"));

      // - Setup Content Pane - - - - - - - - - - - - - - - - - - - - - - - //

      JPanel mainControl = new JPanel();
      mainControl.setBounds(20, 276, 546, 70);
      mainWindow.add(mainControl);
      mainControl.setBorder(new TitledBorder(UIManager
            .getBorder("TitledBorder.border"), "Video Options",
            TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
      mainControl.setLayout(null);

      JButton registrationButton = new JButton("Registration");

      registrationButton.setHorizontalAlignment(SwingConstants.LEFT);
      registrationButton
            .setSelectedIcon(new ImageIcon(
                  MainInterface.class
                        .getResource("/com/sun/java/swing/plaf/motif/icons/ScrollRightArrow.gif")));
      registrationButton
            .setIcon(new ImageIcon(
                  MainInterface.class
                        .getResource("/com/sun/java/swing/plaf/motif/icons/ScrollRightArrowActive.gif")));
      registrationButton.setBounds(10, 20, 122, 42);
      mainControl.add(registrationButton);

      // - Setup Content Pane - - - - - - - - - - - - - - - - - - - - - - - //

      JButton stockButton = new JButton("Stock DVD");
      stockButton.setHorizontalAlignment(SwingConstants.LEFT);
      stockButton
            .setIcon(new ImageIcon(
                  MainInterface.class
                        .getResource("/com/sun/java/swing/plaf/motif/icons/ScrollRightArrowActive.gif")));
      stockButton.setBounds(139, 20, 111, 42);
      mainControl.add(stockButton);

      // - Setup Content Pane - - - - - - - - - - - - - - - - - - - - - - - //

      JButton checkInButton = new JButton("Check-In DVD");
      checkInButton
            .setIcon(new ImageIcon(
                  MainInterface.class
                        .getResource("/com/sun/java/swing/plaf/motif/icons/ScrollRightArrowActive.gif")));
      checkInButton.setBounds(403, 20, 122, 42);
      mainControl.add(checkInButton);

      // - Setup Content Pane - - - - - - - - - - - - - - - - - - - - - - - //

      JButton checkOutButton = new JButton("Check-Out DVD");
      checkOutButton.setHorizontalAlignment(SwingConstants.LEFT);
      checkOutButton
            .setIcon(new ImageIcon(
                  MainInterface.class
                        .getResource("/com/sun/java/swing/plaf/motif/icons/ScrollRightArrowActive.gif")));
      checkOutButton.setBounds(260, 20, 133, 42);
      mainControl.add(checkOutButton);

      JPanel customerWindow = new JPanel();
      contentPane.add(customerWindow, "name_14707922355637");
      customerWindow.setLayout(null);

      JLabel lblPleaseEnterYour = new JLabel("Please Enter Your Name Below");
      lblPleaseEnterYour.setBounds(10, 11, 519, 14);
      customerWindow.add(lblPleaseEnterYour);

      textField = new JTextField();
      textField.setBounds(10, 31, 466, 20);
      customerWindow.add(textField);
      textField.setColumns(10);

      JButton btnNewButton = new JButton("New button");
      btnNewButton.setBounds(10, 62, 89, 23);
      customerWindow.add(btnNewButton);

      JButton btnNewButton_1 = new JButton("New button");
      btnNewButton_1.setBounds(109, 62, 89, 23);
      customerWindow.add(btnNewButton_1);

      SignInListener login = new SignInListener();
      signIn.addActionListener(login);

   }

   // ------------------------- Action Listeners -----------------------------//

   public class SignInListener implements ActionListener {
      public void actionPerformed(ActionEvent event) {
         customerName = nameField.getText();
         customerId = Integer.parseInt(idField.getText());

         registerLabel.setText("Registration: Not Complete");
         statusLabel.setText("Status : Online");
         signNameLabel.setText(customerName + " : " + customerId + " (id)");
      }
   }

   /*
    * private class StartListener implements ActionListener {
    * public void actionPerformed(ActionEvent event) {
    * this.add(questionMenu);
    * // switchFrame.revalidate();
    * this.getContentPane().validate();
    * this.repaint();
    * }
    * }
    */

}
