package com.compass.changelog.util;

import com.compass.changelog.exception.InvalidFileException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.InvalidPathException;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

public class FileConverter {

  public static String convertToString(String fileName) {
    if (fileName == null) {
      throw new NullPointerException("Filename");
    }

    String markdown;
    try {
      markdown = IOUtils
          .toString(new ClassPathResource(fileName).getInputStream(), Charset.defaultCharset());
    } catch (IOException | InvalidPathException ex) {
      throw new InvalidFileException();
    }

    return markdown;
  }
}
