public class Racer {
	
	private int bibNumber;
	private String time;
	
	public Racer(int bibNumber, String time) {
		this.bibNumber = bibNumber;
		this.time = time;
	}
	
	/**
	 * Gets this racer's bib number.
	 * 
	 * @return	Racer's unique bib number.
	 */
	public int getBib() {
		return this.bibNumber;
	}
	
	/**
	 * Updates the racer getting their bib number changed with the bib number the user entered (passed in as a parameter)
	 * 
	 * @param bib		The bib number entered by the user to set as the racer's bib number
	 */
	public void setBib(int bibNumber) {
		this.bibNumber = bibNumber;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
}