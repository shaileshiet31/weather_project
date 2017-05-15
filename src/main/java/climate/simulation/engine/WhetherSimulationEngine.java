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
 * The class main method is used to simulate weather data in file
 * input required at console-->
 * 1)no of Records 
 * 2)Latitude
 * 3)longitude
 * 4)File Path for output file eg(d:\\output.txt)
 *
 * @author  shailesh
 * @see  climate.simulation.core.impl.WhetherConditionPredectionEarth
	@see climate.simulation.core.impl.PressureCalculationEarth
	@see climate.simulation.core.impl.TempretureCalculationEarth
	@see climate.simulation.core.impl.WhetherConditionPredectionEarth
	
 */

public class WhetherSimulationEngine
{
	
	/**  
	 * Core Engine to generate whether simulation data
	 * 
	 * @param noOfReords
	 * 					 NO of Records to generate
	 * @param enteredLatitude
	 * 					 on behalf of latitude provided ranges of +10 to -10 latitude data is generated
	 * @param enteredLongitude 
	 * 					on behalf of longitude provided ranges of +10 to -10 longitude data is generated
	 * @param bw 
	 * 					 buffer writer file the file
	 */
	
	private  void executeEngineToGenerateRecords(int noOfReords,double enteredLatitude,double enteredLongitude, BufferedWriter bw ) throws Exception
	{
	 
		
		
		LocationsCalculation locationsCalculation=new LocationCalculationEarth() ;
		TimeCalculations timeCalculations=new TimeCalculationEarth() ;
		TempretureCalculation tempretureCalculation=new TempretureCalculationEarth();
		PresureCalculation presureCalculation=new PressureCalculationEarth();
		HumidityCalculation humidityCalculation=new HumidityCalculationEarth();
		WhetherConditionPredection whetherConditionPredection=new WhetherConditionPredectionEarth();
		
		
		
		for(int i=1;i<=noOfReords;i++)
		{
			StringBuilder sb=new StringBuilder();
			double latitude=locationsCalculation.generateLatitude(enteredLatitude,null);
			double longitude=locationsCalculation.generateLongitude(enteredLongitude,null);
			double altitude=locationsCalculation.generateAltitude(null, null);
			Date randomDate=timeCalculations.generateDateTime(null);
			
			
			double tempreture=ClimateUtils.calculateTempretureByFactors(latitude, altitude, randomDate,tempretureCalculation);
			
			double pressure=presureCalculation.calculatePressureAtAltitude(altitude, tempreture);
			
			double humidity=humidityCalculation.generateRandomRelativeHumidity(altitude, latitude, longitude, tempreture);
			
			WheatherCondition condition=whetherConditionPredection.calculateWhetherCondition(pressure, tempreture, humidity, altitude);
			
			sb.append( String.format( "%.2f", latitude ));
			sb.append(",");
			sb.append(String.format( "%.2f", longitude ));
			sb.append(",");
			sb.append(String.format( "%.2f", altitude));
			sb.append("|");
			sb.append(ClimateUtils.getISO8601DateFormat(randomDate));
			sb.append("|");
			sb.append(condition.toString());
			sb.append("|");
			String formattedTempreture=String.format( "%.2f", tempreture);
			sb.append(tempreture>0?"+"+formattedTempreture:formattedTempreture);
			sb.append("|");
			sb.append(String.format( "%.2f", pressure));
			sb.append("|");
			sb.append( String.format( "%.2f", humidity));
			System.out.println(sb);
			sb.append("\r\n");
			
			bw.write(sb.toString());
			
		}
		
	}
	
	/**  
	 * Initiator point for Data generation  input required at console-->
	 * 
	 * 1)no of Records--> NO of Records to generate 
	 * 2)Latitude-->on behalf of latitude provided ranges of +10 to -10 latitude data is generated
	 * 3)longitude-->on behalf of longitude provided ranges of +10 to -10 longitude data is generated
	 * 4)File Path for output file eg(d:\\output.txt)
	 * 
	 * It expect inputs to be entered when prompted at console
	 * 

	 */
	
	public static void main(String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		int noOfReords;
		 BufferedWriter bw = null;
		 FileWriter fw =null;
		double enteredLatitude;
		double enteredLongitude;
		try
		{
			//initializing applicationInstance by reeading default values of application.properties file in resources bundle
			ApplicationInstance.getInstance();
			
			System.out.print("Enter number of records to genrate: ");
			
			
			String noOfReordsString = scanner.nextLine();
	
			try
			{
				noOfReords=Integer.valueOf(noOfReordsString);	
			}
			catch(NumberFormatException e)
			{
				throw new IllegalArgumentException("No Of Records to generate should be of numeric");
			}
			
			System.out.print("Enter Latitude (Note:-+"+ApplicationInstance.getRandomLatitudePlusMinusRange()+" range of latitude data will be generated): ");
			String latitudeString = scanner.nextLine();
			
			try
			{
				enteredLatitude=Double.valueOf(latitudeString);	
			}
			catch(NumberFormatException e)
			{
				throw new Exception("latitude should be a number");
			}
			if(enteredLatitude>ApplicationInstance.getMaxLatitudeLimit())
			{
				throw new IllegalArgumentException("Entered latitude +-"+ApplicationInstance.getRandomLatitudePlusMinusRange()+" will exceed 90 degree please enter a valid range");
			}
			else if(enteredLatitude<ApplicationInstance.getMinLatitudeLimit())
			{
				throw new IllegalArgumentException("Entered latitude +-"+ApplicationInstance.getRandomLatitudePlusMinusRange()+" will exceed 90 degree please enter a valid range");
			}
			
			
			
			System.out.print("Enter Longitude (Note:-+"+ApplicationInstance.getRandomLongitudePlusMinusRange()+" range of Longitude data will be generated): ");
			String longitudeString = scanner.nextLine();
			
			try
			{
				enteredLongitude=Double.valueOf(longitudeString);
			}
			catch(NumberFormatException e)
			{
				throw new IllegalArgumentException("longitude should be a number");
			}
			
			if(enteredLongitude>ApplicationInstance.getMaxLongitudeLimit())
			{
				throw new IllegalArgumentException("Entered longitude +-"+ApplicationInstance.getRandomLongitudePlusMinusRange()+" will exceed 180 degree please enter a valid range");
			}
			else if(enteredLongitude<ApplicationInstance.getMinLongitudeLimit())
			{
				throw new IllegalArgumentException("Entered longitude +-"+ApplicationInstance.getRandomLongitudePlusMinusRange()+" will exceed 180 degree please enter a valid range");
			}
			
			
			System.out.print("Enter File path(eg c:\\data.txt): ");
			String filePathString = scanner.nextLine();
			try 
			{
				File file = new File(filePathString);
			 fw = new FileWriter(file);
			 bw = new BufferedWriter(fw);
			 if (!file.exists()) {
			     file.createNewFile();
			  }
			}
			catch(Exception e) 
			{
				throw e;
			}
			
			WhetherSimulationEngine whetherSimulationEngine=new WhetherSimulationEngine();
			whetherSimulationEngine.executeEngineToGenerateRecords(noOfReords, enteredLatitude, enteredLongitude,bw);
		}
		finally
		{
			try 
			{
				scanner.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			try 
			{
				if(bw!=null)
				bw.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
