package org.example.Messages;

import org.example.Player.Player;

public class Messages {

    Player player;

    // Method to display a welcome message to the players
    public void displayWelcomeMessage() {
        String welcomeMessage =
                "\n" +
                        "██████╗ ██╗ ██████╗███████╗     ██████╗  █████╗ ███╗   ███╗███████╗\n" +
                        "██╔══██╗██║██╔════╝██╔════╝    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝\n" +
                        "██║  ██║██║██║     █████╗      ██║ ████║███████║██╔████╔██║█████╗  \n" +
                        "██║  ██║██║██║     ██╔══╝      ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  \n" +
                        "██████╔╝██║╚██████╗███████╗    ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗\n" +
                        "╚═════╝ ╚═╝ ╚═════╝╚══════╝     ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝\n" +
                        "                                                                   \n" +
                        "           Welcome to the Ultimate Dice Rolling Game!              \n" +
                        "  Roll the dice, score the highest, and become the champion!       \n";
        System.out.println(welcomeMessage);
    }

    // Method to display a winner
    public void displayWinner(Player winner) {
        String winnerMessage =
                "\n" +
                        "██╗    ██╗██╗███╗   ██╗███╗   ██╗███████╗██████╗     ██╗███████╗\n" +
                        "██║    ██║██║████╗  ██║████╗  ██║██╔════╝██╔══██╗    ██║██╔════╝\n" +
                        "██║ █╗ ██║██║██╔██╗ ██║██╔██╗ ██║█████╗  ██████╔╝    ██║███████╗\n" +
                        "██║███╗██║██║██║╚██╗██║██║╚██╗██║██╔══╝  ██╔══██╗    ██║╚════██║\n" +
                        "╚███╔███╔╝██║██║ ╚████║██║ ╚████║███████╗██║  ██║    ██║███████║\n" +
                        " ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝    ╚═╝╚══════╝\n" +
                        "                                                                \n" +
                        winner.getName() + "! You are the champion with " + winner.getScore() + " rounds won!\n";
        System.out.println(winnerMessage);
    }

}
