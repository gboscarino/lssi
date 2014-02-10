/**
 * Sensor
 */
package com.sfu.lssi.data;

import org.codehaus.jackson.annotate.JsonProperty;
import com.sfu.lssi.data.Payload;


//import javax.vecmath.Point3d;
//import javax.vecmath.Tuple3d;
//import javax.vecmath.*;



/**
 * Sensor
 * 
 * @author Gaspare Boscarino
 */
public class Sensor extends Payload {
	
    @JsonProperty("id")
    protected int id = 0;

    // Position of the sensor
    //@JsonProperty("position")
    //protected Point3d position;
    @JsonProperty("position_x")
    protected double positionX;
    
    @JsonProperty("position_y")
    protected double positionY;
    
    @JsonProperty("position_z")
    protected double positionZ;

    public Sensor() {}
	
    /**
     * Get the ID of this sensor.
     * 
     * @return The ID of this sensor
     */
    @JsonProperty("id")
    public int getId() {
        return id;
    }
    
    /**
     * Set the id of the sensor.
     * @param sensorId
     */
    @JsonProperty("id")
    public void setId(int sensorId) {
    	this.id = sensorId;
    }
    
    /**
     * Get the X position of this sensor.
     * 
     * @return The position (x,y,z) of this sensor.
     */
    @JsonProperty("position_x")
    public double getPositionX() {
        return positionX;
    }

    /**
     * Get the Y position of this sensor.
     * 
     * @return The position (x,y,z) of this sensor.
     */
    @JsonProperty("position_y")
    public double getPositionY() {
        return positionY;
    }
    
    /**
     * Get the Z position of this sensor.
     * 
     * @return The position (x,y,z) of this sensor.
     */
    @JsonProperty("position_z")
    public double getPositionZ() {
        return positionZ;
    }
    
    
    /**
     * Set the position of this sensor.
     * 
     * @return The position (x,y,z) of this sensor.
     */
    @JsonProperty("position")
    public void setPosition(double x, double y, double z) {
    	this.positionX = x;
    	this.positionY = y;
    	this.positionZ = z;
    }
    
}
