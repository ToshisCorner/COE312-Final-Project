package Game_Package;

import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args)
	{
		Game Instance = new Game();
		try 
		{
			Instance.beginSequence();
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Instance.gameSequence();
	}
}
