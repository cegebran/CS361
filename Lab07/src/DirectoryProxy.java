import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class DirectoryProxy {
	MainDirectory md;
	public DirectoryProxy(){
		md = new MainDirectory();
	}
	
	public void add(ArrayList<Employee> employees){
		Gson g = new Gson();
		String out = g.toJson(employees);
		FileWriter fw = null;
		try {
			fw = new FileWriter("output.txt", false);
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
		md.add(null);
	}
	
	public void clear(){
		md.clear();
	}
	
	public void print(){
		md.print();
	}
}