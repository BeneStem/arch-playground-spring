package com.breuninger.arch.playground.common.job;

import java.text.MessageFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobProgressLogger {

  private static final Logger LOG = LoggerFactory.getLogger(JobProgressLogger.class);

  private final long loggingThresholdPerItems;
  private final Date jobStartDate;

  private long nrOfProcessedItems;

  public JobProgressLogger(final long loggingThresholdPerItems) {
    this.loggingThresholdPerItems = loggingThresholdPerItems;
    jobStartDate = new Date();
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
    final var jobRuntimeInSeconds = (System.currentTimeMillis() - jobStartDate.getTime()) / 1000 + 1;
    LOG.info(MessageFormat.format("Processed {0} items. Average Items per Second: {1}", nrOfProcessedItems,
      nrOfProcessedItems / jobRuntimeInSeconds));
  }

  public void info(final String message) {
    LOG.info(message);
  }

  public void warn(final String message) {
    LOG.warn(message);
  }

  public void error(final String message) {
    LOG.error(message);
  }
}
