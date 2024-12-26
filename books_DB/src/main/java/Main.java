import controller.*;
import dao.LibraryDAO;
import model.Library;
import view.CLI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static String operationValue;

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/books_database";
        String user = "root";
        String password = "1337qQ__";

        Scanner scanner = new Scanner(System.in);

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Не удалось установить соединение" + e.getMessage());
        }

        while (true){
            CLI.tableChoice();

            boolean correctTableValue = false;
            while (!correctTableValue){
                String tableValue = scanner.next();
                boolean correctOperationValue = false;
                switch (tableValue){
                    case "1":
                        CLI.operationChoice();

                        while (!correctOperationValue){
                            String operationValue = scanner.next();
                            correctOperationValue =
                                    new BookController(scanner).operationChoose(operationValue, connection);
                        }

                        correctTableValue = true;
                        break;
                    case "2":
                        CLI.operationChoice();

                        while (!correctOperationValue){
                            String operationValue = scanner.next();
                            correctOperationValue =
                                    new BookContentController(scanner).operationChoose(operationValue, connection);
                        }

                        correctTableValue = true;
                        break;
                    case "3":
                        CLI.operationChoice();

                        while (!correctOperationValue){
                            String operationValue = scanner.next();
                            correctOperationValue =
                                    new AuthorController(scanner).operationChoose(operationValue, connection);
                        }

                        correctTableValue = true;
                        break;
                    case "4":
                        CLI.issuanceOperationChoice();

                        while (!correctOperationValue){
                            String operationValue = scanner.next();
                            correctOperationValue =
                                    new IssuanceController(scanner).operationChoose(operationValue, connection);
                        }

                        correctTableValue = true;
                        break;
                    case "5":
                        CLI.operationChoice();

                        while (!correctOperationValue){
                            String operationValue = scanner.next();
                            correctOperationValue =
                                    new ReaderController(scanner).operationChoose(operationValue, connection);
                        }

                        correctTableValue = true;
                        break;
                    case "6":
                        CLI.operationChoice();

                        while (!correctOperationValue){
                            String operationValue = scanner.next();
                            correctOperationValue =
                                    new LibraryController(scanner).operationChoose(operationValue, connection);
                        }

                        correctTableValue = true;
                        break;
                    default:
                        System.out.print("Вы ввели неверный номер, попробуйте еще раз: ");
                }
            }

            String breakSymbol = "";
            while (!breakSymbol.equals("n") && !breakSymbol.equals("y")){
                System.out.print("\nСнова перейти к выбору таблиц? [y/n]: ");
                breakSymbol = scanner.next();
            }
            if (breakSymbol.equals("n")){
                System.exit(0);
            }
            System.out.println();
        }
    }
}
