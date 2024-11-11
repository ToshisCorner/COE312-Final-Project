package Items;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Default.Item;
import Supplement.Message;
import Supplement.Observer;
import Supplement.Subject;

public class W_Watch extends Item implements Subject, Runnable
{

	private Thread t;
	public ArrayList<Observer> observers;
	
	private boolean timeRequested;
	private String currentTime;
	
	public W_Watch()
	{
		this.name = "watch";
		description = "";
		observers = new ArrayList<>();
		
		timeRequested = false;
		
		t = new Thread(this);
		t.start();
	}
	
	@Override
	public void use(String environmentName) 
	{
		// TODO Auto-generated method stub
		System.out.println("You used the watch!");
	}

	@Override
	public void registerObserver(Observer o) 
	{
		// TODO Auto-generated method stub
		if(!observers.contains(o))
		{
			observers.add(o);
		}
	}

	@Override
	public void removeObserver(Observer o) 
	{
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	@Override
	public void notifyObserver(Message m) 
	{
		// TODO Auto-generated method stub
		for(int i = 0;i < observers.size();i++)
		{
			Observer observer = observers.get(i);
			observer.update(m);
		}
	}

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		while(true)
		{
			if(timeRequested)
			{				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				Message timeMessage = new Message(this.name, "Current Time", dtf.format(now));
				
				if(!observers.isEmpty())
				{
					notifyObserver(timeMessage);
				}
				
				timeRequested = false;
			}

			try {Thread.sleep(1000);} 
			catch (InterruptedException e) 
			{e.printStackTrace();}
		}
	}
	
	public void requestTimeUpdate()
	{
		timeRequested = true;
	}

	@Override
	public void inspect() 
	{
		// TODO Auto-generated method stub
		
	}
	
}
