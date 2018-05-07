package com.evansnet.FitnessPlanTest;

import org.junit.Test;

import com.evansnet.FitnessPlan.FemalePerson;
import com.evansnet.FitnessPlan.MalePerson;
import com.evansnet.FitnessPlan.SEX;
import com.evansnet.measurement.MEASUREMENT_SYSTEM;


public class CalcDeficitAllTests {

	MalePerson englishMale;
	FemalePerson englishFemale;
	
	MalePerson metricMale;
	FemalePerson metricFemale;
	
	
	// Input parameters for people use for person tests and unit conversiontests
	final Double weight = 150.0; 		// pounds.
	final Double height = 5.0*12.0+5; 	// inches.
	final int age = 50;
	
	
	public CalcDeficitAllTests() {
		englishMale = new MalePerson();
		englishFemale = new FemalePerson();
	}
	
	/**
	 * Set up for all tests
	 */
	public void setUp() {
		
		// set up the male for the test first.
		setupEnglishMale(englishMale);
		setupMetricMale(metricMale);
		
		// now set up the girls.
		setupEnglishFemale(englishFemale);
		setupMetricFemale(metricFemale);
	}
	
	private void setupMetricFemale(FemalePerson metricFemale2) {
		
	}

	private void setupEnglishFemale(FemalePerson englishFemale2) {
		
	}

	private void setupMetricMale(MalePerson metricMale2) {
		
	}

	
	private void setupEnglishMale(MalePerson m) {
		this.englishMale.setGender(SEX.MALE);
		this.englishMale.setHeight(this.height);
		this.englishMale.setCurrentWeight(this.weight);
		this.englishMale.useMeasurementSystem(MEASUREMENT_SYSTEM.ENGLISH);
	}
	
}
