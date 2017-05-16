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
package climate.simulation.core.impl;

import java.util.concurrent.ThreadLocalRandom;

import climate.simulation.core.base.HumidityCalculation;
import climate.simulation.util.ApplicationInstance;


/**
 * The class is used to define methods for finding humidity attributes on earth.
 * 
 * @author shailesh
 * @see climate.simulation.core.base.HumidityCalculation
 */

public class HumidityCalculationEarth implements HumidityCalculation {

    /**
     * to generate humidity ranging between humidity start range to humidity end
     * range by Reading aplication.properties file humidity is generated as
     * random because relative humidity is calculate by formula rh=p0/P1 where
     * p0 is pressure of atmosphere where as p1 is dew point pressure which is
     * more calculated by scientific measures (eg wet bulb measure test)
     * 
     * @param altitude
     * @param latitude
     * @param longitude
     * @param tempreture
     * @return relativeHumidity
     */

    public double generateRandomRelativeHumidity(double altitude, double latitude, double longitude, double tempreture) {
	double relativeHumidity = ThreadLocalRandom.current().nextDouble(ApplicationInstance.getRandomHumidityStartRange(),
	        ApplicationInstance.getRandomHumidityEndRange());

	return relativeHumidity;
    }

}
