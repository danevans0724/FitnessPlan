package com.evansnet.statistics;

import java.util.Date;
import java.util.List;

import com.evansnet.measurement.Measurement;


/**
 * Represents a list of measurements that represent a statistic such as an average.
 * 
 * @author Dan
 *
 */
public interface IStat {
	
	public String getStatDesc();
	public void setStatDesc(String d);
	public List<Measurement> getStat();
	public Date getStatDate();
	public void setStatDate(Date d);
	public Double getValue();
	public Double getAverage();
	public Double getMaxValue();
	public Double getMinValue();
	public Double getVariance();
	public Double getStdDeviation();
}
