import java.util.Random;
import java.util.Scanner;

/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {
    public static void GuessingANumber() {
        Scanner scanner = null;
        int userInput = -1;
        int previousGuess = 0;
        int numberGuesses = 0;

        // create a random integer for user to guess
        Random randomInteger = new Random();
        int expectedNumber = randomInteger.nextInt(101);
        System.out.println(expectedNumber);
        do {
            // asking for user input
            System.out.println("Guess number from 1 - 100 or enter (0) to exit: ");
            scanner = new Scanner(System.in);

            // check if input is not integer, or if input > 100 or < 0
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input, Please try again!");
                continue;
            } else { // if input is integer and within range 1-100

                // get user input
                userInput = scanner.nextInt();

                // if user input is out of range
                if (userInput > 100 || userInput < 0) {
                    System.out.println("Input out of range!");
                    continue;
                } else if (userInput == 0) {
                    System.out.println("You have exited the game!");
                    return;
                } else if (userInput > expectedNumber) {
                    System.out.println("Too large!");
                    if(userInput!=previousGuess){
                        previousGuess = userInput;
                        numberGuesses++;
                    }
                } else if (userInput < expectedNumber) {
                    System.out.println("Too small!");
                    if(userInput!=previousGuess){
                        previousGuess = userInput;
                        numberGuesses++;
                    }
                } else {
                    numberGuesses++;
                    System.out.println(numberGuesses+" guesses");
                    System.out.println("Correct guess!");
                }
            }
        } while (userInput != expectedNumber) ;
        scanner.close();
    }

    public static void main(String[] args){
        GuessingANumber();
    }
}
