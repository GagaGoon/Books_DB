package dao;

import model.BookContent;

import java.sql.*;

public class BookContentDAO {
    private final Connection connection;

    public BookContentDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(BookContent bookContent) {
        String sql = "INSERT INTO book_content (book_id, works, publisher, " +
                "publication_number, publication_year) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setInt(1, bookContent.getBookId());
            statement.setString(2, bookContent.getWorks());
            statement.setString(3, bookContent.getPublisher());
            statement.setInt(4, bookContent.getPublicationNumber());
            statement.setInt(5, bookContent.getPublicationYear());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void findAll() {
        String sql = "SELECT book_content.book_id, book.title, book.author_surname, book.author_first_name, " +
                "book.author_patronymic, book_content.works, book_content.publisher, book_content.publication_number, " +
                "book_content.publication_year FROM book_content inner join book on book_content.book_id=book.id";
        try (Statement statement = this.connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int bookId = resultSet.getInt("book_id");
                String title = resultSet.getString("title");
                String authorSurname = resultSet.getString("author_surname");
                String authorFirstName = resultSet.getString("author_first_name");
                String authorPatronymic = resultSet.getString("author_patronymic");
                String works = resultSet.getString("works");
                String publisher = resultSet.getString("publisher");
                int publicationNumber = resultSet.getInt("publication_number");
                int publicationYear = resultSet.getInt("publication_year");
                System.out.println(bookId + " " + title + " " + authorSurname + " " + authorFirstName +
                        " " + authorPatronymic + " " + works + " " + publisher + " " +
                        publicationNumber + " " + publicationYear);
            }
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void delete(int bookId) {
        String sql = "DELETE FROM book_content WHERE book_id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setInt(1, bookId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }

    public void update(BookContent bookContent) {
        String sql = "UPDATE book_content SET works = ?, publisher = ?, publication_number = ?, " +
                "publication_year = ? WHERE book_id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)){
            statement.setString(1, bookContent.getWorks());
            statement.setString(2, bookContent.getPublisher());
            statement.setInt(3, bookContent.getPublicationNumber());
            statement.setInt(4, bookContent.getPublicationYear());
            statement.setInt(5, bookContent.getBookId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("какая то ошибка " + e.getMessage());
        }
    }
}
