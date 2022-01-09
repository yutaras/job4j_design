package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class SearchByCriterion {
    public static void validation(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        if (args.length != 4) {
            throw new IllegalArgumentException("Root folder is incorrect");
        }
        Path start = Paths.get(argsName.get("d"));
        if (!Files.exists(start) || !Files.isDirectory(start)) {
            throw new IllegalArgumentException("The argument does not exist or is not a directory");
        }
    }

    public static void handle(ArgsName argsName) throws IOException {
        List<Path> listPath = new ArrayList<>();
        String typeOfSearch = argsName.get("t");
        if ("mask".equals(typeOfSearch)) {
            listPath = search(Paths.get(argsName.get("d")), p -> p.toFile().getName()
                    .endsWith(argsName.get("n").replace("*", "")));
        }
        if ("name".equals(typeOfSearch)) {
            listPath = search(Paths.get(argsName.get("d")), p -> p.toFile().getName()
                    .equals(argsName.get("n")));
        }
        if ("regex".equals(typeOfSearch)) {
            Pattern pattern = Pattern.compile((argsName.get("n")));
            listPath = search(Paths.get(argsName.get("d")), p -> pattern.matcher(p.toFile().getName()).find());

        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(argsName.get("o"), true))) {
            listPath.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        validation(args);
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
