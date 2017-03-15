import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.soap.Node;

public class Run {
	private LinkedList<Racer> beginQueue;
	private LinkedList<Racer> endQueue;
	private Stats stats;
	private boolean individual;
	private boolean parallel;
	
	public Run(boolean individual, boolean parallel){
		beginQueue = new LinkedList<Racer>();
		endQueue = new LinkedList<Racer>();
		stats = new Stats();
		this.individual = individual;
		this.parallel = parallel;
	}
	
	/**
	 * Returns list of racers in line to start their runs.
	 * 
	 * @return	LinkedList of racers yet to start.
	 */
	public LinkedList<Racer> getBeginQueue(){
		return this.beginQueue;
	}
	
	/**
	 * Returns list of racers in order that they finished.
	 * 
	 * @return	LinkedList of racers that have finished.
	 */
	public LinkedList<Racer> getEndQueue(){
		return this.endQueue;
	}
	
	/**
	 * Gets stats for this run.
	 * 
	 * @return	Stats pertaining to this particular run.
	 */
	public Stats getStats(){
		return this.stats;
	}
	
	/**
	 * Adds a racer to the queue at the starting line.
	 * 
	 * @param racer	Racer to be added to the line-up.
	 */
	public void addRacer(Racer racer){
		beginQueue.addLast(racer);
	}
	
	/**
	 * Starts the run for the next racer in line, removing them from the 'start' line to the 'finish' line.
	 * 
	 * @param time	Current time used to mark racer's 'Start time'
	 * @return	True if successful, False otherwise
	 */
	public boolean startRacer(long time){
		if(beginQueue.isEmpty()){
			return false;
		}
		// Remove racer from begin queue, add to end queue, set end to pending and start to current time
		Racer racer = beginQueue.removeFirst();
		endQueue.addLast(racer);
		stats.setEnd(racer, 0);
		stats.setStart(racer, time);
		return true;
	}
	
	/**
	 * Ends the run for the current racer on the track and sets their end time accordingly.
	 * 
	 * @param time	Current time to mark the racer's 'End time'
	 * @return	True if successful, False otherwise
	 */
	public boolean endRacer(long time){
		// If no one is currently racing, return false
		if(endQueue.isEmpty()){
			return false;
		}
		Racer racer = endQueue.removeFirst();
		stats.setEnd(racer, time);
		return true;
	}
	
	/**
	 * Cancels the current racer's attempt (due to fault, miscue, etc.) and puts him or her back in line to start.
	 */
	public void cancel(){
		if(endQueue.isEmpty()){
			return;
		}
		Racer tmp = endQueue.removeLast();
		beginQueue.addFirst(tmp);
	}
	
	/**
	 * Marks the current racer with a 'Did Not Finish' status and removes them from the run.
	 */
	public void didNotFinish(){
		Racer tmp = endQueue.remove();
		// Denotes 'Did Not Finish' within racer's stats in the run
		stats.setEnd(tmp, -1);
	}

	/**
	 * Sets the type of the next event to be held.
	 * 
	 * @param individual	True if inidividual type race, False if group
	 * @param parallel	True if parallel races, False if in series
	 */
	public void setEvent(boolean individual, boolean parallel) {
		this.individual = individual;
		this.parallel = parallel;
	}
	
	/**
	 * *
	 * @param testNum
	 * @return True if bib number not already in the run or false if otherwise
	 */
	public boolean numExistsInRun(String testNum){
		boolean dne = true;
		int testNumInt = Integer.parseInt(testNum);
		Iterator<Racer> it = beginQueue.iterator();
		while(it.hasNext()){
			Racer temp = it.next();
			int tempBib = temp.getBib();
			if(tempBib == testNumInt){
				dne = false;
				break;
			}
		}
		
		if(dne == true){
			Iterator<Racer> it2 = beginQueue.iterator();
			while(it2.hasNext()){
				Racer temp = it2.next();
				int tempBib = temp.getBib();
				if(tempBib == testNumInt){
					dne = false;
					break;
				}
			}
		}
		
		if(dne == true){
			return true;
		}else{
			return false;
		}
		
	}
}