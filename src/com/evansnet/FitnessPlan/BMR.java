package com.evansnet.FitnessPlan;



public class BMR {
		
	protected Double BMR;					// The user's Basil Metabolic Rate
	protected Person person;				// The person is the user.
	
	/**
	 * Returns the user's Basil Metabolic Rate (BMR) given the info provided.
	 * 
	 * @return Double - Basil Metabolic Rate
	 *
	 * @ref WOMEN BMR = 447.593 + (9.247 x weight in kg) + (3.098 x height in cm) - (4.330 x age in years)
	 * @ref MEN BMR = 88.362 + (13.397 x weight in kg) + (4.799 x height in cm) - (5.677 x age in years) 
	 */ 
	public Double getBMR() { return BMR; }

	public void calcBMR(Person p) {
		BMR = p.getBMRConst(0) + ((p.getBMRConst(1) * p.getWeight()) +
				(p.getBMRConst(2) * p.getHeight()) -
				(p.getBMRConst(3) * p.getAge()));		
	}

	 public void setBMR(IPerson p) {
		 // Override in the extended classes.
	 }
}
