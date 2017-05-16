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
package climate.simulation.core.base;

/**
 * The interface declared methods for finding location attributes
 * Latitude,Altitude,Longitude and datetime. date time is declared here since
 * its also represent one of the dimension. This methods can be defined in there
 * implementation classes to construct location attribute for all planets
 * (Earth,jupiter,saturn etc.)
 * 
 * @author shailesh
 * @see climate.simulation.core.impl.LocationCalculationEarth
 */

public interface LocationsCalculation {

    /**
     * To get altitude on behalf of ranges supplied
     * 
     * @param startRange
     *            start range of altitude point
     * 
     * @param endRange
     *            end range of altitude point
     * 
     * @return altitude
     */
    public double generateAltitude(Double startRange, Double endRange);

    /**
     * To get latitude on behalf of plus minus subranges supplied
     * 
     * @param latitude
     *            supplied by user as input
     * 
     * @param plusMinusRange
     *            subrange of supplied latitudes
     * 
     * @return latitude
     */
    public double generateLatitude(double latitude, Double plusMinusRange);

    /**
     * To get longitude on behalf of plus minus subranges supplied
     * 
     * @param longitude
     *            supplied by user as input
     * 
     * @param plusMinusRange
     *            subrange of supplied longitude
     * 
     * @return longitude
     */
    public double generateLongitude(double longitude, Double plusMinusRange);

}
