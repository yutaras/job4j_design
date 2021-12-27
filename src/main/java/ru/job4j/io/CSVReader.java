package ru.job4j.io;

import java.io.*;

public class CSVReader {
    public static void handle(ArgsName argsName) {
        try (BufferedReader in = new BufferedReader(new FileReader(argsName.get("path")));
             PrintWriter writer = new PrintWriter(new FileOutputStream(argsName.get("out")))) {
            String[] valueOfFilter = argsName.get("filter").split(",");
            String line = in.readLine();
            int[] arrayOfNumber = new int[valueOfFilter.length];
            String[] valueOfColumnName = line.split(";");
            for (int i = 0; i < valueOfFilter.length; i++) {
                for (int j = 0; j < valueOfColumnName.length; j++) {
                    if (valueOfFilter[i].equals(valueOfColumnName[j])) {
                        arrayOfNumber[i] = j;
                    }
                }
            }
            if ("stdout".equals(argsName.get("out"))) {
                for (int i = 0; i < arrayOfNumber.length - 1; i++) {
                    System.out.print(line.split(";")[arrayOfNumber[i]] + ";");
                }
                System.out.println(line.split(";")[arrayOfNumber[arrayOfNumber.length - 1]]);
                while (in.ready()) {
                    String string = in.readLine();
                    for (int i = 0; i < arrayOfNumber.length - 1; i++) {
                        System.out.print(string.split(";")[arrayOfNumber[i]] + ";");
                    }
                    System.out.println(string.split(";")[arrayOfNumber[arrayOfNumber.length - 1]]);
                }
            } else {
                for (int i = 0; i < arrayOfNumber.length - 1; i++) {
                    writer.print(line.split(";")[arrayOfNumber[i]] + ";");
                }
                writer.println(line.split(";")[arrayOfNumber[arrayOfNumber.length - 1]]);
                while (in.ready()) {
                    String string = in.readLine();
                    for (int i = 0; i < arrayOfNumber.length - 1; i++) {
                        writer.print(string.split(";")[arrayOfNumber[i]] + ";");
                    }
                    writer.println(string.split(";")[arrayOfNumber[arrayOfNumber.length - 1]]);
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("Root folder is incorrect");
        }
        ArgsName argsName = ArgsName.of(args);
        File f = new File(argsName.get("path"));
        if (!f.exists() || !f.isFile()) {
            throw new IllegalArgumentException("The argument \"path\"does not exist or is not a directory");
        }
        handle(argsName);
    }
}