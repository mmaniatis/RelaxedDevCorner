package com.DevCorner.DevCorner.repository;
import com.DevCorner.DevCorner.ApplicationProperties;
import com.DevCorner.DevCorner.models.*;
import com.google.gson.Gson;
import com.mongodb.DBCollection;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import static com.mongodb.client.model.Filters.eq;


@SpringBootApplication
@RestController
@Component
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
        return result;
    }

    public boolean CreatePost(Post post)
    {
        try{
            Document toInsert = new Document("id", new ObjectId())
                                    .append("category", post.category)
                                    .append("title", post.title)
                                    .append("slug", post.slug)
                                    .append("body", post.body)
                                    .append("author", post.author)
                                    .append("cdDate", post.cdDate)
                                    .append("comments", post.getComments());
            MongoCollection<Document> collection = getDBCollection("Post");
            collection.insertOne(toInsert);
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return false;
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

    public Set<String> getCategories()  {
        Set<String> result = new HashSet<>();
        FindIterable<Document> findIterable;
        MongoCollection<Document> coll = getDBCollection("Post");
        Gson g = new Gson();
        if (coll != null){

            findIterable = coll.find(new Document());

            for (Document doc : findIterable){
                Post p = g.fromJson(g.toJson(doc) , Post.class);
                result.add(p.category);
            }
        }
        return result;
    }

    public ArrayList<Post> getPostsByCategory(String category){
        ArrayList<Post> result = new ArrayList<>();
        FindIterable<Document> findIterable;
        MongoCollection<Document> coll = getDBCollection("Post");
        Gson g = new Gson();
        if (coll != null){

            findIterable = coll.find(new Document());

            for (Document doc : findIterable){
                Post p = g.fromJson(g.toJson(doc) , Post.class);
                if(p.category.equalsIgnoreCase(category)){
                    result.add(p);
                }
            }
        }

//        sortPosts(result);

        return result;
    }

    public synchronized void addComment(String body, String author, String slug, String category){
        if (!body.equals("")) {
            try {
                MongoCollection<Document> coll = getDBCollection("Post");
                Gson g = new Gson();
                Post post = this.GetPost(category, slug);
                Document toUpdate = Document.parse(g.toJson(post));
                post.addComment(body, author);
                Document updated = Document.parse(g.toJson(post));
                coll.replaceOne(toUpdate, updated);
            }
            catch (Exception ex){
                throw ex;
            }

        }

    }


}