package Supplement;

public class TCP_Client implements Runnable {

	String host;
	int port;

	TCP_Client(String host, int port) {
		this.host = host;
		this.port = port;
		Thread t = new Thread(this);
		t.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
