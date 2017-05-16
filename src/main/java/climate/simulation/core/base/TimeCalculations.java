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

import java.util.Date;

/**
 * calculation Related to time. This methods can be defined in there
 * implementation classes to construct time attribute for all planets
 * (Earth,jupiter,saturn etc.)
 * 
 * @author shailesh
 * @see climate.simulation.core.impl.LocationCalculationEarth
 */

public interface TimeCalculations {
    /**
     * To get Date within range of years from current date time
     * 
     * @param uptoYearsRange
     *            year subrange by defualt 3
     * 
     * @return Date
     */
    public Date generateDateTime(Integer uptoYearsRange);
}
