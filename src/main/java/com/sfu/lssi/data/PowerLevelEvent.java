/**
 * Event
 */
package com.sfu.lssi.data;

import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonProperty;
import com.sfu.lssi.data.Luminaire;
import com.sfu.lssi.data.Payload;

public class PowerLevelEvent extends Payload {
	
    @JsonProperty("id")
    protected int id = 0;


    @JsonProperty("luminaire_array")
    protected ArrayList<Luminaire> luminaireArray;
    
    
    public PowerLevelEvent() {}
	
    
    // ------------------------------------------------------------------------
    // Getters
    // ------------------------------------------------------------------------
    @JsonProperty("id")
    public int getId() {
        return id;
    }
    
    @JsonProperty("luminaire_array")
    public ArrayList<Luminaire> getLuminaireArray () {
    	return luminaireArray;
    }
    
    // ------------------------------------------------------------------------
    // Setters
    // ------------------------------------------------------------------------
    @JsonProperty("id")
    public void setId(int sensorId) {
    	this.id = sensorId;
    }
    
    @JsonProperty("luminaire_array")
    public void setLuminaireArray (ArrayList<Luminaire> pLuminaireArray) {
    	luminaireArray = pLuminaireArray;
    }
  
}
