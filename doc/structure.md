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

Client:

+ `client` - automatically generated client.
+ `client-example` - example of clients usage.

Clean architecture, separated in modules. No implementation depends on the other implementation, only on interfaces.

## Verbs, no Nouns!

Services are **verbs**. I don't use anemic services.

Unfortunately, Java do not offer much syntax sugar, hence the `invoke()` method is called explicitly.

## Queue

I use awesome Postgres locking features to build a queue.

## API-First

API is designed first and the routes are generated.

## Client auto-generated

Client is auto-generated on build. This way it always stays up-to-date.
