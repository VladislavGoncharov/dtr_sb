FROM openjdk:11

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
#ONLY FOR LINUX
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]