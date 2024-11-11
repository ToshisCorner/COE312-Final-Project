package Default;

import java.util.ArrayList;

import Supplement.Observer;

public abstract class NPC implements Observer
{
	public String name;
	public  int health;
	public String dialogue;
	public ArrayList<Item> inventory;
	
	public NPC(String _name, int _health, String _dialogue)
	{
		this.name = _name;
		this.health = _health;
		this.dialogue = _dialogue;
		
		inventory = new ArrayList<Item>();
	}
		
	public abstract void interact();
	/*
	 * child class personalized method that contains the interaction sequence of the character
	 * There could be different dialogue options 
	 */
}