package controller;

import dao.BookContentDAO;
import model.BookContent;

import java.sql.Connection;
import java.util.Scanner;

public class BookContentController {
    Scanner scanner;

    public BookContentController(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean operationChoose(String option, Connection connection) {
        switch (option) {
            case "1":
                scannerInsert(connection);
                return true;
            case "2":
                findAllBookContent(connection);
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
        int bookId = Integer.parseInt(this.scanner.next());

        System.out.print("Введите список произведений: ");
        String works = this.scanner.next();

        System.out.print("Введите издателя: ");
        String publisher = this.scanner.next();

        System.out.print("Введите номер издания: ");
        int publicationNumber = Integer.parseInt(this.scanner.next());

        System.out.print("Введите год издания: ");
        int publicationYear = Integer.parseInt(this.scanner.next());

        BookContent bookContent = new BookContent(bookId, works, publisher, publicationNumber, publicationYear);

        BookContentDAO bookContentDAO = new BookContentDAO(connection);
        bookContentDAO.insert(bookContent);
    }

    public void scannerDelete(Connection connection) {
        System.out.print("\nВведите id книги, содержание которой надо удалить: ");
        int bookId = Integer.parseInt(this.scanner.next());

        BookContentDAO bookContentDAO = new BookContentDAO(connection);
        bookContentDAO.delete(bookId);
    }

    public void scannerUpdate(Connection connection) {
        System.out.print("\nВведите id книги, чьи данные надо изменить: ");
        int bookId = Integer.parseInt(this.scanner.next());

        System.out.println("\nТеперь введите новые данные");

        System.out.print("\nВведите новый список произведений: ");
        String works = this.scanner.next();

        System.out.print("Введите нового издателя: ");
        String publisher = this.scanner.next();

        System.out.print("Введите новый номер издания: ");
        int publicationNumber = Integer.parseInt(this.scanner.next());

        System.out.print("Введите новый год издания: ");
        int publicationYear = Integer.parseInt(this.scanner.next());

        BookContent bookContent = new BookContent(bookId, works, publisher, publicationNumber, publicationYear);

        BookContentDAO bookContentDAO = new BookContentDAO(connection);
        bookContentDAO.update(bookContent);
    }

    public static void findAllBookContent(Connection connection) {
        System.out.println("Вот все строки из таблицы содержания книг:\n");

        BookContentDAO bookContentDAO = new BookContentDAO(connection);
        bookContentDAO.findAll();
    }
}
