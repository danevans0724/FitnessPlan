package com.evansnet.FitnessPlan;

import com.evansnet.measurement.HEIGHT_UNITS;
import com.evansnet.measurement.MEASUREMENT_SYSTEM;

public class FemalePerson extends Person {

	private final Double[] BMRCONSTANTS = {447.593, 9.247, 3.098, 4.330}; 
	/**
	 * @ref WOMEN BMR = 447.593 + (9.247 x weight in kg) + (3.098 x height in cm) - (4.330 x age in years)
	*/
	public FemalePerson() {
		super(SEX.FEMALE, MEASUREMENT_SYSTEM.Metric, HEIGHT_UNITS.CENTIMETERS);
		this.setConstants(BMRCONSTANTS);	
	}
	
	/**
	 * Calculates the Basil Metabolic rate for an adult female.
	 * 
	 * @return a Double representing the BMR for this FemalePerson
	 */
	public Double getBMR() {
		super.calcBMR(BMRCONSTANTS);
		super.calcBMI();
		return bmr;
		}	
}
