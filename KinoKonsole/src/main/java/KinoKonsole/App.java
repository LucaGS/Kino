package KinoKonsole;

import KinoKonsole.Database;
import KinoKonsole.Modells.MovieScreening;
import KinoKonsole.Modells.User;
import KinoKonsole.Repositorys.MovieScreeningRepository;
import KinoKonsole.Services.UserService;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Database database = new Database();
        Connection connection = database.getConnection();
        if (connection == null) {
            System.err.println("Datenbankverbindung konnte nicht hergestellt werden.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(connection, scanner);
        User user = userService.HandleUser();
        user.PrintUser();
        MovieScreeningRepository movieScreeningRepository = new MovieScreeningRepository(connection);
        ArrayList<MovieScreening> movieScreenings = movieScreeningRepository.GetAllMovieScreenings();
        for (MovieScreening movieScreening : movieScreenings) {
            movieScreening.PrintMovieScreening();
        }
        database.close();
        scanner.close();
    }
}
