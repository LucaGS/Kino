package KinoKonsole.Modells;

public class Movie {

    private int id;
    private String name;
    private String description;
    private String Genre;

    public Movie(String name, String description, String Genre){
        this.name = name;
        this.description = description;
        this.Genre = Genre;
    }
    public String getGenre() {
        return Genre;
    }
    public void setGenre(String genre) {
        Genre = genre;
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
}
