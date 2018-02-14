# arch-playground 

> "TODO" - Someone Nice

Make breuninger architecture great again.

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

Start client in dev mode:

    $ yarn start

Start server in dev mode:

    $ gradle bootRun [--debug-jvm]

## Testing

### Test client

    $ yarn test

### Test server

    $ gradle test

## Dependency Update

Client dependencies:

    $ yarn upgrade && yarn upgrade-interactive

Server dependencies:

    $ gradle dependencyUpdates -Drevision=release
