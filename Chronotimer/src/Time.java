import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {
	private static long startTime;
	private static long setTime;
	
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
	public static long getCurrentTime(){
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
	public static String convertRealTime(long time){
		// If given time is noted as -1, this indicates a 'Did not finish'
		if (time == -1) {
			return "DNF";
		}
		// If given time is noted as 0, this indicates a 'Still in progress'
		else if (time == 0){
			return "Still in progress";
		}
		else {
			String value;
			DateFormat formatter = new SimpleDateFormat("hh:mm:ss.SSS");
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(time - 6 * 3600000);
			value = formatter.format(calendar.getTime());
			value = value.substring(0, value.length()-1);
			
			return value;
		}
	}
	
	public static String convertTime(long time){
		// If given time is noted as -1, this indicates a 'Did not finish'
				if (time == -1) {
					return "DNF";
				}
				// If given time is noted as 0, this indicates a 'Still in progress'
				else if (time == 0){
					return "Still in progress";
				}
				else {
					String value;
					DateFormat formatter = new SimpleDateFormat("hh:mm:ss.SSS");
					Calendar calendar = Calendar.getInstance();
					calendar.setTimeInMillis(time - 6 * 3600000);
					value = formatter.format(calendar.getTime());
					value = value.substring(0, value.length()-1);
					value = value.substring(3, value.length());

					return value;
				}
	}
}