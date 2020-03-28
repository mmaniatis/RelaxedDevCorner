package com.DevCorner.DevCorner.repository;
import java.util.ArrayList;
import com.DevCorner.DevCorner.models.Post;

public interface IPostRepository {
    public ArrayList<Post> GetAllPosts();
    public void CreatePost(Post post);
}
