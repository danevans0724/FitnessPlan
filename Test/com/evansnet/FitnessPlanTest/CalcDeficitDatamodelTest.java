package com.evansnet.FitnessPlanTest;

import static org.junit.Assert.*;
import org.junit.Test;

import com.evansnet.FitnessPlan.BMICalculator;
import com.evansnet.FitnessPlan.FemalePerson;
import com.evansnet.FitnessPlan.MalePerson;
import com.evansnet.FitnessPlan.Person;
import com.evansnet.measurement.ConversionException;
import com.evansnet.measurement.HEIGHT_UNITS;
import com.evansnet.measurement.MASS_UNIT;
import com.evansnet.measurement.MEASUREMENT_SYSTEM;
import com.evansnet.measurement.MEASUREMENT_TYPE;
import com.evansnet.measurement.Measurement;


public class CalcDeficitDatamodelTest {
		
	
	@Test
	public void testCalcDefictDatamodel() {
		BMICalculator d= new BMICalculator();
		assertTrue(d instanceof BMICalculator);
	}

	@Test
	public void testGetBMIENGLISHUnitsTest() {
		// Test the BMICalculator calculation for a 160lb Male 57 years of age, 5'-5" high.
		Person man = new MalePerson();
		man.setCurrentWeight(Double.valueOf(160));
		man.setHeight(Double.valueOf((5*12)+5));
		
		// Test for ENGLISH units.
		try {
			man.useMeasurementSystem(MEASUREMENT_SYSTEM.ENGLISH);
			man.setHgtUnits(HEIGHT_UNITS.INCHES);
			man.calcBMI();
			assertEquals(Double.valueOf(26.6), man.getBMI(), Double.valueOf(0.09));
		} catch (AssertionError e) {
			fail("Failed BMICalculator calculation with ENGLISH units.\n" + 
					"BMICalculator returned was: " + man.getBMI().toString());
			e.printStackTrace();
		}		
	}
	
	@Test 
	public void testGetBMIMETRICUnits () {
		// Test the BMICalculator calculation for a 160lb Male 57 years of age, 5'-5" high.
		Person man = new MalePerson();
		man.setCurrentWeight(Double.valueOf(72.5748));
		man.setHeight(Double.valueOf(165.1));

		try {
			assertEquals(Double.valueOf(26.6), man.getBMI(), Double.valueOf(0.09));
		} catch (AssertionError e) {
			fail("Failed BMICalculator calculation with METRIC units.\n" + 
					"BMICalculator returned was: " + man.getBMI().toString());
			e.printStackTrace();
		}
	}
	
	@Test
	public void GetBMRENGLISHMaleTest() {
		// Test BMR calculation for a 160 lb Male 57 years of age and 5'-5" high.
		// ref: MEN BMR = 88.362 + (13.397 x weight in kg) + (4.799 x height in cm) - (5.677 x age in years)
		MalePerson dm = new MalePerson();
		Measurement m = new Measurement(MEASUREMENT_SYSTEM.ENGLISH, MEASUREMENT_TYPE.MASS);
		try {
			dm.setCurrentWeight(m.convertMass(MEASUREMENT_SYSTEM.METRIC, MASS_UNIT.POUNDS, MASS_UNIT.KILOGRAMS, 160.0));
			dm.setHeight(m.convertDistance(MEASUREMENT_SYSTEM.METRIC, HEIGHT_UNITS.INCHES, HEIGHT_UNITS.CENTIMETERS, 65.0));
		} catch (ConversionException e1) {
			e1.printStackTrace();
			fail("Exception thrown");
		} catch (Exception e1) {
			e1.printStackTrace();
			fail("Exception thrown");
		}
		dm.setAge(57);
		
		try {
			assertEquals(Double.valueOf(1529.4), dm.getBMR(), Double.valueOf(0.9));
		} catch (AssertionError e) {
			fail("\nTest failed for male BMR calculation using ENGLISH units\n" + 
		         "The value returned is: " + dm.getBMR().toString() + 
		         "\n Age is: " + dm.getAge() + 
		         "\n Gender is: " + dm.genderIs() + 
		         "\n Weight is: " + dm.getCurrentWeight() + 
		         "\n Height is: " + dm.getHeight());
			
			
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBMRENGLISHFemaleTest() {
		Measurement m = new Measurement(MEASUREMENT_SYSTEM.ENGLISH, MEASUREMENT_TYPE.MASS);
		FemalePerson dm = new FemalePerson();
		try {
			dm.setCurrentWeight(m.convertMass(MEASUREMENT_SYSTEM.METRIC, MASS_UNIT.POUNDS, MASS_UNIT.KILOGRAMS, 160.0));
			dm.setHeight(m.convertDistance(MEASUREMENT_SYSTEM.METRIC, HEIGHT_UNITS.INCHES, HEIGHT_UNITS.CENTIMETERS, 65.0));
		} catch (ConversionException e1) {
			e1.printStackTrace();
			fail("Measurement conversion failed");
		} catch (Exception e1) {
			e1.printStackTrace();
			fail("Measurement conversion failed");
		}
		dm.setAge(57);
		
		try {
			assertEquals(Double.valueOf(1383.36), dm.getBMR(), Double.valueOf(0.9));
		} catch (AssertionError e) {
			fail("Test failed for female BMR calculation using ENGLISH units\n" + 
		         "The value returned is: " + dm.getBMR().toString()  + 
		         "\n Age is: " + dm.getAge() + 
		         "\n Gender is: " + dm.genderIs() + 
		         "\n Weight is: " + dm.getCurrentWeight() + 
		         "\n Height is: " + dm.getHeight());
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBMRMETRICMaleTest() {
		MalePerson dm = new MalePerson();
		dm.useMeasurementSystem(MEASUREMENT_SYSTEM.METRIC);
		dm.setHgtUnits(HEIGHT_UNITS.CENTIMETERS);
		dm.setCurrentWeight(72.5748);
		dm.setHeight(165.1);
		dm.setAge(57);
		
		try {
			assertEquals(Double.valueOf(1529.4), dm.getBMR(), Double.valueOf(0.9));
		} catch (AssertionError e) {
			fail("Test failed for male BMR calculation using METRIC units\n" + 
		         "The value returned is: " + dm.getBMR().toString());
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBMRMETRICFemaleMaleTest() {
		FemalePerson dm = new FemalePerson();
		dm.setCurrentWeight(72.5748);
		dm.setHeight(165.1);
		dm.setAge(57);
		try {
			assertEquals(Double.valueOf(1383.36), dm.getBMR(), Double.valueOf(0.9));
		} catch (AssertionError e) {
			fail("Test failed for female BMR calculation using METRIC units\n" + 
		         "The value returned is: " + dm.getBMR().toString() + 
		         "\n Age is: " + dm.getAge() + 
		         "\n Gender is: " + dm.genderIs() + 
		         "\n Weight is: " + dm.getCurrentWeight() + 
		         "\n Height is: " + dm.getHeight());
			e.printStackTrace();
		}
	}
}
