import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;

public class Chronotimer {
	private boolean power;
	private boolean printerPower;
	private ArrayList<Run> runs;
	private Channel one, two, three, four, five, six, seven, eight;
	private Run currentRun;
	private Time timer;
	private String bibNumberString;
	
	// IND = individual && !parallel
	// PARIND = individual && parallel
	// GRP = !individual && !parallel
	// PARGRP = !individual && parallel
	private boolean individual;
	private boolean parallel;
	
	public Chronotimer(){
		// Set the default states of the sensors; odd-numbered channels detect 'Start' times, even-number detect 'End' times.
		// Additionally, all channels are, by default, turned off.
		this.one = new Channel(true, false);
		this.two = new Channel(false, false);
		this.three = new Channel(true, false);	
		this.four = new Channel(false, false);
		this.five = new Channel(true, false);	
		this.six = new Channel(false, false);
		this.seven = new Channel(true, false);	
		this.eight = new Channel(false, false);
		this.runs = new ArrayList<Run>();
		this.bibNumberString = "";
		
		// Chronotimer is initially powered off within the simulator.
		// Default settings include no races made, no racers stored.
		this.power = false;
		this.currentRun = null;
		this.timer = new Time();
		this.printerPower = false;
		
		// Default race type set to IND (individual non-parallel).
		this.individual = true;
		this.parallel = false;
		
	}
	
	/**
	 * Gets time according to system clock.
	 * 
	 * @return	Time currently in use within Chronotimer.
	 */
	public Time getTimer(){
		return this.timer;
	}
	
