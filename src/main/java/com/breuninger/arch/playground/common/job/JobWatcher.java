package com.breuninger.arch.playground.common.job;

import java.time.Duration;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.IntervalTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import com.breuninger.boot.jobs.service.JobDefinitionService;
import com.breuninger.boot.jobs.service.JobService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Component
@Profile("!test")
public final class JobWatcher implements SchedulingConfigurer {

  private final JobDefinitionService jobDefinitionService;
  private final JobService jobService;

  @Override
  public void configureTasks(final ScheduledTaskRegistrar taskRegistrar) {
    jobDefinitionService.getJobDefinitions().forEach(def -> {
      def.cron().ifPresent(cron -> registerCronJob(def.jobType(), cron, taskRegistrar));
      def.fixedDelay().ifPresent(fixedDelay -> registerFixedDelay(def.jobType(), fixedDelay, taskRegistrar));
    });
  }

  private void registerCronJob(final String jobType, final String cron, final ScheduledTaskRegistrar taskRegistrar) {
    LOG.info("register job {} for cron scheduling: {}", jobType, cron);
    taskRegistrar.addCronTask(() -> jobService.startAsyncJob(jobType), cron);
  }

  private void registerFixedDelay(final String jobType, final Duration fixedDelay, final ScheduledTaskRegistrar taskRegistrar) {
    LOG.info("register job {} for scheduling with fixed delay: {}", jobType, fixedDelay);
    taskRegistrar.addFixedDelayTask(
      new IntervalTask(() -> jobService.startAsyncJob(jobType), fixedDelay.toMillis(), fixedDelay.toMillis()));
  }
}
