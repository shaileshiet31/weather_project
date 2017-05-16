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

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import climate.simulation.core.base.TimeCalculations;
import climate.simulation.util.ApplicationInstance;

/**
 * The class is used to define methods for finding location Date time attributes
 * on earth on earth.
 * 
 * @author shailesh
 * @see climate.simulation.core.base.TimeCalculations
 */

public class TimeCalculationEarth implements TimeCalculations {

    /**
     * This method is used to generate dates in range of uptoYearsRange years
     * from current date by default uptoYearsRange=3 years Calculation of Date
     * time is present in this class because like altitude,latitude and
     * longitude this can be also taken as dimension.
     * 
     * @param uptoYearsRange
     *            if null then default value be 3
     * @return Date
     */
    public Date generateDateTime(Integer uptoYearsRange) {
	if (uptoYearsRange == null) {
	    uptoYearsRange = new Double(ApplicationInstance.getRandomDateTimeWithinRange()).intValue();
	}
	Calendar lowerRangeDate = Calendar.getInstance();
	lowerRangeDate.setTimeInMillis(System.currentTimeMillis());
	lowerRangeDate.add(Calendar.YEAR, -uptoYearsRange);
	Calendar upperRangeDate = Calendar.getInstance();
	upperRangeDate.setTimeInMillis(System.currentTimeMillis());

	Date randomDate = new Date(ThreadLocalRandom.current().nextLong(lowerRangeDate.getTimeInMillis(),
	        upperRangeDate.getTimeInMillis()));
	return randomDate;
    }

}
