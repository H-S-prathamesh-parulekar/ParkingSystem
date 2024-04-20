package parking;

import vehicles.Floor;
import vehicles.Vehicle;
import vehicles.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int totalFloors;
    private int spacesPerFloor;
    private Map<Integer, Floor> floors;
    private CostStrategy costStrategy;

    public ParkingLot(int totalFloors, int spacesPerFloor, CostStrategy costStrategy) {
        this.totalFloors = totalFloors;
        this.spacesPerFloor = spacesPerFloor;
        this.costStrategy = costStrategy;
        this.floors = new HashMap<>();
        initializeFloors();
    }

    private void initializeFloors() {
        for (int i = 1; i <= totalFloors; i++) {
            floors.put(i, new Floor(i, spacesPerFloor));
        }
    }

    public int addVehicle(Vehicle vehicle) {
        for (Floor floor : floors.values()) {
            int spaceNumber = floor.findAvailableSpace(vehicle.getType());
            if (spaceNumber != -1) {
                floor.occupySpace(spaceNumber);
                return spaceNumber;
            }
        }
        return -1; // No available space
    }

    public void removeVehicle(int floorNumber, int spaceNumber) {
        Floor floor = floors.get(floorNumber);
        if (floor != null) {
            floor.vacateSpace(spaceNumber);
        }
    }

    public double calculateParkingFee(int duration) {
        return costStrategy.calculateCost(duration);
    }
}
