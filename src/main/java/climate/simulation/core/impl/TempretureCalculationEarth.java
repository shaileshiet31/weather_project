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
import java.util.HashMap;
import java.util.Map;
import climate.simulation.core.base.TempretureCalculation;
import climate.simulation.util.ClimateUtils;

/**
 * The class is used to define methods for finding pressure and humidity
 * attributes on earth. The class is used to define methods methods for finding
 * temperature and intensity of temperature by there months and hours since in
 * earth we have 365 days 12 months and 24 hours which will be used to calculate
 * temperature intensity by season and time on earth
 * 
 * @author shailesh
 * @see climate.simulation.core.base.TempretureCalculation
 * 
 */

public class TempretureCalculationEarth implements TempretureCalculation {

    private static Map<Integer, Double> summerMonthsForNorthernHemishphereMap = new HashMap<Integer, Double>();
    private static Map<Integer, Double> winterrMonthsForNorthernHemishphereMap = new HashMap<Integer, Double>();
    private static Map<Integer, Double> summerMonthsForSouthernHemishphereMap = new HashMap<Integer, Double>();
    private static Map<Integer, Double> winterrMonthsForSouthernHemishphereMap = new HashMap<Integer, Double>();
    private static Map<Integer, Double> tempIntensityKeyedByHour = new HashMap<Integer, Double>();

    /**
     * 
     * Initializing credit weightage score for individual summer and cold months
     * for northern and southern hemisphere Also initialization of credit
     * weightage score for temperature intensity for day hours
     */
    static {
	// april and its weigtage out of 100 % intensity range
	summerMonthsForNorthernHemishphereMap.put(3, 5.0);
	// may and its weigtage out of 100 % intensity range
	summerMonthsForNorthernHemishphereMap.put(4, 10.0);
	// june and its weigtage out of 100 % intensity range
	summerMonthsForNorthernHemishphereMap.put(5, 20.0);
	// july and its weigtage out of 100 % intensity range
	summerMonthsForNorthernHemishphereMap.put(6, 15.0);
	// august and its weigtage out of 100 % intensity range
	summerMonthsForNorthernHemishphereMap.put(7, 10.0);
	// sep and its weigtage out of  100 % intensity range
	summerMonthsForNorthernHemishphereMap.put(8, 0.0);
	// october and its weigtage out of  100 % intensity range
	winterrMonthsForNorthernHemishphereMap.put(9, 0.0);
	// november and its weigtage out  of 100 % intensity range
	winterrMonthsForNorthernHemishphereMap.put(10, -5.0);
	// december and its weigtage out of 100 % intensity range
	winterrMonthsForNorthernHemishphereMap.put(11, -15.0);
	// january and its weigtage out  of 100 % intensity range
	winterrMonthsForNorthernHemishphereMap.put(0, -10.0);
	// februry and its weigtage out of  100 % intensity range
	winterrMonthsForNorthernHemishphereMap.put(1, -8.0);
	// march and its weigtage out  of 100 % intensity range
	winterrMonthsForNorthernHemishphereMap.put(2, -5.0);
	// october and its weigtage out of  100 % intensity range
	summerMonthsForSouthernHemishphereMap.put(9, 5.0);
	// november and its weigtage out of 100 % intensity range
	summerMonthsForSouthernHemishphereMap.put(10, 10.0);
	// december and its weigtage out of 100 % intensity range
	summerMonthsForSouthernHemishphereMap.put(11, 20.0);
	// january and its weigtage out of  100 % intensity range
	summerMonthsForSouthernHemishphereMap.put(0, 15.0);
	// februry and its weigtage out of  100 % intensity range
	summerMonthsForSouthernHemishphereMap.put(1, 10.0);
	// march and its weigtage out of 100 % intensity range
	summerMonthsForSouthernHemishphereMap.put(2, 8.0);
	// april and its weigtage out of  100 % intensity range
	winterrMonthsForSouthernHemishphereMap.put(3, 0.0);
	// may and its weigtage out of 100 %intensity range
	winterrMonthsForSouthernHemishphereMap.put(4, -5.0);
	// june and its weigtage out of  100 % intensity range
	winterrMonthsForSouthernHemishphereMap.put(5, -15.0);
	// july and its weigtage out of 100 % intensity range
	winterrMonthsForSouthernHemishphereMap.put(6, -12.0);
	// august and its weigtage out  of 100 % intensity range
	winterrMonthsForSouthernHemishphereMap.put(7, -8.0);
	// sep and its weigtage out of  100 % intensity range
	winterrMonthsForSouthernHemishphereMap.put(8, -5.0);
	tempIntensityKeyedByHour.put(12, 100.0);
	tempIntensityKeyedByHour.put(13, 100.0);
	tempIntensityKeyedByHour.put(14, 92.0);
	tempIntensityKeyedByHour.put(15, 82.0);
	tempIntensityKeyedByHour.put(16, 75.0);
	tempIntensityKeyedByHour.put(17, 67.0);
	tempIntensityKeyedByHour.put(18, 60.0);
	tempIntensityKeyedByHour.put(19, 56.0);
	tempIntensityKeyedByHour.put(20, 54.0);
	tempIntensityKeyedByHour.put(21, 53.0);
	tempIntensityKeyedByHour.put(22, 53.0);
	tempIntensityKeyedByHour.put(23, 53.0);
	tempIntensityKeyedByHour.put(0, 52.0);
	tempIntensityKeyedByHour.put(1, 52.0);
	tempIntensityKeyedByHour.put(2, 51.0);
	tempIntensityKeyedByHour.put(3, 51.0);
	tempIntensityKeyedByHour.put(4, 49.0);
	tempIntensityKeyedByHour.put(5, 49.0);
	tempIntensityKeyedByHour.put(6, 52.0);
	tempIntensityKeyedByHour.put(7, 67.0);
	tempIntensityKeyedByHour.put(8, 75.0);
	tempIntensityKeyedByHour.put(9, 82.0);
	tempIntensityKeyedByHour.put(10, 92.0);
	tempIntensityKeyedByHour.put(11, 95.0);
    }

