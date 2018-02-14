package com.breuninger.arch.playground.common.service;

import static org.apache.http.client.config.CookieSpecs.STANDARD;
import static org.apache.http.client.config.RequestConfig.custom;

import java.time.Duration;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

  private static final int CONNECT_TIMEOUT = (int) Duration.ofSeconds(1).toMillis();
  private static final int READ_TIMEOUT = (int) Duration.ofSeconds(2).toMillis();

  @Bean
  public RestTemplate restTemplate() {
    final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient());
    requestFactory.setConnectTimeout(CONNECT_TIMEOUT);
    requestFactory.setReadTimeout(READ_TIMEOUT);
    return new RestTemplate(requestFactory);
  }

  private HttpClient httpClient() {
    final HttpClientBuilder clientBuilder = HttpClientBuilder.create();
    clientBuilder.useSystemProperties();
    clientBuilder.setDefaultRequestConfig(custom()
      .setCookieSpec(STANDARD)
      .build());
    return clientBuilder.build();
  }
}
