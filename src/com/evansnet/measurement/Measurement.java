package com.evansnet.measurement;



public class Measurement implements IMeasurement {
	
	// Fields
	String name;
	Double value;
	MEASUREMENT_SYSTEM measurementSystem;
	HEIGHT_UNITS heightUnits;
	
	//Constructors
	public Measurement() {
		name = new String();
		value = 0.00;
	}
	
	public Measurement(MEASUREMENT_SYSTEM m) {
		this.setMeasurementSystem(m);
		setRightUnits(m);
	}
	
	public Measurement(String n, Double d, MEASUREMENT_SYSTEM s){
		name = new String(n);
		value = new Double(d);
		setMeasurementSystem(s);
		setRightUnits(s);
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

	private void setRightUnits(MEASUREMENT_SYSTEM m) {
		if (m == MEASUREMENT_SYSTEM.English) 
			setUnits(HEIGHT_UNITS.INCHES);
		else
			setUnits(HEIGHT_UNITS.CENTIMETERS);
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
	 */
	public Double convert(MEASUREMENT_SYSTEM to) {
		if (measurementSystem == MEASUREMENT_SYSTEM.English &&
				to == MEASUREMENT_SYSTEM.Metric) {
			return value * 25.4;
		} else if (measurementSystem == MEASUREMENT_SYSTEM.Metric && 
				to == MEASUREMENT_SYSTEM.English) {
			return value/25.4;
		}
		
		// Invalid conversion attempted.
		return null;
	}
}
