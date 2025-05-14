package KinoKonsole.Modells;

import java.util.ArrayList;

public class CinemaHall {
    private int id;
    private ArrayList<Seat>seats;
    
    //Fills seats with row like A and number like 1 starting from A , 1
    public CinemaHall(int id ,int number, char lastrow){
        this.seats = new ArrayList<Seat>();
       for (char c = 'A'; c <= lastrow; c++) {
        for(int i = 1; i <= number; i++){
            this.seats.add(new Seat(c, i));
        }
    }
    }
    public ArrayList<Seat> getSeats() {
        return seats;
    }
    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
     public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
