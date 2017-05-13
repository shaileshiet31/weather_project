package climate.simulation.util;

/**
 * 
 */


import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import climate.simulation.core.base.TempretureCalculation;

/**
 * The class will contain Utility method which will be used for other classes as helper methods .
 *
 * @author  shailesh
 * 
 */
public class ClimateUtils {
	
	/**  
	 * This method is used to convert farenhiegth to celcius by formula
	 *  (F - 32) / 1.8 = C
	 * @param farenhieghtDegree
	 * @return celciusDegree
	 */
	
	 public static double convertFareignhigthToCelcius(double farenhieghtDegree)
	 {
		 return (farenhieghtDegree-32)/1.8;
	 }
	 
 /**  
	 * 
	 * this method is used to format the date into ISO8601 Format .
	 *its using joda time library
	 * 
	 * @param date 
	 *
	 * @return formatted date String
	 */
	public static String getISO8601DateFormat(Date date){
		
		
		DateTime dt = new DateTime(date);

		
		//DateTimeFormatter isoFormat = ISODateTimeFormat.dateParser();

		    
		//System.out.println(DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z"));
		
		/*TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); 
		df.setTimeZone(tz);
		String nowAsISO = df.format(date);*/
		return dt.toString(DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z"));
	}

	/**  
	 * 
	 * It is used to calculate temperature on various factor .
	 * 1)latitude & altitude 
	 * 2)By factor of latitude falling in northern and southern hemisphere also 
	 * it will be using intensity factor of temperature by months
	 * taking account of summer and winter months of norther and southern hemisphere ie.summer months (April,May,June,July,August,Sep) on the Northern Hemisphere 
	 *	and the winter months are October through March (Oct,Nov,Dec,Jan,Feb,March) and vice versa foe southern hemisphere
	 * 3)By factor of timestamp hour in noon the temperature intensity will be high in night it will less.
	 * 
	 * @param lattitude 
	 * @param altitude 
	 * @param randomDate
	 *  auto generated date
	 * @param TempretureCalculation
	 *  implementation of PlanetTempretureCalculation object
	 * @return temperature
	 */
	
	public static double calculateTempretureByFactors(double lattitude,double altitude,Date randomDate,TempretureCalculation tempretureCalculation) throws Exception
	{
		
		double tempreture=tempretureCalculation.getAverageTempretureByLattitudeAndAltitude(lattitude, altitude);
		
		tempreture=tempreture+tempretureCalculation.calculateTempretureIntensityFactorByMonth(lattitude,  altitude, randomDate);
		
		tempreture=(tempreture*	tempretureCalculation.calculateTempretureIntensityFactorByCurrentHours(randomDate))/100;
		
		return tempreture;
	}
}
