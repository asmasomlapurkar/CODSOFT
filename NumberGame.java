package CodSoft;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 3;
        int score = 0;

        System.out.println("Welcome to Guess the Number!");

        while (true) {
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.printf("I'm thinking of a number between %d and %d.%n", lowerBound, upperBound);

            while (attempts < maxAttempts) {
                System.out.print("Your guess: ");

                try {
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess == secretNumber) {
                        System.out.printf("Congratulations! You guessed the number %d in %d attempts.%n", secretNumber, attempts);
                        score++;
                        break;
                    } else if (userGuess < secretNumber) {
                        System.out.println("Too low. Try again.");
                    } else {
                        System.out.println("Too high. Try again.");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }

            if (attempts == maxAttempts) {
                System.out.printf("Sorry, you've reached the maximum number of attempts. The correct number was %d.%n", secretNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.printf("Your total score is %d%n", score);
                break;
            }
        }

        scanner.close();
    }
}


