package com.breuninger.arch.playground.common.job;

import java.text.MessageFormat;
import java.util.Date;

import de.otto.edison.jobs.eventbus.JobEventPublisher;

public class JobProgressLogger {

  private final JobEventPublisher jobEventPublisher;
  private final long loggingThresholdPerItems;
  private final Date JobStartDate;

  private long nrOfProcessedItems;

  public JobProgressLogger(final JobEventPublisher jobEventPublisher, final long loggingThresholdPerItems) {
    this.jobEventPublisher = jobEventPublisher;
    this.loggingThresholdPerItems = loggingThresholdPerItems;
    JobStartDate = new Date();
  }

  public void itemProcessed() {
    nrOfProcessedItems++;
    if (nrOfProcessedItems % loggingThresholdPerItems == 0) {
      printStatistics();
    }
  }

  public void printFinalStatistics() {
    printStatistics();
  }

  private void printStatistics() {
    final long jobRuntimeInSeconds = (System.currentTimeMillis() - JobStartDate.getTime()) / 1000 + 1;
    jobEventPublisher.info(MessageFormat.format("Processed {0} items. Average Items per Second: {1}", nrOfProcessedItems,
      nrOfProcessedItems / jobRuntimeInSeconds));
  }

  public void info(final String message) {
    jobEventPublisher.info(message);
  }

  public void warn(final String message) {
    jobEventPublisher.warn(message);
  }

  public void error(final String message) {
    jobEventPublisher.error(message);
  }
}
