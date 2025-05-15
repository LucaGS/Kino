package KinoKonsole.Services;

import java.util.ArrayList;
import java.util.Scanner;

import KinoKonsole.Modells.Booking;
import KinoKonsole.Modells.CinemaHall;
import KinoKonsole.Modells.Movie;
import KinoKonsole.Modells.MovieScreening;
import KinoKonsole.Modells.User;
import KinoKonsole.Repositorys.BookingRepositry;
import KinoKonsole.Repositorys.MovieRepository;
import KinoKonsole.Repositorys.MovieScreeningRepository;

public class BookingService {
    private User user;
    private MovieScreeningRepository movieScreeningRepository;
    private MovieRepository movieRepository;
    private Scanner scanner;
    private BookingRepositry BookingRepositry;

    public BookingService(User user, MovieScreeningRepository movieScreeningRepository, Scanner scanner,
            BookingRepositry bookingRepositry) {
        this.user = user;
        this.movieScreeningRepository = movieScreeningRepository;
        this.scanner = scanner;
        this.BookingRepositry = bookingRepositry;
    }

    public MovieScreening selectScreening() {
        System.out.println("Bitte wählen Sie eine Filmvorführung aus:");
        ArrayList<MovieScreening> movieScreenings = movieScreeningRepository.GetAllMovieScreenings();
        if (movieScreenings == null) {
            System.err.println("Fehler beim Abrufen der Filmvorführungen.");
            return null;
        }
        for (MovieScreening movieScreening : movieScreenings) {
            System.out.println("[" + movieScreening.getId() + "] ");
            System.out.println("Film: " + movieScreening.getMovie().getName());
            System.out.println("Datum: " + movieScreening.getScreeningTime());
        }
        System.out.print("Bitte geben Sie die ID der gewünschten Filmvorführung ein: ");
        int screeningId = scanner.nextInt();
        MovieScreening selectedScreening = findMovieScreeningById(movieScreenings, screeningId);
        System.out.println("Sie haben die Filmvorführung mit der ID " + screeningId + " ausgewählt.");
        selectedScreening.PrintMovieScreening();
        return selectedScreening;
    }

    private MovieScreening findMovieScreeningById(ArrayList<MovieScreening> movieScreenings, int screeningId) {
        MovieScreening selectedScreening;
        for (MovieScreening movieScreening : movieScreenings) {
            if (movieScreening.getId() == screeningId) {
                selectedScreening = movieScreening;
                return selectedScreening;
            }
            break;
        }
        System.out.println("Filmvorführung nicht gefunden.");
        return null;
    }

    public void bookSeat() {
        MovieScreening selectedScreening = selectScreening();
        ArrayList<Booking> bookings = BookingRepositry.gettBookingForScreening(selectedScreening.getId(),
                selectedScreening);
        for (Booking booking : bookings) {
            System.out.println("[" + booking.getId() + "] " + booking.getRow() + " - " + booking.getNumber() + " - "
                    + booking.isBooked());
        }
    }

    public void selectMovie() {
        ArrayList<Movie> movies = movieRepository.GetAllMovies();
        for (Movie movie : movies) {
            System.out.println("[" + movie.getId() + "] " + movie.getName() + " - " + movie.getDescription());
        }

    }
}
