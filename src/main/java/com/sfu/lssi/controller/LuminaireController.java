package com.sfu.lssi.controller;



import javax.inject.Inject;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sfu.lssi.data.PowerLevelEvent;
import com.sfu.lssi.data.Payload;
import com.sfu.lssi.service.LuminaireService;




/**
 * @author
 *
 */
@Controller
public class LuminaireController {
	
	private static final Logger logger = Logger.getLogger(LuminaireController.class);
	private LuminaireService luminaireService;
	
	@Inject
	public LuminaireController(LuminaireService pLuminaireService ) {
		this.luminaireService = pLuminaireService;
	}

	/**
	 * Method to create a new power level event.
	 * 
	 * The event is used to change the power level of a set of luminaires 
	 * (light fixtures).
	 * 
	 * @param  PowerLevelEvent The power event level object.
	 * @return PowerLevelEvent The power event level object.
	 * @throws Exception 
	 * 
	 */
    @RequestMapping(value = "/power_level_events", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PowerLevelEvent createPowerLevelEvent (@RequestBody PowerLevelEvent powerLevelEvent) 
    		throws Exception  {
    	
		String methodName = "createPowerLevelEvent";
		String logMessage = null;
	
		logMessage = methodName + " ---> ";
		logger.debug(logMessage);
		
		logMessage = methodName + " --- Creating a new event ";	
		logger.debug(logMessage);
		
		PowerLevelEvent retVal = new PowerLevelEvent();	
		
		// Creates the new event
		try {
			logMessage = methodName + " --- "
					+ " creating the new event ";
			logger.debug(logMessage);
			retVal = luminaireService.createPowerLevelEvent(powerLevelEvent);
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

}
