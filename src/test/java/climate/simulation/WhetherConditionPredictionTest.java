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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import climate.simulation.bean.PlacesClimateBean;
import climate.simulation.bean.WheatherCondition;
import climate.simulation.core.base.WhetherConditionPredection;
import climate.simulation.core.impl.WhetherConditionPredectionEarth;
import climate.simulation.util.ApplicationInstance;

/**
 * Unit Test Cases Written for
 * climate.simulation.core.impl.WhetherConditionPredectionEarth
 * 
 * @author shailesh
 * @see climate.simulation.core.impl.WhetherConditionPredectionEarth
 */
public class WhetherConditionPredictionTest extends TestCase {

    private List<PlacesClimateBean> placesClimateBeanList;

    ApplicationInstance instance = null;

    @Before
    public void setUp() throws Exception {
	instance = ApplicationInstance.getInstance();
	placesClimateBeanList = new ArrayList<PlacesClimateBean>();
	PlacesClimateBean placesClimateBean = new PlacesClimateBean();
	placesClimateBean.setLattitude(70);
	placesClimateBean.setAltitude(993);
	placesClimateBean.setTempreture(-20);
	placesClimateBean.setHumidity(65);
	placesClimateBean.setCondition(WheatherCondition.SNOW);
	placesClimateBeanList.add(placesClimateBean);
	PlacesClimateBean placesClimateBean1 = new PlacesClimateBean();
	placesClimateBean1.setLattitude(45);
	placesClimateBean1.setAltitude(30);
	placesClimateBean1.setTempreture(35);
	placesClimateBean1.setHumidity(87);
	placesClimateBean1.setCondition(WheatherCondition.RAIN);
	placesClimateBeanList.add(placesClimateBean1);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	placesClimateBeanList = null;
	instance = null;
    }

    @Test
    public void testCalculateWhetherCondition() throws Exception {
	WhetherConditionPredection wheatherConditionPrediction = new WhetherConditionPredectionEarth();
	for (PlacesClimateBean placesClimateBean : placesClimateBeanList) {
	    assertEquals(placesClimateBean.getCondition(), wheatherConditionPrediction.calculateWhetherCondition(
		            placesClimateBean.getPressure(), placesClimateBean.getTempreture(), placesClimateBean.getHumidity(),
		            placesClimateBean.getAltitude()));
	  
	}

    }

}
