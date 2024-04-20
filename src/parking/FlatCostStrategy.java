package parking;

import vehicles.VehicleType;
import java.util.HashMap;
import java.util.Map;

public class FlatCostStrategy implements CostStrategy {
    private Map<VehicleType, Double> costPerHour;

    public FlatCostStrategy() {
        costPerHour = new HashMap<>();
        costPerHour.put(VehicleType.BIKE, 10.0);
        costPerHour.put(VehicleType.CAR, 20.0);
        costPerHour.put(VehicleType.TRUCK, 30.0);
        costPerHour.put(VehicleType.BUS, 30.0);
    }

    @Override
    public double calculateCost(int duration) {
        return costPerHour.get(VehicleType.CAR) * duration;
    }
}
