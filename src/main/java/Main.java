import java.util.Random;
import java.util.Scanner;

/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {
    public static void GuessingANumber() {
        Scanner scanner = new Scanner(System.in);
        int userInput = -1;
        int previousGuess = 0;
        int numberGuesses = 0;

        // create a random integer for user to guess
        Random randomInteger = new Random();
        int expectedNumber = randomInteger.nextInt(100)+1;

        do {
            // asking for user input
            System.out.println("Guess number from 1 - 100 or enter (0) to exit: ");

            // check if input is not integer, or if input > 100 or < 0
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input, Please try again!");

            } else { // if input is integer and within range 1-100

                // get user input
                userInput = scanner.nextInt();

                // if user input is out of range
                if (userInput > 100 || userInput < 0) {
                    System.out.println("Input out of range!");

                } else if (userInput == 0) {
                    System.out.println("You have exited the game!");
                    return;

                } else if (userInput > expectedNumber) {
                    System.out.println("Too large!");

                    //increase number of guesses if the current and previous guesses are different
                    if(userInput != previousGuess){
                        previousGuess = userInput;
                        numberGuesses++;
                    }

                } else if (userInput < expectedNumber) {
                    System.out.println("Too small!");

                    //increase number of guesses if the current and previous guesses are different
                    if(userInput!=previousGuess){
                        previousGuess = userInput;
                        numberGuesses++;
                    }

                } else { // when userInput == expectedNumber
                    numberGuesses++;
                    System.out.format("Congratulation! You did it with %s guesses!",numberGuesses);
                }
            }
        } while (userInput != expectedNumber) ;

        //closing the scanner
        if(scanner!=null) scanner.close();
    }

    public static void main(String[] args){
        GuessingANumber();
    }
}
