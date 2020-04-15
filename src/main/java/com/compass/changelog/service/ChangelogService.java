package com.compass.changelog.service;

import com.compass.changelog.util.FileConverter;
import com.compass.changelog.util.MarkdownConverter;
import org.springframework.stereotype.Service;

@Service
public class ChangelogService {

  public String handle(String fileName) {
    String markdown = FileConverter.convertToString(fileName);

    return MarkdownConverter.convertToHTML(markdown);
  }
}