	/**
	 * Gets the state of the printer power
	 * 
	 * @return	True if the printer is on or false if the printer is off
	 */
	public boolean getPrinterPower(){
		if(printerPower == true){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Gets a list of the runs stored within Chronotimer.
	 * 
	 * @return	ArrayList of runs included in the current race (spanning multiple competitors).
	 */
	public ArrayList<Run> getRuns(){
		return this.runs;
	}
	
	/**
	 * Gets the default channel used for 'Start' detection.
	 * 
	 * @return	Channel corresponding to sensing the beginning of the race.
	 */
	public Channel getChannelOne(){
		return this.one;
	}
	
	/**
	 * Gets the default channel used for 'Finish' detection.
	 * 
	 * @return	Channel corresponding to sensing the end of the race.
	 */
	public Channel getChannelTwo(){
		return this.two;
	}
	
	/**
	 * 
	 * @return	channel 3
	 */
	public Channel getChannelThree(){
		return this.three;
	}
	
	/**
	 * 
	 * @return	channel 4
	 */
	public Channel getChannelFour(){
		return this.four;
	}
	
	/**
	 * 
	 * @return	channel 5
	 */
	public Channel getChannelFive(){
		return this.five;
	}
	
	/**
	 * 
	 * @return	channel 6
	 */
	public Channel getChannelSix(){
		return this.six;
	}
	
	/**
	 * 
	 * @return	channel 7
	 */
	public Channel getChannelSeven(){
		return this.seven;
	}
	
	/**
	 * 
	 * @return	channel 8
	 */
	public Channel getChannelEight(){
		return this.eight;
	}
	
	/**
	 * Gets information on the IND run that is currently underway.
	 * 
	 * @return	Run that Chronotimer is currently tracking.
	 */
	public Run getCurrentRun(){
		return this.currentRun;
	}
	
	/**
	 * Gets the power status of the machine.
	 * 
	 * @return	True if power is on, False if off.
	 */
	public boolean getPower(){
		return this.power;
	}
	
	/**
	 * Switches the power for the simulated Chronotimer machine (off->on, on->off).
	 */
	public void power(){
		if(power == false){
			power = true;
		}
		else{
			power = false;
			printerPower = false;
		}
	}
	
	/**
	 * Switches the printer power for the simulated Chronotimer printer (off->on, on->off).
	 */
	public boolean printerPower(){
		if(power == true){
			if(printerPower == false){
				printerPower = true;
				return true;
			}else{
				printerPower = false;
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**
	 * Depending on the channel, this either marks the start of a race or end to one.
	 * 
	 * @param inputChannel	Channel that is being triggered
	 * @return	0 if trigger is valid (queue is not empty for start, racer has started if there
	 * is an end mark), Racer number otherwise.
	 */
	public int trigger(String inputChannel){
		// If there is not race underway, return false (invalid input - ignore)
		if(currentRun == null){
			return 0;
		}
		
		// Parse the number from the input channel, check to see if it's a 'Start' or 'Finish' one
		int number = Integer.parseInt(inputChannel);
		
		// If the channel is # and is 'On'... if 'Start' channel: start racer. else: end current race
		if(number == 1 && one.getOn() == true){
			if(one.getStart() == true){
				Racer racer = currentRun.startRacer(timer.getCurrentTime(),1);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Racer racer = currentRun.endRacer(timer.getCurrentTime(),1);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}	
		}
		else if(number == 2 && two.getOn() == true){
			if(two.getStart() == true){
				Racer racer = currentRun.startRacer(timer.getCurrentTime(),2);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Racer racer = currentRun.endRacer(timer.getCurrentTime(),2);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}	
		}
		else if(number == 3 && three.getOn() == true){
			if(three.getStart() == true){
				Racer racer = currentRun.startRacer(timer.getCurrentTime(),3);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Racer racer = currentRun.endRacer(timer.getCurrentTime(),3);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}	
		}
		else if(number == 4 && four.getOn() == true){
			if(four.getStart() == true){
				Racer racer =  currentRun.startRacer(timer.getCurrentTime(),4);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Racer racer = currentRun.endRacer(timer.getCurrentTime(),4);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}	
		}
		else if(number == 5 && five.getOn() == true){
			if(five.getStart() == true){
				Racer racer = currentRun.startRacer(timer.getCurrentTime(),5);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Racer racer = currentRun.endRacer(timer.getCurrentTime(),5);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}	
		}
		else if(number == 6 && six.getOn() == true){
			if(six.getStart() == true){
				Racer racer = currentRun.startRacer(timer.getCurrentTime(),6);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Racer racer = currentRun.endRacer(timer.getCurrentTime(),6);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}	
		}
		else if(number == 7 && seven.getOn() == true){
			if(seven.getStart() == true){
				Racer racer = currentRun.startRacer(timer.getCurrentTime(),7);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Racer racer = currentRun.endRacer(timer.getCurrentTime(),7);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}	
		}
		else if(number == 8 && eight.getOn() == true){
			if(eight.getStart() == true){
				Racer racer = currentRun.startRacer(timer.getCurrentTime(),8);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Racer racer = currentRun.endRacer(timer.getCurrentTime(),8);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}	
		}
		return 0;
	}
	
	/**
	 * If reading from a string, trigger according to indicated input for specific channel and given time.
	 * 
	 * @param inputChannel	Channel that is being triggered
	 * @param time	Time at which channel was/is to be triggered
	 * @return	Bib Number if trigger is valid (queue is not empty for start, racer has started if there
	 * is an end mark) or if a group event the num 11111 will be returned , 0 otherwise.
	 */
	public int triggerTime(String inputChannel, String time){
		// If there is not race underway, return false (invalid input - ignore)
		if(currentRun == null){
			return 0;
		}
		
		// Parse time (string) into doubles for easier conversion into a long (hours, minutes, seconds)
		// According to project sample input, time input includes hours, minutes, and seconds.
		String[] stringTimeArray = time.split(":");
		double[] array = new double[3];
		array[0] = Double.parseDouble(stringTimeArray[0]);
		array[1] = Double.parseDouble(stringTimeArray[1]);
		array[2] = Double.parseDouble(stringTimeArray[2]);
		
		// Using milliseconds structure, set current time to string input time
		double currentTimeDouble = 3600000 * array[0] + 60000 * array[1] + 1000 * array[2];
		long currentTime = (long)currentTimeDouble;
		
		// Parse the number from the input channel, check to see if it's a 'Start' or 'Finish' one		
		int number = Integer.parseInt(inputChannel);
		
		// If the channel is # and is 'On'... if 'Start' channel: start racer. else: end current race
		if(number == 1 && one.getOn() == true){
			if(individual){
				Racer racer = currentRun.startRacer(currentTime,1);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Boolean returnValue = currentRun.startGroup(currentTime);
				if(returnValue == true){
					return 11111;
				}else{
					return 0;
				}
			}
		}
		else if(number == 2 && two.getOn() == true){
			if(individual){
				Racer racer = currentRun.endRacer(currentTime,2);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Boolean returnValue = currentRun.endGroup(currentTime);
				if(returnValue == true){
					return 11111;
				}else{
					return 0;
				}
			}
		}
		else if(number == 3 && three.getOn() == true){
			if(individual){
				Racer racer = currentRun.startRacer(currentTime,1);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Boolean returnValue = currentRun.startGroup(currentTime);
				if(returnValue == true){
					return 11111;
				}else{
					return 0;
				}
			}
		}
		else if(number == 4 && four.getOn() == true){
			if(individual){
				Racer racer = currentRun.endRacer(currentTime,2);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Boolean returnValue = currentRun.endGroup(currentTime);
				if(returnValue == true){
					return 11111;
				}else{
					return 0;
				}
			}
		}
		else if(number == 5 && five.getOn() == true){
			if(individual){
				Racer racer = currentRun.startRacer(currentTime,1);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Boolean returnValue = currentRun.startGroup(currentTime);
				if(returnValue == true){
					return 11111;
				}else{
					return 0;
				}
			}
		}
		else if(number == 6 && six.getOn() == true){
			if(individual){
				Racer racer = currentRun.endRacer(currentTime,2);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Boolean returnValue = currentRun.endGroup(currentTime);
				if(returnValue == true){
					return 11111;
				}else{
					return 0;
				}
			}
		}
		else if(number == 7 && seven.getOn() == true){
			if(individual){
				Racer racer = currentRun.startRacer(currentTime,1);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Boolean returnValue = currentRun.startGroup(currentTime);
				if(returnValue == true){
					return 11111;
				}else{
					return 0;
				}
			}
		}
		else if(number == 8 && eight.getOn() == true){
			if(individual){
				Racer racer = currentRun.endRacer(currentTime,2);
				if(racer == null){
					return 0;
				}else{
					return racer.getBib();
				}
			}
			else{
				Boolean returnValue = currentRun.endGroup(currentTime);
				if(returnValue == true){
					return 11111;
				}else{
					return 0;
				}
			}
		}
		return 0;
	}
	
	/**
	 * Returns whether the current grouping type is an individual race.
	 * 
	 * @return	True if current races are of individuals, False if groups.
	 */
	public boolean getIndividual(){
		return this.individual;
	}
	
	/**
	 * Returns whether the current race type is a parallel race.
	 * 
	 * @return	True if current races are parallels, False if in series.
	 */
	public boolean getParallel(){
		return this.parallel;
	}
	
	/**
	 * Creates a new run (assuming power is not on and there are no concurrent runs).
	 * 
	 * @param individual	Takes True if current run type is a parallel, False if group
	 * @param parallel	Takes True if current run type is parallel, False if series
	 */
	public void newRun(boolean individual, boolean parallel){
		// Ignore if power is off
		if(power == false){
			return;
		}
		
		// Also ignore if there is a run already underway.
		if(currentRun != null){
			return;
		}
		
		int newRunNumber = runs.size() + 1;
		// Create a new run based on two variables: IND/GRP, PAR/SER
		Run current = new Run(individual, parallel, newRunNumber);
		current.setEvent(individual,parallel);	// set the event
		runs.add(current);
		currentRun = current;
	}
	
	/**
	 * Ends the run that is currently underway.
	 * 
	 * Note: As it was not required, data is not saved or printed for any lingering racers in the queue for the ending run.
	 */
	public void endRun(){
		// Ignore if power if off
		if(power == false){
			return;
		}
		
		// Also ignore if there is not a run underway
		if(currentRun == null){
			return;
		}
		
		// currentRun to end on command
		int runNumber = currentRun.getRunNumber();
		String runNumberString = Integer.toString(runNumber);
		String exportInput = "RUN" + runNumberString + ".txt";
		export(exportInput);
		currentRun = null;
	}
	
	/**
	 * Resets settings to original defaults:
	 * 	Odd channels mark 'Start'
	 * 	Even channels mark 'Finish'
	 * 	No channels are 'On'
	 * 	The list of runs is empty
	 * 	Any current runs are wiped
	 * 	Default race type is IND (individual, non-parallel)
	 */
	public void reset(){
		if(power == false){
			return;
		}
		this.one = new Channel(true, false);	//set default state of sensors
		this.two = new Channel(false, false);
		this.three = new Channel(true, false);	
		this.four = new Channel(false, false);
		this.five = new Channel(true, false);	
		this.six = new Channel(false, false);
		this.seven = new Channel(true, false);	
		this.eight = new Channel(false, false);
		runs = new ArrayList<Run>();
		currentRun = null;
		this.individual = true;
		this.parallel = false;
	}
	
	/**
	 * For Sprint 2; sets the type of the event.
	 * 
	 * @param individual	Set True if race will be individual, False if group
	 * @param parallel	Set True if race will be parallel, False if in series
	 */
	public boolean setEvent(String userInput){
		// As long as there is not a run underway, set details for a new one
		if(power == false){
			return false;
		}
		if(userInput.equals("IND")){
			individual = true;
			parallel = false;
			return true;
		}else if(userInput.equals("PARIND")){
			individual = true;
			parallel = true;
			return true;
		}else if(userInput.equals("GRP")){
			individual = false;
			parallel = false;
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Changes the status of a channel based on an input string.
	 * 
	 * @param channelNum	The number of the channel being toggled
	 * @return	True if successful, otherwise False
	 */
	public boolean toggleChannel(String channelNum){
		// Only toggle is Chronotimer is active
		if(power == false){
			return false;
		}else{
			// If the channel number is not valid, ignore the command
			if(channelNum == null){
				return false;
			}else{
				// Grab the channel number from the string input
				int number = Integer.parseInt(channelNum);
				
				// If the number is out of range (1-8), ignore the command
				if(number < 1 || number > 8){
					return false;
				}else{
					if(number == 1){
						one.toggle();
						return true;
					}else if(number == 2){
						two.toggle();
						return true;
					}else if(number == 3){
						three.toggle();
						return true;
					}else if(number == 4){
						four.toggle();
						return true;
					}else if(number == 5){
						five.toggle();
						return true;
					}else if(number == 6){
						six.toggle();
						return true;
					}else if(number == 7){
						seven.toggle();
						return true;
					}else if(number == 8){
						eight.toggle();
						return true;
					}else{
						return false;
					}
				}
			}
		}
	}
	
	/**
	 * Changes the status of the connected sensor to the channel
	 * 
	 * @param channelNum	The number of the channel being toggled
	 * @return	True if successful, otherwise False
	 */
	public boolean connectChannelSensor(String channelNum){
		// One can plug/connect a sensor to the chronotimer while it is off so do not check if chronotimer is on or not
		// If the channel number is not valid, ignore the command
		if(channelNum == null){
			return false;
		}else{
			// Grab the channel number from the string input
			int number = Integer.parseInt(channelNum);
					
			// If the number is out of range (1-8), ignore the command
			if(number < 1 || number > 8){
				return false;
			}else{
				if(number == 1){
					one.connectSensor();
					return true;
				}else if(number == 2){
					two.connectSensor();
					return true;
				}else if(number == 3){
					three.connectSensor();
					return true;
				}else if(number == 4){
					four.connectSensor();
					return true;
				}else if(number == 5){
					five.connectSensor();
					return true;
				}else if(number == 6){
					six.connectSensor();
					return true;
				}else if(number == 7){
					seven.connectSensor();
					return true;
				}else if(number == 8){
					eight.connectSensor();
					return true;
				}else{
					return false;
				}
			}
		}
	}
	
	/**
	 * Creates a racer with the given bib number in the current run.
	 * 
	 * @param number	The bib number of the racer being entered into the race.
	 * @return	True if successful, False otherwise
	 */
	public boolean num(String number){
		// Only add racer if power is on
		if(power == false){
			return false;
		}
		else if(!individual){
			if(currentRun != null){
				return currentRun.setRacerNum(Integer.parseInt(number));
			}
			return false;
		}
		else{
			// Ignore the command if the input is invalid
			if(number == null){
				return false;
			}else{
				// Only add if there is a run underway
				if(currentRun == null){
					return false;
				}else{
					// Check if bib number already exists in the current run before adding it to the run
					boolean checkBibNumValue = currentRun.numExistsInRun(number);
					if(checkBibNumValue == false){
						return false;
					}
					// Parse the bib number, then add the racer with their number
					int racerBibNumber = Integer.parseInt(number);
					Racer toAdd = new Racer(racerBibNumber);
					currentRun.addRacer(toAdd);
					return true;
				}
			}
		}
	}
	
	/**
	 * Creates a racer with the given bib number in the current run and clears the number string created by inputs from the keypad.
	 * 
	 * @return	0 if unsuccessful/printer off and bib Number entered on success
	 */
	public int numFromKeypad(){
		if(power == false){
			return 0;
		}else{
			// Ignore the command if the input is invalid
			if(bibNumberString == null || bibNumberString.length() == 0){
				return 0;
			}else{
				// Only add if there is a run underway
				if(currentRun == null){
					return 0;
				}else{
					// Check if bib number already exists in the current run before adding it to the run
					boolean checkBibNumValue = currentRun.numExistsInRun(bibNumberString);
					if(checkBibNumValue == false){
						return 0;
					}
					// Parse the bib number, then add the racer with their number
					int racerBibNumber = Integer.parseInt(bibNumberString);
					Racer toAdd = new Racer(racerBibNumber);
					currentRun.addRacer(toAdd);
					bibNumberString = "";
					return racerBibNumber;
				}
			}
		}
	}
	
	/**
	 * Exits the simulator/program.
	 */
	public void exit(){
		System.exit(0);
	}
	
	public void cancel(){
		currentRun.cancel();
	}
	
	/**
	 * Marks the current racer with a 'Did Not Finish' status'.
	 * 
	 * @return	True if successfully marked, False otherwise.
	 */
	public boolean dnf(){
		// Only act if Chronotimer is on
		if(power == false){
			return false;
		}else{
			// Only perform if there is a run underway
			if(currentRun == null){
				return false;
			}else{
				// Utilize Run object's 'Did Not Finish' method for marking
				boolean dnfResult = currentRun.didNotFinish();
				if(dnfResult == true){
					return true;
				}else{
					return false;
				}
			}
		}
	}
	
	/**
	 * Utilizes a hotkey to use Channel 1 to trigger the beginning of the next race using the next racer up.
	 * 
	 * @return	True if successful, False if there was an error.
	 */
	public boolean start(){
		// Only perform if Chronotimer is active
		if(power == false){
			return false;
		}else{
			int triggered1 = trigger("1");
			if(triggered1 == 0){
				return false;
			}else{
				return true;
			}
		}
	}
	
	/**
	 * Utilizes a hotkey to use Channel 2 to trigger the end of the current race using the current racer.
	 * 
	 * @return	True if successful, False otherwise
	 */
	public boolean finish(){
		if(power == false){
			return false;
		}else{
			int triggered2 = trigger("2");
			if(triggered2 == 0){
				return false;
			}else{
				return true;
			}
		}
	}
	
	public void export(String filename){
		if(power != false){
			Gson g = new Gson();
			String out = g.toJson(runs);
			FileWriter fw = null;
			try {
				fw = new FileWriter(filename, false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fw.write(out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Adds a number from the keypad to the bib number to add to the queue of racers
	 * 
	 * @return	True if successful, False if there was an error
	 */
	public boolean addToBibNumberString(String numToAdd){
		if(power == false){
			return false;
		}else{
			// Ignore the command if the input is invalid
			if(numToAdd == null || bibNumberString == null){
				return false;
			}else{
				if(numToAdd.equals("0")){
					// Do not allow first number of bib number to be a 0 character
					if(bibNumberString.length() == 0){
						return false;
					}else{
						bibNumberString = bibNumberString + numToAdd;
						return true;
					}
				}else{
					bibNumberString = bibNumberString + numToAdd;
					return true;
				}
			}
		}
	}
	
	/**
	 * Clears the string of the next bib number to add to the queue of racers
	 * 
	 * @return	True if successful, False if there was an error
	 */
	public boolean clearBibNumberString(){
		if(power == false){
			return false;
		}else{
			if(bibNumberString.length() == 0){
				return false;
			}else{
				bibNumberString = "";
				return true;
			}
		}
	}
	
	/**
	 * Prints the list of available commands, as well as prompts user for input.
	 */
	public void print(){
		if(power != false){
			System.out.println();
			Iterator<Run> it = runs.iterator();
			while(it.hasNext()){
				// Increment the run number
				Run run = it.next();
				
				if(run.getEventType().equals("IND")){
					System.out.println("Run number: " + run.getRunNumber() + "     Event Type: " + "Individual");
				}else if(run.getEventType().equals("PARIND")){
					System.out.println("Run number: " + run.getRunNumber() + "     Event Type: " + "Individual Parallel");
				}else if(run.getEventType().equals("GRP")){
					System.out.println("Run number: " + run.getRunNumber() + "	   Event Type: " + "Group");
				}else{
					System.out.println("Run number: " + run.getRunNumber() + "     Event Type: " + "-");
				}
				System.out.println("---------------------");
			
				// Iterate through racers and retrieve stats to print (Start time, End time, Total time)
				//Run run = it.next();
				Stats stats = run.getStats();
				ArrayList<Racer> racers = stats.getRacers();
				Iterator<Racer> it2 = racers.iterator();
				while(it2.hasNext()){
					Racer racer = it2.next();
					System.out.println("Racer BIB number: " + racer.getBib());
					System.out.println("Start: " + Time.convertTime(stats.getStart(racer)) + "	End: " + Time.convertTime(stats.getEnd(racer)));
					if(stats.getEnd(racer) == -1){
						System.out.println("Total time: Did not finish");
					}
					else if(stats.getRaceTime(racer) < 0){
						System.out.println("Total time: Still In Progress");
					}
					else{
						System.out.println("Total time: " + Time.convertTime(stats.getRaceTime(racer)));	
					}
					System.out.println();
					
				}
			}
		}
	}
}