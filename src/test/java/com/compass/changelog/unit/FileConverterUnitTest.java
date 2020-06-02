package com.compass.changelog.unit;

import com.compass.changelog.util.FileConverter;
import org.junit.Test;

public class FileConverterUnitTest {

  @Test(expected = NullPointerException.class)
  public void filename_null() {
    FileConverter.convertToString(null);
  }

  @Test
  public void file_not_found() {
    try {
      FileConverter.convertToString("notExistingFile.txt");
    } catch (Exception ex) {
      assert ex.getMessage().equals("There was an error reading file");
    }
  }

  @Test
  public void success() {
    String expected = "## Test Changelog\n\n"
        + "### This is a title.\n\nThis is a paragraph.\n"
        + "- This is 1st list item.\n- This is 2nd list item.\n";
    String actual = FileConverter.convertToString("TEST.md");

    assert actual.equals(expected);
  }
}
