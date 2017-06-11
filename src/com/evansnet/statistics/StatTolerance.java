package com.evansnet.statistics;

import java.util.HashMap;


/**
 * <p>Defines the average value for a statistic and its boundry tolerances, 
 * i.e.: the values that describe the danger points for the statistic.
 * Define these with a name for the low limit value, and a numeric value for the same.
 * Then define the nominal value name and its value and then also the 
 * high limit value name and its value.</p>
 * 
 * <p>Example:</p>
 * <l>For blood glucose, the following would apply:
 * <li>Low limit: "Too low" and a value of 70.</li>
 * <li>nominal:   "Fasting 8 hours." and a value of 90.</li>
 * <li>high limit: "2 hours after eating" with a value of 140.</li>
 * </l><br>
 * @author Dan
 *
 */
public class StatTolerance {

	HashMap<String, Double> tolerances;
	
	String lowValueName;
	Double lowValue;
	String nominalValueName;
	Double nominalValue;
	String highValueName;
	Double highValue;
	
	public StatTolerance () {
		lowValueName = new String();
		lowValue = 0.0;
		nominalValueName = new String();
		nominalValue = 0.0;
		highValueName = new String();
		highValue = 0.0;
	}
	
	/**
	 * @return the lowValueName
	 */
	public String getLowValueName() {
		return lowValueName;
	}
	/**
	 * @param lowValueName the lowValueName to set
	 */
	public void setLowValueName(String lowValueName) {
		this.lowValueName = lowValueName;
	}
	/**
	 * @return the lowValue
	 */
	public Double getLowValue() {
		return lowValue;
	}
	/**
	 * @param lowValue the lowValue to set
	 */
	public void setLowValue(Double lowValue) {
		this.lowValue = lowValue;
	}
	/**
	 * @return the nominalValueName
	 */
	public String getNominalValueName() {
		return nominalValueName;
	}
	/**
	 * @param nominalValueName the nominalValueName to set
	 */
	public void setNominalValueName(String nominalValueName) {
		this.nominalValueName = nominalValueName;
	}
	/**
	 * @return the nominalValue
	 */
	public Double getNominalValue() {
		return nominalValue;
	}
	/**
	 * @param nominalValue the nominalValue to set
	 */
	public void setNominalValue(Double nominalValue) {
		this.nominalValue = nominalValue;
	}
	/**
	 * @return the highValueName
	 */
	public String getHighValueName() {
		return highValueName;
	}
	/**
	 * @param highValueName the highValueName to set
	 */
	public void setHighValueName(String highValueName) {
		this.highValueName = highValueName;
	}
	/**
	 * @return the highValue
	 */
	public Double getHighValue() {
		return highValue;
	}
	/**
	 * @param highValue the highValue to set
	 */
	public void setHighValue(Double highValue) {
		this.highValue = highValue;
	}
	
	public void setTolerances() {
		if (!tolerances.isEmpty())
			clearTolerances();
		tolerances.put(lowValueName, lowValue);
		tolerances.put(nominalValueName, nominalValue);
		tolerances.put(highValueName, highValue);
	}
	
	public HashMap<String, Double> getTolerances() {
		return tolerances;
	}
	
	private void clearTolerances() {
		tolerances.clear();
	}
	
	
}
