package com.breuninger.arch.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("version.properties")
@ComponentScan(basePackages = {"de.otto.edison", "com.breuninger.arch.playground"})
public class Server {

  public static void main(final String... args) {
    SpringApplication.run(Server.class, args);
  }
}
