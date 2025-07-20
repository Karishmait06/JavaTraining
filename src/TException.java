import java.util.Scanner;

class MaxRetry extends Exception {
    @Override
    public String toString() {
        return "Maximum number of attempts reached!";
    }

    @Override
    public String getMessage() {
        return "Something went wrong!";
    }
}

public class TException {

    public static void accessAnimeList() throws MaxRetry {
        Scanner sc = new Scanner(System.in);
        String[] anime = {"One Piece", "Death Note", "Demon Slayer", "Vinland Saga", "Attack on Titan"};
        int maxRetries = 5;
        int attempts = 0;

        while (attempts < maxRetries) {
            System.out.println("Attempts: " + attempts + ", Max Retries: " + maxRetries);
            System.out.println("Enter an index from 0 - " + (anime.length - 1) + ": ");
            int index = sc.nextInt();

            if (index >= 0 && index < anime.length) {
                System.out.println("Value at index " + index + " is: " + anime[index]);
                return;
            } else {
                attempts++;
                System.out.println("Invalid index! Attempts left: " + (maxRetries - attempts));
            }
        }


        throw new MaxRetry();
    }

    public static void main(String[] args) {
        try {
            accessAnimeList();
        } catch (MaxRetry e) {
            e.getMessage();
        }
    }
}
