package com.breuninger.arch.playground.common.domain;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class ValidationError {

  private final String fieldName;
  private final String errorMessage;
}
