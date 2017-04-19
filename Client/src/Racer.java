public class Racer implements Comparable<Object>{
	
	private String bibNumber;
	private String time;
	
	public Racer(String bibNumber, String time) {
		this.bibNumber = bibNumber;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return bibNumber + " has race time of " + time;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Racer) {
			Racer other = (Racer) o;
			return bibNumber.compareTo(other.bibNumber);
		}
		return 0;
	}

}
