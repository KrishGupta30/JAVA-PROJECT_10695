class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // default available
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter for availability
    public void setAvailable(boolean status) {
        isAvailable = status;
    }
}

class Library {
    private Book[] books;

    // Constructor
    public Library() {
        books = new Book[3];

        // Sample books
        books[0] = new Book("Java Basics", "James Gosling");
        books[1] = new Book("Data Structures", "Mark Allen Weiss");
        books[2] = new Book("OOP Concepts", "Bjarne Stroustrup");
    }

    // Display all books
    public void displayBooks() {
        System.out.println("\nAvailable Books:");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i].getTitle() + " - " +
                    (books[i].isAvailable() ? "Available" : "Issued"));
        }
    }

    // Search book
    public void searchBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + b.getTitle() + " by " + b.getAuthor());
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Issue book
    public void issueBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (b.isAvailable()) {
                    b.setAvailable(false);
                    System.out.println("Book issued successfully");
                } else {
                    System.out.println("Book is already issued");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Return book
    public void returnBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.setAvailable(true);
                System.out.println("Book returned successfully");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        library.displayBooks();

        System.out.println("\nSearching Book: Java Basics");
        library.searchBook("Java Basics");

        System.out.println("\nIssuing Book: Java Basics");
        library.issueBook("Java Basics");

        System.out.println("\nIssuing Book: Java Basics");
        library.issueBook("Java Basics");

        System.out.println("\nReturning Book: Java Basics");
        library.returnBook("Java Basics");

        library.displayBooks();
    }
}