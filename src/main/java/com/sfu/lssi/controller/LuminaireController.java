package com.sfu.lssi.controller;


import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sfu.lssi.data.Event;
//import com.lssi.data.Sensor;
import com.sfu.lssi.data.Luminaire;
import com.sfu.lssi.data.Payload;




/**
 * @author
 *
 */
@Controller
public class LuminaireController {
	
	private static final Logger logger = Logger.getLogger(LuminaireController.class);
	
	public LuminaireController() {
	}
	
	//private LuminaireResolver resolver;
	//public LuminaireResolver getResolver() { return this.resolver; }
	//public void setResolver(LuminaireResolver resolver) { this.resolver = resolver; }
	
	
	/**
	 * Method to create a new client.
	 * 
	 * @param  The client object
	 * @return The Client object (only the client bKey).
	 * @throws Exception 
	 * 
	 */
    @RequestMapping(value = "/events", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Event createEvent (@RequestBody Event event) throws Exception  {
    	
		String methodName = "createEvent";
		String logMessage = null;
	
		logMessage = methodName + " ---> ";
		logger.debug(logMessage);
		
		logMessage = methodName + " --- Creating a new event ";	
		logger.debug(logMessage);
		
		Event retVal = new Event();	
		
		// Creates the new event
		try {
			logMessage = methodName + " --- "
					+ " creating the new event "
			        + event.getId();
			
			////// CONTINUE ////
			
			logger.debug(logMessage);
			
			retVal.setRequestStatus(Payload.CREATED);
		}
		catch (Exception e) {
			logMessage = methodName + " *** "
					+ " Error while adding a new client "
		            + e.getMessage().toString();
			logger.error(logMessage);
			throw e;			
		}
		logMessage = methodName + " ---< ";
		logger.debug(logMessage);
		return retVal;
    }
	
	
	
	/**
	 * Method to change the status of a given luminaire by setting 
	 * the R,B, and B values.
	 * Persist the values (input parameters) in a file.
	 * --- improve description ...
	 * 
	 * @param luminaireId The id of the luminaire.
	 * @return 
	 */
    @RequestMapping(value = "/luminaires", method = RequestMethod.POST)
    @ResponseBody
    public Luminaire setLuminaire(@RequestParam("id")   int id
    		                    , @RequestParam("rval") int rVal
                                , @RequestParam("gval") int gVal
    		                    , @RequestParam("bval") int bVal)
    {
         
    	
    	String methodName = "setLuminaire";
		String logMessage = null;
	
		logMessage = methodName + " ---> ";
		logger.debug(logMessage);
		
    	int retVal = 0;
    	Luminaire retLuminaire = new Luminaire();
    	retLuminaire.setId(id);
    	retLuminaire.setState("WORKING");
    	// Set the R,G, and B values
    	// Improve
    	// 
        //retVal = getResolver().setLuminaire(id, rVal, gVal, bVal);
    	
        logMessage = methodName + " <--- ";
		logger.debug(logMessage);
        return retLuminaire;
    }
}
