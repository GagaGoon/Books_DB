package controller;

import dao.IssuanceDAO;
import dao.LibraryDAO;
import dao.ReaderDAO;
import model.Library;

import java.sql.Connection;
import java.util.Scanner;

public class LibraryController {
    Scanner scanner;

    public LibraryController(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean operationChoose(String option, Connection connection) {
        switch (option) {
            case "1":
                scannerInsert(connection);
                return true;
            case "2":
                findAllLibrary(connection);
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

        System.out.print("\nВведите номер библиотеки в госреестре: ");
        int governmentNumber = Integer.parseInt(this.scanner.next());

        System.out.print("Введите название библиотеки: ");
        String name = this.scanner.next();

        System.out.print("Введите адрес библиотеки: ");
        String address = this.scanner.next();

        Library library = new Library(governmentNumber, name, address);

        LibraryDAO libraryDAO = new LibraryDAO(connection);
        libraryDAO.insert(library);
    }

    public void scannerDelete(Connection connection) {
        System.out.print("\nВведите номер библиотеки, которую надо удалить: ");
        int governmentNumber = Integer.parseInt(this.scanner.next());

        LibraryDAO libraryDAO = new LibraryDAO(connection);
        libraryDAO.delete(governmentNumber);

        IssuanceDAO issuanceDAO = new IssuanceDAO(connection);
        issuanceDAO.deleteLibrary(governmentNumber);

        ReaderDAO readerDAO = new ReaderDAO(connection);
        readerDAO.deleteLibrary(governmentNumber);
    }

    public void scannerUpdate(Connection connection) {
        System.out.print("\nВведите номер библиотеки в госреестре, чьи данные надо изменить: ");
        int governmentNumber = Integer.parseInt(this.scanner.next());

        System.out.println("\nТеперь введите новые данные");

        System.out.print("\nВведите новое название библиотеки: ");
        String name = this.scanner.next();

        System.out.print("Введите новый адрес библиотеки: ");
        String address = this.scanner.next();

        Library library = new Library(governmentNumber, name, address);
        LibraryDAO libraryDAO = new LibraryDAO(connection);
        libraryDAO.update(library);
    }

    public static void findAllLibrary(Connection connection) {
        System.out.println("Вот все строки из таблицы библиотек:\n");

        LibraryDAO libraryDAO = new LibraryDAO(connection);
        libraryDAO.findAll();
    }
}
