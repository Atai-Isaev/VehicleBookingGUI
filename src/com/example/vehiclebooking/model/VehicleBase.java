package com.example.vehiclebooking.model;

public abstract class VehicleBase implements Vehicle {
    private int maxDistance;
    private boolean available;
    private String name;
    private OperatingEnvironment operatingEnvironment;

    public VehicleBase(int maxDistance, String name, OperatingEnvironment operatingEnvironment) {
        super();
        this.maxDistance = maxDistance;
        this.name = name;
        this.operatingEnvironment = operatingEnvironment;
        this.available = true;
    }


    /*
        @author - Atai
        @date   - 18.03.2021
        @time   - 17:47
     */
    public boolean canOperateOn(OperatingEnvironment operatingEnvironment){
        return this.operatingEnvironment.equals(operatingEnvironment);
    }

    /*
        @author - Atai
        @date   - 18.03.2021
        @time   - 17:50
     */

    public void book(){
        this.available = false;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OperatingEnvironment getOperatingEnvironment() {
        return operatingEnvironment;
    }

    public void setOperatingEnvironment(OperatingEnvironment operatingEnvironment) {
        this.operatingEnvironment = operatingEnvironment;
    }
}
