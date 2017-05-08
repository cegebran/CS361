package com.example;

public class Racer implements Comparable<Object>{
	
	private int bibNumber;
	private String time;
	
	public Racer(int bibNumber, String time) {
		this.bibNumber = bibNumber;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return bibNumber + " has a time of " + time;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Racer) {
			Racer other = (Racer) o;
			
			if(time.equals("DNF")){
				return Integer.MAX_VALUE;
			}
			else if(other.getTime().equals("DNF")){
				return Integer.MIN_VALUE;
			}
			
			String[] thisstringTimeArray = time.split(":");
			long[] thisarray = new long[2];
			thisarray[0] = Long.parseLong(thisstringTimeArray[0]);
			double thisd = Double.parseDouble(thisstringTimeArray[1]);
			long thistmp = (long) thisd;
			thisarray[1] = thistmp;
			long thistotaltime = (thisarray[0] * 60000) + (thisarray[1] * 1000);
			
			String[] otherstringTimeArray = ((Racer) o).getTime().split(":");
			long[] otherarray = new long[2];
			otherarray[0] = Long.parseLong(otherstringTimeArray[0]);
			double otherd = Double.parseDouble(otherstringTimeArray[1]);
			long othertmp = (long) otherd;
			otherarray[1] = othertmp;
			long othertotaltime = (60000 * otherarray[0]) + (1000 * otherarray[1]);
			return (int) (thistotaltime - othertotaltime);
			
		}
		return 0;
	}

	/**
	 * Returns the racer's bib number.
	 * 
	 * @return	Racer's bib number (as String)
	 */
	public String getBibNumber() {
		
		return Integer.toString(bibNumber);
		
	}
	
	/**
	 * Returns the racer's total race time for most recent run.
	 * 
	 * @return	Racer's time (as formatted HH:MM:SS String)
	 */
	public String getTime() {
		
		return time;
		
	}
	
}
