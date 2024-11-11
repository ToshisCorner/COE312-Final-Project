package NPCs;

import java.util.ArrayList;

import Default.NPC;
import Supplement.Message;
import Supplement.Observer;
import Supplement.Subject;

public class Jack_Stone extends NPC implements Observer
{
	public ArrayList<Subject> subjects;
	private boolean msgReceived;
	
	public Jack_Stone() 
	{
		// TODO Auto-generated constructor stub
		super("Jack Stone", 100, "nothing so far (CHANGE THIS)");
		
		this.subjects = new ArrayList<>();
	}
	
	@Override
	public void interact() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Message m) 
	{
		// TODO Auto-generated method stub
		if(m.origin.equals("watch"))
		{
			String parts[] = ("You raise your wrist to check your watch... The time is " + m.payload).split("\\s");
			for(String part: parts)
			{
				System.out.print(part + " ");
				
				try {Thread.sleep(50);} 
				catch (InterruptedException e) 
				{e.printStackTrace();}
			}
			System.out.println("\n");
			try {Thread.sleep(3000);} 
			catch (InterruptedException e) 
			{e.printStackTrace();}
			msgReceived = true;
		}
	}
	
	public boolean messageReceived()
	{
		return msgReceived;
	}
	public void resetMessageFlag()
	{
		msgReceived = false;
	}
}


