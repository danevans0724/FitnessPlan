package com.evansnet.FitnessPlan.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionListener;
import java.time.Year;

import com.evansnet.FitnessPlan.FemalePerson;
import com.evansnet.FitnessPlan.IPerson;
import com.evansnet.FitnessPlan.MalePerson;
import com.evansnet.FitnessPlan.Person;
import com.evansnet.FitnessPlan.UI.menu.FPMainMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTree;

public class Fitness extends JFrame implements Observer {
	
	
	List<IPerson> people;
	//Temporary array to fill the tree.
	List<String> tempPeople;
	DefaultMutableTreeNode treeRoot;
	JTree personTree;
	PersonalPanel pPerson;
	StatsPanel pStats;
	
	FPMainMenu mainMenus;
	ActionListener menuListener;
	
	Person thePerson;
	public static String version = "1.0.0";
	public static String copyrightYear = Year.now().toString();	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the Fitness application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fitness frame = new Fitness();
					frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DefaultMutableTreeNode getTreeRoot() {
		return treeRoot;
	}

	public void setTreeRoot(DefaultMutableTreeNode treeRoot) {
		this.treeRoot = treeRoot;
	}

	public JTree getPersonTree() {
		return personTree;
	}

	public void setPersonTree(JTree personTree) {
		this.personTree = personTree;
	}
	
	/**
	 * Provides the product version.
	 * @return A string representing the product version.
	 */
	public static String getVersion() {
		return version;
	}

