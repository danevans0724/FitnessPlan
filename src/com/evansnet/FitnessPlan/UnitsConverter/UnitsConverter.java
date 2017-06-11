package com.evansnet.FitnessPlan.UnitsConverter;

public class UnitsConverter implements IUnitsConverter{
	

	@Override
	public Double inchesToCentimeters(Double in) {
		return in/(IUnitsConverter.INCH*IUnitsConverter.CM);
	}

	@Override
	public Double FeetToCentimeters(Double ft) {
		Double in = ft * 12;
		return inchesToCentimeters(in);
	}

	@Override
	public Double CentimetersToFeet(Double cm) {
		return 1/FeetToCentimeters(cm);
	}

	@Override
	public Double PoundsToKg(Double lb) {
		return lb/IUnitsConverter.POUND;
	}
	
	@Override
	public Double KgToPounds (Double kg) {
		return kg*IUnitsConverter.POUND;
	}

	@Override
	public Double CentimetersToInches(Double cm) {
		return cm*IUnitsConverter.CM*IUnitsConverter.INCH;
	}

	@Override
	public Double CentimetersToMeters(Double cm) {
		// Meters is used for height for BMI.
		return cm/IUnitsConverter.CM;
	}
}
