package com.breuninger.arch.playground.example.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.breuninger.arch.playground.example.domain.Example;
import com.breuninger.arch.playground.example.domain.ExampleRepository;

import io.micrometer.core.instrument.MeterRegistry;

@Service
public class ExampleService {

  private final ExampleRepository exampleRepository;
  private final LongAdder exampleCount;

  public ExampleService(final ExampleRepository exampleRepository, final MeterRegistry meterRegistry) {
    this.exampleRepository = exampleRepository;
    exampleCount = new LongAdder();
    exampleCount.add(count());
    meterRegistry.gauge("example.count", exampleCount);
  }

  public List<Example> findAll() {
    return exampleRepository.findAll();
  }

  public Example create(final Example example) {
    final var creationDate = new Date();
    final var createdExample = exampleRepository.create(example.toBuilder()
      .id(ObjectId.get().toString())
      .creationDate(creationDate)
      .lastModificationDate(creationDate)
      .build());
    exampleCount.increment();
    return createdExample;
  }

  private long count() {
    return exampleRepository.size();
  }
}
