// Book.java
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;
    
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }
    
    // Getters and Setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isBorrowed() { return isBorrowed; }
    
    public void setBorrowed(boolean borrowed) { 
        this.isBorrowed = borrowed; 
    }
    
    @Override
    public String toString() {
        return "Book: " + title + " by " + author + " (ISBN: " + isbn + ")";
    }
}