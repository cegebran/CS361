import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.swing.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Client {
//test
	private JTextField firstName("First name");
	private JTextField lastName("Last Name");
	private JTextField department("Department");
	private JTextField phone("Phone");
	private JRadioButton gender("Gender");
	private JList title("Title");
	private JButton submit("Submit (send)");
	private JButton exit("Exit");
	
	public static void main(String[] args) {
		try {
			makeFrame();
			
			System.out.println("in the client");

			// Client will connect to this location
			URL site = new URL("http://localhost:8000/sendresults");
			HttpURLConnection conn = (HttpURLConnection) site.openConnection();

			// now create a POST request
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			DataOutputStream out = new DataOutputStream(conn.getOutputStream());

			// build a string that contains JSON from console
			String content = "";
			content = getJSON();

			// write out string to output buffer for message
			out.writeBytes(content);
			out.flush();
			out.close();

			System.out.println("Done sent to server");

			InputStreamReader inputStr = new InputStreamReader(conn.getInputStream());

			// string to hold the result of reading in the response
			StringBuilder sb = new StringBuilder();

			// read the characters from the request byte by byte and build up
			// the Response
			int nextChar;
			while ((nextChar = inputStr.read()) > -1) {
				sb = sb.append((char) nextChar);
			}
			System.out.println("Return String: " + sb);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getJSON() {

		ArrayList<Employee> em = new ArrayList<>();
		em.add(new Employee("Eric", "Fritz", "Computer Science", "1"));
		em.add(new Employee("Tanawat", "Khun", "Computer Science", "2"));
		em.add(new Employee("Foo", "Bar", "Baz", "3"));
		em.add(new Employee("Donald", "Duck", "Disney Animals", "4"));
		Gson g = new Gson();
		String json = g.toJson(em);
		return json;
	}

	private void makeFrame(){
		
		myFrame = new JFrame("Lab 08");
		myFrame.setSize(1000, 800);
		myFrame.setLocation(10, 200);
		myFrame.setLayout(new FlowLayout());
		
		myFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		myPanel = new JPanel();
		myPanel.setLayout(new FlowLayout());
		
		myPanel.add(firstName);
		myPanel.add(lastName);
		myPanel.add(department);
		myPanel.add(phone);
		myPanel.add(gender);
		myPanel.add(title);
		myPanel.add(submit);
		myPanel.add(exit);
		myPanel.setVisible(true);
		
		myFrame.getContentPane()clone().add(myPanel);
			
			
	}
}
