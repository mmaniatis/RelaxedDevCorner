package com.DevCorner.DevCorner;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ApplicationProperties {

    private Properties properties;

    public ApplicationProperties() {
        // application.properties located at src/main/resource
        Resource resource = new ClassPathResource("/application.properties");
        try {
            this.properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException ex) {
            Logger.getLogger(ApplicationProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getProperty(String propertyName) {
        return this.properties.getProperty(propertyName);
    }

    public MongoDatabase getDataBase(String dbName)
    {
//        ApplicationProperties properties = new ApplicationProperties();
        MongoClient mongoClient = MongoClients.create(
                "mongodb+srv://mmaniatis:" + this.getProperty("app.MongoPassword") + "@blog-d3ual.mongodb.net/blog?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase(dbName);
        return database;
    }
}