    /**
     * This method is used to calculate temperature from latitude and altitude
     * there is a temperature relationship between latitude and altitude for
     * more details visit http://webinquiry.org/examples/temps/ Temperature
     * relation ship with altitude -->Temperature = -0.0026* (Elevation in feet)
     * Temperature relation ship with latitude --> For locations below 20N:
     * Temperature = 80F. For locations between 20N and 60N: Temperature =
     * -0.988 *(latitude) + 96.827F.
     * 
     * @param lattitude
     * @param altitude
     * 
     * @return temperature
     * @throws if
     *             latitude supplied is greter than 90 degree
     */

    public double getAverageTempretureByLattitudeAndAltitude(double lattitude, double altitude) throws Exception {
	/*
	 * if lattitude contains -ve val than change to positive value as we
	 * assume that the formula will be applied for both northern hemisphere
	 * and southern hemisphere
	 */

	lattitude = lattitude < 0 ? (lattitude * -1) : lattitude;
	double returnTempretureFareignhight = 0.0;
	if (lattitude < 20) {
	    returnTempretureFareignhight = 80;
	} else if (lattitude >= 20 && lattitude < 60) {
	    returnTempretureFareignhight = (-0.988 * lattitude) + 96.827;
	} else if (lattitude >= 60 && lattitude <= 90) {
	    returnTempretureFareignhight = (-2.5826 * lattitude) + 193.33;
	} else {
	    throw new Exception("Latitude can't be greater then 90 degree");
	}
	// tempreture is inversely propartional to altitude
	// conversion of altitude to feet 1:3.28084
	returnTempretureFareignhight = returnTempretureFareignhight - (0.0026 * (altitude * 3.28084));
	return ClimateUtils.convertFareignhigthToCelcius(returnTempretureFareignhight);
    }

    /**
     * This method is used to calculate temperature intensity weitage by months
     * The summer months are April through September
     * (April,May,June,July,August,Sep) on the Northern Hemisphere and the
     * winter months are October through March (Oct,Nov,Dec,Jan,Feb,March), and
     * VICE VERSA for the Southern Hemisphere also the mid months intensity will
     * be more than other months
     * 
     * @param lattitude
     * @param altitude
     * @param atDateTime
     * @return wheitageOfIntensity
     */

    public double calculateTempretureIntensityFactorByMonth(double lattitude, double altitude, Date atDateTime) {
	Calendar passedDate = Calendar.getInstance();
	passedDate.setTime(atDateTime);
	int currentMonth = passedDate.get(Calendar.MONTH);
	double wheitageOfIntensity = 0.0d;

	// if location falls under southern hemishphere
	if (lattitude < 0) {
	    // to check current month is in summer
	    if (summerMonthsForSouthernHemishphereMap.keySet().contains(currentMonth)) {
		// since location is falled under southern hemishephere then
		// winter months will be summer months
		wheitageOfIntensity = summerMonthsForSouthernHemishphereMap.get(currentMonth);
	    }
	    // current month falls in winter
	    else {
		wheitageOfIntensity = winterrMonthsForSouthernHemishphereMap.get(currentMonth);
	    }
	}
	// if location falls under northern hemishphere
	else {
	    // to check current month is in summer
	    if (summerMonthsForNorthernHemishphereMap.keySet().contains(currentMonth)) {
		// since location is falled under southern hemishephere then
		// winter months will be summer months
		wheitageOfIntensity = summerMonthsForNorthernHemishphereMap.get(currentMonth);
	    }
	    // current month falls in winter
	    else {
		wheitageOfIntensity = winterrMonthsForNorthernHemishphereMap.get(currentMonth);
	    }
	}
	return wheitageOfIntensity;
    }

