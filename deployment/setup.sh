cd ..
./gradlew wrapper
./gradlew bootJar
cp -R carpark-api/build/libs/*.jar deployment