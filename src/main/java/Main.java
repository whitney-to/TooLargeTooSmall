import java.util.Random;
import java.util.Scanner;

/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {
    public static void main(String[] args){
        boolean isPlaying = true;
        boolean isInGame = true;

        while(isPlaying) {
            if(isInGame){
                Scanner scanner = null;
                int userInput = -1;

                // create a random integer for user to guess
                Random randomInteger = new Random();
                int expectedNumber  = randomInteger.nextInt(101);
                System.out.println(expectedNumber);

                do{
                    // asking for user input
                    System.out.println("Guess number from 1 - 100 or enter (0) to exit: ");
                    scanner = new Scanner(System.in);
                    userInput = scanner.nextInt();

                    // check user input
                    if(userInput == 0){
                        System.out.println("You have exited the game!");
                        isPlaying = false;
                        isInGame = false;
                        return;
                    }
                    //if user input larger than expected number
                    else if(userInput > expectedNumber){
                        System.out.println("Too large!");
                        continue;
                    }
                    //if user input smaller than expected number
                    else if(userInput < expectedNumber) {
                        System.out.println("Too small!");
                        continue;
                    }
                    //if user input is equal to the expected number
                    else if(userInput == expectedNumber) {
                        System.out.println("Congratulation! You have guessed the number.");
                        isInGame = false;
                        break;
                    } else {
                        continue;
                    }
                } while(userInput != expectedNumber);

            }
            System.out.println("\"Do you want to continue Playing? (Y/N): \"");
            Scanner scanner2 = new Scanner(System.in);
            String userInput2 = scanner2.nextLine();
            if(userInput2.equalsIgnoreCase("Y")){
                isInGame = true;
                continue;
            } else if (userInput2.equalsIgnoreCase("N")){
                isPlaying  = false;
                isInGame = false;
                break;
            } else {
                isInGame = false;
                System.out.println("Invalid input, Please try again!");
            }
        }





    }
}
