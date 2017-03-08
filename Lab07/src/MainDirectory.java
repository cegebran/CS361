import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class MainDirectory {
	
	public MainDirectory() {
		ArrayList<Employee> p = new ArrayList<Employee>();
	}
	
	// ADD - listens for END command, adds employee
	public void add() {
		// just add to ArrayList
	}
	
	// PRINT - listens for PRINT, sends collection of employees via GSON
	public void print() {
		// for every entry, toString every employee
	}
	
	// CLR - listens for CLR, empties the collection of employees
	public void clear() {
		
	}
}
