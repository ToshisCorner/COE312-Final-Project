package Environments;

import java.util.Scanner;
import java.util.ArrayList;

import Default.Environment;
import Default.Item;
import Default.NPC;
import Game_Package.Game;
import Game_Package.UI;
import Items.W_Book;
import Items.W_Magnifying_Glass;
import Items.W_Watch;

public class Workshop extends Environment implements Runnable
{
	public Thread t;
	UI ui;
	NPC player;
	Game game;
	
	public Workshop(Game game)
	{
		this.game = game;
		t = new Thread(this);
		
		player = game.getPlayer(); // Passing the player character into environment
		
		Item book = new W_Book();
		Item magnifyingGlass = new W_Magnifying_Glass();
		Item watch = new W_Watch();
		
		Item_list = new ArrayList<Item>();
		Item_list.add(book);
		Item_list.add(magnifyingGlass);
		Item_list.add(watch);		
	}
	
	public Thread getThread()
	{
		return t;
	}
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		startSequence(in);
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
	
	@Override
	public void startSequence(Scanner in) 
	{
		// TODO Auto-generated method stub
		System.out.println(
				"+-+-+-+-+ +-+-+ +-+-+-+ +-+-+-+-+-+-+-+-+\r\n"
				+ "|P|a|r|t| |1|:| |T|h|e| |W|o|r|k|s|h|o|p|\r\n"
				+ "+-+-+-+-+ +-+-+ +-+-+-+ +-+-+-+-+-+-+-+-+\n"
				);

		ArrayList<String[]> dialogue = new ArrayList<String[]>();
		parseDialogue(dialogue);
		
		for(int i = 0;i < 9;i++)
		{
			for(String part: dialogue.get(i))
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
		}
		
		inputSequence(in);
		
		for(int i = 9;i < 11;i++)
		{
			for(String part: dialogue.get(i))
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
		}
		
		inputSequence(in);
		
		for(int i = 11;i < 13;i++)
		{
			for(String part: dialogue.get(i))
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
		}
		
		inputSequence(in);
		
		for(String part: dialogue.get(13))
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
		
		inputSequence(in);
		
		for(int i = 14;i < 16;i++)
		{
			for(String part: dialogue.get(i))
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
		}
		
		inputSequence(in);
		
		for(int i = 16;i < 20;i++)
		{
			for(String part: dialogue.get(i))
			{
				System.out.print(part + " ");
				
				try {Thread.sleep(100);} 
				catch (InterruptedException e) 
				{e.printStackTrace();}
			}
			System.out.println("\n");
			try {Thread.sleep(3000);} 
			catch (InterruptedException e) 
			{e.printStackTrace();}
		}
		
		inputSequence(in);
	}
	
	public void inputSequence(Scanner in) // THIS CAN BE TURNED INTO ITS OWN CLASS OR INTERFACE
	{
		while(true)
		{
			System.out.print("> ");
			
			String userInput = in.nextLine().trim().toLowerCase();
		
			switch(userInput)
			{
			case "check time":
				game.getPlayer().inventory.add(Item_list.get(2)); // Giving player the watch item
				// Add subject functionality to watch and observer functionality to player for checking time
				return;
			case "look around":
				// Implement lookAround() method
				return;
			case "inspect magnifying glass":
				// Implement item description
				return;
			case "inspect book":
				// Implement item description
				return;
			case "take magnifying glass":
				// add item to inventory
				return;
			case "take book":
				// add item to inventory
				return;
			default:
				System.out.println("try doing something else");
				break;
			}
		}
	}
	 
