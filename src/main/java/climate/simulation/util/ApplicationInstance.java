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
package climate.simulation.util;

import java.util.Properties;
/**
 * 
 * This is singleton Class it will be used to set Default values from reading application.properties file 
 * All engine and calculation class will be using this class to get the default value 
 * 
 * @author  shailesh
 * @see    climate.simulation.core.impl.WhetherConditionPredectionEarth



 */
public class ApplicationInstance 
{
	private static Properties properties = null;
			
	public static double maxLatitudeLimit;
	
	private static double minLatitudeLimit;
	private static double maxLongitudeLimit;
	private static double minLongitudeLimit;
	private static double lowPressueStartRange;
	private static double highAltitudeStartRange;
	private static double lowTempretureStartRange;
	
	private static double highHumidityRangeForRain;
	private static double randomHumidityStartRange;
	private static double randomHumidityEndRange;
	private static double randomAltitudeStartRange;
	private static double randomALtitudeEndRange;
	private static double randomLatitudePlusMinusRange;
	private static double randomLongitudePlusMinusRange;
	private static double randomDateTimeWithinRange;
	
	private static ApplicationInstance instance = null;
	
	private ApplicationInstance()
	{
		
	}
	
	public static ApplicationInstance getInstance() throws Exception
	{
		initializeApplication();
		return instance;
	}
	/**  
	 * This method is used to initialize application data from reading values from application.properties file
	 *  
	 
	 *@throws   Exception
	 *			when not able to read application.properties file
	
	 */
	private static void initializeApplication() throws Exception 
	{
		 if(instance == null)
		 {
	        instance = new ApplicationInstance();
         	
			properties = new Properties();
			properties.load(ApplicationInstance.class.getResourceAsStream("/application.properties"));
			
			maxLatitudeLimit=Double.valueOf(properties.getProperty("MAX_LATITUDE_LIMIT"));
			minLatitudeLimit=Double.valueOf(properties.getProperty("MIN_LATITUDE_LIMIT"));
			maxLongitudeLimit=Double.valueOf(properties.getProperty("MAX_LONGITUDE_LIMIT"));
			minLongitudeLimit=Double.valueOf(properties.getProperty("MIN_LONGITUDE_LIMIT"));
			lowPressueStartRange=Double.valueOf(properties.getProperty("LOW_PRESSURE_START_RANGE"));
			highAltitudeStartRange=Double.valueOf(properties.getProperty("HIGH_ALTITUDE_START_RANGE"));
			lowTempretureStartRange=Double.valueOf(properties.getProperty("LOW_TEMPRETURE_START_RANGE"));
			highHumidityRangeForRain=Double.valueOf(properties.getProperty("HIGH_HUMIDITY_RANGE_FOR_RAIN"));
			
			
			 randomHumidityStartRange=Double.valueOf(properties.getProperty("RANDOM_HUMIDITY_START_RANGE"));;
			 randomHumidityEndRange=Double.valueOf(properties.getProperty("RANDOM_HUMIDITY_END_RANGE"));;
			 randomAltitudeStartRange=Double.valueOf(properties.getProperty("RANDOM_ALTITUDE_START_RANGE"));;
			 randomALtitudeEndRange=Double.valueOf(properties.getProperty("RANDOM_ALTITUDE_END_RANGE"));;
			 randomLatitudePlusMinusRange=Double.valueOf(properties.getProperty("RANDOM_LATITUDE_PLUS_MINUS_RANGE"));;
			 randomLongitudePlusMinusRange=Double.valueOf(properties.getProperty("RANDOM_LONGITUDE_PLUS_MINUS_RANGE"));;
			 randomDateTimeWithinRange=Double.valueOf(properties.getProperty("RANDOM_DATE_TIME_YEAR_WITHIN_RANGE"));;
		
		 }
	}
	public static double getRandomDateTimeWithinRange() {
		return randomDateTimeWithinRange;
	}

	public static double getRandomHumidityStartRange() {
		return randomHumidityStartRange;
	}

	public static double getRandomHumidityEndRange() {
		return randomHumidityEndRange;
	}

	public static double getRandomAltitudeStartRange() {
		return randomAltitudeStartRange;
	}

	public static double getRandomALtitudeEndRange() {
		return randomALtitudeEndRange;
	}

	public static double getRandomLatitudePlusMinusRange() {
		return randomLatitudePlusMinusRange;
	}

	public static double getRandomLongitudePlusMinusRange() {
		return randomLongitudePlusMinusRange;
	}


	public static double getHighHumidityRangeForRain() {
		return highHumidityRangeForRain;
	}
	
	public static double getMaxLatitudeLimit() {
		return maxLatitudeLimit;
	}

	public static double getMinLatitudeLimit() {
		return minLatitudeLimit;
	}

	public static double getMaxLongitudeLimit() {
		return maxLongitudeLimit;
	}

	public static double getMinLongitudeLimit() {
		return minLongitudeLimit;
	}

	public static double getLowPressueStartRange() {
		return lowPressueStartRange;
	}

	public static double getHighAltitudeStartRange() {
		return highAltitudeStartRange;
	}

	public static double getLowTempretureStartRange() {
		return lowTempretureStartRange;
	}

	
	/*
	public static void main(String[] args) throws Exception 
	{
		getInstance();
		System.out.println("ApplicationInstance.getMaxLatitudeLimit()"+ApplicationInstance.getMaxLatitudeLimit());
		System.out.println("ApplicationInstance.getMinLatitudeLimit()"+ApplicationInstance.getMinLatitudeLimit());
		System.out.println("ApplicationInstance.getMaxLongitudeLimit()"+ApplicationInstance.getMaxLongitudeLimit());
		System.out.println("ApplicationInstance.getMinLongitudeLimit()"+ApplicationInstance.getMinLongitudeLimit());
		System.out.println("ApplicationInstance.getLowPressueStartRange()"+ApplicationInstance.getLowPressueStartRange());
		System.out.println("ApplicationInstance.getLowTempretureStartRange()"+ApplicationInstance.getLowTempretureStartRange());
		System.out.println("ApplicationInstance.getHighHumidityRangeForRain()"+ApplicationInstance.getHighHumidityRangeForRain());
		
		System.out.println("ApplicationInstance.getRandomAltitudeStartRange()"+ApplicationInstance.getRandomAltitudeStartRange());
		System.out.println("ApplicationInstance.getRandomALtitudeEndRange()"+ApplicationInstance.getRandomALtitudeEndRange());
		System.out.println("ApplicationInstance.getRandomHumidityStartRange()"+ApplicationInstance.getRandomHumidityStartRange());
		System.out.println("ApplicationInstance.getRandomHumidityEndRange()"+ApplicationInstance.getRandomHumidityEndRange());
		System.out.println("ApplicationInstance.getRandomLatitudePlusMinusRange()"+ApplicationInstance.getRandomLatitudePlusMinusRange());
		System.out.println("ApplicationInstance.getRandomLongitudePlusMinusRange()"+ApplicationInstance.getRandomLongitudePlusMinusRange());
		System.out.println("ApplicationInstance.getrandomDateTimeWithinRange()"+ApplicationInstance.getRandomDateTimeWithinRange());
	
		
		
	}*/
}

