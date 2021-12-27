package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static void handle(ArgsName argsName) {
        List<String> log = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(argsName.get("path")))) {
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
            for (int i = 0; i < arrayOfNumber.length - 1; i++) {
                log.add(line.split(";")[arrayOfNumber[i]] + ";");
            }
            log.add(line.split(";")[arrayOfNumber[arrayOfNumber.length - 1]] + System.lineSeparator());
            while (in.ready()) {
                String string = in.readLine();
                for (int i = 0; i < arrayOfNumber.length - 1; i++) {
                    log.add(string.split(";")[arrayOfNumber[i]] + ";");
                }
                log.add(string.split(";")[arrayOfNumber[arrayOfNumber.length - 1]] + System.lineSeparator());
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        CSVReader csvReader = new CSVReader();
        csvReader.writeOut(argsName, log);
    }

    public void writeOut(ArgsName argsName, List<String> log) {
        if ("stdout".equals(argsName.get("out"))) {
            for (String line : log) {
                System.out.print(line);
            }
        } else {
            try (PrintWriter pw = new PrintWriter(new FileWriter(argsName.get("out"), true))) {
                log.forEach(pw::print);
            } catch (IOException e) {
                e.printStackTrace();
            }
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