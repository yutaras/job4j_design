package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class CurrentParking implements Parking {
    private int placesPassengerCars;
    private int placesTrucks;
    private List<Vehicles> vehicles = new ArrayList<>();

    public CurrentParking(int placesPassengerCars, int placesTrucks) {
        this.placesPassengerCars = placesPassengerCars;
        this.placesTrucks = placesTrucks;
    }

    @Override

    public boolean add(Vehicles vehicles) {
        return false;
    }

    List<Vehicles> getVehicles() {
        return null;
    }
}
