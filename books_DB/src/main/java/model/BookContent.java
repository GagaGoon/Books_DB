package model;

public class BookContent {
    private int bookId;
    private String works;
    private String publisher;
    private int publicationNumber;
    private int publicationYear;

    public BookContent() {}

    public BookContent(int bookId, String works, String publisher, int publicationNumber, int publicationYear) {
        this.bookId = bookId;
        this.works = works;
        this.publisher = publisher;
        this.publicationNumber = publicationNumber;
        this.publicationYear = publicationYear;
    }

    public int getBookId() { return this.bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }
    public String getWorks() { return this.works; }
    public void setWorks(String works) { this.works = works; }
    public String getPublisher() { return this.publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public int getPublicationNumber() { return this.publicationNumber; }
    public void setPublicationNumber(int publicationNumber) { this.publicationNumber = publicationNumber; }
    public int getPublicationYear() { return this.publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }
}
