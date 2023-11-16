package org.example;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintDirectoryStructure {
    public static void main(String[] args) throws IOException {
        Path directory = Paths.get("C:\\git\\JavaPackagerDemo"); // 替换为你的项目目录路径

        if (!Files.isDirectory(directory)) {
            System.out.println("指定路径不是一个目录");
            return;
        }

        printDirectoryStructure(directory, "");
    }

    private static void printDirectoryStructure(Path directory, String indent) throws IOException {
        System.out.println(indent + "- " + directory.getFileName());

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {
                    printDirectoryStructure(path, indent + "  ");
                } else {
                    System.out.println(indent + "  - " + path.getFileName());
                }
            }
        }
    }
}
