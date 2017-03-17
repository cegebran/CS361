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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Client extends JFrame implements ActionListener{
//test	
	public static void main(String[] args) {
		try {
			Client myGUI = new Client();
			myGUI.setVisible(true);
			
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
		
		Gson g = new Gson();
		String json = g.toJson(em);
		return json;
	}

	public Client(){//Making a GUI out of a constructor
		JTextField firstName = new JTextField("", 15);
		JTextField lastName = new JTextField("", 15);
		JTextField department = new JTextField("", 15);
		JTextField phone = new JTextField("", 15);
		JRadioButton genderMale = new JRadioButton("Male");
		JRadioButton genderFemale = new JRadioButton("Female");
		JRadioButton genderOther = new JRadioButton("Other");
		String[] listOfTitle = {"Mr.", "Ms", "Mrs.", "Dr.", "Col.", "Prof.", };
		JList title = new JList(listOfTitle);
		title.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		title.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		title.setVisibleRowCount(-1);  
//		JScrollPane listScroller = new JScrollPane(listOfTitle);
//		listScroller.setPreferredSize(new Dimension(250, 80));
		JButton submit = new JButton("Submit");
		JButton exit = new JButton("Exit");
		
		setTitle("Lab08");
		setSize(400, 400);
		setLocation(10, 200);
		setLayout(new FlowLayout());
		
	//		myFrame.addWindowListener(new WindowAdapter(){
	//			public void windowClosing(WindowEvent e){
	//				System.exit(0);
	//			}
	//		});
				
	//		submit.addActionListener(new MyActionListener());
	//		exit.addActionListener(new MyActionListener());
		
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
		myPanel2.setVisible(true);
		
		JPanel myPanel3 = new JPanel();
		myPanel3.setLayout(new GridLayout(0, 2));
		myPanel3.add(submit);
		myPanel3.add(exit);
		myPanel3.setVisible(true);
		
		getContentPane().add(myPanel1);	
		getContentPane().add(myPanel2);	
		getContentPane().add(myPanel3);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
