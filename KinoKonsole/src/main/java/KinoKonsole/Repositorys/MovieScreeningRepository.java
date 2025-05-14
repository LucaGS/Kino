package KinoKonsole.Repositorys;

import KinoKonsole.Modells.CinemaHall;
import KinoKonsole.Modells.Genre;
import KinoKonsole.Modells.Movie;
import KinoKonsole.Modells.MovieScreening;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MovieScreeningRepository {
    private Connection connection;

    public MovieScreeningRepository(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<MovieScreening> GetAllMovieScreenings() {
        ArrayList<MovieScreening> movieScreenings = new ArrayList<MovieScreening>();
        String sql = "SELECT \r\n" + //
                "    movie_screenings.id AS screeningId,\r\n" + //
                "    movie_screenings.screening_time,\r\n" + //
                "\r\n" + //
                "    Movies.id AS movieId,\r\n" + //
                "    Movies.name AS movieName,\r\n" + //
                "    Movies.description AS movieDescription,\r\n" + //
                "\r\n" + //
                "    Genres.id AS genreId,\r\n" + //
                "    Genres.name AS genreName,\r\n" + //
                "    Genres.description AS genreDescription,\r\n" + //
                "\r\n" + //
                "    cinema_hall.id AS hallId,\r\n" + //
                "    cinema_hall.name AS hallName,\r\n" + //
                "    cinema_hall.rows,\r\n" + //
                "    cinema_hall.numbers\r\n" + //
                "\r\n" + //
                "FROM movie_screenings\r\n" + //
                "JOIN Movies ON Movies.id = movie_screenings.movie_id\r\n" + //
                "JOIN Genres ON Movies.genreid = Genres.id\r\n" + //
                "JOIN cinema_hall ON cinema_hall.id = movie_screenings.cinema_hall_id;\r\n" + //
                "";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Genre genre = new Genre(rs.getInt("genreId"), rs.getString("genreName"),
                        rs.getString("genreDescription"));
                Movie movie = new Movie(rs.getInt("movieId"), rs.getString("movieName"),
                        rs.getString("movieDescription"), genre);
                CinemaHall cinemaHall = new CinemaHall(rs.getInt("hallId"), rs.getString("hallName"),
                        rs.getInt("rows"), rs.getInt("numbers"));
                MovieScreening movieScreening = new MovieScreening(rs.getInt("screeningId"), movie,
                        rs.getObject("screening_time", LocalDateTime.class), cinemaHall);
                movieScreening.setMovie(movie);
                movieScreenings.add(movieScreening);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return movieScreenings;

    }

    public void addMovieScreening(int movieId, LocalDateTime screeningTime, int cinema_hall) {
        String sql = "INSERT INTO movie_screenings (movie_id, screening_time, cinema_hall) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, movieId);
            statement.setObject(2, screeningTime);
            statement.setInt(3, cinema_hall);
            statement.executeUpdate();
            // String query = "SELECT * FROM movie_screenings WHERE movie_id = ? AND
            // screening_time = ? AND cinema_hall = ?";

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

}
