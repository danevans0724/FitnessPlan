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

import com.evansnet.FitnessPlan.FemalePerson;
import com.evansnet.FitnessPlan.MalePerson;
import com.evansnet.FitnessPlan.Person;
import com.evansnet.FitnessPlan.UI.menu.FPMainMenu;
import javax.swing.JMenuBar;
import javax.swing.ScrollPaneLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTree;

public class Fitness extends JFrame implements Observer {
	
	//Temporary array to fill the tree.
	List<String> people;
	DefaultMutableTreeNode treeRoot;
	JTree personTree;
	PersonalPanel pPerson;
	StatsPanel pStats;
	
	FPMainMenu mainMenus;
	ActionListener menuListener;
	
	Person thePerson;

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
		people = new ArrayList<String>();
		people.add("Dan");
		people.add("Jan");
		people.add("Brett");		
		
		for(String p : people) {
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
			doGetPerson();
			break;
		case "SAVE_PERSON":
			doSavePerson();
			break;
		case "DELETE_PERSON":
			doDeletePerson();
			break;
		case "HELP_CONTENTS":
			break;			//Do nothing for now.
		case "HELP_ABOUT":
			break;			//TODO: Write the help system and do the help about dialog.
		case "QUIT":
			doExit();
			break;
		}
	}
	
	/**
	 * Find the person in the system and remove the record. Remove
	 * the person from the tree.
	 */
	private void doDeletePerson() {
		// TODO Auto-generated method stub
		System.out.println("Deleting a person!");
	}
	
	/** 
	 * Save the person's data to storage and add the name to the tree.
	 */
	private void doSavePerson() {
		// TODO Auto-generated method stub
		System.out.println("Saving a person!");
	}
	
	/**
	 * Do this when the menu item is selected or when a person is clicked in the tree.
	 */
	private void doGetPerson() {
		// TODO Auto-generated method stub
		System.out.println("Getting a person! (From where?)");
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
	private void doNewPerson() {
		if (pPerson.rd_male.isSelected()) {
			thePerson = new MalePerson();
		} else if (pPerson.rd_female.isSelected()) {
			thePerson = new FemalePerson();
		} 
		
		
	}
	
	private void syncModel() {
		System.out.println("Synchronizing the model and GUI.");
	}
	
}
