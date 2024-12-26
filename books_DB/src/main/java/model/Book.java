package model;

public class Book {
    private int id;
    private String title;
    private String authorSurname;
    private String authorFirstName;
    private String authorPatronymic;

    public Book() {}

    public Book(int id, String title, String authorSurname, String authorFirstName, String authorPatronymic) {
        this.id = id;
        this.title = title;
        this.authorSurname = authorSurname;
        this.authorFirstName = authorFirstName;
        this.authorPatronymic = authorPatronymic;
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthorSurname() { return this.authorSurname; }
    public void setAuthorSurname(String authorSurname) { this.authorSurname = authorSurname; }
    public String getAuthorFirstName() { return this.authorFirstName; }
    public void setAuthorFirstName(String authorFirstName) { this.authorFirstName = authorFirstName; }
    public String getAuthorPatronymic() { return this.authorPatronymic; }
    public void setAuthorPatronymic(String authorPatronymic) { this.authorPatronymic = authorPatronymic; }
}