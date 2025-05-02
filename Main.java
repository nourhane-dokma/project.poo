// Main.java
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        // Sample data
        initializeSampleData(library);
        
        while (true) {
            System.out.println("\n=== Digital Library Management System ===");
            System.out.println("1. Add a new book");
            System.out.println("2. Add a new borrower");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Search for a book");
            System.out.println("6. Search for a borrower");
            System.out.println("7. Display all books");
            System.out.println("8. Display all borrowers");
            System.out.println("9. Display borrowed books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addNewBook(library, scanner);
                    break;
                case 2:
                    addNewBorrower(library, scanner);
                    break;
                case 3:
                    borrowBook(library, scanner);
                    break;
                case 4:
                    returnBook(library, scanner);
                    break;
                case 5:
                    searchBook(library, scanner);
                    break;
                case 6:
                    searchBorrower(library, scanner);
                    break;
                case 7:
                    library.displayAllBooks();
                    break;
                case 8:
                    library.displayAllBorrowers();
                    break;
                case 9:
                    library.displayBorrowedBooks();
                    break;
                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void initializeSampleData(Library library) {
        // Add sample books
        library.addBook(new PaperBook("Java Programming", "John Doe", "1234567890", 500));
        library.addBook(new EBook("Python Basics", "Jane Smith", "0987654321", "PDF"));
        
        // Add sample borrowers
        library.addBorrower(new Borrower("Alice Johnson", "S1001"));
        library.addBorrower(new Borrower("Bob Williams", "S1002"));
    }
    
    private static void addNewBook(Library library, Scanner scanner) {
        System.out.println("\n=== Add New Book ===");
        System.out.print("Enter book type (1-Paper, 2-EBook): ");
        int type = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        if (type == 1) {
            System.out.print("Enter page count: ");
            int pages = scanner.nextInt();
            library.addBook(new PaperBook(title, author, isbn, pages));
        } else {
            System.out.print("Enter file format: ");
            String format = scanner.nextLine();
            library.addBook(new EBook(title, author, isbn, format));
        }
        
        System.out.println("Book added successfully!");
    }
    
    private static void addNewBorrower(Library library, Scanner scanner) {
        System.out.println("\n=== Add New Borrower ===");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        
        library.addBorrower(new Borrower(name, id));
        System.out.println("Borrower added successfully!");
    }
    
    private static void borrowBook(Library library, Scanner scanner) {
        System.out.println("\n=== Borrow a Book ===");
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        
        Borrower borrower = library.findBorrowerById(id);
        if (borrower == null) {
            System.out.println("Borrower not found!");
            return;
        }
        
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        
        Book book = library.findBookByTitle(title);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        
        System.out.print("Enter days to return: ");
        int days = scanner.nextInt();
        scanner.nextLine();
        
        library.borrowBook(borrower, book, days);
    }
    
    private static void returnBook(Library library, Scanner scanner) {
        System.out.println("\n=== Return a Book ===");
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        
        Borrower borrower = library.findBorrowerById(id);
        if (borrower == null) {
            System.out.println("Borrower not found!");
            return;
        }
        
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        
        Book book = library.findBookByTitle(title);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        
        library.returnBook(borrower, book);
    }
    
    private static void searchBook(Library library, Scanner scanner) {
        System.out.println("\n=== Search for a Book ===");
        System.out.println("1. By title");
        System.out.println("2. By author");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice == 1) {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            Book book = library.findBookByTitle(title);
            if (book != null) {
                System.out.println("Book found: " + book);
            } else {
                System.out.println("Book not found!");
            }
        } else if (choice == 2) {
            System.out.print("Enter author: ");
            String author = scanner.nextLine();
            List<Book> books = library.findBooksByAuthor(author);
            if (!books.isEmpty()) {
                System.out.println("Books by " + author + ":");
                for (Book book : books) {
                    System.out.println(book);
                }
            } else {
                System.out.println("No books found by this author!");
            }
        } else {
            System.out.println("Invalid choice!");
        }
    }
    
    private static void searchBorrower(Library library, Scanner scanner) {
        System.out.println("\n=== Search for a Borrower ===");
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        
        Borrower borrower = library.findBorrowerById(id);
        if (borrower != null) {
            System.out.println("Borrower found: " + borrower);
            System.out.println("Borrowed books:");
            for (Book book : borrower.getBorrowedBooks()) {
                System.out.println("- " + book);
            }
        } else {
            System.out.println("Borrower not found!");
        }
    }
}