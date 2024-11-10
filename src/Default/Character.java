package Default;

import java.util.ArrayList;

public abstract class Character 
{
	private String name;
	private int health;
	public String dialogue;
	ArrayList<Item> inventory;
	
	public Character()
	{
		
	}
	
	Character(String _name, int _health, String _dialogue)
	{
		this.name = _name;
		this.health = _health;
		this.dialogue = _dialogue;
	}
		
	public abstract void interact();
	/*
	 * child class personalized method that contains the interaction sequence of the character
	 * There could be different dialogue options 
	 */
}