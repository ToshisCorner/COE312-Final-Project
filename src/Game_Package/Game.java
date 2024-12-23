package Game_Package;

import java.util.ArrayList;
import java.util.Scanner;

import Default.Environment;
import Default.NPC;
import Environments.Workshop;
import NPCs.Jack_Stone;
import Supplement.Subject;

public class Game 
{
	public Environment currentEnvironment;
	Jack_Stone player;
	UI ui;
	public ArrayList<Subject> subjects = null;

	public Game()
	{
		player = new Jack_Stone();
		currentEnvironment = new Workshop(this);
	}
	
	public NPC getPlayer()
	{
		return player;
	}
	
	public void beginSequence() throws InterruptedException // Beginning Sequence to Introduce the Game
	{
		System.out.println(
				"  .-.-.   .-.-.   .-.-.   .-.-.   .-.-.   .-.-.   .-.-.   .-.-\r\n"
				+ " / / \\ \\ / / \\ \\ / / \\ \\ / / \\ \\ / / \\ \\ / / \\ \\ / / \\ \\ / / \\\r\n"
				+ "`-'   `-`-'   `-`-'   `-`-'   `-`-'   `-`-'   `-`-'   `-`-'"
				);
		
		System.out.println(
				" █████   ███   █████          ████                                            \r\n"
				+ "░░███   ░███  ░░███          ░░███                                            \r\n"
				+ " ░███   ░███   ░███   ██████  ░███   ██████   ██████  █████████████    ██████ \r\n"
				+ " ░███   ░███   ░███  ███░░███ ░███  ███░░███ ███░░███░░███░░███░░███  ███░░███\r\n"
				+ " ░░███  █████  ███  ░███████  ░███ ░███ ░░░ ░███ ░███ ░███ ░███ ░███ ░███████ \r\n"
				+ "  ░░░█████░█████░   ░███░░░   ░███ ░███  ███░███ ░███ ░███ ░███ ░███ ░███░░░  \r\n"
				+ "    ░░███ ░░███     ░░██████  █████░░██████ ░░██████  █████░███ █████░░██████ \r\n"
				+ "     ░░░   ░░░       ░░░░░░  ░░░░░  ░░░░░░   ░░░░░░  ░░░░░ ░░░ ░░░░░  ░░░░░░  \r\n"
				+ "                                                                              \r\n"
				+ "                                                                              \r\n"
				+ "                                                                              \r\n"
				+ "  █████                                                                       \r\n"
				+ " ░░███                                                                        \r\n"
				+ " ███████    ██████                                                            \r\n"
				+ "░░░███░    ███░░███                                                           \r\n"
				+ "  ░███    ░███ ░███                                                           \r\n"
				+ "  ░███ ███░███ ░███                                                           \r\n"
				+ "  ░░█████ ░░██████                                                            \r\n"
				+ "   ░░░░░   ░░░░░░                                                             \r\n"
				+ "                                                                              \r\n"
				+ "                                                                              \r\n"
				+ "                                                                              \r\n"
				+ " ██████████                █████  ███                                         \r\n"
				+ "░░███░░░░░█               ░░███  ░░░                                          \r\n"
				+ " ░███  █ ░  ████████    ███████  ████  ████████    ███████                    \r\n"
				+ " ░██████   ░░███░░███  ███░░███ ░░███ ░░███░░███  ███░░███                    \r\n"
				+ " ░███░░█    ░███ ░███ ░███ ░███  ░███  ░███ ░███ ░███ ░███                    \r\n"
				+ " ░███ ░   █ ░███ ░███ ░███ ░███  ░███  ░███ ░███ ░███ ░███                    \r\n"
				+ " ██████████ ████ █████░░████████ █████ ████ █████░░███████                    \r\n"
				+ "░░░░░░░░░░ ░░░░ ░░░░░  ░░░░░░░░ ░░░░░ ░░░░ ░░░░░  ░░░░░███                    \r\n"
				+ "                                                  ███ ░███                    \r\n"
				+ "                                                 ░░██████                     \r\n"
				+ "                                                  ░░░░░░                      \r\n"
				+ " ██████   ██████           █████                         ███                  \r\n"
				+ "░░██████ ██████           ░░███                         ░███                  \r\n"
				+ " ░███░█████░███   ██████   ░███ █████  ██████  ████████ ░███                  \r\n"
				+ " ░███░░███ ░███  ░░░░░███  ░███░░███  ███░░███░░███░░███░███                  \r\n"
				+ " ░███ ░░░  ░███   ███████  ░██████░  ░███████  ░███ ░░░ ░███                  \r\n"
				+ " ░███      ░███  ███░░███  ░███░░███ ░███░░░   ░███     ░░░                   \r\n"
				+ " █████     █████░░████████ ████ █████░░██████  █████     ███                  \r\n"
				+ "░░░░░     ░░░░░  ░░░░░░░░ ░░░░ ░░░░░  ░░░░░░  ░░░░░     ░░░                   "
				);
		System.out.println(
				"  .-.-.   .-.-.   .-.-.   .-.-.   .-.-.   .-.-.   .-.-.   .-.-\r\n"
				+ " / / \\ \\ / / \\ \\ / / \\ \\ / / \\ \\ / / \\ \\ / / \\ \\ / / \\ \\ / / \\\r\n"
				+ "`-'   `-`-'   `-`-'   `-`-'   `-`-'   `-`-'   `-`-'   `-`-'"
				);
		
		Thread.sleep(3000); // Short Pause
		
		System.out.println(
				"   _____________________________________________\r\n"
				+ " / \\                                             \\.\r\n"
				+ "|   |    Are you ready for an adventure?         |.\r\n"
				+ " \\_ |                                            |.\r\n"
				+ "    |                                            |.\r\n"
				+ "    |    As a \"Novel-Maker\", you are tasked      |.\r\n"
				+ "    |    with crafting the ending to stories.    |.\r\n"
				+ "    |                                            |.\r\n"
				+ "    |    Your job is to jump into tales,         |.\r\n"
				+ "    |    traverse the environment,               |.\r\n"
				+ "    |    interact with the story's               |.\r\n"
				+ "    |    characters, and...                      |.\r\n"
				+ "    |    hopefully, reach a happy ending :D      |.\r\n"
				+ "    |                                            |.\r\n"
				+ "    |    ...but, it might not be that easy.      |.\r\n"
				+ "    |   _________________________________________|___\r\n"
				+ "    |  /                                            /.\r\n"
				+ "    \\_/____________________________________________/.\n\n"
				);
		
		Thread.sleep(1000); // 10 Second Pause

		System.out.println(
				"   ;;;;;\r\n"
				+ "   ;;;;;\r\n"
				+ "   ;;;;;		See you at the Workshop, and again, Welcome to... Ending Maker!\r\n"
				+ " ..;;;;;..\r\n"
				+ "  ':::::'\r\n"
				+ "    ':`\n\n"
				);
		
		Thread.sleep(1000); // Short Pause
	}
		
	public void gameSequence() // UPDATE FOR OTHER SCENES
	{
		currentEnvironment.getThread().start();
	}
}
