import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
		
		final JTextField lastName = new JTextField("", 15);
		
		final JTextField department = new JTextField("", 15);
		
		final JTextField phone = new JTextField("", 15);
		
		JRadioButton genderMale = new JRadioButton("Male");
		genderMale.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  genderString = "male";
		      }
		});
		JRadioButton genderFemale = new JRadioButton("Female");
		genderFemale.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  genderString = "female";
		      }
		});
		JRadioButton genderOther = new JRadioButton("Other");
		genderOther.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  genderString = "other";
		      }
		});
		ButtonGroup group = new ButtonGroup();
		group.add(genderMale);
		group.add(genderFemale);
		group.add(genderOther);
		String[] listOfTitle = {"Mr.", "Ms", "Mrs.", "Dr.", "Col.", "Prof.", };
		final JComboBox title = new JComboBox(listOfTitle);
		title.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				titleString = title.getSelectedItem().toString();
			}
            
        });
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
	    			
	    			fname = firstName.getText();
	    			lname = lastName.getText();
	    			departmentString = department.getText();
	    			phoneString = phone.getText();
	    			
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
		setSize(700, 240);
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
