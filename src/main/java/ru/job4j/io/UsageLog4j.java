package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        char gender = 'm';
        boolean active = true;
        byte value = 121;
        short category = 2;
        long num = 2147483649L;
        float fl = 30.6f;
        double db = 30.6;

        LOG.debug("User info name : {}, age : {}, gender: {}, isActive: {}, value: {}, category: {}, num: {},fl: {}, db: {}",
                name, age, gender, active, value, category, num, fl, db);
    }
}
