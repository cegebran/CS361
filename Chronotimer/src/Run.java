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
	
	// added for group functionality
	private long groupStartTime;
	private int racerNum;
	private int setRacerNum;
	
	public Run(boolean individual, boolean parallel, int runNumInput){
		beginQueue = new LinkedList<Racer>();
		endQueue = new LinkedList<Racer>();
		stats = new Stats();
		this.individual = individual;
		this.parallel = parallel;
		racerNum = 0;
		setRacerNum = 1;
		runNumber = runNumInput;
		groupStartTime = -1;
		
		if(parallel == true && individual == true){
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
	 * @return 1 if added, 0 if no racer to add to, and -1 if number already exists in the run
	 */
	public int setRacerNum(int bib){
		if(setRacerNum > racerNum){
			return 0;
		}
		Iterator<Racer> it = stats.getRacers().iterator();
		Racer tmp = null;
		for(int i = 0; i < setRacerNum; i++){
			tmp = it.next();
			if(tmp.getBib() == bib){
				return -1;
			}
		}
		tmp.setBib(bib);
		setRacerNum++;
		return 1;
	}
	
	/**
	 * 
	 * @return the run Number associated with the run
	 */
	public int getRunNumber(){
		return runNumber;
	}
	
	/**
	 * 
	 * @return the other lane being used if any 0 = 12, 1 = 34, 2 = 56, 3 = 78, -1 = none
	 */
	public int getOtherLane(int knownLane){
		int i = 0;
		while(i < 4){
			if(usedLanes[i] == true){
				if(i != knownLane){
					return i;
				}
			}
			i++;
		}
		return -1;
	}
	
	/**
	 * 
	 * @return the the two lanes being used, if any
	 */
	public String getOtherLaneNoCurrentRacers(){
		String lanesReturn = "";
		int i = 0;
		int ct = 0;
		while(i < 4){
			if(usedLanes[i] == true){
				lanesReturn += i;
				if(ct == 0){
					lanesReturn +=":";
				}
				ct++;
			}
			i++;
		}
		if(ct == 2){
			return lanesReturn;
		}else if(ct == 1){
			lanesReturn += "9";
			return lanesReturn;
		}else{
			return "9:9";
		}
	}
	
	/**
	 * 
	 * @return the start time of the current run, -1 if not started or the time if already started
	 */
	public long getGroupStartTime(){
		return groupStartTime;
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
	 * @return	LinkedList of racers currently running in Queue 12
	 */
	public LinkedList<Racer> getPendingQueue12(){
		return this.pendingQueue12;
	}
	
	/**
	 * 
	 * @return	LinkedList of racers currently running in Queue 34
	 */
	public LinkedList<Racer> getPendingQueue34(){
		return this.pendingQueue34;
	}
	
	/**
	 * 
	 * @return	LinkedList of racers currently running in Queue 56
	 */
	public LinkedList<Racer> getPendingQueue56(){
		return this.pendingQueue56;
	}
	
	/**
	 * 
	 * @return	LinkedList of racers currently running in Queue 78
	 */
	public LinkedList<Racer> getPendingQueue78(){
		return this.pendingQueue78;
	}
	
	/**
	 * 
	 * @return event type abbreviation of the event the run is
	 */
	public String getEventType(){
		if(individual && !parallel){
			return "IND";
		}else if(individual && parallel){
			return "PARIND";
		}else if(!individual && !parallel){
			return "GRP";
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
	public boolean swap(){
		if(endQueue.size() < 2){
			return false;
		}
		if(!(individual && !parallel)){
			return false;
		}
		Racer first = endQueue.removeFirst();
		Racer second = endQueue.removeFirst();
		endQueue.addFirst(first);
		endQueue.addFirst(second);
		return true;
	}
	/**
	 * Starts the run for the next racer in line, removing them from the 'start' line to the 'finish' line.
	 * 
	 * @param time	Current time used to mark racer's 'Start time'
	 * @return	True if successful, False otherwise
	 */
	public Racer startRacer(long time, int sensorNum){
		if(beginQueue.isEmpty()){
			return null;
		}
		
		if(!parallel){
			// Remove racer from begin queue, add to end queue, set end to pending and start to current time
			Racer racer = beginQueue.removeFirst();
			endQueue.addLast(racer);
			stats.setEnd(racer, 0);
			stats.setStart(racer, time);
			return racer;
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
					return racer;
				}else{
					return null;
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
					return racer;
				}else{
					return null;
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
					return racer;
				}else{
					return null;
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
					return racer;
				}else{
					return null;
				}
			}else{
				return null;
			}
		}else{	// expand when implement new race types
			return null;
		}
	}
	
	public boolean startGroup(long startTime){
		if(groupStartTime != -1){
			return false;
		}
		groupStartTime = startTime;
		return true;
	}
	
	public boolean endGroup(long endTime){
		Racer tmp = new Racer(racerNum + 1);
		stats.setStart(tmp, groupStartTime);
		racerNum++;
		stats.setEnd(tmp, endTime);
		return true;
	}
	
	/**
	 * Ends the run for the current racer on the track and sets their end time accordingly.
	 * 
	 * @param time	Current time to mark the racer's 'End time'
	 * @return	True if successful, False otherwise
	 */
	public Racer endRacer(long time, int sensorNum){
		// If no one is currently racing, return false
		
		if(!parallel){
			if(endQueue.isEmpty()){
				return null;
			}
			Racer racer = endQueue.removeFirst();
			stats.setEnd(racer, time);
			return racer;
		}else if(parallel){
			if(sensorNum == 2){
				if(usedLanes[0] == true){
					if(pendingQueue12.isEmpty() != true){
						Racer racer = pendingQueue12.removeFirst();
						stats.setEnd(racer, time);
						return racer;
					}else{
						return null;
					}
				}else{
					return null;
				}
			}else if(sensorNum == 4){
				if(usedLanes[1] == true){
					if(pendingQueue34.isEmpty() != true){
						Racer racer = pendingQueue34.removeFirst();
						stats.setEnd(racer, time);
						return racer;
					}else{
						return null;
					}
				}else{
					return null;
				}
			}else if(sensorNum == 6){
				if(usedLanes[2] == true){
					if(pendingQueue56.isEmpty() != true){
						Racer racer = pendingQueue56.removeFirst();
						stats.setEnd(racer, time);
						return racer;
					}else{
						return null;
					}
				}else{
					return null;
				}
			}else if(sensorNum == 8){
				if(usedLanes[3] == true){
					if(pendingQueue78.isEmpty() != true){
						Racer racer = pendingQueue78.removeFirst();
						stats.setEnd(racer, time);
						return racer;
					}else{
						return null;
					}
				}else{
					return null;
				}
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	/**
	 * Cancels the current racer's attempt (due to fault, mis-queue, etc.) and puts him or her back in line to start.
	 * 
	 * @Return integer value of racer's bib number that has been canceled or 0 otherwise
	 */
	public int cancel(){
		if(endQueue.isEmpty()){
			return 0;	// no racer has been cancelled
		}
		Racer tmp = endQueue.removeLast();
		stats.cancel(tmp);
		beginQueue.addFirst(tmp);
		int tmpBibNum = tmp.getBib();
		return tmpBibNum;	// a racer has been cancelled
	}
	
	/**
	 * Marks the current racer with a 'Did Not Finish' status and removes them from the run.
	 * 
	 * @Return int racer bib number if dnf successful or 0 if no racer to dnf
	 */
	public int didNotFinish(){
		if(!parallel){
			if(endQueue.isEmpty() == false){
				Racer tmp = endQueue.remove();
				// Denotes 'Did Not Finish' within racer's stats in the run
				stats.setEnd(tmp, -1);
				return tmp.getBib();
			}else{
				return 0;
			}
		}else if(parallel){
			// No Active Racers
			if(endQueue.isEmpty() == false){
				Racer tmp = endQueue.remove();
				if(pendingQueue12.contains(tmp) == true){
					pendingQueue12.removeFirst();
					stats.setEnd(tmp, -1);
					return tmp.getBib();
				}else if(pendingQueue34.contains(tmp) == true){
					pendingQueue34.removeFirst();
					stats.setEnd(tmp, -1);
					return tmp.getBib();
				}else if(pendingQueue56.contains(tmp) == true){
					pendingQueue56.removeFirst();
					stats.setEnd(tmp, -1);
					return tmp.getBib();
				}else if(pendingQueue78.contains(tmp) == true){
					pendingQueue78.removeFirst();
					stats.setEnd(tmp, -1);
					return tmp.getBib();
				}else{
					return 0;
				}
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}

	/**
	 * Sets the type of the next event to be held.
	 * 
	 * @param individual	True if individual type race, False if group
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