package com.evansnet.FitnessPlan.UI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

/**
 * Shows the BMI, and BMR for the person shown in the PersonPanel, (center frame). 
 * 
 * @author Daniel Evans (C) 2018
 *
 */
@SuppressWarnings("serial")
public class StatsPanel extends JPanel {
	
	 JPanel bmiPanel;
	 JLabel lblBmi;
	 JTextField  txtBmi;
	 JLabel lblBmr;
	 JTextField  txtBmr;
	 private JPanel bmrPanel;
	 

	/**
	 * Create the panel.
	 */
	public StatsPanel() {
		init();
	}
	
	/**
	 * Create the JPanel content
	 */
	public void init() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{152, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		setLayout(gridBagLayout);
		bmiPanel = new JPanel();
		bmiPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lblBmi = new JLabel("BMI: ");
		bmiPanel.add(lblBmi);
		
		GridBagConstraints gbc_bmiPanel = new GridBagConstraints();
		gbc_bmiPanel.anchor = GridBagConstraints.NORTH;
		gbc_bmiPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_bmiPanel.insets = new Insets(0, 0, 5, 0);
		gbc_bmiPanel.gridx = 0;
		gbc_bmiPanel.gridy = 0;
		this.add(bmiPanel, gbc_bmiPanel);
		txtBmi = new JTextField();
		txtBmi.setPreferredSize(new Dimension(110, 20));
		txtBmi.setMinimumSize(new Dimension(80, 20));
		bmiPanel.add(txtBmi);
		bmiPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtBmi}));
		
		bmrPanel = new JPanel();
		lblBmr = new JLabel("BMR: ");
		txtBmr = new JTextField();
		txtBmr.setPreferredSize(new Dimension(110, 20));
		txtBmr.setMinimumSize(new Dimension(80, 20));
		bmrPanel.add(lblBmr);
		bmrPanel.add(txtBmr);
		GridBagConstraints gbc_bmrPanel = new GridBagConstraints();
		gbc_bmrPanel.insets = new Insets(0, 0, 5, 0);
		gbc_bmrPanel.anchor = GridBagConstraints.NORTH;
		gbc_bmrPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_bmrPanel.gridx = 0;
		gbc_bmrPanel.gridy = 1;
		this.add(bmrPanel, gbc_bmrPanel);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{bmiPanel, txtBmi, txtBmr}));
	}
}
