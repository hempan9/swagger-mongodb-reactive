package com.hmp.reactive.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Configuration
public class ReactiveMongoConfig {
    @Value("${mongo.database.uri}")
    private String mongoUri;
    @Value("${mongo.database.name}")
    private String mongoDatabsename;
    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(mongoClient(), mongoDatabsename);
    }
    @Bean
    public MongoClient mongoClient(){
       return MongoClients.create(mongoUri);
    }
}