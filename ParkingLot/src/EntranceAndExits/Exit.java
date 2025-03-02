package EntranceAndExits;

import Ticket.Ticket;

public class Exit {
   private int no;

   public Exit(int no) {
       this.no = no;
   }

   public void checkTicket(Ticket ticket) {
       ticket.getParkingSpot().unBookSpot();
       if(ticket.getParkingSpot().getIsFree())
           System.out.println("You paid price of " + 0);
       else
        System.out.println("You paid price of " + 200);
       ticket = null;
   }
}
