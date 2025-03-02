import EntranceAndExits.Entrance;
import EntranceAndExits.Exit;
import ParkingSpot.ParkingSpot;
import Ticket.Ticket;
import Vehicle.Vehicle;
import Vehicle.TwoWheeler;
import  Vehicle.FourWheeler;
import ParkingSpot.TwoWheelerParkingSpot;
import ParkingSpot.FourWheelerParkingSpot;
import ParkingSpot.ParkingStatus;

public class Main {

    public static void main(String[] args) {

        Vehicle twoWheeler = new TwoWheeler("1");
        Vehicle fourWheeler = new FourWheeler("2");
        Vehicle fourWheeler2 = new FourWheeler("2");

        ParkingSpot s1 = new TwoWheelerParkingSpot(1, true, 1, ParkingStatus.AVAILABLE);
        ParkingSpot s2 = new FourWheelerParkingSpot(2, false, 2, ParkingStatus.AVAILABLE);
        ParkingSpot s3 = new FourWheelerParkingSpot(2, false, 2, ParkingStatus.RESERVED);

        Entrance e1 = new Entrance(1);
        Entrance e2 = new Entrance(2);

        Exit ex1 = new Exit(1);
        Exit ex2 = new Exit(2);

        Ticket t1 = e1.generateTicket(1, s1, twoWheeler);
        Ticket t2 = e2.generateTicket(2, s2, fourWheeler);
        e1.generateTicket(3, s3, fourWheeler2);

        t1.printTicketDetails();
        t2.printTicketDetails();

        ex1.checkTicket(t1);
        ex2.checkTicket(t2);
    }
}