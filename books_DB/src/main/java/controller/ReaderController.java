package controller;

import dao.IssuanceDAO;
import dao.ReaderDAO;
import model.Reader;

import java.sql.Connection;
import java.util.Scanner;

public class ReaderController {
    Scanner scanner;

    public ReaderController(Scanner scanner) {
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

        System.out.print("\nВведите номер читательского билета: ");
        int libraryCard = Integer.parseInt(this.scanner.next());

        System.out.print("Введите номер библиотеки в госреестре: ");
        int libraryGovernmentNumber = Integer.parseInt(this.scanner.next());

        System.out.print("Введите фамилию читателя: ");
        String surname = this.scanner.next();

        System.out.print("Введите имя читателя: ");
        String firstName = this.scanner.next();

        System.out.print("Введите отчество читателя: ");
        String patronymic = this.scanner.next();

        Reader reader = new Reader(libraryCard, libraryGovernmentNumber, surname, firstName, patronymic);

        ReaderDAO readerDAO = new ReaderDAO(connection);
        readerDAO.insert(reader);
    }

    public void scannerDelete(Connection connection) {
        System.out.print("\nВведите номер читательского билета, который надо удалить: ");
        int libraryCard = Integer.parseInt(this.scanner.next());

        ReaderDAO readerDAO = new ReaderDAO(connection);
        readerDAO.delete(libraryCard);

        IssuanceDAO issuanceDAO = new IssuanceDAO(connection);
        issuanceDAO.deleteReader(libraryCard);
    }

    public void scannerUpdate(Connection connection) {
        System.out.print("\nВведите номер читательского билета, чьи данные надо изменить: ");
        int libraryCard = Integer.parseInt(this.scanner.next());

        System.out.println("\nТеперь введите новые данные");

        System.out.print("Введите номер библиотеки в госреестре: ");
        int libraryGovernmentNumber = Integer.parseInt(this.scanner.next());

        System.out.print("Введите фамилию читателя: ");
        String surname = this.scanner.next();

        System.out.print("Введите имя читателя: ");
        String firstName = this.scanner.next();

        System.out.print("Введите отчество читателя: ");
        String patronymic = this.scanner.next();

        Reader reader = new Reader(libraryCard, libraryGovernmentNumber, surname, firstName, patronymic);

        ReaderDAO readerDAO = new ReaderDAO(connection);
        readerDAO.update(reader);
    }

    public static void findAllLibrary(Connection connection) {
        System.out.println("Вот все строки из таблицы читателей:\n");

        ReaderDAO readerDAO = new ReaderDAO(connection);
        readerDAO.findAll();
    }
}
