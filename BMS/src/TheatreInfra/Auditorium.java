package TheatreInfra;

import Cinemas.Show;

import java.util.ArrayList;
import java.util.List;

public class Auditorium {
    private String auditoriumName;
    private Theatre theatre;

    private List<Seat> seatList;

    private List<Show> showList;

    public Auditorium() {
        this.showList = new ArrayList<>();
        this.seatList = new ArrayList<>();
    }
    public Auditorium setAuditoriumName(String auditoriumName) {
        this.auditoriumName = auditoriumName;
        return this;
    }

    public Auditorium setTheatre(Theatre theatre) {
        this.theatre = theatre;
        this.theatre.addAuditorium(this);
        return this;
    }

    public Theatre getTheatre() {
        return this.theatre;
    }

    public String getAuditoriumName() {
        return this.auditoriumName;
    }

    public void addSeat(Seat seat) {
        this.seatList.add(seat);
    }

    public void addShow(Show show) {
        this.showList.add(show);
    }

    public List<Seat> getSeatList() {
        return this.seatList;
    }
}
