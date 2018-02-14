package com.breuninger.arch.playground.example.service;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.breuninger.arch.playground.example.domain.Example;
import com.breuninger.arch.playground.example.domain.ExampleRepository;
import com.codahale.metrics.annotation.Gauge;

@Service
public class ExampleService {

  private final ExampleRepository exampleRepository;

  public ExampleService(final ExampleRepository exampleRepository) {
    this.exampleRepository = exampleRepository;
  }

  public List<Example> findAll() {
    return exampleRepository.findAll();
  }

  public Example create(final Example example) {
    final Date creationDate = new Date();
    return exampleRepository.create(example.toBuilder()
      .id(ObjectId.get().toString())
      .creationDate(creationDate)
      .lastModificationDate(creationDate)
      .build());
  }

  @Gauge(name = "example.count", absolute = true)
  public long count() {
    return exampleRepository.size();
  }
}
