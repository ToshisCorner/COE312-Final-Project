package Default;

import Supplement.Subject;

public abstract class Item implements Subject 
{
	protected String name;
	protected String description;
	
	public Item()
	{
		// parametrized constructor
	}

	public abstract void use(String environmentName);
	public void inspect()
	{
		System.out.println(description);
	}
	/*
	 * child class personalized method that gives a description of the item and where it can be used
	 */
	
} 