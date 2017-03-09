import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class MainDirectory {
	ArrayList<Employee> p;
	
	public MainDirectory() {
		p = new ArrayList<Employee>();
	}
	
	// ADD - listens for END command, adds employee
	public void add(ArrayList<Employee> list) {
		Gson g = new Gson();
		File file = new File("output.txt");		//Declare file for input
		FileReader input = null;
		BufferedReader buffRead = null;
		String output = "";
		try {
			input = new FileReader(file);				//Initialize the FileReader and Buffered Reader for input
			buffRead = new BufferedReader(input);
			try {
				output = buffRead.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException f) {
			System.out.print("\nError! File not found!");
		}
		ArrayList<Employee> ep = (g.fromJson(output, new TypeToken<Collection<Employee>>(){}.getType()));
		Iterator<Employee> it = ep.iterator();
		while(it.hasNext()){
			p.add(it.next());
		}
	}
	
	// PRINT - listens for PRINT, sends collection of employees via GSON
	public void print() {
		// for every entry, toString every employee
		Collections.sort(p);
		Iterator<Employee> it = p.iterator();
		if(!it.hasNext()){
			System.out.println("<empty directory");
		}
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		System.out.println();
	}
	
	// CLR - listens for CLR, empties the collection of employees
	public void clear() {
		p.clear();
	}
}
