package com.example.vehiclebooking.model;

import javafx.beans.property.*;

public class VehicleBindingAdapter {
    private IntegerProperty maxDistance;
    private BooleanProperty available;
    private StringProperty name;
    private ObjectProperty<OperatingEnvironment> operatingEnvironment;
    private VehicleBase vehicleBase;

    public VehicleBindingAdapter() {
        this(0, false,null,null,null);
    }

    public VehicleBindingAdapter(int maxDistance, boolean available, String name, OperatingEnvironment operatingEnvironment, VehicleBase vehicleBase) {
        this.maxDistance = new SimpleIntegerProperty(maxDistance);
        this.available = new SimpleBooleanProperty(available);
        this.name = new SimpleStringProperty(name);
        this.operatingEnvironment = new SimpleObjectProperty<>(operatingEnvironment);
        this.vehicleBase = vehicleBase;
    }

    public int getMaxDistance() {
        return maxDistance.get();
    }

    public IntegerProperty maxDistanceProperty() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        if (this.maxDistance.get()!=maxDistance) {
            this.maxDistance.set(maxDistance);
            this.vehicleBase.setMaxDistance(maxDistance);
        }
    }

    public boolean isAvailable() {
        return available.get();
    }

    public BooleanProperty availableProperty() {
        return available;
    }

    public void setAvailable(boolean available) {
        if (this.available.get()!=available){
            this.available.set(available);
            this.vehicleBase.setAvailable(available);
        }
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        if (!this.name.get().equals(name)) {
            this.name.set(name);
            this.vehicleBase.setName(name);
        }
    }

    public OperatingEnvironment getOperatingEnvironment() {
        return operatingEnvironment.get();
    }

    public ObjectProperty<OperatingEnvironment> operatingEnvironmentProperty() {
        return operatingEnvironment;
    }

    public void setOperatingEnvironment(OperatingEnvironment operatingEnvironment) {
        if (!this.operatingEnvironment.get().equals(operatingEnvironment)) {
            this.operatingEnvironment.set(operatingEnvironment);
            this.vehicleBase.setOperatingEnvironment(operatingEnvironment);
        }

    }

    public VehicleBase getVehicleBase() {
        return vehicleBase;
    }

    public void setVehicleBase(VehicleBase vehicleBase) {
        if (this.getMaxDistance()!=(vehicleBase.getMaxDistance())){
            this.maxDistance = new SimpleIntegerProperty(vehicleBase.getMaxDistance());
        }
        if (this.isAvailable()!=(vehicleBase.isAvailable())){
            this.available.setValue(vehicleBase.isAvailable());
        }
        if (!this.getName().equals(vehicleBase.getName())){
            this.name = new SimpleStringProperty(vehicleBase.getName());
        }
        if (!this.getOperatingEnvironment().equals(vehicleBase.getOperatingEnvironment())){
            this.operatingEnvironment = new SimpleObjectProperty<>(vehicleBase.getOperatingEnvironment());
        }

        this.vehicleBase = vehicleBase;
    }
}
