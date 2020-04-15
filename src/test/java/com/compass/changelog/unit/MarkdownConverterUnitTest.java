package com.compass.changelog.unit;

import com.compass.changelog.util.MarkdownConverter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import org.junit.Test;

public class MarkdownConverterUnitTest {

  @Test
  public void success() throws Exception {
    String expected = Files.lines(Paths.get("test_files/test.html")).collect(Collectors.joining("\n"));
    String actual = MarkdownConverter.convertToHTML(
        "## Test Changelog\n\n"
            + "### This is a title.\n\nThis is a paragraph.\n"
            + "- This is 1st list item.\n- This is 2nd list item."
    );

    assert actual.equals(expected + "\n");
  }
}
