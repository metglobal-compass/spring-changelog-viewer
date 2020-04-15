package com.compass.changelog.unit;

import com.compass.changelog.service.ChangelogService;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import org.junit.Test;

// TODO: Add integration test
public class ServiceUnitTest {

  @Test
  public void success() throws Exception {
    ChangelogService service = new ChangelogService();

    String expected = Files.lines(Paths.get("test_files/test.html")).collect(Collectors.joining("\n"));
    String actual = service.handle("test_files/TEST.md");

    assert actual.equals(expected + "\n");
  }
}
