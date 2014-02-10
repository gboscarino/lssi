package com.sfu.lssi.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sfu.lssi.data.IlluminanceSensor;
import com.sfu.lssi.data.Payload;
import com.sfu.lssi.data.IlluminanceSensorList;
import com.sfu.lssi.data.PowerLevelEvent;
import com.sfu.lssi.service.IlluminanceSensorService;

import java.io.*;
import java.util.ArrayList;

/**
 * @author
 *
 */
@Controller
public class IlluminanceSensorController {
	
	private static final Logger logger = Logger.getLogger(IlluminanceSensorController.class);
	private IlluminanceSensorService illuminanceSensorService; 
	
	@Inject
	public IlluminanceSensorController(IlluminanceSensorService pIlluminanceSensorService) {
		this.illuminanceSensorService = pIlluminanceSensorService;
	}
	
	//private IlluminanceSensorListResolver resolver;
	//public IlluminanceSensorListResolver getResolver() { return this.resolver; }
	//public void setResolver(IlluminanceSensorListResolver resolver) { this.resolver = resolver; }
	
	/**
	 * Method to resolve a sensor list based on the sensorListId.
	 * 
	 * --- modify this method
	 * 
	 * @param sensorid The id of the sensor.
	 * @return The sensor object.
	 */
	@RequestMapping(value = "/illumsensorlists/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public IlluminanceSensorList getIlluminanceSensorValues(@PathVariable("id") int id) {
		
		String methodName = "getIlluminanceSensorValues";
		String logMessage = null;
	
		logMessage = methodName + " ---> ";
		logger.debug(logMessage);
		
		IlluminanceSensorList retVal = new IlluminanceSensorList();
		try {
			retVal = illuminanceSensorService.getIlluminanceSensorValues(id);
			retVal.setRequestStatus(Payload.OK);
			logger.debug("Retrieving the sensor list data ....");
		}
		catch (Exception e) {
				logMessage = methodName + " *** Error " 
				     + e.getMessage().toString();
				logger.error(logMessage);
				throw e;
		}
		
		/**
		IlluminanceSensorList retVal = getResolver().getSensorListById(id);
		if(retVal == null) {
			retVal = new IlluminanceSensorList();
			retVal.setStatus(Payload.NODATA);
			retVal.setErrorMessage("getSensor: Couldn't find sensor list for id " + id + ".");
		} else {
			retVal.setStatus(Payload.OK);
		}
		*/
		
		logMessage = methodName + " <--- ";
		logger.debug(logMessage);
		return retVal;
	}
    
    
}
