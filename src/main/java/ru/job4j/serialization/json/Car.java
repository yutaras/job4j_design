package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
    private final boolean truck;
    private final int power;
    private final Number number;
    private final String name;
    private final String[] statuses;


    public Car(boolean truck, int power, Number number, String name, String[] statuses) {
        this.truck = truck;
        this.power = power;
        this.number = number;
        this.name = name;
        this.statuses = statuses;
    }


    public boolean isTruck() {
        return truck;
    }

    public int isPower() {
        return power;
    }

    public Number isNumber() {
        return number;
    }

    public String isName() {
        return name;
    }


    @Override
    public String toString() {
        return "Car{"
                + "truck=" + truck
                + ", power=" + power
                + ", number=" + number
                + ", name=" + name
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public static void main(String[] args) {

        /* JSONObject из json-строки строки */
        JSONObject jsonNumber = new JSONObject("{\"number\":\"M059РК33\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Empty");
        list.add("Full");
        JSONArray jsonStatuses = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Car car = new Car(true, 500,
                new Number("M059HR33"), "Man", new String[]{"Random", "Custom"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("truck", car.isTruck());
        jsonObject.put("power", car.isPower());
        jsonObject.put("name", car.isName());
        jsonObject.put("number", jsonNumber);
        jsonObject.put("statuses", jsonStatuses);

        /* Выведем результат в консоль */
        System.out.println(jsonObject);

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(car));
    }
}

