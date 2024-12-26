package dao;

import model.Author;

import java.sql.*;

public class AuthorDAO {
    private final Connection connection;

    public AuthorDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Author author) {
        String sql = "INSERT INTO author (surname, first_name, patronymic, publications_number, " +
                "birth_date, death_date, activity_years) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, author.getSurname());
            statement.setString(2, author.getFirstName());
            statement.setString(3, author.getPatronymic());
            statement.setInt(4, author.getPublicationsNumber());
            statement.setDate(5, author.getBirthDate());
            statement.setDate(6, author.getDeathDate());
            statement.setInt(7, author.getActivityYears());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void findAll() {
        String sql = "SELECT * FROM author";
        try (Statement statement = this.connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String surname = resultSet.getString("surname");
                String firstName = resultSet.getString("first_name");
                String patronymic = resultSet.getString("patronymic");
                int publicationsNumber = resultSet.getInt("publications_number");
                Date birthDate = resultSet.getDate("birth_date");
                Date deathDate = resultSet.getDate("death_date");
                int activityYears = resultSet.getInt("activity_years");
                System.out.println(surname + " " + firstName + " " + patronymic + " " + publicationsNumber
                        + " " + birthDate + " " + deathDate + " " + activityYears);
            }
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void delete(String surname, String firstName, String patronymic) {
        String sql = "DELETE FROM author WHERE surname = ? AND first_name = ? AND patronymic = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setString(1, surname);
            statement.setString(2, firstName);
            statement.setString(3, patronymic);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void update(Author author) {
        String sql = "UPDATE author SET publications_number = ?, birth_date = ?, death_date = ?, " +
                "activity_years = ? WHERE surname = ? AND first_name = ? AND patronymic = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setInt(1, author.getPublicationsNumber());
            statement.setDate(2, author.getBirthDate());
            statement.setDate(3, author.getDeathDate());
            statement.setInt(4, author.getActivityYears());
            statement.setString(5, author.getSurname());
            statement.setString(6, author.getFirstName());
            statement.setString(7, author.getPatronymic());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }
}
