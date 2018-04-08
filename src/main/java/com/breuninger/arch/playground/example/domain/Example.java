package com.breuninger.arch.playground.example.domain;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.jongo.marshall.jackson.oid.MongoId;

import com.breuninger.arch.playground.common.util.SanitizingUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@AllArgsConstructor
@Value
public class Example {

  @MongoId
  private final String id;

  private final @NotEmpty @Length(max = 5) String text;

  private final Date creationDate;
  private final Date lastModificationDate;

  public Example sanitize() {
    return toBuilder().text(SanitizingUtil.sanitize(text)).build();
  }
}
