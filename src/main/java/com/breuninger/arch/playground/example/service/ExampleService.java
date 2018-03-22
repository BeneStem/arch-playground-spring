package com.breuninger.arch.playground.example.service;

import java.util.Date;
import java.util.List;

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
    final var creationDate = new Date();
    return exampleRepository.create(new Example(example.getId(), example.getText(), creationDate, creationDate));
  }

  @Gauge(name = "example.count", absolute = true)
  public long count() {
    return exampleRepository.size();
  }
}
