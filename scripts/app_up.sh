## Runs the application in dockerized environment.
## Application is available at: http://localhost:8080

KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://kafka:29092,PLAINTEXT_HOST://kafka:9092 \
    docker-compose --profile app up -d
