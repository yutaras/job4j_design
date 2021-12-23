package ru.job4j.io;

import java.io.*;
import java.util.Scanner;

public class CSVReader {
    public static void handle(ArgsName argsName) {
        try (BufferedReader in = new BufferedReader(new FileReader(argsName.get("path")));
             PrintWriter writer = new PrintWriter(new FileOutputStream(argsName.get("out")))) {
            while (in.ready()) {
                String line = in.readLine();
                var scanner = new Scanner(new ByteArrayInputStream(line.getBytes()))
                        .useDelimiter(";");
                while (scanner.hasNext()) {
                    writer.print(scanner.next());
                    writer.print(";");
                    writer.println(scanner.next());
                    scanner.next();
                    scanner.next();
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
        handle(argsName);
    }
}