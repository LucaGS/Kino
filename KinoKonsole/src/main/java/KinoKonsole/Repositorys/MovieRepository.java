package KinoKonsole.Repositorys;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import KinoKonsole.Modells.Movie;
import KinoKonsole.Modells.User;;
public class MovieRepository {
    private Connection connection;
    public MovieRepository(Connection connection){
        this.connection = connection;
    }

    public ArrayList<Movie> GetAllMovies(){
    ArrayList<Movie> movies = new ArrayList<Movie>();
    final String sql = "SELECT \r\n" + //
                "    Movies.id,\r\n" + //
                "    Movies.name AS filmname,\r\n" + //
                "    Movies.description,\r\n" + //
                "    Genres.name AS genre\r\n" + //
                "FROM \r\n" + //
                "    Movies\r\n" + //
                "JOIN \r\n" + //
                "    Genres ON Movies.genreid = Genres.id;";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)){
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            Movie movie = new Movie(rs.getString("name"), rs.getString("description"), rs.getString("Genre"));
            movie.setId(rs.getInt("id"));
            movies.add(movie);
        }
        return movies;

    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
    }
    public Movie CreateMovie(String name, String description, int genreId){
        final String sql = "INSERT INTO Movies (name, description, genreid) VALUES(?,?,?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setInt(3, genreId);
            pstmt.executeUpdate();
            String query = "Select Movies.id, Movies.name, Movies.description, Genres.name as genre FROM Movies Join Genres On Movies.genreid = Genres.id WHERE name = ?";
            try (PreparedStatement getUser = connection.prepareStatement(query)) {
            getUser.setString(1, name);
            ResultSet rs = getUser.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String genre = rs.getString("genre");
                Movie movie = new Movie(name,description,genre);
                movie.setId(id);
                return movie;
            }
        }
        }catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
}
