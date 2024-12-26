package model;

import java.sql.Date;

public class Author {
    private String surname;
    private String firstName;
    private String patronymic;
    private int publicationsNumber;
    private Date birthDate;
    private Date deathDate;
    private int activityYears;

    public Author() {}

    public Author(String surname, String firstName, String patronymic, int publicationsNumber, Date birthDate,
                  Date deathDate, int activityYears) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.publicationsNumber = publicationsNumber;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.activityYears = activityYears;
    }

    public String getSurname() { return this.surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getFirstName() { return this.firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getPatronymic() { return this.patronymic; }
    public void setPatronymic() { this.patronymic = patronymic; }
    public int getPublicationsNumber() { return this.publicationsNumber; }
    public void setPublicationsNumber(int publicationsNumber) { this.publicationsNumber = publicationsNumber; }
    public Date getBirthDate() { return this.birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
    public Date getDeathDate() { return this.deathDate; }
    public void setDeathDate(Date deathDate) { this.deathDate = deathDate; }
    public int getActivityYears() { return this.activityYears; }
    public void setActivityYears(int activityYears) { this.activityYears = activityYears; }
}
