package com.evansnet.FitnessPlan.UnitsConverter;

 /**
 *  <bold>Interface: IUnitsConverter</bold>
 *  This interface provides static conversion values and methods for the 
 *  conversion of units to and from the English and Metric systems.
 *  
 *  The interface uses the Kilogram as the base unit for all mass conversions. In
 *  other words the conversion from Kilograms to Kilograms uses a factor of 1. In
 *  addition, the base unit for distance is the meter and all other conversion
 *  factors are a value that converts the source value to meters.  
 *
 *  
 * @author Dan Evans 
 * @copyright © 2015 Daniel C. Evans. All rights reserved.
 * 
 */

public interface IUnitsConverter {
	
	// public constants
	// Mass
	public static final Double Kg = 1.0;
	public static final Double POUND = 2.20462;					// Pounds in a kilogram					
	
	
	// Distance
	// Metric 
	public static final Double METER = 1.0;
	public static final Double KM = 1000.0;
	public static final Double CM = 0.01; 
	public static final Double MM = 0.001;
	
	// English distance
	public static final Double INCH = 39.37007874;				// inches per meter	
	public static final Double FEET = 3.28084;					// feet per meter
	public static final Double YARD = 1.0936133333333297735; 	// yards per meter.
	public static final Double MILE = 0.00062137121212121;		// Miles per meter

	public Double inchesToCentimeters (Double in);
	public Double FeetToCentimeters (Double ft);
	public Double CentimetersToInches(Double cm);
	public Double CentimetersToMeters(Double cm);
	public Double CentimetersToFeet(Double cm);

	public Double PoundsToKg (Double lb);
	public Double KgToPounds (Double kg);
	

}
