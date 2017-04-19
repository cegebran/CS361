import java.util.Scanner;
import java.util.InputMismatchException;

public class Driver {
	public static void main(String[] args){
	
		// Create Scanner to read user input and userInputLine for command input
		Scanner input = new Scanner(System.in);
		String userInputLine;
		
		// Create Chronotimer for simulator
		Chronotimer chronotimer = new Chronotimer();
	
		// Marks valid input from the user that is acceptable and recognized
		boolean validInput;
	
		validInput = false;
		while(!validInput){
			try{
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
				System.out.print("User Input: ");
				
				// Take input, make all upper case for uniformity, parse into components
				userInputLine = input.nextLine();
				userInputLine = userInputLine.toUpperCase();
				String[] userInputParseFirst = userInputLine.split(" ");
				String[] userInputParse = new String[3];
				
				// Parse command
				int parseFirstLength = userInputParseFirst.length;
				int i = 0;
				while(i < parseFirstLength){
					userInputParse[i] = userInputParseFirst[i];
					i++;
				}
				
				// exit command
				if(userInputParse[0].equals("EXIT")){
					validInput = true;
					input.close();
					System.out.println("The simulator has now stopped");
					chronotimer.exit();
				}
				
				// power command
				if(userInputParse[0].equals("POWER")){
					chronotimer.power();
					if(chronotimer.getPower() == true){
						System.out.println("The Chronotimer has been turned on");
					}else{
						System.out.println("The Chronotimer has been turned off");
					}
				}
				
				// reset command
				if(userInputParse[0].equals("RESET")){
					chronotimer.reset();
					if(chronotimer.getPower() == true){
						System.out.println("The chronotimer has now been set back to its original state");
					}else{
						System.out.println("The Chronotimer is turned off");
					}
				}
				
				// cancel command
				if(userInputParse[0].equals("CANCEL")){
					int result = chronotimer.cancel();
					if(result > 0){
						System.out.println("Racer #" + result + " has been canceled");
					}else{
						if(result == 0){
							System.out.println("There is no current run to cancel a racer from");
						}else if(result == -1){
							System.out.println("There is no current racer currently making their run to cancel");
						}else if(result == -2){
							System.out.println("The Chronotimer is turned off");
						}
					}
				}
				
				// time command
				if(userInputParse[0].equals("TIME")){
					if(chronotimer.getPower() == false){
						System.out.println("The Chronotimer is turned off");
					}else{
						chronotimer.getTimer().setTime(userInputParse[1]);
						System.out.println("The time was set as entered");
					}
				}
				
				// start command
				if(userInputParse[0].equals("START")){
					if(chronotimer.getPower() == true){
						boolean started = chronotimer.start();
						if(started == false){
							System.out.println("Channel 1 has not been triggered");
						}else{
							System.out.println("Channel 1 has been triggered");
						}
					}else{
						System.out.println("The Chronotimer is off");
					}
				}
				
				// finish command
				if(userInputParse[0].equals("FINISH")){
					if(chronotimer.getPower() == true){
						boolean finished = chronotimer.finish();
						if(finished == false){
							System.out.println("Channel 2 has not been triggered");
						}else{
							System.out.println("Channel 2 has been triggered");
						}
					}else{
						System.out.println("The Chronotimer is off");
					}
				}
				
				// dnf command
				if(userInputParse[0].equals("DNF")){
					int result = chronotimer.dnf();
					if(result > 0){
						System.out.println("Racer #" + result + " Marked As DNF");
					}else if(result == 0){
						System.out.println("No Racer Currently Running To Mark As DNF");
					}else if(result == -2){
						System.out.println("No Current Run To Mark A Racer As DNF");
					}else if(result == -1){
						System.out.println("The Chronotimer Power Is Currently Off");
					}
				}
				
				// tog command
				if(userInputParse[0].equals("TOG")){
					if(chronotimer.getPower() == false){
						System.out.println("The chronotimer is currently off");
					}else{
						boolean toggled = chronotimer.toggleChannel(userInputParse[1]);
						
						if(toggled == true){
							System.out.println("The channel has been toggled");
						}else{
							System.out.println("The channel has not been toggled");
						}
					}
				}
				
				// trig command
				if(userInputParse[0].equals("TRIG")){
					if(chronotimer.getPower() == false){
						System.out.println("The Chronotimer is off");
					}else{
						int triggered = chronotimer.trigger(userInputParse[1]);
						if(triggered != 0){
							System.out.println("The channel has been triggered");
						}else{
							System.out.println("The channel has not been triggered");
						}
					}
				}
				
				// newrun command
				if(userInputParse[0].equals("NEWRUN")){
					if(chronotimer.getPower() == false){
						System.out.println("The Chronotimer is off");
					}else{
						int result = chronotimer.newRun();
						if(result == 0){
							System.out.println("New Run Has Not Been Added");
        				}else if(result == 1){
        					System.out.println("New IND Run Added");
        				}else if(result == 2){
        					System.out.println("New PARIND Run Added");
        				}else if(result == 3){
        					System.out.println("New GRP Run Added");
        				}else if(result == 4){
        					System.out.println("New PARGRP Run Added");
        				}else{
        					System.out.println("New Run Has Not Been Added");
        				}
					}
				}
				
				// endrun command
				if(userInputParse[0].equals("ENDRUN")){
					if(chronotimer.getPower() == false){
						System.out.println("The Chronotimer is off");
					}else{
						boolean result = chronotimer.endRun();
						if(result == true){
							System.out.println("The current run has ended and the next in the queue (if any) has become the current run");
						}else{
							System.out.println("There was no current run to end");
						}
					}
				}
				
				// num command
				if(userInputParse[0].equals("NUM")){
					int result = chronotimer.num(userInputParse[1]);
					if(result == -1){
						System.out.println("The Chronotimer Is Off");
					}else if(result == 0){
						System.out.println("Number Not Added");
					}else if(result == 1){
						System.out.println("Racer With BIB #" + userInputParse[1] + " Has Been Added");
					}else if(result == -2){
						System.out.println("No Current Run To Add The Racer To");
					}else if(result == -3){
						System.out.println("The BIB #" + userInputParse[1] + " Already Exists");
					}else if(result == -4){
						System.out.println("No Number Entered To Add");
					}
				}
				
				// print command
				if(userInputParse[0].equals("PRINT")){
					if(chronotimer.getPower() == false){
						System.out.println("The chronotimer is off");
					}else{
						chronotimer.print();
					}
				}
				
				// event command
				if(userInputParse[0].equals("EVENT")){
					if(chronotimer.getPower() == false){
						System.out.println("The chronotimer is off");
					}else{
						boolean returnValue = chronotimer.setEvent(userInputParse[1]);
						if(returnValue == true){
							System.out.println("The event type has been changed");
						}else{
							System.out.println("The event type has NOT been changed");
						}
					}
				}
				
			}catch(InputMismatchException e){
				input.next();
			}
		}
	}
}