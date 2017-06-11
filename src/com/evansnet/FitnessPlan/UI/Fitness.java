package com.evansnet.FitnessPlan.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JMenuBar;
import javax.swing.ScrollPaneLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTree;

public class Fitness extends JFrame {
	
	//Temporary array to fill the tree.
	List<String> people;
	DefaultMutableTreeNode treeRoot;
	JTree personTree;

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

	/**
	 * Create the main window frame and controls.
	 */
	public Fitness() {
		setTitle("Fitness Helper - Personal Statistics.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 275);
		
		JMenuBar menuBarMain = new JMenuBar();
		setJMenuBar(menuBarMain);

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
		PersonalPanel pPerson = new PersonalPanel();
		contentPane.add(pPerson, BorderLayout.CENTER);
		
		// Show the panel that contains the BMR and BMI 
		StatsPanel pStats = new StatsPanel();
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
}
