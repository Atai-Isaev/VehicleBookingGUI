package com.example.vehiclebooking.view;

import com.example.vehiclebooking.VehicleBookingMainApp;
import com.example.vehiclebooking.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

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

    @FXML
    private TextField tfMindestdistanz;

    @FXML
    private RadioButton rbAir;

    @FXML
    private RadioButton rbLand;

    @FXML
    private RadioButton rbWater;

    @FXML
    private ToggleGroup tgFindOperEnv;


    private VehicleBookingMainApp mainApp;
    private VehicleManagement vehicleManagement;
    private Customer customer;

    public VehicleBookingController() {
    }

    @FXML
    private void initialize() {
        rbAir.setUserData(OperatingEnvironment.AIR);
        rbLand.setUserData(OperatingEnvironment.LAND);
        rbWater.setUserData(OperatingEnvironment.WATER);

        maxDistance.setCellValueFactory(cellData -> cellData.getValue().maxDistanceProperty().asObject());
        available.setCellValueFactory(cellData -> cellData.getValue().availableProperty().asObject());
        name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        operatingEnvironment.setCellValueFactory(cellData -> cellData.getValue().operatingEnvironmentProperty());

    }

    public void setMainApp(VehicleBookingMainApp mainApp) {
        this.mainApp = mainApp;

        vehicleTable.setItems(mainApp.getVehicleData());
    }

    public void setVehicleManagement(VehicleManagement vehicleManagement) {
        this.vehicleManagement = vehicleManagement;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @FXML
    private void handleBookVehicleButton() {
        VehicleBindingAdapter selectedVehicle = vehicleTable.getSelectionModel().selectedItemProperty().getValue();

        if (selectedVehicle != null) {
            if (selectedVehicle.isAvailable()) {
                this.vehicleManagement.bookVehicle(selectedVehicle.getVehicleBase(), this.customer);
            } else {
                createAlert("Not available",
                        "Selected Vehicle is not available",
                        "Please select available vehicle in the table.",
                        Alert.AlertType.WARNING);
            }
        } else {
            createAlert("No Selection",
                    "No Vehicle Selected",
                    "Please select vehicle in the table.",
                    Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void handleSearchVehicleButton() {
        if (tfMindestdistanz.getText().equals("")) {
            createAlert("No Value",
                    "No Mindestdistanz Value",
                    "Please type a mindestdistanz value.",
                    Alert.AlertType.WARNING);
        } else {
            try {

                int mindestDistanz = Integer.parseInt(tfMindestdistanz.getText());
                RadioButton selectedOperEnv = (RadioButton) tgFindOperEnv.getSelectedToggle();

                if (selectedOperEnv == null) {
                    createAlert("No Selection",
                            "No Operating Environment Selected",
                            "Please select operating environment.",
                            Alert.AlertType.WARNING);
                } else {
                    selectedOperEnv.getUserData();
                    List<Vehicle> searchResult = this.vehicleManagement.findMatchingVehicles(mindestDistanz, (OperatingEnvironment) selectedOperEnv.getUserData());

                    ObservableList<VehicleBindingAdapter> observableList = FXCollections.observableArrayList();

                    if (searchResult!=null){
                        for (Vehicle vehicle :
                                searchResult) {
                            observableList.add(vehicle.getVehicleBindingAdapter());
                        }
                    }
                    this.vehicleTable.setItems(observableList);
                }
            } catch (NumberFormatException e) {
                createAlert("Number format",
                        "Number format is not integer",
                        "Please type an integer value",
                        Alert.AlertType.WARNING);
            }
        }
    }

    @FXML
    private void handleShowAllVehiclesButton(){
        this.vehicleTable.setItems(this.mainApp.getVehicleData());
    }

    private void createAlert(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
