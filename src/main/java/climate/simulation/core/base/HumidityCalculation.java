package climate.simulation.core.base;
/**
 * The interface declared methods for finding  humidity.
 *.
 * This methods can be defined in there implementation classes to construct  humidity attribute for all planets 
 * (Earth,jupiter,saturn etc.)    
 *
 * @author  shailesh
 * @see    climate.simulation.core.impl.PressureCalculationEarth

 */
public interface HumidityCalculation {
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
