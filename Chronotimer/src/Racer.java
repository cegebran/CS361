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
	
	public void setBib(int bib){
		this.bib = bib;
	}
}