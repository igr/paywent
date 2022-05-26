# Architecture

## API

Microservice exposes its REST API to the users.

## DB

Each microservice has its own database.

## EventBus

Event Bus is used for s2s communication.

## Event Message Queue

Here, we don't send messages immediately on EventBus. Instead, they are stored in the queue and processed.

This should be generalized for _both_ outgoing and incoming messages.  

## Scaling

First, determine _what_ to scale and _why_; i.e. measure the system. Define the performance boundaries.

What we can scale:

+ Decrease waiting times (default `1000ms`).
+ Increase queue batch size (default `1`) - carefully. Actually, it is a _bulk_ size.
+ Increase the number of app pods (i.e. scale up).
+ Use e.g. Redis to buffer incoming requests.
+ Use non-blocking I/O.
