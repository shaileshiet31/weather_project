package climate.simulation;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import climate.simulation.core.base.TimeCalculations;
import climate.simulation.core.impl.TimeCalculationEarth;
import junit.framework.TestCase;
/**
 * Unit Test Case Written for climate.simulation.core.impl.TimeCalculationEarth 
 *
 * @author  shailesh
 * @see    climate.simulation.core.impl.TimeCalculationEarth 

 */
public class TimeCalcultaionTest extends TestCase {
	
	@Before
	public void setUp() throws Exception 
	{
	
		
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testGenerateDateTime() 
	{
		TimeCalculations timeCalculation=new	TimeCalculationEarth();
		assertTrue(new Date(System.currentTimeMillis()).after(timeCalculation.generateDateTime(1)));
		assertTrue(new Date(System.currentTimeMillis()).after(timeCalculation.generateDateTime(10)));
		assertTrue(new Date(System.currentTimeMillis()).after(timeCalculation.generateDateTime(3)));
	}

}
