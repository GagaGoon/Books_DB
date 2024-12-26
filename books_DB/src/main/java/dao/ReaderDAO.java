package dao;

import model.Reader;

import java.sql.*;

public class ReaderDAO {
    private final Connection connection;

    public ReaderDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Reader reader) {
        String sql = "INSERT INTO reader (library_card, library_government_number, surname, first_name, patronymic) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setInt(1, reader.getLibraryCard());
            statement.setInt(2, reader.getLibraryGovernmentNumber());
            statement.setString(3, reader.getSurname());
            statement.setString(4, reader.getFirstName());
            statement.setString(5, reader.getPatronymic());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void findAll() {
        String sql = "SELECT * FROM reader";
        try (Statement statement = this.connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int libraryCard = resultSet.getInt("library_card");
                int libraryGovernmentNumber = resultSet.getInt("library_government_number");
                String surname = resultSet.getString("surname");
                String firstName = resultSet.getString("first_name");
                String patronymic = resultSet.getString("patronymic");
                System.out.println(libraryCard + " " + libraryGovernmentNumber + " " + surname
                        + " " + firstName + " " + patronymic);
            }
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void delete(int libraryCard) {
        String sql = "DELETE FROM reader WHERE library_card = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setInt(1, libraryCard);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void deleteLibrary(int libraryGovernmentNumber) {
        String sql = "delete from reader where library_government_number = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setInt(1, libraryGovernmentNumber);
            statement.executeUpdate();
        } catch (SQLException e){
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void update(Reader reader) {
        String sql = "UPDATE reader SET library_government_number = ?, surname = ?, first_name = ?, " +
                "patronymic = ? WHERE library_card = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setInt(1, reader.getLibraryGovernmentNumber());
            statement.setString(2, reader.getSurname());
            statement.setString(3, reader.getFirstName());
            statement.setString(4, reader.getPatronymic());
            statement.setInt(5, reader.getLibraryCard());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }
}
