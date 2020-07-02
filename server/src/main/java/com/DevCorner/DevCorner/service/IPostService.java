package com.DevCorner.DevCorner.service;
import com.DevCorner.DevCorner.models.Post;
import java.util.ArrayList;
import java.util.Set;

public interface IPostService {
    ArrayList<Post> GetAllPosts() ;
    void CreatePost(Post post);
    Post GetPost(String category, String slug);
    Set<String> getCategories();
    ArrayList<Post> getPostsByCategory(String category);
    boolean addComment(String body, String author, String slug, String category);
}
