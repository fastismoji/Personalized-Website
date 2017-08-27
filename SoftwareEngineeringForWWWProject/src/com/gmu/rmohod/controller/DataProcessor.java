package com.gmu.rmohod.controller;

import com.gmu.rmohod.bean.DataBean;

/**
 * Model class to process data and compute mean and standard deviation
 * 
 * @author Rasika
 *
 */
public class DataProcessor {

	/**
	 * Method to compute mean and standard deviation
	 * 
	 * @param data
	 * @return DataBean object
	 */
	public DataBean computeMeanDeviation(int[] data)
	{
		
		DataBean dataBeanObject = new DataBean();
		
		int sum = 0;
		for(int i=0;i<data.length;i++)
		{
			sum = sum + data[i];
		}
		
		double mean = sum/data.length;
		
		double standardDeviation = 0;
		
		for (int i = 0; i < data.length; i++)
		{
			standardDeviation += ((data[i] - mean)*(data[i] - mean)) / data.length;
		}
		standardDeviation = Math.sqrt(standardDeviation);
		
		dataBeanObject.setMean(mean);
		dataBeanObject.setStandardDeviation(standardDeviation);
		
		return dataBeanObject;
		
	}
}
