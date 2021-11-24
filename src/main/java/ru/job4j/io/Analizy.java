package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
            byte serverDown = 0;
            while (in.ready()) {
                String line = in.readLine();
                if (serverDown == 0 && (line.startsWith("400") || line.startsWith("500"))) {
                    writer.print(line.split(" ")[1] + ";");
                    serverDown = 1;
                } else if (serverDown == 1 && (!line.startsWith("400") && !line.startsWith("500"))) {
                    writer.println(line.split(" ")[1] + ";");
                    serverDown = 0;
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String source = "./data/source.txt";
        String target = "./data/target.txt";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
    }
}