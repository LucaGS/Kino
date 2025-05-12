package KinoKonsole.Repositorys;

import KinoKonsole.Modells.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository {
    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public boolean registerUser(User user) {
        String sql = "INSERT INTO users (name, password, isAdmin) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setBoolean(3, user.isAdmin());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Fehler beim Registrieren des Benutzers: " + e.getMessage());
            return false;
        }
    }

    public boolean authenticateUser(String name, String password) {
        String sql = "SELECT * FROM users WHERE name = ? AND password = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Gibt true zurück, wenn ein Benutzer gefunden wurde
        } catch (Exception e) {
            System.err.println("Fehler beim Authentifizieren des Benutzers: " + e.getMessage());
            return false;
        }
    }
}
