package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (values.get(key) == null) {
            throw new IllegalArgumentException("данного ключа не существует");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("параметры не введены");
        }
        for (String arg : args) {
            if (!arg.startsWith("-") || (!arg.contains("="))) {
                throw new IllegalArgumentException("Параметры не соотвествуют шаблону -key=value");
            }

            String[] split = arg.replaceFirst("-", "").split("=");
            if (split.length != 2) {
                throw new IllegalArgumentException("Не введен один из параметров");
            }
            values.put(split[0], split[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("encoding"));
    }
}
