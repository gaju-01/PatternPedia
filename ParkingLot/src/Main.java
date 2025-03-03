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

        Vehicle yamaha = new TwoWheeler("1");
        Vehicle hundai = new FourWheeler("2");
        Vehicle tata = new FourWheeler("2");

        ParkingSpot twoWheelerParkingSpot1 = new TwoWheelerParkingSpot(1, true, 1, ParkingStatus.AVAILABLE);
        ParkingSpot fourWheelerParkingSpot1 = new FourWheelerParkingSpot(1, false, 2, ParkingStatus.AVAILABLE);
        ParkingSpot fourWheelerParkingSpot2 = new FourWheelerParkingSpot(2, false, 2, ParkingStatus.RESERVED);

        Entrance northEntrance = new Entrance(1);
        Entrance eastEntrance = new Entrance(2);

        Exit southExit = new Exit(1);
        Exit westExit = new Exit(2);

        Ticket ticketForTwoWheeler1 = northEntrance.generateTicket(1, twoWheelerParkingSpot1, yamaha);
        Ticket ticketForFourWheeler1 = eastEntrance.generateTicket(2, fourWheelerParkingSpot1, hundai);
        northEntrance.generateTicket(3, fourWheelerParkingSpot2, tata);

        ticketForFourWheeler1.printTicketDetails();
        ticketForTwoWheeler1.printTicketDetails();

        westExit.checkTicket(ticketForFourWheeler1);
        southExit.checkTicket(ticketForTwoWheeler1);
    }
}