'use strict';

const url = '/arch-playground-spring/internal/status';

class InternalStatusPage {
  static visit() {
    browser.get(url);
  }
}

module.exports = InternalStatusPage;
