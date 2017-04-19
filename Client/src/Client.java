import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.google.gson.Gson;

public class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	static String bibNumber = "";
	static String time = "";

	public static void main(String[] args) {
		
		Client myGUI = new Client();
		myGUI.setVisible(true);
		myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("In the client");

	}
	
	public Client() {
		
		final JTextField bibNumberField = new JTextField("", 15);
		
		final JTextField timeField = new JTextField("", 15);
		
		final JButton add = new JButton("Add");
		
		add.addActionListener(new ActionListener() {
	        
			public void actionPerformed(ActionEvent e) {
	        	
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
	    			bibNumber = bibNumberField.getText();
	    			time = timeField.getText();
	    			
	    			String content = "";
	    			content = "ADD;" + getJSON();

	    			// write out string to output buffer for message
	    			out.writeBytes(content);
	    			out.flush();
	    			out.close();
	    			InputStreamReader inputStr = new InputStreamReader(conn.getInputStream());

	    			// string to hold the result of reading in the response
	    			StringBuilder sb = new StringBuilder();

	    			// read the characters from the request byte by byte and build up the response
	    			int nextChar;
	    			while ((nextChar = inputStr.read()) > -1) {
	    				sb = sb.append((char) nextChar);
	    			}
	    			System.out.println("Return String: " + sb);
	    			
	    			bibNumberField.setText("");
	    			timeField.setText("");

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
	    			InputStreamReader inputStr = new InputStreamReader(conn.getInputStream());

	    			// string to hold the result of reading in the response
	    			StringBuilder sb = new StringBuilder();

	    			// read the characters from the request byte by byte and build up the response
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
	    			InputStreamReader inputStr = new InputStreamReader(conn.getInputStream());

	    			// string to hold the result of reading in the response
	    			StringBuilder sb = new StringBuilder();

	    			// read the characters from the request byte by byte and build up the response
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
	        
			public void actionPerformed(ActionEvent e) {
	        	
				Container frame = add.getParent();
	            do 
	                frame = frame.getParent(); 
	            while (!(frame instanceof JFrame));                                      
	            ((JFrame) frame).dispose();
	            System.exit(0);
	        }
	    });
				
		setTitle("Lab09");
		setSize(700, 240);
		setLocation(10, 200);
		setLayout(new FlowLayout());
		JPanel myPanel1 = new JPanel();
		myPanel1.setLayout(new GridLayout(0, 2));
		myPanel1.add(new JLabel("Bib Number"));
		myPanel1.add(bibNumberField);
		myPanel1.add(new JLabel("Time"));
		myPanel1.add(timeField);
		myPanel1.setVisible(true);
		
		JPanel myPanel2 = new JPanel();
		myPanel2.setLayout(new GridLayout(0, 4));
		myPanel2.add(add);
		myPanel2.add(print);
		myPanel2.add(clear);
		myPanel2.add(exit);
		myPanel1.add(myPanel2);
		myPanel2.setVisible(true);
		
		getContentPane().add(myPanel1);	
		
	}

	private static String getJSON() {

		ArrayList<Racer> racer = new ArrayList<>();
		racer.add(new Racer(bibNumber, time));
		Gson g = new Gson();
		String json = g.toJson(racer);
		return json;
		
	}

}
