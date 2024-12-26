package dao;

import model.Library;

import java.sql.*;

public class LibraryDAO {
    private final Connection connection;

    public LibraryDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Library library) {
        String sql = "INSERT INTO library (government_number, name, address) VALUES (?, ?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setInt(1, library.getGovernmentNumber());
            statement.setString(2, library.getName());
            statement.setString(3, library.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void findAll() {
        String sql = "SELECT * FROM library";
        try (Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("government_number");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                System.out.println(id + " " + name + " " + address);
            }
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM library WHERE government_number = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void update(Library library) {
        String sql = "UPDATE library SET name = ?, address = ? WHERE government_number = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setString(1, library.getName());
            statement.setString(2, library.getAddress());
            statement.setInt(3, library.getGovernmentNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }
}
