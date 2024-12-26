package controller;

import dao.IssuanceDAO;
import model.Issuance;

import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

public class IssuanceController {
    Scanner scanner;

    public IssuanceController(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean operationChoose(String option, Connection connection) {
        switch (option) {
            case "1":
                scannerInsert(connection);
                return true;
            case "2":
                findAllIssuance(connection);
                return true;
            case "3":
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
        int libraryGovernmentNumber = Integer.parseInt(this.scanner.next());

        System.out.print("Введите id книги: ");
        int bookId = Integer.parseInt(this.scanner.next());

        System.out.print("Введите читательский билет: ");
        int libraryCard = Integer.parseInt(this.scanner.next());

        System.out.print("Введите дату выдачи(гггг-мм-дд): ");
        Date issueDate = Date.valueOf(this.scanner.next());

        Issuance issuance = new Issuance(libraryGovernmentNumber, bookId, libraryCard, issueDate);

        IssuanceDAO issuanceDAO = new IssuanceDAO(connection);
        issuanceDAO.insert(issuance);
    }

    public void scannerDelete(Connection connection) {
        System.out.print("\nВведите номер библиотеки в госреестре, строку с которым надо удалить: ");
        int libraryGovernmentNumber = Integer.parseInt(this.scanner.next());

        System.out.print("Введите id книги, строку с которым надо удалить: ");
        int bookId = Integer.parseInt(this.scanner.next());

        System.out.print("Введите читательский билет, строку с которым надо удалить: ");
        int libraryCard = Integer.parseInt(this.scanner.next());

        System.out.print("Введите дату выдачи, строку с которым надо удалить(гггг-мм-дд): ");
        Date issueDate = Date.valueOf(this.scanner.next());

        Issuance issuance = new Issuance(libraryGovernmentNumber, bookId, libraryCard, issueDate);

        IssuanceDAO issuanceDAO = new IssuanceDAO(connection);
        issuanceDAO.delete(issuance);
    }

    public static void findAllIssuance(Connection connection) {
        System.out.println("Вот все строки из таблицы выдач:\n");

        IssuanceDAO issuanceDAO = new IssuanceDAO(connection);
        issuanceDAO.findAll();
    }
}
