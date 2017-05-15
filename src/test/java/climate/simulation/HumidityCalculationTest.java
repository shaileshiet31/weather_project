package climate.simulation;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import climate.simulation.bean.PlacesClimateBean;
import climate.simulation.core.base.HumidityCalculation;
import climate.simulation.core.base.PresureCalculation;
import climate.simulation.core.impl.HumidityCalculationEarth;
import climate.simulation.core.impl.PressureCalculationEarth;
import climate.simulation.util.ApplicationInstance;
/**
 * Unit Test Case Written for climate.simulation.core.impl.HumidityCalculationEarth 
 *
 * @author  shailesh
 * @see    cclimate.simulation.core.impl.HumidityCalculationEarth 

 */
public class HumidityCalculationTest extends TestCase
{

	private List<PlacesClimateBean>         placesClimateBeanList;
	ApplicationInstance instance=null;
	@Before
	public void setUp() throws Exception 
	{
		 instance=ApplicationInstance.getInstance();
        placesClimateBeanList=new ArrayList<PlacesClimateBean>();
		
     
		
		PlacesClimateBean  placesClimateBean=new PlacesClimateBean();
		placesClimateBean.setLattitude(-39.00);
		placesClimateBean.setLongitude(160);
		placesClimateBean.setAltitude(57.15);
		placesClimateBean.setTempreture(14.33);
		placesClimateBean.setPressure(1006.3);
		placesClimateBean.setHumidity(64.61);
		
				
		placesClimateBeanList.add(placesClimateBean);
		
		PlacesClimateBean  placesClimateBean1=new PlacesClimateBean();
		placesClimateBean1.setLattitude(-31.29);
		placesClimateBean1.setAltitude(154.31);
		placesClimateBean1.setLongitude(130);
		placesClimateBean1.setTempreture(18.10);
		placesClimateBean1.setPressure(995.07);
		placesClimateBean1.setHumidity(56.66);
		
		placesClimateBeanList.add(placesClimateBean1);
		
		PlacesClimateBean  placesClimateBean2=new PlacesClimateBean();
		placesClimateBean2.setLattitude(-42.34);
		placesClimateBean2.setAltitude(45.33);
		placesClimateBean2.setTempreture(12.56);
		placesClimateBean.setLongitude(-30);
		placesClimateBean2.setPressure(1007.77);
		placesClimateBean2.setHumidity(67.17);
		placesClimateBeanList.add(placesClimateBean2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		instance=null;
	}
	@Test
	public void testGenerateRandomRelativeHumidity() {
		
		HumidityCalculation humidityCalculation=new HumidityCalculationEarth();
		
		for(PlacesClimateBean placesClimateBean:placesClimateBeanList)
		{
			
			assertNotNull(new Double(humidityCalculation.generateRandomRelativeHumidity(placesClimateBean.getAltitude(),placesClimateBean.getLattitude(),placesClimateBean.getLongitude(), placesClimateBean.getTempreture())).intValue());
			
		}
		
		
	}

}
