package com.compass.changelog.util;

import com.compass.changelog.exception.InvalidFileException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileConverter {

  public static String convertToString(String fileName) {
    if (fileName == null) {
      throw new NullPointerException("Filename");
    }

    String markdown;
    try {
      markdown = Files.lines(Paths.get(fileName)).collect(Collectors.joining("\n"));
    } catch (IOException | InvalidPathException ex) {
      throw new InvalidFileException();
    }

    return markdown;
  }
}
