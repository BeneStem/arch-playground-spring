package com.breuninger.arch.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.breuninger.boot.authentication.configuration.LdapConfiguration;
import com.breuninger.boot.configuration.ThymeleafConfiguration;
import com.breuninger.boot.health.configuration.HealthConfiguration;
import com.breuninger.boot.jobs.configuration.JobWatcher;
import com.breuninger.boot.jobs.configuration.JobsConfiguration;
import com.breuninger.boot.jobs.controller.JobDefinitionsController;
import com.breuninger.boot.jobs.controller.JobsController;
import com.breuninger.boot.jobs.eventbus.EventBusConfiguration;
import com.breuninger.boot.jobs.service.JobDefinitionService;
import com.breuninger.boot.jobs.service.JobMessageLogAppender;
import com.breuninger.boot.jobs.service.JobMetaService;
import com.breuninger.boot.jobs.service.JobMutexGroups;
import com.breuninger.boot.jobs.service.JobService;
import com.breuninger.boot.jobs.service.UuidProvider;
import com.breuninger.boot.logging.LoggingConfiguration;
import com.breuninger.boot.logging.ui.LoggersConfiguration;
import com.breuninger.boot.logging.ui.LoggersController;
import com.breuninger.boot.mongo.MongoStatusDetailIndicator;
import com.breuninger.boot.mongo.configuration.MongoConfiguration;
import com.breuninger.boot.mongo.configuration.MongoJobsConfiguration;
import com.breuninger.boot.mongo.configuration.MongoTogglzConfiguration;
import com.breuninger.boot.navigation.NavBarConfiguration;
import com.breuninger.boot.registry.client.AsyncHttpRegistryClient;
import com.breuninger.boot.registry.configuration.ServiceRegistryConfiguration;
import com.breuninger.boot.status.configuration.ApplicationInfoConfiguration;
import com.breuninger.boot.status.configuration.ApplicationStatusAggregatorConfiguration;
import com.breuninger.boot.status.configuration.ClusterInfoConfiguration;
import com.breuninger.boot.status.configuration.SystemInfoConfiguration;
import com.breuninger.boot.status.configuration.TeamInfoConfiguration;
import com.breuninger.boot.status.configuration.VersionInfoConfiguration;
import com.breuninger.boot.status.controller.ExternalDependencies;
import com.breuninger.boot.status.controller.GlobalModelAttributes;
import com.breuninger.boot.status.controller.InternalController;
import com.breuninger.boot.status.controller.StatusController;
import com.breuninger.boot.togglz.configuration.TogglzConfiguration;
import com.breuninger.boot.togglz.configuration.TogglzConsoleConfiguration;
import com.breuninger.boot.togglz.controller.FeatureTogglesController;

import de.otto.edison.vault.VaultPropertySourcePostProcessor;

@SpringBootApplication
@PropertySource("version.properties")
@Import({
          ApplicationInfoConfiguration.class,
          ApplicationStatusAggregatorConfiguration.class,
          AsyncHttpRegistryClient.class,
          ClusterInfoConfiguration.class,
          EventBusConfiguration.class,
          ExternalDependencies.class,
          FeatureTogglesController.class,
          GlobalModelAttributes.class,
          HealthConfiguration.class,
          InternalController.class,
          JobDefinitionsController.class,
          JobDefinitionService.class,
          JobMessageLogAppender.class,
          JobMetaService.class,
          JobMutexGroups.class,
          JobsConfiguration.class,
          JobsController.class,
          JobService.class,
          JobWatcher.class,
          LdapConfiguration.class,
          LoggersConfiguration.class,
          LoggersController.class,
          LoggingConfiguration.class,
          MongoConfiguration.class,
          MongoJobsConfiguration.class,
          MongoStatusDetailIndicator.class,
          MongoTogglzConfiguration.class,
          NavBarConfiguration.class,
          ServiceRegistryConfiguration.class,
          StatusController.class,
          StatusController.class,
          SystemInfoConfiguration.class,
          TeamInfoConfiguration.class,
          ThymeleafConfiguration.class,
          TogglzConfiguration.class,
          TogglzConsoleConfiguration.class,
          UuidProvider.class,
          VaultPropertySourcePostProcessor.class,
          VersionInfoConfiguration.class
        })
public class Server {

  public static void main(final String... args) {
    SpringApplication.run(Server.class, args);
  }
}
