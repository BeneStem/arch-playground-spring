package com.breuninger.arch.playground.example.domain;

import java.beans.ConstructorProperties;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.jongo.marshall.jackson.oid.MongoId;

import com.breuninger.arch.playground.common.util.SanitizingUtil;

public class Example {

  @MongoId
  private final String id;

  private final @NotEmpty @Length(max = 5) String text;

  private final Date creationDate;
  private final Date lastModificationDate;

  @ConstructorProperties({"id", "text", "creationDate", "lastModificationDate"})
  public Example(final String id, final @NotEmpty @Length(max = 5) String text, final Date creationDate,
                 final Date lastModificationDate) {
    this.id = id;
    this.text = text;
    this.creationDate = creationDate;
    this.lastModificationDate = lastModificationDate;
  }

  public Example sanitize() {
    return new Example(id, SanitizingUtil.sanitize(text), creationDate, lastModificationDate);
  }

  public String getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public Date getLastModificationDate() {
    return lastModificationDate;
  }
}
