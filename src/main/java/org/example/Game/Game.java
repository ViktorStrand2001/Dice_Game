package org.example.Game;

import org.example.Dice.Dice;
import org.example.Messages.Messages;
import org.example.Player.Player;
import org.example.Scanner.Scan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Game {

    // Instances of Dice, Scan, and Messages classes
    Dice dice = new Dice();
    Scan scanner = new Scan();
    Messages messages = new Messages();

    private int rounds;
    private String winner;
    private List<Player> playersPlaying = new ArrayList<>();
    private boolean gameRunning = true;

    // Main game loop
    public void game(){

        // Display welcome message
        messages.displayWelcomeMessage();

        delayExecution(2000);

        // Main game loop
        while (gameRunning) {
            System.out.println("\n===============================");
            System.out.println("How many players are playing?");
            System.out.println("===============================\n");

            // Sets the amount of players playing
            int amountOfPlayers = scanner.selectPlayersPlaying();

            // Sets player names
            for (int i = 0; i < amountOfPlayers; i++) {
                System.out.println("\n===============================");
                System.out.println("Enter player " + (i + 1) + " name:");
                System.out.println("===============================\n");
                Player player = new Player();
                scanner.selectName(player);
                playersPlaying.add(player);

            }

            System.out.println("\n===============================");
            System.out.println("How many rounds are playing?");
            System.out.println("===============================\n");

            // Sets amount of rounds playing
            rounds = scanner.selectRounds();

            // Loop through each round
            for (int i = 0; i < rounds; i++) {

                int highestRoll = 0;
                Player roundWinner = null;

                // Each player rolls the dice
                for (Player player : playersPlaying) {

                    System.out.println("\n====================================================");
                    System.out.println(player.getName() + ", it's your turn. Press Enter to roll the dice...");
                    System.out.println("====================================================");
                    waitForKeyPress();

                    int roll = dice.roll();
                    System.out.println(player.getName() + " rolled a " + roll);
                    if (roll > highestRoll) {
                        highestRoll = roll;
                        roundWinner = player;
                    }
                }

                // Announce round winner
                if (roundWinner != null) {
                    roundWinner.setScore(roundWinner.getScore() + 1);
                    System.out.println("\n==============================================");
                    System.out.println(roundWinner.getName() + " won the round " + (i + 1));
                    System.out.println("==============================================\n");
                }

            }

            delayExecution(1000);

            // Display the overall winner
            messages.displayWinner(playersPlaying.stream().max(Comparator.comparingInt(Player::getScore)).get());

            System.out.println("\n==============================================");
            System.out.println("Do you want to play again? (y/n)");
            System.out.println("==============================================\n");

            // Ask if the user wants to play again
            boolean validInput = false;
            while (!validInput) {
                String input = scanner.scanner.next().trim().toLowerCase();
                if (input.equals("y")) {
                    validInput = true;
                    playersPlaying.clear();
                    rounds = 0;
                    winner = null;
                    gameRunning = true;
                } else if (input.equals("n")) {
                    gameRunning = false;
                    validInput = true;
                    System.out.println("\n==============================================");
                    System.out.println("Thanks for playing!");
                    System.out.println("==============================================\n");
                } else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
           }
        }
    }

    // Wait for the user to press Enter
    private void waitForKeyPress() {
        try {
            scanner.scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Pause execution for a specified number of milliseconds
    private void delayExecution(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException _) {}
    }

    public int getRounds() {
        return rounds;
    }

    public String getWinner() {
        return winner;
    }

    public List<Player> getPlayersPlaying() {
        return playersPlaying;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }
}
