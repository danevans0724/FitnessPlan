package com.evansnet.statistics;

import java.util.ArrayList;
import java.util.List;



/** 
 * A list of statistics of a particular type. For instance, the list 
 * could be for statistics relating to blood pressure (Systolic, diastolic and pulse 
 * measurements). Note that this list could contain only one type of measurement, 
 * as in weight for instance.
 * 
 * The StatList includes a StatTolerance object that allows for the comparison of 
 * a particular statistic against a range of acceptable values. This allows the user
 * to compare the list of statistics against individual acceptable ranges and thus
 * assess how appropriate the value of the particular statistic is. For instance,
 * a weight statistic can be compared against a tolerance range for a 50 year old
 * male. 
 * 
 * @author Dan Evans (c) 2016. All rights reserved.
 *
 */
public abstract class StatList {
	
	String statType;
	List<StatTolerance> statToleranceList;
	List<IStat> theStatList;
	
	public StatList() {
		statType = new String();
		statToleranceList = new ArrayList<StatTolerance>();
		theStatList = new ArrayList<IStat>();
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
	 * @return the statToleranceList
	 */
	public List<StatTolerance> getStatListTolerance() {
		return statToleranceList;
	}

	/**
	 * @param statToleranceList the statToleranceList to set
	 */
	public void setStatListTolerance(List<StatTolerance> tolerances) {
		this.statToleranceList = tolerances;
	}

	/**
	 * @return the theStat
	 */
	public ArrayList<IStat> getTheStat() {
		return (ArrayList<IStat>)theStatList;
	}

	/**
	 * @param theStat the theStat to set
	 */
	public void setTheStat(List<IStat> theList) {
		this.theStatList = theList;
	}
	
	public void addAStatToList(IStat s) {
		theStatList.add(s);
	}
	
	
	

}
