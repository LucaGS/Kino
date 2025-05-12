package KinoKonsole.Repositorys;

import KinoKonsole.Modells.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserRepository {
    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

   public User registerUser(String name, String password, boolean isAdmin) {
    String sql = "INSERT INTO users (name, password, is_admin) VALUES (?, ?, ?)";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1, name);
        pstmt.setString(2, password);
        pstmt.setBoolean(3, isAdmin);
        pstmt.executeUpdate();
        String query = "SELECT * FROM users WHERE name = ?";
        try (PreparedStatement getUser = connection.prepareStatement(query)) {
            getUser.setString(1, name);
            ResultSet rs = getUser.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                User user = new User(name, password, isAdmin);
                user.setId(id);
                return user;
            }
        }
    } catch (Exception e) {
        System.err.println("Fehler beim Registrieren des Benutzers: " + e.getMessage());
    }
    return null;
}



    public User authenticateUser(String name, String password) {
        String sql = "SELECT * FROM users WHERE name = ? AND password = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                String _name = rs.getString("name");
                String _password = rs.getString("password");
                boolean _isAdmin = rs.getBoolean("is_admin");
                int _id = rs.getInt("id");
                User user = new User(_name, _password, _isAdmin);
                user.setId(_id);
                return user;
            }
             // Gibt true zurück, wenn ein Benutzer gefunden wurde
        } catch (Exception e) {
            System.err.println("Fehler beim Authentifizieren des Benutzers: " + e.getMessage());
            
        }return null;
    }
}
