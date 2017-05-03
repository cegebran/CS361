package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {

    // a shared area where we get the POST data and then use it in the other handler
    static boolean valid = true;
	static int parseFirstLength = 0;
	static int i = 0;
	static String myLine = "";
	static FileReader fileInput = null;
	static BufferedReader buffRead = null;
	static String[] userInputParse = null;
	static String sharedResponse = "";
    static boolean gotMessageFlag = false;
    static ArrayList<Racer> racers = new ArrayList<Racer>();
    static TreeMap<String, String> map = new TreeMap<String, String>();

    public static void main(String[] args) throws Exception {
    	
    	File file = new File("racers.txt");						//Declare file for input
		
		try {
			
			fileInput = new FileReader(file);					//Initialize the FileReader and Buffered Reader for input
			buffRead = new BufferedReader(fileInput);
			
		} catch (FileNotFoundException f) {
			
			System.out.print("\nError! File not found!");
			System.exit(0);
			
		}
		
		while (valid) {
			
			try {
				
				if ((myLine = buffRead.readLine()) != null) {				//Loop while there is still a next line
					
					userInputParse = myLine.split(",");						//Parse the input line	
					map.put(userInputParse[0], userInputParse[1] + " " + userInputParse[2]);
				
				} else {
					
					valid = false;
					
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
		}
    	
        // set up a simple HTTP server on our local host
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        
        // create a context to get the request for the POST
        server.createContext("/sendresults",new PostHandler());
        server.setExecutor(null); // creates a default executor
        
        // create a context to get the request for the POST
        server.createContext("/displayresults",new HtmlHandler());
        
        // create a context to create CSS
        server.createContext("/displayresults/style.css",new CssHandler());

        // get it going
        System.out.println("Starting Server...");
        server.start();
    }

    static class PostHandler implements HttpHandler {
    	
        public void handle(HttpExchange transmission) throws IOException {

        	// clear results from previous run
            racers.clear();
        	
        	//  shared data that is used with other handlers
            sharedResponse = "";

            // set up a stream to read the body of the request
            InputStream inputStr = transmission.getRequestBody();

            // set up a stream to write out the body of the response
            OutputStream outputStream = transmission.getResponseBody();

            // string to hold the result of reading in the request
            StringBuilder sb = new StringBuilder();

            // read the characters from the request byte by byte and build up the sharedResponse
            int nextChar = inputStr.read();
            while (nextChar > -1) {
                sb=sb.append((char)nextChar);
                nextChar=inputStr.read();
            }

            // create our response String to use in other handler
            sharedResponse = sb.toString();

            // respond to the POST with ROGER
            String postResponse = "ROGER JSON RECEIVED";

            System.out.println("Begin of response\n");
            System.out.println("response: " + sharedResponse);

            // assume that stuff works all the time
            transmission.sendResponseHeaders(300, postResponse.length());

            // write it and return it
            outputStream.write(postResponse.getBytes());

            outputStream.close();
            
			Gson g = new Gson();
			// set up the header
			String response = "";
            String[] tokens = sharedResponse.split(";");
            if(tokens[0].equals("ADD")) {
            	try {
    				if (!sharedResponse.isEmpty()) {
    					ArrayList<Racer> fromJson = g.fromJson(tokens[1],
    							new TypeToken<Collection<Racer>>() {
    							}.getType());
    					racers.addAll(fromJson);
    					
    					response += "Before sort\n";
    					for (Racer e : racers) {
    						response += e + "\n";
    					}
    					Collections.sort(racers);
    					response += "\nAfter sort\n";
    					for (Racer e : racers) {
    						response += e + "\n";
    					}
    				}
    			} catch (JsonSyntaxException e) {
    				e.printStackTrace();
    			}
                response += "\nEnd of response\n";
                System.out.println(response);
            } else if(tokens[0].equals("PRINT")) {
            	Iterator<Racer> it = racers.iterator();
            	while(it.hasNext()){
            		System.out.println(it.next().toString());
            	}
            	System.out.println("\nEnd of response");
            } else if(tokens[0].equals("CLEAR")) {
            	racers.clear();
            	System.out.println("\nEnd of response");
            }
			
            // write out the response
            transmission.sendResponseHeaders(200, response.length());
            OutputStream os = transmission.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
        
    }
    
    static class HtmlHandler implements HttpHandler {
    	
        public void handle(HttpExchange transmission) throws IOException {

            // set up a stream to write out the body of the response
            OutputStream outputStream = transmission.getResponseBody();

            String htmlString = "";
            StringBuilder result = new StringBuilder();
			result.append("<!DOCTYPE html>").append("<html>").append("<head>");
			result.append("<link href=\"http://localhost:8000/displayresults/style.css\" rel=\"stylesheet\" type=\"text/css\" />");
			result.append("<title>Race Results</title>");
			result.append("</head>");
			result.append("<body>");
			result.append("<table width=\"100%\">");
			result.append("<h1 align=\"center\">Race Results</h1>");
			result.append("<tr><th>").append("Place").append("</td><th>").append("Bib Number").append("</td><th>").append("Name").append("</td><th>").append("Time").append("</th></tr>");
			int counter = 1;
			for (Racer r : racers) {
				String name = map.get(r.getBibNumber());
				// replace "null" in table for unmatched bib number to <empty> name
				if (name == null) {
					name = "";
				}
				result.append("<tr><td>").append(counter).append("</td><td>").append(r.getBibNumber()).append("</td><td>").append(name).append("</td><td>").append(r.getTime()).append("</td></tr>");
				counter += 1;
			}
			result.append("</table>");
			result.append("</body>").append("</html>");

			// convert to String
			htmlString = result.toString();
			
            // assume that stuff works all the time
            transmission.sendResponseHeaders(300, htmlString.length());

            // write it and return it
            outputStream.write(htmlString.getBytes());

            outputStream.close();
            
        }
        
    }
    
    static class CssHandler implements HttpHandler {
    	
        public void handle(HttpExchange transmission) throws IOException {

        	// set up a stream to write out the body of the response
            OutputStream outputStream = transmission.getResponseBody();

            //hard code CSS
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("table { border-collapse: collapse; }");
            stringBuilder.append("table, tr, td, th { border: 1px solid black; text-align: center; }");
		    stringBuilder.append("th { font-size: 25px; color: red; }");
		    stringBuilder.append("tr { background-color: white; font-size: 20px; }");
		    stringBuilder.append("p { text-align: center; font-family: verdana; font-size: 20px; }");

			// convert to String
			String htmlString = stringBuilder.toString();
			
            // assume that stuff works all the time
            transmission.sendResponseHeaders(300, htmlString.length());

            // write it and return it
            outputStream.write(htmlString.getBytes());

            outputStream.close();
            
        }
        
    }
    
}