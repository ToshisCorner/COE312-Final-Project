package Supplement;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Items.W_Book;

public class TCP_Client implements Runnable {

	String host;
	int port;
	W_Book book;

	public TCP_Client(String host, int port) {
		this.host = host;
		this.port = port;
		Thread t = new Thread(this);
		t.start();

	}

	public TCP_Client(W_Book book) {
		this.book = book;
		Thread t = new Thread(this);
		t.start();
	}

	JSONParser parser = new JSONParser();

	@Override
	public void run() {

		try {
			Socket socket = new Socket(this.host, this.port);
			InputStream input = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(input);
			// -------------------------------- new reader -------------------------------
			BufferedReader br = new BufferedReader(reader);
			String line = "";

			int count = 0;

			while ((line = br.readLine()) != null) {

				JSONObject jsonObject = (JSONObject) parser.parse(line);

				JSONObject accObject = (JSONObject) jsonObject.get("accelerometer");

				JSONArray accValues = (JSONArray) accObject.get("value");

				// double x_axis = (double) accValues.get(0);
				// double y_axis = (double) accValues.get(1);
				double z_axis = (double) accValues.get(2);

				if (Math.abs(z_axis) > 18.0) {

					System.out.println();
					count++;
				} else if (count < 4) {
					book.jumpSequence();
					break;
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
}