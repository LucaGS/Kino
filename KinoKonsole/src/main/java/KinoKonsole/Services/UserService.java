package KinoKonsole.Services;

import java.util.Scanner;
import java.sql.Connection;
import KinoKonsole.Modells.User;
import KinoKonsole.Repositorys.UserRepository;

public class UserService {
    private Connection connection;
    private Scanner scanner;
    private UserRepository userRepository;

    public UserService(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
        this.userRepository = new UserRepository(connection);
    }

    public User HandleUser() {
        int choice = 0;
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
                break;
            default:
                System.out.println("Ungültige Auswahl.");
        }

    }

    public void Login() {
        System.out.println("Login gestartet.");
        System.out.print("Benutzername: ");
        String name = scanner.next();
        System.out.print("Passwort: ");
        String password = scanner.next();
        this.userRepository.authenticateUser(name, password);
        if (userRepository.authenticateUser(name, password)) {
            System.out.println("Login erfolgreich.");
        } else {
            System.out.println("Login fehlgeschlagen. Überprüfen Sie Ihren Benutzernamen und Ihr Passwort.");
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
        User user = new User(name, password, isAdmin);
        if (userRepository.registerUser(user)) {
            System.out.println("Registrierung erfolgreich.");
        } else {
            System.out.println("Registrierung fehlgeschlagen. Überprüfen Sie Ihre Eingaben.");
        }
    }
}
