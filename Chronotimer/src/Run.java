import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.soap.Node;

public class Run {
	private LinkedList<Racer> beginQueue;
	private LinkedList<Racer> endQueue;
	private Stats stats;
	private boolean individual;
	private boolean parallel;
	
	// Added fields for parallel races
	private LinkedList<Racer> pendingQueue12;
	private LinkedList<Racer> pendingQueue34;
	private LinkedList<Racer> pendingQueue56;
	private LinkedList<Racer> pendingQueue78;
	private boolean[] usedLanes;
	
	// added for export functionality
	private int runNumber;
	
	
	public Run(boolean individual, boolean parallel, int runNumInput){
		beginQueue = new LinkedList<Racer>();
		endQueue = new LinkedList<Racer>();
		stats = new Stats();
		this.individual = individual;
		this.parallel = parallel;
		
		runNumber = runNumInput;
		
		if(parallel == true && individual == false){
			pendingQueue12 = new LinkedList<Racer>();
			pendingQueue34 = new LinkedList<Racer>();
			pendingQueue56 = new LinkedList<Racer>();
			pendingQueue78 = new LinkedList<Racer>();
			usedLanes = new boolean[4];
			for(int i = 0; i < 4; i++){
				usedLanes[i] = false;
			}
		}
	}
	
	/**
	 * 
	 * @return the run Number associated with the run
	 */
	public int getRunNumber(){
		return runNumber;
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
	 * 
	 * @return event type abbreviation of the event the run is
	 */
	public String getEventType(){
		if(individual == true){
			return "IND";
		}else if(parallel == true){
			return "PARIND";
		}else{
			return null;
		}
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
	public boolean startRacer(long time, int sensorNum){
		if(beginQueue.isEmpty()){
			return false;
		}
		
		if(individual == true){
			// Remove racer from begin queue, add to end queue, set end to pending and start to current time
			Racer racer = beginQueue.removeFirst();
			endQueue.addLast(racer);
			stats.setEnd(racer, 0);
			stats.setStart(racer, time);
			return true;
		}else if(parallel == true){
			Racer racer = beginQueue.removeFirst();
			
			if(sensorNum == 1){
				int counter = 0;
				if(usedLanes[0] == false){
					for(int i = 0; i < 4; i++){
						if(usedLanes[i] == true){
							if(usedLanes[i] == true){
								counter++;
							}
						}
					}
				}
				if(usedLanes[0] == true || counter < 2){
					pendingQueue12.addLast(racer);
					endQueue.addLast(racer);
					stats.setEnd(racer, 0);
					stats.setStart(racer, time);
					usedLanes[0] = true;
					return true;
				}else{
					return false;
				}
			}else if(sensorNum == 3){
				int counter = 0;
				if(usedLanes[1] == false){
					for(int i = 0; i < 4; i++){
						if(usedLanes[i] == true){
							counter++;
						}
					}
				}
				if(usedLanes[1] == true || counter < 2){
					pendingQueue34.addLast(racer);
					endQueue.addLast(racer);
					stats.setEnd(racer, 0);
					stats.setStart(racer, time);
					usedLanes[1] = true;
					return true;
				}else{
					return false;
				}
			}else if(sensorNum == 5){
				int counter = 0;
				if(usedLanes[2] == false){
					for(int i = 0; i < 4; i++){
						if(usedLanes[i] == true){
							counter++;
						}
					}
				}
				if(usedLanes[2] == true || counter < 2){
					pendingQueue56.addLast(racer);
					endQueue.addLast(racer);
					stats.setEnd(racer, 0);
					stats.setStart(racer, time);
					usedLanes[2] = true;
					return true;
				}else{
					return false;
				}
			}else if(sensorNum == 7){
				int counter = 0;
				if(usedLanes[3] == false){
					for(int i = 0; i < 4; i++){
						if(usedLanes[i] == true){
							counter++;
						}
					}
				}
				if(usedLanes[3] == true || counter < 2){
					pendingQueue78.addLast(racer);
					endQueue.addLast(racer);
					stats.setEnd(racer, 0);
					stats.setStart(racer, time);
					usedLanes[3] = true;
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{	// expand when implement new race types
			return false;
		}
	}
	
	/**
	 * Ends the run for the current racer on the track and sets their end time accordingly.
	 * 
	 * @param time	Current time to mark the racer's 'End time'
	 * @return	True if successful, False otherwise
	 */
	public boolean endRacer(long time, int sensorNum){
		// If no one is currently racing, return false
		
		if(individual == true){
			if(endQueue.isEmpty()){
				return false;
			}
			Racer racer = endQueue.removeFirst();
			stats.setEnd(racer, time);
			return true;
		}else if(parallel == true){
			if(sensorNum == 2){
				if(usedLanes[0] == true){
					if(pendingQueue12.isEmpty() != true){
						Racer racer = pendingQueue12.removeFirst();
						stats.setEnd(racer, time);
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else if(sensorNum == 4){
				if(usedLanes[1] == true){
					if(pendingQueue34.isEmpty() != true){
						Racer racer = pendingQueue34.removeFirst();
						stats.setEnd(racer, time);
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else if(sensorNum == 6){
				if(usedLanes[2] == true){
					if(pendingQueue56.isEmpty() != true){
						Racer racer = pendingQueue56.removeFirst();
						stats.setEnd(racer, time);
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else if(sensorNum == 8){
				if(usedLanes[3] == true){
					if(pendingQueue78.isEmpty() != true){
						Racer racer = pendingQueue78.removeFirst();
						stats.setEnd(racer, time);
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
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
	public boolean didNotFinish(){
		if(individual == true){
			if(endQueue.isEmpty() == false){
				Racer tmp = endQueue.remove();
				// Denotes 'Did Not Finish' within racer's stats in the run
				stats.setEnd(tmp, -1);
				return true;
			}else{
				return false;
			}
		}else if(parallel == true){
			// No Active Racers
			if(endQueue.isEmpty() == false){
				Racer tmp = endQueue.remove();
				if(pendingQueue12.contains(tmp) == true){
					pendingQueue12.removeFirst();
					stats.setEnd(tmp, -1);
					return true;
				}else if(pendingQueue34.contains(tmp) == true){
					pendingQueue34.removeFirst();
					stats.setEnd(tmp, -1);
					return true;
				}else if(pendingQueue56.contains(tmp) == true){
					pendingQueue56.removeFirst();
					stats.setEnd(tmp, -1);
					return true;
				}else if(pendingQueue78.contains(tmp) == true){
					pendingQueue78.removeFirst();
					stats.setEnd(tmp, -1);
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
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