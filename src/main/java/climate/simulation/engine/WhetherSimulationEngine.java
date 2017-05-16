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
package climate.simulation.engine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;
import climate.simulation.bean.WheatherCondition;
import climate.simulation.core.base.HumidityCalculation;
import climate.simulation.core.base.LocationsCalculation;
import climate.simulation.core.base.PresureCalculation;
import climate.simulation.core.base.TempretureCalculation;
import climate.simulation.core.base.TimeCalculations;
import climate.simulation.core.base.WhetherConditionPredection;
import climate.simulation.core.impl.HumidityCalculationEarth;
import climate.simulation.core.impl.LocationCalculationEarth;
import climate.simulation.core.impl.PressureCalculationEarth;
import climate.simulation.core.impl.TempretureCalculationEarth;
import climate.simulation.core.impl.TimeCalculationEarth;
import climate.simulation.core.impl.WhetherConditionPredectionEarth;
import climate.simulation.util.ApplicationInstance;
import climate.simulation.util.ClimateUtils;

/**
 * The class main method is used to simulate weather data in file input required
 * at console-->
 *  1)no of Records
 *  2)Latitude
 *  3)longitude 
 *  4)File Path for output
 * file eg(d:\\output.txt)
 * 
 * @author shailesh
 * @see climate.simulation.core.impl.WhetherConditionPredectionEarth
 * @see climate.simulation.core.impl.PressureCalculationEarth
 * @see climate.simulation.core.impl.TempretureCalculationEarth
 * @see climate.simulation.core.impl.WhetherConditionPredectionEarth
 */

public class WhetherSimulationEngine {

    /**
     * Core Engine to generate whether simulation data
     * 
     * @param noOfReords
     *            NO of Records to generate
     * @param enteredLatitude
     *            on behalf of latitude provided ranges of +10 to -10 latitude
     *            data is generated
     * @param enteredLongitude
     *            on behalf of longitude provided ranges of +10 to -10 longitude
     *            data is generated
     * @param bw
     *            buffer writer file the file
     */
    private void executeEngineToGenerateRecords(int noOfReords,double enteredLatitude, double enteredLongitude,
	    BufferedWriter bw) throws Exception {
	
	LocationsCalculation locationsCalculation = new LocationCalculationEarth();
	TimeCalculations timeCalculations = new TimeCalculationEarth();
	TempretureCalculation tempretureCalculation = new TempretureCalculationEarth();
	PresureCalculation presureCalculation = new PressureCalculationEarth();
	HumidityCalculation humidityCalculation = new HumidityCalculationEarth();
	WhetherConditionPredection whetherConditionPredection = new WhetherConditionPredectionEarth();

	for (int i = 1; i <= noOfReords; i++) {
	    StringBuilder sb = new StringBuilder();
	    double latitude = locationsCalculation.generateLatitude(enteredLatitude, null);
	    double longitude = locationsCalculation.generateLongitude(enteredLongitude, null);
	    double altitude = locationsCalculation.generateAltitude(null, null);
	    Date randomDate = timeCalculations.generateDateTime(null);
	    double tempreture = ClimateUtils.calculateTempretureByFactors(latitude, altitude, randomDate,
		    tempretureCalculation);
	    double pressure = presureCalculation.calculatePressureAtAltitude(altitude, tempreture);
	    double humidity = humidityCalculation.generateRandomRelativeHumidity(altitude, latitude,
		            longitude, tempreture);
	    WheatherCondition condition = whetherConditionPredection.calculateWhetherCondition(pressure,
		    tempreture, humidity, altitude);
	    sb.append(String.format("%.2f", latitude));
	    sb.append(",");
	    sb.append(String.format("%.2f", longitude));
	    sb.append(",");
	    sb.append(String.format("%.2f", altitude));
	    sb.append("|");
	    sb.append(ClimateUtils.getISO8601DateFormat(randomDate));
	    sb.append("|");
	    sb.append(condition.toString());
	    sb.append("|");
	    String formattedTempreture = String.format("%.2f", tempreture);
	    sb.append(tempreture > 0 ? "+" + formattedTempreture: formattedTempreture);
	    sb.append("|");
	    sb.append(String.format("%.2f", pressure));
	    sb.append("|");
	    sb.append(String.format("%.2f", humidity));
	    System.out.println(sb);
	    sb.append("\r\n");
	    bw.write(sb.toString());
	}
    }

