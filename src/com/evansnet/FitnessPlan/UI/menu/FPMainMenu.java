package com.evansnet.FitnessPlan.UI.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * The main menu for this little fitness application
 * 
 * @author Dan Evans © 2017, All rights reserved.
 */
public class FPMainMenu extends Observable {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	JMenu personMenu;
	JMenuItem addPerson;
	JMenuItem getPerson;
	JMenuItem savePerson;
	JMenuItem deletePerson;
	JMenuItem quit;
	
	JMenu helpMenu;
	JMenuItem helpContents;
	JMenuItem helpAbout;
	String selectedMenu;
	
	ActionListener personMenuListener;
	
	public FPMainMenu() {
		personMenuListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				JMenuItem ctrl = (JMenuItem)src;
				selectedMenu = ctrl.getName();
				setChanged();
				notifyObservers();
			}
		};		
		buildPersonMenu();
		buildHelpMenu();
	}
	
	private void buildPersonMenu() {
		personMenu = new JMenu("Person");
		personMenu.setMnemonic(KeyEvent.VK_P);
		personMenu.setName("PERSON_MENU");
		
		addPerson = new JMenuItem("Add");
		addPerson.setMnemonic(KeyEvent.VK_A);
		addPerson.setName("ADD_PERSON");
		addPerson.addActionListener(personMenuListener);
		
		getPerson = new JMenuItem("Get a person");
		getPerson.setMnemonic(KeyEvent.VK_G);
		getPerson.setName("GET_PERSON");
		getPerson.addActionListener(personMenuListener);
		
		savePerson = new JMenuItem("Save");
		savePerson.setMnemonic(KeyEvent.VK_S);
		savePerson.setName("SAVE_PERSON");
		savePerson.addActionListener(personMenuListener);
		
		deletePerson = new JMenuItem("Delete");
		deletePerson.setMnemonic(KeyEvent.VK_D);
		deletePerson.setName("DELETE_PERSON");
		deletePerson.addActionListener(personMenuListener);
		
		quit = new JMenuItem("Quit");
		quit.setMnemonic(KeyEvent.VK_Q);
		quit.setName("QUIT");
		quit.addActionListener(personMenuListener);
		
		personMenu.add(addPerson);
		personMenu.add(getPerson);
		personMenu.add(savePerson);
		personMenu.add(deletePerson);
		personMenu.addSeparator();
		personMenu.add(quit);
	}
	
	private void buildHelpMenu() {
		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		helpMenu.setName("HELP_MENU");
		
		helpContents = new JMenuItem("Contents");
		helpContents.setMnemonic(KeyEvent.VK_C);
		helpContents.setName("HELP_CONTENTS");
		helpContents.addActionListener(personMenuListener);
		
		helpMenu.addSeparator();
		
		helpAbout = new JMenuItem("About");
		helpAbout.setMnemonic(KeyEvent.VK_B);
		helpAbout.setName("HELP_ABOUT");
		helpAbout.addActionListener(personMenuListener);
		
		helpMenu.add(helpContents);
		helpMenu.add(helpAbout);
	}

	public JMenu getPersonMenu() {
		return personMenu;
	}
	
	public JMenu getHelpMenu() {
		return helpMenu;
	}
	
	public String getSelectedMenuItem() {
		return selectedMenu;
	}
	
	public ActionListener getPersonMenuListener() {
		return personMenuListener;
	}
}
