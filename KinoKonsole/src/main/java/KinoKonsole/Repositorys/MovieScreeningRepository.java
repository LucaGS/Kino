package KinoKonsole.Repositorys;

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
        String sql = "SELECT movie_screenings.id, movie_screenings.screening_time, movie_screenings.cinema_hall, \r\n" + //
                "   movies.id as MovieId, movies.name As MovieName, movies.description As MovieDescription , Genres.id As GenreId , Genres.name as Genre, Genres.description as GenreDescription FROM movie_screenings\r\n"
                + //
                "      JOIN movies ON movie_screenings.movie_id = movies.id\r\n" + //
                "\t\t JOIN Genres ON Genres.id = Movies.genreid;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Genre genre = new Genre(rs.getInt("GenreId"), rs.getString("Genre"), rs.getString("GenreDescription"));
                Movie movie = new Movie(rs.getInt("MovieId"), rs.getString("MovieName"),
                        rs.getString("MovieDescription"), genre);
                movie.setId(rs.getInt("MovieId"));
                MovieScreening movieScreening = new MovieScreening(rs.getInt("id"), rs.getInt("MovieId"),
                        rs.getObject("screening_time", LocalDateTime.class), rs.getInt("cinema_hall"));
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
