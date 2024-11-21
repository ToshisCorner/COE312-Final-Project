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
import NPCs.Jack_Stone;
import Supplement.TCP_Client;

public class Workshop extends Environment implements Runnable
{
	Jack_Stone playerCharacter;
	public Thread t;
	UI ui;
	Game game;
	TCP_Client tcp;
	W_Book book;
	
	public Workshop(Game game)
	{
		this.game = game;
		this.name = "Workshop";
		t = new Thread(this);
		
		playerCharacter = (Jack_Stone) game.getPlayer();
		
		book = new W_Book();
		W_Magnifying_Glass magnifyingGlass = new W_Magnifying_Glass();
		W_Watch watch = new W_Watch();
		
		Item_list = new ArrayList<Item>();
		Item_list.add(book);
		Item_list.add(magnifyingGlass);
		Item_list.add(watch);		
		 tcp = new TCP_Client("192.168.0.176", 4242);
		
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
		
		System.out.println("\n<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
		System.out.println(
				"%@%%#####%%%%%%%%%%@@@@%%%%%%%%%%%%%%%%%%#%%%%%%%############**##%%%#######################################%@@@%%#%######%%%%##############################\r\n"
				+ "%###%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#%%%%############*###%%%@@@%##############################################%%%%%%%%%###############################\r\n"
				+ "%%%%%%%%%#%%%%%%%%%%%%%%%%%%%%%%%%%%%#%%%#####%######**##%%%@@@@@@@@@##########################################@@###########%%######%%#####################\r\n"
				+ "%%%%%%%%%%%@@%%%%%%%%%%%#%%%%%#%%%%%#################%%%@%@@@@@@@@@@%########################################@@@@@@################%%%%%######%############\r\n"
				+ "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%############**###%%@%%%@@@@@@@@@@#########################################@@@@@@@##########################%%%@@%%###%%%@%\r\n"
				+ "#%%%%%%%%%%%%%%%%%%%%%%%%%%%#####%#############%%%%@@@@@@@@@@@%##########################################%@@@@@@@#####################################%%@@%\r\n"
				+ "%##%%%%%%%%%%%%%%%%%%%%%#############*###%%%@%@@@@@@@@@@@@###############################%%#***#########@@@@@@@############################################\r\n"
				+ "%%###%%%%%%%%%%%%%%%###%%%#######*###%%%%@@@@@@@@@@@@%################################%@%#######%#*#%@@@@@@@@@#############################################\r\n"
				+ "%##%%#%%%%%%%%%%####%############%%%%@%@@@@@@@@@@%##################################%#+++###########%@@@@@@@###############################################\r\n"
				+ "#%%%%%##%%%####%%%######*#####%%@@@@@@@@@@@@@%#####*+##############################%%##%%%%%%%%@@@@@@#@%@@#################################################\r\n"
				+ "###%%%%%####%%#######**#%#%%%%%@@@@@@@@@@@#######+++++++++++*####%%#######%%##%####%#%%#############%@%@%##################################################\r\n"
				+ "##%##%%%%#######**##%%%%%%@@@@@@@@@@@@%########++++++++++++++++++++++*#############%##################@%%##################################################\r\n"
				+ "@%################%%%@@@@@@@@@@@@@###########+++++++++++++++++++++++++++++++*######@%##################%###################################################\r\n"
				+ "@@@########%%%%%%%@@@@@@@@@@@@#############*+++++++*+++*+*+++++++++++++++++++++++++#%%%####################################################################\r\n"
				+ "@@@@%#%%%%%%%@@@@@@@@@@@@@################++++++++*++**++++++*++++*++++*+++++++++++++++++++**#######+#@%###################################################\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@%#################+++++++++*++++++*++*+**+++++++++**++*++++++++++++++++++++++++#%##########%%%%%%%%##################################\r\n"
				+ "@@@@@@@@@@@@@@@@@@####################++++++++++*++*+++*++*+**++**++*++*++*+*++**+**++**++++++++++++++++++#%@@@@@@@@@@@@@@@@@@@%###########################\r\n"
				+ "@@@@@@@@@@@@@@%#####################+++++++++++++*++*++++++++++++***+*++**++++*++**++**+*+++++++++++++++%@@@@@@@@@@@@@@@@@@@@@@@@@@%#######################\r\n"
				+ "%%%@@@@@@@%##################%####*++++++++*++**+**+++++++*++*+++++++++**++*++*++**+*++**+++**++*++++++@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#####################\r\n"
				+ "####%@%%########################*++++++*++*++*++*++**+++++++++++*+**+++++++*+++*+++++++**+++***+++++++%@@@@@@@@@@@%%%%%@@@@@@@@@@@@@@@@@###################\r\n"
				+ "########%%%%####%#############+++++++*++++++**+**++++++***+*++*++++++++*++*+++++++++++++++++++++++++++@@@@%#*****************#%@@@@@@@@@@##################\r\n"
				+ "###########%##########%%%###*+++++++*+*++**++**++*++*++++++++++++*++*+++++++*++*+++++++++*+++++++++++*@%**************************@@@@@@@#############%%%##\r\n"
				+ "%####################%%###*++++++++**+***+*++++++++++++*++**+++++++++++*++*+++++++++*+++*++**+++++++#%@@@***************************#@@@@######%%%%%@@%%%##\r\n"
				+ "####################%%##+++++++++**+**+**++*+**+**+++++**++++++**+**+++++*++**+**+++++++++**++++++*#%@@@@@@*********++++++************%%@##########%#@@@%%%\r\n"
				+ "######################*+++++++*++*++*+***+*++++*+++*+**+*+++++*++*+**+++++++++++++**+***+++++++++*##%@@@@@@@@%****++++++===+*********#@@%#################%\r\n"
				+ "####################*+++++++**++*+*+++++**++*++**++++++++**+**+++++*+++*+++**+++*+++**++++++++++####%@@@@@@@@@@@@@#*++++++++++++*%@@@@@@###################\r\n"
				+ "##################+++++++++*+*+++*+**+++++*++**++*+*+*+++++++*++*+++**++*****++++***++++++++++*#####@@@@@@@@%%%*%@@@@@@@@@@@@@@@@@@@@@@%###################\r\n"
				+ "################*++++++++*+*+++*+***++*+++*++++++*+++*++**+**+++++++*++*+++*++***+***++++++++**####%@@@@@@@@%#+*%@@@@@@@@@@@@@@@@@@@@@@####################\r\n"
				+ "############%#*++++++++*++*++++***+*+++*+++*++*++++++++*++*++**+**+++++++*++**++**++*++++++*##**#*%@@@@@@%%%#+*%%@@@@@@@@@@@@@@@@@@@@@@####################\r\n"
				+ "############*++++++++*+*++*++++**+++***++*++**++*+*+**+++*+++*++*****++*+++*++++**++++++++*******@@%##@@%%%*%%%%@@@@@@@@@@@@@@@@@@@@%++**##################\r\n"
				+ "#####%%###++++++++**+**+*++*++*++*+**+**++*++**++*++++++++**++*++**++**+**++**++*+++++++*******%@@##%@%@@@#@@%%@@@@@@@@@@@@@@@@@@%*+++++++++*##############\r\n"
				+ "#######%*++++++++*+++++*+++++*+++++++**++++*+****+***+*++*++**++**++*+++*++**+++++++++********@@@#####@@%%@@@@@@@@@@@@@@@@%##*++++++++++++++++++*##########\r\n"
				+ "####%%*++++++++**++*++*+++**++*++*++*++*++**+*++***+**+**++++***+***+*+*++*++**++++++*******#@@#####@@@%@@@@%@@@@@@@@@*++++++++++++++++++++++++++++++*#####\r\n"
				+ "#%%%*++++++++**+**+*+++**++*+++*+**++**+*++**+**++*++**+*+++*++*+++**+*++++*++++++++*******%@@####%@@%%@@@@%########*+++++++++++++*++++++++++++++++++++++*#\r\n"
				+ "%%*++++++++++*++*++*++*+++**+*++**+*++++++**+**+**+*+++**+**++*++**++++++++*++++++*******#@@%####@@@#@@@@@@@@#####*++++++++++++++*++*+++++++++**+++++++++++\r\n"
				+ "#+++++++++++++++**+*+*+**+++*+**+**++*+++*++++*++**++*++*++**++**++*+++**++++++++*******%@@####@@@#%@@@@@@@@@@###+++++++++++++++*+*++*+++++++++++++++++++++\r\n"
				+ "#%%*+++++++++++++++++++*+*++***+****+*+**+**+*++**+**+**++*++**+++*++***++++++++*******%@@###%@@%#@@@@@@@@@%###*+++++++++++++++***++*+++++*++++++++++++++++\r\n"
				+ "%%%@@@@%*+++++++++++++++++**++*+++*++**+*++**+*++**+**++*++**++*++**++*++++++++*******@@%###@@@#%@@@@@@@@@%##*++++++++++++++++*+**+++++*+++++*++*++*+++++++\r\n"
				+ "%%%@@@@@@@@@#*+++++++++++++++++**+*+*++*++*++++*+++*+**++*++*+*+++***++++++++*******#@@###%@@@#@@@@@@@@@@###++++++++++++++++++*+*+*++*+*+++++++**++*+++*+++\r\n"
				+ "%@@@@@@@@@@@@@@@%#++++++++++++++++++**+++*+*+**+**++*++*+++**++**++*++++++++****#**%@@###@@@%@@@@@@@@@@@##*++++++++++++++++*+++++*++*+*++*++*+*+*++*++*+*++\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@%*++++++++++++++++++**++**++*+***++*++++*++++++++++++*****#**%@%###@@@@@@@@@@@@@@%##+++++++++++++++*+++*++*++++**+*++*++*+++*++*++*+++\r\n"
				+ "#%%@@@@@@@@@@@@@@@@@@@@@@@%*++++++++++++++++++**++**++**++*++**++*+++++++********%@###%@@@@@@@@@@@@@@%#*++++++++++++++*+*+*++**+*+*++*++*++*++*+**+**+++*++\r\n"
				+ "%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@#+++++++++++++++++++*+++*+++*++**++++++++*******#%@###@@@@@@@@@@@@@@%#*++++++++++++++++*+++**++*++*+*++*++++*****+*++****+**\r\n"
				+ "%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@%*+++++++++++++++++*++**+++++++++++*******%@@###@@@@@@@@@@@@@%##*++++++++++++++*+*+***+***+**++++++*++*++*+*****++++**+\r\n"
				+ "%%%%%%%##%%%%%%#%%@@@@@@@@@@@@@@@@@@@@@@@%+++++++++++++++++**++++++++********%@@###@@@@@@@@@@@@@##*++++++++++++++++*+*++**+*++*+*++*+*++*++*+*++++++*+*+*++\r\n"
				+ "%%%%%%%%###%#######%%%%@@@@@@@@@@@@@@@@@@@@@@@#*++++++++++++++++++++********%@@###%%##%@@@@@@@%##+++++++++++++++++++*++*++++*++*+***+**++*++*+*++**++++**++\r\n"
				+ "%%%%%%%%%%%%#%############%%@@@@@@@@@@@@@@@@@@@@@@%*+++++++++++++++*******#%@%###@%*@%#@@@@@@##*+++++++++++++++*+*++**++++**+**+++*+**+*++*+**+*++*++*+*+++\r\n"
				+ "%%@@%%%%%%%%%%#################%%@@@@@@@@@@@@@@@@@@@@@@#++++++++++*******#%@#####@@%@@@@@@@###*+++++++++++++++**+*++*+++++++*+*++*+++*++*+*++*++++*++*+*+*+\r\n"
				+ "@@@@@@@@%%%%%%%%%%##################%%@@@@@@@@@@@@@@@@@@@@@%*++++*******%%@#######%@@@@@%###*++++++++++++++++++*++*++*+**+*+++**+**+**+*+++*++*++++*+++***+\r\n"
				+ "@@@@@@@@@@@@@%%%%%%%#####################%@@@@@@@@@@@@@@@@@@@@@#*******%%@#######@@@@@@###*++++*+++++++++++******+*++*++**+***++++++**++*++**++*+****++*+++\r\n"
				+ "@@@@@@@@@@@@@%%%%%@%%%%%%%####################%@@@@@@@@@@@@@@@@%******%@@#######%@@@@%###*+++**++++++++++*++*++*++**++*++*++*++****+++****++**+***+++++**+*\r\n"
				+ "@@@@@@@@@@@@@@@%%@@%%%%%%%%%#######################%@@@@@@@@@@@@%***#@@%################*++**++++++++++++**+*+++++*+++*++*++**+**++*+*+++**++*++#+*+++*+*++\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%#####################%@@@@@@@@@%%%@@%###############%%%#**++++++++++++++**+*+*+*+**+++++*+**++****+**+*+++++****++*++***+\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@%%%%##%%%%%%%#######################@@@@@@@@@################@@@@@@%*++++++++++++++++*++**++*++*++*++**+****++*++*+*++*++**+*++*++*\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%##%###########################################@@@@@@@@@@*++++++++++++++++*+++*+++++*+**+++*+*++*++****++*+*++**+**++\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%###############################################%@@@@@@@@@@@@#++++++++++++++++*+++**+**+*++*+++*+*++*++*++*++++**+++++\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%##############################################%@@@@@@@@@@@@@@@#*+++++++++++++++*+*++*+**+*+**++**++*+*++*++*++*++++*\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%############################################%@@@@@@@@@@@@@@@@%*+++++++++++++++****++++*+**+**++*+**+*+**+**+++++\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%#*****####################################@@@@@@@@@@@@@@@@@@*+++++++++++++++**++**++*+*****++*+****+*++**+*\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%##******#################################@@@@@@@@@@@@@@@@@%*++++++++++++++++**+**+++++*+*****+*+++*****\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%##*+*****##*############################@@@@@@@@@@@@@@@@@@*++++++++++++++++*+++*++++**+**+*+++**+*+\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%*++++***********#####################%@@@@@@@@@@@@@@@@@%*++++++++++++++++*++***+*++**+++***+*+\r\n"
				+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%##*+=++++++*********##################%@@@@@@@@@@@@@@@@@%*++++++++++++++++*++**+*+++**++**+*"
				);
		
		System.out.println("\n<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
		String content = "You look around, and a couple steps behind you, you see a large table, clearly divided into two by the differing items on each side. On one half of the table, you see an organized array of magnifying glasses. On the other half, you see a never-ending stack of books.";
		String[] parts = content.split("\\s");
		for(String part: parts)
		{
			System.out.print(part + " ");
			try {Thread.sleep(50);} 
			catch (InterruptedException e) 
			{e.printStackTrace();}
		}
		System.out.print("\n\n<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
		try {Thread.sleep(2000);} 
		catch (InterruptedException e) 
		{e.printStackTrace();}
	}

	@Override
	public void investigate() 
	{
		// TODO Auto-generated method stub
		
	}
	
	public void printDialogue(String[] parts)
	{
		for(String part: parts)
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
	
	@Override
	public void startSequence(Scanner in) 
	{
		// TODO Auto-generated method stub
		System.out.println(
				"+-+-+-+-+ +-+-+ +-+-+-+ +-+-+-+-+-+-+-+-+\r\n"
				+ "|P|a|r|t| |1|:| |T|h|e| |W|o|r|k|s|h|o|p|\r\n"
				+ "+-+-+-+-+ +-+-+ +-+-+-+ +-+-+-+-+-+-+-+-+\n"
				);

		while (true) {
		    if (tcp.isWaving()) {
		        System.out.println("Waving detected! You prepare to jump into the story...");

		        // Transition to Mansion (Scene 1)
		        System.out.println("Transitioning to Scene 1: The Mansion...");
		        game.currentEnvironment = new Mansion(game); // Set the next environment
		        game.currentEnvironment.startSequence(new Scanner(System.in)); // Begin Mansion sequence
		        break;
		    }

		    try {
		        Thread.sleep(100); // Check every 100ms
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}
		
		

		
		ArrayList<String[]> dialogue = new ArrayList<String[]>();
		parseDialogue(dialogue);
		
		for(int i = 0;i < 9;i++)
		{
			printDialogue(dialogue.get(i));
		}
		inputSequence(in); // check time
		
		for(int i = 9;i < 11;i++)
		{
			printDialogue(dialogue.get(i));
		}
		inputSequence(in); // look around
		
		printDialogue(dialogue.get(11));
		inspectItemSequence(in); // inspect magnifying glass

		for(int i = 12;i < 14;i++)
		{
			printDialogue(dialogue.get(i));
		}
		inspectBookSequence(in); // inspect book
		
		for(int i = 14;i < 18;i++)
		{
			printDialogue(dialogue.get(i));
		}
		
		inputSequence(in); // JUMP SEQUENCE
		
		
	
		
	}
	
	public void inputSequence(Scanner in)
	{
		while(true)
		{
			System.out.print("> ");
			String userInput = in.nextLine().trim().toLowerCase();
			
			switch(userInput)
			{
			case "check time":
				W_Watch watch = (W_Watch) Item_list.get(2);
				watch.requestTimeUpdate();
				
				playerCharacter.inventory.add(watch); // giving player the watch
				playerCharacter.subjects.add(watch); // adding watch to Jack Stone's list of subjects
				watch.registerObserver(playerCharacter); // register Jack Stone as observer of watch
				
				while(!playerCharacter.messageReceived())
				{
					try {Thread.sleep(100);} 
					catch (InterruptedException e) 
					{e.printStackTrace();} // keep checking if message has been received
				}
				playerCharacter.resetMessageFlag();
				
				return;
			case "look around":
				lookAround();
				return;
			case "jump":
				String[] parts = "... A leap of faith".split("\\s");
				printDialogue(parts);
//				Item_list.get(0).jumpSequence();
				System.out.println("Jumping into the story");
			default:
				System.out.println("Try doing something else");
				break;
			}
		}
	}
	
	public void inspectItemSequence(Scanner in)
	{
		int misinputs = 0;
		
		while(true)
		{
			System.out.print("> ");
			String userInput = in.nextLine().trim().toLowerCase();
			
			switch(userInput)
			{
			case "inspect magnifying glass":
				Item_list.get(1).inspect(); // inspecting magnifying glass
				playerCharacter.inventory.add(Item_list.get(1)); // Giving player the magnifying glass item
				return;
			case "inspect book":
				String[] parts = "The Guide: \" Jack, go grab a magnifying glass first! \"".split("\\s");
				printDialogue(parts);
				break;
			default:
				if(misinputs >= 3)
				{
					System.out.println("Try inspecting the magnifying glass.");
				}
				misinputs++;
				break;
			}
		}
	}
	
	public void inspectBookSequence(Scanner in)
	{
		int misinputs = 0;
		
		while(true)
		{
			System.out.print("> ");
			String userInput = in.nextLine().trim().toLowerCase();
			
			switch(userInput)
			{
			case "inspect books":
				Item_list.get(0).inspect(); // inspecting books
				playerCharacter.inventory.add(Item_list.get(0)); // Giving player the book item
				return;
			default:
				if(misinputs >= 3)
				{
					System.out.println("Try inspecting the books.");
				}
				misinputs++;
				break;
			}
		}
	}
	
	// IMPLEMENTS USE SCENARIOS FOR ITEMS
	 
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
		
		content = "You walk up to … (hint: try inspecting an item)";
		parts = content.split("\\s");
		dialogue.add(parts);
		
		// > inspect ITEM (magnifying glass or book)
		
		content = "The Guide: \"That magnifying glass is a crucial item that will allow you to quickly investigate a multitude of things in your story, from characters, items, to environments. Keep it at arm’s reach, should you need some more information. \"";
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
		
		content = "Jump… (Waving your hands) ";
		parts = content.split("\\s");
		dialogue.add(parts);
		
		
		content = "Wave your hand to jump into the story!";
		parts = content.split("\\s");
		dialogue.add(parts);
		

	
		
		
//		content = "";
//		parts = content.split("\\s");
//		dialogue.add(parts);
	}
}
