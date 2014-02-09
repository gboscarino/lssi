/**
 * Luminaire
 */
package com.sfu.lssi.data;

import org.codehaus.jackson.annotate.JsonProperty;

import com.sfu.lssi.data.Payload;

/**
 * Sensor
 * 
 * @author Gaspare Boscarino
 */
public class Luminaire extends Payload {
	
    @JsonProperty("id")
    protected int id = 0;

    @JsonProperty("state")
    protected String state;

    
    
    public Luminaire() {}
	
    /**
     * Get the ID of this luminaire.
     * 
     * @return The ID of this luminaire
     */
    @JsonProperty("id")
    public int getId() {
        return id;
    }
    
    /**
     * Set the id of the luminaire.
     * @param sensorId
     */
    @JsonProperty("id")
    public void setId(int sensorId) {
    	this.id = sensorId;
    }

    /**
     * Get the status of the luminaire.
     * @return Get the status of the luminaire.
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * Set the state of the luminaire
     * @param 
     */
    @JsonProperty("state")
    public void setState(String luminaireState) {
        state = luminaireState;
    }
  
}
