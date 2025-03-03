package Ticket;

import ParkingSpot.ParkingSpot;
import Vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ticket {

    private int no;
    private Vehicle vehicle;
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private ParkingSpot parkingSpot;

    public Ticket(int no, Vehicle vehicle, LocalDateTime endTime, ParkingSpot parkingSpot) {
        this.no = no;
        this.vehicle = vehicle;
        this.startTime = LocalDateTime.now();
        this.endTime = endTime;
        this.vehicle.assignTicket(this);
        this.parkingSpot = parkingSpot;
    }

    public void printTicketDetails() {
        System.out.println("Ticket no: " + this.no);
        System.out.println("Vehicle license: " + this.vehicle.getLicenseNo());
        System.out.println("Start time: " + this.startTime);
        System.out.println("endTime: " + this.endTime);
        System.out.println("parking spot: " + this.parkingSpot.getFloor() + " " + this.parkingSpot.getId());
        System.out.println("************************************************************************");
    }

    public ParkingSpot getParkingSpot() {
        return this.parkingSpot;
    }
}
