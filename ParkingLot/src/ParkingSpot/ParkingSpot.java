package ParkingSpot;

import Vehicle.Vehicle;

public abstract class ParkingSpot {

    private int id;

    private int floor;

    private boolean isFree;
    private Vehicle vehicle;

    private ParkingStatus parkingStatus;

    public ParkingSpot(int id, boolean isFree, int floor, ParkingStatus parkingStatus) {
        this.id = id;
        this.floor = floor;
        this.isFree = isFree;
        this.parkingStatus = parkingStatus;
    }
    public  boolean getIsFree() {
        return this.isFree;
    }

    public boolean unBookSpot() {
        this.vehicle = null;
        return true;
    }
    public boolean bookSpot(Vehicle vehicle) {
        if(parkingStatus == ParkingStatus.NOT_AVAILABLE || parkingStatus == ParkingStatus.RESERVED) {
            return false;
        }
        if (vehicle == null) {
            synchronized (FourWheelerParkingSpot.class) {
                if (vehicle == null) {
                    vehicle = vehicle;
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    public int getId() {return this.id;}

    public int getFloor() {return this.floor;}
}
