/**
 * SensorList
 * ----- Add comment here
 */
package com.sfu.lssi.data;

import org.codehaus.jackson.annotate.JsonProperty;
import com.sfu.lssi.data.Payload;
import com.sfu.lssi.data.IlluminanceSensor;


/**
 * Sensor
 * 
 * @author Gaspare Boscarino
 */
public class IlluminanceSensorList extends Payload {
	
    @JsonProperty("id")
    protected int id = 0;
 
    @JsonProperty("number_of_sensors")
    protected int numberOfSensors = 0;
    
    @JsonProperty("sensor_array")
    protected IlluminanceSensor sensorArray[];   // The list of the sensors
    
    
    public IlluminanceSensorList() {}
	
    
    // ------------------------------------------------------------------------
    // Getters
    // ------------------------------------------------------------------------
    @JsonProperty("id")
    public int getId() {
        return id;
    }
    
    @JsonProperty("number_of_sensors")
    public int getNumberOfSensors() {
        return numberOfSensors;
    }
    
    
    
    
    // ------------------------------------------------------------------------
    // Setters
    // ------------------------------------------------------------------------
    @JsonProperty("id")
    public void setId(int sensorlistId) {
    	this.id = sensorlistId;
    }

   @JsonProperty("pNumberOfSensors")
    public void setNumberOfSensors(int pNumberOfSensors) {
    	this.numberOfSensors = pNumberOfSensors;
    }
    
    
    /**
     * Set the content of the sensor list
     * @param 
     */
    @JsonProperty("sensor_array")
    public void setSensorArray (IlluminanceSensor[] pIllSensorArray) {
        sensorArray = pIllSensorArray;
    }
  
}
