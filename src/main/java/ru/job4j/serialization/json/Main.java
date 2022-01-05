package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Car car = new Car(true, 200, new Number("11-111"), "Man",
                new String[] {"Empty", "Full"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));

        final String carJson =
                "{"
                        + "\"truck\":true,"
                        + "\"power\":250,"
                        + "\"number\":"
                        + "{"
                        + "\"number\":\"M059HR\""
                        + "},"
                        + "\"name\":Reno,"
                        + "\"statuses\":"
                        + "[\"Fast\",\"Slow\"]"
                        + "}";
        final Car carMod = gson.fromJson(carJson, Car.class);
        System.out.println(carMod);
    }
}