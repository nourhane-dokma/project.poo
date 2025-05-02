// BorrowingProcess.java
import java.time.LocalDate;

public class BorrowingProcess {
    private Book book;
    private Borrower borrower;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    
    public BorrowingProcess(Book book, Borrower borrower, LocalDate borrowDate, int daysToReturn) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.returnDate = borrowDate.plusDays(daysToReturn);
    }
    
    // Getters
    public Book getBook() { return book; }
    public Borrower getBorrower() { return borrower; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getReturnDate() { return returnDate; }
    
    public boolean isOverdue() {
        return LocalDate.now().isAfter(returnDate);
    }
    
    @Override
    public String toString() {
        return "Borrowing: " + book.getTitle() + " by " + borrower.getName() + 
               " from " + borrowDate + " to " + returnDate;
    }
}