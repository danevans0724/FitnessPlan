package com.evansnet.FitnessPlan;


public class BMICalculator {

	private Double BMI;
	
	/* The class needs to have an object based on the IPerson interface
	 * That interface should have the units of measure etc defined for the
	 * person that we are planning for.
	 */
	public BMICalculator () {
		BMI = new Double(0.0);
	}
	
	/**
	 * <p>Calculates the user's Body Mass Index (BMI) using the information provided.</p>
	 * <p>The class needs to have an object based on the IPerson interface
	 * That interface should have the units of measure etc defined for the
	 * person that we are planning for.</p>
	 * 
	 * @ref BMI = (mass(kg)/(height(m))^2 OR (mass(lb)/height(in))^2))*703
	 * @param p A person object for the calculations.
	 * @return The users BMI (Body mass index)
	 *
	 */
	
	public Double calcBMI (Person p) {
		double wgt = p.getWeight();
		double hgt = p.getHeight();
		if (!p.isMetric()){
			BMI = (wgt/Math.pow(hgt, 2))*703;	// Units must be in inches.
		} else {
			//units must be metric and height in meters.
			if (p.areCentimeters()) {			// Forces the logic to convert to meters.
				hgt = hgt/100;
			}
			BMI = (wgt/Math.pow(hgt, 2));
		}
		return BMI;
	}
	

	public void setBMI(Double b) {
		BMI = b;		
	}
}
