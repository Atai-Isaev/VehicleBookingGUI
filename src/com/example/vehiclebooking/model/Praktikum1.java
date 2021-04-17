package com.example.vehiclebooking.model;

public class Praktikum1 {
    public static void main(String[] args) {

        VehicleManagement vehicleManagement = new VehicleManagement();

        Customer customer1 = new Customer(1, "John");
        Customer customer2 = new Customer(2, "Alex");
        Customer customer3 = new Customer(3, "Anna");

        Vehicle vehicle1 = new eCar(100, "Tesla");
        Vehicle vehicle2 = new Boat(150, "Delvi");
        Vehicle vehicle3 = new Helicopter(200, "Shuza");
        Vehicle vehicle4 = new Plane(200, "TA");


        vehicleManagement.addVehicle(vehicle1);
        vehicleManagement.addVehicle(vehicle2);
        vehicleManagement.addVehicle(vehicle3);
        vehicleManagement.addVehicle(vehicle4);

        System.out.println();

        customer1.setVehicleManagement(vehicleManagement);
        customer2.setVehicleManagement(vehicleManagement);
        customer3.setVehicleManagement(vehicleManagement);

        vehicleManagement.showBookedVehicles();

        customer1.searchAndBookVehicle(100, OperatingEnvironment.WATER);

        customer1.searchAndBookVehicle(150, OperatingEnvironment.WATER);

        customer1.searchAndBookVehicle(200, OperatingEnvironment.AIR);

        vehicleManagement.showBookedVehicles();

        System.out.println("\nTesting Vehicle interface methods:");

        System.out.println("    isAvailable: " + vehicle1.isAvailable());
        System.out.println("    getMaxDistance: " + vehicle1.getMaxDistance());
        System.out.println("    getOperatingEnvironment: " + vehicle1.getOperatingEnvironment());
        System.out.println("    getName: " + vehicle1.getName());

        vehicle1.book();
        System.out.println("    after book (isAvailable): " + vehicle1.isAvailable());

        System.out.println("    canOperateOn AIR: " + vehicle1.canOperateOn(OperatingEnvironment.AIR));
        System.out.println("    canOperateOn WATER: " + vehicle1.canOperateOn(OperatingEnvironment.WATER));
        System.out.println("    canOperateOn LAND: " + vehicle1.canOperateOn(OperatingEnvironment.LAND));
    }
}
