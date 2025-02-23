package TheatreInfra;

import Enums.SeatType;
import TheatreInfra.Auditorium;

public class Seat {
    private int seatNumber;

    private SeatType seatType;

    private Auditorium auditorium;

    private static int cnt = 0;

    public Seat(SeatType seatType, Auditorium auditorium) {
        this.seatNumber = cnt;
        this.seatType = seatType;
        this.auditorium = auditorium;
        this.auditorium.addSeat(this);
        cnt++;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public SeatType getSeatType() {
        return this.seatType;
    }
}
