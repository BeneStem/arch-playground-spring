'use strict';

const process = require('process');
const fs = require('fs');
const {SpecReporter} = require('jasmine-spec-reporter');

function encode(file) {
  const stream = fs.readFileSync(file);
  return Buffer.from(stream).toString('base64');
}

exports.config = {
  framework: 'jasmine',
  suites: {
    parallel: `${__dirname}/../../e2e/*.e2e.test.js`
  },
  suite: 'parallel',
  seleniumAddress: process.env.SELENIUM_HOST,
  maxInstances: 10,
  useBlockingProxy: false,
  capabilities: {
    browserName: 'chrome',
    chromeOptions: {
      extensions: [encode('./src/test/resources/e2e/ublock-origin.crx')],
      args: ['--window-size=375,667']
    },
    // dont shard when on local to be able to attach to process
    shardTestFiles: !!process.env.SELENIUM_HOST,
    maxInstances: 10
  },
  onPrepare() {
    jasmine.getEnv().addReporter(new SpecReporter({
      spec: {
        displayStacktrace: true
      }
    }));
  },
  jasmineNodeOpts: {
    print: () => {
      return null;
    },
    showColors: true,
    defaultTimeoutInterval: 30001,
    isVerbose: true,
    includeStackTrace: true
  },
  sync: true,
  logLevel: 'verbose',
  coloredLogs: true,
  baseUrl: process.env.BASE_DOMAIN,
  waitforTimeout: 20001,
  connectionRetryTimeout: 90000,
  connectionRetryCount: 3
};
