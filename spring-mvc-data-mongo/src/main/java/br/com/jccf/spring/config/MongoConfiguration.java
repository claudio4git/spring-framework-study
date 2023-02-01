package br.com.jccf.spring.config;

import com.mongodb.*;
import com.mongodb.client.*;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.repository.config.*;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.jccf.spring.repo")
public class MongoConfiguration {

    @Bean
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/spring-mvc-data-mongo");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(settings);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "spring-mvc-data-mongo");
    }
}
