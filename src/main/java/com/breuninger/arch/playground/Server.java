package com.breuninger.arch.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.codahale.metrics.MetricRegistry;

import de.otto.edison.authentication.configuration.LdapConfiguration;
import de.otto.edison.health.configuration.HealthConfiguration;
import de.otto.edison.jobs.configuration.JobsConfiguration;
import de.otto.edison.jobs.controller.JobDefinitionsController;
import de.otto.edison.jobs.controller.JobsController;
import de.otto.edison.jobs.eventbus.EventBusConfiguration;
import de.otto.edison.jobs.service.JobDefinitionService;
import de.otto.edison.jobs.service.JobMessageLogAppender;
import de.otto.edison.jobs.service.JobMetaService;
import de.otto.edison.jobs.service.JobMutexGroups;
import de.otto.edison.jobs.service.JobService;
import de.otto.edison.jobs.service.UuidProvider;
import de.otto.edison.logging.LoggingConfiguration;
import de.otto.edison.logging.ui.LoggersConfiguration;
import de.otto.edison.logging.ui.LoggersHtmlEndpoint;
import de.otto.edison.metrics.configuration.GraphiteReporterConfiguration;
import de.otto.edison.metrics.http.HttpMetricsFilter;
import de.otto.edison.mongo.MongoStatusDetailIndicator;
import de.otto.edison.mongo.configuration.MongoConfiguration;
import de.otto.edison.mongo.configuration.MongoJobsConfiguration;
import de.otto.edison.mongo.configuration.MongoTogglzConfiguration;
import de.otto.edison.navigation.NavBarConfiguration;
import de.otto.edison.registry.client.AsyncHttpRegistryClient;
import de.otto.edison.registry.configuration.ServiceRegistryConfiguration;
import de.otto.edison.status.configuration.ApplicationInfoConfiguration;
import de.otto.edison.status.configuration.ApplicationStatusAggregatorConfiguration;
import de.otto.edison.status.configuration.ClusterInfoConfiguration;
import de.otto.edison.status.configuration.SystemInfoConfiguration;
import de.otto.edison.status.configuration.TeamInfoConfiguration;
import de.otto.edison.status.configuration.VersionInfoConfiguration;
import de.otto.edison.status.controller.GlobalModelAttributes;
import de.otto.edison.status.controller.InternalController;
import de.otto.edison.togglz.configuration.TogglzConfiguration;
import de.otto.edison.togglz.configuration.TogglzConsoleConfiguration;
import de.otto.edison.togglz.controller.FeatureTogglesController;
import de.otto.edison.vault.VaultPropertySourcePostProcessor;

@SpringBootApplication
@PropertySource("version.properties")
@Import({
          SystemInfoConfiguration.class,
          HealthConfiguration.class,
          TeamInfoConfiguration.class,
          ApplicationInfoConfiguration.class,
          VersionInfoConfiguration.class,
          ApplicationStatusAggregatorConfiguration.class,
          ClusterInfoConfiguration.class,
          LoggingConfiguration.class,
          LoggersConfiguration.class,
          GraphiteReporterConfiguration.class,
          ServiceRegistryConfiguration.class,
          NavBarConfiguration.class,
          LdapConfiguration.class,
          GlobalModelAttributes.class,
          InternalController.class,
          LoggersHtmlEndpoint.class,
          HttpMetricsFilter.class,
          MetricRegistry.class,
          AsyncHttpRegistryClient.class,
          EventBusConfiguration.class,
          JobMessageLogAppender.class,
          JobsConfiguration.class,
          JobDefinitionsController.class,
          JobsController.class,
          JobService.class,
          JobMetaService.class,
          JobDefinitionService.class,
          JobMutexGroups.class,
          UuidProvider.class,
          TogglzConfiguration.class,
          TogglzConsoleConfiguration.class,
          FeatureTogglesController.class,
          MongoConfiguration.class,
          MongoJobsConfiguration.class,
          MongoTogglzConfiguration.class,
          MongoStatusDetailIndicator.class,
          VaultPropertySourcePostProcessor.class
        })
public class Server {

  public static void main(final String... args) {
    SpringApplication.run(Server.class, args);
  }
}
