import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;

public class DirectoryEditor {
	public static void main(String[] args){
		
		File file = new File("InputData.txt");		//Declare file for input
		FileReader input = null;
		BufferedReader buffRead = null;
		String myLine = "";	 //Buffer string
		ArrayList<Employee> employees = new ArrayList<Employee>();
		DirectoryProxy dp = new DirectoryProxy();
		
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
					dp.clear();
				}
				else if(array[0].equals("ADD")){
					try{
						while ( !((myLine = buffRead.readLine()).equals("END"))) {
							String[] EmployeeArray = myLine.split(" ");	
							Employee tmp = new Employee(EmployeeArray[1], EmployeeArray[0], EmployeeArray[3], EmployeeArray[2]);
							employees.add(tmp);
						}
					}catch(IOException e){
						System.out.println("I/O Exception");
					}
					dp.add(employees);
					employees.clear();
				}else if(array[0].equals("PRINT")){
					dp.print();
				}				
			}
		} catch (IOException e) {
			System.out.println("I/O Exception");
		}
		
		
		
	}
}
