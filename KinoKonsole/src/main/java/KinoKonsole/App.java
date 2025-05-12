package KinoKonsole;

import KinoKonsole.Database;
import KinoKonsole.Modells.User;
import KinoKonsole.Services.UserService;
import java.sql.Connection;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Erstellen Sie eine Instanz der Database-Klasse
        Database database = new Database();
        Connection connection = database.getConnection();
        if (connection == null) {
            System.err.println("Datenbankverbindung konnte nicht hergestellt werden.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(connection, scanner);
        userService.HandleUser();
        database.close();
        scanner.close();
    }
}
