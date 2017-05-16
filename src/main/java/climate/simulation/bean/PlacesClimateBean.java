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

package climate.simulation.bean;

import java.util.Date;

/**
 * @author shailesh_331829
 * 
 */

public class PlacesClimateBean {

    String locationName = null;
    double lattitude = 0.0d;
    double longitude = 0.0d;
    double altitude = 0.0d;
    double tempreture = 0.0d;
    double pressure = 0.0d;
    Date localTime = null;
    double intensityByMonth = 0.0d;
    double intensityByHour = 0.0d;
    double humidity = 0.0d;

    WheatherCondition condition;

    public PlacesClimateBean() {
	super();
    }

    public PlacesClimateBean(double lattitude, double longitude, double altitude, Date localTime) {
	super();
	this.lattitude = lattitude;
	this.longitude = longitude;
	this.altitude = altitude;
	this.localTime = localTime;
    }

    public double getHumidity() {
	return humidity;
    }

    public void setHumidity(double humidity) {
	this.humidity = humidity;
    }

    public double getIntensityByMonth() {
	return intensityByMonth;
    }

    public void setIntensityByMonth(double intensityByMonth) {
	this.intensityByMonth = intensityByMonth;
    }

    public double getIntensityByHour() {
	return intensityByHour;
    }

    public void setIntensityByHour(double intensityByHour) {
	this.intensityByHour = intensityByHour;
    }

    public String getLocationName() {
	return locationName;
    }

    public void setLocationName(String locationName) {
	this.locationName = locationName;
    }

    public double getLattitude() {
	return lattitude;
    }

    public void setLattitude(double lattitude) {
	this.lattitude = lattitude;
    }

    public double getLongitude() {
	return longitude;
    }

    public void setLongitude(double longitude) {
	this.longitude = longitude;
    }

    public double getAltitude() {
	return altitude;
    }

    public void setAltitude(double altitude) {
	this.altitude = altitude;
    }

    public double getTempreture() {
	return tempreture;
    }

    public void setTempreture(double tempreture) {
	this.tempreture = tempreture;
    }

    public double getPressure() {
	return pressure;
    }

    public void setPressure(double pressure) {
	this.pressure = pressure;
    }

    public Date getLocalTime() {
	return localTime;
    }

    public void setLocalTime(Date localTime) {
	this.localTime = localTime;
    }

    public WheatherCondition getCondition() {
	return condition;
    }

    public void setCondition(WheatherCondition condition) {
	this.condition = condition;
    }

}
