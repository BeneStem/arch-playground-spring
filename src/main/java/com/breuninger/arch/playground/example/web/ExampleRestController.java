package com.breuninger.arch.playground.example.web;

import static java.util.concurrent.TimeUnit.HOURS;

import static org.springframework.http.CacheControl.maxAge;
import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import static com.breuninger.arch.playground.common.domain.BadRequestException.badRequest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breuninger.arch.playground.example.domain.Example;
import com.breuninger.arch.playground.example.service.ExampleService;
import com.breuninger.arch.playground.toggle.domain.Features;
import com.codahale.metrics.annotation.Timed;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/examples")
public class ExampleRestController {

  private final Validator validator;
  private final ExampleService exampleService;

  @Timed
  @GetMapping(produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Example>> findAll() {
    if (!Features.TEST_TOGGLE.isActive()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok()
      .contentType(APPLICATION_JSON)
      .cacheControl(maxAge(1, HOURS).cachePublic())
      .varyBy(ACCEPT)
      .body(exampleService.findAll());
  }

  @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Example> create(@RequestBody final Example example, final Errors errors) {
    final var sanitizedExample = example.sanitize();
    validator.validate(sanitizedExample, errors);
    if (errors.hasErrors()) {
      throw badRequest(errors);
    }

    final var createdExample = exampleService.create(sanitizedExample);
    return ResponseEntity.ok().contentType(APPLICATION_JSON).body(createdExample);
  }
}
