package com.example.vehiclebooking.model;

public abstract class LandVehicle extends VehicleBase {

    public LandVehicle(int maxDistance, String name) {
        super(maxDistance, name, OperatingEnvironment.LAND);
    }
}