	/**
	 * Create the main window frame and controls.
	 */
	public Fitness() {
		setTitle("Fitness Helper - Personal Statistics.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 275);
		
		JMenuBar menuBarMain = new JMenuBar();
		setJMenuBar(menuBarMain);
		
		mainMenus = new FPMainMenu();
		
		mainMenus.addObserver(this);
		menuBarMain.add(mainMenus.getPersonMenu());
		menuBarMain.add(mainMenus.getHelpMenu());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Create the tree
		treeRoot = new DefaultMutableTreeNode("People");
		personTree = new JTree(treeRoot);
		personTree.setPreferredSize(new Dimension(145, 100));

		//Add the tree to the ScrollPane and ultimately to the main window.
		JScrollPane pnlPersonTree = new JScrollPane(personTree);
		pnlPersonTree.setPreferredSize(new Dimension(145, 100));
		pnlPersonTree.setLayout(new ScrollPaneLayout());
		contentPane.add(pnlPersonTree, BorderLayout.WEST);
		populateTree();
		
		// Set the center panel for editing people
		pPerson = new PersonalPanel();
		contentPane.add(pPerson, BorderLayout.CENTER);
		
		// Show the panel that contains the BMR and BMI 
		pStats = new StatsPanel();
		contentPane.add(pStats, BorderLayout.EAST);	
	}
	
	/**
	 * Temporary method to fill the tree with names. 
	 * Normally, we would read people from the data source and build the 
	 * tree. Then the user could select a person and get their data or
	 * create a new person and save the person in the data source.
	 */
	private void populateTree() {
		tempPeople = new ArrayList<String>();
		tempPeople.add("Dan");
		tempPeople.add("Jan");
		tempPeople.add("Brett");		
		
		for(String p : tempPeople) {
			treeRoot.add(new DefaultMutableTreeNode(p));
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String selected = mainMenus.getSelectedMenuItem();
		
		//Perform an action based on the menu selected
		switch(selected) {
		case "ADD_PERSON":
			doNewPerson();
			break;
		case "GET_PERSON":
			doGetPersonFromTree();
			break;
		case "SAVE_PERSON":
			doSavePerson();
			break;
		case "DELETE_PERSON":
			doDeletePerson();
			break;
		case "HELP_CONTENTS":
			doHelpContents();
			break;			//Do nothing for now.
		case "HELP_ABOUT":
			doHelpAbout();
			break;			
		case "QUIT":
			doExit();
			break;
		}
	}
	
	@SuppressWarnings("static-access")
	private void doHelpAbout() {
		String versionStr = "Fitness Planner version " + getVersion();
		String copyright = "Copyright Dan Evans " + copyrightYear + " . All rights reserved.";
		final JOptionPane helpAbout = new JOptionPane();
		helpAbout.showMessageDialog(this, versionStr + "\n" + copyright, 
				"About Fitness Planner", JOptionPane.OK_OPTION );
	}

	private void doHelpContents() {
		// TODO: Create a dialog for help contents and implement it.
		System.out.println("Creating help contents! ");
	}

	/**
	 * Find the person in the system and remove the record. Remove
	 * the person from the tree.
	 */
	private void doDeletePerson() {
		// TODO: Call the method in the person panel that deletes the person.
		System.out.println("Deleting a person!");
	}
	
	/** 
	 * Save the person's data to storage and add the name to the tree.
	 */
	private void doSavePerson() {
		// TODO: Call the method in the person panel that saves a person. Persist to storage.
		System.out.println("Saving a person!");
	}
	
	/**
	 * Do this when the menu item is selected or when a person is clicked in the tree.
	 */
	private void doGetPersonFromTree() {
		// TODO Auto-generated method stub
		System.out.println("Getting a person! (From where?)");
		/* Algorithm:
		 * 1. Use the person entry from the tree.
		 * 2. Find the person in storage or the model.
		 * 3. Use the values in the model to populate the controls. 
		 *    (Sounds like a great JFace usage to me. Too bad it's Swing)
		 */
	}
	
	/**
	 * Fetch the people records from a CSV file and populate the data model with them.
	 * 
	 */
	private void doFetchPeople() {
		
	
	}

	/**
	 * Handles the request to exit the application.
	 */
	private void doExit() {
		Runtime.getRuntime().exit(0);
		//System.exit();	//Alternate method. Keep this handy.
	}
	
	/**
	 * Handles the creation of a new person. Synchronizes the model and 
	 * the display in preparation for the save.
	 */
	/*
	 * Algorithm:
	 * 1. Get the male/female selection from the GUI.
	 * 2. Create the appropriate model object.
	 * 3. Synch the values in the controls, if any, with the new objects.
	 * 4. Add the person to the tree.
	 */
	private void doNewPerson() {
		if (pPerson.rd_male.isSelected()) {
			thePerson = new MalePerson();
		} else if (pPerson.rd_female.isSelected()) {
			thePerson = new FemalePerson();
		} 
		syncModel();
		
	}
	
	private void syncModel() {
		System.out.println("Synchronizing the model and GUI.");
		if (pPerson.isDirty()) {
			if (pPerson.isPersonExists(pPerson.getName())) {
				// The person already exists. Update the record with GUI changes
				thePerson.setName(pPerson.getTxtName());
				thePerson.setStartWeight(Double.parseDouble(pPerson.getTxtStartWgt()));
				thePerson.setTargetWeight(Double.parseDouble(pPerson.getTxtTargetWgt()));
				thePerson.setCurrentWeight(Double.parseDouble(pPerson.getTxtCurrentWgt()));
				thePerson.setGender(pPerson.getGender());
				thePerson.setBirthDate(getDateFromString(pPerson.getTxtBirthDate()));
				thePerson.calcCurrentAge();
				//TODO: Need to set the age, measurement system etc for the person. 
			} else {
				// The person does not exist in the tree. Create a new person object
				System.out.println("Sync a new Person!");
			}
		}
	}

	/**
	 * Provides a calendar from a string representation of a date. As of this writing the 
	 * method assumes that the date is in the form of MM/DD/YYYY. Other formats will cause an error.
	 * 
	 * @param dt
	 * @return
	 */
	protected Calendar getDateFromString(String dt) {
		String[] d = new String[3];
		d = dt.split("/"); 	// split into MM and DD and YYYY
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(d[2]), Integer.parseInt(d[0]), Integer.parseInt(d[2]));
		return c;
	}
	
}
