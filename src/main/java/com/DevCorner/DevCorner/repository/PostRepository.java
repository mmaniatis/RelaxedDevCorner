package com.DevCorner.DevCorner.repository;
        import java.util.ArrayList;
        import java.util.List;
        import com.DevCorner.DevCorner.models.Post;
        import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String>
{
    public ArrayList<Post> findPostsByCategory(String category);
    public Post findPostById(String id);
}
