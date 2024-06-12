import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        // Scanner object to take user input
        Scanner scanner = new Scanner(System.in);
        // Random object to generate random numbers
        Random random = new Random();
        // Boolean to control the play loop
        boolean playAgain = true;
        // Score to track how many times the user guesses the number correctly
        int score = 0;

        // Main play loop
        while (playAgain) {
            // Generate a random number between 1 and 100
            int generatedNumber = random.nextInt(100) + 1;
            // Number of attempts made by the user
            int attempts = 0;
            // Boolean to check if the user guessed the number correctly
            boolean guessedCorrectly = false;

            // Welcome message
            System.out.println("\nWelcome to the Number Game!");
            System.out.println("Guess the number between 1 and 100.");

            // Loop until the user guesses the correct number or exceeds the attempt limit
            while (!guessedCorrectly && attempts < 10) {
                // Prompt user for input
                System.out.print("Enter your guess: ");
                // Read user input
                int userGuess = scanner.nextInt();
                // Increment the attempt count
                attempts++;

                // Check if the user's guess matches the generated number
                if (userGuess == generatedNumber) {
                    // If the guess is correct, display a success message
                    System.out.println("Congratulations! You guessed the number " + generatedNumber + " correctly in " + attempts + " attempts.");
                    // Increment the score
                    score++;
                    // Set the guessedCorrectly flag to true to exit the loop
                    guessedCorrectly = true;
                } else if (userGuess < generatedNumber) {
                    // If the guess is lower than the generated number, provide a hint
                    System.out.println("Too low! Try again.");
                } else {
                    // If the guess is higher than the generated number, provide a hint
                    System.out.println("Too high! Try again.");
                }
            }

            // If the user exceeds the attempt limit, display the correct number
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all 10 attempts. The number was: " + generatedNumber);
            }

            // Prompt the user to play again
            System.out.print("Do you want to play again? (yes/no): ");
            // Read user input
            String playChoice = scanner.next().toLowerCase();
            // If the user doesn't want to play again, exit the loop
            if (!playChoice.equals("yes")) {
                playAgain = false;
            }
        }

        // Game over message
        System.out.println("\nGame Over!");
        // Display the user's score
        System.out.println("Your score: " + score);
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
//Code by Vivek Auti