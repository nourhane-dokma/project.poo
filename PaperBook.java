// PaperBook.java
public class PaperBook extends Book {
    private int pageCount;
    
    public PaperBook(String title, String author, String isbn, int pageCount) {
        super(title, author, isbn);
        this.pageCount = pageCount;
    }
    
    public int getPageCount() { return pageCount; }
    
    @Override
    public String toString() {
        return super.toString() + " [Paper, Pages: " + pageCount + "]";
    }
}

// EBook.java
public class EBook extends Book {
    private String fileFormat;
    
    public EBook(String title, String author, String isbn, String fileFormat) {
        super(title, author, isbn);
        this.fileFormat = fileFormat;
    }
    
    public String getFileFormat() { return fileFormat; }
    
    @Override
    public String toString() {
        return super.toString() + " [EBook, Format: " + fileFormat + "]";
    }
}