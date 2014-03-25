/** Description of Program 
 * @file: MainInterface.java
 * @author: Alex Dodge, YongHong Chan
 * @date: 14/03/2014
 * 
 * The main GUI component for the video store.
 */

package graphicalComponent;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.AbstractMap.SimpleEntry;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import logicalComponents.Customer;
import logicalComponents.DVD;
import logicalComponents.DVDStoreController;
import logicalComponents.RentalItem;
import logicalComponents.SaleItem;

public class MainInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private final static int MAIN_PANEL = 1;
	private final static int STOCK_PANEL = 2;
	private final static int CHECKOUT_PANEL = 3;
	private final static int CHECKIN_PANEL = 4;
	private int CURRENT_PANEL = MAIN_PANEL;
	// Controller which manages the functionality of the DVD store
	private DVDStoreController runStore;

	// * * * Variable instantiation * * *
	// Usually the main panels would be contained in their own classes, but
	// for ease of implementation they remain in one
	private JPanel contentPane, customerWindow, mainWindow, logIn, logo,
			mainControl, stockWindow, stockListWindow, checkOutWindow, panel,
			checkInWindow, returnReceiptWindow;

	private JLabel registerLabel, statusLabel, signNameLabel, idLabel,
			welcomeLabel, nameLabel, logoLabel, customerTitle, stockInfo,
			quantityLabel, costLabel, customerNameBuyLabel, idBuyLabel,
			totalAmountBuyLabel, chooseDVDLabel, quantityBuyLabel,
			amountDueBuyLabel, enterPaymentBuyLabel, customerNameReturnLabel,
			idReturnLabel, totalAmountLabel, returnTitleLabel,
			finishReturnLabel, dvdIdLabel;

	private JButton registrationButton, checkInButton, stockButton,
			checkOutButton, backStockButton, backCheckInButton,
			backCheckOutButton, backRegButton, submitButton, addDVDButton,
			stockAllDvdsButton, addPurchaseButton, completePurchaseBuyButton,
			returnDVDButton, finishReturnButton;

	private JSpinner quantitySpinner, costSpinner, quantityBuySpinner,
			idSpinner, paymentBuySpinner, paymentRentSpinner;

	private JTextField nameField, idField, registerTextField, stockInputField;
	private JTextArea stockListBox, textPane, returnReceipt;
	private JComboBox<String> buyRentChoice, rentedDVDBox;
	private JSeparator sep1, sep3, sep4, sep2;
	private JRadioButton radioRent, radioBuy;
	private ButtonGroup buttonGroup;
	private ImageIcon iconLogo, iconMainButton, iconDoneButton;
	private ActionListener goBack, goRegisterCustomer, goAddDVD, goFinStock,
			goAddSaleItem, goFinishPurchase, goAddReturnItem, goFinishReturn;

	// These variables are used to buffer data into the store controller
	private boolean isReg;
	private Customer tempCustomer;
	private DVD tempDVD;
	private SaleItem tempSaleItem;
	private RentalItem tempRentalItem;
	private boolean finalized;
	private Vector<String> buyNamesComboList;
	private Vector<String> rentNamesComboList;
	private DefaultComboBoxModel<String> buyModel, rentModel;

	// Allows the output to be formatted to dollars
	private NumberFormat dollarFormatter;

	/**
	 * Constructor
	 */
	public MainInterface() {

		// The main data controlling instances are created
		runStore = new DVDStoreController();
		tempCustomer = new Customer();
		tempDVD = new DVD();
		tempSaleItem = new SaleItem();
		isReg = false;
		finalized = true;
		buyNamesComboList = new Vector<String>();
		rentNamesComboList = new Vector<String>();
		dollarFormatter = NumberFormat.getCurrencyInstance();

		setTitle("Alex and Peter Video Inc.");
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Content pane is what all other panels paint on
		contentPane = new JPanel();
		contentPane.setOpaque(true);
		setContentPane(contentPane);

		// Private methods contain creation of components
		createActionListeners();
		createPanels();
		createButtons();
		createLabels();
		createTextFields();
		createUniqueComponents();
		createRadioButtons();

		setAlignment();
		setComponentBounds();
		setComponentBorders();
		setComponentIcons();

		// The card layout allows switching between JPanels
		contentPane.setLayout(new CardLayout(0, 0));

		contentPane.add(mainWindow, "mainWindow");
		contentPane.add(customerWindow, "customerWindow");
		contentPane.add(stockWindow, "stockWindow");
		contentPane.add(checkOutWindow, "checkOutWindow");
		contentPane.add(checkInWindow, "checkInWindow");

		// Required when setting components in absolute position
		returnReceiptWindow.setLayout(null);
		mainWindow.setLayout(null);
		customerWindow.setLayout(null);
		stockWindow.setLayout(null);
		checkOutWindow.setLayout(null);
		stockListWindow.setLayout(null);
		panel.setLayout(null);
		checkInWindow.setLayout(null);

		// Sets the length of the text fields
		nameField.setColumns(10);
		idField.setColumns(10);
		registerTextField.setColumns(10);
		stockInputField.setColumns(10);

		// Sets the starting, min, max, and increment values for spinners
		quantitySpinner.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		idSpinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		costSpinner.setModel(new SpinnerNumberModel(0.0, 0.0, 40.0, 2.0));
		quantityBuySpinner.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		paymentBuySpinner
				.setModel(new SpinnerNumberModel(0.0, 0.0, 300.0, 5.0));

		stockListBox.setEditable(false);
		textPane.setEditable(false);
		returnReceipt.setEditable(false);

		addActionComponents();
		addComponentsToFrame();

	}

	private void setAlignment() {
		signNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stockButton.setHorizontalAlignment(SwingConstants.LEFT);
		checkOutButton.setHorizontalAlignment(SwingConstants.LEFT);
		completePurchaseBuyButton.setHorizontalAlignment(SwingConstants.LEFT);
		finishReturnButton.setHorizontalAlignment(SwingConstants.LEFT);
	}

	private void setComponentBorders() {
		logIn.setBorder(new TitledBorder(new LineBorder(
				new Color(192, 192, 192), 1, true), "Sign in Here",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		logIn.setLayout(null);

		mainControl.setBorder(new TitledBorder(new LineBorder(new Color(192,
				192, 192), 1, true), "Video Options", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		mainControl.setLayout(null);

		stockListWindow.setBorder(new TitledBorder(new LineBorder(new Color(
				192, 192, 192), 1, true), "DVDs to be Stocked",
				TitledBorder.RIGHT, TitledBorder.TOP, null, null));

		panel.setBorder(new TitledBorder(new LineBorder(
				new Color(192, 192, 192), 1, true), "Receipt",
				TitledBorder.RIGHT, TitledBorder.TOP, null, null));

		returnReceiptWindow.setBorder(new TitledBorder(new LineBorder(
				new Color(192, 192, 192), 1, true), "Return Receipt",
				TitledBorder.RIGHT, TitledBorder.TOP, null, null));

	}

	private void addComponentsToFrame() {

		mainWindow.add(logIn);
		logo.add(logoLabel);
		logIn.add(idLabel);
		logIn.add(registerLabel);
		logIn.add(statusLabel);
		logIn.add(welcomeLabel);
		logIn.add(signNameLabel);
		logIn.add(nameField);
		logIn.add(nameLabel);
		logIn.add(idField);
		mainWindow.add(logo);
		mainWindow.add(mainControl);
		mainControl.add(registrationButton);
		mainControl.add(stockButton);
		mainControl.add(checkInButton);
		mainControl.add(checkOutButton);
		customerWindow.add(customerTitle);
		customerWindow.add(registerTextField);
		customerWindow.add(submitButton);
		customerWindow.add(backRegButton);
		stockWindow.add(stockListWindow);
		stockListWindow.add(stockListBox);
		stockWindow.add(stockInfo);
		stockWindow.add(stockInputField);
		stockWindow.add(addDVDButton);
		stockWindow.add(backStockButton);
		stockWindow.add(stockAllDvdsButton);
		stockWindow.add(quantitySpinner);
		stockWindow.add(quantityLabel);
		stockWindow.add(costSpinner);
		stockWindow.add(idSpinner);
		stockWindow.add(costLabel);

		stockWindow.add(dvdIdLabel);
		checkOutWindow.add(customerNameBuyLabel);
		checkOutWindow.add(idBuyLabel);
		checkOutWindow.add(panel);
		panel.add(textPane);
		panel.add(totalAmountBuyLabel);
		checkOutWindow.add(buyRentChoice);
		checkOutWindow.add(sep1);
		checkOutWindow.add(chooseDVDLabel);
		buttonGroup.add(radioBuy);
		checkOutWindow.add(radioBuy);
		buttonGroup.add(radioRent);
		checkOutWindow.add(radioRent);
		checkOutWindow.add(quantityBuyLabel);
		checkOutWindow.add(quantityBuySpinner);
		checkOutWindow.add(addPurchaseButton);
		checkOutWindow.add(sep3);
		checkOutWindow.add(amountDueBuyLabel);
		checkOutWindow.add(enterPaymentBuyLabel);
		checkOutWindow.add(paymentBuySpinner);
		checkOutWindow.add(completePurchaseBuyButton);
		checkOutWindow.add(backCheckOutButton);
		checkInWindow.add(customerNameReturnLabel);
		checkInWindow.add(idReturnLabel);
		checkInWindow.add(returnReceiptWindow);
		returnReceiptWindow.add(returnReceipt);
		returnReceiptWindow.add(totalAmountLabel);
		checkInWindow.add(sep2);
		checkInWindow.add(returnTitleLabel);
		checkInWindow.add(rentedDVDBox);
		checkInWindow.add(returnDVDButton);
		checkInWindow.add(finishReturnLabel);
		checkInWindow.add(sep4);
		checkInWindow.add(paymentRentSpinner);
		checkInWindow.add(finishReturnButton);
		checkInWindow.add(backCheckInButton);
	}

	private void createRadioButtons() {
		buttonGroup = new ButtonGroup();

		radioRent = new JRadioButton("Rent");
		radioBuy = new JRadioButton("Buy");
	}

	private void setComponentBounds() {
		logIn.setBounds(403, 11, 171, 254);
		idLabel.setBounds(10, 75, 46, 14);
		registerLabel.setBounds(10, 122, 137, 14);
		statusLabel.setBounds(10, 147, 137, 14);
		welcomeLabel.setBounds(10, 172, 137, 14);
		signNameLabel.setBounds(10, 197, 137, 14);
		nameField.setBounds(10, 44, 137, 20);
		nameLabel.setBounds(10, 28, 46, 14);
		idField.setBounds(10, 91, 137, 20);
		logo.setBounds(10, 10, 383, 254);
		mainControl.setBounds(10, 276, 564, 75);
		registrationButton.setBounds(24, 20, 122, 42);
		stockButton.setBounds(156, 20, 111, 42);
		checkInButton.setBounds(420, 20, 122, 42);
		checkOutButton.setBounds(277, 20, 133, 42);
		customerTitle.setBounds(10, 11, 519, 14);
		registerTextField.setBounds(10, 31, 466, 20);
		submitButton.setBounds(10, 62, 89, 23);
		backRegButton.setBounds(109, 62, 89, 23);
		stockListWindow.setBounds(269, 11, 301, 340);
		stockListBox.setBounds(10, 22, 281, 307);
		stockInfo.setBounds(10, 11, 249, 14);
		stockInputField.setBounds(10, 36, 249, 20);
		addDVDButton.setBounds(10, 161, 89, 23);
		backStockButton.setBounds(10, 328, 89, 23);
		stockAllDvdsButton.setBounds(109, 328, 120, 23);
		quantitySpinner.setBounds(67, 67, 61, 20);
		quantityLabel.setBounds(10, 70, 61, 14);
		costSpinner.setBounds(67, 98, 61, 20);
		idSpinner.setBounds(67, 129, 61, 21);
		costLabel.setBounds(10, 101, 46, 14);
		customerNameBuyLabel.setBounds(10, 11, 256, 14);
		idBuyLabel.setBounds(10, 31, 256, 14);
		panel.setBounds(276, 11, 298, 340);
		textPane.setBounds(10, 21, 278, 288);
		totalAmountBuyLabel.setBounds(10, 315, 146, 14);
		buyRentChoice.setBounds(10, 88, 256, 20);
		sep1.setBounds(10, 56, 256, 14);
		chooseDVDLabel.setBounds(10, 66, 235, 14);
		radioBuy.setBounds(10, 115, 46, 23);
		radioRent.setBounds(60, 115, 49, 23);
		quantityBuyLabel.setBounds(139, 119, 59, 14);
		quantityBuySpinner.setBounds(198, 116, 68, 20);
		addPurchaseButton.setBounds(10, 150, 131, 23);
		sep3.setBounds(10, 184, 256, 14);
		amountDueBuyLabel.setBounds(10, 197, 235, 14);
		enterPaymentBuyLabel.setBounds(10, 219, 88, 14);
		paymentBuySpinner.setBounds(10, 238, 88, 20);
		completePurchaseBuyButton.setBounds(10, 269, 139, 23);
		backCheckOutButton.setBounds(10, 328, 89, 23);
		customerNameReturnLabel.setBounds(10, 11, 147, 14);
		idReturnLabel.setBounds(10, 30, 46, 14);
		returnReceiptWindow.setBounds(286, 11, 288, 340);
		returnReceipt.setBounds(10, 22, 268, 286);
		totalAmountLabel.setBounds(10, 315, 118, 14);
		sep2.setBounds(10, 55, 270, 14);
		returnTitleLabel.setBounds(10, 66, 266, 14);
		rentedDVDBox.setBounds(10, 88, 266, 20);
		returnDVDButton.setBounds(10, 120, 89, 23);
		finishReturnLabel.setBounds(10, 168, 238, 14);
		sep4.setBounds(10, 154, 270, 14);
		paymentRentSpinner.setBounds(10, 191, 89, 20);
		finishReturnButton.setBounds(10, 222, 114, 23);
		backCheckInButton.setBounds(10, 328, 89, 23);

	}

	private void setComponentIcons() {
		iconLogo = new ImageIcon(getClass().getResource(
				"/graphicalComponent/logo.png"));
		iconMainButton = new ImageIcon(getClass().getResource(
				"/graphicalComponent/buttonLogo.png"));
		iconDoneButton = new ImageIcon(getClass().getResource(
				"/graphicalComponent/doneLogo.png"));

		logoLabel.setIcon(iconLogo);
		registrationButton.setIcon(iconMainButton);
		stockButton.setIcon(iconMainButton);
		checkInButton.setIcon(iconMainButton);
		checkOutButton.setIcon(iconMainButton);
		stockAllDvdsButton.setIcon(iconDoneButton);
		completePurchaseBuyButton.setIcon(iconDoneButton);
		finishReturnButton.setIcon(iconDoneButton);

	}

	private void createTextFields() {
		nameField = new JTextField();
		idField = new JTextField();
		idField.setToolTipText("0 indicates new customer, > 0 if customer already registered.");
		registerTextField = new JTextField();
		stockInputField = new JTextField();

		stockListBox = new JTextArea();
		stockListBox.setFont(new Font("Courier New", Font.PLAIN, 11));
		textPane = new JTextArea();
		textPane.setFont(new Font("Courier New", Font.PLAIN, 11));
		returnReceipt = new JTextArea();
		returnReceipt.setFont(new Font("Courier New", Font.PLAIN, 11));
	}

	private void createUniqueComponents() {
		quantitySpinner = new JSpinner();
		quantitySpinner.setValue(1);
		idSpinner = new JSpinner();
		idSpinner
				.setToolTipText("An id of 0 indicates a new DVD, while > 0 indicates DVD is in inventory");
		idSpinner.setValue(0);
		costSpinner = new JSpinner();
		costSpinner.setValue(0.0);
		quantityBuySpinner = new JSpinner();
		quantityBuySpinner.setValue(1);
		paymentBuySpinner = new JSpinner();
		paymentBuySpinner.setValue(0.0);
		paymentRentSpinner = new JSpinner();
		paymentRentSpinner.setValue(0.0);

		buyModel = new DefaultComboBoxModel<String>(buyNamesComboList);
		buyRentChoice = new JComboBox<String>(buyModel);
		rentModel = new DefaultComboBoxModel<String>(rentNamesComboList);
		rentedDVDBox = new JComboBox<String>(rentModel);

		sep1 = new JSeparator();
		sep2 = new JSeparator();
		sep3 = new JSeparator();
		sep4 = new JSeparator();

	}

	private void createLabels() {
		dvdIdLabel = new JLabel("DVD id :");
		dvdIdLabel.setBounds(10, 132, 46, 14);
		idLabel = new JLabel("Store ID:");
		registerLabel = new JLabel("Registration: ");
		statusLabel = new JLabel("Status: Offline");
		welcomeLabel = new JLabel("Welcome :");
		signNameLabel = new JLabel("- - - - - - -");
		nameLabel = new JLabel("Name:");
		logoLabel = new JLabel();
		customerTitle = new JLabel("Please Enter Your Name Below");
		stockInfo = new JLabel("Enter the name of the DVD Below");
		quantityLabel = new JLabel("Quantity :");
		costLabel = new JLabel("Cost :");
		customerNameBuyLabel = new JLabel("Customer Name :");
		idBuyLabel = new JLabel("Id : ");
		totalAmountBuyLabel = new JLabel("Total Amount :");
		chooseDVDLabel = new JLabel("Choose a DVD to Buy or Rent");
		quantityBuyLabel = new JLabel("Quantity :");
		amountDueBuyLabel = new JLabel("Amount Due :");
		enterPaymentBuyLabel = new JLabel("Enter payment");
		customerNameReturnLabel = new JLabel("Customer Name :");
		idReturnLabel = new JLabel("Id :");
		totalAmountLabel = new JLabel("Total Amount :");
		returnTitleLabel = new JLabel("Select a DVD to return,");
		finishReturnLabel = new JLabel("Amount due :");

	}

	private void createPanels() {
		mainWindow = new JPanel();
		logIn = new JPanel();
		logo = new JPanel();
		mainControl = new JPanel();
		customerWindow = new JPanel();
		stockWindow = new JPanel();
		stockListWindow = new JPanel();
		checkOutWindow = new JPanel();
		panel = new JPanel();
		checkInWindow = new JPanel();
		returnReceiptWindow = new JPanel();
	}

	private void createButtons() {
		backCheckOutButton = new JButton("Back");
		backCheckInButton = new JButton("Back");
		registrationButton = new JButton("Register Name");
		registrationButton.setHorizontalAlignment(SwingConstants.LEFT);
		checkInButton = new JButton("Check-In DVD");
		stockButton = new JButton("Stock DVD");
		checkOutButton = new JButton("Check-Out DVD");
		backStockButton = new JButton("Back");
		backRegButton = new JButton("Back");

		submitButton = new JButton("Submit");
		addDVDButton = new JButton("Add DVD");
		stockAllDvdsButton = new JButton("Stock all DVDs");
		addPurchaseButton = new JButton("Add to Purchase");
		completePurchaseBuyButton = new JButton("Complete Purchase");
		returnDVDButton = new JButton("Return DVD");
		finishReturnButton = new JButton("Finish Return");
	}

	private void createActionListeners() {
		goBack = new BackListener();
		goRegisterCustomer = new RegisterListener();
		goAddDVD = new AddListener();
		goFinStock = new FinalStockListener();
		goAddSaleItem = new AddSaleItemListener();
		goFinishPurchase = new CompletePurchaseListener();
		goAddReturnItem = new AddReturnItemListener();
		goFinishReturn = new FinishReturnListener();
	}

	private void addActionComponents() {

		addDVDButton.addActionListener(goAddDVD);

		// Main screen navigation listeners, added anonymously
		registrationButton.addActionListener(goRegisterCustomer);

		stockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finalized = false;
				if (isReg) {
					CURRENT_PANEL = STOCK_PANEL;
					CardLayout cl = (CardLayout) (contentPane.getLayout());
					cl.show(contentPane, "stockWindow");
				} else {
					showMsgDlg("You must sign in and register first.");
				}
			}
		});

		checkOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finalized = false;
				if (isReg) {
					CURRENT_PANEL = CHECKOUT_PANEL;
					CardLayout cl = (CardLayout) (contentPane.getLayout());
					cl.show(contentPane, "checkOutWindow");

					customerNameBuyLabel.setText("Customer Name : "
							+ tempCustomer.getName());
					idBuyLabel.setText("Id : " + tempCustomer.getId());
					updateSaleComboList();
					runStore.startSale(tempCustomer.getId());
				} else {
					showMsgDlg("You must sign in and register first.");
				}
			}
		});

		checkInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finalized = false;
				if (isReg) {
					CURRENT_PANEL = CHECKIN_PANEL;
					CardLayout cl = (CardLayout) (contentPane.getLayout());
					cl.show(contentPane, "checkInWindow");

					// Change customer name and id in window
					customerNameReturnLabel.setText("Customer Name : "
							+ tempCustomer.getName());
					idReturnLabel.setText("Id : " + tempCustomer.getId());
					runStore.startReturnSale((tempCustomer.getId()));
					updateRentComboList();

				} else {
					showMsgDlg("You must sign in and register first.");
				}
			}
		});

		// Tertiary screen back listeners
		backStockButton.addActionListener(goBack);
		backCheckOutButton.addActionListener(goBack);
		backCheckInButton.addActionListener(goBack);

		// This listener is for the customer registration
		submitButton.addActionListener(goRegisterCustomer);
		stockAllDvdsButton.addActionListener(goFinStock);

		addPurchaseButton.addActionListener(goAddSaleItem);
		completePurchaseBuyButton.addActionListener(goFinishPurchase);

		returnDVDButton.addActionListener(goAddReturnItem);
		finishReturnButton.addActionListener(goFinishReturn);

	}

	// Brings user back to main menu
	private class BackListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (!finalized) {
				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to go back?\n"
								+ "Information will be erased.", "Warning",
						JOptionPane.YES_NO_OPTION);

				if (dialogResult == JOptionPane.YES_OPTION) {
					switch (CURRENT_PANEL) {
					case STOCK_PANEL:
						runStore.clearStockList();
						resetStockPanelOption();
						break;

					case CHECKOUT_PANEL:
						resetCheckoutPanelOption();
						break;

					case CHECKIN_PANEL:
						resetCheckinPanelOption();
					default:
						break;
					}
				} else
					return;
			}
			goToMainWindow();
		}
	}

	private void goToMainWindow() {
		CardLayout cl = (CardLayout) (contentPane.getLayout());
		cl.show(contentPane, "mainWindow");
		CURRENT_PANEL = MAIN_PANEL;
	}

	// ------------------------Registration Scenario--------------------------//
	// Calls method for registering customer
	private class RegisterListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (nameField.getText().isEmpty() || idField.getText().isEmpty()) {
				showMsgDlg("You must fill out both name and id field.");
				isReg = false;
				return;
			}

			tempCustomer.setName(nameField.getText());
			tempCustomer.setId(Integer.parseInt(idField.getText()));

			// check if customer exist. if not, register new one
			if (!runStore.checkCustomer(tempCustomer)) {

				// The customer id is returned when registration complete
				tempCustomer.setId(runStore.registerCustomer(tempCustomer));

				registerLabel.setText("Registration: Complete");
				signNameLabel.setText(tempCustomer.getName() + " : "
						+ tempCustomer.getId() + " (id)");
				isReg = true;

				// if customer exists, validate id and name
			} else if (runStore.validateCustomer(tempCustomer)) {
				registerLabel.setText("Registration: Complete");
				signNameLabel.setText(tempCustomer.getName() + " : "
						+ tempCustomer.getId() + " (id)");
				isReg = true;

			} else {
				showMsgDlg("Name and id do not match or no such id exists.");
				isReg = false;
				idField.setText("");
				registerLabel.setText("Registration: Incomplete");
			}
		}
	}

	// --------------------------Stock DVD Scenario---------------------------//
	// Calls method for adding DVDs to stocklist
	private class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (stockInputField.getText().isEmpty()) {
				showMsgDlg("Please enter a DVD name.");
				stockInputField.setBackground(new Color(238, 242, 153));

			} else if ((Double) costSpinner.getValue() < 0.0000001) {
				showMsgDlg("DVDs aren't generally free.");
				stockInputField.setBackground(Color.white);

			} else {
				tempDVD.setName(stockInputField.getText());
				tempDVD.setQuantity((Integer) quantitySpinner.getValue());
				tempDVD.setCost((Double) costSpinner.getValue());
				tempDVD.setId((Integer) idSpinner.getValue());

				int test = runStore.testValidation(tempDVD);
				switch (test) {
				case 1:// no error
					runStore.stockDVD(tempDVD);
					stockListBox.setText(null);
					for (int i = 0; i < runStore.getStockList().size(); i++)
						stockListBox.append(""
								+ runStore.getStockList().getStockItem(i));
					break;

				case 2:
					showMsgDlg("DVD already exists in the inventory with id > 0.");
					break;

				case 3:
					showMsgDlg("The DVD name and id don't match in inventory.");
					break;

				case 4:// skip stock process due to new duplicated DVD
					stockListBox.setText(null);
					for (int i = 0; i < runStore.getStockList().size(); i++)
						stockListBox.append(""
								+ runStore.getStockList().getStockItem(i));
					break;

				default:
					showMsgDlg("How did you get here?");
					break;
				}
			}
		}
	}

	// Calls method for updating stocklist to inventory
	private class FinalStockListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			runStore.updateStockToInventory();
			runStore.clearStockList();
			resetStockPanelOption();

			goToMainWindow();
			finalized = true;
		}
	}

	private void resetStockPanelOption() {
		stockInputField.setText("");
		quantitySpinner.setValue(1);
		costSpinner.setValue(0.0);
		idSpinner.setValue(0);
		stockListBox.setText(null);
	}

	private class AddSaleItemListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int maxQuanDVD = 0;

			// First test if any dvds are stocked in inventory
			if (((String) buyModel.getElementAt(0))
					.equalsIgnoreCase("No DVDs stocked.")) {
				showMsgDlg("No DVDs have been stocked. Please go back.");
				return;

				// Then check if a dvd is selected in combo box
			} else if (((String) buyRentChoice.getSelectedItem())
					.equalsIgnoreCase("Select a DVD below,")) {
				showMsgDlg("You must select a DVD from the list first.");
				return;

			} else if (radioRent.isSelected()) {
				maxQuanDVD = runStore.getInvQuantity(buyRentChoice
						.getSelectedIndex() - 1);

				if ((Integer) quantityBuySpinner.getValue() > 1) {
					showMsgDlg("You may only rent one DVD at a time.");
					return;

				} else if (maxQuanDVD == 0) {
					showMsgDlg("There are not enough DVDs in stock to buy.");
					return;

				} else
					tempSaleItem.setType(DVDStoreController.RENT);

			} else if (radioBuy.isSelected()) {
				maxQuanDVD = runStore.getInvQuantity(buyRentChoice
						.getSelectedIndex() - 1);

				if ((Integer) quantityBuySpinner.getValue() > maxQuanDVD) {
					showMsgDlg("There are not enough DVDs in stock to buy.");
					return;

				} else
					tempSaleItem.setType(DVDStoreController.BUY);

			} else {
				showMsgDlg("You have not selected whether to buy or rent.");
				return;
			}

			if (runStore.checkSaleItemDuplicate((String) buyRentChoice
					.getSelectedItem()))
				showMsgDlg("You have already bought or rented this DVD.");

			else {
				double subCost;
				tempSaleItem.setName((String) buyRentChoice.getSelectedItem());
				tempSaleItem.setId(buyRentChoice.getSelectedIndex());
				tempSaleItem.setQuantity((Integer) quantityBuySpinner
						.getValue());

				subCost = runStore.addToSaleAndUpdateTotal(tempSaleItem);
				textPane.append("" + tempSaleItem + "cost : "
						+ dollarFormatter.format(subCost) + "\n\n");
				totalAmountBuyLabel.setText("Total: "
						+ dollarFormatter.format(runStore.getSaleTotal()));
				amountDueBuyLabel.setText("Amount due: "
						+ dollarFormatter.format(runStore.getSaleTotal()));
			}
		}
	}

	private class CompletePurchaseListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (textPane.getText().isEmpty())
				return;
			double change = (Double) paymentBuySpinner.getValue()
					- runStore.getSaleTotal();
			if (change < 0) {
				showMsgDlg("You have not provided enough money.");
				return;
			}
			showMsgDlg("Your change is :" + dollarFormatter.format(change));

			finalized = true;
			resetCheckoutPanelOption();
			runStore.updateSalesToInventory();
			runStore.updateSalesToRentalList();

			goToMainWindow();

		}
	}

	private void resetCheckoutPanelOption() {
		quantityBuySpinner.setValue(1);
		textPane.setText(null);
		totalAmountBuyLabel.setText("Total: ");
		amountDueBuyLabel.setText("Amount due :");
		paymentBuySpinner.setValue(0.0);
	}

	private class AddReturnItemListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// First test if any dvds are stocked in inventory
			if (((String) rentModel.getElementAt(0))
					.equalsIgnoreCase("No DVDs rented.")) {
				showMsgDlg("No DVDs have been rented. Please go back.");
				return;

				// Then check if a dvd is selected in combo box
			} else if (((String) rentedDVDBox.getSelectedItem())
					.equalsIgnoreCase("Select a DVD below,")) {
				showMsgDlg("You must select a DVD from the list first.");
				return;

			} else {
				if (runStore
						.checkReturnSaleItemDuplicate(((String) rentedDVDBox
								.getSelectedItem()).split(":")[0]))
					showMsgDlg("You have already returned this DVD.");

				else {
					String rentalName = ((String) rentedDVDBox
							.getSelectedItem()).split(":")[0];
					int rentalId = runStore.getInvItemIdByName(rentalName);
					tempRentalItem = runStore.getRentalItem(
							tempCustomer.getId(), rentalId);

					returnReceipt.append("Rented DVD :" + rentalName
							+ "\nfee : "
							+ dollarFormatter.format(tempRentalItem.getFee())
							+ "\n\n");

					totalAmountLabel.setText("Total: "
							+ dollarFormatter.format(runStore
									.getReturnSaleTotal()));
					finishReturnLabel.setText("Amount due: "
							+ dollarFormatter.format(runStore
									.getReturnSaleTotal()));

					runStore.addToReturnSaleAndUpdateTotal(tempRentalItem);
				}
			}
		}
	}

	private class FinishReturnListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (returnReceipt.getText().isEmpty())
				return;
			double change = (Double) paymentRentSpinner.getValue()
					- runStore.getReturnSaleTotal();
			if (change < 0) {
				showMsgDlg("You have not provided enough money.");
				return;
			}
			showMsgDlg("Your change is :" + dollarFormatter.format(change));

			finalized = true;
			resetCheckinPanelOption();
			runStore.updateReturnSalesToInventory();
			runStore.updateReturnSalesToRentalList();

			goToMainWindow();

		}
	}

	private void resetCheckinPanelOption() {
		returnReceipt.setText(null);
		totalAmountLabel.setText("Total: ");
		finishReturnLabel.setText("Amount due :");
		paymentRentSpinner.setValue(0.0);

	}

	private void updateSaleComboList() {
		buyModel.removeAllElements();
		int sizeInv = runStore.getInvSize();

		if (sizeInv == 0)
			buyModel.addElement("No DVDs stocked.");
		else
			buyModel.addElement("Select a DVD below,");

		for (int i = 0; i < sizeInv; i++)
			buyModel.addElement(runStore.getInvItemName(i));
	}

	private void updateRentComboList() {
		rentModel.removeAllElements();
		int sizeRentList = runStore.getRentalListSize();

		if (sizeRentList == 0)
			rentModel.addElement("No DVDs rented.");
		else
			rentModel.addElement("Select a DVD below,");

		Set<SimpleEntry<Integer, Integer>> keySet = runStore
				.getRentalListKeySet();
		Iterator<SimpleEntry<Integer, Integer>> iter = keySet.iterator();
		SimpleEntry<Integer, Integer> currentEntry;

		while (iter.hasNext()) {
			currentEntry = iter.next();
			if (tempCustomer.getId() == currentEntry.getKey())
				rentModel.addElement(runStore.getInvItemName(currentEntry
						.getValue() - 1)
						+ ": "
						+ runStore.getRentalItem(currentEntry.getKey(),
								currentEntry.getValue()).getRentDate());
		}
	}

	public void showMsgDlg(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Excuse me",
				JOptionPane.OK_CANCEL_OPTION);
	}
}
