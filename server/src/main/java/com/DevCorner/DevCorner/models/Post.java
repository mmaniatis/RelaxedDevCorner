package com.DevCorner.DevCorner.models;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Post {
    public String category;
    public String title;
    public String slug;
    public String body;
    public String author;
    public Date cdDate;
    private ArrayList<Comment> comments;

    public Post(String category, String title, String slug, String body, String author, Date cdDate)
    {
        this.category = category;
        this.title = title;
        this.slug = slug;
        this.body = body;
        this.author = author;
        this.cdDate = cdDate;
        this.comments = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            if(
                    this.category.equals(((Post)obj).category) &&
                    this.slug.equals(((Post)obj).slug) &&
                    this.author.equals(((Post)obj).author)
            ) {
                return true;
            }
            else {
                return false;
            }
        } else {
            return false;
        }
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(String body, String author){
        Comment comment = new Comment(body, author);
        if(this.getComments() == null) {
            this.comments = new ArrayList<>() ;
        }
        this.comments.add(comment);
    }
}
