package com.example.vehiclebooking;

import com.example.vehiclebooking.model.*;
import com.example.vehiclebooking.view.VehicleBookingController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VehicleBookingMainApp extends Application {

    private Stage primaryStage;

    private ObservableList<VehicleBindingAdapter> vehicleData = FXCollections.observableArrayList();
    private VehicleManagement vehicleManagement;
    private Customer customer;

    public VehicleBookingMainApp() {
        this.vehicleManagement = new VehicleManagement();

        this.customer = new Customer(1, "John");

        VehicleBase vehicle1 = new eCar(100, "Tesla");
        VehicleBase vehicle2 = new Boat(150, "Delvi");
        VehicleBase vehicle3 = new Helicopter(200, "Shuza");
        VehicleBase vehicle4 = new Plane(200, "TA");

        VehicleBindingAdapter va1 = new VehicleBindingAdapter(vehicle1.getMaxDistance(), vehicle1.isAvailable(), vehicle1.getName(), vehicle1.getOperatingEnvironment(), vehicle1);
        VehicleBindingAdapter va2 = new VehicleBindingAdapter(vehicle2.getMaxDistance(), vehicle2.isAvailable(), vehicle2.getName(), vehicle2.getOperatingEnvironment(), vehicle2);
        VehicleBindingAdapter va3 = new VehicleBindingAdapter(vehicle3.getMaxDistance(), vehicle3.isAvailable(), vehicle3.getName(), vehicle3.getOperatingEnvironment(), vehicle3);
        VehicleBindingAdapter va4 = new VehicleBindingAdapter(vehicle4.getMaxDistance(), vehicle4.isAvailable(), vehicle4.getName(), vehicle4.getOperatingEnvironment(), vehicle4);

        va1.setVehicleBase(vehicle1);
        va2.setVehicleBase(vehicle2);
        va3.setVehicleBase(vehicle3);
        va4.setVehicleBase(vehicle4);

        vehicle1.setBindingAdapter(va1);
        vehicle2.setBindingAdapter(va2);
        vehicle3.setBindingAdapter(va3);
        vehicle4.setBindingAdapter(va4);

        vehicleManagement.addVehicle(vehicle1);
        vehicleManagement.addVehicle(vehicle2);
        vehicleManagement.addVehicle(vehicle3);
        vehicleManagement.addVehicle(vehicle4);

        customer.setVehicleManagement(vehicleManagement);

        vehicleData.add(va1);
        vehicleData.add(va2);
        vehicleData.add(va3);
        vehicleData.add(va4);

//        vehicle1.setName("BMW");
//
//        va1.setAvailable(false);
//
//        va2.setAvailable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Vehicle Booking App");

        showVehicles();
    }

    public void showVehicles() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(VehicleBookingMainApp.class.getResource("view/BookingOverview.fxml"));
            Parent vehiclesOverview = loader.load();

            Scene scene = new Scene(vehiclesOverview);
            primaryStage.setScene(scene);
            primaryStage.show();

            VehicleBookingController controller = loader.getController();
            controller.setVehicleManagement(this.getVehicleManagement());
            controller.setCustomer(this.getCustomer());

            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<VehicleBindingAdapter> getVehicleData() {
        return vehicleData;
    }

    public VehicleManagement getVehicleManagement() {
        return vehicleManagement;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
