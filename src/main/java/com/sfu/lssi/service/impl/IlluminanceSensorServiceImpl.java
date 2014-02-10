package com.sfu.lssi.service.impl;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.sfu.lssi.data.IlluminanceSensor;
import com.sfu.lssi.data.IlluminanceSensorList;
import com.sfu.lssi.service.IlluminanceSensorService;

public class IlluminanceSensorServiceImpl implements IlluminanceSensorService {
	private static final Logger logger = Logger.getLogger(IlluminanceSensorServiceImpl.class);

	@Override
	public IlluminanceSensorList getIlluminanceSensorValues(int sensorListId) {
		
		String methodName = "getIlluminanceSensorValues";
		String logMessage = null;
		double x = 0.0;
		double y = 0.0;
		double z = 0.0;
		double illuminanceLux = 0.0;
		String row;
		String substring;
		int startSubstr = 0;
		int endSubstr = 0;
		int numLines   = 0;
		int sensorId = 0;
		int index = 0;
		String illuminanceValuesFile = "";  
        String illuminanceCalculatorProcess = ""; 
		IlluminanceSensorList retVal = new IlluminanceSensorList();
		
		
		logMessage = methodName + " ---> ";
		logger.debug(logMessage);
		
		//retVal.setId(sensorListId);
		//retVal.setNumberOfSensors(4);
		
		// Retrieve the values of the configuration parameters
        Properties properties = new Properties();
		try {
			// 
			properties.load(new FileInputStream("/opt/LSS/lssi/lssi.properties"));	
			illuminanceValuesFile = properties.getProperty("illuminanceValuesFile");
			illuminanceCalculatorProcess = properties.getProperty("illuminanceCalculatorProcess");
			logger.info(" === property (illuminanceValuesFile) = " + illuminanceValuesFile);
			logger.info(" === property (illuminanceCalculatorProcess) = " + illuminanceCalculatorProcess);
    	} catch (IOException e) {
    		logger.error("Error **** properties file **** " + e.getMessage());
        }	
		
		// --------------------------------------------------------------------
		// Ask Radiance to calculate the illuminance values (lux).
		// The output is a text file (fileName) which will be used in the 
		// second part of this method.
		// --------------------------------------------------------------------
		// Try to execute  UNIX shell script
		Runtime r = Runtime.getRuntime();
		try {
		  logger.info(" ----- Calculating illuminance values");
		  Process p = r.exec(illuminanceCalculatorProcess);
		  try {
			  // Wait for the process
		     int resultWait = p.waitFor();
		  }
		  catch (InterruptedException e) {
			  logger.error(e.getMessage());
		  }
		}
		catch (IOException e) {
			logger.error(e.getMessage());
	    }
		
		// --------------------------------------------------------------------
		// The illuminance values contained in the text file (fileName) are 
		// represented through a group of sensors; each line of the file is
		// considered as an illuminance sensor having, amomg other attributes,
		// position and illuminance.
		// --------------------------------------------------------------------
		
		// Count the number of lines in the input file. This number coincides 
		// with the number of sensors which added to sensorArray.
		numLines = countNumberLines (illuminanceValuesFile); 
		logger.info(" ==== Number of lines = " + numLines);
		
		
		// The array containing the sensors.
		ArrayList<IlluminanceSensor> sensorArray = new ArrayList<IlluminanceSensor>();   
		
		
		try{
			  // Open the file that contains the illuminance values calculated 
			  // by Radiance.
			  FileInputStream fstream = new FileInputStream(illuminanceValuesFile);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  
			  //Read File Line By Line
			  for (index=0; index < numLines; index=index+1) {
				  row = br.readLine();
				  sensorId ++;  // Set the value of the sensor Id
				  
				  // Temporary illuminance sensor which is used for gathering 
				  // the data for the array of sensors.
				  IlluminanceSensor illuminanceSensor = new IlluminanceSensor();
				  				  
				  // Retrieve x
				  startSubstr = 0;
				  endSubstr = row.indexOf('\t'); 
				  substring = row.substring(startSubstr, endSubstr);
				  x = Double.valueOf(substring.trim()).doubleValue();
				  logger.info("====== x = " + x);

				  // Retrieve y
				  startSubstr = endSubstr + 1;
				  endSubstr = row.indexOf('\t', startSubstr); 
				  substring = row.substring(startSubstr, endSubstr);
				  y = Double.valueOf(substring.trim()).doubleValue();
				  logger.info("====== y = " + y);
				  
				  
				  // Retrieve z
				  startSubstr = endSubstr + 1;
				  endSubstr = row.indexOf('\t', startSubstr);
				  substring = row.substring(startSubstr, endSubstr);
				  z = Double.valueOf(substring.trim()).doubleValue();
				  logger.info("====== z = " + z);
				  
				  // Retrieve illuminanceLux
				  startSubstr = endSubstr + 1;
				  substring = row.substring(startSubstr);
				  illuminanceLux = Double.valueOf(substring.trim()).doubleValue();
				  logger.info("====== illuminanceLux = " + illuminanceLux);
  
				  illuminanceSensor.setId(sensorId);
				  illuminanceSensor.setPosition(x, y, z);
				  illuminanceSensor.setIlluminanceLux(illuminanceLux);

				  
				  logger.info("====== illuminanceSensor: id= " + illuminanceSensor.getId());
				  
				  logger.info("====== Composing sensor id = " + sensorId);
				  sensorArray.add(illuminanceSensor);
				  logger.info("====== sensor id = " + sensorId + " composed");
				  
				  illuminanceSensor = null;
				  				  
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			    	logger.info("getSensorListById *** Error: " + e.getMessage());
			  }
		
		// Return the list of sensors
		retVal.setId(sensorListId);
		retVal.setNumberOfSensors(numLines);
		retVal.setSensorArray(sensorArray);
		
		logMessage = methodName + " <--- ";
		logger.debug(logMessage);
		return retVal;
	}
	
	
	
	/**
	 * 
	 * @param fileName
	 * @return Number of lines in the file fileName
	 */
	private int countNumberLines (String fileName) {
		int numberOfLines = 0;
		String line;
		
		try {
		  FileInputStream fstream = new FileInputStream(fileName);
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  
		  //Read File Line By Line
		  while ((line = br.readLine()) != null) {
			  numberOfLines++;
		  }	 
		 //Close the input stream
		 in.close();
		}
		catch (Exception e) { //Catch exception if any
		    	logger.error("countNumberLines **** Error: " + e.getMessage());
	    }
		return numberOfLines;
   }

}
