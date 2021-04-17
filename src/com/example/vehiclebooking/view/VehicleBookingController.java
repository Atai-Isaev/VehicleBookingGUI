package com.example.vehiclebooking.view;

import com.example.vehiclebooking.VehicleBookingMainApp;
import com.example.vehiclebooking.model.OperatingEnvironment;
import com.example.vehiclebooking.model.VehicleBindingAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class VehicleBookingController {
    @FXML
    private TableView<VehicleBindingAdapter> vehicleTable;

    @FXML
    private TableColumn<VehicleBindingAdapter, Integer> maxDistance;

    @FXML
    private TableColumn<VehicleBindingAdapter, Boolean> available;

    @FXML
    private TableColumn<VehicleBindingAdapter, String> name;

    @FXML
    private TableColumn<VehicleBindingAdapter, OperatingEnvironment> operatingEnvironment;

    private VehicleBookingMainApp mainApp;

    public VehicleBookingController() {
    }

    @FXML
    private void initialize() {

        maxDistance.setCellValueFactory(cellData -> cellData.getValue().maxDistanceProperty().asObject());
        available.setCellValueFactory(cellData -> cellData.getValue().availableProperty().asObject());
        name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        operatingEnvironment.setCellValueFactory(cellData -> cellData.getValue().operatingEnvironmentProperty());

    }

    public void setMainApp(VehicleBookingMainApp mainApp) {
        this.mainApp = mainApp;

        vehicleTable.setItems(mainApp.getVehicleData());
    }
}
