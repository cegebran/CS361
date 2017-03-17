/**
 * Simple HTTP handler for testing ChronoTimer
 */
package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Test {

    // a shared area where we get the POST data and then use it in the other handler
    static String sharedResponse = "";
    static boolean gotMessageFlag = false;
    static ArrayList<Employee> employees = new ArrayList<Employee>();

    public static void main(String[] args) throws Exception {

        // set up a simple HTTP server on our local host
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // create a context to get the request for the POST
        server.createContext("/sendresults",new PostHandler());
        server.setExecutor(null); // creates a default executor

        // get it going
        System.out.println("Starting Server...");
        server.start();
    }

    static class PostHandler implements HttpHandler {
        public void handle(HttpExchange transmission) throws IOException {

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

            System.out.println("response: " + sharedResponse);

            // assume that stuff works all the time
            transmission.sendResponseHeaders(300, postResponse.length());

            // write it and return it
            outputStream.write(postResponse.getBytes());

            outputStream.close();
            
            String response = "Begin of response\n";
			Gson g = new Gson();
			// set up the header
            System.out.println(response);
            String[] tokens = response.split(";");
            if(tokens[0].equals("ADD")){
            	try {
    				if (!sharedResponse.isEmpty()) {
    					System.out.println(response);
    					ArrayList<Employee> fromJson = g.fromJson(sharedResponse,
    							new TypeToken<Collection<Employee>>() {
    							}.getType());
    					employees.addAll(fromJson);

    					System.out.println(response);
    					response += "Before sort\n";
    					for (Employee e : employees) {
    						response += e + "\n";
    					}
    					Collections.sort(employees);
    					response += "\nAfter sort\n";
    					for (Employee e : employees) {
    						response += e + "\n";
    					}
    				}
    			} catch (JsonSyntaxException e) {
    				e.printStackTrace();
    			}
                response += "End of response\n";
                System.out.println(response);
            }
            else if(tokens[0].equals("PRINT")){
            	Iterator<Employee> it = employees.iterator();
            	while(it.hasNext()){
            		System.out.println(it.next().toString());
            	}
            }
            else if(tokens[0].equals("CLEAR")){
            	employees.clear();
            }
			
            // write out the response
            transmission.sendResponseHeaders(200, response.length());
            OutputStream os = transmission.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}