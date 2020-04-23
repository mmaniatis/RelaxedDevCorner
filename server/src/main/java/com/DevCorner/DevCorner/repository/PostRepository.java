package com.DevCorner.DevCorner.repository;
import com.DevCorner.DevCorner.ApplicationProperties;
import com.DevCorner.DevCorner.models.Post;
import com.google.gson.Gson;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

@SpringBootApplication
@RestController
public class PostRepository implements IPostRepository {
    private MongoDatabase database;
    public PostRepository()
    {
        this.database = new ApplicationProperties().getDataBase("Primary");
    }

    private MongoCollection<Document> getDBCollection(String collection)
    {
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

    public ArrayList<Post> GetAllPosts()
    {
        ArrayList<Post> result = new ArrayList<>();
        FindIterable<Document> findIterable;
        MongoCollection<Document> coll = getDBCollection("Post");
        Gson g = new Gson();
        if (coll != null){

            findIterable = coll.find(new Document());

            for (Document doc : findIterable){
                Post p = g.fromJson(g.toJson(doc) , Post.class);
                result.add(p);
            }
        }

        //Not the most efficient sorting algorithm, but it'l do for now.
        for(int i = 0; i < result.size(); i ++)
        {
            for (int j =1; j < result.size()-i; j ++)
            {
                if (result.get(j).cdDate.compareTo(result.get(j-1).cdDate) >  0) {
                    Post temp = result.get(j-1);
                    result.set(j-1, result.get(j));
                    result.set(j, temp);
                }
            }
        }

        return result;
    }

    public void CreatePost(Post post)
    {
        try{
            Document toInsert = new Document("id", new ObjectId())
                                    .append("category", post.category)
                                    .append("title", post.title)
                                    .append("slug", post.slug)
                                    .append("body", post.body)
                                    .append("author", post.author)
                                    .append("cdDate", post.cdDate);
            MongoCollection<Document> collection = getDBCollection("Post");
            collection.insertOne(toInsert);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public Post GetPost(String category, String slug)
    {
        Post result = null;
        FindIterable<Document> findIterable;
        findIterable = getDBCollection("Post").find(new Document());
        for (Document doc : findIterable) { //At some point I need to refactor this into a binary search or something ..
            String currslug = doc.get("slug").toString();
            String currCategory = doc.get("category").toString();
            Gson g = new Gson();
            if (slug.equals(currslug) && category.equals(currCategory))
                return g.fromJson(g.toJson(doc) , Post.class);
        }

        return result;
    }
}