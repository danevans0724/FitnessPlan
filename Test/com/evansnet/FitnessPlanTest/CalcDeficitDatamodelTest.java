package com.evansnet.FitnessPlanTest;

//import static org.junit.Assert.*;
//import java.util.Calendar;
//import org.junit.Test;
/*
import com.evansnet.FitnessPlan.BMICalculator;
import com.evansnet.FitnessPlan.BMICalculator.HEIGHT_UNITS;
import com.evansnet.FitnessPlan.BMICalculator.MEASUREMENT_SYSTEM;
import com.evansnet.FitnessPlan.BMICalculator.SEX;


public class CalcDeficitDatamodelTest {
	
	// TODO: write a test for conversion of centimeters to Meters.

	@Test
	public void testCalcDefictDatamodel() {
		BMICalculator d= new BMICalculator();
		assertTrue(d instanceof BMICalculator);
	}

	@Test
	public void testGetBMIEnglishUnitsTest() {
		// Test the BMICalculator calculation for a 160lb Male 57 years of age, 5'-5" high.
		BMICalculator dm = new BMICalculator();
		dm.setCurrentWeight(Double.valueOf(160));
		dm.setGender(SEX.Male);
		dm.setHeight(Double.valueOf((5*12)+5));
		
		// Test for English units.
		try {
			dm.setUOMSystem (MEASUREMENT_SYSTEM.English);
			dm.setUnits(HEIGHT_UNITS.INCHES);
			assertEquals(Double.valueOf(26.6), dm.getBMI(), Double.valueOf(0.09));
		} catch (AssertionError e) {
			fail("Failed BMICalculator calculation with English units.\n" + 
					"BMICalculator returned was: " + dm.getBMI().toString());
			e.printStackTrace();
		}		
	}
	
	@Test 
	public void testGetBMIMetricUnits () {
		// Test the BMICalculator calculation for a 160lb Male 57 years of age, 5'-5" high.
		BMICalculator dm = new BMICalculator();
		dm.setCurrentWeight(Double.valueOf(72.5748));
		dm.setGender(SEX.Male);
		dm.setHeight(Double.valueOf(165.1));

		try {
			dm.setUOMSystem(MEASUREMENT_SYSTEM.Metric);
			dm.setUnits(HEIGHT_UNITS.CENTIMETERS);
			assertEquals(Double.valueOf(26.6), dm.getBMI(), Double.valueOf(0.09));
		} catch (AssertionError e) {
			fail("Failed BMICalculator calculation with Metric units.\n" + 
					"BMICalculator returned was: " + dm.getBMI().toString());
			e.printStackTrace();
		}
	}
	
	@Test
	public void GetBMREnglishMaleTest() {
		// Test BMR calculation for a 160 lb Male 57 years of age and 5'-5" high.
		// ref: MEN BMR = 88.362 + (13.397 x weight in kg) + (4.799 x height in cm) - (5.677 x age in years)
		BMICalculator dm = new BMICalculator();
		dm.setUOMSystem(MEASUREMENT_SYSTEM.English);
		dm.setCurrentWeight(160.0);
		dm.setHeight(5.0*12+5);
		dm.setGender(SEX.Male);
		Calendar bdCal = Calendar.getInstance();
		int currentYear = bdCal.get(Calendar.YEAR);
		int testYear = currentYear - 57;
		bdCal.set(Calendar.YEAR, testYear);
		bdCal.set(Calendar.MONTH, 7);
		bdCal.set(Calendar.DAY_OF_MONTH, 24);		
		Calendar today = Calendar.getInstance();		
		dm.setBirthDate(bdCal);

		try {
			assertEquals(Double.valueOf(1529.4), dm.getBMR(), Double.valueOf(0.9));
		} catch (AssertionError e) {
			fail("\nTest failed for male BMR calculation using English units\n" + 
		         "The value returned is: " + dm.getBMR().toString() + 
		         "\n Age is: " + dm.getCurrentAge() + 
		         "\n Gender is: " + dm.getGender() + 
		         "\n Weight is: " + dm.getCurrentWeight() + 
		         "\n Height is: " + dm.getHeight());
			
			
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBMREnglishFemaleTest() {
		BMICalculator dm = new BMICalculator();
		dm.setUOMSystem(MEASUREMENT_SYSTEM.English);
		dm.setCurrentWeight(160.0);
		dm.setHeight(5.0*12+5);
		dm.setGender(SEX.Female);
		Calendar bdCal = Calendar.getInstance();
		int currentYear = bdCal.get(Calendar.YEAR);
		int testYear = currentYear - 57;
		bdCal.set(Calendar.YEAR, testYear);
		bdCal.set(Calendar.MONTH, 7);
		bdCal.set(Calendar.DAY_OF_MONTH, 24);		
		Calendar today = Calendar.getInstance();		
		dm.setBirthDate(bdCal);
		try {
			assertEquals(Double.valueOf(1383.36), dm.getBMR(), Double.valueOf(0.9));
		} catch (AssertionError e) {
			fail("Test failed for female BMR calculation using English units\n" + 
		         "The value returned is: " + dm.getBMR().toString()  + 
		         "\n Age is: " + dm.getCurrentAge() + 
		         "\n Gender is: " + dm.getGender() + 
		         "\n Weight is: " + dm.getCurrentWeight() + 
		         "\n Height is: " + dm.getHeight());
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBMRMetricMaleTest() {
		BMICalculator dm = new BMICalculator();
		dm.setUOMSystem(MEASUREMENT_SYSTEM.Metric);
		dm.setUnits(HEIGHT_UNITS.CENTIMETERS);
		dm.setCurrentWeight(72.5748);
		dm.setHeight(165.1);
		dm.setGender(SEX.Male);
		Calendar bdCal = Calendar.getInstance();
		int currentYear = bdCal.get(Calendar.YEAR);
		int testYear = currentYear - 57;
		bdCal.set(Calendar.YEAR, testYear);
		bdCal.set(Calendar.MONTH, 7);
		bdCal.set(Calendar.DAY_OF_MONTH, 24);		
		Calendar today = Calendar.getInstance();		
		dm.setBirthDate(bdCal);
		
		try {
			assertEquals(Double.valueOf(1529.4), dm.getBMR(), Double.valueOf(0.9));
		} catch (AssertionError e) {
			fail("Test failed for male BMR calculation using Metric units\n" + 
		         "The value returned is: " + dm.getBMR().toString());
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBMRMetricFemaleMaleTest() {
		BMICalculator dm = new BMICalculator();
		dm.setUOMSystem(MEASUREMENT_SYSTEM.Metric);
		dm.setUnits(HEIGHT_UNITS.CENTIMETERS);
		dm.setCurrentWeight(72.5748);
		dm.setHeight(165.1);
		dm.setGender(SEX.Female);
		Calendar bdCal = Calendar.getInstance();
		int currentYear = bdCal.get(Calendar.YEAR);
		int testYear = currentYear - 57;
		bdCal.set(Calendar.YEAR, testYear);
		bdCal.set(Calendar.MONTH, 7);
		bdCal.set(Calendar.DAY_OF_MONTH, 24);		
		Calendar today = Calendar.getInstance();		
		dm.setBirthDate(bdCal);
		try {
			assertEquals(Double.valueOf(1383.36), dm.getBMR(), Double.valueOf(0.9));
		} catch (AssertionError e) {
			fail("Test failed for female BMR calculation using Metric units\n" + 
		         "The value returned is: " + dm.getBMR().toString() + 
		         "\n Age is: " + dm.getCurrentAge() + 
		         "\n Gender is: " + dm.getGender() + 
		         "\n Weight is: " + dm.getCurrentWeight() + 
		         "\n Height is: " + dm.getHeight());
			e.printStackTrace();
		}
	}
	

	@Test 
	public void testGetCurrentAgeEquals57Test() {
		//Test the calculation of the user's current age.
		BMICalculator dm = new BMICalculator();
		Calendar bdCal = Calendar.getInstance();
		int currentYear = bdCal.get(Calendar.YEAR);
		int testYear = currentYear - 57;
		bdCal.set(Calendar.YEAR, testYear);
		bdCal.set(Calendar.MONTH, 7);
		bdCal.set(Calendar.DAY_OF_MONTH, 24);
		
		Calendar today = Calendar.getInstance();
		
		dm.setBirthDate(bdCal);
		// Debugging line System.out.println("Age returned is: " + dm.getCurrentAge());
		assertEquals((int) 57, dm.getCurrentAge());
	}
}*/