	public void parseDialogue(ArrayList<String[]> dialogue)
	{
		String content = "It’s been two years since you’ve started training as a \"Novel-Maker\", with aspirations to work alongside the best when it comes to creating resolutions to beautiful tales.";
		String[] parts = content.split("\\s");
		dialogue.add(parts);
		content = "You stare at the nametag they gave you when you first came here, \"Jack\", it says. You’ve spent countless hours in this workshop learning the in’s and out’s of navigating a story. You’ve learned languages, practiced techniques on investigation, persuasion, and reading expressions – all in an effort to perfect the ending to stories.";
		parts = content.split("\\s");
		dialogue.add(parts);
		content = "You reminisce about the happy and sad times you’ve had through-out the years, but before you could think…";
		parts = content.split("\\s");
		dialogue.add(parts);
		content = "The Guide: \" Jack… Are you even listening? \"";
		parts = content.split("\\s");
		dialogue.add(parts);
		content = "You look up, it’s \"The Guide\", your mentor, and the man who will be testing you today to see whether you are finally fit to craft your very first ending.";
		parts = content.split("\\s");
		dialogue.add(parts);
		content = "The Guide: \" I know you’re excited to finally jump into a story, but there’s a couple of things you need to know before you get started. \"";
		parts = content.split("\\s");
		dialogue.add(parts);
		content = "The Guide: \" Firstly, every story has its ending, and every ending happens on the (TIME WHEN GAME SHOULD END). This means that you must complete everything you want to do to ensure the ending you want before this time. To keep track of this, every one of you will get a watch. \"";
		parts = content.split("\\s");
		dialogue.add(parts);
		content = "You hear some mechanical clicking near your right wrist, and you look down to see a mechanical spider slowly circling your arm. It approaches your wrist, then wraps its eight legs around it. It’s abdomen slowly blossoms to reveal… an ordinary watch face.";
		parts = content.split("\\s");
		dialogue.add(parts);
		content = "The Guide: \" Try checking the time on your watch, or your spider. \" (hint: try saying ‘check time’)";
		parts = content.split("\\s");
		dialogue.add(parts);
		
		// User input to check time, then time is displayed (Watch is subject)
		
		content = "The Guide: \" Another thing! Before I forget, grab a magnifying glass from the main table. \"";
		parts = content.split("\\s");
		dialogue.add(parts);
		content = "You get up from your chair, and …  (hint: try looking around)";
		parts = content.split("\\s");
		dialogue.add(parts);
		
		// > look around
		
		content = "You look around, and a couple steps behind you, you see a large table, clearly divided into two by the differing items on each side. On one half of the table, you see an organized array of magnifying glasses. On the other half, you see a never-ending stack of books.";
		parts = content.split("\\s");
		dialogue.add(parts);
		content = "You walk up to … (hint: try inspecting an item)";
		parts = content.split("\\s");
		dialogue.add(parts);
		
		// > inspect ITEM (magnifying glass or book)
		
		content = "The Guide: \"That magnifying glass is a crucial item that will allow you to quickly investigate a multitude of things in your story, from characters, items, to environments. Keep it at arm’s reach, should you need some more information. \"";
		parts = content.split("\\s");
		dialogue.add(parts);
		content = "The Guide: \" Jack, go grab a magnifying glass first! \" ";
		parts = content.split("\\s");
		dialogue.add(parts);
		content = "The Guide: \" Finally! It’s the moment you’ve all been waiting for… Your first \\”Tale Hop\\”. Don’t be surprised if you feel nauseous as you jump into your first story, we’ve all experienced it. Quickly! Grab a book from the table, and envision the type of story you’d like to experience. \"";
		parts = content.split("\\s");
		dialogue.add(parts);
		
		// > inspect books
		
		content = "As you near the half of the table with the books, a particular volume catches your eye. You spot a thick book, the colour a dark crimson. You can’t read the text on the spine, the characters worn out, but you can’t help but pick it up.";
		parts = content.split("\\s");
		dialogue.add(parts);
		content = "You flip it open, and you cough as some dust spills out. You instinctively feel it… the creased upper corner of the pages, the stains on the side…this book is the one.";
		parts = content.split("\\s");
		dialogue.add(parts);
		content = "You prepare yourself mentally. \"The Guide\" told you how to do this, a long time ago, and it’s never left your mind. You breathe in and out, three breaths, and you say… ";
		parts = content.split("\\s");
		dialogue.add(parts);
		content = "\" Jump… \"";
		parts = content.split("\\s");
		dialogue.add(parts);
		
//		content = "";
//		parts = content.split("\\s");
//		dialogue.add(parts);
	}
}
