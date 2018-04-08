package com.breuninger.arch.playground.common.domain;

import static lombok.AccessLevel.PRIVATE;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = PRIVATE)
@Getter
public final class BadRequestException extends RuntimeException {

  private final Errors errors;

  public static BadRequestException badRequest(final Errors errors) {
    return new BadRequestException(errors);
  }

  public static BadRequestException badRequest(final Object target, final String targetName, final String fieldName,
                                               final String message) {
    final var error = new BeanPropertyBindingResult(target, targetName);
    error.addError(new FieldError(targetName, fieldName, message));
    return badRequest(error);
  }
}
