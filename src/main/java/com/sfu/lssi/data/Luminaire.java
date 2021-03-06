/**
 * Luminaire
 */
package com.sfu.lssi.data;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.sfu.lssi.data.Payload;

/**
 * Sensor
 * 
 * @author Gaspare Boscarino
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Luminaire {
	
    @JsonProperty("id")
    protected int id = 0;

    @JsonProperty("power_level_percent")
    protected int powerLevelPercent = 0;
    
    
    public Luminaire() {}
	
    
    // ------------------------------------------------------------------------
    // Getters
    // ------------------------------------------------------------------------
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("power_level_percent")
    public int getPowerLevelPercent() {
        return powerLevelPercent;
    }
    
    
    // ------------------------------------------------------------------------
    // Setters
    // ------------------------------------------------------------------------
    @JsonProperty("id")
    public void setId(int sensorId) {
    	this.id = sensorId;
    }

    @JsonProperty("power_level_percent")
    public void setPowerLevelPercent(int pPowerLevelPercent) {
    	this.powerLevelPercent = pPowerLevelPercent;
    }
  
}
