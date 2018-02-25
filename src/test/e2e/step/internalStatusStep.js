'use strict';

const page = require('../pageObject/interalStatusPage');

class InternalStatusStep {
  static statusIsOk() {
    page.visit();
  }
}

module.exports = InternalStatusStep;
