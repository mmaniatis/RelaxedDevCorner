package com.DevCorner.DevCorner.repository;
import com.DevCorner.DevCorner.DatabaseConfig;
import com.DevCorner.DevCorner.models.*;
import com.google.gson.Gson;
import com.mongodb.Cursor;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private DatabaseConfig databaseConfig;

    public ArrayList<Post> GetAllPosts() {
        ArrayList<Post> result = new ArrayList<>();
        FindIterable<Document> findIterable;
        MongoCollection<Document> collection = databaseConfig.getPostCollection();
        Gson g = new Gson();
        if (collection != null){
            findIterable = collection.find(new Document());
            if(findIterable != null){
                MongoCursor cursor = findIterable.iterator();
                while(cursor.hasNext()){
                    Post p = g.fromJson(g.toJson(cursor.next()) , Post.class);
                    result.add(p);
                }
            }

        }
        return result;
    }

    public boolean CreatePost(Post post) {
        try{
            if(post != null){
                Document toInsert = new Document("id", new ObjectId())
                        .append("category", post.category)
                        .append("title", post.title)
                        .append("slug", post.slug)
                        .append("body", post.body)
                        .append("author", post.author)
                        .append("cdDate", post.cdDate)
                        .append("comments", post.getComments());
                MongoCollection<Document> collection = databaseConfig.getPostCollection();
                collection.insertOne(toInsert);
                return true;
            } else {
                return false;
            }

        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return false;
        }
    }

    public Post GetPost(String category, String slug) {
        Post result = null;
        FindIterable<Document> findIterable;
        findIterable = databaseConfig.getPostCollection().find(new Document());
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
        MongoCollection<Document> collection = databaseConfig.getPostCollection();
        Gson g = new Gson();
        if (collection != null){
            findIterable = collection.find(new Document());
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
        MongoCollection<Document> collection = databaseConfig.getPostCollection();
        Gson g = new Gson();
        if (collection != null){
            findIterable = collection.find(new Document());
            for (Document doc : findIterable){
                Post p = g.fromJson(g.toJson(doc) , Post.class);
                if(p.category.equalsIgnoreCase(category)){
                    result.add(p);
                }
            }
        }
        return result;
    }

    public synchronized void addComment(String body, String author, String slug, String category){
        if (!body.equals("")) {
            try {
                MongoCollection<Document> collection = databaseConfig.getPostCollection();
                Gson g = new Gson();
                Post post = this.GetPost(category, slug);
                Document toUpdate = Document.parse(g.toJson(post));
                post.addComment(body, author);
                Document updated = Document.parse(g.toJson(post));
                collection.replaceOne(toUpdate, updated);
            }
            catch (Exception ex){
                throw ex;
            }

        }

    }


}