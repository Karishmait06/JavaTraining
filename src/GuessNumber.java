import java.util.Random;
import java.util.Scanner;

class Game {
    private final int number;
    private int userGuess;
    private int noOfGuesses;

    public Game() {
        Random random= new Random();
        number = random.nextInt(100) + 1;
        noOfGuesses = 0;
    }

    public void takeUserInput () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Guess the number between 1 to 100");
        userGuess = sc.nextInt();
        noOfGuesses++;

    }

    public boolean isCorrectGuess () {
        if(userGuess == number) {
            System.out.println("Correct ! Your score is : " +noOfGuesses);
            return true;
        } else if (userGuess > number) {
            System.out.println("Too high!");
        } else {
            System.out.println("Too low!");
        }
        return false;
    }


}

public class GuessNumber {
    public static void main(String[] args) {

        Game player = new Game();
        boolean win = false;

        while (!win) {
            player.takeUserInput();
            win = player.isCorrectGuess();
        }


    }

}
