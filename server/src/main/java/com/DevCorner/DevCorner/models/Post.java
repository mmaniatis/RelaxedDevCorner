package com.DevCorner.DevCorner.models;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    public ObjectId id;
    public String category;
    public String title;
    public String slug;
    public String body;
    public String author;
    public Date cdDate;

    private static ArrayList<Comment> comments;

    public Post(String category, String title, String slug, String body, String author, Date cdDate)
    {
        this.id = new ObjectId();
        this.category = category;
        this.title = title;
        this.slug = slug;
        this.body = body;
        this.author = author;
        this.cdDate = cdDate;

        comments = new ArrayList<>();
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }
}
