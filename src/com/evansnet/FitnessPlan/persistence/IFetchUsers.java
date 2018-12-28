package com.evansnet.FitnessPlan.persistence;

import java.nio.file.Path;
import java.util.Properties;

/**
 * Provides an API for fetching and saving users to disk. 
 * Fetches the whole group of users from an XML file. The file is used to populate
 * the model for the application and the tree model.
 * @author Dan Evans
 *
 */
public interface IFetchUsers {
	
	final String filename = "FitPeople.xml";
	
	/**
	 * Get the system properties. Similar to running the "set" command at the command line.
	 * @return The list of system properties
	 */
	Properties getSystemProperties();	
	
	/**
	 * Get the logged in user of the system. This user will be the owner of
	 * the fitness data.
	 * @return A string representing the currently logged in user.
	 */
	String getSystemUser();				
	
	/**
	 * Fetches the current user's home directory on this system. 
	 * @return A string representing the user's home directory.
	 */
	String getUserHome();
	
	/**
	 * Represents the absolute path to the user's FitPeople.xml file.
	 * @return A Path object that represents the absolute path to the user's file.
	 */
	Path getUserPath();					
}