    /**
     * Initiator point for Data generation input required at console-->
     * 1)no of Records--> NO of Records to generate 2)Latitude-->on behalf of
     * latitude provided ranges of +10 to -10 latitude data is generated
     * 3)longitude-->on behalf of longitude provided ranges of +10 to -10
     * longitude data is generated 4)File Path for output file
     * eg(d:\\output.txt)
     * It expect inputs to be entered when prompted at console
     */
    public static void main(String[] args) throws Exception {
	Scanner scanner = new Scanner(System.in);
	int noOfReords;
	WhetherSimulationEngine whetherSimulationEngine = new WhetherSimulationEngine();
	double enteredLatitude;
	double enteredLongitude;
	try {
	    // initializing applicationInstance by reading default values of
	    // application.properties file in resources bundle
	    ApplicationInstance.getInstance();

	    noOfReords = whetherSimulationEngine.getScannedRecordsEntered(scanner);
	    enteredLatitude = whetherSimulationEngine.getScannedLatitude(scanner);
	    enteredLongitude = whetherSimulationEngine.getScannedLongitude(scanner);
	    File file = whetherSimulationEngine.getScannedFile(scanner);
	    whetherSimulationEngine.startEngine(noOfReords, enteredLatitude,enteredLongitude, file);
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		scanner.close();
	    } catch (Exception e) {
		e.printStackTrace();
	    }

	}
    }
    
    /**
     * Asks for longitude at console .scanner captures the entered longitude 
     * 
     * @param Scanner
     *            object to scan inputs from user at console
     * @return longitude
     * 		longitude in decimal value
     */
    private double getScannedLongitude(Scanner scanner) throws Exception {
	Double enteredLongitude;
	System.out.print("Enter Longitude (Note:-+"
	        + ApplicationInstance.getRandomLongitudePlusMinusRange()
	        + " range of Longitude data will be generated): ");
	String longitudeString = scanner.nextLine();
	try {
	    enteredLongitude = Double.valueOf(longitudeString);
	} catch (Exception e) {
	    throw new Exception("longitude should be a number");
	}

	if (enteredLongitude > ApplicationInstance.getMaxLongitudeLimit()) {
	    throw new Exception("Entered longitude +-"
		    + ApplicationInstance.getRandomLongitudePlusMinusRange()
		    + " will exceed 180 degree please enter a valid range");
	} else if (enteredLongitude < ApplicationInstance.getMinLongitudeLimit()) {
	    throw new Exception("Entered longitude +-"
		    + ApplicationInstance.getRandomLongitudePlusMinusRange()
		    + " will exceed 180 degree please enter a valid range");
	}
	return enteredLongitude;
    }
    
    /**
     * Asks for latitude at console .scanner captures the entered latitude 
     * 
     * @param Scanner
     *            object to scan inputs from user at console
     * @return latitude
     * 		latitude in decimal value
     */
    private double getScannedLatitude(Scanner scanner) throws Exception {
	
	System.out.print("Enter Latitude (Note:-+"
	        + ApplicationInstance.getRandomLatitudePlusMinusRange()
	        + " range of latitude data will be generated): ");
	Double enteredLatitude;
	String latitudeString = scanner.nextLine();
	try {
	    enteredLatitude = Double.valueOf(latitudeString);
	} catch (Exception e) {
	    throw new Exception("latitude should be a number");
	}
	if (enteredLatitude > ApplicationInstance.getMaxLatitudeLimit()) {
	    throw new Exception("Entered latitude +-"
		    + ApplicationInstance.getRandomLatitudePlusMinusRange()
		    + " will exceed 90 degree please enter a valid range");
	} else if (enteredLatitude < ApplicationInstance.getMinLatitudeLimit()) {
	    throw new Exception("Entered latitude +-"
		    + ApplicationInstance.getRandomLatitudePlusMinusRange()
		    + " will exceed 90 degree please enter a valid range");
	}
	return enteredLatitude;
    }
    
    /**
     * Asks for no of weather records to generate  .
     * 
     * @param Scanner
     *            object to scan inputs from user at console
     * @return noOfRecords
     * 		no Of Records to generate 
     */
    private Integer getScannedRecordsEntered(Scanner scanner) throws Exception {
	System.out.print("Enter number of records to genrate: ");
	Integer noOfReords = null;
	String noOfReordsString = scanner.nextLine();
	try {
	    noOfReords = Integer.valueOf(noOfReordsString);
	} catch (Exception e) {
	    throw new Exception("No Of Records to generate should be of numeric");
	}
	return noOfReords;
    }
    
    /**
     * method used to start Weather data generation engine  .
     * 
     * @param noOfReords
     *             NO of Records to generate
     * @param enteredLatitude
     * 		on behalf of latitude provided ranges of +10 to -10 latitude data is generated
     * @param enteredLongitude
     * 		on behalf of longitude provided ranges of +10 to -10
     * @param file
     * 		file reference to which output result will be written 
     */
    private void startEngine(int noOfReords, double enteredLatitude,
	    double enteredLongitude, File file) throws Exception {
	BufferedWriter bw = null;
	FileWriter fw = null;
	try {

	    fw = new FileWriter(file);
	    bw = new BufferedWriter(fw);
	    WhetherSimulationEngine whetherSimulationEngine = new WhetherSimulationEngine();
	    whetherSimulationEngine.executeEngineToGenerateRecords(noOfReords, enteredLatitude, enteredLongitude, bw);
	} finally {
	    try {
		if (bw != null)
		    bw.close();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    try {
		if (fw != null)
		    fw.close();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    
    /**
     * Asks for file path to which result will be written  .
     * 
     * @param Scanner
     *            object to scan inputs from user at console
     * @return file
     * 		newly generated output file refrence 
     */
    private File getScannedFile(Scanner scanner) throws Exception {
	System.out.print("Enter File path(eg c:\\data.txt): ");
	String filePathString = scanner.nextLine();
	File file = null;
	file = new File(filePathString);
	if (!file.exists()) {
	    file.createNewFile();
	}
	return file;
    }

}
