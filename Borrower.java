// Borrower.java
import java.util.ArrayList;
import java.util.List;

public class Borrower {
    private String name;
    private String studentId;
    private List<Book> borrowedBooks;
    
    public Borrower(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.borrowedBooks = new ArrayList<>();
    }
    
    // Getters
    public String getName() { return name; }
    public String getStudentId() { return studentId; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
    
    // Methods
    public void borrowBook(Book book) {
        if (!book.isBorrowed()) {
            borrowedBooks.add(book);
            book.setBorrowed(true);
        }
    }
    
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setBorrowed(false);
        }
    }
    
    @Override
    public String toString() {
        return "Borrower: " + name + " (ID: " + studentId + ")";
    }
}