package KinoKonsole.Services;

import java.util.Scanner;
import java.sql.Connection;
import KinoKonsole.Modells.User;
import KinoKonsole.Repositorys.UserRepository;

public class UserService {
    private Connection connection;
    private Scanner scanner;
    private UserRepository userRepository;
    private User user;

    public UserService(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
        this.userRepository = new UserRepository(this.connection);
    }

    public User HandleUser() {
        int choice = 0;
        while (this.user == null) {
            System.out.println("UserService gestartet.");
            System.out.println("[1] Login.");
            System.out.println("[2] Register.");
            System.out.println("[3] Abbrechen.");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Login();
                    break;
                case 2:
                    Register();
                    break;
                case 3:
                    System.out.println("Abgebrochen.");
                    return null;
                default:
                    System.out.println("Ungültige Auswahl.");
            }
        }
        return this.user;
    }

    public void Login() {
        System.out.println("Login gestartet.");
        System.out.print("Benutzername: ");
        String name = scanner.next();
        System.out.print("Passwort: ");
        String password = scanner.next();
        this.user = this.userRepository.authenticateUser(name, password);
        if (userRepository.authenticateUser(name, password) != null) {
            System.out.println("Login erfolgreich.");
        } else {
            System.out.println("Login fehlgeschlagen. Überprüfen Sie Ihren Benutzernamen und Ihr Passwort.");
            return;
        }
    }

    public void Register() {
        System.out.println("Register gestartet.");
        System.out.print("Benutzername: ");
        String name = scanner.next();
        System.out.print("Passwort: ");
        String password = scanner.next();
        System.out.print("Admin (true/false): ");
        boolean isAdmin = false;
        this.user = userRepository.registerUser(name, password, isAdmin);
        if (this.user != null) {
            System.out.println("Registrierung erfolgreich.");

        } else {
            System.out.println("Registrierung fehlgeschlagen. Überprüfen Sie Ihre Eingaben.");
        }
    }
}
