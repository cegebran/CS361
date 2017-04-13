import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Testdata {
	public static void main(String[] args){
		File file = new File("Test4");		//Declare file for input
		FileReader input = null;
		BufferedReader buffRead = null;
		String myLine = "";								//Buffer string
		Chronotimer chronotimer = new Chronotimer();
		
		try {
			input = new FileReader(file);				//Initialize the FileReader and Buffered Reader for input
			buffRead = new BufferedReader(input);
			
		} catch (FileNotFoundException f) {
			System.out.print("\nError! File not found!");
		}
		
		try {
			while ( (myLine = buffRead.readLine()) != null) {	//Loop while there is still a next line
				String[] array = myLine.split(" ");			//Parse the input line		
				System.out.println(myLine);
					if(array[1].equals("POWER")){
						chronotimer.power();
						if(chronotimer.getPower() == true){
							System.out.println("Chronotimer has turned on");
						}
						else{
							System.out.println("Chronotimer has turned off");
						}
					}
					else if(array[1].equals("TIME")){
						chronotimer.getTimer().setTime(array[2]);
						System.out.println("Time has been set on the chronotimer");
					}
					else if(array[1].equals("TOG")){
						chronotimer.toggleChannel(array[2]);
						System.out.println("The channel has been toggled");
					}
					else if(array[1].equals("TRIG")){
						int test = chronotimer.triggerTime(array[2], array[0]);
						if(test != 0){
							System.out.println("Channel has been triggered");
						}
						else{
							System.out.println("Channel has not been triggered");
						}
					}
					else if(array[1].equals("EXIT")){
						System.out.println("Exiting simulator...");
						break;
					}
					else if(array[1].equals("EVENT")){
						if(array[2].equals("IND")){
							chronotimer.setEvent("IND");
							System.out.println("IND has been set");
						}
						else if(array[2].equals("PARIND")){
							chronotimer.setEvent("PARIND");
							System.out.println("PARIND has been set");
						}
						else if(array[2].equals("GRP")){
							chronotimer.setEvent("GRP");
							System.out.println("GRP has been set");
						}
					}
					else if(array[1].equals("NEWRUN")){
						chronotimer.newRun();
						System.out.println("A new run has been created");
					}
					else if(array[1].equals("NUM")){
						int tmp = chronotimer.num(array[2]);
						//chronotimer.getCurrentRun().addRacer(new Racer(Integer.parseInt(array[2])));
						if(tmp == 1){
							System.out.println("Number has been set");
						}
						else{
							System.out.println("Number has not been set");
						}
					}
					else if(array[1].equals("PRINT")){
						chronotimer.print();
					}
					else if(array[1].equals("ENDRUN")){
						chronotimer.endRun();
						System.out.println("The current run has been ended");
					}
					else if(array[1].equals("EXPORT")){
						chronotimer.export(array[2]);
						System.out.println("The current runs have been exported to the specified file");
					}
					else if(array[1].equals("DNF")){
						chronotimer.dnf();
						System.out.println("The current racer did not finish");
					}
					else if(array[1].equals("CANCEL")){
						chronotimer.cancel();
						System.out.println("The current racer has been canceled");
					}
					System.out.println();
			}
		} catch (IOException e) {
			System.out.println("I/O Exception");
		}
	}
}