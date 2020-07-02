package com.DevCorner.DevCorner.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Comment {
    private String body;
    private String author;
    private ArrayList<Comment> replies;

    public Comment(){

    }
    public Comment(String body, String author) {
        this.body = body;
        this.author = author;
        this.replies = new ArrayList<>();
    }

    public String getBody(){
        return body;
    }
    public String getauthor(){
        return author;
    }
    public ArrayList<Comment> getreplies(){
        return replies;
    }
}
