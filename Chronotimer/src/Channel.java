public class Channel {//test
	private boolean start;
	private boolean on;
	
	public Channel(boolean start, boolean on){
		this.start = start;
		this.on = on;
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