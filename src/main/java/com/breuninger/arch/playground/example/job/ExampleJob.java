package com.breuninger.arch.playground.example.job;

import static de.otto.edison.jobs.definition.DefaultJobDefinition.cronJobDefinition;

import java.util.Optional;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import de.otto.edison.jobs.definition.JobDefinition;
import de.otto.edison.jobs.service.JobRunnable;

@Slf4j
@Component
public class ExampleJob implements JobRunnable {

  private static final String JOB_TYPE = "ExampleJob";

  @Override
  public JobDefinition getJobDefinition() {
    return cronJobDefinition(
      JOB_TYPE,
      JOB_TYPE,
      "just an example job.",
      "0 0/2 * ? * *",
      0,
      Optional.empty());
  }

  @Override
  public boolean execute() {
    LOG.info("DING");
    return true;
  }
}
