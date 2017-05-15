package climate.simulation.core.base;





/**
 * The interface declared methods for finding location attributes Latitude,Altitude,Longitude and datetime.
 * date time is declared here since its also represent one of the dimension.
 * This methods can be defined in there implementation classes to construct location attribute for all planets 
 * (Earth,jupiter,saturn etc.)    
 *
 * @author  shailesh
 * @see    climate.simulation.core.impl.LocationCalculationEarth

 */

public interface LocationsCalculation 
{
	
	
	/**
     * To get  altitude on behalf of ranges supplied 
   
     * @param  startRange
     *         start range of altitude point
     *
     * @param  endRange
     *         end range of altitude point

     * @return  altitude
     */
	public  double generateAltitude(Double startRange,Double endRange);
	/**
     * To get latitude on behalf of plus minus subranges supplied 
   
     * @param  latitude
     *         supplied by user as input
     *
     * @param  plusMinusRange
     *          subrange of supplied latitudes

     * @return  latitude
     */
	public  double generateLatitude(double latitude,Double plusMinusRange);
	
	/**
     * To get longitude on behalf of plus minus subranges supplied 
   
     * @param  longitude
     *         supplied by user as input
     *
     * @param  plusMinusRange
     *          subrange of supplied longitude 

     * @return  longitude
     */
	public  double generateLongitude(double longitude,Double plusMinusRange);
	
}
