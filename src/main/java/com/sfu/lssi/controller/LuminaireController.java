package com.sfu.lssi.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.lssi.data.Sensor;
import com.sfu.lssi.data.Luminaire;




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
