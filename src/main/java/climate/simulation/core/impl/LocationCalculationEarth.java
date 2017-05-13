package climate.simulation.core.impl;

/**
 * 
 */


import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import climate.simulation.core.base.LocationsCalculation;
import climate.simulation.util.ApplicationInstance;

/**
 * The class is used to define methods for finding location attributes Latitude,Altitude,Longitude and datetime on earth.
 *
 * @author  shailesh
 * @see    climate.simulation.core.base.LocationsCalculation

 */
public class LocationCalculationEarth implements LocationsCalculation
{

	/**  
	 * to  generate random altitude of startRange to endRange meters
	 *  by default startRange=20, endRange=200 meters 
	 * @param  startRange
     *         if null then taken from properties file
     *
     * @param  endRange
     *        if null then read from application.properties file
     *
     * 
	 * @return altitude
	 * 			random Altitude in decimal value
	 */
	public  double generateAltitude(Double startRange,Double endRange) 
	{
		if(startRange==null) 
		{
			startRange=ApplicationInstance.getRandomAltitudeStartRange();
		}
		if(endRange==null) 
		{
			endRange=ApplicationInstance.getRandomALtitudeEndRange();
		}
		double altitude = ThreadLocalRandom.current().nextDouble(startRange, endRange);
		
		return altitude;
	}

	/**  
	 * to  generate random latitude 
	 * 
	 * @param  latitude
     *         taken as input from console ui
     *
     * @param  plusMinusRange
     *       subrange incremental and decremental values used to calculate random latitude range
     *       if null then read from application.properties file
     * 
	 * @return latitude
	 * 			random latitude in decimal value
	 */
	public  double generateLatitude(double latitude,Double plusMinusRange )
	{
		if(plusMinusRange==null) 
		{
			plusMinusRange=ApplicationInstance.getRandomLatitudePlusMinusRange();
		}
		return ThreadLocalRandom.current().nextDouble(latitude-plusMinusRange, latitude+plusMinusRange);
	
	}
	
	
	
	
	
	/**  
	 * to  generate random longitude 
	 * 
	 * @param  longitude
     *         taken as input from console ui
     *
     * @param  plusMinusRange
     *       subrange incremental and decremental values used to calculate random longitude range
     *       if null then read from application.properties file
     * 
	 * @return longitude
	 * 			random longitude in decimal value
	 */
	
	
	public double generateLongitude(double longitude,Double plusMinusRange) {
		
		if(plusMinusRange==null) 
		{
			plusMinusRange=ApplicationInstance.getRandomLongitudePlusMinusRange();
		}
		return ThreadLocalRandom.current().nextDouble(longitude-plusMinusRange, longitude+plusMinusRange);
	}

	

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
