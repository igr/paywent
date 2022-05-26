## Package all artifacts!

./mvnw clean
./mvnw package -Dmaven.test.skip

rm -f ./pwt-boot/target/*-sources.jar
docker-compose --profile app build
