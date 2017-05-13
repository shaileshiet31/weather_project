package climate.simulation.core.base;



/**
 * The interface declared methods for finding pressure and humidity.
 *.
 * This methods can be defined in there implementation classes to construct pressure & humidity attribute for all planets 
 * (Earth,jupiter,saturn etc.)    
 *
 * @author  shailesh
 * @see    climate.simulation.core.impl.PressureCalculationEarth

 */

public interface PresureCalculation 
{
	/**
     * It will calculate pressure from altitude and temperature relationship
     * since pressure is inversely proportional to altitude
     * and pressure is directly proportional to temperature so the derivation can be calculated from planets attributes
   		This methods can be defined in there implementation classes to construct pressure attribute for all planets
     * @param  altitude
     *         
     * * @param  tempreture
     *       
   
     * @return  Pressure
     */
	public double calculatePressureAtAltitude(double altitude ,double tempreture);
	
	/**
     * It will generate relative humidity   the derivation can be calculated from planets  attributes (altitude,latitude,longitude,tempreture)
   
     * @param  altitude
     * @param  lattude
     * @param  longitude    
     * @param  tempreture
     *       
   
     * @return  humidity
     */
	public  double generateRandomRelativeHumidity(double altitude ,double latitude,double longitude,double tempreture);
	
}
