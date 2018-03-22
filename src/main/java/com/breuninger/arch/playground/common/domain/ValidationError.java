package com.breuninger.arch.playground.common.domain;

import java.beans.ConstructorProperties;

// TODO make this error prettier use edison-validation domain object
public class ValidationError {

  private final String fieldName;
  private final String errorMessage;

  @ConstructorProperties({"fieldName", "errorMessage"})
  public ValidationError(final String fieldName, final String errorMessage) {
    this.fieldName = fieldName;
    this.errorMessage = errorMessage;
  }

  public String getFieldName() {
    return fieldName;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
