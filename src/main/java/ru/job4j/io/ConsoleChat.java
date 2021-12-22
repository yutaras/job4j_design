package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    List<String> listOfPhrases = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> log = new ArrayList<>();
            boolean flag = true;
            String line = null;
            Random rand = new Random();
            while (!(OUT).equals(line)) {
                line = reader.readLine();
                log.add(line);
                if ((STOP).equals(line)) {
                    flag = false;
                }
                if ((CONTINUE).equals(line)) {
                    flag = true;
                }
                if (flag) {
                    String randomAnswerBot = readPhrases().get(rand.nextInt(readPhrases().size()));
                    System.out.println(randomAnswerBot);
                    log.add(randomAnswerBot);
                }
            }
            saveLog(log);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<String> readPhrases() {
        try (BufferedReader in = new BufferedReader(new FileReader(this.botAnswers))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                listOfPhrases.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfPhrases;
    }

    private void saveLog(List<String> log) {
        if (!log.isEmpty()) {
            try (PrintWriter out = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
                log.forEach(out::println);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("C:\\projects\\job4j_design\\data\\log.txt", "C:\\projects\\job4j_design\\data\\botAnswers.txt");
        cc.run();
    }
}
