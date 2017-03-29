import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Client extends JFrame{
static String fname = "";
static String lname = "";
static String departmentString = "";
static String phoneString = "";
static String titleString = "";
static String genderString = "";

	public static void main(String[] args) {
		
		Client myGUI = new Client();
		myGUI.setVisible(true);
		System.out.println("in the client");
	
	}
	public Client(){//Making a GUI out of a constructor
		final JTextField firstName = new JTextField("", 15);
		firstName.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        System.out.println("First Name=" + firstName.getText());
		        fname = firstName.getText();
		      }
		});
		final JTextField lastName = new JTextField("", 15);
		lastName.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        System.out.println("Last Name=" + lastName.getText());
		        lname = lastName.getText();
		      }
		});
		final JTextField department = new JTextField("", 15);
		department.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        System.out.println("Department=" + department.getText());
		        departmentString = department.getText();
		      }
		});
		final JTextField phone = new JTextField("", 15);
		phone.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        System.out.println("Phone=" + phone.getText());
		        phoneString = phone.getText();
		      }
		});
		JRadioButton genderMale = new JRadioButton("Male");
		genderMale.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  System.out.println("Gender = male");
		    	  genderString = "male";
		      }
		});
		JRadioButton genderFemale = new JRadioButton("Female");
		genderFemale.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  System.out.println("Gender = female");
		    	  genderString = "female";
		      }
		});
		JRadioButton genderOther = new JRadioButton("Other");
		genderOther.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  System.out.println("Gender = other");
		    	  genderString = "other";
		      }
		});
		ButtonGroup group = new ButtonGroup();
		group.add(genderMale);
		group.add(genderFemale);
		group.add(genderOther);
		String[] listOfTitle = {"Mr.", "Ms", "Mrs.", "Dr.", "Col.", "Prof.", };
		final JList title = new JList(listOfTitle);
		title.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
			    if (e.getKeyCode() == KeyEvent.VK_ENTER){
			           titleString = (String) title.getSelectedValue();	
			           System.out.print("Title = " + titleString);
			    }
			}
			});
		title.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		title.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		title.setVisibleRowCount(-1);  
//		JScrollPane listScroller = new JScrollPane(listOfTitle);
//		listScroller.setPreferredSize(new Dimension(250, 80));
		final JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
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
	    			content = "ADD;" + getJSON();

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

	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		JButton print = new JButton("Print");
		print.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	    			// Client will connect to this location
	    			URL site = new URL("http://localhost:8000/sendresults");
	    			HttpURLConnection conn = (HttpURLConnection) site.openConnection();

	    			// now create a POST request
	    			conn.setRequestMethod("POST");
	    			conn.setDoOutput(true);
	    			conn.setDoInput(true);
	    			DataOutputStream out = new DataOutputStream(conn.getOutputStream());

	    			// build a string that contains JSON from console
	    			String content = "PRINT";

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

	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	    			// Client will connect to this location
	    			URL site = new URL("http://localhost:8000/sendresults");
	    			HttpURLConnection conn = (HttpURLConnection) site.openConnection();

	    			// now create a POST request
	    			conn.setRequestMethod("POST");
	    			conn.setDoOutput(true);
	    			conn.setDoInput(true);
	    			DataOutputStream out = new DataOutputStream(conn.getOutputStream());

	    			// build a string that contains JSON from console
	    			String content = "CLEAR";

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

	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	Container frame = add.getParent();
	            do 
	                frame = frame.getParent(); 
	            while (!(frame instanceof JFrame));                                      
	            ((JFrame) frame).dispose();
	            System.exit(0);
	        }
	    });
				
		setTitle("Lab08");
		setSize(700, 500);
		setLocation(10, 200);
		setLayout(new FlowLayout());
		JPanel myPanel1 = new JPanel();
		myPanel1.setLayout(new GridLayout(0, 2));
		myPanel1.add(new JLabel("First Name"));
		myPanel1.add(firstName);
		myPanel1.add(new JLabel("Last Name"));
		myPanel1.add(lastName);
		myPanel1.add(new JLabel("Department"));
		myPanel1.add(department);
		myPanel1.add(new JLabel("Phone"));
		myPanel1.add(phone);
		myPanel1.add(new JLabel("Title"));
		myPanel1.add(title);
		myPanel1.setVisible(true);
		
		JPanel myPanel2 = new JPanel();
		myPanel2.setLayout(new GridLayout(0, 3));
		myPanel2.add(genderMale);
		myPanel2.add(genderFemale);
		myPanel2.add(genderOther);
		myPanel1.add(myPanel2);
		myPanel2.setVisible(true);
		
		
		JPanel myPanel3 = new JPanel();
		myPanel3.setLayout(new GridLayout(0, 4));
		myPanel3.add(add);
		myPanel3.add(print);
		myPanel3.add(clear);
		myPanel3.add(exit);
		myPanel1.add(myPanel3);
		myPanel3.setVisible(true);		
		
		getContentPane().add(myPanel1);	
	}

	private static String getJSON() {

		ArrayList<Employee> em = new ArrayList<>();
		em.add(new Employee(fname, lname, departmentString, phoneString, titleString, genderString));
		Gson g = new Gson();
		String json = g.toJson(em);
		return json;
	}

	
}
