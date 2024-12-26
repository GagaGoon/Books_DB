package dao;

import model.Issuance;

import java.sql.*;

public class IssuanceDAO {
    private final Connection connection;

    public IssuanceDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Issuance issuance) {
        String sql = "INSERT INTO issuance (library_government_number, book_id, library_card, issue_date)" +
                " VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setInt(1, issuance.getLibraryGovernmentNumber());
            statement.setInt(2, issuance.getBookId());
            statement.setInt(3, issuance.getLibraryCard());
            statement.setDate(4, issuance.getIssueDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void findAll() {
        String sql = "SELECT * FROM issuance";
        try (Statement statement = this.connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int libraryGovernmentNumber = resultSet.getInt("library_government_number");
                int bookId = resultSet.getInt("book_id");
                int libraryCard = resultSet.getInt("library_card");
                Date issueDate = resultSet.getDate("issue_date");
                System.out.println(libraryGovernmentNumber + " " + bookId + " " + libraryCard + " " + issueDate);
            }
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void delete(Issuance issuance) {
        String sql = "DELETE FROM issuance WHERE library_government_number = ? AND " +
                "book_id = ? AND library_card = ? AND issue_date = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setInt(1, issuance.getLibraryGovernmentNumber());
            statement.setInt(2, issuance.getBookId());
            statement.setInt(3, issuance.getLibraryCard());
            statement.setDate(4, issuance.getIssueDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void deleteBook(int bookId) {
        String sql = "delete from issuance where book_id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setInt(1, bookId);
            statement.executeUpdate();
        } catch (SQLException e){
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void deleteLibrary(int libraryGovernmentNumber) {
        String sql = "delete from issuance where library_government_number = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setInt(1, libraryGovernmentNumber);
            statement.executeUpdate();
        } catch (SQLException e){
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void deleteReader(int libraryCard) {
        String sql = "delete from issuance where library_card = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setInt(1, libraryCard);
            statement.executeUpdate();
        } catch (SQLException e){
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }
}
