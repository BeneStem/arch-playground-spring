'use strict';

const status = require('./step/internalStatusStep');

function logBrowserLogToProtractorLog(browserLog) {
  console.log('################# BEGIN BrowserLog #################');
  browserLog.forEach((browserLogEntry) => {
    console.log(browserLogEntry.message);
  });
  console.log('################# END BrowserLog #################');
}

describe('internal sites', () => {
  beforeAll(() => {
    browser.ignoreSynchronization = true;
  });

  it('status is ok', () => {
    status.statusIsOk();
  });

  afterEach(() => {
    browser.manage().logs()
      .get('browser')
      .then(logBrowserLogToProtractorLog);
  });
});
