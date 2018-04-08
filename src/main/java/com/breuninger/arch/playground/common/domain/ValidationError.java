package com.breuninger.arch.playground.common.domain;

import lombok.Builder;
import lombok.Value;

// TODO make this error prettier use edison-validation domain object
@Builder(toBuilder = true)
@Value
public class ValidationError {

  private final String fieldName;
  private final String errorMessage;
}
