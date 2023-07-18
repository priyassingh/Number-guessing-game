import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            int minRange = 1;
            int maxRange = 150;
            int maxAttempts = 4;
            int round = 1;
            int score = 0;

            System.out.println("Welcome to Guess the Number!");

            while (true) {
                int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                int attempts = 0;
                boolean guessedCorrectly = false;

                System.out.println("\nRound " + round);
                System.out.println("I have generated a number between " + minRange + " and " + maxRange + ".");
                System.out.println("Can you guess the number?");

                while (!guessedCorrectly && attempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess == randomNumber) {
                        System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempt(s)!");
                        score += calculatePoints(attempts, maxAttempts);
                        guessedCorrectly = true;
                    } else if (guess < randomNumber) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                }

                if (!guessedCorrectly) {
                    System.out.println("Sorry, you've reached the maximum number of attempts.");
                    System.out.println("The correct number was: " + randomNumber);
                }

                System.out.print("\nDo you want to play another round? (Y/N): ");
                String playAgain = scanner.next().toUpperCase();

                if (playAgain.equals("N")) {
                    System.out.println("\nGame Over!");
                    System.out.println("Your total score is: " + score);
                    break;
                }

                round++;
            }
        }
    }

    private static int calculatePoints(int attempts, int maxAttempts) {
        int points = maxAttempts - attempts + 1;
        return Math.max(points, 0);
    }
}
    
