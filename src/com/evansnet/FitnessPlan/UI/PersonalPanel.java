package com.evansnet.FitnessPlan.UI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.evansnet.FitnessPlan.SEX;

import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonalPanel extends JPanel implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	JLabel lblName;
	JTextField  txtName;
	JLabel lblBirthDate;
	JTextField txtBirthDate;
	JLabel lblGender;
	JRadioButton rd_male;
	JRadioButton rd_female;
	JLabel lblWeight;
	JLabel lblStartWgt;
	JTextField txtStartWgt;
	JLabel lblTargetWgt;
	JTextField txtTargetWgt;
	JLabel lblCurrentWgt;
	JTextField txtCurrentWgt;
	JButton btnOK;
	boolean isDirty;
	JButton btnCancel;
	SEX gender = SEX.MALE;
	
	DocumentListener docChgListener;
	
	Logger statsLogger = Logger.getLogger("StatsLogger");

	/**
	 * Create the panel.
	 */
	public PersonalPanel() {
		setDirty(false);		//Initially a clean display.
		setBackground(SystemColor.control);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {350};
		gridBagLayout.rowHeights = new int[] {198};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{0.0};
		setLayout(gridBagLayout);
		
		// Handle changes to the text controls in order to set dirty flag.
		docChgListener = new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				String ctrl = getControlName(e);
					setDirty(true);
					// TODO: enable the save menu item. Of course I have to write it first!
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				String ctrl = getControlName(e);
					setDirty(true);
					// TODO: enable the save menu item. Of course I have to write it first!
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String ctrl = getControlName(e);
				setDirty(true);
					// TODO: enable the save menu item. Of course I have to write it first!
			}
			
		};
		
		ButtonGroup bgGender = new ButtonGroup();
		
		JPanel personPanel = new JPanel();
		GridBagConstraints gbc_personPanel = new GridBagConstraints();
		gbc_personPanel.insets = new Insets(0, 0, 0, 5);
		gbc_personPanel.fill = GridBagConstraints.BOTH;
		gbc_personPanel.gridx = 0;
		gbc_personPanel.gridy = 0;
		add(personPanel, gbc_personPanel);
		GridBagLayout gbl_personPanel = new GridBagLayout();
		gbl_personPanel.columnWidths = new int[] {116, 60, 60, 60, 60};
		gbl_personPanel.rowHeights = new int[] {13, 13, 13, 13, 13};
		gbl_personPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_personPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		personPanel.setLayout(gbl_personPanel);
		
		lblName = new JLabel("Name: ");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 5, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		personPanel.add(lblName, gbc_lblName);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 0;
		gbc_txtName.gridwidth = 4;
		personPanel.add(txtName, gbc_txtName);
		txtName.setName("NAME");
		txtName.getDocument().addDocumentListener(docChgListener);
		txtName.getDocument().putProperty("owner", txtName);
		
		lblBirthDate = new JLabel("Birth Date: ");
		GridBagConstraints gbc_lblBirthDate = new GridBagConstraints();
		gbc_lblBirthDate.insets = new Insets(0, 5, 0, 0);
		gbc_lblBirthDate.anchor = GridBagConstraints.WEST;
		gbc_lblBirthDate.gridx = 0;
		gbc_lblBirthDate.gridy = 1;
		personPanel.add(lblBirthDate, gbc_lblBirthDate);
		
		txtBirthDate = new JTextField();
		txtBirthDate.setName("BIRTHDATE");
		txtBirthDate.getDocument().addDocumentListener(docChgListener);
		txtBirthDate.getDocument().putProperty("owner", txtBirthDate);
		GridBagConstraints gbc_birthDate = new GridBagConstraints();
		gbc_birthDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_birthDate.gridx = 1;
		gbc_birthDate.gridy = 1;
		gbc_birthDate.gridwidth = 3;
		personPanel.add(txtBirthDate, gbc_birthDate);
		
		lblGender = new JLabel("Gender: ");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.insets = new Insets(0, 5, 0, 0);
		gbc_lblGender.anchor = GridBagConstraints.WEST;
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 2;
		personPanel.add(lblGender, gbc_lblGender);
		
		rd_male = new JRadioButton("Male");
		GridBagConstraints gbc_rdmale = new GridBagConstraints();
		gbc_rdmale.anchor = GridBagConstraints.WEST;
		gbc_rdmale.gridx = 1;
		gbc_rdmale.gridy = 2;
		personPanel.add(rd_male, gbc_rdmale);
		
		rd_female = new JRadioButton("Female");
		GridBagConstraints gbc_rdfemale = new GridBagConstraints();
		gbc_rdfemale.gridx = 2;
		gbc_rdfemale.gridy = 2;
		personPanel.add(rd_female, gbc_rdfemale);
		bgGender.add(rd_male);
		bgGender.add(rd_female);
		
		rd_male.setSelected(true);
		
		rd_male.addItemListener(this);
		rd_female.addItemListener(this);
		
		lblWeight = new JLabel("Weight");
		GridBagConstraints gbc_weight = new GridBagConstraints();
		gbc_weight.gridx = 0;
		gbc_weight.gridy = 3;
		personPanel.add(lblWeight, gbc_weight);
		
		lblStartWgt = new JLabel("Start Weight: ");
		GridBagConstraints gbc_startWgt = new GridBagConstraints();
		gbc_startWgt.insets = new Insets(0, 5, 0, 0);
		gbc_startWgt.anchor = GridBagConstraints.WEST;
		gbc_startWgt.gridx = 0;
		gbc_startWgt.gridy = 4;
		personPanel.add(lblStartWgt, gbc_startWgt);
		
		txtStartWgt = new JTextField();
		txtStartWgt.setName("STARTWGT");
		txtStartWgt.getDocument().putProperty("owner", txtStartWgt);
		txtStartWgt.getDocument().addDocumentListener(docChgListener);
		GridBagConstraints gbc_txtstartWgt = new GridBagConstraints();
		gbc_txtstartWgt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtstartWgt.gridx = 1;
		gbc_txtstartWgt.gridy = 4;
		personPanel.add(txtStartWgt, gbc_txtstartWgt);
		
		
		lblTargetWgt = new JLabel("Target Weight");
		GridBagConstraints gbc_targetWgt = new GridBagConstraints();
		gbc_targetWgt.insets = new Insets(0, 5, 0, 0);
		gbc_targetWgt.anchor = GridBagConstraints.WEST;
		gbc_targetWgt.gridx = 2;
		gbc_targetWgt.gridy = 4;
		personPanel.add(lblTargetWgt, gbc_targetWgt);
		
		txtTargetWgt = new JTextField();
		txtTargetWgt.setName("TARGETWGT");
		txtTargetWgt.getDocument().addDocumentListener(docChgListener);
		txtTargetWgt.getDocument().putProperty("owner", txtTargetWgt);
		GridBagConstraints gbc_txtTargetWgt = new GridBagConstraints();
		gbc_txtTargetWgt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTargetWgt.gridx = 3;
		gbc_txtTargetWgt.gridy = 4;
		personPanel.add(txtTargetWgt, gbc_txtTargetWgt);
		
		lblCurrentWgt = new JLabel("Current Weight");
		GridBagConstraints gbc_currentWgt = new GridBagConstraints();
		gbc_currentWgt.insets = new Insets(0, 5, 0, 0);
		gbc_currentWgt.anchor = GridBagConstraints.WEST;
		gbc_currentWgt.gridx = 0;
		gbc_currentWgt.gridy = 5;
		personPanel.add(lblCurrentWgt, gbc_currentWgt);
		
		txtCurrentWgt = new JTextField();
		txtCurrentWgt.setName("CURRENTWGT");
		txtCurrentWgt.getDocument().addDocumentListener(docChgListener);
		txtCurrentWgt.getDocument().putProperty("owner", txtCurrentWgt);
		GridBagConstraints gbc_txtCurrenWgt = new GridBagConstraints();
		gbc_txtCurrenWgt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCurrenWgt.gridx = 1;
		gbc_txtCurrenWgt.gridy = 5;
		personPanel.add(txtCurrentWgt, gbc_txtCurrenWgt);
		
		btnOK = new JButton("OK");
		GridBagConstraints gbc_btnOK = new GridBagConstraints();
		gbc_btnOK.gridx = 3;
		gbc_btnOK.gridy = 7;
		personPanel.add(btnOK, gbc_btnOK);
		btnOK.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 4;
		gbc_btnCancel.gridy = 7;
		personPanel.add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener(this);
		
	}


	@Override
	public void itemStateChanged(ItemEvent genderEvent) {
		if (genderEvent.getSource() == rd_male) {
			statsLogger.log(Level.INFO, "Male gender selected");
			gender = SEX.MALE;
			setDirty(true);
			
		} else if (genderEvent.getSource() == rd_female) {
			statsLogger.log(Level.INFO, "Female gender selected");
			gender = SEX.FEMALE;
			setDirty(true);
		}
	}
	
	//Handle the OK and cancel button clicks.
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOK) {
			statsLogger.log(Level.INFO, "Adding / changing a person.");
			if (!isPersonExists(txtName.getText())) {		//TODO: Write the checkPerson routine.
				doAddPerson();
			} else {
				doUpdatePerson();
			}
		} else if (e.getSource() == btnCancel) {
			statsLogger.log(Level.INFO, "Clearing controls.");
			doClearCtrl();
		}
	}
	
	/**
	 * Checks persistent storage and determines if the person is 
	 * already in the system. 
	 * 
	 * @return True if the person record exists, false otherwise.
	 */
	protected boolean isPersonExists(String name) {
		// TODO Write the routine to check for an existing person in storage. Determines add or edit.
		return false;
	}


	/**
	 * Cancels the operation and clears all of the controls. Sets
	 * the state of the controls to their default.
	 */
	private void doClearCtrl() {
		txtName.setText("");
		txtBirthDate.setText("");
		rd_male.setSelected(true);
		txtStartWgt.setText("");
		txtTargetWgt.setText("");
		txtCurrentWgt.setText("");
		setDirty(false);
		statsLogger.log(Level.INFO, "UI dirty flag cleared");
	}

	/**
	 * Once the controls have been edited and the OK button clicked,
	 * the tree is searched for the user and if the user is there, the
	 * user's data is updated. 
	 * 
	 * If the user is not in the tree, then a new user is added to the 
	 * system and the model is update for the user's fitness statistics.
	 */
	private void doAddPerson() {
		statsLogger.log(Level.INFO, "Checking for existence of user " + txtName.getText());
		if (isDirty()) {
			if (doCheckExistingUser(txtName.getText())) {
				setDirty(false);
				JOptionPane.showMessageDialog(this, "User already exists in the tree!");
			} else {
				DefaultMutableTreeNode newPerson = new DefaultMutableTreeNode();
				//TODO: Fire an add person to the tree event. I need to write the event and listener.
			}
		}
	}
	
	/** 
	 * Performs an update of the existing person record based on the values
	 * in the panel's controls.
	 */
	private void doUpdatePerson() {
		System.out.println("Updating the person!");
		//TODO: Write the doUpdatePerson() method.
	}

	/**
	 * If the UI has been changed, set this to true. Binding of data back to the model can be 
	 * done at that point
	 * @param b True or False - True if the panel has been edited.
	 * 
	 */
	private void setDirty(boolean b) {
		isDirty = b;
		if (isDirty) {
			statsLogger.log(Level.INFO, "UI is dirty.");
		} else {
			statsLogger.log(Level.INFO, "UI is clean.");
		}
	}
	
	/**
	 * Returns the edit status of the panel. If dirty, there is new 
	 * changes or additions to save.
	 * @return The status of the panel. True if edits have been made.
	 */
	public boolean isDirty() {
		return isDirty;
	}
	
	private String getControlName(DocumentEvent e) {
		String ctrl = ((JTextField) e.getDocument().getProperty("owner")).getName();
		return ctrl;
	}
		
	/**
	 * Confirm that the values in the GUI are appropriate. If not
	 * throw an exception and handle it.
	 * @return
	 */
	private boolean isGUIOK() {
		System.out.println("Checking the GUI for valid values");
		return true;
	}


	public String getTxtName() {
		return txtName.getText();
	}


	public String getTxtBirthDate() {
		return txtBirthDate.getText();
	}


	public String getTxtStartWgt() {
		return txtStartWgt.getText();
	}


	public String getTxtTargetWgt() {
		return txtTargetWgt.getText();
	}


	public String getTxtCurrentWgt() {
		return txtCurrentWgt.getText();
	}
	
	public SEX getGender() {
		return gender;
	}

	/**
	 * Checks the tree and model for the user
	 * @param text The name of the user to search for
	 * @return <b>boolean</b>: true if the user is found, false otherwise
	 */
	private boolean doCheckExistingUser(String text) {
		this.getParent();
		System.out.println("Checking the tree for a person " + text);
		return false;		//TODO: Implement the doCheckExistingUser method.
	}
}
