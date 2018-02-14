package com.breuninger.arch.playground.toggle.domain;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum Features implements Feature {

  /**
   * Usage in thymeleaf template:
   * th:if="${T(com.breuninger.arch.playground.toggle.domain.Features).TEST_TOGGLE.active}"
   * Usage in Tests:
   * FeatureManagerSupport.allDisabledFeatureConfig(Features.class);
   * FeatureManagerSupport.enable(TEST_TOGGLE);
   */

  @Label("TEST_TOGGLE") TEST_TOGGLE;

  public boolean isActive() {
    return FeatureContext.getFeatureManager().isActive(this);
  }
}
