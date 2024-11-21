package Supplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TCP_Client implements Runnable {

	private String host;
	private int port;
	private boolean isWaving;

	public TCP_Client(String host, int port) {
		this.host = host;
		this.port = port;
		this.isWaving = false;

		Thread t = new Thread(this);
		t.start();
	}

	private JSONParser parser = new JSONParser();

	@Override
	public void run() {
		try {
			Socket socket = new Socket(this.host, this.port);
			InputStream input = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			String line;

			double previousX = 0.0;
			double previousY = 0.0;
			double previousZ = 0.0;

			while ((line = br.readLine()) != null) {

				JSONObject jsonObject = (JSONObject) parser.parse(line);

				JSONObject accObject = (JSONObject) jsonObject.get("accelerometer");

				JSONArray accValues = (JSONArray) accObject.get("value");

				double currentX = (double) accValues.get(0);
				double currentY = (double) accValues.get(1);
				double currentZ = (double) accValues.get(2);

				// Detect waving based on rapid changes in X or Y axis
				if (Math.abs(currentX - previousX) > 5.0 || Math.abs(currentY - previousY) > 5.0 || Math.abs(currentZ - previousZ) > 5.0) {
	                setWaving(true);
	                System.out.println("Waving detected!");
	            } else {
	                setWaving(false);
	            }

				try {
					Thread.sleep(100); // Sample rate of 100ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("I/O error: " + ex.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public synchronized boolean isWaving() {
	    return isWaving;
	}

	private synchronized void setWaving(boolean waving) {
	    this.isWaving = waving;
	}

	
	
}
