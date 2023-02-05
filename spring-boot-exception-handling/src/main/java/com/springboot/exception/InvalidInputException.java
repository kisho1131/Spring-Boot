package com.springboot.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvalidInputException extends RuntimeException {
  public InvalidInputException(String errorMessage){
    super(errorMessage);
    log.error("Invalid Request Input Provided !!");
  }
}
