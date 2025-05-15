package KinoKonsole.Repositorys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import KinoKonsole.Modells.Booking;
import KinoKonsole.Modells.MovieScreening;

public class BookingRepositry {
    private Connection connection;

    public BookingRepositry(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Booking> gettBookingForScreening(int screeningId, MovieScreening movieScreening) {
        ArrayList<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE movie_screening_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, screeningId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Booking booking = new Booking(resultSet.getInt("id"), movieScreening, resultSet.getInt("row"),
                        resultSet.getInt("number"), resultSet.getBoolean("is_booked"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;

    }
}
