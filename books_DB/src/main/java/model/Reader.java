package model;

public class Reader {
    private int libraryCard;
    private int libraryGovernmentNumber;
    private String surname;
    private String firstName;
    private String patronymic;

    public Reader() {}

    public Reader(int libraryCard, int libraryGovernmentNumber, String surname, String firstName, String patronymic) {
        this.libraryCard = libraryCard;
        this.libraryGovernmentNumber = libraryGovernmentNumber;
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public int getLibraryCard() { return this.libraryCard; }
    public void setLibraryCard(int libraryCard) { this.libraryCard = libraryCard; }
    public int getLibraryGovernmentNumber() { return this.libraryGovernmentNumber; }
    public void setLibraryGovernmentNumber(int libraryGovernmentNumber) { this.libraryGovernmentNumber = libraryGovernmentNumber; }
    public String getSurname() { return this.surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getFirstName() { return this.firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getPatronymic() { return this.patronymic; }
    public void setPatronymic() { this.patronymic = patronymic; }
}
