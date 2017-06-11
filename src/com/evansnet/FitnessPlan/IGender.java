package com.evansnet.FitnessPlan;

/**
 * Formulas used in fitness calculations sometimes vary by male or female. 
 * This interface defines the basic factors and methods so that the base 
 * formula can be the same across classes defined for male or female.
 *  
 * @author Dan
 *
 */
public interface IGender {
	
	public Double[] BMRConst = {0.0, 0.0, 0.0, 0.0};
	public SEX sex = null;
	
	public void setGender(SEX g);
	public SEX  genderIs();			//Returns the gender, MALE or FEMALE
	public void setConstants(Double[] c);
	public Double getBMRConst(int i);
}
