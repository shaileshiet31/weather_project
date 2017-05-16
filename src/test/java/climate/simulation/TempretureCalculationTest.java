/*
Copyright 2017 TCS All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
*
*Licensed under the Apache License, Version 2.0 (the "License");
*you may not use this file except in compliance with the License.
*You may obtain a copy of the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
*Unless required by applicable law or agreed to in writing, software
*distributed under the License is distributed on an "AS IS" BASIS,
*WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*See the License for the specific language governing permissions and
*limitations under the License.
 */
package climate.simulation;



import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import climate.simulation.bean.PlacesClimateBean;
import climate.simulation.core.base.TempretureCalculation;
import climate.simulation.core.impl.TempretureCalculationEarth;
/**
 * Unit Test Case Written for climate.simulation.core.impl.TempretureCalculationEarth 
 *
 * @author  shailesh
 * @see    climate.simulation.core.impl.TempretureCalculationEarth

 */
	
public class TempretureCalculationTest extends TestCase {

	List<PlacesClimateBean>placesClimateBeanList=null;
	@Before
	public void setUp() throws Exception 
	{
		placesClimateBeanList=new ArrayList<PlacesClimateBean>();
		
		DateTimeFormatter df=DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z");
		
		PlacesClimateBean  placesClimateBean=new PlacesClimateBean();
		placesClimateBean.setLattitude(-39.00);
		placesClimateBean.setAltitude(57.15);
		placesClimateBean.setTempreture(14.33);
		
		placesClimateBean.setLocalTime(df.parseDateTime("2016-07-06T02:31:52Z").toDate());
		placesClimateBean.setIntensityByMonth(-12);
		placesClimateBean.setIntensityByHour(51);
				
		placesClimateBeanList.add(placesClimateBean);
		
		PlacesClimateBean  placesClimateBean1=new PlacesClimateBean();
		placesClimateBean1.setLattitude(-31.29);
		placesClimateBean1.setAltitude(154.31);
		placesClimateBean1.setTempreture(18.10);
		placesClimateBean1.setLocalTime(df.parseDateTime("2015-03-06T22:17:31Z").toDate());
		placesClimateBean1.setIntensityByMonth(8);
		placesClimateBean1.setIntensityByHour(53);
		placesClimateBeanList.add(placesClimateBean1);
		
		PlacesClimateBean  placesClimateBean2=new PlacesClimateBean();
		placesClimateBean2.setLattitude(-42.34);
		placesClimateBean2.setAltitude(45.33);
		placesClimateBean2.setTempreture(12.56);
		placesClimateBean2.setLocalTime(df.parseDateTime("2015-05-14T06:56:17Z").toDate());
		placesClimateBean2.setIntensityByMonth(-5);
		placesClimateBean2.setIntensityByHour(52);
		placesClimateBeanList.add(placesClimateBean2);
		
		
	
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		placesClimateBeanList=null;
		
	}
	
	@Test
	public void testAverageTempretureByLattitudeAndAltitude() throws Exception {
		
		TempretureCalculation tempretureCalculation=new TempretureCalculationEarth();
		for(PlacesClimateBean placesClimateBean:placesClimateBeanList)
		{
			double acutalTempreture=tempretureCalculation.getAverageTempretureByLattitudeAndAltitude(placesClimateBean.getLattitude(), placesClimateBean.getAltitude());
			assertEquals(new Double(placesClimateBean.getTempreture()).intValue(), new Double(acutalTempreture).intValue());
			
		}
	}
	
	
	
	@Test
	public void testCalculateTempretureIntensityFactorByMonth() 
	{
		TempretureCalculation tempretureCalculation=new TempretureCalculationEarth();
		for(PlacesClimateBean placesClimateBean:placesClimateBeanList)
		{
			double intensityByMonth=tempretureCalculation.calculateTempretureIntensityFactorByMonth(placesClimateBean.getLattitude(), placesClimateBean.getAltitude(),placesClimateBean.getLocalTime());
			
			assertEquals(new Double(placesClimateBean.getIntensityByMonth()).intValue(), new Double(intensityByMonth).intValue());
			
		}
	}
	@Test
	public void testCalculateTempretureIntensityFactorByCurrentHours()
	{
		TempretureCalculation tempretureCalculation=new TempretureCalculationEarth();
		
		for(PlacesClimateBean placesClimateBean:placesClimateBeanList)
		{
			double intensityByHour=tempretureCalculation.calculateTempretureIntensityFactorByCurrentHours(placesClimateBean.getLocalTime());
			
			assertEquals(new Double(placesClimateBean.getIntensityByHour()).intValue(), new Double(intensityByHour).intValue());
			
		}
	}

}
