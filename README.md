# Weather Project

This Project is used to simulate weather data in the form 
of latitude,longitude,altitude|datetime|condition|temperature|pressure|humidity taking into account things like
atmosphere, topography, geography,oceanography) .The generated Data will mimic measurements at various locations and times.

## Algorithms & Understanding

The different attribute of weather envoirnement and place locations are genereted on behalf of below understanding and facts.

###### Latitude
By default +-10 range of random latitudes lower and upper range will be created on behalf of entered latitude.

###### Longitude
By default +-10 range of random longitudes lower and upper range will be created on behalf of entered longitude.

###### Altitude
By default random value from a range of 2 to 200 will be picked.

###### Date
Any random date from a range of current date to past 3 years(default) can be picked .

###### Tempereture
   a)tempreture of any place is affected by its latitude and altitude there is a temperature relationship between
   latitude and altitude for more details  visit http://webinquiry.org/examples/temps/.
    Temperature relation ship with altitude -->Temperature = -0.0026* (Elevation in feet) 
    Temperature relation ship with latitude -->For locations below 20°N: Temperature = 80°F.
    For locations between 20°N and 60°N: Temperature = -0.988 *(latitude) + 96.827F.

   b)The tempreture result from step 'a' will be then anlaysed by tempreture intensity by months ,
   The summer months are April through September (April,May,June,July,August,Sep) on the Northern Hemisphere (positive latiudes)
   and the winter months are October through March (Oct,Nov,Dec,Jan,Feb,March), and VICE VERSA for the Southern Hemisphere
   (negitive atiudes).Also the mid months intensity will be more than other months, so every months is having there
   own intensity level which will be furher act on old tempreture from step 'a'.
             
  c)The tempreture result from step 'b' will be then anlaysed by tempreture intensity by hours in noon we
    experience more temperature intensity then in evening and in night the weigtage scores are given for all individual hours of a day .

###### pressure
  Pressure at given altitude can be also calculated by below formula
    P=P0e^((-mu*g*h)\RT)
    where
    p0- pressure at see level -101325
    mu - Molar mass of Earth's air, 0.0289644 kg/mol
    g - Gravitational acceleration, 9.80665 m/(s*s)
    h - Height difference, meters
    R - Universal gas constant for air, 8.31432 N·m /(mol·K)
    T - Air temperature
          
###### humidity
   Random humidity ranging between  5 to 98
       The humidity in the project is taken as random because relative humidity is calculate by formula rh=p0/P1.
       where p0 is pressure of atmoshphere where as p1 is dew point pressure which is more calculated  by scientific measures
       (eg wet bulb measure test).
       
###### Condition 
   condition can be determine as sunny,rain  and snow on behalf pressure, temperature,humidity,alititude as all factors
	   snow->it is assumed that altitudes with higher values , less pressure and less temperature can cause of snow
	  rain->with high humidity,moderate range of altitudes and mild temperature

## Getting Started
1)Download the zipped project to local system (Example-->D:\weather_project-master)
2)Extact the downloded zipped file in some directory 


### Prerequisites
1)JDK must be intalled 
2)Maven must be installed 
1)JAVA_HOME should be set in envoirnment user variables
2)M2_HOME should be set in envoirnment user variables


### Installing & Running

1)Open cmd and navigate to extracted folder (Example-->D:\weather_project-master\weather_project-master)
or type -->
cd /d "D:\weather_project-master\weather_project-master" 
in terminal
2)type -->mvn install
this will build the class files and create executable jars in target subdirectory folder
3)navigate to target sub folder in cmd (type--> cd target ) 
4)Type --> java -jar WeatherSimulation-0.0.1-SNAPSHOT.jar
it will run the program and ask for inputs
		####Inputs Required
		a)no of records to generate
		b)latitude  (Note:By default +-10 range of random latitudes lower and upper range will be created on behalf of entered latitude)
		c)longitude  (Note:By default +-10 range of random latitudes lower and upper range will be created on behalf of entered latitude)
		d)file path-->output file path 

		####Output Generated
		
		The result of execution will be written to file path from (d) step.
		the format of result will be latitude,longitude,altitude|datetime|condition|temperature|pressure|humidity
		


## Built With


* [Maven](https://maven.apache.org/) - Dependency Management


## Contributing


## Authors

Shailesh Gupta -(https://github.com/shaileshiet31)


## Acknowledgments & References

* http://webinquiry.org/examples/temps/
* https://www.mide.com/pages/air-pressure-at-altitude-calculator
* https://www.britannica.com/science/Koppen-climate-classification


