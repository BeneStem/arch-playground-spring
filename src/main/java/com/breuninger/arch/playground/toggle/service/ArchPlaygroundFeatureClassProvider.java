package com.breuninger.arch.playground.toggle.service;

import org.springframework.stereotype.Component;

import com.breuninger.arch.playground.toggle.domain.Features;
import com.breuninger.boot.togglz.FeatureClassProvider;

@Component
public final class ArchPlaygroundFeatureClassProvider implements FeatureClassProvider {

  @Override
  public Class<Features> getFeatureClass() {
    return Features.class;
  }
}
