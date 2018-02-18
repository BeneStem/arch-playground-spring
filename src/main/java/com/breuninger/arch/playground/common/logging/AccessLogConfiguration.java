package com.breuninger.arch.playground.common.logging;

import org.eclipse.jetty.server.AbstractNCSARequestLog;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// TODO Replace with application properties when spring boot 2 is released
public class AccessLogConfiguration {

  static final Logger ACCESSLOG = LoggerFactory.getLogger("com.breuninger.arch.playground.accesslog");

  @Bean
  public EmbeddedServletContainerFactory jettyConfigBean() {
    final JettyEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory = new JettyEmbeddedServletContainerFactory();
    jettyEmbeddedServletContainerFactory.addServerCustomizers((JettyServerCustomizer) server -> {
      final HandlerCollection handlers = new HandlerCollection();
      for (final Handler handler : server.getHandlers()) {
        handlers.addHandler(handler);
      }
      final RequestLogHandler logHandler = new RequestLogHandler();
      final AbstractNCSARequestLog logger = new NcsaLogger();
      logger.setLogLatency(true);
      logger.setExtended(true);
      logHandler.setRequestLog(logger);
      handlers.addHandler(logHandler);
      server.setHandler(handlers);
    });
    return jettyEmbeddedServletContainerFactory;
  }

  private static final class NcsaLogger extends AbstractNCSARequestLog {

    @Override
    protected boolean isEnabled() {
      return true;
    }

    @Override
    public void write(final String requestEntry) {
      ACCESSLOG.info(requestEntry);
    }
  }
}
