package Environments;

import Default.Environment;
import Default.NPC;
import NPCs.Shaun_Miller;
import NPCs.Tony_Smith;
import Combat.CombatSystem;
import NPCs.Jack_Stone;

import java.util.ArrayList;
import java.util.Scanner;

public class Office extends Environment {
    private Jack_Stone player; // Fix for player issue

    public Office(Jack_Stone player) {
        this.name = "Shaun Miller's Office";
        this.description = "A luxurious yet ominous room with thick carpets, leather chairs, and a massive oak desk. Shadows linger in the corners.";
        this.NPC_list = new ArrayList<>();
        this.Item_list = new ArrayList<>();
        this.player = player; // Assign the player character

        // Add bodyguards and Shaun Miller to the NPC list
        this.NPC_list.add(new Tony_Smith());
        this.NPC_list.add(new Shaun_Miller());

        // Add any critical items or clues
        // Item_list.add(new SpecificItem());
    }

    @Override
    public void startSequence(Scanner in) {
        System.out.println("You step into Shaun Miller's office...");
        lookAround();

        // Introduce Shaun Miller
        System.out.println("\nShaun Miller: \"Ah, Jack Stone. You've come all this way to meet your demise.\"");
        System.out.println("He stands at his desk, flanked by his bodyguards. His gaze is cold and calculating.");

        // Investigate or fight
        System.out.println("\nWhat will you do?");
        System.out.println("1. Investigate the room for clues");
        System.out.println("2. Confront Shaun Miller directly");

        int choice = in.nextInt();
        switch (choice) {
            case 1 -> investigate();
            case 2 -> initiateCombat();
            default -> System.out.println("Invalid choice. The tension builds...");
        }
    }

    @Override
    public void lookAround() {
        System.out.println(description);
        System.out.println("You see " + NPC_list.size() + " enemies in the room.");
    }

    @Override
    public void investigate() {
        System.out.println("You carefully observe the surroundings...");
        System.out.println("On the desk, you find a set of incriminating documents linking Shaun Miller to Anna Lee's death.");
        System.out.println("The bodyguards notice your actions and prepare to attack!");

        // Trigger combat after investigation
        initiateCombat();
    }

    public void initiateCombat() {
        System.out.println("Shaun Miller and his bodyguards prepare to attack!");

        // Fix for player issue
        CombatSystem combat = new CombatSystem(player, NPC_list);
        boolean victory = combat.start();

        if (victory) {
            System.out.println("You have defeated Shaun Miller and his bodyguards.");
            System.out.println("Justice is served. Anna Lee's death will not go unanswered.");
        } else {
            System.out.println("You have been defeated... The conspiracy remains hidden.");
            // Handle game-over logic here
        }
    }
}
