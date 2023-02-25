# Spring Framework Study Place

This repo has projects for studying the Spring Framework and modules around it.

## Maven Command

Clean and package the project:

`./mvnw clean package`

## Spring Boot

### Running with Java Command

Run Java Jar file:

``java -jar -Dspring.profiles.active=sandbox target/initial-boot-app-0.0.1-SNAPSHOT.jar``

### Running JAR file

- Fat JAR
- Executable
- init.d or systemd

Run the project using maven:

`./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=sandbox"`

### Autoconfiguration

- `@EnableAutoConfiguration`
  - Allows for configuration classes to be scanned dynamically
- Driven off of `spring.factories`
- Control order using `@AutoConfigurateBefore` and `@AutoConfigureAfter`

Example of autoconfigure classes:

- `org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration`
- `org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration`

### Conditional Loading

- `@Conditional`
- `@ConditionalOnClass`
- `@ConditionalOnBean`
- `@ConditionalOnProperty`
- `@ConditionalOnMissing<Class|Bean|Property>`

### Properties

- `@EnableConfigurationProperties` this annotation is used to enable @ConfigurationProperties annotated beans in the Spring application
  - Preconfigured "default" on `@EnableAutoConfiguration`
- `application.properties` or `application.yml` file
- Can use Environment variables to override Spring Properties
- `@Configuration` this marks the class as a source of Bean definitions
- `@ConfigurationProperties` this binds and validates the external configurations to a configuration class

### Configurations

- Property-based configuration
  - Basic configuration using `application.properties`
  - Environment variables
  - Command-line parameters
  - Cloud configurations
- Bean configuration
  - Using `@Configuration` to create a Bean class configuration
  - XML-based configuration (legacy)
  - Component scanning

### Profiles

- Flex configuration based on environment profile
- Dev, Prod, Test are examples of profiles
- Profile in the file using `spring.config.activate.on-profile`
- Profile splited in files
  - `application-dev.properties`
  - `application-prod.properties`
- `spring.profiles.active` to engaging a profile vi command line or environment

### Embedded servelet

- Spring Boot provide TomCat by default
- Create or change: Servlets, Filters, and Listeners https://www.baeldung.com/spring-servletcomponentscan
- Create additional `ServletContext` using `ServletContextInitializer` interface
- Customize using properties `org.springframework.boot.autoconfigure.web.ServerProperties`
- Customize compression `server.compression.enable=true`
- Support to SSL

Create a Key to SSL:

```shell
keytool -genseckey -keyalg RSA -alias linkedin -keystore keystore.jks -storepass password -keysize 2048
keytool -genseckey -keyalg AES -alias linkedin -keystore keystore.jks -storepass password -keysize 128
keytool -genseckey -keystore linkedin.pf12 -deststoretype pkcs12 -keyalg AES -keysize 256 -storepass password -keypass password -noprompt
```

### XML Marshall

Add this dependency to woth with XML responses:

```xml
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
```

This commando to get XML responses:

```shell
http http://localhost/api/rooms

http http://localhost/api/rooms Accept:application/xml

curl --location --request GET 'http://localhost:8080/api/rooms' \
--header 'Accept: application/xml'
```

### Devtools

Dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

Then go to: Intellij IDEA -> Settings -> Build, Execution, Deployment -> Compiler -> Turn on: Build project automatically

Finally, go to: Intellij IDEA -> Settings -> Advanced Settings -> Turn on: Allow auto-make srtart even if developed 
application is currently running

### Command Line Interface

- CommandLineRunner
- ApplicationRunner
- Single-run method
- `@Order` annotation

Dependency:

```xml
<depencencies>
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
  </dependency>
  <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
  </dependency>
  <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
  </dependency>
</depencencies>
```

Or up-to-date way:

```xml
<depencencies>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-boot-starter</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-json</artifactId>
  </dependency>
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
  </dependency>
</depencencies>
```

### Repository and Database

- Spring data
  - RDBMS and NoSQL database support
- Spring JDBC
- RepositoryRestResources

Dependency:

```xml
<depencencies>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
  </dependency>
  <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
      <scope>runtime</scope>
  </dependency>
  <dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
  </dependency>
</depencencies>
```

Properties:

```text
# memory
logging.level.org.springframework.jdbc.datasource.init.ScriptUtils=debug
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=none
# external
spring.jpa.hibernate.ddl-auto=none
spring.jpa.database=postgresql
spring.datasource.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/test
spring.datasource.username=postgres
spring.datasource.password=postgres
```

H2 console

- http://localhost:8080/h2-console

### Security

- Authentication and Authorization
- `WebConfigurerAdapter`
- @EnableWebSecurity
- @EnableOAuth2Client
- @EnableAuthorizationServer
- @EnableResourceServer
- Password hashed and not encrypted (SHA-1 in sandbox, BCrypt in production)

Dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

### Asynchronous Messaging

- Producer
- Consumer

Dependency:

```xml
<dependencies>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-amqp</artifactId>
  </dependency>
  <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
  </dependency>
</dependencies>
```

Or up-to-date way:

```xml
<depencencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-json</artifactId>
  </dependency>
</depencencies>
```

### Logging

- SLF4J
- Property-based modifications
- Logback logging

### Actuator

Dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Endpoints:

- http://localhost:8080/actuator
- http://localhost:8080/actuator/health
- http://localhost:8080/actuator/env (authenticated)

Interface to create custom endpoints: `Endpoint`

### Docker

- Build plugins
  - `spring-boot:build-image` for Maven
  - `bootBuildImage` fro Gradle
- Dockerfile example
```
FROM maven:3.8.5-openjdk-17-slim as BUILDER
ARG VERSION=0.0.1-SNAPSHOT
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src

RUN mvn clean package
COPY target/booting-web-${VERSION}.jar target/application.jar

FROM openjdk:17-jdk-slim-buster
WORKDIR /app/

COPY --from=BUILDER /build/target/application.jar /app/
CMD java -jar /app/application.jar
```
- Docker build command `docker build -t booting-web .`
- Docker run command `docker run -p 9090:9090 -d booting-web`


### Boot Starters Customized

- Common code
- Common configuration
- Improve ease of use

Based: https://www.baeldung.com/spring-boot-starters
