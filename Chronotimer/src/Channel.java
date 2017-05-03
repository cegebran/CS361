public class Channel {//testing
	// boolean values to determine if a sensor is a start/finish and on/off
	private boolean start;
	private boolean on;
	
	private boolean connectedSensor;
	
	public Channel(boolean start, boolean on){
		this.start = start;
		this.on = on;
		this.connectedSensor = false;
	}
	
	/**
	 * Returns whether the sensor is connected or not as a boolean T/F value
	 * 
	 * @return	True if the sensor is a connected sensor and False otherwise
	 */
	public boolean getConnectedSensor(){
		if(connectedSensor == false){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * Changes the status of the sensor to connected/disconnected depending on the state the sensor was in previously
	 * 
	 * @return	True if successful connection of the sensor made and false otherwise
	 */
	public boolean connectSensor(){
		if(connectedSensor == false){
			connectedSensor = true;
			return true;
		}else{
			connectedSensor = false;
			return false;
		}
	}
	
	/**
	 * Changes the usage of this channel from being a 'Start' to a 'Finish' detector, or vice versa.
	 * 
	 * @return	True if the channel was changed to read 'Start' sensors, False if changed to read 'End' sensors.
	 */
	public boolean state(){
		this.start = !start;
		return start;
	}
	
	/**
	 * Changes the channel from 'Active' to 'Passive', or vice versa.
	 * 
	 * @return True if the channel was off but is now on, False otherwise.
	 */
	public boolean toggle(){
		this.on = !on;
		return on;
	}
	
	/**
	 * Returns whether or not the channel is sensing for the 'Start' or 'Finish' of a race.
	 * 
	 * @return	True if the channel is being used for detecting the start of a race, False if detecting the end.
	 */
	public boolean getStart(){
		return this.start;
	}
	
	/**
	 * Returns whether or not the channel is actively marking starts of/ends to a race.
	 * 
	 * @return	True is the channel is active, False if passive.
	 */
	public boolean getOn(){
		return this.on;
	}
}