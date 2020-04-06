package com.DevCorner.DevCorner.repository;

import com.DevCorner.DevCorner.models.Account;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class AccountRepository implements IAccountRepository{
    private MongoCollection<Document> getDBCollection(String collection)
    {
        String password = System.getenv("APPSETTING_MongoDBPassword");
        MongoClient mongoClient = MongoClients.create(
                "mongodb+srv://mmaniatis:" + password + "@blog-d3ual.mongodb.net/blog?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("Primary");
        MongoCollection<Document> coll = null;
        if (collection != null){
            try
            {
                coll = database.getCollection(collection);
            } catch (Exception e)
            {
                throw e;
            }
        }
        return coll;
    }
    public boolean CreateAccountIfNotExists(Account account)
    {
        return true;
    }

}
