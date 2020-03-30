package com.DevCorner.DevCorner.models;

public class Post {

    public String category;
    public String title;
    public String slug;
    public String body;
    public String author;
    public String cdDate;

    public Post(String category, String title, String slug, String body, String author, String cdDate)
    {
        this.category = category;
        this.title = title;
        this.slug = slug;
        this.body = body;
        this.author = author;
        this.cdDate = cdDate;
    }
}
