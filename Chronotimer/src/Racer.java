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