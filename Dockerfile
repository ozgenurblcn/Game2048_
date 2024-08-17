# Base image olarak OpenJDK kullanıyoruz
FROM openjdk:11

# Uygulama jar dosyasını ekleyip çalıştırıyoruz
COPY target/Game2048-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

