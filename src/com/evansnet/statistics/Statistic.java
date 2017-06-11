package com.evansnet.statistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.evansnet.measurement.Measurement;


/**
 * Statistics are a compilation of a set of measurements used to provide a
 * meaninful description of an object, or the object's behavior or capability.
 * Statistics can describe the object itself and/or the variability of the 
 * object.
 * For instance, an average  is the sum of a group of measurements divided 
 * by the number of measurements taken. 
 * 
 * 
 * @author Dan Evans (c) 2016 all rights reserved.
 *
 */
public abstract class Statistic implements IStat {
	
	//Standard fields for statistics
	Date date;
	List<Measurement> measurements;
	String desc;
	String statType;	// From a string listed in class StatTypeList
	
	public Statistic() {
		date = new Date();
		measurements = new ArrayList<Measurement>();
		desc = new String();
	}

	public Statistic(Date dt, List<Measurement> ms, String d) {
		this.date = dt;
		this.measurements = ms;
		this.desc = d;
	}

	@Override
	public String getStatDesc() {
		return desc;
	}

	@Override
	public void setStatDesc(String d) {
		desc = d;
	}

	@Override
	public List<Measurement> getStat() {
		return measurements;
	}

	@Override
	public Date getStatDate() {
		return date;
	}

	@Override
	public void setStatDate(Date d) {
		date = d;
	}

	/**
	 * @return the statType
	 */
	public String getStatType() {
		return statType;
	}

	/**
	 * @param statType the statType to set
	 */
	public void setStatType(String statType) {
		this.statType = statType;
	}

	
	/**
	 * Returns the latest value in the list of measurements 
	 * for this statistic.
	 * 
	 * @return Double - The last value recorded.
	 */
	@Override
	public Double getValue() {
		Measurement m = measurements.get(measurements.size()-1);
		return m.getValue();
	}
	
	public Double getSum() {
		Double sum = new Double(0.0);
		for (Measurement m : measurements) {
			sum = sum + m.getValue();
		}
		return sum;
	}

	/** 
	 * Calculates the average of the list of measurements in the 
	 * statistic.
	 * 
	 * @return Double - The arithmatic average value
	 */
	@Override
	public Double getAverage() {
		Double avg = new Double(0.0);
		avg = getSum() / measurements.size();
		return avg;
	}

	@Override
	public Double getMaxValue() {
		Double max = new Double(0.0);
		for (Measurement m : measurements) {
			if(m.getValue() > max) {
				max = m.getValue();
			}
		}
		return max;
	}

	@Override
	public Double getMinValue() {
		Double min = new Double(measurements.get(0).getValue());
		for (Measurement m : measurements) {
			if(m.getValue() < min) {
				min = m.getValue();
			}
		}
		return min;
	}

	@Override
	public Double getVariance() {
		Double s = new Double(0.0);
		Double avg = getAverage();
		for (Measurement m : measurements ) {
			s = s + Math.pow((m.getValue() - avg), 2) ;
		}
		return s/measurements.size();
	}

	@Override
	public Double getStdDeviation() {		
		return Math.sqrt(getVariance());
	}
}
