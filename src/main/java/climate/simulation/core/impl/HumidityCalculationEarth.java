package climate.simulation.core.impl;

import java.util.concurrent.ThreadLocalRandom;

import climate.simulation.core.base.HumidityCalculation;
import climate.simulation.util.ApplicationInstance;
/**
 * The class is used to define methods for finding humidity attributes on earth.
 *
 * @author  shailesh
 * 
 *  @see    climate.simulation.core.base.HumidityCalculation

 */
public class HumidityCalculationEarth implements HumidityCalculation {

	/**  
	 *  to  generate humidity ranging between  humidity start range to humidity end range by Reading aplication.properties file 
	 *    humidity is generated as random because relative humidity is calculate by formula rh=p0/P1
	 *  where p0 is pressure of atmosphere where as p1 is dew point pressure which is more calculated 
	 *  by scientific measures (eg wet bulb measure test) 
	 * 
	 *  @param altitude
	 *  @param latitude
	 *  @param longitude
	 *  @param tempreture
	 *
	 * @return relativeHumidity
	 */
	
	public  double generateRandomRelativeHumidity(double altitude ,double latitude ,double longitude,double tempreture)
	{
		double relativeHumidity = ThreadLocalRandom.current().nextDouble(ApplicationInstance.getRandomHumidityStartRange(), ApplicationInstance.getRandomHumidityEndRange());
	
		return relativeHumidity;
	}

}
