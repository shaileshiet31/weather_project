package climate.simulation.core.base;





import java.util.Date;

/**
 * The interface declared methods for finding temperature and intensity of temperature by there months and hours 
 * since in earth we have 365 days 12 months and 24 hours which will be used to calculate temperature intensity by season and time on earth
 * but this can be changed on different planets  
 * This methods can be defined in there implementation classes to construct temperature & its intensity by factor of season and hours
 * which can be changed on other planets  
 * (Earth,jupiter,saturn etc.)    
 * @author  shailesh
 * @see    climate.simulation.core.impl.TempretureCalculationEarth

 */
public interface TempretureCalculation 
{
	/**
     * It will calculate temperature on basis of latitude and altitude the derivations can be changed on planets
     * since temperature is inversely proportional to altitude
     * and temperature is inversely proportional to |latitude|
   
     * @param  lattitude
     * @param  altitude
     * @return  tempreture
     */
	public double getAverageTempretureByLattitudeAndAltitude(double lattitude,double altitude) throws Exception;
	/**
     * It will calculate temperature intensity on basis of season.different seasons can have there own temperature intensity factor. the season definition  can be changed on planets
     * @param  lattitude
     * @param  altitude
     * @param  atDateTime
     * @return  tempretureIntensity
     */
	public double calculateTempretureIntensityFactorByMonth(double lattitude, double altitude,Date atDateTime);
	/**
     * It will calculate temperature intensity on basis of day and night hours .different hours can have there own temperature intensity factor. the hours definition  can be changed on planets
     * @param  lattitude
     * @param  altitude
     * @param  atDateTime
     * @return  tempretureIntensity
     */
	public double calculateTempretureIntensityFactorByCurrentHours(Date atDateTime);

}
