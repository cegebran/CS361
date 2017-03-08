import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class DirectoryEditor {
	public static void main(String[] args){
		
		File file = new File("InputData.txt");		//Declare file for input
		FileReader input = null;
		BufferedReader buffRead = null;
		String myLine = "";	 //Buffer string
		
		try {
			input = new FileReader(file);				//Initialize the FileReader and Buffered Reader for input
			buffRead = new BufferedReader(input);
		} catch (FileNotFoundException f) {
			System.out.print("\nError! File not found!");
		}
		
		try{
			while ( (myLine = buffRead.readLine()) != null) {
				myLine.toUpperCase();
				String[] array = myLine.split(" ");	
				
				if(array[0].equals("CLR")){
					Writer fileWriter = null;
					try {
						fileWriter = new FileWriter("output.txt", false);
					} catch (IOException e) {
						System.out.println("File not found");
					}
					fileWriter.close();
				}else if(array[0].equals("ADD")){
					Writer fileWriter = null;
					try {
						fileWriter = new FileWriter("output.txt", true);
					} catch (IOException e) {
						System.out.println("File not found");
					}
					try{
						boolean first = true;
						fileWriter.write("[");
						while ( !((myLine = buffRead.readLine()).equals("END"))) {
							String[] EmployeeArray = myLine.split(" ");	
							if(first != true){
								fileWriter.write(",");
							}
							fileWriter.write("{");
							fileWriter.write("\"lname\"");
							fileWriter.write(EmployeeArray[1]);
							fileWriter.write(":");
							fileWriter.write("\"fname\"");
							fileWriter.write(EmployeeArray[0]);
							fileWriter.write(":");
							fileWriter.write("\"phone\"");
							fileWriter.write(EmployeeArray[3]);
							fileWriter.write(":");
							fileWriter.write("\"dept\"");
							fileWriter.write(EmployeeArray[2]);
							fileWriter.write("}");
							first = false;
						}
						fileWriter.write("]");
					} catch(IOException e){
						System.out.println("I/O Exception");
					}
					fileWriter.close();
				}else if(array[0].equals("PRINT")){
					
				}else{
					
				}
				
				
			}
		} catch (IOException e) {
			System.out.println("I/O Exception");
		}
		
		
		
	}
}
