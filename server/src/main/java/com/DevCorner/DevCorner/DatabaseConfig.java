package com.DevCorner.DevCorner;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.*;

@Configuration
public class DatabaseConfig {
    @Autowired
    ApplicationProperties applicationProperties;

    private MongoClient getClient()
    {
        return MongoClients.create(
                "mongodb+srv://mmaniatis:" + applicationProperties.getProperty("app.MongoPassword") + "@blog-d3ual.mongodb.net/blog?retryWrites=true&w=majority");
    }

    private MongoDatabase getPrimaryDatabase() {
        return this.getClient()
                .getDatabase("Primary");
    }

    public MongoCollection<Document> getPostCollection() {
        return this.getPrimaryDatabase()
                .getCollection("Post");
    }
}
