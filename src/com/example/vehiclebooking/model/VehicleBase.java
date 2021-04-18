package com.example.vehiclebooking.model;

public abstract class VehicleBase implements Vehicle {
    private int maxDistance;
    private boolean available;
    private String name;
    private OperatingEnvironment operatingEnvironment;
    private VehicleBindingAdapter vehicleBindingAdapter;

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
        @date   - 17.04.2021
        @time   - 22:35
     */

    public void setBindingAdapter(VehicleBindingAdapter vehicleBindingAdapter) {
        this.vehicleBindingAdapter = vehicleBindingAdapter;
    }

    public VehicleBindingAdapter getVehicleBindingAdapter() {
        return vehicleBindingAdapter;
    }

    /*
        @author - Atai
        @date   - 17.04.2021
        @time   - 22:35
     */

    public void notifyBindingAdapter(){
        this.vehicleBindingAdapter.setVehicleBase(this);
    }

    public void book(){
        this.available = false;
        notifyBindingAdapter();
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        if (this.maxDistance!=maxDistance){
            this.maxDistance = maxDistance;
            notifyBindingAdapter();
        }
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        if (this.available!=available){
            this.available = available;
            notifyBindingAdapter();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!this.name.equals(name)){
            this.name = name;
            notifyBindingAdapter();
        }
    }

    public OperatingEnvironment getOperatingEnvironment() {
        return operatingEnvironment;
    }

    public void setOperatingEnvironment(OperatingEnvironment operatingEnvironment) {
        this.operatingEnvironment = operatingEnvironment;
    }
}
