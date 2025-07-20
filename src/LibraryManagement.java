import java.util.Scanner;

class Library {
    String[] availableBooks = new String[100];
    String[] issuedBooks = new String[100];
    int bookCount = 0;
    int issuedCount = 0;

    public void addBook (String name) {
    availableBooks[bookCount] = name;
    bookCount++;
    }

    public void showAvailableBooks () {
        System.out.println("Available books:");
        for (String availableBook : availableBooks) {
            if (availableBook != null) {
                System.out.println(" --> " + availableBook);
            }
        }

    }
    public void issueBook (String name) {
        for (int i = 0; i < bookCount; i++) {
            if(availableBooks[i] != null && availableBooks[i].equalsIgnoreCase(name)){
                issuedBooks[issuedCount] = availableBooks[i];
                issuedCount++;
                availableBooks[i] = null;
                System.out.println("Book '" + name + "' has been issued.");
                return;
            }
        }
        System.out.println("Book '" + name + "' is not available.");
    }

    public void returnBook (String name) {
        for (int i = 0; i < issuedCount; i++) {
            if(issuedBooks[i] != null && issuedBooks[i].equalsIgnoreCase(name)) {
                availableBooks[bookCount] = issuedBooks[i];
                bookCount++;
                issuedBooks[i] = null;
                System.out.println("Book '" + name + "' has been returned.");
                return;
            }
        }
        System.out.println("Book '" + name + "' is not issued to return.");

    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lb = new Library();
        while (true) {
            System.out.println("Welcome to the Library. \n 1 : Add Book. \n 2: Show available books. \n 3 : Issue book \n 4: Return Book \n 5 : Exit");
            byte option = sc.nextByte();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter the book name you want to add: ");
                    String addName = sc.nextLine();
                    lb.addBook(addName);
                    break;

                case 2:
                    lb.showAvailableBooks();
                    break;

                case 3:
                    System.out.print("Enter the book name you want to issue: ");
                    String issueName = sc.nextLine();
                    lb.issueBook(issueName);
                    break;

                case 4:
                    System.out.print("Enter the book name you want to return: ");
                    String returnName = sc.nextLine();
                    lb.returnBook(returnName);
                    break;

                case 5:
                    System.out.println("Exiting Library System. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose 1–5.");
            }
        }
    }
}
