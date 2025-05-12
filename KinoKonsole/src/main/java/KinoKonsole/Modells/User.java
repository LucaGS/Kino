package KinoKonsole.Modells;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {
    private String name;
    private String password;
    private boolean isAdmin;
    private Connection connection;
    private Scanner scanner;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;+
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    private boolean Login() {
        System.out.println("Login");
        System.out.print("name: ");
        this.name = scanner.nextLine();
        System.out.print("password: ");
        this.password = scanner.nextLine();

        if (AuthenticateUser()) {
            System.out.println("Login erfolgreich!");
            return true;
        } else {
            System.out.println("Login fehlgeschlagen.");
            return false;
        }
    }

    private boolean Register() {
        System.out.println("Registrierung");
        System.out.print("name: ");
        this.name = scanner.nextLine();
        System.out.print("password: ");
        this.password = scanner.nextLine();

        if (createUserInDbS()) {
            System.out.println("Benutzer erfolgreich registriert!");
            return true;
        } else {
            System.out.println("Registrierung fehlgeschlagen.");
            return false;
        }
    }

    private boolean createUserInDbS() {
        String sql = "INSERT INTO users(name, password, is_admin) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, password); // Hinweis: Passwort sollte gehasht werden!
            pstmt.setBoolean(3, isAdmin);
            pstmt.executeUpdate();
            System.out.println("Benutzer hinzugefügt: " + name);
            return true;
        } catch (SQLException e) {
            System.err.println("Fehler beim Hinzufügen des Benutzers: " + e.getMessage());
            return false;
        }
    }

    public void PrintUser() {
        System.out.println("Benutzername: " + name);
        System.out.println("Passwort: " + password);
        System.out.println("Ist Administrator: " + (isAdmin ? "Ja" : "Nein"));
    }

    private boolean AuthenticateUser() {
        String sql = "SELECT * FROM users WHERE name = ? AND password = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, password); // Hinweis: Passwort sollte gehasht werden!
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                isAdmin = rs.getBoolean("is_admin");
                System.out.println("Benutzer " + name + " ist " + (isAdmin ? "Administrator" : "normaler Benutzer"));
                return true;
            } else {
                System.out.println("Benutzername oder Passwort falsch.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Fehler bei der Authentifizierung des Benutzers: " + e.getMessage());
            return false;
        }
    }
}
