// Library.java
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Borrower> borrowers;
    private List<BorrowingProcess> borrowingProcesses;
    
    public Library() {
        this.books = new ArrayList<>();
        this.borrowers = new ArrayList<>();
        this.borrowingProcesses = new ArrayList<>();
    }
    
    // Book management
    public void addBook(Book book) {
        books.add(book);
    }
    
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    
    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }
    
    // Borrower management
    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
    }
    
    public Borrower findBorrowerById(String studentId) {
        for (Borrower borrower : borrowers) {
            if (borrower.getStudentId().equals(studentId)) {
                return borrower;
            }
        }
        return null;
    }
    
    // Borrowing process
    public void borrowBook(Borrower borrower, Book book, int daysToReturn) {
        if (!book.isBorrowed()) {
            borrower.borrowBook(book);
            BorrowingProcess process = new BorrowingProcess(
                book, borrower, LocalDate.now(), daysToReturn);
            borrowingProcesses.add(process);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is already borrowed.");
        }
    }
    
    public void returnBook(Borrower borrower, Book book) {
        if (book.isBorrowed()) {
            borrower.returnBook(book);
            // Remove the borrowing process
            borrowingProcesses.removeIf(process -> 
                process.getBook().equals(book) && 
                process.getBorrower().equals(borrower));
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not borrowed by this borrower.");
        }
    }
    
    // Display methods
    public void displayAllBooks() {
        System.out.println("\n=== All Books ===");
        for (Book book : books) {
            System.out.println(book);
        }
    }
    
    public void displayAllBorrowers() {
        System.out.println("\n=== All Borrowers ===");
        for (Borrower borrower : borrowers) {
            System.out.println(borrower);
        }
    }
    
    public void displayBorrowedBooks() {
        System.out.println("\n=== Currently Borrowed Books ===");
        for (BorrowingProcess process : borrowingProcesses) {
            System.out.println(process);
        }
    }
}