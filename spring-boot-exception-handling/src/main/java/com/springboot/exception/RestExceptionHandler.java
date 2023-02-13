package com.springboot.exception;

import com.springboot.exception.model.ApiError;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

  public static final String PRINT_EXCEPTION_MESSAGE = "{} - Exception : {}";

  private void logError(StackTraceElement[] trace, String errorMessage){
    RestExceptionHandler.log.error(PRINT_EXCEPTION_MESSAGE, trace[0].getClass() + "." + trace[0].getClassName(), errorMessage);
  }

  @ExceptionHandler(InvalidInputException.class)
  public ResponseEntity<Object> handleInvalidRequestInput(InvalidInputException ex){
    logError(ex.getStackTrace(), ex.getMessage());
    return new ResponseEntity<>(ApiError.builder()
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.BAD_REQUEST)
            .message(ex.getMessage())
            .subErrors(Collections.singletonList(ex.getMessage()))
            .build(),
            HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<Object> handleConstrain(ConstraintViolationException ex){
    logError(ex.getStackTrace(), ex.getMessage());
    return new ResponseEntity<>(ApiError.builder()
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.BAD_REQUEST)
            .message(ex.getMessage())
            .subErrors(Collections.singletonList(ex.getMessage()))
            .build(),
            HttpStatus.BAD_REQUEST);
  }
  @Override
  public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
    List<String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .toList();
    logError(ex.getStackTrace(), ex.getMessage());
    return new ResponseEntity<>(ApiError.builder()
            .status(HttpStatus.BAD_REQUEST)
            .timestamp(LocalDateTime.now())
            .message("Invalid Request Body :(( ")
            .subErrors(errors)
            .build(),
            HttpStatus.BAD_REQUEST);
  }

 /* @ExceptionHandler(CustomFeignException.class)
  public ResponseEntity<Object> handleCustomFeignException(CustomFeignException ex){
    logError(ex.getStackTrace(), ex.getMessage());
    return new ResponseEntity<>(ApiError.builder()
            .status(HttpStatus.BAD_REQUEST)
            .message(ex.getMessage())
            .timestamp(LocalDateTime.now())
            .subErrors(Collections.singletonList(ex.getMessage()))
            .build(), HttpStatus.BAD_REQUEST);
  }*/
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(CustomFeignException.class)
  public void handleCustomFeignException(CustomFeignException ex){
    logError(ex.getStackTrace(), ex.getMessage());
    System.out.println("<<<<<<<<<<<<<<< Log Exception >>>>>>>>>>>>>>");
    System.out.println(ex.getMessage());
    System.out.println("<<<<<<<<<<<<<<< Log Exception >>>>>>>>>>>>>>");
  }
}