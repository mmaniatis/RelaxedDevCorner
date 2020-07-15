package com.DevCorner.DevCorner.service;

import com.DevCorner.DevCorner.models.Post;
import com.DevCorner.DevCorner.repository.PostRepository;
import com.DevCorner.DevCorner.repository.PostRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@SpringBootApplication
public class PostService {

    @Autowired
    private PostRepository postRepositoryImpl;

    public ArrayList<Post> GetAllPosts() {
        ArrayList<Post> result = postRepositoryImpl.GetAllPosts();
        sortPosts(result);
        return result;
    }

    public boolean CreatePost(Post post) {
        return postRepositoryImpl.CreatePost(post);
    }

    public Post GetPost(String category, String slug) {
        Post result = null;
        if( (category != null && slug != null) && (!category.isEmpty() && !slug.isEmpty())) {
            result = postRepositoryImpl.GetPost(category, slug);
        }
        return result;

    }

    public Set<String> getCategories() {
        return postRepositoryImpl.getCategories();
    }

    public ArrayList<Post> getPostsByCategory(String category) {
        ArrayList<Post> result = new ArrayList<>();
        if(category != null && !category.equals("")) {
            result = postRepositoryImpl.getPostsByCategory(category);
            sortPosts(result);
        }
        return result;
    }

    public boolean addComment(String body, String author, String slug, String category) {
        try {
            postRepositoryImpl.addComment(body, author, slug, category);
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
