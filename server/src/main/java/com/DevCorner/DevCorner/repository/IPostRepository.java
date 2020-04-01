package com.DevCorner.DevCorner.repository;
import java.util.ArrayList;
import com.DevCorner.DevCorner.models.Post;

public interface IPostRepository {
    ArrayList<Post> GetAllPosts();
    void CreatePost(Post post);
}
