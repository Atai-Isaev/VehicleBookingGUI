package com.example.vehiclebooking.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleManagement {

    //List of all vehicles in system
    private List<Vehicle> vehicleList;

    // @Integer = id of customer
    // @List<Vehicle>   = all customers booked vehicles
    private Map<Integer, List<Vehicle>> bookedVehicles;


    public VehicleManagement() {
        vehicleList = new ArrayList<>();
        bookedVehicles = new HashMap<>();
    }

    /*
        @author - Atai
        @date   - 18.03.2021
        @time   - 18:05
     */

    void addVehicle(Vehicle vehicle) {
        if (vehicle != null) {
            vehicleList.add(vehicle);
            System.out.println("Vehicle: " + vehicle.getName() + " added to vehicle List!");
        } else System.out.println("Object Vehicle is null!");
    }

    /*
        @author - Atai
        @date   - 18.03.2021
        @time   - 18:06
        @return - a filtered List of vehicles
     */

    public List<Vehicle> findMatchingVehicles(int maxDistance, OperatingEnvironment operatingEnvironment) {

        List<Vehicle> resultList = new ArrayList<>();

        if (vehicleList.isEmpty()) {
            System.out.println("VehicleManagement have 0 vehicles\n");
            return null;
        } else {
            for (Vehicle currentVehicle : vehicleList) {
                if (currentVehicle.isAvailable() && currentVehicle.canOperateOn(operatingEnvironment)
                        && currentVehicle.getMaxDistance() == maxDistance) resultList.add(currentVehicle);

            }

            if (resultList.isEmpty()) {
                System.out.println("Based on your search 'maxDistance': "
                        + maxDistance + " and 'operatingEnvironment':" + operatingEnvironment.name() + " 0 Vehicle(s) were found\n");
                return null;
            } else {
                System.out.println("Based on your search 'maxDistance': "
                        + maxDistance + " and 'operatingEnvironment':" + operatingEnvironment.name() + " " + resultList.size() + " Vehicle(s) were found\n");
                for (Vehicle vehicle : resultList) {

                    System.out.println("    Vehicle: " + vehicle.getName() + ", max distance: " + vehicle.getMaxDistance()
                            + ", operating environment: " + vehicle.getOperatingEnvironment());
                }
                System.out.println();
                return resultList;
            }


        }
    }

    /*
        Book a specific vehicle
        it is important
        if(bookedVehicles.List<Vehicle>.size!=0 or bookedVehicles.List<Vehicle>.size>0)

        @author - Atai
        @date   - 18.03.2021
        @time   - 18:07
     */

    public boolean bookVehicle(Vehicle vehicle, Customer customer) {


        if (vehicle == null || customer == null || !vehicle.isAvailable()) return false;

        int id = customer.getId();

        if (bookedVehicles.containsKey(id)) {

            List<Vehicle> customersBookedVehicles = bookedVehicles.get(id);

            if (customersBookedVehicles.isEmpty()) {
                vehicle.book();
                List<Vehicle> newList = new ArrayList<>();
                newList.add(vehicle);
                bookedVehicles.put(id, newList);
                System.out.println("        You have booked a car: " + vehicle.getName()
                        + ", maxDistance = " + vehicle.getMaxDistance() + ", operatingEnvironment = " + vehicle.getOperatingEnvironment() + "\n");
                return true;
            } else {
                vehicle.book();
                customersBookedVehicles.add(vehicle);
                bookedVehicles.put(id, customersBookedVehicles);
                System.out.println("        You have booked a car: " + vehicle.getName()
                        + ", maxDistance = " + vehicle.getMaxDistance() + ", operatingEnvironment = " + vehicle.getOperatingEnvironment() + "\n");
                return true;
            }

        } else {
            vehicle.book();
            List<Vehicle> newList = new ArrayList<>();
            newList.add(vehicle);
            bookedVehicles.put(id, newList);
            System.out.println("        You have booked a car: " + vehicle.getName()
                    + ", maxDistance = " + vehicle.getMaxDistance() + ", operatingEnvironment = " + vehicle.getOperatingEnvironment() + "\n");
            return true;
        }

    }

    /*
        @author - Atai
        @date   - 18.03.2021
        @time   - 18:08
     */

    public void showBookedVehicles() {
        if (bookedVehicles.isEmpty()) System.out.println("There are no booked vehicles\n");
        else {
            System.out.println("A list of all booked vehicles");
            bookedVehicles.forEach((customerId, vehicleList) ->
                    vehicleList.forEach(vehicle ->
                            System.out.println("    Customer id: "
                                    + customerId + ", Vehicle: " + vehicle.getName() + ", operating environment: "
                                    + vehicle.getOperatingEnvironment() + ", max distance: " + vehicle.getMaxDistance())));
            System.out.println();
        }
    }
}
