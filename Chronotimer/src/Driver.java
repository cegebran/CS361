import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Driver {
	
	public static void main(String[] args){
	
		// Create Chronotimer for simulator
		Chronotimer chronotimer = new Chronotimer();
			
		boolean realTime = false;
		int parseFirstLength = 0;
		int i = 0;
		String myLine = "";
		FileReader fileInput = null;
		BufferedReader buffRead = null;
		String[] userInputParseFirst = null;
		String[] userInputParse = null;
			
		if (args.length != 0) {
			
			File file = new File(args[0]);						//Declare file for input
			
			try {
				
				fileInput = new FileReader(file);				//Initialize the FileReader and Buffered Reader for input
				buffRead = new BufferedReader(fileInput);
				
			} catch (FileNotFoundException f) {
				
				System.out.print("\nError! File not found!");
				System.exit(0);
				
			}
			
			realTime = false;
			
		} else {
			
			realTime = true;
			
		}
		
		if (realTime) {
			
			// Print list of commands for the user to choose from
			System.out.println(" ");
			System.out.println("Available Commands: The Command should be entered depending on the name, not case sensitive" );
			System.out.println("exit: Exit the simulator");
			System.out.println("power: Turn the System on and off depending on what state the Chronotimer is currently in");
			System.out.println("reset: reset the system to the original state");
			System.out.println("time <hour>:<min>:<sec> : set the current time");
			System.out.println("dnf: the next competitor to finish will not finish");
			System.out.println("cancel: discard the current race and place the racer back in the queue");
			System.out.println("tog <channel>: toggle the state of the channel <channel>");
			System.out.println("trig <NUM>: trigger the channel NUM<>");
			System.out.println("start: start tigger channel 1");
			System.out.println("finish: finish trigger channel 2");
			System.out.println("newrun: Create a new run (must end a run first");
			System.out.println("endrun: Done with a run");
			System.out.println("num <NUM>: Add a racer to the current run at the end of the queue");
			System.out.println("print: Print the data to the screen");
			System.out.println("event <Event Type>: Determine the event that the runs will consist of until changed");
			System.out.println(" ");
			
		}
		
		// Create Scanner to read user input and userInputLine for command input
		Scanner input = new Scanner(System.in);
		String userInputLine;
		
		// Marks valid input from the user that is acceptable and recognized
		boolean validInput;
		validInput = false;
	
		while (!validInput) {
			try {
				if (realTime) {
					// Prompt for input
					System.out.print("User Input: ");
					
					// Take input, make all upper case for uniformity, parse into components
					userInputLine = input.nextLine();
					userInputLine = userInputLine.toUpperCase();
					userInputParseFirst = userInputLine.split(" ");
					userInputParse = new String[4];
					
					// Parse command
					parseFirstLength = userInputParseFirst.length;
					userInputParse[0] = chronotimer.getTimer().toString();
					i = 0;
					while (i < parseFirstLength) {
						userInputParse[i+1] = userInputParseFirst[i];
						i++;
					}
				} else {
					// No need to print list of commands; simulator is working with .txt file
					try {
						if ((myLine = buffRead.readLine()) != null) {				//Loop while there is still a next line
							userInputParseFirst = myLine.split(" ");				//Parse the input line	
							userInputParse = new String[4];
							parseFirstLength = userInputParseFirst.length;
							i = 0;
							while (i < parseFirstLength) {
								userInputParse[i] = userInputParseFirst[i];
								i++;
							}
							System.out.println(myLine);
						} else {
							System.out.println("End of simulator.");
							System.exit(0);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				// exit command
				if (userInputParse[1].equals("EXIT")) {
					validInput = true;
					input.close();
					System.out.println("The simulator has now stopped");
					chronotimer.exit();
				}
				
				// power command
				if (userInputParse[1].equals("POWER")) {
					chronotimer.power();
					if (chronotimer.getPower() == true) {
						System.out.println("The Chronotimer has been turned on");
					} else {
						System.out.println("The Chronotimer has been turned off");
					}
				}
				
				// reset command
				if (userInputParse[1].equals("RESET")) {
					chronotimer.reset();
					if (chronotimer.getPower() == true) {
						System.out.println("The chronotimer has now been set back to its original state");
					} else {
						System.out.println("The Chronotimer is turned off");
					}
				}
				
				// cancel command
				if (userInputParse[1].equals("CANCEL")) {
					int result = chronotimer.cancel();
					if (result > 0) {
						System.out.println("Racer #" + result + " has been canceled");
					} else {
						if (result == 0) {
							System.out.println("There is no current run to cancel a racer from");
						} else if (result == -1) {
							System.out.println("There is no current racer currently making their run to cancel");
						} else if (result == -2) {
							System.out.println("The Chronotimer is turned off");
						}
					}
				}
				
				// time command
				if (userInputParse[1].equals("TIME")) {
					if (chronotimer.getPower() == false) {
						System.out.println("The Chronotimer is turned off");
					} else {
						chronotimer.getTimer().setTime(userInputParse[2]);
						System.out.println("The time was set as entered");
					}
				}
				
				// start command
				if (userInputParse[1].equals("START")) {
					if (chronotimer.getPower() == true) {
						boolean started = chronotimer.start();
						if (started == false) {
							System.out.println("Channel 1 has not been triggered");
						} else {
							System.out.println("Channel 1 has been triggered");
						}
					} else {
						System.out.println("The Chronotimer is off");
					}
				}
				
				// finish command
				if (userInputParse[1].equals("FINISH")) {
					if (chronotimer.getPower() == true) {
						boolean finished = chronotimer.finish();
						if (finished == false) {
							System.out.println("Channel 2 has not been triggered");
						} else {
							System.out.println("Channel 2 has been triggered");
						}
					} else {
						System.out.println("The Chronotimer is off");
					}
				}
				
				// dnf command
				if (userInputParse[1].equals("DNF")) {
					int result = chronotimer.dnf();
					if (result > 0) {
						System.out.println("Racer #" + result + " Marked As DNF");
					} else if(result == 0) {
						System.out.println("No Racer Currently Running To Mark As DNF");
					} else if(result == -2) {
						System.out.println("No Current Run To Mark A Racer As DNF");
					} else if(result == -1) {
						System.out.println("The Chronotimer Power Is Currently Off");
					}
				}
				
				// tog command
				if (userInputParse[1].equals("TOG")) {
					if (chronotimer.getPower() == false) {
						System.out.println("The chronotimer is currently off");
					} else {
						boolean toggled = chronotimer.toggleChannel(userInputParse[2]);
						
						if (toggled == true) {
							System.out.println("The channel has been toggled");
						} else {
							System.out.println("The channel has not been toggled");
						}
					}
				}
				
				// trig command
				if (userInputParse[1].equals("TRIG")) {
					if (chronotimer.getPower() == false) {
						System.out.println("The Chronotimer is off");
					} else {
						int triggered = chronotimer.trigger(userInputParse[2]);
						if (triggered != 0) {
							System.out.println("The channel has been triggered");
						} else {
							System.out.println("The channel has not been triggered");
						}
						//int test = chronotimer.triggerTime(userInputParse[2], userInputParse[0]);
						//if(test != 0){
						//	System.out.println("Channel has been triggered");
						//}
						//else{
						//	System.out.println("Channel has not been triggered");
						//}
					}
				}
				
				// newrun command
				if (userInputParse[1].equals("NEWRUN")) {
					if (chronotimer.getPower() == false) {
						System.out.println("The Chronotimer is off");
					} else {
						int result = chronotimer.newRun();
						if (result == 0) {
							System.out.println("New Run Has Not Been Added");
        				} else if(result == 1) {
        					System.out.println("New IND Run Added");
        				} else if(result == 2) {
        					System.out.println("New PARIND Run Added");
        				} else if(result == 3) {
        					System.out.println("New GRP Run Added");
        				} else if(result == 4) {
        					System.out.println("New PARGRP Run Added");
        				} else {
        					System.out.println("New Run Has Not Been Added");
        				}
					}
				}
				
				// endrun command
				if (userInputParse[1].equals("ENDRUN")) {
					if (chronotimer.getPower() == false) {
						System.out.println("The Chronotimer is off");
					} else {
						boolean result = chronotimer.endRun();
						if (result == true) {
							System.out.println("The current run has ended and the next in the queue (if any) has become the current run");
						} else {
							System.out.println("There was no current run to end");
						}
					}
				}
				
				// num command 
				if (userInputParse[1].equals("NUM")) {
					int result = chronotimer.num(userInputParse[2]);
					if (result == -1) {
						System.out.println("The Chronotimer Is Off");
					} else if(result == 0) {
						System.out.println("Number Not Added");
					} else if(result == 1) {
						System.out.println("Racer With BIB #" + userInputParse[2] + " Has Been Added");
					} else if(result == -2) {
						System.out.println("No Current Run To Add The Racer To");
					} else if(result == -3) {
						System.out.println("The BIB #" + userInputParse[2] + " Already Exists");
					} else if(result == -4) {
						System.out.println("No Number Entered To Add");
					}
				}
				
				// print command
				if (userInputParse[1].equals("PRINT")) {
					if (chronotimer.getPower() == false) {
						System.out.println("The chronotimer is off");
					} else {
						chronotimer.print();
					}
				}
				
				// event command
				if (userInputParse[1].equals("EVENT")) {
					if (chronotimer.getPower() == false) {
						System.out.println("The chronotimer is off");
					} else {
						boolean returnValue = chronotimer.setEvent(userInputParse[2]);
						if (returnValue == true) {
							System.out.println("The event type has been changed");
						} else {
							System.out.println("The event type has NOT been changed");
						}
					}
				}
				
				// export command
				if (userInputParse[1].equals("EXPORT")){
					chronotimer.export(userInputParse[2]);
					System.out.println("The current runs have been exported to the specified file");
				}
				
			} catch(InputMismatchException e) {
				input.next();
			}
		}
	}
}