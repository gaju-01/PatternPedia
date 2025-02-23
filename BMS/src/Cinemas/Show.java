package Cinemas;

import Enums.Language;
import TheatreInfra.Auditorium;
import TheatreInfra.Seat;

import java.util.ArrayList;
import java.util.List;

public class Show {
    int id;

    Movie movie;

    Auditorium auditorium;

    Language language;
    private static int cnt = 0;

    String startTime;

    String endTime;

    List<Seat> seatList;
    boolean isBooked[];

    public Show() {
        this.id = cnt;
        this.seatList = new ArrayList<>();
        cnt++;
    }

    public Show setMovie(Movie movie) {
        this.movie = movie;
        this.movie.addShow(this);
        return this;
    }

    public Show Auditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
        this.auditorium.addShow(this);
        this.seatList = auditorium.getSeatList();
        this.isBooked = new boolean[this.seatList.size()];
        return this;
    }

    public Show setLang(Language language) {
        this.language = language;
        return this;
    }

    public Show setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public Show setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public void printAvailableSeats() {
        for(int i = 0; i< this.seatList.size(); i++) {
            if(!this.isBooked[i])
                System.out.println("Enter " + i + " to book the seat" + this.seatList.get(i).getSeatNumber());
        }
    }

    public boolean bookSeat(int number) {
        if(number >= this.seatList.size()) {
            System.out.println("Please enter the valid seat number");
            return false;
        }
        synchronized (Show.class) {
            if(this.isBooked[number]) {
                System.out.println("This seat is already booked. Please choose another seat");
                return false;
            } else {
                this.isBooked[number] = false;
                System.out.println("Congratulations!! You have booked the seat");
                return true;
            }
        }
    }

    public void printDetails() {
        System.out.println("Cinemas.Movie: "  + this.movie.getMovieName());
        System.out.println("Lang: " + this.language);
        System.out.println("TheatreInfra.Auditorium: " + this.auditorium.getAuditoriumName());
        System.out.println("Timings: " + this.startTime + " - "  + this.endTime);
    }
}
