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

/**
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.TestCase;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import climate.simulation.bean.PlacesClimateBean;
import climate.simulation.core.impl.TempretureCalculationEarth;
import climate.simulation.core.impl.TimeCalculationEarth;
import climate.simulation.util.ClimateUtils;

/**
 * Unit Test Case Written for climate.simulation.util.ClimateUtils
 * 
 * @author shailesh
 * @see climate.simulation.util.ClimateUtils
 */

public class ClimateUtilsTest extends TestCase {
    List<PlacesClimateBean> placesClimateBeanList = null;
    List<Double> fareignhieghtList = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	fareignhieghtList = new ArrayList<Double>();
	fareignhieghtList.add(20.0);
	fareignhieghtList.add(78.3);
	fareignhieghtList.add(145.0);
	fareignhieghtList.add(-34.0);
	DateTimeFormatter df = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z");
	placesClimateBeanList = new ArrayList<PlacesClimateBean>();
	PlacesClimateBean placesClimateBean = new PlacesClimateBean();
	placesClimateBean.setLattitude(-39.00);
	placesClimateBean.setAltitude(57.15);
	placesClimateBean.setLocalTime(df.parseDateTime("2016-07-06T02:31:52Z").toDate());
	placesClimateBean.setTempreture(1.19);
	placesClimateBeanList.add(placesClimateBean);
	PlacesClimateBean placesClimateBean1 = new PlacesClimateBean();
	placesClimateBean1.setLattitude(-31.29);
	placesClimateBean1.setAltitude(154.31);
	placesClimateBean1.setLocalTime(df.parseDateTime("2015-03-06T22:17:31Z").toDate());
	placesClimateBean1.setTempreture(13.84);
	placesClimateBeanList.add(placesClimateBean1);
	PlacesClimateBean placesClimateBean2 = new PlacesClimateBean();
	placesClimateBean2.setLattitude(-42.34);
	placesClimateBean2.setAltitude(45.33);
	placesClimateBean2.setLocalTime(df.parseDateTime("2015-05-14T06:56:17Z").toDate());
	placesClimateBean2.setTempreture(3.93);
	placesClimateBeanList.add(placesClimateBean2);
	PlacesClimateBean placesClimateBean3 = new PlacesClimateBean();
	placesClimateBean3.setLattitude(-38.84);
	placesClimateBean3.setAltitude(187.09);
	placesClimateBean3.setLocalTime(df
	        .parseDateTime("2016-01-11T23:34:57Z").toDate());
	placesClimateBean3.setTempreture(15.27);
	placesClimateBeanList.add(placesClimateBean3);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	placesClimateBeanList = null;
	fareignhieghtList = null;
    }

    @Test
    public void testcalculateTempretureByFactors() throws Exception {
	for (PlacesClimateBean placesClimateBean : placesClimateBeanList) {
	    double acutalTempreture = ClimateUtils.calculateTempretureByFactors(placesClimateBean.getLattitude(),
		            placesClimateBean.getAltitude(), placesClimateBean.getLocalTime(), new TempretureCalculationEarth());
	    assertEquals(new Double(placesClimateBean.getTempreture()).intValue(), new Double(acutalTempreture).intValue());
	}
    }

    @Test
    public void testConvertFareignhigthToCelcius() throws Exception {
	for (Double fareignhieght : fareignhieghtList) {
	    Double celcius = ClimateUtils.convertFareignhigthToCelcius(fareignhieght);
	    assertFalse(celcius == null);
	}
    }

    @Test
    public void testISO8601DateFormat() throws Exception {
	Pattern isoPattern = Pattern.compile("yyyy-MM-dd'T'HH:mm:ss'Z");
	String stringDate = ClimateUtils.getISO8601DateFormat(new TimeCalculationEarth().generateDateTime(3));
	Matcher m = isoPattern.matcher(stringDate);
	if (stringDate.contains("Z") && stringDate.contains("T")) {
	    assertFalse(false);
	} else {
	    assertFalse(true);
	}
    }
}