package KinoKonsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String DB_URL = "jdbc:sqlite:Kino.db";
    private Connection connection;

    public Database() {
        connect();
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("SQLite-Datenbank verbunden.");
        } catch (SQLException e) {
            System.err.println("Verbindungsfehler: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            System.err.println("Fehler beim Schließen der Verbindung: " + e.getMessage());
        }
    }
}
