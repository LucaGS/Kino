package KinoKonsole.Modells;

import KinoKonsole.Modells.Genre;

public class Movie {

    private int id;
    private String name;
    private String description;
    private Genre genre;

    public Movie(String name, String description, Genre Genre) {
        this.name = name;
        this.description = description;
        this.genre = Genre;
    }

    public Movie(int id, String name, String description, Genre Genre) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.genre = Genre;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void PrintMovie() {
        System.out.println("Filmtitel: " + name);
        System.out.println("Beschreibung: " + description);
        System.out.println("Genre: " + genre.getName());
        System.out.println("Genre Beschreibung: " + genre.getDescription());
    }
}
