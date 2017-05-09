import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Stats {
	private LinkedList<Node> start;	// all the racers qued up to make their run
	private LinkedList<Node> end;	// all the racers currently completing their run
	private ArrayList<Racer> racers;	// all the racers currently in the run
	
	private class Node{
		private Racer racer;
		private long time;
		public Node(Racer racer, long time){
			this.racer = racer;
			this.time = time;
		}
	}
	
	public Stats(){
		start = new LinkedList<Node>();
		end = new LinkedList<Node>();
		racers = new ArrayList<Racer>();
	}
	
	/**
	 * The Array List of racers in the run containing any racer that is queued up, running, or completed their run.
	 * The List may be empty which means there are no racers currently in the run
	 * 
	 * @Return an ArrayList<Racer> of all the racers in the current run
	 */
	public ArrayList<Racer> getRacers(){
		return this.racers;
	}
	
	/**
	 * Linked List containing all the racers currently making their run in order from next to finish to farthest away from finishing
	 * The list may be empty to show that there are no racers currently making their run in the current run
	 * 
	 * @Return LinkedList<Node> of all the racers currently making their run
	 */
	public LinkedList<Node> getEndList(){
		return this.end;
	}
	
	/**
	 * For IND and GRP events the string will contain at most 1 bib number to symbolize the most recent finisher
	 * For PARIND events the string will contain at most 2 bib numbers for the most recent finished in both lanes
	 * The String could contain no bib numbers specifying that there are no currently finishers in the run at this moment
	 * 
	 * @Return a String with the racer(s) bib numbers that are the most recent finishers
	 */
	public String getLastToFinish(){
		if(end.isEmpty()){
			return null;
		}else{
			Node lastNode = end.getLast();
			int value = end.indexOf(lastNode);
			boolean pos = false;
			while(value >= 0 && pos == false){
				Racer last = end.get(value).racer;
				int bib = last.getBib();
				String bibS = Integer.toString(bib);
				long raceTime = getRaceTime(last);
				if(raceTime < 0){
					pos = false;
				}else{
					String raceTimeS = String.valueOf(raceTime);
					return bibS + ";" + raceTimeS;
				}
				value--;
			}
			return null;
		}
	}
	
	/**
	 * Return the start time for the racer that is passed in as a parameter. The racer must exist in the current run for their start
	 * time to be returned. The start time is stored as a long value and returned as the same
	 * 
	 * @Return -1 if there is no start time, otherwise return the time as a long value type
	 * @param racer		The racer one would like to get the start time associated with them
	 */
	public long getStart(Racer racer){
		Iterator<Node> it = start.iterator();
		while(it.hasNext()){
			Node tmp = it.next();
			if(racer == tmp.racer){
				return tmp.time;
			}
		}
		return -1; //return -1 if there is no start time for that racer
	}
	
	/**
	 * Add the racer that is starting their run to the start Linked List and set their time as the current system time
	 * 
	 * @param racer		The racer one would like to set the start time for
	 * @param time		The current time of the Chronotimer that one will set for the racer's start time to symbolize the racer starting the race
	 */
	public void setStart(Racer racer, long time){
		start.add(new Node(racer, time));
		racers.add(racer);
	}
	
	/**
	 * Cancel the most recent start of a racer's run and remove them from the currently making their run queue and move them to the front of the
	 * queue of racers waiting to take their runs. Way to fix a mistake in starting a racer who is not supposed to have started.
	 * 
	 * @param racer		The racer one would like to cancel and move them back to the pending queue of racers waiting to make their run
	 */
	public void cancel(Racer racer){
		Iterator<Node> it = start.iterator();
		while(it.hasNext()){
			Node tmp = it.next();
			if(racer == tmp.racer){
				it.remove();
				break;
			}
		}
		Iterator<Racer> it2 = racers.iterator();
		while(it2.hasNext()){
			Racer tmp2 = it2.next();
			if(racer == tmp2){
				it2.remove();
				break;
			}
		}
		Iterator<Node> it3 = end.iterator();
		while(it3.hasNext()){
			Node tmp3 = it3.next();
			if(racer == tmp3.racer){
				it3.remove();
				break;
			}
		}
	}
	
	/**
	 * 
	 * @Return -1 if that racer does not belong to the current run or has yet to complete their run and be assigned an end time
	 * If the racer does exist in the run and has completed their run their end time will be returned
	 * 
	 * @param racer		The racer that is getting their endtime returned as a Long value
	 */
	public long getEnd(Racer racer){
		Iterator<Node> it = end.iterator();
		while(it.hasNext()){
			Node tmp = it.next();
			if(racer == tmp.racer){
				return tmp.time;
			}
		}
		return -1; //return -1 if there is no end time for that racer
	}
	
	/**
	 * Setting the end time for a racer who has just completed their run
	 * 
	 * @param racer		The racer that has just completed their run and needs to be assigned the current time of the chronotimer to be set as their endTime
	 * @param time		The current time set for the Chronotimer System
	 */
	public void setEnd(Racer racer, long time){
		Iterator<Node> it = end.iterator();
		boolean removed = false;	// new to not get a concurrent modification exception when all racers in the run are running
		while(it.hasNext() && removed == false){	// new 2nd condition to prevent concurrent modification exception
			Node tmp = it.next();
			if(racer == tmp.racer){
				end.remove(tmp);
				removed = true;	// new	to prevent concurrent modification exception
			}
		}
		end.add(new Node(racer, time));
	}
	
	/**
	 * Get the current time it took the racer to complete their run and return that value
	 * 
	 * @Return -1 if the racer in the parameter does not exist in this run, else return their race time
	 * @param racer		The racer for which their end time was requested
	 */
	public long getRaceTime(Racer racer) {
		long raceTime = -1;
		if ((this.getStart(racer) != -1) && (this.getEnd(racer) != -1)) {
			raceTime = this.getEnd(racer) - this.getStart(racer);
		}
		return raceTime;
	}
	
	
	/**
	 * If there are at least 2 racers currently making their runs the next to finish and the 2nd to next to finish will be swapped so that they are not in the queue in opposite order
	 * When the finish/DNF command is called next the 2nd to last racer previously before the method will be assigned the DNF or end time
	 * 
	 * @Return True if the swap was successful and False otherwise
	 */
	public boolean swapRacers(){
		
		int i = 0;
		while(i < racers.size()){
			if(getEnd(racers.get(i)) == 0){
				break;
			}
			i++;
		}

		if(i > (racers.size() - 1) || (i+1) > (racers.size() - 1)){
			return false;
		}else{
			Racer first = racers.get(i);
			Racer second = racers.get(i+1);
			racers.set(i, second);
			racers.set(i+1, first);
			return true;
		}
	}
}