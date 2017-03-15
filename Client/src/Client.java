import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.ButtonGroup;

import java.swing.*;
import java.awt.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Client{
//test	
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
		JTextField firstName = new JTextField("First Name");
		JTextField lastName = new JTextField("Last Name");
		JTextField department = new JTextField("Department");
		JTextField phone = new JTextField("Phone");
		JRadioButton genderMale = new JRadioButton("Male");
		JRadioButton genderFemale = new JRadioButton("Female");
		JList title = new JList();
		JButton submit = new JButton();
		JButton exit = new JButton();
		
		myFrame = new JFrame("Lab 08");
		myFrame.setSize(1000, 800);
		myFrame.setLocation(10, 200);
		myFrame.setLayout(new FlowLayout());
		
		myFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		
		.addActionListener(new MyActionListener());
		.addActionListener(new MyActionListener());
		.addActionListener(new MyActionListener());
		.addActionListener(new MyActionListener());
		.addActionListener(new MyActionListener());
		.addActionListener(new MyActionListener());
		.addActionListener(new MyActionListener());
		
		myPanel = new JPanel();
		myPanel.setLayout(new FlowLayout());
		myPanel.add(firstName);
		myPanel.add(lastName);
		myPanel.add(department);
		myPanel.add(phone);
		ButtonGroup group1 = new ButtonGroup();
		group1.add(genderMale);
		group1.add(genderFemale);
		myPanel.add(gendeMale);
		myPanel.add(genderFemale);
		myPanel.add(title);
		myPanel.add(submit);
		myPanel.add(exit);
		myPanel.setVisible(true);
		myFrame.getContentPane().add(myPanel);	
	}
	
	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
}
