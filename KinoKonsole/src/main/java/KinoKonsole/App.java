package KinoKonsole;

import KinoKonsole.Database;
import KinoKonsole.Modells.User;

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
        User user = new User(connection, scanner);

        // Schließen Sie die Verbindung
        database.close();

        System.out.println("Hello World!");
    }
}
