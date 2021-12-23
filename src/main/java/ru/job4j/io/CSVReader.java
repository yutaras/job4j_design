package ru.job4j.io;

import java.io.*;

public class CSVReader {
    public static void handle(ArgsName argsName) {
        try (BufferedReader in = new BufferedReader(new FileReader(argsName.get("path")));
             PrintWriter writer = new PrintWriter(new FileOutputStream(argsName.get("out")))) {
            while (in.ready()) {
                String line = in.readLine();
                writer.println(line.split(";")[0] + ";" + line.split(";")[1]);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        File file = new File("./data/source.csv");
        File target = new File("./data/target.csv");
        ArgsName argsName = ArgsName.of(new String[]{
                "-path=" + file.getAbsolutePath(), "-delimiter=;", "-out=" + target.getAbsolutePath(), "-filter=name,age"
        });
        handle(argsName);
    }
}