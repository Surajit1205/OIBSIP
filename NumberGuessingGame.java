import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int want;
        do {
            Random random = new Random();
            int bound = 50;
            int secretNumber = random.nextInt(bound); // Generate a random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 5; // Set a limit of 5 attempts in this example
            int isWin = 0;

            System.out.println("Welcome to the Number Guessing Game!");

            while (attempts < maxAttempts) {
                System.out.print("Guess the number (between 1 and 50): ");
                float guess = scanner.nextFloat();
                if (guess > bound || guess <= 0) {
                    System.out.println("Please stay in your Limit..");
                    isWin = -1;
                    break;
                }
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Congratulations, you guessed the number in " + attempts + " attempts!");
                    isWin = 1;
                    break; // Exit the loop if the guess is correct
                } else if (guess < secretNumber) {
                    System.out.println("Your guess is too low. Attempts remaining: " + (maxAttempts - attempts) + ".");
                } else {
                    System.out.println("Your guess is too high. Attempts remaining: " + (maxAttempts - attempts) + ".");
                }
            }

            if (isWin == 0) {
                System.out.println("Sorry, you did not guess the number in " + maxAttempts + " attempts. The number was " + secretNumber + ".");
            } else if (isWin == -1) {
                System.out.println("Try Again.");
            }
            //scanner.close();

            System.out.println("Want to play Again?\n1. YES\n2. NO");
            want = scanner.nextInt();
        } while (want != 2);
    }
}

