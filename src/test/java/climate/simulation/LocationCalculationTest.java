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

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import climate.simulation.core.base.LocationsCalculation;
import climate.simulation.core.impl.LocationCalculationEarth;

/**
 * Unit Test Case Written for
 * climate.simulation.core.impl.LocationCalculationEarth
 * 
 * @author shailesh
 * @see climate.simulation.core.impl.LocationCalculationEarth
 */
public class LocationCalculationTest extends TestCase {

    @Before
    public void setUp() throws Exception {

    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGenerateAltitude() {
	LocationsCalculation locationCalculation = new LocationCalculationEarth();
	assertNotNull(locationCalculation.generateAltitude(2.0, 2200.0));
	assertNotNull(locationCalculation.generateAltitude(-200.0, -100.0));

    }

    @Test
    public void testGenerateLatitude() {
	LocationsCalculation locationCalculation = new LocationCalculationEarth();
	assertNotNull(locationCalculation.generateLatitude(2.0, 12.0));
	assertNotNull(locationCalculation.generateLatitude(-70.0, 15.0));
	assertNotNull(locationCalculation.generateLatitude(-35.0, 10.0));

    }

    @Test
    public void testGenerateLongitude() {
	LocationsCalculation locationCalculation = new LocationCalculationEarth();
	assertNotNull(locationCalculation.generateLongitude(8.0, 12.0));
	assertNotNull(locationCalculation.generateLongitude(90.0, 15.0));
	assertNotNull(locationCalculation.generateLongitude(-150.0, 10.0));
    }

}
