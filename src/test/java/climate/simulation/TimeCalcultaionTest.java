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
