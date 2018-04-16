package com.breuninger.arch.playground.toggle.service;

import org.springframework.stereotype.Component;
import org.togglz.core.Feature;

import com.breuninger.arch.playground.toggle.domain.Features;
import com.breuninger.boot.togglz.FeatureClassProvider;

@Component
public final class ArchPlaygroundFeatureClassProvider implements FeatureClassProvider {

  @Override
  public Class<? extends Feature> getFeatureClass() {
    return Features.class;
  }
}
