package ru.job4j.ood.lsp;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CurrentParkingTest {

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

    @Test
    public void whenAddOnlyCarsFalse() {
        Parking currentParking = new CurrentParking(2, 1);
        Vehicles passengerCar1 = new PassengerCar();
        Vehicles passengerCar2 = new PassengerCar();
        Vehicles passengerCar3 = new PassengerCar();
        assertTrue(currentParking.add(passengerCar1));
        assertTrue(currentParking.add(passengerCar2));
        assertFalse(currentParking.add(passengerCar3));
    }

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

    @Test(expected = Exception.class)
    public void whenSizeTruckLess2() {
        Parking currentParking = new CurrentParking(1, 1);
        Vehicles truck1 = new Truck(1);
        currentParking.add(truck1);
    }

    @Test
    public void whenGeneralFalse() {
        Parking currentParking = new CurrentParking(4, 1);
        Vehicles truck1 = new Truck(2);
        Vehicles truck2 = new Truck(4);
        Vehicles truck3 = new Truck(2);
        Vehicles passengerCar = new PassengerCar();
        assertTrue(currentParking.add(truck1));
        assertTrue(currentParking.add(truck2));
        assertFalse(currentParking.add(truck3));
        assertFalse(currentParking.add(passengerCar));
    }
}