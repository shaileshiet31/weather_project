package climate.simulation.core.impl;


import java.util.concurrent.ThreadLocalRandom;

import climate.simulation.core.base.HumidityCalculation;
import climate.simulation.core.base.PresureCalculation;
import climate.simulation.util.ApplicationInstance;

/**
 * The class is used to define methods for finding pressure  attributes on earth.
 *
 * @author  shailesh
 * @see    climate.simulation.core.base.PresureCalculation
 *  

 */
public class PressureCalculationEarth implements PresureCalculation
{
	/**  
	 * This method is used to calculate pressure at a given  altitude and temperature
	 *  formula for calculation is 
	 *  P=P0e^((-mu*g*h)\RT)
		where
		p0- pressure at see level -101325
		mu - Molar mass of Earth's air, 0.0289644 kg/mol
		g - Gravitational acceleration, 9.80665 m/(s*s)
		h - Height difference, meters
		R - Universal gas constant for air, 8.31432
		T - Air temperature*
	 * @param altitude
	 * 			
	 * @param tempreture 
	 *  
	 *
	 * @return pressure 
	 *        at given altitude and latitude
	 */
	
	public double calculatePressureAtAltitude(double altitude ,double tempreture)
	{
		
		double pressure=	(101325*(Math.exp((-0.0289644*9.80665*altitude)/(8.31432*(tempreture+273.15))))/100);
		
		//System.out.println(pressure);
		return pressure;
	}
	
}
