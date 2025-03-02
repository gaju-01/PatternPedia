package Vehicle;

import Ticket.Ticket;

public abstract class Vehicle {
    private String licenseNo;

    private Ticket ticket;

    public Vehicle(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public boolean assignTicket(Ticket ticket) {
        this.ticket = ticket;
        return true;
    }

    public String getLicenseNo() {
        return this.licenseNo;
    }
}
