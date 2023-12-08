import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min_range = 1;
        int max_range = 100;
        int max_attempts = 10;
        int score = 0;
        do {
            int target_number = random.nextInt(max_range - min_range + 1) + min_range;
            int attempts = 0;
            boolean guessedCorrectly = false;
            System.out.println("\nGuess the number between " + min_range + " and " + max_range + ".");
            while (attempts < max_attempts) {
                System.out.print("Enter your guess: ");
                int user_guess = scanner.nextInt();
                attempts++;
                if (user_guess == target_number) {
                    guessedCorrectly = true;
                    System.out.println("You guessed the correct number in " + attempts + " attempts.");
                    break;
                } else if (user_guess < target_number) {
                    System.out.println("Low , Try again");
                } else {
                    System.out.println("High , Try again");
                }
            }
            if (!guessedCorrectly) {
                System.out.println("You reached the max no of attempts. Correct number was: " + target_number);
            }
            score += guessedCorrectly ? 1 : 0;
            System.out.print("Want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));
        System.out.println("Game over \n Total score : " + score);
        scanner.close();
    }
}