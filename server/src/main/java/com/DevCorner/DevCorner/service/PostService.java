package com.DevCorner.DevCorner.service;

import com.DevCorner.DevCorner.models.Post;
import com.DevCorner.DevCorner.repository.IPostRepository;
import com.DevCorner.DevCorner.repository.PostRepository;
import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.nio.channels.NotYetBoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@SpringBootApplication
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public ArrayList<Post> GetAllPosts() {
        ArrayList<Post> result = postRepository.GetAllPosts();
        sortPosts(result);
        return result;
    }

    public boolean CreatePost(Post post) {
        return postRepository.CreatePost(post);
    }

    public Post GetPost(String category, String slug) {
        Post result = null;
        if( (category != null && slug != null) && (!category.isEmpty() && !slug.isEmpty())) {
            result = postRepository.GetPost(category, slug);
        }
        return result;

    }

    public Set<String> getCategories() {
        return postRepository.getCategories();
    }

    public ArrayList<Post> getPostsByCategory(String category) {
        ArrayList<Post> result = new ArrayList<>();
        if(category != null && !category.equals("")) {
            result = postRepository.getPostsByCategory(category);
            sortPosts(result);
        }
        return result;
    }

    public boolean addComment(String body, String author, String slug, String category) {
        try {
            postRepository.addComment(body, author, slug, category);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    private void sortPosts(List<Post> arr) {
        if (arr != null && arr.size() > 0) {
            for(int i = 0; i < arr.size(); i ++)
            {
                for (int j =1; j < arr.size()-i; j ++)
                {
                    if (arr.get(j).cdDate.compareTo(arr.get(j-1).cdDate) >  0) {
                        Post temp = arr.get(j-1);
                        arr.set(j-1, arr.get(j));
                        arr.set(j, temp);
                    }
                }
            }
        }

    }
}
