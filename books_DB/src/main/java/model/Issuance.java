package model;

import java.sql.Date;

public class Issuance {
    private int libraryGovernmentNumber;
    private int bookId;
    private int libraryCard;
    private Date issueDate;

    public Issuance() {}

    public Issuance(int libraryGovernmentNumber, int bookId, int libraryCard, Date issueDate) {
        this.libraryGovernmentNumber = libraryGovernmentNumber;
        this.bookId = bookId;
        this.libraryCard = libraryCard;
        this.issueDate = issueDate;
    }

    public int getLibraryGovernmentNumber() { return libraryGovernmentNumber; }
    public void setLibraryGovernmentNumber(int libraryGovernmentNumber) {
        this.libraryGovernmentNumber = libraryGovernmentNumber;
    }
    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }
    public int getLibraryCard() { return libraryCard; }
    public void setLibraryCard(int libraryCard) { this.libraryCard = libraryCard; }
    public Date getIssueDate() { return issueDate; }
    public void setIssueDate(Date issueDate) { this.issueDate = issueDate; }
}
