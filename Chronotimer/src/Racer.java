public class Racer {
	private int bib;
	
	public Racer(int bib){
		this.bib = bib;
	}
	
	/**
	 * Gets this racer's bib number.
	 * 
	 * @return	Racer's unique bib number.
	 */
	public int getBib(){
		return this.bib;
	}
	
	/**
	 * Updates the racer getting their bib number changed with the bib number the user entered (passed in as a parameter)
	 * 
	 * @param bib		The bib number entered by the user to set as the racer's bib number
	 */
	public void setBib(int bib){
		this.bib = bib;
	}
}