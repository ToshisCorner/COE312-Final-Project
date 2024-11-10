package Environments;

import java.util.Scanner;

import Default.Environment;
import Game_Package.UI;

public class Workshop extends Environment implements Runnable
{
	public Thread t;
	UI ui;
	
	public Workshop()
	{
		t = new Thread(this);
	}
	public Thread getThread()
	{
		return t;
	}
	
	//--------------------------------------------------------
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		startSequence(in);
	}
	
	@Override
	public void startSequence(Scanner in) 
	{
		// TODO Auto-generated method stub
		System.out.println(
				"+-+-+-+-+ +-+-+ +-+-+-+ +-+-+-+-+-+-+-+-+\r\n"
				+ "|P|a|r|t| |1|:| |T|h|e| |W|o|r|k|s|h|o|p|\r\n"
				+ "+-+-+-+-+ +-+-+ +-+-+-+ +-+-+-+-+-+-+-+-+\n"
				);
		String content = "";
		
	}
	
	@Override
	public void lookAround() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void investigate() 
	{
		// TODO Auto-generated method stub
		
	}
}
