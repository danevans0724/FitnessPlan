package com.evansnet.FitnessPlan;

import com.evansnet.measurement.HEIGHT_UNITS;
import com.evansnet.measurement.MEASUREMENT_SYSTEM;

public class MalePerson extends Person {
	
	private final Double[] BMRCONSTANTS = {88.362, 13.397, 4.799, 5.677};
	
	/**
	 *@ref MEN BMR = 88.362 + (13.397 x weight in kg) + (4.799 x height in cm) - (5.677 x age in years) 
	 */
	public MalePerson() {
		super(SEX.MALE, MEASUREMENT_SYSTEM.Metric, HEIGHT_UNITS.CENTIMETERS);
		this.setConstants(BMRCONSTANTS);
	}
	
	public Double getBMR() {
		super.calcBMR(BMRCONSTANTS);
		super.calcBMI();
		return bmr;
		}
	
	
}
