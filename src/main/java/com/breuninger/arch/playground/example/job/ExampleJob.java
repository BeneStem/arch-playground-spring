package com.breuninger.arch.playground.example.job;

import static de.otto.edison.jobs.definition.DefaultJobDefinition.cronJobDefinition;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import de.otto.edison.jobs.definition.JobDefinition;
import de.otto.edison.jobs.service.JobRunnable;

@Component
public class ExampleJob implements JobRunnable {

  private static final Logger LOG = LoggerFactory.getLogger(ExampleJob.class);

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
