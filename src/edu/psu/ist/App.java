package edu.psu.ist;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Minesweeper game = new Minesweeper();
        Scanner scanner = new Scanner(System.in);
        boolean gameOngoing = true;

        while (gameOngoing) {
            System.out.println(game.renderBoard());
            System.out.print("Enter a row and column (row, column), (1,1) is the top left of the board): ");

            String input = scanner.nextLine();
            String[] parts = input.split(",");

            if (parts.length != 2) {
                System.out.println("Invalid input. Please enter in the format row,column.");
                continue;
            }

            try {
                int row = Integer.parseInt(parts[0].trim()) - 1; // Converting to index of 0
                int col = Integer.parseInt(parts[1].trim()) - 1; // Converting to index of 0

                if (row < 0 || row >= Minesweeper.SIZE || col < 0 || col >= Minesweeper.SIZE) {
                    System.out.println("Input out of bounds. Please try again.");
                    continue;
                }

                int result = game.updateBoard(row, col);

                if (result == -1) {
                    System.out.println(game.renderBoard());
                    System.out.println("You hit a mine! You lose.");
                    gameOngoing = false;
                } else if (result == 1) {
                    System.out.println(game.renderBoard());
                    System.out.println("You win!");
                    gameOngoing = false;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numbers.");
            }
        }

        scanner.close();
    }
}

