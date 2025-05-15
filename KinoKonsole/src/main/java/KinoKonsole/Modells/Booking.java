package KinoKonsole.Modells;

public class Booking {

    int id;
    MovieScreening movieScreening;

    private int row;
    private int number;
    private boolean isBooked;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public Booking(int id, MovieScreening movieScreening, int row, int number, boolean isBooked) {
        this.id = id;
        this.movieScreening = movieScreening;
        this.row = row;
        this.number = number;
        this.isBooked = isBooked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
