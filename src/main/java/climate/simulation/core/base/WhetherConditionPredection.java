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

import climate.simulation.bean.WheatherCondition;

/**
 * The interface declared methods for finding weather condition like RAIN,SNOW
 * AND SUNNY The Condition can be derived from relationship between pressure
 * temperature ,humidity and altitude
 * 
 * The nature of derivation can be changed on different planets Like This
 * methods can be defined in there implementation classes to construct weather
 * Condition (Earth,jupiter,saturn etc.)
 * 
 * @author shailesh
 * @see climate.simulation.bean.WheatherCondition
 */

public interface WhetherConditionPredection {
    public WheatherCondition calculateWhetherCondition(double pressure,double tempreture,
	    double humidity, double altitude) throws Exception;

}
