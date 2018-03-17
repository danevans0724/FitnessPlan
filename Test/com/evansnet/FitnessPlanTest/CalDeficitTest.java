package com.evansnet.FitnessPlanTest;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import com.evansnet.FitnessPlan.BMR;
import com.evansnet.FitnessPlan.MalePerson;
import com.evansnet.FitnessPlan.Person;
import com.evansnet.FitnessPlan.UnitsConverter.UnitsConverter;
import com.evansnet.measurement.HEIGHT_UNITS;
import com.evansnet.measurement.MEASUREMENT_SYSTEM;

public class CalDeficitTest {
	@Test
	public void GetBMRandBMIEnglishMaleTest() {
		BMR bmr = new BMR();
		Person person = new MalePerson();
		UnitsConverter uc = new UnitsConverter();
		person.setCurrentWeight(uc.PoundsToKg(160.0));
		person.setHeight(uc.inchesToCentimeters(5.0*12+5));
		Calendar bdCal = Calendar.getInstance();
		int currentYear = bdCal.get(Calendar.YEAR);
		int testYear = currentYear - 57;
		bdCal.set(Calendar.YEAR, testYear);
		bdCal.set(Calendar.MONTH, 7);
		bdCal.set(Calendar.DAY_OF_MONTH, 24);		
		person.setBirthDate(bdCal);
		person.calcCurrentAge();

		try {
			bmr.calcBMR(person);
			Double theBmr = bmr.getBMR();
			theBmr =  ((double)Math.round(theBmr * 100)) / 100;	//Round to 2 decimals. That is all the precision we need for this.
			assertEquals(Double.valueOf(1529.37), theBmr);
		} catch (AssertionError e) {
			fail("\nTest failed for male BMR calculation using English units\n" + 
		         "The value returned is: " + bmr.getBMR() + 
		         "\n Age is: " + person.calcCurrentAge() + 
		         "\n Gender is: Male" + 
		         "\n Weight is: " + person.getCurrentWeight() + 
		         "\n Height is: " + person.getHeight());
			e.printStackTrace();
		}
		
		// Now get the BMI
		person.useMeasurementSystem(MEASUREMENT_SYSTEM.METRIC);
		person.hgtUnits(HEIGHT_UNITS.CENTIMETERS);
		Double theBmi = person.getBMI();
		theBmi = ((double)Math.round(theBmi * 100)) / 100; 	// Round to 2 decimals
		
		try {
			assertEquals(Double.valueOf(26.63), theBmi);
		} catch (AssertionError e) {
			fail("\nfailed for male BMI calculation using Metric units\n" + 
					"The value returned is " + theBmi + 
					"\n the age is " + person.calcCurrentAge() + 
					"\nGender is Male \n" + 
					"With a weight of " + person.getWeight() + 
					"\nand a height of " + person.getHeight());
		}
		
		// Now test BMI for English units\
		person.useMeasurementSystem(MEASUREMENT_SYSTEM.ENGLISH);
		person.setHeight(5.0*12 + 5.0);
		person.setCurrentWeight(160.0);
		theBmi = person.getBMI();
		theBmi = ((double)Math.round(theBmi * 100)) / 100; 	// Round to 2 decimals
		
		try {
			assertEquals(Double.valueOf(26.62), theBmi);
		} catch (AssertionError e) {
			fail("\nfailed for male BMI calculation using English units\n" + 
					"The value returned is " + theBmi + 
					"\n the age is " + person.calcCurrentAge() + 
					"\nGender is Male \n" + 
					"With a weight of " + person.getWeight() + 
					"\nand a height of " + person.getHeight());
		}
	}

}
