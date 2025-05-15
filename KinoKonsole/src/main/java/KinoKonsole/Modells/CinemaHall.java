package KinoKonsole.Modells;

import java.util.ArrayList;

public class CinemaHall {
    private int id;
    private String name;
    private int rows;
    private int numbers;

    // Fills seats with row like A and number like 1 starting from A , 1
    public CinemaHall(int id, String name, int rows, int numbers) {
        this.id = id;
        this.name = name;
        this.rows = rows;
        this.numbers = numbers;
    }

    public int GetRows() {
        return this.rows;
    }

    public int GetNumbers() {
        return this.numbers;
    }

    public void SetNumbers(int numbers) {
        this.numbers = numbers;
    }

    public void SetRows(int rows) {
        this.rows = rows;
    }

    public String GetName() {
        return this.name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public void PrintCinemaHall() {
        System.out.println("Kinosaal: " + name);
        System.out.println("Reihen: " + rows);
        System.out.println("Sitzplätze: " + numbers);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
