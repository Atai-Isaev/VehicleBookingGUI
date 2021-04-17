package com.example.vehiclebooking.model;

public abstract class WaterVehicle extends VehicleBase {

    public WaterVehicle(int maxDistance, String name) {
        super(maxDistance, name, OperatingEnvironment.WATER);
    }
}
