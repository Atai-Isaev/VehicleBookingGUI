package com.example.vehiclebooking.model;

public abstract class AirVehicle extends VehicleBase {
    public AirVehicle(int maxDistance, String name) {
        super(maxDistance, name, OperatingEnvironment.AIR);
    }
}
