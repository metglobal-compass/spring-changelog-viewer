package com.compass.changelog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidFileException extends RuntimeException {
  public InvalidFileException() {
    super("There was an error reading file");
  }
}
