public class Time {
	private long startTime;
	private long setTime;
	
	public Time(){
		this.startTime = System.currentTimeMillis();
		// Default time is set to midnight whenever powered on
		setTime("0:0:0");
	}

	/**
	 * "Sets the time" by retrieving user input to use for offsetting future time stamps from the machine's
	 * system clock.
	 * 
	 * @param time	User's time input, parsed by ":"
	 */
	public void setTime(String time){
		// Get current machine time for reference
		this.startTime = System.currentTimeMillis();
		
		// Retrieve user input for time, accurate to the hundredth of a second
		String[] stringTimeArray = time.split(":");
		long[] array = new long[3];
		array[0] = Long.parseLong(stringTimeArray[0]);
		array[1] = Long.parseLong(stringTimeArray[1]);
		double d = Double.parseDouble(stringTimeArray[2]);
		long tmp = (long) d;
		array[2] = tmp;
		// Get user's time for offset from machine clock
		this.setTime = 3600000 * array[0] + 60000 * array[1] + 1000 * array[2];
	}
	
	/**
	 * Returns the current time, accurate to the hundredth of a second, in respect to the standardized time
	 * based on the user's set time.
	 * 
	 * @return	Current time in milliseconds
	 */
	public long getCurrentTime(){
		long currentTime = System.currentTimeMillis();
		long elapsedTime = currentTime - startTime;
		return setTime + elapsedTime;
	}
	
	/**
	 * Outputs the given time into a formatted string of a standard clock reading.
	 * 
	 * @param time	Time in milliseconds
	 * @return	String of style "HH:MM:SS.LL", where H = Hours, M = Minutes, S = Seconds, L = Hundredths of a second
	 */
	public static String convertTime(long time){
		int[] out = new int[]{0, 0, 0, 0};
		// If given time is noted as -1, this indicates a 'Did not finish'
		if (time == -1) {
			return "DNF";
		}
		// If given time is noted as 0, this indicates a 'Still in progress'
		else if (time == 0){
			return "Still in progress";
		}
		else {
			// Divvy up milliseconds into each respective time span, from hours to hundredths of a second
			out[0] = (int)(time / 3600000);
			out[1] = (int)(time / 60000) % 60;
			out[2] = (int)(time / 1000) % 60;
			out[3] = (int)(time) % 1000;
			String out3 = Integer.toString(out[3]);
			char one = out3.charAt(0);
			char two;
			try{
				two = out3.charAt(1);
			}catch(StringIndexOutOfBoundsException e){
				two = '0';
			}
			out3 = Character.toString(one) + Character.toString(two);

			// Outputs string in specific HH:MM:SS.LL format
			String value = String.format("%02d:%02d:%02d", out[0], out[1], out[2]) + "." + out3;
			return value;
		}
	}
}