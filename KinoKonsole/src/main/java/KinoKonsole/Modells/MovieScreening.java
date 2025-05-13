package KinoKonsole.Modells;

import java.time.LocalDateTime;

public class MovieScreening {
    private int id;
    private Movie movie;
    private int movieId;
    private LocalDateTime screeningTime;
    private int cinema_hall;

    public MovieScreening(int id, int movieId, LocalDateTime screeningTime, int cinema_hall) {
        this.movieId = movieId;
        this.screeningTime = screeningTime;
        this.cinema_hall = cinema_hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public MovieScreening(int movieId, LocalDateTime screeningTime, int cinema_hall) {
        this.movieId = movieId;
        this.screeningTime = screeningTime;
        this.cinema_hall = cinema_hall;
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

    public int getCinema_hall() {
        return cinema_hall;
    }

    public void setCinema_hall(int cinema_hall) {
        this.cinema_hall = cinema_hall;

    }

    public void PrintMovieScreening() {
        System.out.println("MovieId: " + movieId);
        System.out.println("ScreeningTime: " + screeningTime);
        System.out.println("CinemaHall: " + cinema_hall);
        this.movie.PrintMovie();
        System.out.println("--------------------------------------------------");
    }
}
