/*
Create a library management system which is capable of issuing books to students.
Books should have info :
1. Book name
2. Book author
3. Issued to
4. Issued on
User should be able to add books, return issued books, issue books
Assume that all users are registered with their names in their central database

book class - isIssued(),issueTo(), returnBack();
library class - addBook(), issueBook(), returnBook(), listAllBooks()
 */

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class Book {
    protected final String name;
    protected final String author;
    protected String issuedTo;
    protected LocalDate issuedOn;

    Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    boolean isIssued() {
        return issuedTo != null;
    }

    void issueTo(String student) {
        issuedTo = student;
        issuedOn = LocalDate.now();
    }

    void returnBack() {
        issuedTo = null;
        issuedOn = null;
    }
    @Override
    public String toString() {
        return name + " by " + author +
                (isIssued() ? " (Issued to: " + issuedTo + " on " + issuedOn + ")" : " (Available)");
    }
}

class Library1 {
    private final Set<String> registeredStudents = Set.of("Luffy", "Zoro", "Shanks", "Oden", "Law");
    private final HashMap<String, Book> books = new HashMap<>();

    void addBook(String name, String author) {
        String key = name.toLowerCase();
        if (books.containsKey(key)) {
            System.out.println("Book already exists!");
            return;
        }
        books.put(key, new Book(name, author));
        System.out.println(name + "Book added");
    }

    void issueBook(String name, String student) {
        String key = name.toLowerCase();
        Book book = books.get(key);
        if (book == null) {
            System.out.println("Book not found");
            return;
        }
        if (!registeredStudents.contains(student)) {
            System.out.println("Student " + student + " is not registered");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Already issued to " + book.issuedTo);
            return;
        }
        book.issueTo(student);
        System.out.println("Book issued to" + student);

    }

    void returnBook(String name) {
        String key = name.toLowerCase();
        Book book = books.get(key);
        if (book == null) {
            System.out.println("Book not found");
            return;
        }
        if (!book.isIssued()) {
            System.out.println("Book was not issued");
            return;
        }
        book.returnBack();
        System.out.println("Book returned");
    }

    void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty");
            return;
        }
        books.values().forEach(System.out::println);
    }


}

public class LibrayManagementSystem {
    public static void main(String[] args) {
        Library1 library = new Library1();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. List Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Book name : ");
                    String name = sc.nextLine();
                    System.out.print("Author : ");
                    String author = sc.nextLine();
                    library.addBook(name, author);
                }
                case 2 -> {
                    System.out.print("Book name to issue : ");
                    String name = sc.nextLine();
                    System.out.print("Student name : ");
                    String student = sc.nextLine();
                    library.issueBook(name, student);
                }
                case 3 -> {
                    System.out.println("Book name to return : ");
                    String name = sc.nextLine();
                    library.returnBook(name);
                }
                case 4 -> library.listBooks();
                case 5 -> {
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Please choose a valid option (1–5).");

            }
        }
    }
}
