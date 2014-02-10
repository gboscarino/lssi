/**
 * SensorList
 * ----- Add comment here
 */
package com.sfu.lssi.data;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.*;

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
    protected ArrayList<IlluminanceSensor> sensorArray; 
    
    
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
    
    @JsonProperty("sensor_array")
    public ArrayList<IlluminanceSensor> getSensorArray() {
        return sensorArray;
    }
    
    
    // ------------------------------------------------------------------------
    // Setters
    // ------------------------------------------------------------------------
    @JsonProperty("id")
    public void setId(int sensorlistId) {
    	this.id = sensorlistId;
    }

    @JsonProperty("number_of_sensors")
    public void setNumberOfSensors(int pNumberOfSensors) {
    	this.numberOfSensors = pNumberOfSensors;
    }
    
    @JsonProperty("sensor_array")
    public void setSensorArray (ArrayList<IlluminanceSensor> pSensorArray) {
        sensorArray = pSensorArray;
    }
  
}
