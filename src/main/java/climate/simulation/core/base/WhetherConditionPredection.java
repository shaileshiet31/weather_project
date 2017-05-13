package climate.simulation.core.base;



import java.io.IOException;

import climate.simulation.bean.WheatherCondition;


/**
 * The interface declared methods for finding weather condition like RAIN,SNOW AND SUNNY
 * The Condition can be derived from relationship between pressure temperature ,humidity and altitude  
 * 
 * The nature of derivation  can be changed on different planets  Like 
 * This methods can be defined in there implementation classes to construct weather Condition 
 * (Earth,jupiter,saturn etc.)    
 *
 * @author  shailesh
 * @see    climate.simulation.bean.WheatherCondition

 */
public interface WhetherConditionPredection 
{
	public WheatherCondition calculateWhetherCondition(double pressure,double tempreture, double humidity,double altitude) throws IOException;
	
}
