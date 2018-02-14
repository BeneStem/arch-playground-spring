package com.breuninger.arch.playground.common.configuration;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.stream.Stream;

import javax.validation.ValidatorFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
public class ValidationConfiguration {

  @Bean
  public MethodValidationPostProcessor methodValidationPostProcessor(final ValidatorFactory validatorFactory) {
    final MethodValidationPostProcessor methodValidationPostProcessor = new MethodValidationPostProcessor();
    methodValidationPostProcessor.setValidatorFactory(validatorFactory);
    return methodValidationPostProcessor;
  }

  @Bean
  @Primary
  public Validator configurationPropertiesValidator(final ApplicationContext applicationContext) {
    final LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
    localValidatorFactoryBean.setApplicationContext(applicationContext);
    localValidatorFactoryBean.setParameterNameDiscoverer(new CustomParameterNameDiscoverer());
    localValidatorFactoryBean.afterPropertiesSet();
    return localValidatorFactoryBean;
  }

  static class CustomParameterNameDiscoverer implements ParameterNameDiscoverer {

    @Override
    public String[] getParameterNames(final Method method) {
      return Stream.of(method.getParameters())
        .map(Parameter::getName)
        .toArray(String[]::new);
    }

    @Override
    public String[] getParameterNames(final Constructor<?> constructor) {
      return Stream.of(constructor.getParameters())
        .map(Parameter::getName)
        .toArray(String[]::new);
    }
  }
}
