package climate.simulation.test;



import java.util.Date;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import climate.simulation.core.base.LocationsCalculation;
import climate.simulation.core.impl.LocationCalculationEarth;
/**
 * Unit Test Case Written for climate.simulation.core.impl.LocationCalculationEarth 
 *
 * @author  shailesh
 * @see    climate.simulation.core.impl.LocationCalculationEarth

 */
public class LocationCalculationTest extends TestCase {
	
	

	
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
	public void testGenerateAltitude() {
		LocationsCalculation locationCalculation=new	LocationCalculationEarth();
		assertNotNull(locationCalculation.generateAltitude(2.0, 2200.0));
		assertNotNull(locationCalculation.generateAltitude(-200.0, -100.0));
		
	}
	@Test
	public void testGenerateLatitude() {
		LocationsCalculation locationCalculation=new	LocationCalculationEarth();
		assertNotNull(locationCalculation.generateLatitude(2.0, 12.0));
		assertNotNull(locationCalculation.generateLatitude(-70.0, 15.0));
		assertNotNull(locationCalculation.generateLatitude(-35.0, 10.0));
		
	}
	@Test
	public void testGenerateLongitude() {
		LocationsCalculation locationCalculation=new	LocationCalculationEarth();
		assertNotNull(locationCalculation.generateLongitude(8.0, 12.0));
		assertNotNull(locationCalculation.generateLongitude(90.0, 15.0));
		assertNotNull(locationCalculation.generateLongitude(-150.0, 10.0));
	}
	@Test
	public void testGenerateDateTime() 
	{
		LocationsCalculation locationCalculation=new	LocationCalculationEarth();
		assertTrue(new Date(System.currentTimeMillis()).after(locationCalculation.generateDateTime(1)));
		assertTrue(new Date(System.currentTimeMillis()).after(locationCalculation.generateDateTime(10)));
		assertTrue(new Date(System.currentTimeMillis()).after(locationCalculation.generateDateTime(3)));
	}

}
