import parking.*;
import vehicles.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize parking lot with 2 floors and 2 spaces per floor for cars
        ParkingLot parkingLot = new ParkingLot(2, 2, new FlatCostStrategy());

        while (true) {
            System.out.println("\n===== Car Parking System Menu =====");
            System.out.println("1. Park a vehicle");
            System.out.println("2. Remove a vehicle");
            System.out.println("3. Calculate parking fee");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    parkVehicle(parkingLot, scanner);
                    break;
                case 2:
                    removeVehicle(parkingLot, scanner);
                    break;
                case 3:
                    calculateParkingFee(parkingLot, scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void parkVehicle(ParkingLot parkingLot, Scanner scanner) {
        System.out.println("\n===== Park a Vehicle =====");
        System.out.print("Enter registration number: ");
        String registrationNumber = scanner.next();
        System.out.print("Enter color: ");
        String color = scanner.next();
        System.out.println("Select vehicle type:");
        for (VehicleType type : VehicleType.values()) {
            System.out.println(type.ordinal() + ". " + type);
        }
        System.out.print("Enter vehicle type number: ");
        int typeIndex = scanner.nextInt();
        VehicleType type = VehicleType.values()[typeIndex];
        Vehicle vehicle = new Vehicle(registrationNumber, color, type);
        int spaceNumber = parkingLot.addVehicle(vehicle);
        if (spaceNumber != -1) {
            System.out.println("Vehicle parked successfully in space number: " + spaceNumber);
        } else {
            System.out.println("No available space for parking.");
        }
    }

    private static void removeVehicle(ParkingLot parkingLot, Scanner scanner) {
        System.out.println("\n===== Remove a Vehicle =====");
        System.out.print("Enter floor number: ");
        int floorNumber = scanner.nextInt();
        System.out.print("Enter space number: ");
        int spaceNumber = scanner.nextInt();
        parkingLot.removeVehicle(floorNumber, spaceNumber);
        System.out.println("Vehicle removed from floor " + floorNumber + ", space " + spaceNumber);
    }

    private static void calculateParkingFee(ParkingLot parkingLot, Scanner scanner) {
        System.out.println("\n===== Calculate Parking Fee =====");
        System.out.print("Enter duration of parking (in hours): ");
        int duration = scanner.nextInt();
        double fee = parkingLot.calculateParkingFee(duration);
        System.out.println("Parking fee: $" + fee);
    }
}
