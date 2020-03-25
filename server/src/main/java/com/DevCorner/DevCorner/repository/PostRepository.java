package com.DevCorner.DevCorner.repository;

import com.DevCorner.DevCorner.models.Post;
import com.google.gson.Gson;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.ArrayList;

public class PostRepository implements IPostRepository {
    private MongoCollection getDBCollection(String collection)
    {
        String password = System.getenv("APPSETTING_MongoDBPassword");
        MongoClient mongoClient = MongoClients.create(
                "mongodb+srv://mmaniatis:" + password + "@blog-d3ual.mongodb.net/blog?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("Primary");
        MongoCollection coll = null;
        if (collection != null){
            try {
                coll = database.getCollection(collection);
            } catch (Exception e){

            }
        }
        return coll;
    }

    public ArrayList<Post> GetAllPosts()
    {
        ArrayList<Post> result = new ArrayList<Post>();
        FindIterable<Document> findIterable;
        MongoCollection coll = getDBCollection("Post");
        Gson g = new Gson();
        if (coll != null){
            findIterable = coll.find(new Document());
            for (Document doc : findIterable){
                Post p = g.fromJson(g.toJson(doc) , Post.class);
                result.add(p);
            }
        }
        return result;
    }
}