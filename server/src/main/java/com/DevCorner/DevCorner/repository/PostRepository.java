package com.DevCorner.DevCorner.repository;
import com.DevCorner.DevCorner.models.Post;
import com.google.gson.Gson;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;


import java.util.ArrayList;
import java.util.Date;


public class PostRepository implements IPostRepository {
    private MongoDatabase database;
    public PostRepository()
    {
        String password = System.getenv("APPSETTING_MongoDBPassword");
        MongoClient mongoClient = MongoClients.create(
                "mongodb+srv://mmaniatis:" + password + "@blog-d3ual.mongodb.net/blog?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("Primary");
        this.database = database;
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
            for (int j =0; j < result.size() - 1; j ++)
            {
                if (result.get(i).cdDate.compareTo(result.get(j + 1).cdDate) <  0) {
                    Post temp = result.get(i);
                    result.set(i, result.get(j+ 1));
                    result.set(j+ 1, temp);
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