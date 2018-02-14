package com.breuninger.arch.playground.example.domain;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
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
  private String id;

  @NotEmpty
  @Length(max = 5)
  private String text;

  private Date creationDate;
  private Date lastModificationDate;

  public Example sanitize() {
    return toBuilder().text(SanitizingUtil.sanitize(text)).build();
  }
}
