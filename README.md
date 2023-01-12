# Spring Framework study place

This repo has projects for studing the Spring Framework and modules around it.

Based: https://www.linkedin.com/learning/spring-boot-1-0-essential-training

## Maven commands

Clean and package the project:

`./mvnw clean package`

## Java commands

Run Java Jar file:

``java -jar -Dspring.profiles.active=sandbox target/initial-boot-app-0.0.1-SNAPSHOT.jar``

## Spring Boot

### Run Application

Run the project using:

``./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=sandbox"``

### Autoconfiguration

- `@EnableAutoConfiguration`
- Profiles
- `@Conditional`
- Control order using `@AutoConfigurateBefore` and `@AutoConfigureAfter`
- `spring.factories` file

Examples:

- `org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration`
- `org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration`

### Conditional Loading Annonation

- `@ConditionalOnClass`
- `@ConditionalOnBean`
- `@ConditionalOnProperty`
- `@ConditionalOnMissing<Class|Bean|Property>`

### Properties

- `application.properties` or `application.yml`
- Can use Environment variables to override Spring Properties
- `@Configuration` this marks the class as a source of bean definitions
- `@ConfigurationProperties` this binds and validates the external configurations to a configuration class
- `@EnableConfigurationProperties` this annotation is used to enable @ConfigurationProperties annotated beans in the Spring application
  - Preconfigured "default" on `@EnableAutoConfiguration`

### Embedded TomCat

- Spring Boot provide to you TomCat configured
- Create or change: Servlets, Filters, and Listeners https://www.baeldung.com/spring-servletcomponentscan
- Create aditional `ServletContext` using `ServletContextInitializer` interface
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

### Database

Dependency:

```xml
<depencencies>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
      <scope>runtime</scope>
  </dependency>
</depencencies>
```

### Security

Dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

### Asynchronous Messaging

- Producer `RoomClrAppApplication`
- Consumer `RoomCleanerConsumerApplication`

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

### Logging

- SLF4J

### Boot Starter

?

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
- http://localhost:8080/actuator/env

Interface to create custom endpoints: `Endpoint`
