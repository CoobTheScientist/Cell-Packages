/*
 * Yacob Ahmad
 * 4-28-2023
 * Adv. Java Spring 2023
 * CellPhone Assignment Week 13 
 */

package CellPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   A solution to the
   Cell Phone programming assignment.
*/

public class CellPhones extends JFrame
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
   private JPanel packagesPanel;    // Shows selected package cost
   private JPanel phonePanel;       // Shows selected phone cost
   private JPanel optionsPanel;     // Shows selected options cost
   private JPanel submitPanel;
   
   private JTextField packageText;  // Package cost
   private JTextField phoneText;    // Phone cost
   private JTextField optionsText;  // Options cost
   private String packageTextNm;  	// Selected Package name
   private String phoneTextNm;    	// Selected Phone name
   private String optionsTextNm;  	// Selected Options name
   private JButton submitButton;	// Button to display submitted message
                      
   private JMenuBar menuBar;        // The menu bar
   
   private JMenu fileMenu;          // File menu
   private JMenu packageMenu;       // Packages menu
   private JMenu phonesMenu;        // Phones menu
   private JMenu optionsMenu;       // Options menu
                 
   private JMenuItem exitItem;      // Exit item
                 
   private JRadioButtonMenuItem packageAitem; // 300 minute package menu item
   private JRadioButtonMenuItem packageBitem; // 800 minute package menu item
   private JRadioButtonMenuItem packageCitem; // 1500 minute package menu item
   
   private JRadioButtonMenuItem phone100item; // Model 100 phone menu item
   private JRadioButtonMenuItem phone110item; // Model 110 menu item
   private JRadioButtonMenuItem phone200item; // Model 200 menu item
                 
   private JCheckBoxMenuItem voiceMailItem; // Voice mail menu item
   private JCheckBoxMenuItem textMsgItem;   // Text messaging menu item
   
   
  
   public CellPhones()
   {
      // Display a title.
      setTitle("Cell Phone Packages");
      
      // Specify what happens when the close button is clicked.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Build the menu system.
      buildMenuBar();
      
      // Build the panels.
      buildPackagesPanel();
      buildPhonePanel();
      buildOptionsPanel();
      buildSubmitPanel();

      // Create a grid layout: 4 rows, 1 column.
      setLayout(new GridLayout(4, 1));
  	  setLocation(500, 250);
  	  setPreferredSize(new Dimension(400, 300));

      
      // Add the panels to the content pane.    
      add(packagesPanel);
      add(phonePanel);
      add(optionsPanel);
      add(submitPanel);
      
      // Pack and display the window.
      pack();
      setVisible(true);
   }

   /**
      The buildMenuBar method builds the application's
      menu bar.
   */
   
   private void buildMenuBar()
   {
      // Create the menu bar.
	   menuBar = new JMenuBar();
      
      // Create the menus.
	   buildFileMenu();
	   buildPackagesMenu();
	   buildPhonesMenu();
	   buildOptionsMenu();
      
      // Add the menus to the menu bar.
	   menuBar.add(fileMenu);
	   menuBar.add(packageMenu);
	   menuBar.add(phonesMenu);
	   menuBar.add(optionsMenu);
	   
      // Set the window's menu bar.
	   setJMenuBar(menuBar);
   }

   /**
      The buildFileMenu method builds the File menu.
   */
   
   private void buildFileMenu()
   {
      // Create an Exit menu item.
	   exitItem = new JMenuItem("Exit");
	   exitItem.setMnemonic(KeyEvent.VK_X);
	   exitItem.addActionListener(new ExitListener());
	   
      // Create a JMenu object for the File menu.
	   fileMenu = new JMenu("File");
	   fileMenu.setMnemonic(KeyEvent.VK_F);
         
      // Add the Exit menu item to the File menu.
	   fileMenu.add(exitItem);
   }

   /**
      The buildPackagesMenu method builds the Packages menu.
   */

   private void buildPackagesMenu()
   {
      // Create the radio button menu items to select
      // one of the packages.
	   packageAitem = new JRadioButtonMenuItem("300 Minutes", true);
	   packageAitem.setMnemonic(KeyEvent.VK_3);
	   packageAitem.addActionListener(new PackageListener());
	   
	   packageBitem = new JRadioButtonMenuItem("800 Minutes");
	   packageBitem.setMnemonic(KeyEvent.VK_8);
	   packageBitem.addActionListener(new PackageListener());
	   
	   packageCitem = new JRadioButtonMenuItem("1500 Minutes");
	   packageCitem.setMnemonic(KeyEvent.VK_1);
	   packageCitem.addActionListener(new PackageListener());
	   

      // Create a button group for the radio button items.
          ButtonGroup button = new ButtonGroup();
          button.add(packageAitem);
          button.add(packageBitem);
          button.add(packageCitem);
          
      // Create a JMenu object for the Pakcages menu.
          packageMenu = new JMenu("Packages");
          packageMenu.setMnemonic(KeyEvent.VK_P);

      // Add the menu items to the Text menu.
          packageMenu.add(packageAitem);
          packageMenu.add(packageBitem);
          packageMenu.add(packageCitem);
   }

   /**
      The buildPhonesMenu method builds the Phones menu.
   */
   
   private void buildPhonesMenu()
   {
      // Create the radio button menu items to select
      // one of the phones.
	   phone100item = new JRadioButtonMenuItem("Model 100", true);
	   phone100item.setMnemonic(KeyEvent.VK_1);
	   phone100item.addActionListener(new PhoneListener());
	
	   phone110item = new JRadioButtonMenuItem("Model 110");
	   phone110item.setMnemonic(KeyEvent.VK_0);
	   phone110item.addActionListener(new PhoneListener());
	   
	   phone200item = new JRadioButtonMenuItem("Model 200");
	   phone200item.setMnemonic(KeyEvent.VK_2);
	   phone200item.addActionListener(new PhoneListener());
          
      // Create a button group for the radio button items.
	   ButtonGroup button = new ButtonGroup();
	   button.add(phone100item);
	   button.add(phone110item);
	   button.add(phone200item);
          
      // Create a JMenu object for the Pakcages menu.
	   phonesMenu = new JMenu("Phones");
	   phonesMenu.setMnemonic(KeyEvent.VK_H);

      // Add the menu items to the Text menu.
	   phonesMenu.add(phone100item);
	   phonesMenu.add(phone110item);
	   phonesMenu.add(phone200item);
   }

   /**
      The buildOptionsMenu method builds the Options menu.
   */
   
   private void buildOptionsMenu()
   {
      // Create a check box menu item for the voice mail option.
	   voiceMailItem = new JCheckBoxMenuItem("Voice Mail", true);
	   voiceMailItem.setMnemonic(KeyEvent.VK_V);
	   voiceMailItem.setSelected(false);
	   voiceMailItem.addActionListener(new OptionsListener());

      // Create a check box menu item for the text messaging option.
	   textMsgItem = new JCheckBoxMenuItem("Text Messaging", true);
	   textMsgItem.setMnemonic(KeyEvent.VK_T);
	   textMsgItem.setSelected(false);
	   textMsgItem.addActionListener(new OptionsListener());
	   	   
      // Create a JMenu object for the Options menu.
	   optionsMenu = new JMenu("Options");
	   optionsMenu.setMnemonic(KeyEvent.VK_O);
	   
      // Add the menu items to the Text menu.
	   optionsMenu.add(voiceMailItem);
	   optionsMenu.add(textMsgItem);
   }

   /**
      The buildPackagesPanel method builds a panel to
      display the package cost.
   */
   
   private void buildPackagesPanel()
   {
      packagesPanel = new JPanel();
      JLabel packageMsg = new JLabel("Package Cost:");
      packageText = new JTextField(10);
      packageText.setText("$45.00 per month");
      packageTextNm = "Package A";
      packagesPanel.add(packageMsg);
      packagesPanel.add(packageText);
      
   }

   /**
      The buildPhonePanel method builds a panel to
      display the phone cost.
   */
   
   private void buildPhonePanel()
   {
	  phonePanel = new JPanel();
	  JLabel phoneMsg = new JLabel("Phone Cost:");
	  phoneText = new JTextField(10);
	  phoneText.setText("$29.45");
	  phoneTextNm = "Model 100";
	  phonePanel.add(phoneMsg);
	  phonePanel.add(phoneText);
   }

   /**
      The buildOptionsPanel method builds a panel to
      display the options cost.
   */
      
   private void buildOptionsPanel()
   {
	  optionsPanel = new JPanel();
	  JLabel optionMsg = new JLabel("Options Cost:");
	  optionsText = new JTextField(10);
	  optionsText.setText("$0.00");
	  optionsTextNm = "none";
	  optionsPanel.add(optionMsg);
	  optionsPanel.add(optionsText);
	  
   }
   
   /**
   The buildSubmitPanel method builds a panel to
   display the selections submitted.
*/
   
   private void buildSubmitPanel()
   {
	   submitPanel = new JPanel();
	   
	   submitButton = new JButton("Submit Order");
	   submitButton.addActionListener(new SubmitListener());
	   submitPanel.add(submitButton); 

   }
   
   /**
      Private inner class that handles the event that
      is generated when the user selects Exit from
      the File menu.
   */
   
    private class ExitListener implements ActionListener
    {
      /**
         actionPerformed method
         @param e An ActionEvent object.
      */
      
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
    }
     
   /**
      Private inner class that handles the event that
      is generated when the user selects a package
      from the Packages menu.
   */
   
    private class PackageListener implements ActionListener
    {
      /**
         actionPerformed method
         @param e An ActionEvent object.
      */
      
      public void actionPerformed(ActionEvent e)
      {
         if (packageAitem.isSelected()) {
            packageText.setText("$45.00 per month");
            packageTextNm = "Package A";
         }
         else if (packageBitem.isSelected()) {
            packageText.setText("$65.00 per month");
            packageTextNm = "Package B";         }
         else if (packageCitem.isSelected()) {
            packageText.setText("$99.00 per month");
            packageTextNm = "Package C";         }
         
       }
    }

   /**
      Private inner class that handles the event that
      is generated when the user selects a phone
      from the Phones menu.
   */
   
    private class PhoneListener implements ActionListener
    {
      /**
         actionPerformed method
         @param e An ActionEvent object.
      */
      
      public void actionPerformed(ActionEvent e)
      {
         if (phone100item.isSelected()) {
            phoneText.setText("$29.95");
            phoneTextNm = "Model 100";
         }
         else if (phone110item.isSelected()) {
            phoneText.setText("$49.95");
            phoneTextNm = "Model 110";
         }
         else if (phone200item.isSelected()) {
            phoneText.setText("$99.95");
            phoneTextNm = "Model 200";
         }
      }
    }

   /**
      Private inner class that handles the event that
      is generated when the user selects an option
      from the Options menu.
   */
   
    private class OptionsListener implements ActionListener
    {
      /**
         actionPerformed method
         @param e An ActionEvent object.
      */
      
      public void actionPerformed(ActionEvent e)
      {
         if (voiceMailItem.isSelected() && !textMsgItem.isSelected()) {
            optionsText.setText("$5.00");
            optionsTextNm = "Voice Mail";
         }
         if (textMsgItem.isSelected() && !voiceMailItem.isSelected()) {
            optionsText.setText("$10.00");
            optionsTextNm = "Text Messaging";
         }
         if (textMsgItem.isSelected() && voiceMailItem.isSelected()) {
            optionsText.setText("$15.00");
            optionsTextNm = "Voice Mail and Text Messaging";
         }
         if (!voiceMailItem.isSelected() && !textMsgItem.isSelected()) {
            optionsText.setText("$0.00");
            optionsTextNm = "None";
         }
      }
    
    }

    /**
    Private inner class that handles the event that
    is generated when the user selects an option
    from the Options menu.
 */
 
  private class SubmitListener implements ActionListener
  {
    /**
       actionPerformed method
       @param e An ActionEvent object.
    */
    
    public void actionPerformed(ActionEvent e)
    {
    	String selection;
    	
    	 // window
        JWindow submitWindow = new JWindow();
        submitPanel = new JPanel();
        submitPanel.setLayout(new GridLayout(4, 1));

        JLabel submitMsg = new JLabel("Final Selections:");
        selection = "     Package: " + packageTextNm;
        JLabel submittedPackage = new JLabel(selection);

        selection = "     Phone: " + phoneTextNm;
        JLabel submittedPhone = new JLabel(selection);

        selection = "     Options: " + optionsTextNm;
  	   	JLabel submittedOptions = new JLabel(selection);

            // add contents to panel
  	   	submitPanel.add(submitMsg);
  	   	submitPanel.add(submittedPackage);
  	   	submitPanel.add(submittedPhone);
  	   	submitPanel.add(submittedOptions);
  	   	submitWindow.add(submitPanel);
           
  	   	submitWindow.setSize(400, 100);
  	   	submitWindow.setLocation(800, 500);
     
  	   	submitWindow.setVisible(true);

    	
    }
  }
    
   /**	
      The main method creates an instance of the CellPackages
      class, causing it to display its window.
   */

   public static void main(String[] args)
   {

	   CellPhones cp = new CellPhones();
	   
   }
}




