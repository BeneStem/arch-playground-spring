package com.breuninger.arch.playground.common.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class SanitizingUtil {

  // private static final PolicyFactory DISALLOW_ANYTHING_POLICY = new HtmlPolicyBuilder().toFactory();

  public static String sanitize(final String text) {
    // return StringUtils.trim(StringEscapeUtils.unescapeHtml4(DISALLOW_ANYTHING_POLICY
    // .sanitize(StringEscapeUtils.unescapeHtml4(text))))
    return text;
  }
}
