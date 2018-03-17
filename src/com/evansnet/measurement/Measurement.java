package com.evansnet.measurement;



public class Measurement implements IMeasurement {
	
	// Fields
	String name;
	Double value;
	MEASUREMENT_SYSTEM measurementSystem;
	MEASUREMENT_TYPE type;
	MASS_UNIT massUnits;
	HEIGHT_UNITS heightUnits;
	
	//Constructors
	public Measurement(MEASUREMENT_SYSTEM m, MEASUREMENT_TYPE t) {
		setMeasurementSystem(m);
		setMeasurementType(t);
	}
	
	public Measurement(String n, Double d, MEASUREMENT_SYSTEM s, MEASUREMENT_TYPE t){
		name = new String(n);
		value = new Double(d);
		setMeasurementSystem(s);
		setMeasurementType(t);
	}

	private void setMeasurementType(MEASUREMENT_TYPE t) {
		type = t;
	}

	private void setMeasurementSystem(MEASUREMENT_SYSTEM sys) {
		measurementSystem = sys;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String n) {
		name = n;
	}

	@Override
	public Double getValue() {
		return value;
	}

	@Override
	public void setValue(Double v) {
		value = v;
	}
	
	public HEIGHT_UNITS getUnits() {
		return heightUnits;
	}
	
	public void setUnits(HEIGHT_UNITS u) {
		heightUnits = u;
	}
	
	/**
	 * Converts this measurement value to a different measurement system 
	 * assuming the conversion is from the system this measurement is
	 * defined in.
	 * 
	 * @param to 
	 * 		The measurement system to convert the value to.
	 * @return
	 * 		Returns a double representing the converted value or null 
	 * 		if the conversion would be invalid.
	 * @throws Exception 
	 * @throws ConversionException 
	 */
	@SuppressWarnings("incomplete-switch")
	public Double convertDistance(MEASUREMENT_SYSTEM toSystem, HEIGHT_UNITS fromUnit, HEIGHT_UNITS toUnit, Double value ) throws ConversionException, Exception {
		if (measurementSystem == MEASUREMENT_SYSTEM.ENGLISH) {
			switch (fromUnit) {
			case INCHES:
				switch (toUnit) {
				case CENTIMETERS:
					return value * 2.54;
				case METERS:
					return value * 0.0254;
				case INCHES:
					return value;
				case FEET:
					return value / 12;
				}
			case FEET:
				switch (toUnit) {
				case CENTIMETERS:
					return value * 30.48;
				case METERS:
					return value * .3048;
				case INCHES:
					return value * 12;
				case FEET:
					return value;
				}
			}
			return null;
		} else if (measurementSystem == MEASUREMENT_SYSTEM.METRIC) {
			switch (fromUnit) {
			case CENTIMETERS:
				switch (toUnit) {
				case INCHES:
					return value * 0.393701;
				case METERS:
					return value * 0.01;
				case CENTIMETERS:
					return value;
				case FEET:
					return value * 0.0328084;
				}
			case METERS:
				switch (toUnit) {
				case CENTIMETERS:
					return value * 100;
				case METERS:
					return value;
				case INCHES:
					return value * 39.3701;
				case FEET:
					return value * 3.28084;
				}
		}
			return null;
		} else {
		// Invalid conversion attempted.
		throw new ConversionException("An invalid conversion was attempted");
		}
	}
	
	/**
	 * Converts this measurement value to a different system of mass.
	 * @param toSystem - The measurement system to convert to.
	 * @param toUnit - The mass unit to convert to.
	 * @param from - The value to convert.
	 * @return
	 * @throws Exception 
	 * @throws ConversionException 
	 */
	public Double convertMass(MEASUREMENT_SYSTEM toSystem, MASS_UNIT fromUnit, MASS_UNIT toUnit, Double value) throws ConversionException, Exception {
		if (measurementSystem == MEASUREMENT_SYSTEM.ENGLISH ) {
			switch (fromUnit) {
			case POUNDS:
				switch (toUnit) {
				case POUNDS:
					return value;
				case KILOGRAMS:
					return value * 0.453592;
				}
			case KILOGRAMS:
				switch (toUnit) {
				case KILOGRAMS:
					return value;
				case POUNDS:
					return value * 2.20462;
				}
			}
		} else if (measurementSystem == MEASUREMENT_SYSTEM.METRIC) {
			switch (fromUnit) {
			case POUNDS:
				switch (toUnit) {
				case POUNDS:
					return  value;
				case KILOGRAMS:
					return value * 0.453592;
				}
			case KILOGRAMS:
				switch (toUnit) {
				case POUNDS:
					return value * 2.20462;
				case KILOGRAMS:
					return value;
				}
			}
		}
		//Invalid conversion attempted
		throw new ConversionException("Illegal conversion attempted.");
	}
}
