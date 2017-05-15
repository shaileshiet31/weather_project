package climate.simulation.core.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import climate.simulation.core.base.TimeCalculations;
import climate.simulation.util.ApplicationInstance;
/**
 * The class is used to define methods for finding location Date time attributes on earth on earth.
 *
 * @author  shailesh
 * @see    climate.simulation.core.base.TimeCalculations

 */
public class TimeCalculationEarth implements TimeCalculations {

	/**  
	 *This method is used to generate dates in range of uptoYearsRange years from current date  
	 *  by default uptoYearsRange=3 years
	 *  Calculation of Date time is present in this class because like altitude,latitude and longitude this can be
	 *   also taken as dimension.
	 * 
	 * @param  uptoYearsRange
     *       if null   then default value be 3
     *
    * @return Date
	 */
	
	public  Date generateDateTime(Integer uptoYearsRange)
	{
		if(uptoYearsRange==null) 
		{
			uptoYearsRange=new Double (ApplicationInstance.getRandomDateTimeWithinRange()).intValue();
		}
		Calendar lowerRangeDate=Calendar.getInstance();
		lowerRangeDate.setTimeInMillis(System.currentTimeMillis());
		lowerRangeDate.add(Calendar.YEAR, -uptoYearsRange);
		
		Calendar upperRangeDate=Calendar.getInstance();
		upperRangeDate.setTimeInMillis(System.currentTimeMillis());
		
		
		Date randomDate = new Date(ThreadLocalRandom.current().nextLong(
				lowerRangeDate.getTimeInMillis(), upperRangeDate.getTimeInMillis()));
		
		return randomDate;

	}

}
