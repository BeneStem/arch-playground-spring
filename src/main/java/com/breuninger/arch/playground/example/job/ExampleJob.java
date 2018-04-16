package com.breuninger.arch.playground.example.job;

import static com.breuninger.boot.jobs.definition.DefaultJobDefinition.cronJobDefinition;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.breuninger.boot.jobs.definition.JobDefinition;
import com.breuninger.boot.jobs.service.JobRunnable;

import lombok.extern.slf4j.Slf4j;

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
