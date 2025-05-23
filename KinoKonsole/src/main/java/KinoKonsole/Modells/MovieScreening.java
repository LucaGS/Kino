package KinoKonsole.Modells;

import java.time.LocalDateTime;

public class MovieScreening {
    private int id;
    private Movie movie;
    private int movieId;
    private LocalDateTime screeningTime;
    private CinemaHall cinemaHall;

    public MovieScreening(int id, Movie movie, LocalDateTime screeningTime, CinemaHall cinemaHall) {
        this.id = id;
        this.movie = movie;
        this.screeningTime = screeningTime;
        this.cinemaHall = cinemaHall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public MovieScreening(int movieId, LocalDateTime screeningTime, CinemaHall cinemaHall) {
        this.movieId = movieId;
        this.screeningTime = screeningTime;
        this.cinemaHall = cinemaHall;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public LocalDateTime getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(LocalDateTime screeningTime) {
        this.screeningTime = screeningTime;
    }

    public CinemaHall getCinemaHall() {
        return this.cinemaHall;
    }

    public void setCinema_hall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;

    }

    public void PrintMovieScreening() {
        System.out.println("ScreeningId: " + id);
        System.out.println("Movie: " + movie.getName());
        System.out.println("ScreeningTime: " + screeningTime);
        System.out.println("CinemaHall: " + cinemaHall.GetName());
        this.movie.PrintMovie();
        System.out.println("--------------------------------------------------");
    }
}
