# On Project Structure

## Modules

App is split in modules:

+ `domain` - domain models and mappers.
+ `app-impl` - apps business logic, transaction boundaries.
+ `app` - app interfaces.
+ `repo-api-jpa` - JPA implementation of the repo.
+ `repo-api` - repo interfaces.
+ `eventbus-kafka` - kafka implementation of the message bus.
+ `eventbus` - eventbus interfaces.
+ `web-api` - web-api layer. API-first approach.
+ `boot` - configuration and boostrap of the web app.

Specification:

+ `*-spec` - very light take on specification definition.

Client:

+ `client` - automatically generated client.
+ `client-example` - example of clients usage.

Clean architecture. Dependencies:

+ Interface module depends only on other interfaces.
+ Implementation module depends only on other interfaces.
+ Boot module provides implementation.

![](arh.png)

## Verbs, no Nouns!

Services are **verbs**. I don't use anemic services.

Java do not offer much syntax sugar, hence the `invoke()` method is called explicitly.

## Queue

I use awesome Postgres locking features to build a queue.

## API-First

API is designed first and the routes are generated.

## OpenAPI

Microservices exposes its OpenAPI.

## Client auto-generated

Client is auto-generated on build. This way it always stays up-to-date.
