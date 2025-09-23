package ParkingLot;

import java.util.List;

public class Floor {
    int floorId;
    List<ParkingSlot> parkingSlots;

    public Floor(int floorId, List<ParkingSlot> parkingSlots) {
        this.floorId = floorId;
        this.parkingSlots = parkingSlots;
    }
    
    public int getFloorId(){
        return floorId;
    }
    public List<ParkingSlot> getParkingSlots(){
        return parkingSlots;
    }
}
