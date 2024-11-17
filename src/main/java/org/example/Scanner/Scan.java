package org.example.Scanner;

import org.example.Player.Player;

import java.util.Scanner;

public class Scan {

     public Scanner scanner = new Scanner(System.in);

    // Method to select and set the player's name
    public void selectName(Player player){
        String name = scanner.next();
        scanner.nextLine(); // Consume the leftover newline character
        player.setName(name);
    }

    // Method to select the number of players playing
    public int selectRounds() {
        while (true) {
            System.out.println("Enter the number of rounds:");
            if (scanner.hasNextInt()) {
                int rounds = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newline character
                return rounds;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    public int selectPlayersPlaying() {
        while (true) {
            System.out.println("Enter the number of players:");
            if (scanner.hasNextInt()) {
                int players = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newline character
                return players;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
}