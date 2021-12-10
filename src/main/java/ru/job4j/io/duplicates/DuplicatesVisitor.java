package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, List<Path>> files = new HashMap<>();
    private List<Path> duplicates = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.toFile().getName());
        if (!files.containsKey(fileProperty)) {
            List<Path> originals = new ArrayList<>();
            originals.add(file);
            files.put(fileProperty, originals);

        } else {
            duplicates = files.get(fileProperty);
            duplicates.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    public void getDuplicates() {
        for (Path subfile : duplicates) {
            System.out.println(subfile);
        }
    }
}