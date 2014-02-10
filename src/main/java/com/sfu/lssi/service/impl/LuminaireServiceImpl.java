package com.sfu.lssi.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.sfu.lssi.controller.LuminaireController;
import com.sfu.lssi.data.Luminaire;
import com.sfu.lssi.data.PowerLevelEvent;
import com.sfu.lssi.service.LuminaireService;

public class LuminaireServiceImpl implements LuminaireService {
	
	private static final Logger logger = Logger.getLogger(LuminaireServiceImpl.class);

	@Override
	public PowerLevelEvent createPowerLevelEvent(PowerLevelEvent powerLevelEvent) {
		
		String methodName = "createPowerLevelEvent";
		String logMessage = null;
		ArrayList<Luminaire> luminaires = null;

		logMessage = methodName + " ---> ";
		logger.debug(logMessage);
		
		luminaires = powerLevelEvent.getLuminaireArray();
		Iterator<Luminaire> iter = luminaires.iterator();
		while (iter.hasNext())
	    {
			Luminaire luminaire = new Luminaire();
			luminaire = iter.next();
			logMessage = methodName + " --- "
					+ " Setting the power for the luminaire: "
			        + luminaire.getId()
			        + " powerLevelPercent = " + luminaire.getPowerLevelPercent();
			int output = setLuminairePower(luminaire.getId()
					,luminaire.getPowerLevelPercent());
			logger.debug(logMessage);
	    }	
		logMessage = methodName + " <--- ";
		logger.debug(logMessage);
		return powerLevelEvent;
	}
	
	/**
	 * Sets the power level of a given luminaire.
	 * 
	 * @param int luminaireId
	 * @return int status of the execution
	 */
	private int setLuminairePower(int luminaireId, int powerLevelPercent) {
		String methodName = "setLuminairePower";
		String logMessage = null;
		
		logMessage = methodName + " ---> ";
		logger.debug(logMessage);
		
		int retVal = 1;
        String setLuminaireProcess = "";
		
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("/opt/LSS/lssi/lssi.properties"));	
			setLuminaireProcess = properties.getProperty("setLuminaireProcess");
			logger.info(" === property (setLuminaireProcess) = " + setLuminaireProcess);
 
    	} catch (IOException e) {
    		logger.error("Error **** properties file **** " + e.getMessage());
        }	
		
		// Executes the Unix shell script that updates the power level of a 
		// luminaire through the ies2rad Radiance program.
		// The power level is a number between 0 and 1 and is calculated as 
		// follows:
		//   powerLevel = powerLevelPercent / 100;
		//
		double powerLevel = 0.0;
		powerLevel = (double)powerLevelPercent / 100;
		DecimalFormat df = new DecimalFormat("#.#");
		powerLevel = Double.valueOf(df.format(powerLevel));
		Runtime r = Runtime.getRuntime();
		try {
			  Process p = r.exec(setLuminaireProcess 
			               + " " + luminaireId 
			               + " " + powerLevel);
			  logger.info("luminaire set: (id, powerLevel) = (" 
			               + luminaireId 
			               + ", " + powerLevel + ")");
			  try {
				  // Wait for the process
			      retVal = p.waitFor();
			  }
			  catch (InterruptedException e) {
				  logger.error(e.getMessage());
			  }
			}
			catch (IOException e) {
				logger.error(e.getMessage());
		   }	 
		logMessage = methodName + " <--- ";
		logger.debug(logMessage);
		return retVal;
	}	
	
}
