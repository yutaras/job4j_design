package ru.job4j.ood.lsp;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CurrentParkingTest {

    @Ignore
    @Test
    public void whenAddTwoCarsOneTruckTrue() {
        Parking currentParking = new CurrentParking(2, 1);
        Vehicles passengerCar1 = new PassengerCar();
        Vehicles passengerCar2 = new PassengerCar();
        Vehicles truck = new Truck(2);
        assertTrue(currentParking.add(passengerCar1));
        assertTrue(currentParking.add(passengerCar2));
        assertTrue(currentParking.add(truck));
    }

    @Ignore
    @Test
    public void whenAddOnlyCarsTrue() {
        Parking currentParking = new CurrentParking(3, 0);
        Vehicles passengerCar1 = new PassengerCar();
        Vehicles passengerCar2 = new PassengerCar();
        Vehicles passengerCar3 = new PassengerCar();
        assertTrue(currentParking.add(passengerCar1));
        assertTrue(currentParking.add(passengerCar2));
        assertTrue(currentParking.add(passengerCar3));
    }

    @Ignore
    @Test
    public void whenTwoTrucksTrue() {
        Parking currentParking = new CurrentParking(4, 1);
        Vehicles truck1 = new Truck(2);
        Vehicles truck2 = new Truck(4);
        assertTrue(currentParking.add(truck1));
        assertTrue(currentParking.add(truck2));
    }

    @Ignore
    @Test
    public void whenAddTruckFalse() {
        Parking currentParking = new CurrentParking(1, 1);
        Vehicles passengerCar1 = new PassengerCar();
        Vehicles truck1 = new Truck(2);
        Vehicles truck2 = new Truck(3);
        currentParking.add(passengerCar1);
        currentParking.add(truck1);
        assertFalse(currentParking.add(truck2));
    }

    @Ignore
    @Test
    public void whenAddCarsFalse() {
        Parking currentParking = new CurrentParking(1, 1);
        Vehicles car1 = new PassengerCar();
        Vehicles car2 = new PassengerCar();
        Vehicles truck1 = new Truck(2);
        currentParking.add(car1);
        currentParking.add(truck1);
        assertFalse(currentParking.add(car2));
    }

}