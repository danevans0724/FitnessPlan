package com.evansnet.statistics;

import java.util.List;
import java.util.ArrayList;

/** 
 * A list of statistic types that can be used to classify lists of statistics
 * 
 * @author Dan
 *
 */
public class StatTypeList { 
	
	List<String> typeList;
	
	
	public StatTypeList() {
		typeList = new ArrayList<String>();
	}


	/**
	 * @return the typeList
	 */
	public List<String> getTypeList() {
		return typeList;
	}


	/**
	 * @param typeList the typeList to set
	 */
	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}
	
	public void addStatType(String s) {
		typeList.add(s);
	}

}
