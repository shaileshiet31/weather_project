package climate.simulation.core.base;

import java.util.Date;
/**
 * calculation Related to time
 * 
 * This methods can be defined in there implementation classes to construct time attribute for all planets 
 * (Earth,jupiter,saturn etc.)    
 *
 * @author  shailesh
 * @see    climate.simulation.core.impl.LocationCalculationEarth

 */
public interface TimeCalculations {
	/**
     * To get Date within range of years from current date time 
   
     * @param  uptoYearsRange
     *         year subrange by defualt 3
   
     * @return  Date
     */
	public  Date generateDateTime(Integer uptoYearsRange);
}
