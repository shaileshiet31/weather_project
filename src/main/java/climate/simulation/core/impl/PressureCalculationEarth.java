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

import climate.simulation.core.base.PresureCalculation;

/**
 * The class is used to define methods for finding pressure attributes on earth.
 * 
 * @author shailesh
 * @see climate.simulation.core.base.PresureCalculation
 * 
 */

public class PressureCalculationEarth implements PresureCalculation {
    /**
     * This method is used to calculate pressure at a given altitude and
     * temperature formula for calculation is P=P0e^((-mu*g*h)\RT) where p0-
     * pressure at see level -101325 mu - Molar mass of Earth's air, 0.0289644
     * kg/mol g - Gravitational acceleration, 9.80665 m/(s*s) h - Height
     * difference, meters R - Universal gas constant for air, 8.31432 T - Air
     * temperature*
     * 
     * @param altitude
     * @param tempreture
     * @return pressure at given altitude and latitude
     */

    public double calculatePressureAtAltitude(double altitude, double tempreture) {
	double pressure = (101325 * (Math.exp((-0.0289644 * 9.80665 * altitude)
	        / (8.31432 * (tempreture + 273.15)))) / 100);
	return pressure;
    }

}
