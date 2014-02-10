/**
 * Sensor
 * --------------  Improve comment 
 */
package com.sfu.lssi.data;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;


/**
 * Sensor
 * 
 * @author Gaspare Boscarino
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
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
    @JsonProperty("illuminance_lux")
    public void setIlluminanceLux(double pIlluminanceLux) {
    	this.illuminanceLux = pIlluminanceLux;
    }
    
}
