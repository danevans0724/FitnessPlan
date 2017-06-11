package com.evansnet.FitnessPlan;

import com.evansnet.FitnessPlan.ACTIVITY_LEVEL;
import com.evansnet.measurement.HEIGHT_UNITS;
import com.evansnet.measurement.MEASUREMENT_SYSTEM;

/**
 * Interface IPerson
 * 
 * Describes the basic characteristics necessary for calculation of 
 * Body Mass Index (BMI) and Basal Metabolic Rate (BMR) for a generic
 * human being.
 * 
 * @author Dan Evans
 * @copyright (c) 2015 all rights reserved.
 *
 */
public interface IPerson {

	// constants
	public static final int POUND_OF_FAT = 3500; // A pound of fat in terms of calories.
	
	// These factors help designate the amount of calories over BMR that will maintain weight.
	public static final double SEDENTARY = 1.2;				//KCal Minimal activity.
	public static final double LIGHT_EXERCISE = 1.375; 		//KCal Light exercise 1 to 3 days / week.
	public static final double MODERATE_EXERCISE = 1.55;	//KCal Moderate exercise 3 to 5 days / week.
    public static final double HEAVY_EXERCISE = 1.725;		//KCal  Vigorous exercise 6 to 7 days / week. 
    public static final double VERYHEAVY_EXERCISE = 1.9;	//KCal  Exercise twice per day 6 to 7 days / week.
          

    public int calcCurrentAge();
    public void useMeasurementSystem(MEASUREMENT_SYSTEM measurmentSystem);
    public void hgtUnits(HEIGHT_UNITS h);
    public void activityLvl(ACTIVITY_LEVEL a);
    public boolean isMetric();
}
