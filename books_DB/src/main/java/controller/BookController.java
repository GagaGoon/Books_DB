package controller;

import dao.BookContentDAO;
import dao.BookDAO;
import dao.IssuanceDAO;
import model.Book;

import java.sql.Connection;
import java.util.Scanner;

public class BookController {
    Scanner scanner;

    public BookController(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean operationChoose(String option, Connection connection) {
        switch (option) {
            case "1":
                scannerInsert(connection);
                return true;
            case "2":
                findAllBook(connection);
                return true;
            case "3":
                scannerUpdate(connection);
                return true;
            case "4":
                scannerDelete(connection);
                return true;
            default:
                System.out.print("Вы ввели неверный номер, попробуйте еще раз: ");
                return false;
        }
    }

    public void scannerInsert(Connection connection) {
        System.out.println("\nВведите данные для новой строки");

        System.out.print("\nВведите id книги: ");
        int id = Integer.parseInt(this.scanner.next());

        System.out.print("Введите название книги: ");
        String title = this.scanner.next();

        System.out.print("Введите фамилию автора: ");
        String authorSurname = this.scanner.next();

        System.out.print("Введите имя автора: ");
        String authorFirstName = this.scanner.next();

        System.out.print("Введите отчество автора: ");
        String authorPatronymic = this.scanner.next();

        Book book = new Book(id, title, authorSurname, authorFirstName, authorPatronymic);

        BookDAO bookDAO = new BookDAO(connection);
        bookDAO.insert(book);
    }

    public void scannerDelete(Connection connection) {
        System.out.print("\nВведите id книги, которую надо удалить: ");
        int id = Integer.parseInt(this.scanner.next());

        BookDAO bookDAO = new BookDAO(connection);
        bookDAO.delete(id);

        BookContentDAO bookContentDAO = new BookContentDAO(connection);
        bookContentDAO.delete(id);

        IssuanceDAO issuanceDAO = new IssuanceDAO(connection);
        issuanceDAO.deleteBook(id);
    }

    public void scannerUpdate(Connection connection) {
        System.out.print("\nВведите id книги, чьи данные надо изменить: ");
        int id = Integer.parseInt(this.scanner.next());

        System.out.println("\nТеперь введите новые данные");

        System.out.print("\nВведите новое название книги: ");
        String title = this.scanner.next();

        System.out.print("Введите новую фамилию автора: ");
        String authorSurname = this.scanner.next();

        System.out.print("Введите новое имя автора: ");
        String authorFirstName = this.scanner.next();

        System.out.print("Введите новое отчество автора: ");
        String authorPatronymic = this.scanner.next();

        Book book = new Book(id, title, authorSurname, authorFirstName, authorPatronymic);

        BookDAO bookDAO = new BookDAO(connection);
        bookDAO.update(book);
    }

    public static void findAllBook(Connection connection) {
        System.out.println("Вот все строки из таблицы книг:\n");

        BookDAO bookDAO = new BookDAO(connection);
        bookDAO.findAll();
    }
}
