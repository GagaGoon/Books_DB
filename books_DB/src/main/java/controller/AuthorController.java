package controller;

import dao.AuthorDAO;
import dao.BookDAO;
import model.Author;

import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

public class AuthorController {
    Scanner scanner;

    public AuthorController(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean operationChoose(String option, Connection connection) {
        switch (option) {
            case "1":
                scannerInsert(connection);
                return true;
            case "2":
                findAllAuthor(connection);
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

        System.out.print("Введите фамилию автора: ");
        String surname = this.scanner.next();

        System.out.print("Введите имя автора: ");
        String firstName = this.scanner.next();

        System.out.print("Введите отчество автора: ");
        String patronymic = this.scanner.next();

        System.out.print("Введите количество публикаций: ");
        int publicationNumber = Integer.parseInt(this.scanner.next());

        System.out.print("Введите дату рождения(гггг-мм-дд): ");
        Date birthDate = Date.valueOf(this.scanner.next());

        System.out.print("Введите дату смерти(гггг-мм-дд): ");
        Date deathDate = Date.valueOf(this.scanner.next());

        System.out.print("Введите годы деятельности: ");
        int activityYears = Integer.parseInt(this.scanner.next());

        Author author = new Author(surname, firstName, patronymic, publicationNumber,
                birthDate, deathDate, activityYears);

        AuthorDAO authorDAO = new AuthorDAO(connection);
        authorDAO.insert(author);
    }

    public void scannerDelete(Connection connection) {
        System.out.print("\nВведите фамилию автора, которого надо удалить: ");
        String surname = this.scanner.next();

        System.out.print("Ведите имя автора, которого надо удалить: ");
        String firstName = this.scanner.next();

        System.out.print("Ведите отчество автора, которого надо удалить: ");
        String patronymic = this.scanner.next();

        AuthorDAO authorDAO = new AuthorDAO(connection);
        authorDAO.delete(surname, firstName, patronymic);

        BookDAO bookDAO = new BookDAO(connection);
        bookDAO.deleteAuthor(surname, firstName, patronymic);
    }

    public void scannerUpdate(Connection connection) {
        System.out.print("\nВведите фамилию автора, данные которого надо изменить: ");
        String surname = this.scanner.next();

        System.out.print("Ведите имя автора, данные которого надо изменить: ");
        String firstName = this.scanner.next();

        System.out.print("Ведите отчество автора, данные которого надо изменить: ");
        String patronymic = this.scanner.next();

        System.out.println("\nТеперь введите новые данные");

        System.out.print("Введите новое количество публикаций: ");
        int publicationsNumber = Integer.parseInt(this.scanner.next());

        System.out.print("Введите новую дату рождения(гггг-мм-дд): ");
        Date birthDate = Date.valueOf(this.scanner.next());

        System.out.print("Введите новую дату смерти(гггг-мм-дд): ");
        Date deathDate = Date.valueOf(this.scanner.next());

        System.out.print("Введите новые годы активности: ");
        int activityYears = Integer.parseInt(this.scanner.next());

        Author author = new Author(surname, firstName, patronymic, publicationsNumber,
                birthDate, deathDate, activityYears);
        AuthorDAO authorDAO = new AuthorDAO(connection);
        authorDAO.update(author);
    }

    public static void findAllAuthor(Connection connection) {
        System.out.println("Вот все строки из таблицы авторов:\n");

        AuthorDAO authorDAO = new AuthorDAO(connection);
        authorDAO.findAll();
    }
}
