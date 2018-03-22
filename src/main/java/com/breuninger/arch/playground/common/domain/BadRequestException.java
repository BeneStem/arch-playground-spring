package com.breuninger.arch.playground.common.domain;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public final class BadRequestException extends RuntimeException {

  private final Errors errors;

  private BadRequestException(final Errors errors) {
    this.errors = errors;
  }

  public static BadRequestException badRequest(final Errors errors) {
    return new BadRequestException(errors);
  }

  public static BadRequestException badRequest(final Object target, final String targetName, final String fieldName,
                                               final String message) {
    final var error = new BeanPropertyBindingResult(target, targetName);
    error.addError(new FieldError(targetName, fieldName, message));
    return badRequest(error);
  }

  public Errors getErrors() {
    return errors;
  }
}
