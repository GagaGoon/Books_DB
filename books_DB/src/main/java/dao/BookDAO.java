package dao;

import model.Book;
import java.sql.*;

public class BookDAO {
    private final Connection connection;

    public BookDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Book book) {
        String sql = "INSERT INTO book (id, title, author_surname, author_first_name, author_patronymic)" +
                " VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setInt(1, book.getId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthorSurname());
            statement.setString(4, book.getAuthorFirstName());
            statement.setString(5, book.getAuthorPatronymic());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void findAll() {
        String sql = "SELECT * FROM book";
        try (Statement statement = this.connection.createStatement()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String authorSurname = resultSet.getString("author_surname");
                String authorFirstName = resultSet.getString("author_first_name");
                String authorPatronymic = resultSet.getString("author_patronymic");
                System.out.println(id + " " + title + " " + authorSurname
                        + " " + authorFirstName + " " + authorPatronymic);
            }
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }

        try (ResultSet resultSet = statement.executeQuery(sql))
    }

    public void findTitle(String title) {
        String sql = "SELECT * FROM book WHERE title = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String authorSurname = resultSet.getString("author_surname");
                String authorFirstName = resultSet.getString("author_first_name");
                String authorPatronymic = resultSet.getString("author_patronymic");
                System.out.println(id + " " + title + " " + authorSurname
                        + " " + authorFirstName + " " + authorPatronymic);
            }
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM book WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void deleteAuthor(String authorSurname, String authorFirstName, String authorPatronymic) {
        String sql = "DELETE FROM book WHERE author_surname = ? AND author_first_name = ? AND author_patronymic = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setString(1, authorSurname);
            statement.setString(2, authorFirstName);
            statement.setString(3, authorPatronymic);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void deleteByDate(Date date) {
        String sql = "DELETE FROM book WHERE date = ?";
    }

    public void update(Book book) {
        String sql = "UPDATE book SET title = ?, author_surname = ?, author_first_name = ?, " +
                "author_patronymic = ? WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthorSurname());
            statement.setString(3, book.getAuthorFirstName());
            statement.setString(4, book.getAuthorPatronymic());
            statement.setInt(5, book.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }
}
