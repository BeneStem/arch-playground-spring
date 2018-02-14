package com.breuninger.arch.playground.toggle.domain;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum Features implements Feature {

  /**
   * Usage in thymeleaf template:
   * th:if="${T(de.otto.social.feed.toggle.domain.Features).SHOW_PAGING_BUTTON.active}"
   * Usage in Tests:
   * FeatureManagerSupport.allDisabledFeatureConfig(Features.class);
   * FeatureManagerSupport.enable(SHOW_FEED_TEASER_IN_WISHLIST_PAGE);
   */

  @Label("TEST_TOGGLE") TEST_TOGGLE;

  public boolean isActive() {
    return FeatureContext.getFeatureManager().isActive(this);
  }
}
