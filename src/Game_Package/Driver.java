package Game_Package;

import java.util.Scanner;

import Supplement.TCP_Client;

public class Driver 
{
	public static void main(String[] args)
	{
		
		Game Instance = new Game();
		try 
		{
			new TCP_Client("10.25.151.23", 4242);
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