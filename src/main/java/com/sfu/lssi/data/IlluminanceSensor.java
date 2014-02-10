/**
 * Sensor
 * --------------  Improve comment 
 */
package com.sfu.lssi.data;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * Sensor
 * 
 * @author Gaspare Boscarino
 */
public class IlluminanceSensor extends Sensor {
	
    @JsonProperty("illuminance_lux")
    protected double illuminanceLux = 0.0;

    public IlluminanceSensor() {}
	
    // ------------------------------------------------------------------------
    // Getters
    // ------------------------------------------------------------------------
    @JsonProperty("illuminance_lux")
    public double getIlluminanceLux() {
        return illuminanceLux;
    }
  
    
    // ------------------------------------------------------------------------
    // Setters
    // ------------------------------------------------------------------------
    @JsonProperty("id")
    public void setIlluminanceLux(double pIlluminanceLux) {
    	this.illuminanceLux = pIlluminanceLux;
    }
    
}
