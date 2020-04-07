package com.DevCorner.DevCorner.repository;

import com.DevCorner.DevCorner.models.Account;
import com.DevCorner.DevCorner.models.Post;
import com.google.gson.Gson;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class AccountRepository implements IAccountRepository {

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
//                if  (coll == null)
//                {
//                    database.createCollection(collection);
//                }
            } catch (Exception e)
            {
                throw e;
            }
        }
        return coll;
    }
    public String CreateAccountIfNotExists(Account account) throws Exception {
        MongoCollection<Document> accountCollection = getDBCollection("Accounts");
        FindIterable<Document> findIterable;
        if (accountCollection != null){

            findIterable = accountCollection.find(new Document());

            for (Document doc : findIterable) { //At some point I need to refactor this into a binary search or something ..
                String currEmail = doc.get("email").toString();
                if ( currEmail.equals(account.email))
                {
                    return new Gson().toJson(doc);
                }
            }

            Document toInsert = new Document()
                    .append("id", new ObjectId())
                    .append("email", account.email)
                    .append("name", account.name)
                    .append("locale", account.locale)
                    .append("familyName", account.familyName)
                    .append("givenName", account.givenName)
                    .append("isAdmin", account.isAdmin);
            accountCollection.insertOne(toInsert);
            return new Gson().toJson(account);
        }
        else
            throw new Exception("Account look up / creation failed.");
    }
}