    /**
     * This method is used to calculate temperature intensity weigtage by day
     * hours in noon we experience more temperature intensity then in evening
     * and in night the weigtage scores are given for all individual hours of a
     * day
     * 
     * @param atDateTime
     * @return wheitageOfIntensity
     */

    public double calculateTempretureIntensityFactorByCurrentHours(Date atDateTime) {
	Calendar passedDate = Calendar.getInstance();
	passedDate.setTime(atDateTime);
	int currentHour = passedDate.get(Calendar.HOUR_OF_DAY);
	return tempIntensityKeyedByHour.get(currentHour);
    }

    /*
     * public double calculateTempretureIntensityFactorByDay(Date atDateTime) {
     * 
     * List<Integer>collectionOfDAys=new ArrayList<>(); for(int i=0;i<31;i++){
     * collectionOfDAys.add(i); }
     * 
     * 
     * Calendar passedDate= Calendar.getInstance();
     * passedDate.setTime(atDateTime); int
     * currentDay=passedDate.get(Calendar.DAY_OF_MONTH);
     * 
     * return getCyclicWiegtage(collectionOfDAys, 100, 10, 1, currentDay); }
     *//**
     * (Note: this method is incomplete) it will be used for calculation of
     * tempreture intensity weigtage in cyclic graph if we take 24 hour period
     * tempreture at 12' clock noon will be very high then 3 then there will
     * less instesity in evening and in nightso the the tempreture intensity can
     * be defined as 12 noon>3pm>6pm>9pm>24 then there will be reverse occuring
     * of rise in tempreture ie 2am<4am<8am<10am<11am this algorithm is desinged
     * to claculate this intenisty changes in cyclic manner . this alogrithm
     * will be used defined the intensity of tempreture of a particular day in
     * 30 days of month also
     * 
     * @param
     * @return wheitageOfIntensity
     */
    /*
     * 
     * 
     * public double getCyclicWiegtage(List<Integer>collectionList,double
     * higherWietage, double lowerWeigtage,int elementOfHigherWietage,int item)
     * {
     * 
     * int midSizeOFCollection=collectionList.size()/2; int
     * itemIndex=collectionList.indexOf(item); int
     * elementOfHigherWietageIndex=collectionList
     * .indexOf(elementOfHigherWietage); int
     * midPointIndexRefrenceToMainElement=elementOfHigherWietageIndex;
     * List<Integer> elementsOfMidRange= new ArrayList<Integer>(); for(int
     * inc=0;inc<midSizeOFCollection;inc++) {
     * if(midPointIndexRefrenceToMainElement!=collectionList.size()) {
     * midPointIndexRefrenceToMainElement++;
     * elementsOfMidRange.add(midPointIndexRefrenceToMainElement); } else {
     * midPointIndexRefrenceToMainElement=0;
     * elementsOfMidRange.add(midPointIndexRefrenceToMainElement); } } double
     * midWiegtageVal
     * =(higherWietage-((higherWietage-lowerWeigtage)/collectionList
     * .size())*midSizeOFCollection); double weightedReturnVal=0.0;
     * if(!elementsOfMidRange.contains(itemIndex)) { int distance=0;
     * if(midPointIndexRefrenceToMainElement>itemIndex) {
     * distance=collectionList
     * .size()-midPointIndexRefrenceToMainElement+itemIndex; } else {
     * distance=itemIndex-midPointIndexRefrenceToMainElement; }
     * weightedReturnVal
     * =(midWiegtageVal+((higherWietage-lowerWeigtage)/collectionList
     * .size())*distance); } else { int distance=0;
     * if(elementOfHigherWietageIndex<itemIndex) {
     * distance=itemIndex-elementOfHigherWietageIndex; } else {
     * distance=collectionList.size()-elementOfHigherWietageIndex+itemIndex; }
     * weightedReturnVal
     * =(higherWietage-((higherWietage-lowerWeigtage)/collectionList
     * .size())*distance); }
     * 
     * 
     * return weightedReturnVal; }
     */
}
