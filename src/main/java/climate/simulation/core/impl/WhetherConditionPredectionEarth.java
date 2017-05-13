package climate.simulation.core.impl;



import climate.simulation.bean.WheatherCondition;
import climate.simulation.core.base.WhetherConditionPredection;
import climate.simulation.util.ApplicationInstance;

/**
 * 
 * The class is used to define methods methods for finding for finding weather condition like RAIN,SNOW AND SUNNY
 * The Condition can be derived from relationship between pressure temperature ,humidity and altitude
 * @author  shailesh
 * @see    climate.simulation.core.impl.WhetherConditionPredectionEarth
 * @see    climate.simulation.bean.WheatherCondition


 */
public class WhetherConditionPredectionEarth implements WhetherConditionPredection 
{
	/**  
	 * This method is used to calculate whether condition as sunny,rain  and snow on behalf pressure, temperature,humidity,alititude
	 *  snow->it is assumed that altitudes with higher values , less pressure and less temperature can cause of snow
	 * rain->with high humidity,moderate range of altitudes and mild temperature
	 * sunny-->else all conditions
	 * @param pressure
	 * @param tempreture 
	 * @param humidity 
	 * @param altitude 
	 *  
	 *
	 * @return WheatherCondition
	 * 			in terms of SNOW,RAIN,SUNNY
	 */
	
	public WheatherCondition calculateWhetherCondition(double pressure,double tempreture, double humidity,double altitude) 
	{
				
		if(pressure<ApplicationInstance.getLowPressueStartRange() && altitude>ApplicationInstance.getHighAltitudeStartRange() && tempreture<ApplicationInstance.getLowTempretureStartRange()   )
		{
			if((humidity>=50 && humidity<=75))
			{
				return WheatherCondition.SNOW ;
			}
			else if( humidity>ApplicationInstance.getHighHumidityRangeForRain())
			{
				return WheatherCondition.RAIN;
			}
			else {
				return WheatherCondition.SUNNY;
			}
		}
		else if(humidity>=85)
		{
			return WheatherCondition.RAIN;
		}
		else
		{
			return WheatherCondition.SUNNY;
		}
		
	}
	
}
