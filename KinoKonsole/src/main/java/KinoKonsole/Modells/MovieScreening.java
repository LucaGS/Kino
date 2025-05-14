package KinoKonsole.Modells;

import java.time.LocalDateTime;

public class MovieScreening {
    private int id;
    private Movie movie;
    private int movieId;
    private LocalDateTime screeningTime;
    private CinemaHall cinemaHall;

    public MovieScreening(int id, int movieId, LocalDateTime screeningTime, CinemaHall cinemaHall) {
        this.movieId = movieId;
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

    public CinemaHall getCinema_hall() {
        return cinemaHall;
    }

    public void setCinema_hall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;

    }

    public void PrintMovieScreening() {
        System.out.println("ScreeningId: "+ id);
        //System.out.println("MovieId: " + movieId);
        System.out.println("ScreeningTime: " + screeningTime);
        System.out.println("CinemaHall: " + cinemaHall);
        this.movie.PrintMovie();
        System.out.println("--------------------------------------------------");
    }
}
