package Default;

import java.util.ArrayList;

public abstract class Environment 
{
	String name;
	String description;
	
	ArrayList<Character> NPC_list;
	ArrayList<Item> Item_list;	
	
	public Environment()
	{
		// parametrized constructor
	}
	
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
	
	public void interact()
	{
		/*
		 * method for initiating the interaction sequence with a character
		 * If the character is in the current environment, then they can be interacted with
		*/ 
	}
	
	public void use()
	{
		/*
		 * method for initiating the usage sequence of an item
		 * If the item is in the current environment, then they can be used
		*/ 
	}	
}