package com.kaykamaral.workshopmongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {

    @Bean
    public MongoDatabaseFactory mongoDbFactory() {
        // This will force the connection with MongoDB
        return new SimpleMongoClientDatabaseFactory("mongodb://localhost:27017/workshop_mongo");
    }
}