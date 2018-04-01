# arch-playground 

> "How can I die, when I have so much of the Universe left to explore?" - Stephen Hawking

Have fun hacking.

## Roadmap

* include font into service-worker

## Setup

Install dependencies:

    $ yarn install

## Build

Build client:

    $ yarn build

Build server:

    $ gradle build

## Startup

Start server:

    $ java -jar build/libs/arch-playground.jar

Start client in dev mode: (:warning: not working yet!)

    $ yarn start

Start server in dev mode:

    $ gradle bootRun [--debug-jvm]

## Testing

### Test client

    $ yarn test

### Test server

    $ gradle test

### Test e2e

#### Test e2e on selenium grid

    $ yarn test:e2e
    
#### Test e2e locally

    $ yarn webdriver:install
    $ yarn webdriver:start
    $ yarn test:e2e:local

## Dependency Update

Client dependencies:

    $ yarn dependency-update

Server dependencies:

    $ gradle dependencyUpdates -Drevision=release
