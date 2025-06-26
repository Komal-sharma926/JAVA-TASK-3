import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Book class
class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }
}

// User class
class User {
    private String name;
    private List<Book> issuedBooks;

    public User(String name) {
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void addIssuedBook(Book book) {
        issuedBooks.add(book);
    }

    public void removeIssuedBook(Book book) {
        issuedBooks.remove(book);
    }
}

// Library class
class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void issueBook(User user, Book book) {
        if (!book.isIssued()) {
            book.setIssued(true);
            user.addIssuedBook(book);
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book is already issued!");
        }
    }

    public void returnBook(User user, Book book) {
        if (user.getIssuedBooks().contains(book)) {
            book.setIssued(false);
            user.removeIssuedBook(book);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("You haven't issued this book!");
        }
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Issued: " + book.isIssued());
        }
    }

    public void displayUsers() {
        for (User user : users) {
            System.out.println("Name: " + user.getName());
            System.out.println("Issued Books:");
            for (Book book : user.getIssuedBooks()) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Books");
            System.out.println("6. Display Users");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    library.addUser(new User(name));
                    break;
                case 3:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();

                    User user = null;
                    Book book = null;

                    for (User u : library.users) {
                        if (u.getName().equals(userName)) {
                            user = u;
                            break;
                        }
                    }

                    for (Book b : library.books) {
                        if (b.getTitle().equals(bookTitle)) {
                            book = b;
                            break;
                        }
                    }

                    if (user != null && book != null) {
                        library.issueBook(user, book);
                    } else {
                        System.out.println("User or book not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter user name: ");
                    userName = scanner
