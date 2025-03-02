package EntranceAndExits;

import ParkingSpot.ParkingSpot;
import Ticket.Ticket;
import Vehicle.Vehicle;

import java.time.LocalDateTime;

public class Entrance {
    private int no;

    public Entrance(int no) {
        this.no = no;
    }

    public Ticket generateTicket(int no, ParkingSpot parkingSpot, Vehicle vehicle) {
        parkingSpot.bookSpot(vehicle);
        return new Ticket(no, vehicle, LocalDateTime.of(2025, 3, 3, 0, 0, 0), parkingSpot);
    }
}
