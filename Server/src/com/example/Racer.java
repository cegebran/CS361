package com.example;

public class Racer implements Comparable<Object>{
	
	private String bibNumber;
	private String time;
	
	public Racer(String bibNumber, String time) {
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
			long[] thisarray = new long[3];
			thisarray[0] = Long.parseLong(thisstringTimeArray[0]);
			thisarray[1] = Long.parseLong(thisstringTimeArray[1]);
			double thisd = Double.parseDouble(thisstringTimeArray[2]);
			long thistmp = (long) thisd;
			thisarray[2] = thistmp;
			long thistotaltime = 3600000 * thisarray[0] + 60000 * thisarray[1] + 1000 * thisarray[2];
			
			String[] otherstringTimeArray = time.split(":");
			long[] otherarray = new long[3];
			otherarray[0] = Long.parseLong(otherstringTimeArray[0]);
			otherarray[1] = Long.parseLong(otherstringTimeArray[1]);
			double otherd = Double.parseDouble(otherstringTimeArray[2]);
			long othertmp = (long) otherd;
			otherarray[2] = othertmp;
			long othertotaltime = 3600000 * thisarray[0] + 60000 * thisarray[1] + 1000 * thisarray[2];

			return (int) (othertotaltime - thistotaltime);
		}
		return 0;
	}

	public String getBibNumber(){
		return bibNumber;
	}
	
	public String getTime(){
		return time;
	}
}
