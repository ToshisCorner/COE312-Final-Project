package Game_Package;

import Default.Environment;
import Environments.Workshop;

public class Game 
{
	Environment currentEnvironment;
	
	public Game()
	{
		currentEnvironment = new Workshop();
	}
}
