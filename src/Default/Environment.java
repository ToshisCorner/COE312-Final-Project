package Default;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Environment 
{
	protected String name;
	protected String description;
	
	protected ArrayList<NPC> NPC_list;
	protected ArrayList<Item> Item_list;	
	
	Thread t;
		
	public Environment()
	{
		// parametrized constructor
	}
	
	public Thread getThread()
	{
		return t;
	}
	
	public abstract void startSequence(Scanner in);
	
	public abstract void lookAround();
	/* 
	 * lookAround is personalized for every child environment
	 * this gives you a basic description of the environment + where you can go
	*/
	public abstract void investigate();
	/*
	 * investigate tells you about the characters in an environment and the objects that can be used
	 * We can make use of sensors to simulate being cautious (volume sensor for being quiet, gyroscope for sneaking around, etc)
	 * We can also use the gyroscope in order to simulate looking around and place items and characters at different locations
	*/
}