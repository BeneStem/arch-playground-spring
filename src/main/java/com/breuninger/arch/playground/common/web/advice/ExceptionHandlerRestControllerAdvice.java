package com.breuninger.arch.playground.common.web.advice;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.breuninger.arch.playground.common.domain.BadRequestException;
import com.breuninger.arch.playground.common.domain.ValidationError;

@ControllerAdvice
public class ExceptionHandlerRestControllerAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<List<ValidationError>> handleBadRequest(final BadRequestException exception) {
    return ResponseEntity.badRequest()
      .body(exception.getErrors()
        .getFieldErrors()
        .stream()
        .map(fieldError -> new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()))
        .collect(toList()));
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException exception,
                                                                final HttpHeaders headers, final HttpStatus status,
                                                                final WebRequest request) {
    return ResponseEntity.badRequest()
      .body(exception.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(fieldError -> new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()))
        .collect(toList()));
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<List<ValidationError>> handleConstraintViolation(final ConstraintViolationException exception) {
    return ResponseEntity.badRequest()
      .body(exception.getConstraintViolations()
        .stream()
        .map(
          constraintViolation -> new ValidationError(((PathImpl) constraintViolation.getPropertyPath()).getLeafNode().getName(),
            constraintViolation.getMessage()))
        .collect(toList()));
  }
}
