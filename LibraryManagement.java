package OasisInfobyte;


import java.util.*;

    // Book class representing a book entity
    class Book {
        private int bookId;
        private String title;
        private String author;
        private boolean available;

        public Book(int bookId, String title, String author, boolean available) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.available = available;
        }

        // Getters and setters
        public int getBookId() {
            return bookId;
        }

        public void setBookId(int bookId) {
            this.bookId = bookId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }
    }

    // Library class managing books and operations
    class Library {
        private List<Book> books;

        public Library() {
            this.books = new ArrayList<>();
        }

        // Add a new book to the library
        public void addBook(Book book) {
            books.add(book);
        }

        // Remove a book from the library
        public void removeBook(int bookId) {
            books.removeIf(book -> book.getBookId() == bookId);
        }

        // Display all books in the library
        public void displayBooks() {
            for (Book book : books) {
                System.out.println("Book ID: " + book.getBookId() +
                        ", Title: " + book.getTitle() +
                        ", Author: " + book.getAuthor() +
                        ", Available: " + (book.isAvailable() ? "Yes" : "No"));
            }
        }

        // Issue a book by marking it unavailable
        public void issueBook(int bookId) {
            for (Book book : books) {
                if (book.getBookId() == bookId && book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book issued successfully.");
                    return;
                }
            }
            System.out.println("Book not available for issue.");
        }

        // Return a book by marking it available
        public void returnBook(int bookId) {
            for (Book book : books) {
                if (book.getBookId() == bookId && !book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book returned successfully.");
                    return;
                }
            }
            System.out.println("Book not available for return.");
        }
    }

    // Main class to run the library management system
    public class LibraryManagement {
        public static void main(String[] args) {
            Library library = new Library();

            // Adding some initial books
            library.addBook(new Book(1, "Java Programming", "John Doe", true));
            library.addBook(new Book(2, "Python Basics", "Jane Smith", true));
            library.addBook(new Book(3, "Data Structures", "Alan Turing", false));

            // Display all books in the library
            System.out.println("Books available in the library:");
            library.displayBooks();

            // Example of issuing a book
            library.issueBook(2);

            // Display updated book status
            System.out.println("\nBooks after issuing:");
            library.displayBooks();

            // Example of returning a book
            library.returnBook(3);

            // Display updated book status
            System.out.println("\nBooks after returning:");
            library.displayBooks();
        }
    }

