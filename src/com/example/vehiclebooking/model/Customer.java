package com.example.vehiclebooking.model;

import java.util.List;

public class Customer {

    private int id;
    private String name;
    private VehicleManagement vehicleManagement;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
        @author - Atai
        @date   - 18.03.2021
        @time   - 18:10
     */

    public boolean searchAndBookVehicle(int maxDistance, OperatingEnvironment operatingEnvironment){

        List<Vehicle> resultList = vehicleManagement.findMatchingVehicles(maxDistance, operatingEnvironment);

        if(resultList == null || resultList.isEmpty()) {
            return false;
        }
        else {
            vehicleManagement.bookVehicle(resultList.get(0), this);
            return true;
        }

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setVehicleManagement(VehicleManagement vehicleManagement) {
        this.vehicleManagement = vehicleManagement;
    }
}
