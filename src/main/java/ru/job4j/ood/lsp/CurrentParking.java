package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class CurrentParking implements Parking {
    private int placesPassengerCars;
    private int placesTrucks;
    private List<Vehicles> vehiclesList = new ArrayList<>();

    public CurrentParking(int placesPassengerCars, int placesTrucks) {
        this.placesPassengerCars = placesPassengerCars;
        this.placesTrucks = placesTrucks;
    }

    @Override

    public boolean add(Vehicles vehicle) {
        boolean rsl = false;
        if (vehicle.getSize() == PassengerCar.SIZE && placesPassengerCars >= 1) {
            vehiclesList.add(vehicle);
            placesPassengerCars--;
            rsl = true;
        } else if (vehicle.getSize() > PassengerCar.SIZE && placesTrucks >= 1) {
            vehiclesList.add(vehicle);
            placesTrucks--;
            rsl = true;
        } else if (vehicle.getSize() > PassengerCar.SIZE
                && placesPassengerCars >= vehicle.getSize()) {
            vehiclesList.add(vehicle);
            placesPassengerCars -= vehicle.getSize();
            rsl = true;
        }
        return rsl;
    }

    List<Vehicles> getVehicles() {
        return List.copyOf(vehiclesList);
    }
}
