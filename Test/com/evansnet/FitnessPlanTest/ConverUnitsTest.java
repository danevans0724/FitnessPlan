package com.evansnet.FitnessPlanTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.evansnet.FitnessPlan.UnitsConverter.UnitsConverter;

public class ConverUnitsTest {

	@Test
	public void InchesToCentimetersShouldEqual254test() {
		// Testing the conversion from inches to centimeters.
		UnitsConverter i2cm = new UnitsConverter();
		assertEquals(Double.valueOf(1/0.3937007874), (Double) i2cm.inchesToCentimeters(1.0));		
	}
	
	@Test
	public void FeetToCentimetersTestShouldEqual3048Test() {
		// 1 foot = 30.48000000012192000000048768 centimeters.
		UnitsConverter ft2cm = new UnitsConverter();
		assertEquals(Double.valueOf(30.48000000012192000000048768), 
				(Double) ft2cm.FeetToCentimeters(Double.valueOf(1)),
				Double.valueOf(0.000000000000009));
	}
	
	@Test
	public void CentimetersToFeetTestShouldEqual0328084() {
		// 1 centimeter equals 0.03280839895 feet
		UnitsConverter cm2ft = new UnitsConverter();
		Double ft = cm2ft.CentimetersToFeet(1.0);
		assertEquals(Double.valueOf(0.03280839895), ft);
	}
	
	@Test
	public void KgToPoundsTestShouldEqualTest() {
		// 1 Kilogram equals .45359237  
		UnitsConverter kg2lb = new UnitsConverter();
		Double lb = kg2lb.KgToPounds(Double.valueOf(1));
		assertEquals(Double.valueOf(1*2.20462), 
				lb );
	}
	
	@Test
	public void PoundsToKilogramsShouldEqualTest() {
		// 1 pound = roughly 2.20462 kilograms.
		UnitsConverter lb2kg = new UnitsConverter();
		assertEquals(Double.valueOf(1*0.45359237), 
				      lb2kg.PoundsToKg(Double.valueOf(1)),
				      Double.valueOf(0.009));
	}

}
